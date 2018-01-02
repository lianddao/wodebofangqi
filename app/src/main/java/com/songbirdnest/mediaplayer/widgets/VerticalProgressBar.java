package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.util.Logger;

public class VerticalProgressBar extends SeekBar {
    private static final int MAX_LEVEL = 10000;
    public static final int THUMB_PADDING = 8;
    static Paint greenLine = new Paint();
    static Paint middleLine = new Paint();
    static Paint normalBottomLine = new Paint();
    static Paint normalTopLine = new Paint();
    static Paint redLine = new Paint();
    private Context context;
    private boolean debugging = false;
    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private int middleSnapPoint;
    private int minHeight = -1;
    private int minWidth = -1;
    private int thumbHeight;
    private int thumbWidth;
    private float tickLineDistance;

    static {
        normalTopLine.setARGB(MotionEventCompat.ACTION_MASK, 102, 105, 117);
        normalTopLine.setStyle(Style.STROKE);
        normalTopLine.setStrokeWidth(1.0f);
        normalBottomLine.setARGB(MotionEventCompat.ACTION_MASK, 30, 32, 34);
        normalBottomLine.setStyle(Style.STROKE);
        normalBottomLine.setStrokeWidth(1.0f);
        middleLine.setARGB(MotionEventCompat.ACTION_MASK, 94, 95, 101);
        middleLine.setStyle(Style.STROKE);
        middleLine.setStrokeWidth(1.0f);
        redLine.setARGB(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, 0, 0);
        redLine.setStyle(Style.STROKE);
        redLine.setStrokeWidth(1.0f);
        greenLine.setARGB(MotionEventCompat.ACTION_MASK, 0, MotionEventCompat.ACTION_MASK, 0);
        greenLine.setStyle(Style.STROKE);
        greenLine.setStrokeWidth(1.0f);
    }

    public VerticalProgressBar(Context context) {
        super(context);
        this.context = context;
    }

    public VerticalProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public VerticalProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        this.mOnSeekBarChangeListener = l;
    }

    public void setThumb(Drawable thumb) {
        Rect bounds;
        int width = thumb.getIntrinsicWidth();
        if (width != -1) {
            this.thumbWidth = width;
        } else {
            bounds = thumb.getBounds();
            if (bounds.width() > 0) {
                this.thumbWidth = bounds.width();
            }
        }
        int height = thumb.getIntrinsicHeight();
        if (height != -1) {
            this.thumbHeight = height;
        } else {
            bounds = thumb.getBounds();
            if (bounds.width() > 0) {
                this.thumbHeight = bounds.height();
            }
        }
        invalidate();
        super.setThumb(thumb);
        setThumbOffset(thumb.getIntrinsicHeight());
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public void setThumbHeight(int thumbHeight) {
        this.thumbHeight = thumbHeight;
    }

    public void setThumbWidth(int thumbWidth) {
        this.thumbWidth = thumbWidth;
    }

    private Drawable getSuperDrawable() {
        return (Drawable) Utils.getField(this, "mCurrentDrawable");
    }

    private int getSuperThumbOffset() {
        return ((Integer) Utils.getField(this, "mThumbOffset")).intValue();
    }

    private Drawable getSuperThumb() {
        return (Drawable) Utils.getField(this, "mThumb");
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.rotate(-90.0f);
        canvas.translate((float) (-getHeight()), 0.0f);
        int max = getMax();
        int level = (int) (10000.0f * (max > 0 ? ((float) getProgress()) / ((float) max) : 0.0f));
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int halfThumbHeight = this.thumbHeight / 2;
        float yStartPoint = 8.0f;
        int thumbPadding = 8;
        if ((getWidth() - getPaddingRight()) - getPaddingLeft() <= this.thumbWidth + 16) {
            thumbPadding = 0;
            yStartPoint = 0.0f;
        }
        this.middleSnapPoint = (height / 2) + halfThumbHeight;
        canvas.drawLine((float) this.middleSnapPoint, yStartPoint, (float) this.middleSnapPoint, yStartPoint + ((float) this.thumbWidth), middleLine);
        canvas.drawLine((float) (this.middleSnapPoint + 1), yStartPoint, (float) (this.middleSnapPoint + 1), yStartPoint + ((float) this.thumbWidth), middleLine);
        canvas.drawLine((float) (this.middleSnapPoint + 2), yStartPoint, (float) (this.middleSnapPoint + 2), yStartPoint + ((float) this.thumbWidth), middleLine);
        this.tickLineDistance = (float) (((this.middleSnapPoint - halfThumbHeight) - getPaddingBottom()) / 5);
        float yPos = (float) (getPaddingBottom() + halfThumbHeight);
        while (yPos <= ((float) this.middleSnapPoint) - this.tickLineDistance) {
            canvas.drawLine(yPos, yStartPoint, yPos, yStartPoint + ((float) this.thumbWidth), normalTopLine);
            canvas.drawLine(yPos + 1.0f, yStartPoint, yPos + 1.0f, yStartPoint + ((float) this.thumbWidth), normalBottomLine);
            yPos += this.tickLineDistance;
        }
        yPos = (float) ((getHeight() - getPaddingTop()) - halfThumbHeight);
        this.tickLineDistance = (float) (((height - this.middleSnapPoint) - halfThumbHeight) / 5);
        while (yPos >= ((float) this.middleSnapPoint) + this.tickLineDistance) {
            canvas.drawLine(yPos, yStartPoint, yPos, yStartPoint + ((float) this.thumbWidth), normalTopLine);
            canvas.drawLine(yPos + 1.0f, yStartPoint, yPos + 1.0f, yStartPoint + ((float) this.thumbWidth), normalBottomLine);
            yPos -= this.tickLineDistance;
        }
        this.middleSnapPoint = (this.middleSnapPoint - 1) - getPaddingBottom();
        int barWidth = (int) (((double) this.thumbWidth) / 7.2d);
        int bottom = height;
        int left = (this.thumbWidth / 2) - (barWidth / 2);
        int right = left + barWidth;
        int top = getPaddingTop();
        Drawable d = getSuperDrawable();
        if (d != null) {
            d.setBounds(top, thumbPadding + left, bottom, thumbPadding + right);
            d.draw(canvas);
        } else {
            Logger.error((Object) this, "VerticalProgressBar:Could not get drawable");
        }
        Drawable thumb = getSuperThumb();
        if (thumb != null) {
            canvas.restore();
            canvas.save();
            top += Math.min(Math.max((((10000 - level) * bottom) / 10000) - this.thumbHeight, 0), bottom - this.thumbHeight);
            thumb.setBounds(thumbPadding, top, this.thumbWidth + thumbPadding, this.thumbHeight + top);
            thumb.draw(canvas);
        } else {
            Logger.error((Object) this, "VerticalProgressBar:Could not get Thumb");
        }
        canvas.restore();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int dw;
        int dh;
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (this.debugging) {
            Logger.debug(this, "onMeasure: Given width: " + width + " height: " + height);
            switch (widthMode) {
                case Integer.MIN_VALUE:
                    Logger.debug(this, "onMeasure: Width Mode at Most");
                    break;
                case 0:
                    Logger.debug(this, "onMeasure: Width Mode unspecified");
                    break;
                case 1073741824:
                    Logger.debug(this, "onMeasure: Width Mode exactly");
                    break;
                default:
                    Logger.debug(this, "onMeasure: Width Mode undefined");
                    break;
            }
            switch (heightMode) {
                case Integer.MIN_VALUE:
                    Logger.debug(this, "onMeasure: Height Mode at Most");
                    break;
                case 0:
                    Logger.debug(this, "onMeasure: Height Mode unspecified");
                    break;
                case 1073741824:
                    Logger.debug(this, "onMeasure: Height Mode exactly");
                    break;
                default:
                    Logger.debug(this, "onMeasure: Height Mode undefined");
                    break;
            }
        }
        if (this.maxWidth > 0) {
            dw = Math.min(this.maxWidth, width);
        } else {
            dw = width;
        }
        if (this.minWidth > 0) {
            dw = Math.min(this.minWidth, dw);
        }
        if (this.maxHeight > 0) {
            dh = Math.min(this.maxHeight, height);
        } else {
            dh = height;
        }
        if (this.minHeight > 0) {
            dh = Math.min(this.minHeight, dh);
        }
        dw = (this.thumbWidth + 16) + (getPaddingLeft() + getPaddingRight());
        setMeasuredDimension(resolveSize(dw, widthMeasureSpec), resolveSize(dh + (getPaddingTop() + getPaddingBottom()), heightMeasureSpec));
        if (this.debugging) {
            Logger.debug(this, "onMeasure: width: " + getMeasuredWidth() + " height: " + getMeasuredHeight() + " thumb width " + this.thumbWidth + " dw " + dw);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        if (this.debugging) {
            Logger.debug(this, "VerticalProgressBar:onTouchEvent: " + event);
        }
        switch (event.getAction()) {
            case 0:
                if (this.debugging) {
                    setPressed(true);
                    onStartTrackingTouch();
                    trackTouchEvent(event);
                    break;
                }
                setPressed(true);
                onStartTrackingTouch();
                trackTouchEvent(event);
            case 1:
                if (this.debugging) {
                    trackTouchEvent(event);
                    onStopTrackingTouch();
                    setPressed(false);
                    cancelClaimDrag();
                    invalidate();
                    break;
                }
                trackTouchEvent(event);
                onStopTrackingTouch();
                setPressed(false);
                cancelClaimDrag();
                invalidate();
            case 2:
                if (this.debugging) {
                    trackTouchEvent(event);
                    attemptClaimDrag();
                    break;
                }
                trackTouchEvent(event);
                attemptClaimDrag();
            case 3:
            case 4:
                if (this.debugging) {
                    onStopTrackingTouch();
                    setPressed(false);
                    cancelClaimDrag();
                    invalidate();
                    break;
                }
                onStopTrackingTouch();
                setPressed(false);
                cancelClaimDrag();
                invalidate();
        }
        return true;
    }

    private void trackTouchEvent(MotionEvent event) {
        float scale;
        int height = getHeight();
        int available = (height - getPaddingTop()) - getPaddingBottom();
        int y = (int) event.getY();
        if (((float) Math.abs(y - this.middleSnapPoint)) < this.tickLineDistance / 2.0f) {
            y = this.middleSnapPoint;
        }
        if (y < getPaddingTop()) {
            scale = 1.0f;
        } else if (y > height - getPaddingBottom()) {
            scale = 0.0f;
        } else {
            scale = ((float) (available - y)) / ((float) available);
        }
        float progress = scale * ((float) getMax());
        setProgress((int) progress);
        refreshProgress((int) progress);
        invalidate();
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.onProgressChanged(this, (int) progress, true);
        }
    }

    protected void onStartTrackingTouch() {
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.onStartTrackingTouch(this);
        }
    }

    protected void onStopTrackingTouch() {
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    private void attemptClaimDrag() {
        if (getParent() == null) {
        }
    }

    private void cancelClaimDrag() {
        if (getParent() == null) {
        }
    }

    protected synchronized void refreshProgress(int progress) {
        int max = getMax();
        float scale = max > 0 ? ((float) progress) / ((float) max) : 0.0f;
        Drawable d = getSuperDrawable();
        if (d != null) {
            Drawable progressDrawable = null;
            if (d instanceof LayerDrawable) {
                progressDrawable = ((LayerDrawable) d).findDrawableByLayerId(16908301);
            }
            int level = (int) (10000.0f * scale);
            if (progressDrawable == null) {
                progressDrawable = d;
            }
            progressDrawable.setLevel(level);
        }
    }
}
