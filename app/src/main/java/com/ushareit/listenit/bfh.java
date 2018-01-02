package com.ushareit.listenit;

public final class bfh implements bfv {
    private final brl f6047a;
    private final long f6048b;
    private final long f6049c;
    private final long f6050d;
    private final long f6051e;
    private int f6052f;
    private boolean f6053g;

    public bfh() {
        this(new brl(true, 65536));
    }

    public bfh(brl com_ushareit_listenit_brl) {
        this(com_ushareit_listenit_brl, 15000, 30000, 2500, 5000);
    }

    public bfh(brl com_ushareit_listenit_brl, int i, int i2, long j, long j2) {
        this.f6047a = com_ushareit_listenit_brl;
        this.f6048b = ((long) i) * 1000;
        this.f6049c = ((long) i2) * 1000;
        this.f6050d = j * 1000;
        this.f6051e = j2 * 1000;
    }

    public void mo881a() {
        m8014a(false);
    }

    public void mo882a(bfx[] com_ushareit_listenit_bfxArr, bok com_ushareit_listenit_bok, bqn<?> com_ushareit_listenit_bqn_) {
        int i = 0;
        this.f6052f = 0;
        while (i < com_ushareit_listenit_bfxArr.length) {
            if (com_ushareit_listenit_bqn_.m9530a(i) != null) {
                this.f6052f += btc.m9772b(com_ushareit_listenit_bfxArr[i].mo864a());
            }
            i++;
        }
        this.f6047a.m9584a(this.f6052f);
    }

    public void mo885b() {
        m8014a(true);
    }

    public void mo886c() {
        m8014a(true);
    }

    public bra mo887d() {
        return this.f6047a;
    }

    public boolean mo884a(long j, boolean z) {
        long j2 = z ? this.f6051e : this.f6050d;
        return j2 <= 0 || j >= j2;
    }

    public boolean mo883a(long j) {
        boolean z = false;
        int b = m8015b(j);
        boolean z2;
        if (this.f6047a.m9590e() >= this.f6052f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (b == 2 || (b == 1 && this.f6053g && !r2)) {
            z = true;
        }
        this.f6053g = z;
        return this.f6053g;
    }

    private int m8015b(long j) {
        if (j > this.f6049c) {
            return 0;
        }
        return j < this.f6048b ? 2 : 1;
    }

    private void m8014a(boolean z) {
        this.f6052f = 0;
        this.f6053g = false;
        if (z) {
            this.f6047a.m9589d();
        }
    }
}
