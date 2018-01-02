package com.ushareit.listenit;

import android.view.View;

class eli implements Runnable {
    final /* synthetic */ elh f11212a;

    eli(elh com_ushareit_listenit_elh) {
        this.f11212a = com_ushareit_listenit_elh;
    }

    public void run() {
        for (View view : this.f11212a.f11208b) {
            if (view.getHeight() > 0 || view.getWidth() > 0) {
                this.f11212a.m17147b();
            } else {
                view.getViewTreeObserver().addOnPreDrawListener(new elj(this, view));
            }
        }
    }
}
