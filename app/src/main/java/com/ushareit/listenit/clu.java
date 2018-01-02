package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.api.model.CreateAuthUriResponse;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetTokenResponse;

class clu implements cls {
    private IBinder f8436a;

    clu(IBinder iBinder) {
        this.f8436a = iBinder;
    }

    public void mo1402a() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
            this.f8436a.transact(4, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1403a(Status status) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8436a.transact(5, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1404a(CreateAuthUriResponse createAuthUriResponse) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
            if (createAuthUriResponse != null) {
                obtain.writeInt(1);
                createAuthUriResponse.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8436a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1405a(GetTokenResponse getTokenResponse) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
            if (getTokenResponse != null) {
                obtain.writeInt(1);
                getTokenResponse.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8436a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1406a(GetTokenResponse getTokenResponse, GetAccountInfoUser getAccountInfoUser) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
            if (getTokenResponse != null) {
                obtain.writeInt(1);
                getTokenResponse.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (getAccountInfoUser != null) {
                obtain.writeInt(1);
                getAccountInfoUser.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8436a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f8436a;
    }

    public void mo1407b() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
            this.f8436a.transact(6, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1408c() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
            this.f8436a.transact(7, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
