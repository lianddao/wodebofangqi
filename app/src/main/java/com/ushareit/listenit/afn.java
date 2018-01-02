package com.ushareit.listenit;

import android.util.Log;
import java.util.Queue;

public final class afn {
    private static final afn f4268b = new afn();
    private final Queue<byte[]> f4269a = afu.m5496a(0);

    public static afn m5467a() {
        return f4268b;
    }

    private afn() {
    }

    public byte[] m5469b() {
        byte[] bArr;
        synchronized (this.f4269a) {
            bArr = (byte[]) this.f4269a.poll();
        }
        if (bArr == null) {
            bArr = new byte[65536];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return bArr;
    }

    public boolean m5468a(byte[] bArr) {
        boolean z = false;
        if (bArr.length == 65536) {
            synchronized (this.f4269a) {
                if (this.f4269a.size() < 32) {
                    z = true;
                    this.f4269a.offer(bArr);
                }
            }
        }
        return z;
    }
}
