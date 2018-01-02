package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;

public class rs implements Runnable {
    final /* synthetic */ RecyclerView f16433a;

    public rs(RecyclerView recyclerView) {
        this.f16433a = recyclerView;
    }

    public void run() {
        if (this.f16433a.f352e != null) {
            this.f16433a.f352e.mo3021a();
        }
        this.f16433a.af = false;
    }
}
