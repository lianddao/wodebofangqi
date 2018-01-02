package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class ccm extends Binder implements ccl {
    public ccm() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.IRevocationService");
                mo1285a();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.signin.internal.IRevocationService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
