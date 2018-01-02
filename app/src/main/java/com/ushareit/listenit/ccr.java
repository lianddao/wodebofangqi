package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public abstract class ccr extends Binder implements ccq {
    public static ccq m10838a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ccq)) ? new ccs(iBinder) : (ccq) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        GoogleSignInOptions googleSignInOptions = null;
        ccn a;
        switch (i) {
            case 101:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                a = cco.m10737a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    googleSignInOptions = (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(parcel);
                }
                mo1282a(a, googleSignInOptions);
                parcel2.writeNoException();
                return true;
            case 102:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                a = cco.m10737a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    googleSignInOptions = (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(parcel);
                }
                mo1283b(a, googleSignInOptions);
                parcel2.writeNoException();
                return true;
            case 103:
                parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                a = cco.m10737a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    googleSignInOptions = (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(parcel);
                }
                mo1284c(a, googleSignInOptions);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
