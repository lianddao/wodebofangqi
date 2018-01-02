package com.ushareit.listenit;

import android.net.Uri;
import java.util.Arrays;

public final class brk {
    public final Uri f7504a;
    public final byte[] f7505b;
    public final long f7506c;
    public final long f7507d;
    public final long f7508e;
    public final String f7509f;
    public final int f7510g;

    public brk(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public brk(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public brk(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        bsg.m9656a(j >= 0);
        bsg.m9656a(j2 >= 0);
        boolean z = j3 > 0 || j3 == -1;
        bsg.m9656a(z);
        this.f7504a = uri;
        this.f7505b = bArr;
        this.f7506c = j;
        this.f7507d = j2;
        this.f7508e = j3;
        this.f7509f = str;
        this.f7510g = i;
    }

    public String toString() {
        return "DataSpec[" + this.f7504a + ", " + Arrays.toString(this.f7505b) + ", " + this.f7506c + ", " + this.f7507d + ", " + this.f7508e + ", " + this.f7509f + ", " + this.f7510g + "]";
    }
}
