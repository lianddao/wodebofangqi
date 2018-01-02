package com.ushareit.listenit;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public class dme implements ceb, cec {
    public final cdj<?> f9909a;
    private final int f9910b;
    private dmf f9911c;

    public dme(cdj<?> com_ushareit_listenit_cdj_, int i) {
        this.f9909a = com_ushareit_listenit_cdj_;
        this.f9910b = i;
    }

    private void m14824a() {
        cfi.m11081a(this.f9911c, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public void mo1956a(int i) {
        m14824a();
        this.f9911c.mo1956a(i);
    }

    public void mo1957a(Bundle bundle) {
        m14824a();
        this.f9911c.mo1957a(bundle);
    }

    public void mo1954a(ConnectionResult connectionResult) {
        m14824a();
        this.f9911c.mo2009a(connectionResult, this.f9909a, this.f9910b);
    }

    public void m14828a(dmf com_ushareit_listenit_dmf) {
        this.f9911c = com_ushareit_listenit_dmf;
    }
}
