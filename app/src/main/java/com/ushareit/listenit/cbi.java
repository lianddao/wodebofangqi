package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.internal.DeleteRequest;
import com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest;
import com.google.android.gms.auth.api.credentials.internal.SaveRequest;

public abstract class cbi extends Binder implements cbh {
    public static cbh m10681a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof cbh)) ? new cbj(iBinder) : (cbh) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        GeneratePasswordRequest generatePasswordRequest = null;
        cbe a;
        switch (i) {
            case 1:
                CredentialRequest credentialRequest;
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                a = cbf.m10672a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    credentialRequest = (CredentialRequest) CredentialRequest.CREATOR.createFromParcel(parcel);
                }
                mo1251a(a, credentialRequest);
                parcel2.writeNoException();
                return true;
            case 2:
                SaveRequest saveRequest;
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                a = cbf.m10672a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    saveRequest = (SaveRequest) SaveRequest.CREATOR.createFromParcel(parcel);
                }
                mo1254a(a, saveRequest);
                parcel2.writeNoException();
                return true;
            case 3:
                DeleteRequest deleteRequest;
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                a = cbf.m10672a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    deleteRequest = (DeleteRequest) DeleteRequest.CREATOR.createFromParcel(parcel);
                }
                mo1252a(a, deleteRequest);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                mo1250a(cbf.m10672a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                a = cbf.m10672a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    generatePasswordRequest = (GeneratePasswordRequest) GeneratePasswordRequest.CREATOR.createFromParcel(parcel);
                }
                mo1253a(a, generatePasswordRequest);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
