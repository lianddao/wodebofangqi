package com.ushareit.listenit;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class abg extends FilterInputStream {
    private volatile byte[] f4033a;
    private int f4034b;
    private int f4035c;
    private int f4036d = -1;
    private int f4037e;

    public abg(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.f4033a = bArr;
    }

    public synchronized int available() {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f4033a == null || inputStream == null) {
            throw m5080b();
        }
        return inputStream.available() + (this.f4034b - this.f4037e);
    }

    private static IOException m5080b() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void m5081a() {
        this.f4035c = this.f4033a.length;
    }

    public void close() {
        this.f4033a = null;
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int m5079a(InputStream inputStream, byte[] bArr) {
        int read;
        if (this.f4036d == -1 || this.f4037e - this.f4036d >= this.f4035c) {
            read = inputStream.read(bArr);
            if (read <= 0) {
                return read;
            }
            this.f4036d = -1;
            this.f4037e = 0;
            this.f4034b = read;
            return read;
        }
        if (this.f4036d == 0 && this.f4035c > bArr.length && this.f4034b == bArr.length) {
            read = bArr.length * 2;
            if (read > this.f4035c) {
                read = this.f4035c;
            }
            if (Log.isLoggable("BufferedIs", 3)) {
                Log.d("BufferedIs", "allocate buffer of length: " + read);
            }
            Object obj = new byte[read];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            this.f4033a = obj;
            bArr = obj;
        } else if (this.f4036d > 0) {
            System.arraycopy(bArr, this.f4036d, bArr, 0, bArr.length - this.f4036d);
        }
        this.f4037e -= this.f4036d;
        this.f4036d = 0;
        this.f4034b = 0;
        int read2 = inputStream.read(bArr, this.f4037e, bArr.length - this.f4037e);
        this.f4034b = read2 <= 0 ? this.f4037e : this.f4037e + read2;
        return read2;
    }

    public synchronized void mark(int i) {
        this.f4035c = Math.max(this.f4035c, i);
        this.f4036d = this.f4037e;
    }

    public boolean markSupported() {
        return true;
    }

    public synchronized int read() {
        int i = -1;
        synchronized (this) {
            byte[] bArr = this.f4033a;
            InputStream inputStream = this.in;
            if (bArr == null || inputStream == null) {
                throw m5080b();
            }
            if (this.f4037e < this.f4034b || m5079a(inputStream, bArr) != -1) {
                if (bArr != this.f4033a) {
                    bArr = this.f4033a;
                    if (bArr == null) {
                        throw m5080b();
                    }
                }
                if (this.f4034b - this.f4037e > 0) {
                    i = this.f4037e;
                    this.f4037e = i + 1;
                    i = bArr[i] & 255;
                }
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r7, int r8, int r9) {
        /*
        r6 = this;
        r0 = -1;
        monitor-enter(r6);
        r2 = r6.f4033a;	 Catch:{ all -> 0x000b }
        if (r2 != 0) goto L_0x000e;
    L_0x0006:
        r0 = m5080b();	 Catch:{ all -> 0x000b }
        throw r0;	 Catch:{ all -> 0x000b }
    L_0x000b:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x000e:
        if (r9 != 0) goto L_0x0013;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        monitor-exit(r6);
        return r0;
    L_0x0013:
        r4 = r6.in;	 Catch:{ all -> 0x000b }
        if (r4 != 0) goto L_0x001c;
    L_0x0017:
        r0 = m5080b();	 Catch:{ all -> 0x000b }
        throw r0;	 Catch:{ all -> 0x000b }
    L_0x001c:
        r1 = r6.f4037e;	 Catch:{ all -> 0x000b }
        r3 = r6.f4034b;	 Catch:{ all -> 0x000b }
        if (r1 >= r3) goto L_0x0059;
    L_0x0022:
        r1 = r6.f4034b;	 Catch:{ all -> 0x000b }
        r3 = r6.f4037e;	 Catch:{ all -> 0x000b }
        r1 = r1 - r3;
        if (r1 < r9) goto L_0x003e;
    L_0x0029:
        r1 = r9;
    L_0x002a:
        r3 = r6.f4037e;	 Catch:{ all -> 0x000b }
        java.lang.System.arraycopy(r2, r3, r7, r8, r1);	 Catch:{ all -> 0x000b }
        r3 = r6.f4037e;	 Catch:{ all -> 0x000b }
        r3 = r3 + r1;
        r6.f4037e = r3;	 Catch:{ all -> 0x000b }
        if (r1 == r9) goto L_0x003c;
    L_0x0036:
        r3 = r4.available();	 Catch:{ all -> 0x000b }
        if (r3 != 0) goto L_0x0044;
    L_0x003c:
        r0 = r1;
        goto L_0x0011;
    L_0x003e:
        r1 = r6.f4034b;	 Catch:{ all -> 0x000b }
        r3 = r6.f4037e;	 Catch:{ all -> 0x000b }
        r1 = r1 - r3;
        goto L_0x002a;
    L_0x0044:
        r8 = r8 + r1;
        r3 = r9 - r1;
    L_0x0047:
        r1 = r6.f4036d;	 Catch:{ all -> 0x000b }
        if (r1 != r0) goto L_0x005b;
    L_0x004b:
        r1 = r2.length;	 Catch:{ all -> 0x000b }
        if (r3 < r1) goto L_0x005b;
    L_0x004e:
        r1 = r4.read(r7, r8, r3);	 Catch:{ all -> 0x000b }
        if (r1 != r0) goto L_0x0085;
    L_0x0054:
        if (r3 == r9) goto L_0x0011;
    L_0x0056:
        r0 = r9 - r3;
        goto L_0x0011;
    L_0x0059:
        r3 = r9;
        goto L_0x0047;
    L_0x005b:
        r1 = r6.m5079a(r4, r2);	 Catch:{ all -> 0x000b }
        if (r1 != r0) goto L_0x0066;
    L_0x0061:
        if (r3 == r9) goto L_0x0011;
    L_0x0063:
        r0 = r9 - r3;
        goto L_0x0011;
    L_0x0066:
        r1 = r6.f4033a;	 Catch:{ all -> 0x000b }
        if (r2 == r1) goto L_0x0073;
    L_0x006a:
        r2 = r6.f4033a;	 Catch:{ all -> 0x000b }
        if (r2 != 0) goto L_0x0073;
    L_0x006e:
        r0 = m5080b();	 Catch:{ all -> 0x000b }
        throw r0;	 Catch:{ all -> 0x000b }
    L_0x0073:
        r1 = r6.f4034b;	 Catch:{ all -> 0x000b }
        r5 = r6.f4037e;	 Catch:{ all -> 0x000b }
        r1 = r1 - r5;
        if (r1 < r3) goto L_0x008a;
    L_0x007a:
        r1 = r3;
    L_0x007b:
        r5 = r6.f4037e;	 Catch:{ all -> 0x000b }
        java.lang.System.arraycopy(r2, r5, r7, r8, r1);	 Catch:{ all -> 0x000b }
        r5 = r6.f4037e;	 Catch:{ all -> 0x000b }
        r5 = r5 + r1;
        r6.f4037e = r5;	 Catch:{ all -> 0x000b }
    L_0x0085:
        r3 = r3 - r1;
        if (r3 != 0) goto L_0x0090;
    L_0x0088:
        r0 = r9;
        goto L_0x0011;
    L_0x008a:
        r1 = r6.f4034b;	 Catch:{ all -> 0x000b }
        r5 = r6.f4037e;	 Catch:{ all -> 0x000b }
        r1 = r1 - r5;
        goto L_0x007b;
    L_0x0090:
        r5 = r4.available();	 Catch:{ all -> 0x000b }
        if (r5 != 0) goto L_0x009a;
    L_0x0096:
        r0 = r9 - r3;
        goto L_0x0011;
    L_0x009a:
        r8 = r8 + r1;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.abg.read(byte[], int, int):int");
    }

    public synchronized void reset() {
        if (this.f4033a == null) {
            throw new IOException("Stream is closed");
        } else if (-1 == this.f4036d) {
            throw new abh("Mark has been invalidated");
        } else {
            this.f4037e = this.f4036d;
        }
    }

    public synchronized long skip(long j) {
        byte[] bArr = this.f4033a;
        InputStream inputStream = this.in;
        if (bArr == null) {
            throw m5080b();
        } else if (j < 1) {
            j = 0;
        } else if (inputStream == null) {
            throw m5080b();
        } else if (((long) (this.f4034b - this.f4037e)) >= j) {
            this.f4037e = (int) (((long) this.f4037e) + j);
        } else {
            long j2 = (long) (this.f4034b - this.f4037e);
            this.f4037e = this.f4034b;
            if (this.f4036d == -1 || j > ((long) this.f4035c)) {
                j = j2 + inputStream.skip(j - j2);
            } else if (m5079a(inputStream, bArr) == -1) {
                j = j2;
            } else if (((long) (this.f4034b - this.f4037e)) >= j - j2) {
                this.f4037e = (int) ((j - j2) + ((long) this.f4037e));
            } else {
                j = (j2 + ((long) this.f4034b)) - ((long) this.f4037e);
                this.f4037e = this.f4034b;
            }
        }
        return j;
    }
}
