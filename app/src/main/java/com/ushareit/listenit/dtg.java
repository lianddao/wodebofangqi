package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.internal.FusedLocationProviderResult;

class dtg implements dte {
    private IBinder f10315a;

    dtg(IBinder iBinder) {
        this.f10315a = iBinder;
    }

    public void mo2033a(FusedLocationProviderResult fusedLocationProviderResult) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (fusedLocationProviderResult != null) {
                obtain.writeInt(1);
                fusedLocationProviderResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10315a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10315a;
    }
}
