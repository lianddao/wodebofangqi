package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.internal.C0093a;

final class bck extends bcc {
    final /* synthetic */ aic f5901a;

    bck(aic com_ushareit_listenit_aic, aic com_ushareit_listenit_aic2) {
        this.f5901a = com_ushareit_listenit_aic2;
        super(com_ushareit_listenit_aic);
    }

    public void mo825a(C0093a c0093a, Bundle bundle) {
        if (bundle != null) {
            String a = bcj.m7731a(bundle);
            if (a == null || "post".equalsIgnoreCase(a)) {
                bcj.m7740a(this.f5901a, bcj.m7744b(bundle));
            } else if ("cancel".equalsIgnoreCase(a)) {
                bcj.m7745b(this.f5901a);
            } else {
                bcj.m7739a(this.f5901a, new aif("UnknownError"));
            }
        }
    }

    public void mo824a(C0093a c0093a) {
        bcj.m7745b(this.f5901a);
    }

    public void mo826a(C0093a c0093a, aif com_ushareit_listenit_aif) {
        bcj.m7739a(this.f5901a, com_ushareit_listenit_aif);
    }
}
