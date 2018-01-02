package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.internal.C0093a;
import com.facebook.internal.C0116x;
import com.facebook.share.model.ShareContent;

class bea implements C0116x {
    final /* synthetic */ C0093a f5973a;
    final /* synthetic */ ShareContent f5974b;
    final /* synthetic */ boolean f5975c;
    final /* synthetic */ bdz f5976d;

    bea(bdz com_ushareit_listenit_bdz, C0093a c0093a, ShareContent shareContent, boolean z) {
        this.f5976d = com_ushareit_listenit_bdz;
        this.f5973a = c0093a;
        this.f5974b = shareContent;
        this.f5975c = z;
    }

    public Bundle mo832a() {
        return bbx.m7638a(this.f5973a.m1247c(), this.f5974b, this.f5975c);
    }

    public Bundle mo833b() {
        return baj.m7493a(this.f5973a.m1247c(), this.f5974b, this.f5975c);
    }
}
