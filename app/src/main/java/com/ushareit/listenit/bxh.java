package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;

class bxh implements bxf {
    private IBinder f7930a;

    bxh(IBinder iBinder) {
        this.f7930a = iBinder;
    }

    public bxc mo1120a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            this.f7930a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            bxc a = bxd.m10081a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1121a(NativeAdOptionsParcel nativeAdOptionsParcel) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (nativeAdOptionsParcel != null) {
                obtain.writeInt(1);
                nativeAdOptionsParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f7930a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1122a(bwz com_ushareit_listenit_bwz) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            obtain.writeStrongBinder(com_ushareit_listenit_bwz != null ? com_ushareit_listenit_bwz.asBinder() : null);
            this.f7930a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1123a(bxx com_ushareit_listenit_bxx) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            obtain.writeStrongBinder(com_ushareit_listenit_bxx != null ? com_ushareit_listenit_bxx.asBinder() : null);
            this.f7930a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1124a(dhs com_ushareit_listenit_dhs) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            obtain.writeStrongBinder(com_ushareit_listenit_dhs != null ? com_ushareit_listenit_dhs.asBinder() : null);
            this.f7930a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1125a(dhv com_ushareit_listenit_dhv) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            obtain.writeStrongBinder(com_ushareit_listenit_dhv != null ? com_ushareit_listenit_dhv.asBinder() : null);
            this.f7930a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1126a(String str, dib com_ushareit_listenit_dib, dhy com_ushareit_listenit_dhy) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            obtain.writeString(str);
            obtain.writeStrongBinder(com_ushareit_listenit_dib != null ? com_ushareit_listenit_dib.asBinder() : null);
            if (com_ushareit_listenit_dhy != null) {
                iBinder = com_ushareit_listenit_dhy.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f7930a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f7930a;
    }
}
