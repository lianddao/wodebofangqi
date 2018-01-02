package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;

public abstract class bxg extends Binder implements bxf {
    public bxg() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    public static bxf m10069a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof bxf)) ? new bxh(iBinder) : (bxf) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        NativeAdOptionsParcel nativeAdOptionsParcel = null;
        switch (i) {
            case 1:
                IBinder asBinder;
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                bxc a = mo1120a();
                parcel2.writeNoException();
                if (a != null) {
                    asBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                mo1122a(bxa.m10188a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                mo1124a(dht.m14394a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                mo1125a(dhw.m14397a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                mo1126a(parcel.readString(), dic.m14403a(parcel.readStrongBinder()), dhz.m14400a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                if (parcel.readInt() != 0) {
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) NativeAdOptionsParcel.CREATOR.createFromParcel(parcel);
                }
                mo1121a(nativeAdOptionsParcel);
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                mo1123a(bxy.m10273a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
