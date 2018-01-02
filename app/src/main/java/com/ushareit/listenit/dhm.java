package com.ushareit.listenit;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public abstract class dhm extends Binder implements dhl {
    public static dhl m14360a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dhl)) ? new dhn(iBinder) : (dhl) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        IBinder iBinder = null;
        String b;
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                ckg a = mo1788a();
                parcel2.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                b = mo1789b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                List c = mo1790c();
                parcel2.writeNoException();
                parcel2.writeList(c);
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                b = mo1791d();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                dgx e = mo1792e();
                parcel2.writeNoException();
                if (e != null) {
                    iBinder = e.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                b = mo1793f();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                b = mo1794g();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                Bundle h = mo1795h();
                parcel2.writeNoException();
                if (h != null) {
                    parcel2.writeInt(1);
                    h.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 10:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                mo1796i();
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
