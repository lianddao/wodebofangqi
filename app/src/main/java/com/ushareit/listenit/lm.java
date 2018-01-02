package com.ushareit.listenit;

import android.view.View;
import java.lang.ref.WeakReference;

class lm implements Runnable {
    WeakReference<View> f15630a;
    lj f15631b;
    final /* synthetic */ ll f15632c;

    private lm(ll llVar, lj ljVar, View view) {
        this.f15632c = llVar;
        this.f15630a = new WeakReference(view);
        this.f15631b = ljVar;
    }

    public void run() {
        View view = (View) this.f15630a.get();
        if (view != null) {
            this.f15632c.m24463c(this.f15631b, view);
        }
    }
}
