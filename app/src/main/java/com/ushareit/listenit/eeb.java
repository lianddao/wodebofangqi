package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.firebase.database.connection.idl.RangeParcelable;
import java.util.List;

public abstract class eeb extends Binder implements eea {
    public eeb() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
    }

    public static eea m16765a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof eea)) ? new eec(iBinder) : (eea) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = false;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                List createStringArrayList = parcel.createStringArrayList();
                ckg a = ckh.m11511a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    z = true;
                }
                mo2139a(createStringArrayList, a, z, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                mo2140a(parcel.createStringArrayList(), parcel.createTypedArrayList(RangeParcelable.CREATOR), ckh.m11511a(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                mo2137a();
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                mo2142b();
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                mo2141a(z);
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                mo2138a(ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
