package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;

public class bvp extends ckk<buz> {
    public bvp() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    protected buz m10059a(IBinder iBinder) {
        return bva.m9937a(iBinder);
    }

    public bya m10060a(Context context) {
        try {
            return byb.m10142a(((buz) m10057b(context)).mo1105a(ckj.m11512a((Object) context), cge.f8237a));
        } catch (Throwable e) {
            bze.m10491c("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (Throwable e2) {
            bze.m10491c("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object mo1119b(IBinder iBinder) {
        return m10059a(iBinder);
    }
}
