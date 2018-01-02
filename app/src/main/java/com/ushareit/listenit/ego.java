package com.ushareit.listenit;

import com.mopub.common.DiskLruCacheUtil;
import com.umeng.analytics.pro.dm;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class ego implements Closeable {
    private final InputStream f11044a;
    private final Charset f11045b;
    private byte[] f11046c;
    private int f11047d;
    private int f11048e;

    public ego(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public ego(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(DiskLruCacheUtil.f2111a)) {
            this.f11044a = inputStream;
            this.f11045b = charset;
            this.f11046c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() {
        synchronized (this.f11044a) {
            if (this.f11046c != null) {
                this.f11046c = null;
                this.f11044a.close();
            }
        }
    }

    public String readLine() {
        String str;
        synchronized (this.f11044a) {
            if (this.f11046c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f11047d >= this.f11048e) {
                m17070a();
            }
            int i2 = this.f11047d;
            while (i2 != this.f11048e) {
                if (this.f11046c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f11047d || this.f11046c[i2 - 1] != dm.f3661k) ? i2 : i2 - 1;
                    str = new String(this.f11046c, this.f11047d, i3 - this.f11047d, this.f11045b.name());
                    this.f11047d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream com_ushareit_listenit_egp = new egp(this, (this.f11048e - this.f11047d) + 80);
            loop1:
            while (true) {
                com_ushareit_listenit_egp.write(this.f11046c, this.f11047d, this.f11048e - this.f11047d);
                this.f11048e = -1;
                m17070a();
                i = this.f11047d;
                while (i != this.f11048e) {
                    if (this.f11046c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f11047d) {
                com_ushareit_listenit_egp.write(this.f11046c, this.f11047d, i - this.f11047d);
            }
            this.f11047d = i + 1;
            str = com_ushareit_listenit_egp.toString();
        }
        return str;
    }

    private void m17070a() {
        int read = this.f11044a.read(this.f11046c, 0, this.f11046c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f11047d = 0;
        this.f11048e = read;
    }
}
