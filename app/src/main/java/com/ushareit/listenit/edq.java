package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class edq implements edo {
    private IBinder f10863a;

    edq(IBinder iBinder) {
        this.f10863a = iBinder;
    }

    public void mo2143a(boolean z, edr com_ushareit_listenit_edr) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            obtain.writeStrongBinder(com_ushareit_listenit_edr != null ? com_ushareit_listenit_edr.asBinder() : null);
            this.f10863a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10863a;
    }
}
