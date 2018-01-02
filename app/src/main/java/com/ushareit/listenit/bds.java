package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.internal.C0093a;
import com.facebook.internal.C0116x;
import com.facebook.share.model.ShareContent;

class bds implements C0116x {
    final /* synthetic */ C0093a f5956a;
    final /* synthetic */ ShareContent f5957b;
    final /* synthetic */ boolean f5958c;
    final /* synthetic */ bdr f5959d;

    bds(bdr com_ushareit_listenit_bdr, C0093a c0093a, ShareContent shareContent, boolean z) {
        this.f5959d = com_ushareit_listenit_bdr;
        this.f5956a = c0093a;
        this.f5957b = shareContent;
        this.f5958c = z;
    }

    public Bundle mo832a() {
        return bbx.m7638a(this.f5956a.m1247c(), this.f5957b, this.f5958c);
    }

    public Bundle mo833b() {
        return baj.m7493a(this.f5956a.m1247c(), this.f5957b, this.f5958c);
    }
}
