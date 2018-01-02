package com.xiaomi.music.util;

public class Utils {
    public static int ceil(int numerator, int denominator) {
        int result = numerator / denominator;
        return result * denominator == numerator ? result : result + 1;
    }
}
