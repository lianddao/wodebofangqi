package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public abstract class dlg extends Binder implements dlf {
    public static dlf m14761a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dlf)) ? new dlh(iBinder) : (dlf) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        ProxyGrpcRequest proxyGrpcRequest = null;
        dlc a;
        switch (i) {
            case 1:
                ProxyRequest proxyRequest;
                parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                a = dld.m14755a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    proxyRequest = (ProxyRequest) ProxyRequest.CREATOR.createFromParcel(parcel);
                }
                mo1941a(a, proxyRequest);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                a = dld.m14755a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    proxyGrpcRequest = (ProxyGrpcRequest) ProxyGrpcRequest.CREATOR.createFromParcel(parcel);
                }
                mo1940a(a, proxyGrpcRequest);
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                mo1939a(dld.m14755a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.auth.api.internal.IAuthService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
