package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.firebase.database.connection.idl.CompoundHashParcelable;

public abstract class edv extends Binder implements edu {
    public edv() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IListenHashProvider");
    }

    public static edu m16816a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IListenHashProvider");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof edu)) ? new edw(iBinder) : (edu) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IListenHashProvider");
                String a = mo2146a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IListenHashProvider");
                boolean b = mo2147b();
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 3:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IListenHashProvider");
                CompoundHashParcelable c = mo2148c();
                parcel2.writeNoException();
                if (c != null) {
                    parcel2.writeInt(1);
                    c.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.firebase.database.connection.idl.IListenHashProvider");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
