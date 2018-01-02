package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.List;

class dxd implements dxb {
    private IBinder f10542a;

    dxd(IBinder iBinder) {
        this.f10542a = iBinder;
    }

    public List<UserAttributeParcel> mo2100a(AppMetadata appMetadata, boolean z) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            this.f10542a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            List<UserAttributeParcel> createTypedArrayList = obtain2.createTypedArrayList(UserAttributeParcel.CREATOR);
            return createTypedArrayList;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2101a(AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10542a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2102a(EventParcel eventParcel, AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10542a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2103a(EventParcel eventParcel, String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f10542a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2104a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (userAttributeParcel != null) {
                obtain.writeInt(1);
                userAttributeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10542a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public byte[] mo2105a(EventParcel eventParcel, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            this.f10542a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            return createByteArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10542a;
    }

    public void mo2106b(AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f10542a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
