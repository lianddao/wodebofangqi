package com.ushareit.listenit;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

class fef extends hhw {
    final /* synthetic */ ViewGroup f12523a;
    final /* synthetic */ gxl f12524b;
    final /* synthetic */ feg f12525c;
    final /* synthetic */ fee f12526d;
    private Drawable f12527e;

    fef(fee com_ushareit_listenit_fee, ViewGroup viewGroup, gxl com_ushareit_listenit_gxl, feg com_ushareit_listenit_feg) {
        this.f12526d = com_ushareit_listenit_fee;
        this.f12523a = viewGroup;
        this.f12524b = com_ushareit_listenit_gxl;
        this.f12525c = com_ushareit_listenit_feg;
    }

    public void execute() {
        this.f12527e = gxj.m23085a(this.f12523a.getContext(), this.f12524b);
    }

    public void callback() {
        this.f12525c.f12528a.setImageDrawable(this.f12527e);
    }
}
