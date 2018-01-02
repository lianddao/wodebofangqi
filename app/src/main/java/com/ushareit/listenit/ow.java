package com.ushareit.listenit;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class ow implements Callback {
    final /* synthetic */ ot f16083a;

    ow(ot otVar) {
        this.f16083a = otVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f16083a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f16083a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f16083a.unscheduleSelf(runnable);
    }
}
