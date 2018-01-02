package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.SignInButtonConfig;

class cid implements cib {
    private IBinder f8322a;

    cid(IBinder iBinder) {
        this.f8322a = iBinder;
    }

    public ckg mo1368a(ckg com_ushareit_listenit_ckg, int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f8322a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            ckg a = ckh.m11511a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public ckg mo1369a(ckg com_ushareit_listenit_ckg, SignInButtonConfig signInButtonConfig) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (signInButtonConfig != null) {
                obtain.writeInt(1);
                signInButtonConfig.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8322a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            ckg a = ckh.m11511a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f8322a;
    }
}
