package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

class bxw implements bxu {
    private IBinder f7935a;

    bxw(IBinder iBinder) {
        this.f7935a = iBinder;
    }

    public bxf mo1183a(ckg com_ushareit_listenit_ckg, String str, dii com_ushareit_listenit_dii, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeString(str);
            if (com_ushareit_listenit_dii != null) {
                iBinder = com_ushareit_listenit_dii.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f7935a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            bxf a = bxg.m10069a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public bxl mo1184a(ckg com_ushareit_listenit_ckg, AdSizeParcel adSizeParcel, String str, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (adSizeParcel != null) {
                obtain.writeInt(1);
                adSizeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            obtain.writeInt(i);
            this.f7935a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            bxl a = bxm.m10110a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public bxl mo1185a(ckg com_ushareit_listenit_ckg, AdSizeParcel adSizeParcel, String str, dii com_ushareit_listenit_dii, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (adSizeParcel != null) {
                obtain.writeInt(1);
                adSizeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (com_ushareit_listenit_dii != null) {
                iBinder = com_ushareit_listenit_dii.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f7935a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            bxl a = bxm.m10110a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public bya mo1186a(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f7935a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            bya a = byb.m10142a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public bya mo1187a(ckg com_ushareit_listenit_ckg, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeInt(i);
            this.f7935a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            bya a = byb.m10142a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public byi mo1188a(ckg com_ushareit_listenit_ckg, dii com_ushareit_listenit_dii, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (com_ushareit_listenit_dii != null) {
                iBinder = com_ushareit_listenit_dii.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f7935a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            byi a = byj.m10379a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public dhb mo1189a(ckg com_ushareit_listenit_ckg, ckg com_ushareit_listenit_ckg2) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (com_ushareit_listenit_ckg2 != null) {
                iBinder = com_ushareit_listenit_ckg2.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f7935a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            dhb a = dhc.m10152a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f7935a;
    }

    public bxl mo1190b(ckg com_ushareit_listenit_ckg, AdSizeParcel adSizeParcel, String str, dii com_ushareit_listenit_dii, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (adSizeParcel != null) {
                obtain.writeInt(1);
                adSizeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (com_ushareit_listenit_dii != null) {
                iBinder = com_ushareit_listenit_dii.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f7935a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            bxl a = bxm.m10110a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public djz mo1191b(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f7935a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            djz a = dka.m14707a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public djn mo1192c(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f7935a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            djn a = djo.m14677a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
