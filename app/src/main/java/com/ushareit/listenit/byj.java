package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;

public abstract class byj extends Binder implements byi {
    public static byi m10379a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof byi)) ? new byk(iBinder) : (byi) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                mo1199a(parcel.readInt() != 0 ? (RewardedVideoAdRequestParcel) RewardedVideoAdRequestParcel.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                mo1198a();
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                mo1200a(byp.m10401a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                mo1202a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                boolean b = mo1204b();
                parcel2.writeNoException();
                parcel2.writeInt(b ? 1 : 0);
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                mo1205c();
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                mo1207d();
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                mo1208e();
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                mo1201a(ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                mo1203b(ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                mo1206c(ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
