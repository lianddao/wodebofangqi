package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.widget.ActionBarView;

public class hbi extends fjw {
    final /* synthetic */ ActionBarView f15135a;

    public hbi(ActionBarView actionBarView) {
        this.f15135a = actionBarView;
    }

    public void mo2389a(View view) {
        if (this.f15135a.f17134h == null) {
            gyn.m23186a(this.f15135a.getContext(), new gta());
            fio.m19366a(this.f15135a.getContext(), "search");
            fiv.m19452i(this.f15135a.getContext());
            return;
        }
        gyn.m23186a(this.f15135a.getContext(), new gta(this.f15135a.f17134h));
    }
}
