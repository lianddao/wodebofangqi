package com.ushareit.listenit;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;

class dgz implements dgx {
    private IBinder f9792a;

    dgz(IBinder iBinder) {
        this.f9792a = iBinder;
    }

    public ckg mo1193a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.f9792a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            ckg a = ckh.m11511a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9792a;
    }

    public Uri mo1194b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.f9792a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            Uri uri = obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return uri;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public double mo1195c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.f9792a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            double readDouble = obtain2.readDouble();
            return readDouble;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
