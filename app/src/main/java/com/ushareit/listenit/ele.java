package com.ushareit.listenit;

import android.util.DisplayMetrics;
import android.view.View;
import com.mopub.mraid.MraidController;

public class ele implements Runnable {
    final /* synthetic */ View f11199a;
    final /* synthetic */ Runnable f11200b;
    final /* synthetic */ MraidController f11201c;

    public ele(MraidController mraidController, View view, Runnable runnable) {
        this.f11201c = mraidController;
        this.f11199a = view;
        this.f11200b = runnable;
    }

    public void run() {
        DisplayMetrics displayMetrics = this.f11201c.f2575c.getResources().getDisplayMetrics();
        this.f11201c.f2581i.m17167a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int[] iArr = new int[2];
        View j = this.f11201c.m3090i();
        j.getLocationOnScreen(iArr);
        this.f11201c.f2581i.m17168a(iArr[0], iArr[1], j.getWidth(), j.getHeight());
        this.f11201c.f2577e.getLocationOnScreen(iArr);
        this.f11201c.f2581i.m17172c(iArr[0], iArr[1], this.f11201c.f2577e.getWidth(), this.f11201c.f2577e.getHeight());
        this.f11199a.getLocationOnScreen(iArr);
        this.f11201c.f2581i.m17170b(iArr[0], iArr[1], this.f11199a.getWidth(), this.f11199a.getHeight());
        this.f11201c.f2588p.notifyScreenMetrics(this.f11201c.f2581i);
        if (this.f11201c.f2589q.m3074d()) {
            this.f11201c.f2589q.notifyScreenMetrics(this.f11201c.f2581i);
        }
        if (this.f11200b != null) {
            this.f11200b.run();
        }
    }
}
