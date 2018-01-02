package com.miui.player.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.miui.player.service.ShakeListener;

public class InvertImageView extends ImageView {
    private static final String TAG = "InvertImageView";
    private Bitmap mBitmapCache;
    private Drawable mDrawableCached;
    private BitmapDrawable mMask;
    private int mMaskId;
    private final Paint mMaskPaint;
    private float mPercent;
    private final Paint mXfermodePaint;

    public InvertImageView(Context context) {
        this(context, null);
    }

    public InvertImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InvertImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mMaskPaint = new Paint();
        this.mXfermodePaint = new Paint();
        this.mPercent = 0.0f;
        setRotationX(180.0f);
        setScaleType(ScaleType.MATRIX);
        this.mMaskPaint.setAntiAlias(true);
        this.mMaskPaint.setDither(true);
        this.mMaskPaint.setFilterBitmap(true);
        this.mXfermodePaint.setAntiAlias(true);
        this.mXfermodePaint.setDither(true);
        this.mXfermodePaint.setFilterBitmap(true);
        this.mXfermodePaint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            clearCache(false);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.mMask == null) {
            drawInternal(canvas, getDrawable());
            return;
        }
        Bitmap bm = this.mMask.getBitmap();
        int w = bm.getWidth();
        int h = bm.getHeight();
        if (!(this.mBitmapCache == null || (this.mBitmapCache.getWidth() == w && this.mBitmapCache.getHeight() == h))) {
            clearCache(true);
        }
        if (this.mBitmapCache == null) {
            this.mBitmapCache = Bitmap.createBitmap(w, h, Config.ARGB_8888);
        }
        if (getDrawable() != this.mDrawableCached) {
            this.mDrawableCached = getDrawable();
            Canvas tempCanvas = new Canvas(this.mBitmapCache);
            drawInternal(tempCanvas, getDrawable());
            tempCanvas.drawBitmap(bm, 0.0f, 0.0f, this.mXfermodePaint);
            Log.d(TAG, "cache miss");
        } else {
            Log.d(TAG, "cache hit");
        }
        float dstTop = ((float) (canvas.getHeight() - h)) * this.mPercent;
        float dstBottom = (float) canvas.getHeight();
        int dstHeight = Math.round(dstBottom - dstTop);
        int srcTop = h - dstHeight;
        canvas.drawBitmap(this.mBitmapCache, new Rect(0, srcTop, w, srcTop + dstHeight), new RectF(0.0f, dstTop, (float) w, dstBottom), this.mMaskPaint);
    }

    private void drawInternal(Canvas canvas, Drawable drawable) {
        boolean hasSet = false;
        if (drawable != null && drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) {
            hasSet = true;
            canvas.save();
            canvas.translate(0.0f, (float) (canvas.getHeight() - drawable.getIntrinsicHeight()));
        }
        super.onDraw(canvas);
        if (hasSet) {
            canvas.restore();
        }
    }

    public void setMaskResource(int id) {
        if (this.mMaskId != id) {
            this.mMaskId = id;
            this.mMask = id != 0 ? (BitmapDrawable) getResources().getDrawable(id) : null;
            clearCache(this.mMask == null);
            invalidate();
        }
    }

    public void setMaskAlpha(float alpha) {
        int alphaInt = Math.round(255.0f * alpha);
        if (alphaInt != this.mXfermodePaint.getAlpha()) {
            this.mXfermodePaint.setAlpha(alphaInt);
            clearCache(false);
            invalidate();
        }
    }

    public void setMaskHeightRate(float percent) {
        if (((double) Math.abs(this.mPercent - percent)) > 0.001d || ((this.mPercent != 0.0f && percent == 0.0f) || (this.mPercent != ShakeListener.ACCELATION_FACTOR_X && percent == ShakeListener.ACCELATION_FACTOR_X))) {
            this.mPercent = percent;
            invalidate();
        }
    }

    private void clearCache(boolean recycleBitmap) {
        this.mDrawableCached = null;
        if (recycleBitmap && this.mBitmapCache != null) {
            this.mBitmapCache.recycle();
            this.mBitmapCache = null;
        }
    }
}
