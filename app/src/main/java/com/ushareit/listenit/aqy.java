package com.ushareit.listenit;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class aqy {
    private static final Pattern f5196d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern f5197e = Pattern.compile("GET /(.*) HTTP");
    public final String f5198a;
    public final long f5199b;
    public final boolean f5200c;

    public aqy(String str) {
        arl.m6900a(str);
        long a = m6824a(str);
        this.f5199b = Math.max(0, a);
        this.f5200c = a >= 0;
        this.f5198a = m6826b(str);
    }

    private long m6824a(String str) {
        Matcher matcher = f5196d.matcher(str);
        return matcher.find() ? Long.parseLong(matcher.group(1)) : -1;
    }

    public static aqy m6825a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            Object readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new aqy(stringBuilder.toString());
            }
            stringBuilder.append(readLine).append('\n');
        }
    }

    private String m6826b(String str) {
        Matcher matcher = f5197e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f5199b + ", partial=" + this.f5200c + ", uri='" + this.f5198a + '\'' + '}';
    }
}
