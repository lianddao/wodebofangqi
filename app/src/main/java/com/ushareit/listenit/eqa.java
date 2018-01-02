package com.ushareit.listenit;

class eqa extends epz {
    float f11483d;

    public /* synthetic */ Object clone() {
        return m17356g();
    }

    public /* synthetic */ epz mo2247e() {
        return m17356g();
    }

    eqa(float f, float f2) {
        this.a = f;
        this.f11483d = f2;
        this.b = Float.TYPE;
        this.c = true;
    }

    eqa(float f) {
        this.a = f;
        this.b = Float.TYPE;
    }

    public float m17355f() {
        return this.f11483d;
    }

    public Object mo2245b() {
        return Float.valueOf(this.f11483d);
    }

    public void mo2244a(Object obj) {
        if (obj != null && obj.getClass() == Float.class) {
            this.f11483d = ((Float) obj).floatValue();
            this.c = true;
        }
    }

    public eqa m17356g() {
        eqa com_ushareit_listenit_eqa = new eqa(m17347c(), this.f11483d);
        com_ushareit_listenit_eqa.m17343a(m17348d());
        return com_ushareit_listenit_eqa;
    }
}
