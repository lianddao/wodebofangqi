package com.ushareit.listenit;

import android.os.Bundle;
import android.view.View;

class sx extends gk {
    final /* synthetic */ sw f16551b;

    sx(sw swVar) {
        this.f16551b = swVar;
    }

    public void mo2862a(View view, mh mhVar) {
        super.mo2862a(view, mhVar);
        if (!this.f16551b.m26219c() && this.f16551b.f16549b.getLayoutManager() != null) {
            this.f16551b.f16549b.getLayoutManager().m244a(view, mhVar);
        }
    }

    public boolean mo2863a(View view, int i, Bundle bundle) {
        if (super.mo2863a(view, i, bundle)) {
            return true;
        }
        if (this.f16551b.m26219c() || this.f16551b.f16549b.getLayoutManager() == null) {
            return false;
        }
        return this.f16551b.f16549b.getLayoutManager().m263a(view, i, bundle);
    }
}
