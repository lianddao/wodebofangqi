package com.ushareit.listenit;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.mopub.volley.DefaultRetryPolicy;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ery extends Animation {
    public static final boolean f11646a = (Integer.valueOf(VERSION.SDK).intValue() < 11);
    private static final WeakHashMap<View, ery> f11647b = new WeakHashMap();
    private final WeakReference<View> f11648c;
    private final Camera f11649d = new Camera();
    private boolean f11650e;
    private float f11651f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f11652g;
    private float f11653h;
    private float f11654i;
    private float f11655j;
    private float f11656k;
    private float f11657l = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f11658m = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f11659n;
    private float f11660o;
    private final RectF f11661p = new RectF();
    private final RectF f11662q = new RectF();
    private final Matrix f11663r = new Matrix();

    public static ery m17650a(View view) {
        Animation animation = (ery) f11647b.get(view);
        if (animation != null && animation == view.getAnimation()) {
            return animation;
        }
        ery com_ushareit_listenit_ery = new ery(view);
        f11647b.put(view, com_ushareit_listenit_ery);
        return com_ushareit_listenit_ery;
    }

    private ery(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f11648c = new WeakReference(view);
    }

    public float m17655a() {
        return this.f11651f;
    }

    public void m17656a(float f) {
        if (this.f11651f != f) {
            this.f11651f = f;
            View view = (View) this.f11648c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public float m17658b() {
        return this.f11652g;
    }

    public void m17659b(float f) {
        if (!this.f11650e || this.f11652g != f) {
            m17653o();
            this.f11650e = true;
            this.f11652g = f;
            m17654p();
        }
    }

    public float m17661c() {
        return this.f11653h;
    }

    public void m17662c(float f) {
        if (!this.f11650e || this.f11653h != f) {
            m17653o();
            this.f11650e = true;
            this.f11653h = f;
            m17654p();
        }
    }

    public float m17663d() {
        return this.f11656k;
    }

    public void m17664d(float f) {
        if (this.f11656k != f) {
            m17653o();
            this.f11656k = f;
            m17654p();
        }
    }

    public float m17665e() {
        return this.f11654i;
    }

    public void m17666e(float f) {
        if (this.f11654i != f) {
            m17653o();
            this.f11654i = f;
            m17654p();
        }
    }

    public float m17667f() {
        return this.f11655j;
    }

    public void m17668f(float f) {
        if (this.f11655j != f) {
            m17653o();
            this.f11655j = f;
            m17654p();
        }
    }

    public float m17669g() {
        return this.f11657l;
    }

    public void m17670g(float f) {
        if (this.f11657l != f) {
            m17653o();
            this.f11657l = f;
            m17654p();
        }
    }

    public float m17671h() {
        return this.f11658m;
    }

    public void m17672h(float f) {
        if (this.f11658m != f) {
            m17653o();
            this.f11658m = f;
            m17654p();
        }
    }

    public int m17673i() {
        View view = (View) this.f11648c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public void m17657a(int i) {
        View view = (View) this.f11648c.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    public int m17675j() {
        View view = (View) this.f11648c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public void m17660b(int i) {
        View view = (View) this.f11648c.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    public float m17677k() {
        return this.f11659n;
    }

    public void m17674i(float f) {
        if (this.f11659n != f) {
            m17653o();
            this.f11659n = f;
            m17654p();
        }
    }

    public float m17679l() {
        return this.f11660o;
    }

    public void m17676j(float f) {
        if (this.f11660o != f) {
            m17653o();
            this.f11660o = f;
            m17654p();
        }
    }

    public float m17681m() {
        View view = (View) this.f11648c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.f11659n;
    }

    public void m17678k(float f) {
        View view = (View) this.f11648c.get();
        if (view != null) {
            m17674i(f - ((float) view.getLeft()));
        }
    }

    public float m17682n() {
        View view = (View) this.f11648c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.f11660o;
    }

    public void m17680l(float f) {
        View view = (View) this.f11648c.get();
        if (view != null) {
            m17676j(f - ((float) view.getTop()));
        }
    }

    private void m17653o() {
        View view = (View) this.f11648c.get();
        if (view != null) {
            m17652a(this.f11661p, view);
        }
    }

    private void m17654p() {
        View view = (View) this.f11648c.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.f11662q;
            m17652a(rectF, view);
            rectF.union(this.f11661p);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    private void m17652a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f11663r;
        matrix.reset();
        m17651a(matrix, view);
        this.f11663r.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            f = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f;
        }
    }

    private void m17651a(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.f11650e;
        float f = z ? this.f11652g : width / 2.0f;
        float f2 = z ? this.f11653h : height / 2.0f;
        float f3 = this.f11654i;
        float f4 = this.f11655j;
        float f5 = this.f11656k;
        if (!(f3 == 0.0f && f4 == 0.0f && f5 == 0.0f)) {
            Camera camera = this.f11649d;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        f3 = this.f11657l;
        f4 = this.f11658m;
        if (!(f3 == DefaultRetryPolicy.DEFAULT_BACKOFF_MULT && f4 == DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)) {
            matrix.postScale(f3, f4);
            matrix.postTranslate((-(f / width)) * ((f3 * width) - width), (-(f2 / height)) * ((f4 * height) - height));
        }
        matrix.postTranslate(this.f11659n, this.f11660o);
    }

    protected void applyTransformation(float f, Transformation transformation) {
        View view = (View) this.f11648c.get();
        if (view != null) {
            transformation.setAlpha(this.f11651f);
            m17651a(transformation.getMatrix(), view);
        }
    }
}
