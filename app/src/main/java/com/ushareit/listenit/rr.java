package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;

public class rr implements Runnable {
    final /* synthetic */ RecyclerView f16432a;

    public rr(RecyclerView recyclerView) {
        this.f16432a = recyclerView;
    }

    public void run() {
        if (this.f16432a.f369x && !this.f16432a.isLayoutRequested()) {
            if (this.f16432a.f325A) {
                this.f16432a.f371z = true;
            } else {
                this.f16432a.m503t();
            }
        }
    }
}
