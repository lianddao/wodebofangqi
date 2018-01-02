package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class edp extends Binder implements edo {
    public edp() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
    }

    public static edo m16779a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof edo)) ? new edq(iBinder) : (edo) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
                mo2143a(parcel.readInt() != 0, eds.m16786a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
