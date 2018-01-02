package com.ushareit.listenit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class afp extends InputStream {
    private static final Queue<afp> f4272a = afu.m5496a(0);
    private InputStream f4273b;
    private IOException f4274c;

    public static afp m5472a(InputStream inputStream) {
        afp com_ushareit_listenit_afp;
        synchronized (f4272a) {
            com_ushareit_listenit_afp = (afp) f4272a.poll();
        }
        if (com_ushareit_listenit_afp == null) {
            com_ushareit_listenit_afp = new afp();
        }
        com_ushareit_listenit_afp.m5475b(inputStream);
        return com_ushareit_listenit_afp;
    }

    afp() {
    }

    void m5475b(InputStream inputStream) {
        this.f4273b = inputStream;
    }

    public int available() {
        return this.f4273b.available();
    }

    public void close() {
        this.f4273b.close();
    }

    public void mark(int i) {
        this.f4273b.mark(i);
    }

    public boolean markSupported() {
        return this.f4273b.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.f4273b.read(bArr);
        } catch (IOException e) {
            this.f4274c = e;
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f4273b.read(bArr, i, i2);
        } catch (IOException e) {
            this.f4274c = e;
            return -1;
        }
    }

    public synchronized void reset() {
        this.f4273b.reset();
    }

    public long skip(long j) {
        try {
            return this.f4273b.skip(j);
        } catch (IOException e) {
            this.f4274c = e;
            return 0;
        }
    }

    public int read() {
        try {
            return this.f4273b.read();
        } catch (IOException e) {
            this.f4274c = e;
            return -1;
        }
    }

    public IOException m5473a() {
        return this.f4274c;
    }

    public void m5474b() {
        this.f4274c = null;
        this.f4273b = null;
        synchronized (f4272a) {
            f4272a.offer(this);
        }
    }
}
