package com.miui.player.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import java.lang.reflect.Field;

public class ExtendScrollView extends ScrollView implements Runnable {
    private OnExtendScrollListener mExtendScroller;
    private boolean mIsNeedFling = true;
    private int mLastOldT = -1;
    private int mLastT = -1;
    private int mScrollY = -1;

    public interface OnExtendScrollListener {
        void onScroll(int i);

        void onTouchEventEnd();

        void onTouchEventStart();
    }

    public ExtendScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        try {
            Class<?> cls = getClass().getSuperclass();
            Field overscrollDistanceField = cls.getDeclaredField("mOverscrollDistance");
            overscrollDistanceField.setAccessible(true);
            overscrollDistanceField.set(this, Integer.valueOf(0));
            Field overflingDistanceField = cls.getDeclaredField("mOverflingDistance");
            overflingDistanceField.setAccessible(true);
            overflingDistanceField.set(this, Integer.valueOf(0));
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e2) {
        } catch (IllegalAccessException e3) {
        }
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        View child = getChildAt(0);
        if (child != null) {
            child.setMinimumHeight(h);
        }
    }

    public void setNeedFling(boolean isNeedFling) {
        this.mIsNeedFling = isNeedFling;
    }

    public void fling(int velocityY) {
        if (this.mIsNeedFling) {
            super.fling(velocityY);
        }
    }

    public void setOnExtendScrollListener(OnExtendScrollListener l) {
        this.mExtendScroller = l;
    }

    public void reset() {
        getChildAt(0).setVisibility(4);
        this.mScrollY = -1;
        postDelayed(this, 1000);
    }

    public void scrollY(int y) {
        if (getChildAt(0).getVisibility() == 4) {
            this.mScrollY = y;
            post(this);
            return;
        }
        scrollTo(getScrollX(), y);
    }

    public void run() {
        getChildAt(0).setVisibility(0);
        if (this.mScrollY >= 0) {
            scrollTo(getScrollX(), this.mScrollY);
            this.mScrollY = -1;
        }
        removeCallbacks(this);
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (!((this.mLastT == t && this.mLastOldT == oldt) || t == oldt || this.mExtendScroller == null)) {
            this.mExtendScroller.onScroll(oldt - t);
        }
        this.mLastT = t;
        this.mLastOldT = oldt;
    }

    private void handleTouchEvent(int actionEvent) {
        if (this.mExtendScroller != null) {
            if (actionEvent == 0 || actionEvent == 2) {
                this.mExtendScroller.onTouchEventStart();
            } else if (actionEvent == 1 || actionEvent == 3) {
                this.mExtendScroller.onTouchEventEnd();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean returnValue = super.onInterceptTouchEvent(ev);
        handleTouchEvent(ev.getAction());
        return returnValue;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        boolean returnValue = super.onTouchEvent(ev);
        if (returnValue) {
            handleTouchEvent(ev.getAction());
        }
        return returnValue;
    }
}
