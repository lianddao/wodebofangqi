package com.ushareit.listenit;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.ushareit.listenit.widget.LISTENitViewFlipper;

public class hbs extends SimpleOnGestureListener {
    final LISTENitViewFlipper f15159a;
    final /* synthetic */ LISTENitViewFlipper f15160b;

    public hbs(LISTENitViewFlipper lISTENitViewFlipper, LISTENitViewFlipper lISTENitViewFlipper2) {
        this.f15160b = lISTENitViewFlipper;
        this.f15159a = lISTENitViewFlipper2;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        this.f15159a.f17232f = motionEvent.getX() - motionEvent2.getX();
        this.f15159a.f17239m = this.f15159a.f17232f > 0.0f;
        if (!this.f15159a.f17236j) {
            this.f15159a.f17236j = true;
            this.f15159a.f17240n = true;
            if (this.f15159a.f17231e != null) {
                boolean z;
                this.f15159a.f17231e;
                if (this.f15159a.f17232f > 0.0f) {
                    z = true;
                } else {
                    z = false;
                }
                this.f15159a.f17231e.mo2745a(Boolean.valueOf(z));
            }
        }
        if (this.f15159a.getCurrentView().getLeft() < 0 && !this.f15159a.f17237k) {
            if (this.f15159a.f17231e != null) {
                this.f15159a.f17231e.mo2747b(Boolean.valueOf(true));
            }
            this.f15159a.f17238l = false;
            this.f15159a.f17237k = true;
        } else if (this.f15159a.getCurrentView().getLeft() > 0 && !this.f15159a.f17238l) {
            if (this.f15159a.f17231e != null) {
                this.f15159a.f17231e.mo2747b(Boolean.valueOf(false));
            }
            this.f15159a.f17238l = true;
            this.f15159a.f17237k = false;
        }
        if (this.f15159a.getCurrentView().getLeft() < (-this.f15159a.getWidth()) / 2 && !this.f15159a.f17242p) {
            if (this.f15159a.f17231e != null) {
                this.f15159a.f17231e.mo2748c(Boolean.valueOf(true));
            }
            this.f15159a.f17243q = false;
            this.f15159a.f17241o = false;
            this.f15159a.f17242p = true;
        } else if (this.f15159a.getCurrentView().getLeft() > this.f15159a.getWidth() / 2 && !this.f15159a.f17241o) {
            if (this.f15159a.f17231e != null) {
                this.f15159a.f17231e.mo2748c(Boolean.valueOf(false));
            }
            this.f15159a.f17243q = false;
            this.f15159a.f17241o = true;
            this.f15159a.f17242p = false;
        } else if (((this.f15159a.getCurrentView().getLeft() >= (-this.f15159a.getWidth()) / 2 && this.f15159a.getCurrentView().getLeft() < 0) || (this.f15159a.getCurrentView().getLeft() <= this.f15159a.getWidth() / 2 && this.f15159a.getCurrentView().getLeft() > 0)) && !this.f15159a.f17243q) {
            if (this.f15159a.f17231e != null) {
                this.f15159a.f17231e.mo2748c(null);
            }
            this.f15159a.f17243q = true;
            this.f15159a.f17241o = false;
            this.f15159a.f17242p = false;
        }
        this.f15159a.requestLayout();
        return true;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.f15159a.f17233g = this.f15159a.getCurrentView().getLeft();
        this.f15159a.f17232f = 0.0f;
        this.f15159a.f17240n = true;
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f15159a.f17229c != null) {
            this.f15159a.f17229c.onClick(this.f15159a);
        }
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.f15159a.f17230d != null) {
            this.f15159a.f17230d.onLongClick(this.f15159a);
        }
    }
}
