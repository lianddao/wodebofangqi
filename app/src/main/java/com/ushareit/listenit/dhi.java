package com.ushareit.listenit;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public abstract class dhi extends Binder implements dhh {
    public static dhh m14325a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dhh)) ? new dhj(iBinder) : (dhh) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        IBinder iBinder = null;
        String b;
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                ckg a = mo1765a();
                parcel2.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                b = mo1766b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                List c = mo1767c();
                parcel2.writeNoException();
                parcel2.writeList(c);
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                b = mo1768d();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                dgx e = mo1769e();
                parcel2.writeNoException();
                if (e != null) {
                    iBinder = e.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                b = mo1770f();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                double g = mo1771g();
                parcel2.writeNoException();
                parcel2.writeDouble(g);
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                b = mo1772h();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 10:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                b = mo1773i();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 11:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                Bundle j = mo1774j();
                parcel2.writeNoException();
                if (j != null) {
                    parcel2.writeInt(1);
                    j.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 12:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                mo1775k();
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                bvc l = mo1776l();
                parcel2.writeNoException();
                if (l != null) {
                    iBinder = l.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
