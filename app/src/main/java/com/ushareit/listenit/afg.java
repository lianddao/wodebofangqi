package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

public class afg extends abo {
    private abo f4257a;
    private afh f4258b;
    private boolean f4259c;

    public afg(abo com_ushareit_listenit_abo, int i) {
        this(new afh(com_ushareit_listenit_abo.getConstantState(), i), com_ushareit_listenit_abo, null);
    }

    afg(afh com_ushareit_listenit_afh, abo com_ushareit_listenit_abo, Resources resources) {
        this.f4258b = com_ushareit_listenit_afh;
        if (com_ushareit_listenit_abo != null) {
            this.f4257a = com_ushareit_listenit_abo;
        } else if (resources != null) {
            this.f4257a = (abo) com_ushareit_listenit_afh.f4260a.newDrawable(resources);
        } else {
            this.f4257a = (abo) com_ushareit_listenit_afh.f4260a.newDrawable();
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f4257a.setBounds(i, i2, i3, i4);
    }

    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f4257a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f4257a.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f4257a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f4257a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f4257a.setFilterBitmap(z);
    }

    @TargetApi(11)
    public Callback getCallback() {
        return this.f4257a.getCallback();
    }

    @TargetApi(19)
    public int getAlpha() {
        return this.f4257a.getAlpha();
    }

    public void setColorFilter(int i, Mode mode) {
        this.f4257a.setColorFilter(i, mode);
    }

    public void clearColorFilter() {
        this.f4257a.clearColorFilter();
    }

    public Drawable getCurrent() {
        return this.f4257a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.f4257a.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.f4258b.f4261b;
    }

    public int getIntrinsicHeight() {
        return this.f4258b.f4261b;
    }

    public int getMinimumWidth() {
        return this.f4257a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f4257a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f4257a.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.f4257a.invalidateSelf();
    }

    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f4257a.unscheduleSelf(runnable);
    }

    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f4257a.scheduleSelf(runnable, j);
    }

    public void draw(Canvas canvas) {
        this.f4257a.draw(canvas);
    }

    public void setAlpha(int i) {
        this.f4257a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4257a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return this.f4257a.getOpacity();
    }

    public boolean mo568a() {
        return this.f4257a.mo568a();
    }

    public void mo567a(int i) {
        this.f4257a.mo567a(i);
    }

    public void start() {
        this.f4257a.start();
    }

    public void stop() {
        this.f4257a.stop();
    }

    public boolean isRunning() {
        return this.f4257a.isRunning();
    }

    public Drawable mutate() {
        if (!this.f4259c && super.mutate() == this) {
            this.f4257a = (abo) this.f4257a.mutate();
            this.f4258b = new afh(this.f4258b);
            this.f4259c = true;
        }
        return this;
    }

    public ConstantState getConstantState() {
        return this.f4258b;
    }
}
