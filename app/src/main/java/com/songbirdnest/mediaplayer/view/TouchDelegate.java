package com.songbirdnest.mediaplayer.view;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class TouchDelegate extends android.view.TouchDelegate {
    public static final int ABOVE = 1;
    public static final int BELOW = 2;
    public static final int TO_LEFT = 4;
    public static final int TO_RIGHT = 8;
    public static final int X_ACCURATE = 1;
    public static final int Y_ACCURATE = 2;
    private int mAccuracyFlags = 0;
    private Rect mBounds;
    private boolean mDelegateTargeted;
    private View mDelegateView;
    private int mSlop;
    private Rect mSlopBounds;

    public TouchDelegate(Rect bounds, View delegateView, int aAccuracyFlags) {
        super(bounds, delegateView);
        this.mBounds = bounds;
        this.mSlop = ViewConfiguration.get(delegateView.getContext()).getScaledTouchSlop();
        this.mSlopBounds = new Rect(bounds);
        this.mSlopBounds.inset(-this.mSlop, -this.mSlop);
        this.mDelegateView = delegateView;
        this.mAccuracyFlags = aAccuracyFlags;
    }

    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        boolean sendToDelegate = false;
        boolean hit = true;
        switch (event.getAction()) {
            case 0:
                if (this.mBounds.contains(x, y)) {
                    this.mDelegateTargeted = true;
                    sendToDelegate = true;
                    break;
                }
                break;
            case 1:
            case 2:
                sendToDelegate = this.mDelegateTargeted;
                if (sendToDelegate && !this.mSlopBounds.contains(x, y)) {
                    hit = false;
                    break;
                }
            case 3:
                sendToDelegate = this.mDelegateTargeted;
                this.mDelegateTargeted = false;
                break;
        }
        if (!sendToDelegate) {
            return false;
        }
        View delegateView = this.mDelegateView;
        if (hit) {
            int accurateX = delegateView.getWidth() / 2;
            int accurateY = delegateView.getHeight() / 2;
            if ((this.mAccuracyFlags & 1) > 0) {
                accurateX = x;
            }
            if ((this.mAccuracyFlags & 2) > 0) {
                accurateY = y;
            }
            event.setLocation((float) accurateX, (float) accurateY);
        } else {
            int slop = this.mSlop;
            event.setLocation((float) (-(slop * 2)), (float) (-(slop * 2)));
        }
        return delegateView.dispatchTouchEvent(event);
    }
}
