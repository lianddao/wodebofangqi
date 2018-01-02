package com.ushareit.listenit;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class afz {
    private static final Pattern f4291d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern f4292e = Pattern.compile("GET /(.*) HTTP");
    public final String f4293a;
    public final long f4294b;
    public final boolean f4295c;

    public afz(String str) {
        ago.m5589a((Object) str);
        long a = m5510a(str);
        this.f4294b = Math.max(0, a);
        this.f4295c = a >= 0;
        this.f4293a = m5512b(str);
    }

    public static afz m5511a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            Object readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new afz(stringBuilder.toString());
            }
            stringBuilder.append(readLine).append('\n');
        }
    }

    private long m5510a(String str) {
        Matcher matcher = f4291d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1;
    }

    private String m5512b(String str) {
        Matcher matcher = f4292e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f4294b + ", partial=" + this.f4295c + ", uri='" + this.f4293a + '\'' + '}';
    }
}
