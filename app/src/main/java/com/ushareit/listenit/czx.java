package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class czx extends Binder implements czw {
    public static czw m13562a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.storage.network.INetworkRequest");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof czw)) ? new czy(iBinder) : (czw) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        IBinder iBinder = null;
        String c;
        ckg c2;
        int h;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                mo1674a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                mo1673a();
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                mo1677b(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                mo1676b();
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                mo1675a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                c = mo1679c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            case 7:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                c2 = mo1678c();
                parcel2.writeNoException();
                if (c2 != null) {
                    iBinder = c2.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 8:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                c2 = mo1680d();
                parcel2.writeNoException();
                if (c2 != null) {
                    iBinder = c2.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 9:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                c = mo1681e();
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            case 10:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                c2 = mo1682f();
                parcel2.writeNoException();
                if (c2 != null) {
                    iBinder = c2.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 11:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                c2 = mo1683g();
                parcel2.writeNoException();
                if (c2 != null) {
                    iBinder = c2.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 12:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                h = mo1684h();
                parcel2.writeNoException();
                parcel2.writeInt(h);
                return true;
            case 13:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                boolean i3 = mo1685i();
                parcel2.writeNoException();
                parcel2.writeInt(i3 ? 1 : 0);
                return true;
            case 14:
                parcel.enforceInterface("com.google.firebase.storage.network.INetworkRequest");
                h = mo1686j();
                parcel2.writeNoException();
                parcel2.writeInt(h);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.firebase.storage.network.INetworkRequest");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
