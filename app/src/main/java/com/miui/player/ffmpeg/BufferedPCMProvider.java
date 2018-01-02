package com.miui.player.ffmpeg;

import android.util.Log;
import com.miui.player.util.Utils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public class BufferedPCMProvider implements PCMProvider {
    static final String TAG = BufferedPCMProvider.class.getCanonicalName();
    private final PCMProvider mActualProvider;
    private final Buffer mBuffer;
    private final int mChannels;
    private volatile boolean mClosed;
    private final int mDuration;
    private final ExecutorService mExecutorService;
    private final Object mLock = new Object();
    private final int mMinSampleBufferSize;
    private boolean mReadEOF;
    private final int mSampleRate;
    private volatile boolean mSeeking;

    private static class Buffer {
        private final byte[] mBuffer;
        private int mHead = 0;
        private int mTail = 0;

        public Buffer(int unitSize, int count) {
            this.mBuffer = new byte[((count + 1) * unitSize)];
        }

        public void write(byte[] buf, int offset, int len) {
            int direct = this.mBuffer.length - this.mTail;
            if (len <= direct) {
                System.arraycopy(buf, offset, this.mBuffer, this.mTail, len);
                this.mTail += len;
                return;
            }
            int remain = len - direct;
            System.arraycopy(buf, offset, this.mBuffer, this.mTail, direct);
            System.arraycopy(buf, offset + direct, this.mBuffer, 0, remain);
            this.mTail = remain;
        }

        public int read(byte[] buf, boolean full) {
            int actual = (full || buf.length < size()) ? buf.length : size();
            int direct = this.mBuffer.length - this.mHead;
            if (actual <= direct) {
                System.arraycopy(this.mBuffer, this.mHead, buf, 0, actual);
                this.mHead += actual;
            } else {
                int remain = actual - direct;
                System.arraycopy(this.mBuffer, this.mHead, buf, 0, direct);
                System.arraycopy(this.mBuffer, 0, buf, direct, remain);
                this.mHead = remain;
            }
            return actual;
        }

        public void reset() {
            this.mHead = 0;
            this.mTail = 0;
        }

        public int size() {
            int dist = this.mTail - this.mHead;
            return dist >= 0 ? dist : dist + this.mBuffer.length;
        }

        public boolean canRead(int len) {
            return size() > len;
        }

        public boolean canWrite(int len) {
            return size() + len < this.mBuffer.length;
        }
    }

    private static class WorkRunnable implements Runnable {
        private final WeakReference<BufferedPCMProvider> mProviderRef;

        public WorkRunnable(BufferedPCMProvider provider) {
            this.mProviderRef = new WeakReference(provider);
        }

        public void run() {
            Utils.debugLog(BufferedPCMProvider.TAG, "Work thread start");
            BufferedPCMProvider provider = (BufferedPCMProvider) this.mProviderRef.get();
            if (provider != null) {
                try {
                    provider.workAsync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Utils.debugLog(BufferedPCMProvider.TAG, "Work thread finish");
        }
    }

    BufferedPCMProvider(PCMProvider provider, ExecutorService executor) throws IOException {
        this.mExecutorService = executor;
        int status = provider.open();
        if (status != 0) {
            throw new IOException("Init " + getClass().getName() + " failed with code=" + status);
        }
        this.mDuration = provider.getDuration();
        this.mChannels = provider.getChannels();
        this.mSampleRate = provider.getSampleRate();
        this.mMinSampleBufferSize = provider.getMinSampleBufferSize();
        this.mBuffer = new Buffer(this.mMinSampleBufferSize, 3);
        this.mActualProvider = provider;
        this.mClosed = true;
    }

    public int open() {
        if (this.mClosed) {
            this.mClosed = false;
            this.mReadEOF = false;
            this.mSeeking = false;
            synchronized (this.mActualProvider) {
                if (this.mActualProvider.isClosed()) {
                    int status = this.mActualProvider.open();
                    if (status != 0) {
                        Log.e(TAG, "Open " + getClass().getName() + " failed with code=" + status);
                    }
                }
            }
            synchronized (this.mLock) {
                try {
                    this.mExecutorService.execute(new WorkRunnable(this));
                    this.mLock.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        Utils.debugLog(TAG, "open " + this.mActualProvider);
        return 0;
    }

    public void close() {
        if (!this.mClosed) {
            synchronized (this.mLock) {
                this.mClosed = true;
                this.mLock.notifyAll();
                try {
                    this.mLock.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        synchronized (this.mActualProvider) {
            this.mActualProvider.close();
        }
        Utils.debugLog(TAG, "close " + this.mActualProvider);
    }

    public boolean isClosed() {
        return this.mClosed;
    }

    public void release() {
        close();
        synchronized (this.mActualProvider) {
            this.mActualProvider.release();
        }
    }

    public int read(byte[] pcmData) throws IOException {
        int readLen;
        synchronized (this.mLock) {
            while (!this.mBuffer.canRead(pcmData.length) && !this.mReadEOF) {
                this.mLock.notifyAll();
                try {
                    this.mLock.wait();
                } catch (InterruptedException e) {
                }
            }
            readLen = this.mBuffer.read(pcmData, !this.mReadEOF);
            if (this.mReadEOF && readLen <= 0) {
                readLen = -1;
            }
            this.mLock.notifyAll();
        }
        return readLen;
    }

    public int seek(int target) {
        int status = 0;
        synchronized (this.mActualProvider) {
            if (!this.mActualProvider.isClosed() || this.mActualProvider.open() == 0) {
                status = this.mActualProvider.seek(target);
                if (status == 0) {
                    synchronized (this.mLock) {
                        this.mBuffer.reset();
                        this.mSeeking = true;
                        this.mReadEOF = false;
                    }
                }
            }
        }
        return status;
    }

    public int getBaseFramePosition() {
        return this.mActualProvider.getBaseFramePosition();
    }

    public int getChannels() {
        return this.mChannels;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getMinSampleBufferSize() {
        return this.mMinSampleBufferSize;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    void workAsync() throws InterruptedException {
        synchronized (this.mLock) {
            this.mLock.notifyAll();
            this.mLock.wait();
        }
        byte[] buf = new byte[this.mMinSampleBufferSize];
        while (!this.mClosed) {
            int len = -1;
            boolean readEOF = false;
            synchronized (this.mActualProvider) {
                try {
                    this.mSeeking = false;
                    len = this.mActualProvider.read(buf);
                    if (len < 0) {
                        readEOF = true;
                    } else {
                        readEOF = false;
                    }
                } catch (IOException e) {
                }
            }
            synchronized (this.mLock) {
                this.mReadEOF = readEOF;
                while (!this.mClosed && (this.mReadEOF || !this.mBuffer.canWrite(len))) {
                    this.mLock.notifyAll();
                    this.mLock.wait();
                }
                if (len > 0) {
                    if (!this.mSeeking) {
                        this.mBuffer.write(buf, 0, len);
                    }
                }
                this.mLock.notifyAll();
            }
        }
        synchronized (this.mLock) {
            this.mLock.notifyAll();
            Utils.debugLog(TAG, "Work thread say goodbye! " + this.mActualProvider);
        }
    }
}
