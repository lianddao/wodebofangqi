package com.ushareit.listenit;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class dti extends Binder implements dth {
    public static dth m15482a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dth)) ? new dtj(iBinder) : (dth) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                mo2035a(parcel.readInt(), parcel.createStringArray());
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                mo2036b(parcel.readInt(), parcel.createStringArray());
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                mo2034a(parcel.readInt(), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
