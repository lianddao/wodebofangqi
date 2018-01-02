package com.xiaomi.music.util;

public class Numbers {
    public static final long[] LONG_EMPTY_ARRAY = new long[0];
    public static final Long[] LONG_EMPTY_OBJ_ARRAY = new Long[0];
    public static final String[] STRING_EMPTY_ARRAY = new String[0];

    public static float clamp(float x, float min, float max) {
        if (x > max) {
            return max;
        }
        return x < min ? min : x;
    }

    public static int clamp(int v, int min, int max) {
        return Math.max(min, Math.min(v, max));
    }

    public static int toInt(String str, int defaultValue) {
        if (str != null) {
            try {
                defaultValue = Integer.parseInt(str);
            } catch (NumberFormatException e) {
            }
        }
        return defaultValue;
    }

    public static long toLong(String str, int defaultValue) {
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return (long) defaultValue;
    }
}
