package com.ushareit.listenit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class abr<T> implements ux<File, T> {
    private static final abs f4062a = new abs();
    private ux<InputStream, T> f4063b;
    private final abs f4064c;

    public abr(ux<InputStream, T> uxVar) {
        this(uxVar, f4062a);
    }

    abr(ux<InputStream, T> uxVar, abs com_ushareit_listenit_abs) {
        this.f4063b = uxVar;
        this.f4064c = com_ushareit_listenit_abs;
    }

    public wk<T> m5125a(File file, int i, int i2) {
        InputStream inputStream = null;
        try {
            inputStream = this.f4064c.m5128a(file);
            wk<T> a = this.f4063b.mo565a(inputStream, i, i2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            return a;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    public String mo566a() {
        return "";
    }
}
