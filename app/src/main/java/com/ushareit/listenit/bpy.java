package com.ushareit.listenit;

import java.util.regex.Pattern;

public final class bpy {
    private static final Pattern f7381a = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern f7382b = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    public static void m9479a(bss com_ushareit_listenit_bss) {
        Object x = com_ushareit_listenit_bss.m9730x();
        if (x == null || !f7382b.matcher(x).matches()) {
            throw new bor("Expected WEBVTT. Got " + x);
        }
    }

    public static long m9478a(String str) {
        int i = 0;
        long j = 0;
        String[] split = str.split("\\.", 2);
        String[] split2 = split[0].split(":");
        while (i < split2.length) {
            j = (j * 60) + Long.parseLong(split2[i]);
            i++;
        }
        return (Long.parseLong(split[1]) + (j * 1000)) * 1000;
    }

    public static float m9480b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
}
