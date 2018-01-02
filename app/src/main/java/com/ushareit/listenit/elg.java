package com.ushareit.listenit;

import android.os.Handler;
import android.view.View;
import com.mopub.common.VisibleForTesting;

@VisibleForTesting
public class elg {
    private final Handler f11205a = new Handler();
    private elh f11206b;

    public elh m17144a(View... viewArr) {
        this.f11206b = new elh(this.f11205a, viewArr);
        return this.f11206b;
    }

    public void m17145a() {
        if (this.f11206b != null) {
            this.f11206b.m17149a();
            this.f11206b = null;
        }
    }
}
