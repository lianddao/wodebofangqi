package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class bxt implements bxr {
    private IBinder f7934a;

    bxt(IBinder iBinder) {
        this.f7934a = iBinder;
    }

    public void mo1176a(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAppEventListener");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f7934a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f7934a;
    }
}
