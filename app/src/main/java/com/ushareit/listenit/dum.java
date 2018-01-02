package com.ushareit.listenit;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;

class dum implements duk {
    private IBinder f10334a;

    dum(IBinder iBinder) {
        this.f10334a = iBinder;
    }

    public void mo2074a(Location location) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.ILocationListener");
            if (location != null) {
                obtain.writeInt(1);
                location.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10334a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10334a;
    }
}
