package com.ushareit.listenit;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;

public class byy implements cam {
    private final byv f7954a;

    public byy(byv com_ushareit_listenit_byv) {
        this.f7954a = com_ushareit_listenit_byv;
    }

    public void mo1229a(cal com_ushareit_listenit_cal) {
        cfi.m11088b("onInitializationSucceeded must be called on the main UI thread.");
        bze.m10485a("Adapter called onInitializationSucceeded.");
        try {
            this.f7954a.mo1219a(ckj.m11512a((Object) com_ushareit_listenit_cal));
        } catch (Throwable e) {
            bze.m10491c("Could not call onInitializationSucceeded.", e);
        }
    }

    public void mo1230a(cal com_ushareit_listenit_cal, int i) {
        cfi.m11088b("onAdFailedToLoad must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdFailedToLoad.");
        try {
            this.f7954a.mo1223b(ckj.m11512a((Object) com_ushareit_listenit_cal), i);
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void mo1231a(cal com_ushareit_listenit_cal, caj com_ushareit_listenit_caj) {
        cfi.m11088b("onRewarded must be called on the main UI thread.");
        bze.m10485a("Adapter called onRewarded.");
        if (com_ushareit_listenit_caj != null) {
            try {
                this.f7954a.mo1221a(ckj.m11512a((Object) com_ushareit_listenit_cal), new RewardItemParcel(com_ushareit_listenit_caj));
                return;
            } catch (Throwable e) {
                bze.m10491c("Could not call onRewarded.", e);
                return;
            }
        }
        this.f7954a.mo1221a(ckj.m11512a((Object) com_ushareit_listenit_cal), new RewardItemParcel(com_ushareit_listenit_cal.getClass().getName(), 1));
    }

    public void mo1232b(cal com_ushareit_listenit_cal) {
        cfi.m11088b("onAdLoaded must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdLoaded.");
        try {
            this.f7954a.mo1222b(ckj.m11512a((Object) com_ushareit_listenit_cal));
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdLoaded.", e);
        }
    }

    public void mo1233c(cal com_ushareit_listenit_cal) {
        cfi.m11088b("onAdOpened must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdOpened.");
        try {
            this.f7954a.mo1224c(ckj.m11512a((Object) com_ushareit_listenit_cal));
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdOpened.", e);
        }
    }

    public void mo1234d(cal com_ushareit_listenit_cal) {
        cfi.m11088b("onVideoStarted must be called on the main UI thread.");
        bze.m10485a("Adapter called onVideoStarted.");
        try {
            this.f7954a.mo1225d(ckj.m11512a((Object) com_ushareit_listenit_cal));
        } catch (Throwable e) {
            bze.m10491c("Could not call onVideoStarted.", e);
        }
    }

    public void mo1235e(cal com_ushareit_listenit_cal) {
        cfi.m11088b("onAdClosed must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdClosed.");
        try {
            this.f7954a.mo1226e(ckj.m11512a((Object) com_ushareit_listenit_cal));
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdClosed.", e);
        }
    }

    public void mo1236f(cal com_ushareit_listenit_cal) {
        cfi.m11088b("onAdLeftApplication must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdLeftApplication.");
        try {
            this.f7954a.mo1228g(ckj.m11512a((Object) com_ushareit_listenit_cal));
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdLeftApplication.", e);
        }
    }
}
