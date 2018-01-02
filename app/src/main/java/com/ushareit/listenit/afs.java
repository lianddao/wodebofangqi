package com.ushareit.listenit;

import java.io.FilterInputStream;
import java.io.InputStream;

public class afs extends FilterInputStream {
    private int f4280a = Integer.MIN_VALUE;

    public afs(InputStream inputStream) {
        super(inputStream);
    }

    public void mark(int i) {
        super.mark(i);
        this.f4280a = i;
    }

    public int read() {
        if (m5487a(1) == -1) {
            return -1;
        }
        int read = super.read();
        m5488b(1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int a = (int) m5487a((long) i2);
        if (a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a);
        m5488b((long) read);
        return read;
    }

    public void reset() {
        super.reset();
        this.f4280a = Integer.MIN_VALUE;
    }

    public long skip(long j) {
        long a = m5487a(j);
        if (a == -1) {
            return -1;
        }
        long skip = super.skip(a);
        m5488b(skip);
        return skip;
    }

    public int available() {
        return this.f4280a == Integer.MIN_VALUE ? super.available() : Math.min(this.f4280a, super.available());
    }

    private long m5487a(long j) {
        if (this.f4280a == 0) {
            return -1;
        }
        if (this.f4280a == Integer.MIN_VALUE || j <= ((long) this.f4280a)) {
            return j;
        }
        return (long) this.f4280a;
    }

    private void m5488b(long j) {
        if (this.f4280a != Integer.MIN_VALUE && j != -1) {
            this.f4280a = (int) (((long) this.f4280a) - j);
        }
    }
}
