package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.config.internal.FetchConfigIpcResponse;
import java.util.Map;

class ckb implements cjz {
    private IBinder f8381a;

    ckb(IBinder iBinder) {
        this.f8381a = iBinder;
    }

    public void mo1379a(Status status) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8381a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1380a(Status status, FetchConfigIpcResponse fetchConfigIpcResponse) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (fetchConfigIpcResponse != null) {
                obtain.writeInt(1);
                fetchConfigIpcResponse.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8381a.transact(4, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1381a(Status status, Map map) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeMap(map);
            this.f8381a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1382a(Status status, byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.config.internal.IConfigCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeByteArray(bArr);
            this.f8381a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f8381a;
    }
}
