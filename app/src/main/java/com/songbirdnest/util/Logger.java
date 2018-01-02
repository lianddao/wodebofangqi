package com.songbirdnest.util;

import android.util.Log;

public class Logger {
    private static String applicationTag = "Songbird";

    public static void setApplicationTag(String applicationTag) {
        applicationTag = applicationTag;
    }

    public static void error(Object caller, String message) {
        error(caller, message, null);
    }

    public static void error(Object caller, Throwable exception) {
        error(caller, exception.getMessage(), exception);
    }

    public static void error(Object caller, String message, Throwable exception) {
        if (message == null || message.length() == 0) {
            message = "";
        }
        if (exception != null) {
            Log.e(applicationTag, caller.getClass().getSimpleName() + ": " + message, exception);
        } else {
            Log.e(applicationTag, caller.getClass().getSimpleName() + ": " + message);
        }
    }

    public static void debug(Object caller, String message) {
        if (message == null || message.length() == 0) {
            message = "";
        }
        Log.d(applicationTag, caller.getClass().getSimpleName() + ": " + message);
    }

    public static void warn(Object caller, String message) {
        if (message == null || message.length() == 0) {
            message = "";
        }
        Log.w(applicationTag, caller.getClass().getSimpleName() + ": " + message);
    }
}
