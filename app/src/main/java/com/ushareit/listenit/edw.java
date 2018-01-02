package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.firebase.database.connection.idl.CompoundHashParcelable;

class edw implements edu {
    private IBinder f10865a;

    edw(IBinder iBinder) {
        this.f10865a = iBinder;
    }

    public String mo2146a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IListenHashProvider");
            this.f10865a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10865a;
    }

    public boolean mo2147b() {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IListenHashProvider");
            this.f10865a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public CompoundHashParcelable mo2148c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IListenHashProvider");
            this.f10865a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            CompoundHashParcelable compoundHashParcelable = obtain2.readInt() != 0 ? (CompoundHashParcelable) CompoundHashParcelable.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return compoundHashParcelable;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
