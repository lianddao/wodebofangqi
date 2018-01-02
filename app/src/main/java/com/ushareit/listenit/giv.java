package com.ushareit.listenit;

import android.util.Pair;

class giv extends gwv {
    final /* synthetic */ giu f14180a;

    giv(giu com_ushareit_listenit_giu) {
        this.f14180a = com_ushareit_listenit_giu;
    }

    public void execute() {
        Pair a = eyw.m18568a(this.f14180a.f14179a);
        if (((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue()) {
            euq.m18023a(eys.m18562a());
            if (!this.f14180a.f14179a.f15898B) {
                this.f14180a.f14179a.f15898B = true;
                exo.m18425a(eys.m18562a(), 1, false, true);
            }
        }
    }
}
