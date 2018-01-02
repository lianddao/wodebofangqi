package com.ushareit.listenit.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class LISTENitViewPager extends ViewPager {
    public LISTENitViewPager(Context context) {
        super(context);
    }

    public LISTENitViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    public void setCurrentItem(int i) {
        try {
            super.setCurrentItem(i);
        } catch (Exception e) {
        }
    }
}
