package com.ushareit.listenit.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.exw;

public class CustomViewPager extends ViewPager {
    private int f17201a = 0;
    private Context f17202b;

    public CustomViewPager(Context context) {
        super(context);
        this.f17202b = context;
        m26810a(context);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17202b = context;
        m26810a(context);
    }

    private void m26810a(Context context) {
        this.f17201a = (int) context.getResources().getDimension(C0349R.dimen.common_dimens_40dp);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        boolean z2 = false;
        exw.m18443a("CustomViewPager", "onInterceptTouchEvent: count=" + getAdapter().mo2352b());
        if (getAdapter().mo2352b() == 1) {
            return z2;
        }
        if (VERSION.SDK_INT >= 14) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e) {
                return z2;
            }
        } else if (motionEvent.getAction() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        } else {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if (!(m26811b(motionEvent.getX()) && onInterceptTouchEvent)) {
                z = z2;
            }
            return z;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean m26811b(float f) {
        if (this.f17201a <= 0) {
            m26810a(this.f17202b);
        }
        return f < ((float) this.f17201a);
    }
}
