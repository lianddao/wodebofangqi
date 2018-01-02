package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

class ccs implements ccq {
    private IBinder f8131a;

    ccs(IBinder iBinder) {
        this.f8131a = iBinder;
    }

    public void mo1282a(ccn com_ushareit_listenit_ccn, GoogleSignInOptions googleSignInOptions) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            obtain.writeStrongBinder(com_ushareit_listenit_ccn != null ? com_ushareit_listenit_ccn.asBinder() : null);
            if (googleSignInOptions != null) {
                obtain.writeInt(1);
                googleSignInOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8131a.transact(101, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f8131a;
    }

    public void mo1283b(ccn com_ushareit_listenit_ccn, GoogleSignInOptions googleSignInOptions) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            obtain.writeStrongBinder(com_ushareit_listenit_ccn != null ? com_ushareit_listenit_ccn.asBinder() : null);
            if (googleSignInOptions != null) {
                obtain.writeInt(1);
                googleSignInOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8131a.transact(102, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1284c(ccn com_ushareit_listenit_ccn, GoogleSignInOptions googleSignInOptions) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
            obtain.writeStrongBinder(com_ushareit_listenit_ccn != null ? com_ushareit_listenit_ccn.asBinder() : null);
            if (googleSignInOptions != null) {
                obtain.writeInt(1);
                googleSignInOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8131a.transact(103, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
