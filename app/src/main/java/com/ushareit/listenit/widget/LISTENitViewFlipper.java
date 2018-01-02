package com.ushareit.listenit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import android.widget.ViewFlipper;
import com.ushareit.listenit.hbs;
import com.ushareit.listenit.hbt;
import com.ushareit.listenit.hbu;
import com.ushareit.listenit.hbv;

public class LISTENitViewFlipper extends ViewFlipper {
    private GestureDetector f17227a = new GestureDetector(getContext(), this.f17249w);
    private Scroller f17228b = new Scroller(getContext(), new DecelerateInterpolator());
    private OnClickListener f17229c;
    private OnLongClickListener f17230d;
    private hbv f17231e;
    private float f17232f = 0.0f;
    private int f17233g = 0;
    private int f17234h = -1;
    private boolean f17235i = false;
    private boolean f17236j = false;
    private boolean f17237k;
    private boolean f17238l;
    private boolean f17239m;
    private boolean f17240n;
    private boolean f17241o;
    private boolean f17242p;
    private boolean f17243q;
    private boolean f17244r;
    private boolean f17245s = true;
    private long f17246t = 0;
    private int f17247u = 0;
    private int f17248v = 300;
    private OnGestureListener f17249w = new hbs(this, this);

    public LISTENitViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setGestureEnable(boolean z) {
        this.f17245s = z;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f17229c = onClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.f17230d = onLongClickListener;
    }

    public void setOnPlayerDiscListener(hbv com_ushareit_listenit_hbv) {
        this.f17231e = com_ushareit_listenit_hbv;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f17245s) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f17235i = true;
            this.f17246t = System.currentTimeMillis();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (!(this.f17232f == 0.0f && this.f17240n)) {
                this.f17247u++;
            }
            this.f17235i = false;
            this.f17243q = false;
            this.f17241o = false;
            this.f17242p = false;
            this.f17237k = false;
            this.f17238l = false;
            this.f17236j = false;
            float currentTimeMillis = this.f17232f / ((float) (System.currentTimeMillis() - this.f17246t));
            this.f17232f = 0.0f;
            int left = getCurrentView().getLeft();
            if (left > getMeasuredWidth() / 2 || ((double) currentTimeMillis) < -1.0d) {
                this.f17234h = getDisplayedChild() + 1;
                if (this.f17244r) {
                    this.f17228b.startScroll(left, 0, getMeasuredWidth() - getCurrentView().getLeft(), 0, this.f17248v);
                }
            } else if (left > 0) {
                if (this.f17244r) {
                    this.f17228b.startScroll(left, 0, -getCurrentView().getLeft(), 0, this.f17248v);
                }
            } else if (left < (-getMeasuredWidth()) / 2 || ((double) currentTimeMillis) > 1.0d) {
                this.f17234h = getDisplayedChild() + 1;
                if (this.f17244r) {
                    this.f17228b.startScroll(left, 0, (-getMeasuredWidth()) - left, 0, this.f17248v);
                }
            } else if (left < 0 && this.f17244r) {
                this.f17228b.startScroll(left, 0, -left, 0, this.f17248v);
            }
            requestLayout();
        }
        boolean isFinished = this.f17228b.isFinished();
        if (motionEvent.getAction() == 0) {
            this.f17244r = isFinished;
        }
        if (isFinished) {
            if (!this.f17244r) {
                this.f17244r = true;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                this.f17227a.onTouchEvent(obtain);
            }
            this.f17227a.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int currX;
        boolean z2 = false;
        if (this.f17228b.computeScrollOffset()) {
            currX = this.f17228b.getCurrX();
        } else {
            currX = (int) (((float) this.f17233g) - this.f17232f);
        }
        if (currX <= (-getMeasuredWidth()) && this.f17239m) {
            currX = -getMeasuredWidth();
        }
        int measuredWidth = getMeasuredWidth() + currX;
        getCurrentView().layout(currX, 0, measuredWidth, getMeasuredHeight());
        int measuredWidth2 = getMeasuredWidth() + measuredWidth;
        if (this.f17239m) {
            currX = measuredWidth;
            measuredWidth = measuredWidth2;
        } else {
            currX -= getMeasuredWidth();
            if (currX > 0) {
                currX = 0;
            }
            measuredWidth = getMeasuredWidth() + currX;
        }
        if (currX < getMeasuredWidth() || currX > 0) {
            View nextView = getNextView();
            nextView.setVisibility(0);
            nextView.layout(currX, 0, measuredWidth, getMeasuredHeight());
        }
        if (this.f17228b.isFinished()) {
            if (this.f17234h != -1) {
                setDisplayedChild(this.f17234h);
                this.f17234h = -1;
                z2 = true;
            }
            if (this.f17247u > 0) {
                if (this.f17231e != null) {
                    post(new hbu(this, this, z2));
                }
                this.f17247u--;
                return;
            }
            return;
        }
        post(new hbt(this, this));
    }

    public void m26850a(boolean z) {
        boolean z2 = true;
        if (!this.f17228b.isFinished()) {
            this.f17228b.forceFinished(true);
            if (this.f17247u > 0) {
                if (this.f17231e != null) {
                    this.f17231e.mo2746a(false, false, z);
                }
                this.f17247u--;
            }
        }
        if (this.f17231e != null) {
            hbv com_ushareit_listenit_hbv = this.f17231e;
            if (this.f17232f <= 0.0f) {
                z2 = false;
            }
            com_ushareit_listenit_hbv.mo2745a(Boolean.valueOf(z2));
        }
        if (this.f17231e != null) {
            this.f17231e.mo2747b(null);
        }
        this.f17239m = z;
        this.f17240n = false;
        this.f17234h = getDisplayedChild() + 1;
        this.f17247u++;
        this.f17228b.startScroll(0, 0, z ? -getWidth() : getWidth(), 0, this.f17248v);
        requestLayout();
    }

    public View getNextView() {
        return getChildAt(1) == getCurrentView() ? getChildAt(0) : getChildAt(1);
    }

    public void setScrollDuration(int i) {
        this.f17248v = i;
    }
}
