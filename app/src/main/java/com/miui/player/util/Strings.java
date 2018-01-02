package com.miui.player.util;

import java.util.Arrays;
import java.util.List;

public final class Strings {
    private static final long KiloBytes = 1024;
    private static final String LOGTAG = "common/Strings";
    private static final long MigBytes = 1048576;

    public static final List<String> seperateValues(String strValues, String seperator) {
        if (strValues == null || strValues.length() <= 0) {
            return null;
        }
        return Arrays.asList(strValues.split(seperator));
    }

    public static String concat(String connector, String... args) {
        StringBuilder sb = new StringBuilder();
        if (args != null) {
            for (String v : args) {
                if (v != null) {
                    sb.append(v);
                }
                sb.append(connector);
            }
            int len = sb.length();
            sb.delete(len - connector.length(), len);
        }
        return sb.toString();
    }

    public static String formatSize(long size) {
        if (size <= 0) {
            try {
                return "0 B";
            } catch (Exception e) {
                return null;
            }
        } else if (size < 1048576) {
            return String.format("%1.1f K", new Object[]{Float.valueOf((((float) size) + 0.0f) / 1024.0f)});
        } else {
            return String.format("%1.1f M", new Object[]{Float.valueOf((((float) size) + 0.0f) / 1048576.0f)});
        }
    }
}
