package com.ushareit.listenit;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

class cho implements chm {
    private IBinder f8318a;

    cho(IBinder iBinder) {
        this.f8318a = iBinder;
    }

    public Account mo1302a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
            this.f8318a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            Account account = obtain2.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return account;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f8318a;
    }
}
