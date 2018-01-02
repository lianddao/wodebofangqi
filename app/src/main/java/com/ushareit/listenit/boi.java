package com.ushareit.listenit;

public final class boi extends bgd {
    private static final Object f7213a = new Object();
    private final long f7214b;
    private final long f7215c;
    private final long f7216d;
    private final long f7217e;
    private final boolean f7218f;
    private final boolean f7219g;

    public boi(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public boi(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.f7214b = j;
        this.f7215c = j2;
        this.f7216d = j3;
        this.f7217e = j4;
        this.f7218f = z;
        this.f7219g = z2;
    }

    public int mo1051a() {
        return 1;
    }

    public bgf mo1054a(int i, bgf com_ushareit_listenit_bgf, boolean z) {
        bsg.m9653a(i, 0, 1);
        return com_ushareit_listenit_bgf.m8222a(z ? f7213a : null, -9223372036854775807L, -9223372036854775807L, this.f7218f, this.f7219g, this.f7217e, this.f7215c, 0, 0, this.f7216d);
    }

    public int mo1055b() {
        return 1;
    }

    public bge mo1053a(int i, bge com_ushareit_listenit_bge, boolean z) {
        bsg.m9653a(i, 0, 1);
        Object obj = z ? f7213a : null;
        return com_ushareit_listenit_bge.m8218a(obj, obj, 0, this.f7214b, -this.f7216d);
    }

    public int mo1052a(Object obj) {
        return f7213a.equals(obj) ? 0 : -1;
    }
}
