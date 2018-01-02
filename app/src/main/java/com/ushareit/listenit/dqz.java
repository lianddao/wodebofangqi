package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dqz implements dqx {
    private IBinder f10176a;

    dqz(IBinder iBinder) {
        this.f10176a = iBinder;
    }

    public int mo2024a(ckg com_ushareit_listenit_ckg, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeString(str);
            this.f10176a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int mo2025a(ckg com_ushareit_listenit_ckg, String str, boolean z) {
        int i = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeString(str);
            if (z) {
                i = 1;
            }
            obtain.writeInt(i);
            this.f10176a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            i = obtain2.readInt();
            return i;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public ckg mo2026a(ckg com_ushareit_listenit_ckg, String str, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeString(str);
            obtain.writeInt(i);
            this.f10176a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            ckg a = ckh.m11511a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10176a;
    }
}
