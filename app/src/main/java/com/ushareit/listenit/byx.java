package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;

class byx implements byv {
    private IBinder f7953a;

    byx(IBinder iBinder) {
        this.f7953a = iBinder;
    }

    public void mo1219a(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f7953a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1220a(ckg com_ushareit_listenit_ckg, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeInt(i);
            this.f7953a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1221a(ckg com_ushareit_listenit_ckg, RewardItemParcel rewardItemParcel) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (rewardItemParcel != null) {
                obtain.writeInt(1);
                rewardItemParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f7953a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f7953a;
    }

    public void mo1222b(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f7953a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1223b(ckg com_ushareit_listenit_ckg, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeInt(i);
            this.f7953a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1224c(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f7953a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1225d(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f7953a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1226e(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f7953a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1227f(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f7953a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1228g(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f7953a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
