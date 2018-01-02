package com.xiaomi.music.util;

import android.util.Log;

public class MusicLog {
    public static final boolean IS_DEBUG = false;

    public static int m401p(String tag, String msg) {
        return Log.d(tag, "[Performance]" + msg);
    }

    public static int m399i(String tag, String msg) {
        return Log.i(tag, msg);
    }

    public static int m402v(String tag, String msg) {
        return Log.v(tag, msg);
    }

    public static int m395d(String tag, String msg) {
        return Log.d(tag, msg);
    }

    public static int m404w(String tag, String msg) {
        return Log.w(tag, msg);
    }

    public static int m397e(String tag, String msg) {
        return Log.e(tag, msg);
    }

    public static int m400i(String tag, String msg, Throwable tr) {
        return Log.i(tag, msg, tr);
    }

    public static int m403v(String tag, String msg, Throwable tr) {
        return Log.v(tag, msg, tr);
    }

    public static int m396d(String tag, String msg, Throwable tr) {
        return Log.d(tag, msg, tr);
    }

    public static int m405w(String tag, String msg, Throwable tr) {
        return Log.w(tag, msg, tr);
    }

    public static int m398e(String tag, String msg, Throwable tr) {
        return Log.e(tag, msg, tr);
    }
}
