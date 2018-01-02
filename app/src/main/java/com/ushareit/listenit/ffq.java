package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.umeng.analytics.C0154a;
import java.util.ArrayList;
import java.util.List;

class ffq implements gxs {
    final /* synthetic */ Bitmap f12617a;
    final /* synthetic */ ffp f12618b;

    ffq(ffp com_ushareit_listenit_ffp, Bitmap bitmap) {
        this.f12618b = com_ushareit_listenit_ffp;
        this.f12617a = bitmap;
    }

    public void mo2368a(Bitmap bitmap) {
        List arrayList = new ArrayList();
        esi com_ushareit_listenit_esi = new esi(this.f12618b.f12614a.a, this.f12618b.f12614a.c, C0154a.f2954j, this.f12618b.f12615b, this.f12618b.f12614a.f12607l);
        com_ushareit_listenit_esi.m17715a("adImage", (Object) this.f12617a);
        com_ushareit_listenit_esi.m17715a("adBackground", (Object) bitmap);
        arrayList.add(com_ushareit_listenit_esi);
        if (this.f12618b.f12616c != null) {
            this.f12618b.f12616c.mo2371a(arrayList);
        }
    }
}
