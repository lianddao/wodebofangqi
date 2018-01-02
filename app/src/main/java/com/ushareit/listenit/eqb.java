package com.ushareit.listenit;

class eqb extends epz {
    int f11484d;

    public /* synthetic */ Object clone() {
        return m17361g();
    }

    public /* synthetic */ epz mo2247e() {
        return m17361g();
    }

    eqb(float f, int i) {
        this.a = f;
        this.f11484d = i;
        this.b = Integer.TYPE;
        this.c = true;
    }

    eqb(float f) {
        this.a = f;
        this.b = Integer.TYPE;
    }

    public int m17360f() {
        return this.f11484d;
    }

    public Object mo2245b() {
        return Integer.valueOf(this.f11484d);
    }

    public void mo2244a(Object obj) {
        if (obj != null && obj.getClass() == Integer.class) {
            this.f11484d = ((Integer) obj).intValue();
            this.c = true;
        }
    }

    public eqb m17361g() {
        eqb com_ushareit_listenit_eqb = new eqb(m17347c(), this.f11484d);
        com_ushareit_listenit_eqb.m17343a(m17348d());
        return com_ushareit_listenit_eqb;
    }
}
