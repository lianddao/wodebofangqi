package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

class dlh implements dlf {
    private IBinder f9876a;

    dlh(IBinder iBinder) {
        this.f9876a = iBinder;
    }

    public void mo1939a(dlc com_ushareit_listenit_dlc) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
            obtain.writeStrongBinder(com_ushareit_listenit_dlc != null ? com_ushareit_listenit_dlc.asBinder() : null);
            this.f9876a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1940a(dlc com_ushareit_listenit_dlc, ProxyGrpcRequest proxyGrpcRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
            obtain.writeStrongBinder(com_ushareit_listenit_dlc != null ? com_ushareit_listenit_dlc.asBinder() : null);
            if (proxyGrpcRequest != null) {
                obtain.writeInt(1);
                proxyGrpcRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f9876a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1941a(dlc com_ushareit_listenit_dlc, ProxyRequest proxyRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
            obtain.writeStrongBinder(com_ushareit_listenit_dlc != null ? com_ushareit_listenit_dlc.asBinder() : null);
            if (proxyRequest != null) {
                obtain.writeInt(1);
                proxyRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f9876a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9876a;
    }
}
