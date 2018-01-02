package com.miui.player.ui.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.NinePatchDrawable;
import com.miui.player.service.ShakeListener;

public class LevelNinePathDrawable extends Drawable {
    private static final int MAX_LEVEL = 10000;
    private static final int MIN_WIDTH = 10;
    private final NinePatchDrawable mDrawable;

    public LevelNinePathDrawable(NinePatchDrawable d) {
        if (d == null) {
            throw new NullPointerException();
        }
        this.mDrawable = d;
    }

    public void draw(Canvas canvas) {
        float scaleX = ((float) getLevel()) / 10000.0f;
        Rect bounds = getBounds();
        float width = ((float) bounds.width()) * scaleX;
        if (width > 10.0f) {
            this.mDrawable.setBounds(bounds.left, bounds.top, (int) (((float) bounds.left) + width), bounds.bottom);
            this.mDrawable.draw(canvas);
            return;
        }
        canvas.save();
        canvas.scale(scaleX, ShakeListener.ACCELATION_FACTOR_X);
        this.mDrawable.setBounds(getBounds());
        this.mDrawable.draw(canvas);
        canvas.restore();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public void setAlpha(int alpha) {
        this.mDrawable.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        this.mDrawable.setColorFilter(cf);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public boolean getPadding(Rect padding) {
        return this.mDrawable.getPadding(padding);
    }

    public void setDither(boolean dither) {
        this.mDrawable.setDither(dither);
        super.setDither(dither);
    }

    public void setFilterBitmap(boolean filter) {
        this.mDrawable.setFilterBitmap(filter);
        super.setFilterBitmap(filter);
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public ConstantState getConstantState() {
        return this.mDrawable.getConstantState();
    }

    public Drawable mutate() {
        return this.mDrawable.mutate();
    }

    public void setChangingConfigurations(int configs) {
        this.mDrawable.setChangingConfigurations(configs);
        super.setChangingConfigurations(configs);
    }

    public void invalidateSelf() {
        this.mDrawable.invalidateSelf();
        super.invalidateSelf();
    }

    public void setColorFilter(int color, Mode mode) {
        this.mDrawable.setColorFilter(color, mode);
        super.setColorFilter(color, mode);
    }

    public void clearColorFilter() {
        this.mDrawable.clearColorFilter();
        super.clearColorFilter();
    }

    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    public boolean setState(int[] stateSet) {
        return this.mDrawable.setState(stateSet);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    public Drawable getCurrent() {
        return this;
    }

    public boolean setVisible(boolean visible, boolean restart) {
        this.mDrawable.setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    protected boolean onLevelChange(int level) {
        invalidateSelf();
        return true;
    }
}
