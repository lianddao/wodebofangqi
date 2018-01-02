package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.umeng.analytics.C0154a;
import java.util.ArrayList;
import java.util.List;

class ffo implements gxs {
    final /* synthetic */ Bitmap f12612a;
    final /* synthetic */ ffn f12613b;

    ffo(ffn com_ushareit_listenit_ffn, Bitmap bitmap) {
        this.f12613b = com_ushareit_listenit_ffn;
        this.f12612a = bitmap;
    }

    public void mo2368a(Bitmap bitmap) {
        List arrayList = new ArrayList();
        esi com_ushareit_listenit_esi = new esi(this.f12613b.f12608a.a, this.f12613b.f12608a.c, C0154a.f2954j, this.f12613b.f12609b, this.f12613b.f12608a.f12607l);
        com_ushareit_listenit_esi.m17715a("NativeAdListener", (Object) this.f12613b.f12610c);
        com_ushareit_listenit_esi.m17715a("adImage", (Object) this.f12612a);
        com_ushareit_listenit_esi.m17715a("adBackground", (Object) bitmap);
        arrayList.add(com_ushareit_listenit_esi);
        if (this.f12613b.f12611d != null) {
            this.f12613b.f12611d.mo2371a(arrayList);
        }
    }
}
