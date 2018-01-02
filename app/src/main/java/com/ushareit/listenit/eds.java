package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class eds extends Binder implements edr {
    public eds() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IGetTokenCallback");
    }

    public static edr m16786a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IGetTokenCallback");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof edr)) ? new edt(iBinder) : (edr) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IGetTokenCallback");
                mo2144a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IGetTokenCallback");
                mo2145b(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.firebase.database.connection.idl.IGetTokenCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
