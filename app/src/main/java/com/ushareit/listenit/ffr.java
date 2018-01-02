package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.umeng.analytics.C0154a;
import java.util.ArrayList;
import java.util.List;

final class ffr implements gxs {
    final /* synthetic */ ffl f12619a;
    final /* synthetic */ Object f12620b;
    final /* synthetic */ fge f12621c;
    final /* synthetic */ Bitmap f12622d;
    final /* synthetic */ ffs f12623e;

    ffr(ffl com_ushareit_listenit_ffl, Object obj, fge com_ushareit_listenit_fge, Bitmap bitmap, ffs com_ushareit_listenit_ffs) {
        this.f12619a = com_ushareit_listenit_ffl;
        this.f12620b = obj;
        this.f12621c = com_ushareit_listenit_fge;
        this.f12622d = bitmap;
        this.f12623e = com_ushareit_listenit_ffs;
    }

    public void mo2368a(Bitmap bitmap) {
        List arrayList = new ArrayList();
        esi com_ushareit_listenit_esi = new esi(this.f12619a.a, this.f12619a.c, C0154a.f2954j, this.f12620b, this.f12619a.f12607l);
        com_ushareit_listenit_esi.m17715a("NativeAdListener", (Object) this.f12621c);
        com_ushareit_listenit_esi.m17715a("adImage", (Object) this.f12622d);
        com_ushareit_listenit_esi.m17715a("adBackground", (Object) bitmap);
        arrayList.add(com_ushareit_listenit_esi);
        if (this.f12623e != null) {
            this.f12623e.mo2371a(arrayList);
        }
    }
}
