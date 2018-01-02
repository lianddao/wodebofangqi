package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;

public final class bwd extends ckk<bxi> {
    public bwd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public bxf m10194a(Context context, String str, dii com_ushareit_listenit_dii) {
        try {
            return bxg.m10069a(((bxi) m10057b(context)).mo1180a(ckj.m11512a((Object) context), str, com_ushareit_listenit_dii, cge.f8237a));
        } catch (Throwable e) {
            bze.m10491c("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (Throwable e2) {
            bze.m10491c("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    protected bxi m10195a(IBinder iBinder) {
        return bxj.m10292a(iBinder);
    }

    protected /* synthetic */ Object mo1119b(IBinder iBinder) {
        return m10195a(iBinder);
    }
}
