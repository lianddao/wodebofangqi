package com.ushareit.listenit;

import com.google.android.gms.common.ConnectionResult;
import java.util.Map;

class dms extends dmz {
    final /* synthetic */ dmp f9961a;
    private final Map<cdt, dmr> f9962c;

    public dms(dmp com_ushareit_listenit_dmp, Map<cdt, dmr> map) {
        this.f9961a = com_ushareit_listenit_dmp;
        super(com_ushareit_listenit_dmp);
        this.f9962c = map;
    }

    public void mo1990a() {
        int i;
        int i2 = 1;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        for (cdt com_ushareit_listenit_cdt : this.f9962c.keySet()) {
            if (!com_ushareit_listenit_cdt.mo1399k()) {
                i = 0;
                i4 = i5;
            } else if (((dmr) this.f9962c.get(com_ushareit_listenit_cdt)).f9959c == 0) {
                i = 1;
                break;
            } else {
                i = i4;
                i4 = 1;
            }
            i5 = i4;
            i4 = i;
        }
        i2 = i5;
        i = 0;
        if (i2 != 0) {
            i3 = this.f9961a.f9938d.mo1287a(this.f9961a.f9937c);
        }
        if (i3 == 0 || (r0 == 0 && i4 == 0)) {
            if (this.f9961a.f9947m) {
                this.f9961a.f9945k.mo2122m();
            }
            for (cdt com_ushareit_listenit_cdt2 : this.f9962c.keySet()) {
                cfy com_ushareit_listenit_cfy = (cfy) this.f9962c.get(com_ushareit_listenit_cdt2);
                if (!com_ushareit_listenit_cdt2.mo1399k() || i3 == 0) {
                    com_ushareit_listenit_cdt2.m10638a(com_ushareit_listenit_cfy);
                } else {
                    this.f9961a.f9935a.m15050a(new dmu(this, this.f9961a, com_ushareit_listenit_cfy));
                }
            }
            return;
        }
        this.f9961a.f9935a.m15050a(new dmt(this, this.f9961a, new ConnectionResult(i3, null)));
    }
}
