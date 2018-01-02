package com.ushareit.listenit;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

class dns implements cfy {
    final /* synthetic */ dnn f10062a;
    private final cdt f10063b;
    private final dlp<?> f10064c;

    public dns(dnn com_ushareit_listenit_dnn, cdt com_ushareit_listenit_cdt, dlp<?> com_ushareit_listenit_dlp_) {
        this.f10062a = com_ushareit_listenit_dnn;
        this.f10063b = com_ushareit_listenit_cdt;
        this.f10064c = com_ushareit_listenit_dlp_;
    }

    public void mo1310a(ConnectionResult connectionResult) {
        if (connectionResult.m2235b()) {
            this.f10063b.m10639a(null, Collections.emptySet());
        } else {
            ((dnq) this.f10062a.f10038k.get(this.f10064c)).mo1954a(connectionResult);
        }
    }
}
