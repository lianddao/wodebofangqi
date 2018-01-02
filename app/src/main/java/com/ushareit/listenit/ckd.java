package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.config.internal.FetchConfigIpcRequest;
import com.google.android.gms.phenotype.Configuration;

public abstract class ckd extends Binder implements ckc {
    public static ckc m11502a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.config.internal.IConfigService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ckc)) ? new cke(iBinder) : (ckc) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        FetchConfigIpcRequest fetchConfigIpcRequest = null;
        cjz a;
        switch (i) {
            case 4:
                parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                mo1388a(cka.m11463a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                mo1390b(cka.m11463a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                mo1389a(cka.m11463a(parcel.readStrongBinder()), parcel.readString(), parcel.readArrayList(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 7:
                Configuration configuration;
                parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                a = cka.m11463a(parcel.readStrongBinder());
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    configuration = (Configuration) Configuration.CREATOR.createFromParcel(parcel);
                }
                mo1387a(a, readString, configuration, parcel.readString());
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.config.internal.IConfigService");
                a = cka.m11463a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    fetchConfigIpcRequest = (FetchConfigIpcRequest) FetchConfigIpcRequest.CREATOR.createFromParcel(parcel);
                }
                mo1386a(a, fetchConfigIpcRequest);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.config.internal.IConfigService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
