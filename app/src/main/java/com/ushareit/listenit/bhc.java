package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;

public final class bhc {
    public byte[] f6306a;
    public byte[] f6307b;
    public int f6308c;
    public int[] f6309d;
    public int[] f6310e;
    public int f6311f;
    private final CryptoInfo f6312g;

    public bhc() {
        this.f6312g = btc.f7662a >= 16 ? m8386b() : null;
    }

    public void m8389a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.f6311f = i;
        this.f6309d = iArr;
        this.f6310e = iArr2;
        this.f6307b = bArr;
        this.f6306a = bArr2;
        this.f6308c = i2;
        if (btc.f7662a >= 16) {
            m8387c();
        }
    }

    @TargetApi(16)
    public CryptoInfo m8388a() {
        return this.f6312g;
    }

    @TargetApi(16)
    private CryptoInfo m8386b() {
        return new CryptoInfo();
    }

    @TargetApi(16)
    private void m8387c() {
        this.f6312g.set(this.f6311f, this.f6309d, this.f6310e, this.f6307b, this.f6306a, this.f6308c);
    }
}
