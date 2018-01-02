package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;

public class die extends ckk<dhe> {
    public die() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public dhb m14405a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable e;
        try {
            return dhc.m10152a(((dhe) m10057b(context)).mo1764a(ckj.m11512a((Object) context), ckj.m11512a((Object) frameLayout), ckj.m11512a((Object) frameLayout2), cge.f8237a));
        } catch (RemoteException e2) {
            e = e2;
            bze.m10491c("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (ckl e3) {
            e = e3;
            bze.m10491c("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    protected dhe m14406a(IBinder iBinder) {
        return dhf.m14311a(iBinder);
    }

    protected /* synthetic */ Object mo1119b(IBinder iBinder) {
        return m14406a(iBinder);
    }
}
