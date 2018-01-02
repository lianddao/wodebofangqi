package com.ushareit.listenit;

import com.facebook.AccessToken;
import com.facebook.Profile;
import java.util.concurrent.Callable;

final class ain implements Callable<Void> {
    final /* synthetic */ aip f4445a;

    ain(aip com_ushareit_listenit_aip) {
        this.f4445a = com_ushareit_listenit_aip;
    }

    public /* synthetic */ Object call() {
        return m5724a();
    }

    public Void m5724a() {
        aho.m5655a().m5665c();
        ajo.m5793a().m5798c();
        if (AccessToken.m671a() != null && Profile.m777a() == null) {
            Profile.m779b();
        }
        if (this.f4445a != null) {
            this.f4445a.m5725a();
        }
        return null;
    }
}
