package com.ushareit.listenit;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class daa extends Binder implements czz {
    public static czz m13592a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.storage.network.INetworkRequestFactory");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof czz)) ? new dab(iBinder) : (czz) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        czw a;
        String a2;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a = mo1687a(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 2:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a = mo1695b(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 3:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a = mo1688a(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, ckh.m11511a(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 4:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a = mo1691a(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, ckh.m11511a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 5:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a = mo1692a(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, ckh.m11511a(parcel.readStrongBinder()), parcel.readString(), ckh.m11511a(parcel.readStrongBinder()), parcel.readLong(), parcel.readInt(), parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 6:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a = mo1696b(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, ckh.m11511a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 7:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a = mo1698c(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, ckh.m11511a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 8:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a = mo1690a(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, ckh.m11511a(parcel.readStrongBinder()), ckh.m11511a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 9:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a = mo1689a(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, ckh.m11511a(parcel.readStrongBinder()), ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 10:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a2 = mo1693a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            case 11:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a2 = mo1694a(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            case 12:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                a2 = mo1697b(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.firebase.storage.network.INetworkRequestFactory");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
