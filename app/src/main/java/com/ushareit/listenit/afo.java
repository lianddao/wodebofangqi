package com.ushareit.listenit;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class afo extends FilterInputStream {
    private final long f4270a;
    private int f4271b;

    public static InputStream m5471a(InputStream inputStream, long j) {
        return new afo(inputStream, j);
    }

    afo(InputStream inputStream, long j) {
        super(inputStream);
        this.f4270a = j;
    }

    public synchronized int available() {
        return (int) Math.max(this.f4270a - ((long) this.f4271b), (long) this.in.available());
    }

    public synchronized int read() {
        return m5470a(super.read());
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        return m5470a(super.read(bArr, i, i2));
    }

    private int m5470a(int i) {
        if (i >= 0) {
            this.f4271b += i;
        } else if (this.f4270a - ((long) this.f4271b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f4270a + ", but read: " + this.f4271b);
        }
        return i;
    }
}
