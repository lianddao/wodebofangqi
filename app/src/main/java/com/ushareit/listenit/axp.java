package com.ushareit.listenit;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.ads.internal.view.C0052n;
import com.facebook.ads.internal.view.p003d.p004b.C0040h;

public class axp implements OnClickListener {
    final /* synthetic */ C0052n f5625a;
    final /* synthetic */ C0040h f5626b;

    public axp(C0040h c0040h, C0052n c0052n) {
        this.f5626b = c0040h;
        this.f5625a = c0052n;
    }

    public void onClick(View view) {
        if (this.f5626b.f713f.get()) {
            this.f5625a.m1112f();
        } else {
            Log.i("SkipPlugin", "User clicked skip before the ads is allowed to skip.");
        }
    }
}
