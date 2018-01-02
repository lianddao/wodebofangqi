package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

class duj implements duh {
    private IBinder f10333a;

    duj(IBinder iBinder) {
        this.f10333a = iBinder;
    }

    public void mo2072a(LocationAvailability locationAvailability) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
            if (locationAvailability != null) {
                obtain.writeInt(1);
                locationAvailability.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10333a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo2073a(LocationResult locationResult) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
            if (locationResult != null) {
                obtain.writeInt(1);
                locationResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10333a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10333a;
    }
}
