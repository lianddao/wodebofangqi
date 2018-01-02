package com.ushareit.listenit;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;

class dtj implements dth {
    private IBinder f10316a;

    dtj(IBinder iBinder) {
        this.f10316a = iBinder;
    }

    public void mo2034a(int i, PendingIntent pendingIntent) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            obtain.writeInt(i);
            if (pendingIntent != null) {
                obtain.writeInt(1);
                pendingIntent.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10316a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo2035a(int i, String[] strArr) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            obtain.writeInt(i);
            obtain.writeStringArray(strArr);
            this.f10316a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10316a;
    }

    public void mo2036b(int i, String[] strArr) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            obtain.writeInt(i);
            obtain.writeStringArray(strArr);
            this.f10316a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
