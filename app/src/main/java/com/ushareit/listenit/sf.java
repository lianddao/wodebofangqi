package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;

public class sf implements sd {
    final /* synthetic */ RecyclerView f16491a;

    private sf(RecyclerView recyclerView) {
        this.f16491a = recyclerView;
    }

    public void mo3062a(sv svVar) {
        svVar.setIsRecyclable(true);
        if (svVar.f2670f != null && svVar.f2671g == null) {
            svVar.f2670f = null;
        }
        svVar.f2671g = null;
        if (!svVar.m3218v() && !this.f16491a.m481g(svVar.itemView) && svVar.m3239m()) {
            this.f16491a.removeDetachedView(svVar.itemView, false);
        }
    }
}
