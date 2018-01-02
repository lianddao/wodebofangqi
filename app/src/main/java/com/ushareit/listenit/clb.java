package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;

class clb implements ckz {
    private IBinder f8401a;

    clb(IBinder iBinder) {
        this.f8401a = iBinder;
    }

    public void mo1391a(Message message) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            if (message != null) {
                obtain.writeInt(1);
                message.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8401a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f8401a;
    }
}
