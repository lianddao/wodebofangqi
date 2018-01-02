package com.ushareit.listenit;

import java.lang.ref.WeakReference;

abstract class cjf extends cjd {
    private static final WeakReference<byte[]> f8366b = new WeakReference(null);
    private WeakReference<byte[]> f8367a = f8366b;

    cjf(byte[] bArr) {
        super(bArr);
    }

    byte[] mo1375c() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f8367a.get();
            if (bArr == null) {
                bArr = mo1376d();
                this.f8367a = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] mo1376d();
}
