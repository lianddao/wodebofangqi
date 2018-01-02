package com.ushareit.listenit.lockscreen.view;

import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.gdm;
import com.ushareit.listenit.gdn;
import com.ushareit.listenit.gdo;
import com.ushareit.listenit.gdp;
import com.ushareit.listenit.ja;
import com.ushareit.listenit.qb;
import com.ushareit.listenit.qe;

public class VerticalDragLayout extends FrameLayout {
    private qb f15737a;
    private int f15738b;
    private View f15739c;
    private View f15740d;
    private int f15741e;
    private int f15742f;
    private float f15743g;
    private boolean f15744h;
    private boolean f15745i;
    private float f15746j;
    private boolean f15747k;
    private int f15748l;
    private int f15749m;
    private int f15750n;
    private boolean f15751o;
    private boolean f15752p;
    private boolean f15753q;
    private boolean f15754r;
    private float f15755s;
    private gdp f15756t;
    private gdo f15757u;
    private qe f15758v;

    class SavedState extends BaseSavedState {
        int f15736a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public VerticalDragLayout(Context context) {
        this(context, null);
    }

    public VerticalDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalDragLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15745i = true;
        this.f15746j = 1.5f;
        this.f15747k = true;
        this.f15749m = -1;
        this.f15750n = -1;
        this.f15751o = true;
        this.f15752p = false;
        this.f15753q = false;
        this.f15754r = false;
        this.f15755s = Float.MAX_VALUE;
        this.f15756t = gdp.EXPANDED;
        this.f15758v = new gdn(this);
        m24590a(attributeSet);
    }

    private void m24590a(AttributeSet attributeSet) {
        this.f15737a = qb.m25667a((ViewGroup) this, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, this.f15758v);
        m24601e(true);
    }

    public void setCanDragBottom(boolean z) {
        this.f15752p = z;
    }

    private void m24601e(boolean z) {
        if (z) {
            this.f15756t = gdp.EXPANDED;
        } else {
            this.f15756t = gdp.COLLAPSED;
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) {
            throw new RuntimeException("Content view must contains two child views at least.");
        } else if (this.f15749m != -1 && this.f15750n == -1) {
            throw new IllegalArgumentException("You have set \"dtlTopView\" but not \"dtlDragContentView\". Both are required!");
        } else if (this.f15750n != -1 && this.f15749m == -1) {
            throw new IllegalArgumentException("You have set \"dtlDragContentView\" but not \"dtlTopView\". Both are required!");
        } else if (this.f15750n == -1 || this.f15749m == -1) {
            this.f15740d = getChildAt(0);
            this.f15739c = getChildAt(1);
        } else {
            m24591a((View) this);
        }
    }

    private void m24591a(View view) {
        this.f15740d = view.findViewById(this.f15749m);
        this.f15739c = view.findViewById(this.f15750n);
        if (this.f15740d == null) {
            throw new IllegalArgumentException("\"dtlTopView\" with id = \"@id/" + getResources().getResourceEntryName(this.f15749m) + "\" has NOT been found. Is a child with that id in this " + getClass().getSimpleName() + "?");
        } else if (this.f15739c == null) {
            throw new IllegalArgumentException("\"dtlDragContentView\" with id = \"@id/" + getResources().getResourceEntryName(this.f15750n) + "\" has NOT been found. Is a child with that id in this " + getClass().getSimpleName() + "?");
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f15738b = getHeight();
        int i5 = this.f15741e;
        m24595b();
        m24597c();
        this.f15740d.layout(i, Math.min(this.f15740d.getPaddingTop(), this.f15741e - this.f15742f), i3, this.f15741e);
        this.f15739c.layout(i, i5, i3, this.f15739c.getHeight() + i5);
    }

    private void m24595b() {
        int height = this.f15740d.getHeight();
        if (this.f15742f != height) {
            if (this.f15756t == gdp.EXPANDED) {
                this.f15741e = height;
                m24589a(height);
            } else if (this.f15756t == gdp.COLLAPSED) {
                this.f15741e = this.f15748l;
            }
            this.f15742f = height;
        }
    }

    private void m24597c() {
        if (this.f15739c != null && this.f15739c.getHeight() != 0) {
            LayoutParams layoutParams = this.f15739c.getLayoutParams();
            layoutParams.height = getHeight() - this.f15748l;
            this.f15739c.setLayoutParams(layoutParams);
        }
    }

    private void m24589a(int i) {
        new Handler().post(new gdm(this, i));
    }

    private void m24593a(boolean z, int i) {
        this.f15741e = i;
        if (z) {
            this.f15737a.m25691a(this.f15739c, getPaddingLeft(), this.f15741e);
            postInvalidate();
            return;
        }
        requestLayout();
    }

    private void m24588a(float f) {
        this.f15743g = (f - ((float) this.f15748l)) / ((float) (this.f15742f - this.f15748l));
        if (this.f15754r) {
            m24600e();
        }
        if (this.f15757u != null) {
            this.f15757u.mo2650a(this.f15743g);
            if (this.f15743g > this.f15746j && !this.f15744h) {
                this.f15744h = true;
                this.f15757u.mo2649a();
            }
        }
    }

    private void m24598d() {
        if (this.f15741e <= getPaddingTop() + this.f15748l) {
            this.f15756t = gdp.COLLAPSED;
        } else if (this.f15741e >= this.f15740d.getHeight()) {
            this.f15756t = gdp.EXPANDED;
        } else {
            this.f15756t = gdp.SLIDING;
        }
        if (this.f15757u != null) {
            this.f15757u.mo2651a(this.f15756t);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15736a = this.f15756t.m21765a();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f15756t = gdp.m21764a(savedState.f15736a);
            if (this.f15756t == gdp.COLLAPSED) {
                m24612b(false);
                return;
            } else {
                m24611a(false);
                return;
            }
        }
        super.onRestoreInstanceState(BaseSavedState.EMPTY_STATE);
    }

    public void computeScroll() {
        if (this.f15737a.m25692a(true)) {
            ja.m24153d(this);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f15737a.m25690a(motionEvent);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        exw.m18454c("dzt__", " Child onTouchEvent action = " + motionEvent.getAction() + " result:" + false);
        this.f15737a.m25694b(motionEvent);
        return true;
    }

    private void m24600e() {
        this.f15753q = false;
        this.f15754r = false;
        this.f15755s = Float.MAX_VALUE;
    }

    public gdp getState() {
        return this.f15756t;
    }

    public void m24611a(boolean z) {
        if (this.f15739c.getHeight() == 0) {
            this.f15756t = gdp.EXPANDED;
            if (this.f15757u != null) {
                this.f15757u.mo2650a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                return;
            }
            return;
        }
        m24593a(z, this.f15742f);
    }

    public void m24612b(boolean z) {
        if (this.f15739c.getHeight() == 0) {
            this.f15756t = gdp.COLLAPSED;
            if (this.f15757u != null) {
                this.f15757u.mo2650a(0.0f);
                return;
            }
            return;
        }
        m24593a(z, getPaddingTop() + this.f15748l);
    }

    public VerticalDragLayout m24613c(boolean z) {
        this.f15745i = z;
        return this;
    }

    public VerticalDragLayout m24609a(gdo com_ushareit_listenit_gdo) {
        this.f15757u = com_ushareit_listenit_gdo;
        return this;
    }

    public VerticalDragLayout m24614d(boolean z) {
        this.f15747k = z;
        return this;
    }

    public void setmIsRefreshing(boolean z) {
        this.f15744h = z;
    }

    public int getmCollapseOffset() {
        return this.f15748l;
    }

    public void m24610a() {
        this.f15757u = null;
    }
}
