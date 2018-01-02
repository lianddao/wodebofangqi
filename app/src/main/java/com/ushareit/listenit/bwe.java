package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

public class bwe extends ckk<bxo> {
    public bwe() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public bxl m10197a(Context context, AdSizeParcel adSizeParcel, String str, dii com_ushareit_listenit_dii, int i) {
        Throwable e;
        try {
            return bxm.m10110a(((bxo) m10057b(context)).mo1182a(ckj.m11512a((Object) context), adSizeParcel, str, com_ushareit_listenit_dii, cge.f8237a, i));
        } catch (RemoteException e2) {
            e = e2;
            bze.m10486a("Could not create remote AdManager.", e);
            return null;
        } catch (ckl e3) {
            e = e3;
            bze.m10486a("Could not create remote AdManager.", e);
            return null;
        }
    }

    protected bxo m10198a(IBinder iBinder) {
        return bxp.m10321a(iBinder);
    }

    protected /* synthetic */ Object mo1119b(IBinder iBinder) {
        return m10198a(iBinder);
    }
}
