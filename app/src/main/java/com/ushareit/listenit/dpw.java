package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class dpw extends Binder implements dpv {
    public static dpv m15254a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dpv)) ? new dpx(iBinder) : (dpv) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
                mo2020a(dpt.m15237a(parcel.readStrongBinder()));
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
