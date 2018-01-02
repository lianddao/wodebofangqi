package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.config.internal.FetchConfigIpcRequest;
import com.google.android.gms.phenotype.Configuration;
import java.util.List;

class cke implements ckc {
    private IBinder f8382a;

    cke(IBinder iBinder) {
        this.f8382a = iBinder;
    }

    public void mo1386a(cjz com_ushareit_listenit_cjz, FetchConfigIpcRequest fetchConfigIpcRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
            obtain.writeStrongBinder(com_ushareit_listenit_cjz != null ? com_ushareit_listenit_cjz.asBinder() : null);
            if (fetchConfigIpcRequest != null) {
                obtain.writeInt(1);
                fetchConfigIpcRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8382a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1387a(cjz com_ushareit_listenit_cjz, String str, Configuration configuration, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
            obtain.writeStrongBinder(com_ushareit_listenit_cjz != null ? com_ushareit_listenit_cjz.asBinder() : null);
            obtain.writeString(str);
            if (configuration != null) {
                obtain.writeInt(1);
                configuration.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str2);
            this.f8382a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1388a(cjz com_ushareit_listenit_cjz, String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
            obtain.writeStrongBinder(com_ushareit_listenit_cjz != null ? com_ushareit_listenit_cjz.asBinder() : null);
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f8382a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1389a(cjz com_ushareit_listenit_cjz, String str, List list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
            obtain.writeStrongBinder(com_ushareit_listenit_cjz != null ? com_ushareit_listenit_cjz.asBinder() : null);
            obtain.writeString(str);
            obtain.writeList(list);
            this.f8382a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f8382a;
    }

    public void mo1390b(cjz com_ushareit_listenit_cjz, String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigService");
            obtain.writeStrongBinder(com_ushareit_listenit_cjz != null ? com_ushareit_listenit_cjz.asBinder() : null);
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f8382a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
