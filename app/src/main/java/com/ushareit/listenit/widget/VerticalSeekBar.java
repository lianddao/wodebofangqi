package com.ushareit.listenit.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.mopub.mobileads.resource.DrawableConstants.RadialCountdown;

public class VerticalSeekBar extends SeekBar {
    private int f17404a = 0;
    private OnSeekBarChangeListener f17405b;

    public VerticalSeekBar(Context context) {
        super(context);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    protected void onDraw(Canvas canvas) {
        canvas.rotate(RadialCountdown.START_ANGLE);
        canvas.translate((float) (-getHeight()), 0.0f);
        super.onDraw(canvas);
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        this.f17405b = onSeekBarChangeListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f17405b.onStartTrackingTouch(this);
                setPressed(true);
                setSelected(true);
                break;
            case 1:
                this.f17405b.onStopTrackingTouch(this);
                setPressed(false);
                setSelected(false);
                break;
            case 2:
                super.onTouchEvent(motionEvent);
                int max = getMax() - ((int) ((((float) getMax()) * motionEvent.getY()) / ((float) getHeight())));
                if (max > getMax()) {
                    max = getMax();
                } else if (max < 0) {
                    max = 0;
                }
                setProgress(max);
                if (max != this.f17404a) {
                    this.f17404a = max;
                    this.f17405b.onProgressChanged(this, max, true);
                }
                onSizeChanged(getWidth(), getHeight(), 0, 0);
                setPressed(true);
                setSelected(true);
                break;
            case 3:
                super.onTouchEvent(motionEvent);
                setPressed(false);
                setSelected(false);
                break;
        }
        return true;
    }

    public synchronized void setProgressAndThumb(int i) {
        setProgress(i);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        if (i != this.f17404a) {
            this.f17404a = i;
            this.f17405b.onProgressChanged(this, i, true);
        }
    }

    public synchronized void setMaximum(int i) {
        setMax(i);
    }

    public synchronized int getMaximum() {
        return getMax();
    }
}
