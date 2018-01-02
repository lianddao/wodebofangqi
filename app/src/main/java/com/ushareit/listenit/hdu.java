package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class hdu extends Drawable {
    private final RectF f15224a = new RectF();
    private final RectF f15225b = new RectF();
    private final Bitmap f15226c;
    private final Paint f15227d;
    private final int f15228e;
    private final int f15229f;
    private final RectF f15230g = new RectF();
    private final Matrix f15231h = new Matrix();
    private boolean f15232i = true;
    private float f15233j = 0.0f;

    public hdu(Bitmap bitmap) {
        this.f15226c = bitmap;
        this.f15228e = bitmap.getWidth();
        this.f15229f = bitmap.getHeight();
        this.f15225b.set(0.0f, 0.0f, (float) this.f15228e, (float) this.f15229f);
        this.f15227d = new Paint();
        this.f15227d.setStyle(Style.FILL);
        this.f15227d.setAntiAlias(true);
    }

    public static Bitmap m23590a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f15230g.set(rect);
        this.f15231h.reset();
        this.f15231h.setRectToRect(this.f15225b, this.f15230g, ScaleToFit.FILL);
        this.f15224a.set(this.f15230g);
    }

    public void draw(Canvas canvas) {
        if (this.f15232i) {
            Shader bitmapShader = new BitmapShader(this.f15226c, TileMode.CLAMP, TileMode.CLAMP);
            bitmapShader.setLocalMatrix(this.f15231h);
            this.f15227d.setShader(bitmapShader);
            this.f15232i = false;
        }
        canvas.drawRoundRect(this.f15224a, this.f15233j, this.f15233j, this.f15227d);
    }

    public int getOpacity() {
        return -3;
    }

    public int getAlpha() {
        return this.f15227d.getAlpha();
    }

    public void setAlpha(int i) {
        this.f15227d.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f15227d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.f15227d.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.f15227d.setFilterBitmap(z);
        invalidateSelf();
    }

    public int getIntrinsicWidth() {
        return this.f15228e;
    }

    public int getIntrinsicHeight() {
        return this.f15229f;
    }

    public void m23591a(float f) {
        this.f15233j = f;
    }
}
