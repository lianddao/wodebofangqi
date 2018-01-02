package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

public abstract class bxv extends Binder implements bxu {
    public static bxu m10335a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof bxu)) ? new bxw(iBinder) : (bxu) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        IBinder iBinder = null;
        bxl a;
        bya a2;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                a = mo1185a(ckh.m11511a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), dij.m14414a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                a = mo1190b(ckh.m11511a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), dij.m14414a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                bxf a3 = mo1183a(ckh.m11511a(parcel.readStrongBinder()), parcel.readString(), dij.m14414a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                if (a3 != null) {
                    iBinder = a3.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                a2 = mo1186a(ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (a2 != null) {
                    iBinder = a2.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                dhb a4 = mo1189a(ckh.m11511a(parcel.readStrongBinder()), ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (a4 != null) {
                    iBinder = a4.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                byi a5 = mo1188a(ckh.m11511a(parcel.readStrongBinder()), dij.m14414a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                if (a5 != null) {
                    iBinder = a5.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                djz b = mo1191b(ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (b != null) {
                    iBinder = b.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                djn c = mo1192c(ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (c != null) {
                    iBinder = c.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                a2 = mo1187a(ckh.m11511a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                if (a2 != null) {
                    iBinder = a2.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 10:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                a = mo1184a(ckh.m11511a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.client.IClientApi");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
