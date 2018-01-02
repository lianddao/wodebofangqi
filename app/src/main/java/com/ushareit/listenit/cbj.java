package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.internal.DeleteRequest;
import com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest;
import com.google.android.gms.auth.api.credentials.internal.SaveRequest;

class cbj implements cbh {
    private IBinder f8075a;

    cbj(IBinder iBinder) {
        this.f8075a = iBinder;
    }

    public void mo1250a(cbe com_ushareit_listenit_cbe) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            obtain.writeStrongBinder(com_ushareit_listenit_cbe != null ? com_ushareit_listenit_cbe.asBinder() : null);
            this.f8075a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1251a(cbe com_ushareit_listenit_cbe, CredentialRequest credentialRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            obtain.writeStrongBinder(com_ushareit_listenit_cbe != null ? com_ushareit_listenit_cbe.asBinder() : null);
            if (credentialRequest != null) {
                obtain.writeInt(1);
                credentialRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8075a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1252a(cbe com_ushareit_listenit_cbe, DeleteRequest deleteRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            obtain.writeStrongBinder(com_ushareit_listenit_cbe != null ? com_ushareit_listenit_cbe.asBinder() : null);
            if (deleteRequest != null) {
                obtain.writeInt(1);
                deleteRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8075a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1253a(cbe com_ushareit_listenit_cbe, GeneratePasswordRequest generatePasswordRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            obtain.writeStrongBinder(com_ushareit_listenit_cbe != null ? com_ushareit_listenit_cbe.asBinder() : null);
            if (generatePasswordRequest != null) {
                obtain.writeInt(1);
                generatePasswordRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8075a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1254a(cbe com_ushareit_listenit_cbe, SaveRequest saveRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            obtain.writeStrongBinder(com_ushareit_listenit_cbe != null ? com_ushareit_listenit_cbe.asBinder() : null);
            if (saveRequest != null) {
                obtain.writeInt(1);
                saveRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8075a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f8075a;
    }
}
