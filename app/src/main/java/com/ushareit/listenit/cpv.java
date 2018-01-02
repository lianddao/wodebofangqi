package com.ushareit.listenit;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class cpv extends Reader {
    private List<String> f8675a;
    private boolean f8676b;
    private int f8677c;
    private int f8678d;
    private int f8679e;
    private int f8680f;
    private boolean f8681g;

    public cpv() {
        this.f8675a = null;
        this.f8676b = false;
        this.f8679e = this.f8677c;
        this.f8680f = this.f8678d;
        this.f8681g = false;
        this.f8675a = new ArrayList();
    }

    private long m12223a(long j) {
        long j2 = 0;
        while (this.f8678d < this.f8675a.size() && j2 < j) {
            int c = m12225c();
            long j3 = j - j2;
            if (j3 < ((long) c)) {
                this.f8677c = (int) (((long) this.f8677c) + j3);
                j2 += j3;
            } else {
                j2 += (long) c;
                this.f8677c = 0;
                this.f8678d++;
            }
        }
        return j2;
    }

    private String m12224b() {
        return this.f8678d < this.f8675a.size() ? (String) this.f8675a.get(this.f8678d) : null;
    }

    private int m12225c() {
        String b = m12224b();
        return b == null ? 0 : b.length() - this.f8677c;
    }

    private void m12226d() {
        if (this.f8676b) {
            throw new IOException("Stream already closed");
        } else if (!this.f8681g) {
            throw new IOException("Reader needs to be frozen before read operations can be called");
        }
    }

    public void m12227a() {
        if (this.f8681g) {
            throw new IllegalStateException("Trying to freeze frozen StringListReader");
        }
        this.f8681g = true;
    }

    public void m12228a(String str) {
        if (this.f8681g) {
            throw new IllegalStateException("Trying to add string after reading");
        } else if (str.length() > 0) {
            this.f8675a.add(str);
        }
    }

    public void close() {
        m12226d();
        this.f8676b = true;
    }

    public void mark(int i) {
        m12226d();
        this.f8679e = this.f8677c;
        this.f8680f = this.f8678d;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        m12226d();
        String b = m12224b();
        if (b == null) {
            return -1;
        }
        char charAt = b.charAt(this.f8677c);
        m12223a(1);
        return charAt;
    }

    public int read(CharBuffer charBuffer) {
        m12226d();
        int remaining = charBuffer.remaining();
        int i = 0;
        String b = m12224b();
        while (remaining > 0 && b != null) {
            int min = Math.min(b.length() - this.f8677c, remaining);
            charBuffer.put((String) this.f8675a.get(this.f8678d), this.f8677c, this.f8677c + min);
            remaining -= min;
            i += min;
            m12223a((long) min);
            b = m12224b();
        }
        return (i > 0 || b != null) ? i : -1;
    }

    public int read(char[] cArr, int i, int i2) {
        m12226d();
        int i3 = 0;
        String b = m12224b();
        while (b != null && i3 < i2) {
            int min = Math.min(m12225c(), i2 - i3);
            b.getChars(this.f8677c, this.f8677c + min, cArr, i + i3);
            int i4 = i3 + min;
            m12223a((long) min);
            i3 = i4;
            b = m12224b();
        }
        return (i3 > 0 || b != null) ? i3 : -1;
    }

    public boolean ready() {
        m12226d();
        return true;
    }

    public void reset() {
        this.f8677c = this.f8679e;
        this.f8678d = this.f8680f;
    }

    public long skip(long j) {
        m12226d();
        return m12223a(j);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : this.f8675a) {
            stringBuilder.append(append);
        }
        return stringBuilder.toString();
    }
}
