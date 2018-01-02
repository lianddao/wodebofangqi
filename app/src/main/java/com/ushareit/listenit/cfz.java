package com.ushareit.listenit;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class cfz extends cht {
    private cfs f8229a;
    private final int f8230b;

    public cfz(cfs com_ushareit_listenit_cfs, int i) {
        this.f8229a = com_ushareit_listenit_cfs;
        this.f8230b = i;
    }

    private void m11138a() {
        this.f8229a = null;
    }

    public void mo1306a(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public void mo1307a(int i, IBinder iBinder, Bundle bundle) {
        cfi.m11081a(this.f8229a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
        this.f8229a.m10609a(i, iBinder, bundle, this.f8230b);
        m11138a();
    }
}
