package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.mopub.common.Constants;
import com.umeng.analytics.pro.C0277j;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class fof {
    private static int f13092a = Constants.TEN_SECONDS_MILLIS;
    private static ByteBuffer f13093b;
    private static String f13094c;

    public static synchronized int m20203a(String str) {
        int i = 0;
        synchronized (fof.class) {
            if (VERSION.SDK_INT >= 16) {
                int[] b;
                f13094c = str;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    b = m20205b(str);
                } catch (Exception e) {
                    b = null;
                }
                if (f13094c.equals(str) && b != null && b.length >= f13092a / 1000 && f13092a > 0) {
                    double[] a = m20204a(b);
                    int length = a.length;
                    int i2 = length - 1;
                    int i3 = 0;
                    while (i2 > 0 && a[i2] < 0.20000000298023224d) {
                        i3++;
                        i2--;
                    }
                    String str2 = "TailSkipHelper";
                    StringBuilder append = new StringBuilder().append("formalGains.length=").append(a.length).append(", skipTailFrameCount=").append(i3).append(", skipTailDuration=");
                    if (i3 > 0) {
                        i2 = (f13092a * i3) / length;
                    } else {
                        i2 = 0;
                    }
                    exw.m18443a(str2, append.append(i2).append(", usedTime=").append(System.currentTimeMillis() - currentTimeMillis).toString());
                    if (i3 > 0) {
                        i = (f13092a * i3) / length;
                    }
                }
            }
        }
        return i;
    }

    @TargetApi(16)
    private static int[] m20205b(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        MediaFormat mediaFormat;
        mediaExtractor.setDataSource(file.getPath());
        int trackCount = mediaExtractor.getTrackCount();
        MediaFormat mediaFormat2 = null;
        int i = 0;
        while (i < trackCount) {
            mediaFormat2 = mediaExtractor.getTrackFormat(i);
            if (mediaFormat2.getString("mime").startsWith("audio/")) {
                mediaExtractor.selectTrack(i);
                mediaFormat = mediaFormat2;
                break;
            }
            i++;
        }
        mediaFormat = mediaFormat2;
        if (i == trackCount) {
            return null;
        }
        int integer = mediaFormat.getInteger("channel-count");
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
        createDecoderByType.configure(mediaFormat, null, null, 0);
        createDecoderByType.start();
        ByteBuffer[] inputBuffers = createDecoderByType.getInputBuffers();
        ByteBuffer[] outputBuffers = createDecoderByType.getOutputBuffers();
        BufferInfo bufferInfo = new BufferInfo();
        long j = mediaFormat.getLong("durationUs") / 1000;
        f13092a = j > 10000 ? Constants.TEN_SECONDS_MILLIS : (int) j;
        mediaExtractor.seekTo((j - ((long) f13092a)) * 1000, 2);
        exw.m18443a("TailSkipHelper", "dration=" + j + ",  mCodecDuration=" + f13092a);
        if (f13093b == null) {
            f13093b = ByteBuffer.allocate(524288);
        } else {
            f13093b.clear();
            f13093b.rewind();
        }
        Boolean valueOf = Boolean.valueOf(true);
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        ByteBuffer[] byteBufferArr = outputBuffers;
        byte[] bArr = null;
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        while (f13094c.equals(str)) {
            Boolean bool;
            Object obj2;
            int readSampleData;
            int capacity;
            ByteBuffer[] byteBufferArr2;
            i = createDecoderByType.dequeueInputBuffer(100);
            if (obj != null || i < 0) {
                bool = valueOf;
                obj2 = obj;
            } else {
                readSampleData = mediaExtractor.readSampleData(inputBuffers[i], 0);
                if (valueOf.booleanValue()) {
                    if (mediaFormat.getString("mime").equals("audio/mp4a-latm") && readSampleData == 2) {
                        mediaExtractor.advance();
                        bool = Boolean.valueOf(false);
                        obj2 = obj;
                    }
                }
                if (readSampleData < 0) {
                    createDecoderByType.queueInputBuffer(i, 0, 0, -1, 4);
                    obj = 1;
                } else {
                    long sampleTime = mediaExtractor.getSampleTime();
                    createDecoderByType.queueInputBuffer(i, 0, readSampleData, sampleTime, 0);
                    mediaExtractor.advance();
                    j3 = sampleTime;
                }
                bool = Boolean.valueOf(false);
                obj2 = obj;
            }
            int dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 100);
            if (dequeueOutputBuffer >= 0 && bufferInfo.size > 0) {
                byte[] bArr2;
                if (i3 < bufferInfo.size) {
                    trackCount = bufferInfo.size;
                    bArr2 = new byte[trackCount];
                } else {
                    bArr2 = bArr;
                    trackCount = i3;
                }
                byteBufferArr[dequeueOutputBuffer].get(bArr2, 0, bufferInfo.size);
                byteBufferArr[dequeueOutputBuffer].clear();
                if (bufferInfo.size > 1024) {
                    readSampleData = 1024;
                } else {
                    readSampleData = bufferInfo.size;
                }
                bufferInfo.size = readSampleData;
                if (f13093b.remaining() < bufferInfo.size) {
                    capacity = f13093b.capacity() / 2;
                    int capacity2 = f13093b.capacity() + ((((bufferInfo.size - f13093b.remaining()) / capacity) + 1) * capacity);
                    i3 = f13093b.position();
                    ByteBuffer byteBuffer = null;
                    capacity = 10;
                    while (capacity > 0) {
                        try {
                            byteBuffer = ByteBuffer.allocate(capacity2);
                            break;
                        } catch (OutOfMemoryError e) {
                            capacity--;
                        }
                    }
                    if (capacity == 0) {
                        break;
                    }
                    f13093b.rewind();
                    byteBuffer.put(f13093b);
                    f13093b = byteBuffer;
                    f13093b.position(i3);
                }
                f13093b.put(bArr2, 0, bufferInfo.size);
                createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                bArr = bArr2;
                i3 = trackCount;
                byteBufferArr2 = byteBufferArr;
            } else if (dequeueOutputBuffer == -3) {
                byteBufferArr2 = createDecoderByType.getOutputBuffers();
            } else {
                byteBufferArr2 = dequeueOutputBuffer == -2 ? byteBufferArr : byteBufferArr;
            }
            if ((bufferInfo.flags & 4) != 0 || obj2 != null) {
                break;
            }
            if (j2 == j3) {
                readSampleData = i2 + 1;
                if (readSampleData >= 20) {
                    break;
                }
                j = j2;
            } else {
                readSampleData = 0;
                j = j3;
            }
            trackCount = i4 + 1;
            if (trackCount > 1000) {
                i4 = trackCount;
                break;
            }
            i4 = trackCount;
            obj = obj2;
            j2 = j;
            byteBufferArr = byteBufferArr2;
            valueOf = bool;
            i2 = readSampleData;
        }
        i = f13093b.position() / (integer * 2);
        exw.m18443a("TailSkipHelper", "mDecodedBytes.position=" + f13093b.position() + ", readTimes=" + i4);
        f13093b.rewind();
        f13093b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer asShortBuffer = f13093b.asShortBuffer();
        mediaExtractor.release();
        createDecoderByType.stop();
        createDecoderByType.release();
        int i5 = i / 1024;
        if (i % 1024 != 0) {
            i5++;
        }
        int[] iArr = new int[i5];
        for (capacity = 0; capacity < i5; capacity++) {
            trackCount = -1;
            int i6 = 0;
            while (i6 < 1024) {
                i = 0;
                for (int i7 = 0; i7 < integer; i7++) {
                    if (asShortBuffer.remaining() > 0) {
                        i += Math.abs(asShortBuffer.get());
                    }
                }
                i /= integer;
                if (trackCount >= i) {
                    i = trackCount;
                }
                i6++;
                trackCount = i;
            }
            iArr[capacity] = (int) Math.sqrt((double) trackCount);
        }
        asShortBuffer.rewind();
        asShortBuffer.clear();
        f13093b.rewind();
        f13093b.clear();
        return iArr;
    }

    private static double[] m20204a(int[] iArr) {
        int i;
        int i2;
        int length = iArr.length;
        double[] dArr = new double[length];
        if (length == 1) {
            dArr[0] = (double) iArr[0];
        } else if (length == 2) {
            dArr[0] = (double) iArr[0];
            dArr[1] = (double) iArr[1];
        } else if (length > 2) {
            dArr[0] = (((double) iArr[0]) / 2.0d) + (((double) iArr[1]) / 2.0d);
            for (int i3 = 1; i3 < length - 1; i3++) {
                dArr[i3] = ((((double) iArr[i3 - 1]) / 3.0d) + (((double) iArr[i3]) / 3.0d)) + (((double) iArr[i3 + 1]) / 3.0d);
            }
            dArr[length - 1] = (((double) iArr[length - 2]) / 2.0d) + (((double) iArr[length - 1]) / 2.0d);
        }
        double d = 1.0d;
        for (i = 0; i < length; i++) {
            if (dArr[i] > d) {
                d = dArr[i];
            }
        }
        if (d > 255.0d) {
            d = 255.0d / d;
        } else {
            d = 1.0d;
        }
        int[] iArr2 = new int[C0277j.f3694e];
        double d2 = 0.0d;
        for (int i4 = 0; i4 < length; i4++) {
            i2 = (int) (dArr[i4] * d);
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > 255) {
                i2 = 255;
            }
            if (((double) i2) > d2) {
                d2 = (double) i2;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        double d3 = 0.0d;
        i2 = 0;
        while (d3 < 255.0d && i2 < length / 20) {
            i2 += iArr2[(int) d3];
            d3 += 1.0d;
        }
        double d4 = d2;
        i = 0;
        while (d4 > 2.0d && i < length / 100) {
            i += iArr2[(int) d4];
            d4 -= 1.0d;
        }
        double[] dArr2 = new double[length];
        double d5 = d4 - d3;
        for (i2 = 0; i2 < length; i2++) {
            d2 = ((dArr[i2] * d) - d3) / d5;
            if (d2 < 0.0d) {
                d2 = 0.0d;
            }
            if (d2 > 1.0d) {
                d2 = 1.0d;
            }
            dArr2[i2] = d2 * d2;
        }
        return dArr2;
    }
}
