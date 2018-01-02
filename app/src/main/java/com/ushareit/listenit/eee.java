package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class eee extends Binder implements eed {
    public eee() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IRequestResultCallback");
    }

    public static eed m16821a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IRequestResultCallback");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof eed)) ? new eef(iBinder) : (eed) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IRequestResultCallback");
                mo2149a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.firebase.database.connection.idl.IRequestResultCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
