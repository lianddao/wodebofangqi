package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.View;

class lo implements ly {
    lj f15634a;
    boolean f15635b;

    lo(lj ljVar) {
        this.f15634a = ljVar;
    }

    public void mo2880a(View view) {
        ly lyVar;
        this.f15635b = false;
        if (this.f15634a.f15628e >= 0) {
            ja.m24137a(view, 2, null);
        }
        if (this.f15634a.f15626c != null) {
            Runnable a = this.f15634a.f15626c;
            this.f15634a.f15626c = null;
            a.run();
        }
        Object tag = view.getTag(2113929216);
        if (tag instanceof ly) {
            lyVar = (ly) tag;
        } else {
            lyVar = null;
        }
        if (lyVar != null) {
            lyVar.mo2880a(view);
        }
    }

    public void mo2881b(View view) {
        if (this.f15634a.f15628e >= 0) {
            ja.m24137a(view, this.f15634a.f15628e, null);
            this.f15634a.f15628e = -1;
        }
        if (VERSION.SDK_INT >= 16 || !this.f15635b) {
            ly lyVar;
            if (this.f15634a.f15627d != null) {
                Runnable b = this.f15634a.f15627d;
                this.f15634a.f15627d = null;
                b.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof ly) {
                lyVar = (ly) tag;
            } else {
                lyVar = null;
            }
            if (lyVar != null) {
                lyVar.mo2881b(view);
            }
            this.f15635b = true;
        }
    }

    public void mo2882c(View view) {
        ly lyVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof ly) {
            lyVar = (ly) tag;
        } else {
            lyVar = null;
        }
        if (lyVar != null) {
            lyVar.mo2882c(view);
        }
    }
}
