package com.ushareit.listenit;

import com.umeng.analytics.pro.dm;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

class ui implements Closeable {
    private final InputStream f16890a;
    private final Charset f16891b;
    private byte[] f16892c;
    private int f16893d;
    private int f16894e;

    public ui(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public ui(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(uk.f16896a)) {
            this.f16890a = inputStream;
            this.f16891b = charset;
            this.f16892c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() {
        synchronized (this.f16890a) {
            if (this.f16892c != null) {
                this.f16892c = null;
                this.f16890a.close();
            }
        }
    }

    public String m26545a() {
        String str;
        synchronized (this.f16890a) {
            if (this.f16892c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f16893d >= this.f16894e) {
                m26544c();
            }
            int i2 = this.f16893d;
            while (i2 != this.f16894e) {
                if (this.f16892c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f16893d || this.f16892c[i2 - 1] != dm.f3661k) ? i2 : i2 - 1;
                    str = new String(this.f16892c, this.f16893d, i3 - this.f16893d, this.f16891b.name());
                    this.f16893d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream ujVar = new uj(this, (this.f16894e - this.f16893d) + 80);
            loop1:
            while (true) {
                ujVar.write(this.f16892c, this.f16893d, this.f16894e - this.f16893d);
                this.f16894e = -1;
                m26544c();
                i = this.f16893d;
                while (i != this.f16894e) {
                    if (this.f16892c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f16893d) {
                ujVar.write(this.f16892c, this.f16893d, i - this.f16893d);
            }
            this.f16893d = i + 1;
            str = ujVar.toString();
        }
        return str;
    }

    public boolean m26546b() {
        return this.f16894e == -1;
    }

    private void m26544c() {
        int read = this.f16890a.read(this.f16892c, 0, this.f16892c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f16893d = 0;
        this.f16894e = read;
    }
}
