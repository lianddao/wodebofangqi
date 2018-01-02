package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.api.model.CreateAuthUriResponse;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetTokenResponse;

public abstract class clt extends Binder implements cls {
    public clt() {
        attachInterface(this, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    public static cls m11621a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof cls)) ? new clu(iBinder) : (cls) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                mo1405a(parcel.readInt() != 0 ? (GetTokenResponse) GetTokenResponse.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 2:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                mo1406a(parcel.readInt() != 0 ? (GetTokenResponse) GetTokenResponse.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (GetAccountInfoUser) GetAccountInfoUser.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 3:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                mo1404a(parcel.readInt() != 0 ? (CreateAuthUriResponse) CreateAuthUriResponse.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 4:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                mo1402a();
                return true;
            case 5:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                mo1403a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 6:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                mo1407b();
                return true;
            case 7:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                mo1408c();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
