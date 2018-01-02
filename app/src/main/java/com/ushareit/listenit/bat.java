package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.internal.cb;

class bat implements bbj {
    final /* synthetic */ Bundle f5818a;
    final /* synthetic */ bak f5819b;

    bat(bak com_ushareit_listenit_bak, Bundle bundle) {
        this.f5819b = com_ushareit_listenit_bak;
        this.f5818a = bundle;
    }

    public void mo827a() {
        if (cb.m1591a(this.f5819b.f5797s)) {
            Bundle bundle = new Bundle();
            bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
            bak.m7532c(this.f5819b, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle);
            return;
        }
        aje com_ushareit_listenit_aje = new aje();
        bbh com_ushareit_listenit_bbh = new bbh(this.f5819b, this.f5819b.f5797s, this.f5819b.f5790l);
        com_ushareit_listenit_bbh.m7588a(com_ushareit_listenit_aje);
        com_ushareit_listenit_aje.m5756a(new bau(this, com_ushareit_listenit_bbh));
        com_ushareit_listenit_aje.m5766h();
    }
}
