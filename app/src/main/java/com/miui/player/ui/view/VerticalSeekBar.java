package com.miui.player.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.AbsSeekBar;
import com.miui.player.service.ShakeListener;
import com.miui.player.ui.menu.common.BaseMenuId;
import java.lang.reflect.Method;

public class VerticalSeekBar extends AbsSeekBar {
    private Rect mBounds;
    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    private final Method mSetProgress;
    private Drawable mThumb;

    public interface OnSeekBarChangeListener {
        void onProgressChanged(VerticalSeekBar verticalSeekBar, int i, boolean z);

        void onStartTrackingTouch(VerticalSeekBar verticalSeekBar);

        void onStopTrackingTouch(VerticalSeekBar verticalSeekBar);
    }

    public VerticalSeekBar(Context context) {
        this(context, null);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, 16842875);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mBounds = new Rect();
        Method m = null;
        try {
            m = getClass().getSuperclass().getSuperclass().getDeclaredMethod("setProgress", new Class[]{Integer.TYPE, Boolean.TYPE});
            m.setAccessible(true);
        } catch (Exception e) {
        }
        this.mSetProgress = m;
    }

    protected synchronized void onDraw(Canvas c) {
        Rect bounds = this.mBounds;
        int height = getHeight();
        int width = getWidth();
        Drawable thumb = this.mThumb;
        if (thumb != null) {
            thumb.copyBounds(bounds);
            int thumbWidth = thumb.getIntrinsicWidth();
            int thumbHeight = thumb.getIntrinsicHeight();
            int bottom = height - ((getProgress() * (height - thumbHeight)) / getMax());
            thumb.setBounds(this.mPaddingLeft, bottom - thumbHeight, this.mPaddingLeft + thumbWidth, bottom);
            thumb.draw(c);
            thumb.setBounds(bounds);
        }
        Drawable drawable = getProgressDrawable();
        if (drawable != null) {
            drawable.copyBounds(bounds);
            drawable.setLevel(10000);
            drawable.setBounds(this.mPaddingLeft, (height - this.mPaddingBottom) - ((getProgress() * ((height - this.mPaddingBottom) - this.mPaddingTop)) / getMax()), width - this.mPaddingRight, height - this.mPaddingBottom);
            drawable.draw(c);
            drawable.setBounds(bounds);
        }
    }

    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(this.mThumb.getIntrinsicWidth(), MeasureSpec.getSize(heightMeasureSpec));
    }

    public void setThumb(Drawable thumb) {
        this.mThumb = thumb;
        super.setThumb(thumb);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldw, oldh);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case 0:
                setPressed(true);
                onStartVerticalTrackingTouch();
                trackTouchEvent(event);
                break;
            case 1:
                trackTouchEvent(event);
                onStopVerticalTrackingTouch();
                setPressed(false);
                break;
            case 2:
                trackTouchEvent(event);
                attemptClaimDrag();
                break;
            case 3:
                onStopVerticalTrackingTouch();
                setPressed(false);
                break;
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == 0) {
            KeyEvent newEvent = null;
            switch (event.getKeyCode()) {
                case 19:
                    newEvent = new KeyEvent(0, 22);
                    break;
                case BaseMenuId.RENAME_ALBUM /*20*/:
                    newEvent = new KeyEvent(0, 21);
                    break;
                case BaseMenuId.EDIT_ID3 /*21*/:
                    newEvent = new KeyEvent(0, 20);
                    break;
                case BaseMenuId.CORRECT_ID3 /*22*/:
                    newEvent = new KeyEvent(0, 19);
                    break;
            }
            if (newEvent != null) {
                return newEvent.dispatch(this, null, null);
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        this.mOnSeekBarChangeListener = l;
    }

    void onStartVerticalTrackingTouch() {
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.onStartTrackingTouch(this);
        }
    }

    void onStopVerticalTrackingTouch() {
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    private void trackTouchEvent(MotionEvent event) {
        float scale;
        int height = getHeight();
        int available = (height - getPaddingBottom()) - getPaddingTop();
        int eventY = (int) event.getY();
        if (eventY > height - getPaddingBottom()) {
            scale = 0.0f;
        } else if (eventY < getPaddingTop()) {
            scale = ShakeListener.ACCELATION_FACTOR_X;
        } else {
            scale = ((float) ((height - getPaddingBottom()) - eventY)) / ((float) available);
        }
        setProgressOnMove(((float) getMax()) * scale);
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private void setProgressOnMove(float progress) {
        int oldProgress = getProgress();
        try {
            this.mSetProgress.invoke(this, new Object[]{Integer.valueOf((int) progress), Boolean.valueOf(true)});
        } catch (Exception e) {
            setProgress((int) progress);
        }
        if (oldProgress != getProgress() && this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.onProgressChanged(this, getProgress(), true);
        }
    }
}
