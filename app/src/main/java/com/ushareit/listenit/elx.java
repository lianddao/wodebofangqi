package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Rect;
import com.mopub.common.util.Dips;

public class elx {
    private final Context f11229a;
    private final Rect f11230b = new Rect();
    private final Rect f11231c = new Rect();
    private final Rect f11232d = new Rect();
    private final Rect f11233e = new Rect();
    private final Rect f11234f = new Rect();
    private final Rect f11235g = new Rect();
    private final Rect f11236h = new Rect();
    private final Rect f11237i = new Rect();
    private final float f11238j;

    public elx(Context context, float f) {
        this.f11229a = context.getApplicationContext();
        this.f11238j = f;
    }

    private void m17165a(Rect rect, Rect rect2) {
        rect2.set(Dips.pixelsToIntDips((float) rect.left, this.f11229a), Dips.pixelsToIntDips((float) rect.top, this.f11229a), Dips.pixelsToIntDips((float) rect.right, this.f11229a), Dips.pixelsToIntDips((float) rect.bottom, this.f11229a));
    }

    public float getDensity() {
        return this.f11238j;
    }

    void m17167a(int i, int i2) {
        this.f11230b.set(0, 0, i, i2);
        m17165a(this.f11230b, this.f11231c);
    }

    public Rect m17166a() {
        return this.f11231c;
    }

    void m17168a(int i, int i2, int i3, int i4) {
        this.f11232d.set(i, i2, i + i3, i2 + i4);
        m17165a(this.f11232d, this.f11233e);
    }

    public Rect m17169b() {
        return this.f11232d;
    }

    public Rect m17171c() {
        return this.f11233e;
    }

    void m17170b(int i, int i2, int i3, int i4) {
        this.f11234f.set(i, i2, i + i3, i2 + i4);
        m17165a(this.f11234f, this.f11235g);
    }

    public Rect m17173d() {
        return this.f11234f;
    }

    public Rect m17174e() {
        return this.f11235g;
    }

    void m17172c(int i, int i2, int i3, int i4) {
        this.f11236h.set(i, i2, i + i3, i2 + i4);
        m17165a(this.f11236h, this.f11237i);
    }

    public Rect m17175f() {
        return this.f11236h;
    }

    public Rect m17176g() {
        return this.f11237i;
    }
}
