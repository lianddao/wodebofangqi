package com.ushareit.listenit;

import android.view.animation.Interpolator;

public abstract class epz implements Cloneable {
    float f11478a;
    Class f11479b;
    boolean f11480c = false;
    private Interpolator f11481d = null;

    public abstract void mo2244a(Object obj);

    public abstract Object mo2245b();

    public abstract epz mo2247e();

    public /* synthetic */ Object clone() {
        return mo2247e();
    }

    public static epz m17341a(float f, int i) {
        return new eqb(f, i);
    }

    public static epz m17339a(float f) {
        return new eqb(f);
    }

    public static epz m17340a(float f, float f2) {
        return new eqa(f, f2);
    }

    public static epz m17342b(float f) {
        return new eqa(f);
    }

    public boolean m17345a() {
        return this.f11480c;
    }

    public float m17347c() {
        return this.f11478a;
    }

    public Interpolator m17348d() {
        return this.f11481d;
    }

    public void m17343a(Interpolator interpolator) {
        this.f11481d = interpolator;
    }
}
