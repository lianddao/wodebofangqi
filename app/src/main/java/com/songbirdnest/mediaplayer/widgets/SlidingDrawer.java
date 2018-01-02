package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SlidingDrawer extends android.widget.SlidingDrawer {
    private Rect childHitRect;
    private int[] screenCoords;

    public SlidingDrawer(Context aContext, AttributeSet aAttrs) {
        super(aContext, aAttrs);
        this.childHitRect = new Rect();
        this.screenCoords = new int[2];
    }

    public SlidingDrawer(Context aContext, AttributeSet aAttrs, int aDefStyle) {
        super(aContext, aAttrs, aDefStyle);
        this.childHitRect = new Rect();
        this.screenCoords = new int[2];
    }

    public boolean onInterceptTouchEvent(MotionEvent aMotionEvent) {
        if (processTouchEvent(aMotionEvent, null)) {
            return false;
        }
        return super.onInterceptTouchEvent(aMotionEvent);
    }

    private boolean processTouchEvent(MotionEvent aMotionEvent, ViewGroup aViewGroup) {
        int x = (int) aMotionEvent.getRawX();
        int y = (int) aMotionEvent.getRawY();
        if (aViewGroup == null) {
            aViewGroup = (ViewGroup) getHandle();
        }
        int childCount = aViewGroup.getChildCount();
        for (int current = 0; current < childCount; current++) {
            View child = aViewGroup.getChildAt(current);
            try {
                if (processTouchEvent(aMotionEvent, (ViewGroup) child)) {
                    return true;
                }
            } catch (Exception e) {
            }
            if (child.getVisibility() == 0 && (child.isFocusable() || child.isClickable() || child.isFocusableInTouchMode())) {
                child.getHitRect(this.childHitRect);
                child.getLocationOnScreen(this.screenCoords);
                if (this.childHitRect.contains(x - (this.screenCoords[0] - this.childHitRect.left), y - (this.screenCoords[1] - this.childHitRect.top))) {
                    return true;
                }
            }
        }
        return false;
    }
}
