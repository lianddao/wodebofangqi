package com.ushareit.listenit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.ArrayList;

public class ot extends Drawable implements Animatable {
    private static final Interpolator f16065b = new LinearInterpolator();
    private static final Interpolator f16066c = new nv();
    boolean f16067a;
    private final int[] f16068d = new int[]{CtaButton.BACKGROUND_COLOR};
    private final ArrayList<Animation> f16069e = new ArrayList();
    private final ox f16070f;
    private float f16071g;
    private Resources f16072h;
    private View f16073i;
    private Animation f16074j;
    private float f16075k;
    private double f16076l;
    private double f16077m;
    private final Callback f16078n = new ow(this);

    public ot(Context context, View view) {
        this.f16073i = view;
        this.f16072h = context.getResources();
        this.f16070f = new ox(this.f16078n);
        this.f16070f.m25392a(this.f16068d);
        m25374a(1);
        m25369b();
    }

    private void m25366a(double d, double d2, double d3, double d4, float f, float f2) {
        ox oxVar = this.f16070f;
        float f3 = this.f16072h.getDisplayMetrics().density;
        this.f16076l = ((double) f3) * d;
        this.f16077m = ((double) f3) * d2;
        oxVar.m25385a(((float) d4) * f3);
        oxVar.m25384a(((double) f3) * d3);
        oxVar.m25398c(0);
        oxVar.m25386a(f * f3, f3 * f2);
        oxVar.m25388a((int) this.f16076l, (int) this.f16077m);
    }

    public void m25374a(int i) {
        if (i == 0) {
            m25366a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m25366a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void m25375a(boolean z) {
        this.f16070f.m25391a(z);
    }

    public void m25372a(float f) {
        this.f16070f.m25403e(f);
    }

    public void m25373a(float f, float f2) {
        this.f16070f.m25394b(f);
        this.f16070f.m25397c(f2);
    }

    public void m25377b(float f) {
        this.f16070f.m25400d(f);
    }

    public void m25378b(int i) {
        this.f16070f.m25387a(i);
    }

    public void m25376a(int... iArr) {
        this.f16070f.m25392a(iArr);
        this.f16070f.m25398c(0);
    }

    public int getIntrinsicHeight() {
        return (int) this.f16077m;
    }

    public int getIntrinsicWidth() {
        return (int) this.f16076l;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f16071g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f16070f.m25389a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.f16070f.m25401d(i);
    }

    public int getAlpha() {
        return this.f16070f.m25396c();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f16070f.m25390a(colorFilter);
    }

    void m25379c(float f) {
        this.f16071g = f;
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.f16069e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.f16074j.reset();
        this.f16070f.m25410l();
        if (this.f16070f.m25407i() != this.f16070f.m25402e()) {
            this.f16067a = true;
            this.f16074j.setDuration(666);
            this.f16073i.startAnimation(this.f16074j);
            return;
        }
        this.f16070f.m25398c(0);
        this.f16070f.m25411m();
        this.f16074j.setDuration(1332);
        this.f16073i.startAnimation(this.f16074j);
    }

    public void stop() {
        this.f16073i.clearAnimation();
        m25379c(0.0f);
        this.f16070f.m25391a(false);
        this.f16070f.m25398c(0);
        this.f16070f.m25411m();
    }

    private float m25363a(ox oxVar) {
        return (float) Math.toRadians(((double) oxVar.m25399d()) / (6.283185307179586d * oxVar.m25408j()));
    }

    private int m25364a(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        intValue &= 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (intValue + ((int) (((float) ((intValue2 & 255) - intValue)) * f))) | ((((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16)) | ((((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f)) + i5) << 8));
    }

    private void m25367a(float f, ox oxVar) {
        if (f > 0.75f) {
            oxVar.m25395b(m25364a((f - 0.75f) / 0.25f, oxVar.m25406h(), oxVar.m25383a()));
        }
    }

    private void m25370b(float f, ox oxVar) {
        m25367a(f, oxVar);
        float floor = (float) (Math.floor((double) (oxVar.m25409k() / 0.8f)) + 1.0d);
        float a = m25363a(oxVar);
        oxVar.m25394b((((oxVar.m25405g() - a) - oxVar.m25404f()) * f) + oxVar.m25404f());
        oxVar.m25397c(oxVar.m25405g());
        oxVar.m25400d(((floor - oxVar.m25409k()) * f) + oxVar.m25409k());
    }

    private void m25369b() {
        ox oxVar = this.f16070f;
        Animation ouVar = new ou(this, oxVar);
        ouVar.setRepeatCount(-1);
        ouVar.setRepeatMode(1);
        ouVar.setInterpolator(f16065b);
        ouVar.setAnimationListener(new ov(this, oxVar));
        this.f16074j = ouVar;
    }
}
