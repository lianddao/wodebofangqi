package com.ushareit.listenit;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class ug {
    File[] f16877a;
    File[] f16878b;
    final /* synthetic */ ud f16879c;
    private final String f16880d;
    private final long[] f16881e;
    private boolean f16882f;
    private uf f16883g;
    private long f16884h;

    private ug(ud udVar, String str) {
        this.f16879c = udVar;
        this.f16880d = str;
        this.f16881e = new long[udVar.f16865h];
        this.f16877a = new File[udVar.f16865h];
        this.f16878b = new File[udVar.f16865h];
        StringBuilder append = new StringBuilder(str).append('.');
        int length = append.length();
        for (int i = 0; i < udVar.f16865h; i++) {
            append.append(i);
            this.f16877a[i] = new File(udVar.f16859b, append.toString());
            append.append(".tmp");
            this.f16878b[i] = new File(udVar.f16859b, append.toString());
            append.setLength(length);
        }
    }

    public String m26540a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.f16881e) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }

    private void m26532a(String[] strArr) {
        if (strArr.length != this.f16879c.f16865h) {
            throw m26534b(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                this.f16881e[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw m26534b(strArr);
            }
        }
    }

    private IOException m26534b(String[] strArr) {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public File m26539a(int i) {
        return this.f16877a[i];
    }

    public File m26541b(int i) {
        return this.f16878b[i];
    }
}
