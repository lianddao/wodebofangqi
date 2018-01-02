package com.ushareit.listenit;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

class dla implements dky {
    private IBinder f9873a;

    dla(IBinder iBinder) {
        this.f9873a = iBinder;
    }

    public void mo1935a(Account account, int i, dkv com_ushareit_listenit_dkv) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService");
            if (account != null) {
                obtain.writeInt(1);
                account.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            obtain.writeStrongBinder(com_ushareit_listenit_dkv != null ? com_ushareit_listenit_dkv.asBinder() : null);
            this.f9873a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9873a;
    }
}
