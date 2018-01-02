package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.config.internal.FetchConfigIpcResponse;

public abstract class cka extends Binder implements cjz {
    public cka() {
        attachInterface(this, "com.google.android.gms.config.internal.IConfigCallbacks");
    }

    public static cjz m11463a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.config.internal.IConfigCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof cjz)) ? new ckb(iBinder) : (cjz) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.config.internal.IConfigCallbacks");
                mo1382a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.config.internal.IConfigCallbacks");
                mo1381a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readHashMap(getClass().getClassLoader()));
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.config.internal.IConfigCallbacks");
                mo1379a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.config.internal.IConfigCallbacks");
                mo1380a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (FetchConfigIpcResponse) FetchConfigIpcResponse.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.config.internal.IConfigCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
