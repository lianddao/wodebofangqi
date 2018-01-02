package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class dqy extends Binder implements dqx {
    public static dqx m15304a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dqx)) ? new dqz(iBinder) : (dqx) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int a;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                a = mo2024a(ckh.m11511a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a);
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                ckg a2 = mo2026a(ckh.m11511a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a2 != null ? a2.asBinder() : null);
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                a = mo2025a(ckh.m11511a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.dynamite.IDynamiteLoader");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
