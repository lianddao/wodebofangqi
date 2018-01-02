package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;

public final class djm extends ckk<djq> {
    public djm() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public djn m14661a(Activity activity) {
        try {
            return djo.m14677a(((djq) m10057b((Context) activity)).mo1918a(ckj.m11512a((Object) activity)));
        } catch (Throwable e) {
            bze.m10491c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            bze.m10491c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected djq m14662a(IBinder iBinder) {
        return djr.m14692a(iBinder);
    }

    protected /* synthetic */ Object mo1119b(IBinder iBinder) {
        return m14662a(iBinder);
    }
}
