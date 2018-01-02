package com.miui.player.ffmpeg;

import android.util.Log;
import java.io.File;
import java.io.IOException;

public class FFMPEGProvider implements PCMProvider {
    private static final String[] NATIVE_LIBS = new String[]{"ffmpeg_xm", "ffplayer_jni"};
    private static final String TAG = "com.miui.player.ffmpeg.FFMPEGPlayer";
    private static final boolean sNativeInitSuccess;
    private final String mName;
    private int mNativeContext;

    private native void native_finalize();

    private static native void native_init();

    private native int native_setup(String str);

    public native void close();

    public native int getBaseFramePosition();

    public native int getChannels();

    public native int getDuration();

    public native int getMinSampleBufferSize();

    public native int getSampleRate();

    public native boolean isClosed();

    public native int open();

    public native int read(byte[] bArr, int i, int i2) throws IOException;

    public native int seek(int i);

    static {
        boolean initSuccess;
        try {
            for (String lib : NATIVE_LIBS) {
                System.loadLibrary(lib);
            }
            native_init();
            initSuccess = true;
            Log.i(TAG, "All native libs load success!");
        } catch (UnsatisfiedLinkError e) {
            initSuccess = false;
            Log.e(TAG, "Native lib load failed with " + e.toString());
        }
        sNativeInitSuccess = initSuccess;
    }

    public static boolean isNativeInitSuccess() {
        return sNativeInitSuccess;
    }

    public FFMPEGProvider(File file) {
        if (file == null || native_setup(file.getAbsolutePath()) != 0) {
            throw new RuntimeException("Setup FFMPEGProvider failed!");
        }
        this.mName = file.getAbsolutePath();
    }

    public void release() {
        try {
            native_finalize();
        } catch (Exception e) {
        }
    }

    public String toString() {
        return super.toString() + " " + this.mName;
    }

    public void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public int read(byte[] pcmData) throws IOException {
        return read(pcmData, 0, pcmData.length);
    }
}
