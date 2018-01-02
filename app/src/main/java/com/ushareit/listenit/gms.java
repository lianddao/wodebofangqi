package com.ushareit.listenit;

import com.ushareit.listenit.nearby.view.SongMenuActivity;

public class gms implements fei {
    final /* synthetic */ SongMenuActivity f14428a;

    public gms(SongMenuActivity songMenuActivity) {
        this.f14428a = songMenuActivity;
    }

    public void mo2725a(boolean z) {
        if (!z) {
            if (!fhy.m19213a()) {
                this.f14428a.f15999A.setImageResource(this.f14428a.f16011p.m18952a() ? C0349R.drawable.collection_selected : C0349R.drawable.collection_normal);
            } else if (this.f14428a.f16011p.m18952a()) {
                this.f14428a.m25196q();
            }
        }
        this.f14428a.m25197r();
    }
}
