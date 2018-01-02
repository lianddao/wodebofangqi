package com.ushareit.listenit;

import com.mopub.common.Constants;

public final class bqb implements bqm {
    private final brd f7401a;
    private final int f7402b;
    private final int f7403c;
    private final int f7404d;
    private final int f7405e;
    private final float f7406f;

    public /* synthetic */ bql mo1082b(boj com_ushareit_listenit_boj, int[] iArr) {
        return m9499a(com_ushareit_listenit_boj, iArr);
    }

    public bqb(brd com_ushareit_listenit_brd) {
        this(com_ushareit_listenit_brd, 800000, Constants.TEN_SECONDS_MILLIS, 25000, 25000, 0.75f);
    }

    public bqb(brd com_ushareit_listenit_brd, int i, int i2, int i3, int i4, float f) {
        this.f7401a = com_ushareit_listenit_brd;
        this.f7402b = i;
        this.f7403c = i2;
        this.f7404d = i3;
        this.f7405e = i4;
        this.f7406f = f;
    }

    public bqa m9499a(boj com_ushareit_listenit_boj, int... iArr) {
        return new bqa(com_ushareit_listenit_boj, iArr, this.f7401a, this.f7402b, (long) this.f7403c, (long) this.f7404d, (long) this.f7405e, this.f7406f);
    }
}
