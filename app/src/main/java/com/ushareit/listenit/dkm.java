package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;

public final class dkm extends ckk<dkc> {
    public dkm() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public djz m14731a(Activity activity) {
        try {
            return dka.m14707a(((dkc) m10057b((Context) activity)).mo1926a(ckj.m11512a((Object) activity)));
        } catch (Throwable e) {
            bze.m10491c("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            bze.m10491c("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected dkc m14732a(IBinder iBinder) {
        return dkd.m14712a(iBinder);
    }

    protected /* synthetic */ Object mo1119b(IBinder iBinder) {
        return m14732a(iBinder);
    }
}
