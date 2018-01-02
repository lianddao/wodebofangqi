package com.ushareit.listenit;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;

class dab implements czz {
    private IBinder f9443a;

    dab(IBinder iBinder) {
        this.f9443a = iBinder;
    }

    public czw mo1687a(Uri uri, ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f9443a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            czw a = czx.m13562a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public czw mo1688a(Uri uri, ckg com_ushareit_listenit_ckg, long j) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeLong(j);
            this.f9443a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            czw a = czx.m13562a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public czw mo1689a(Uri uri, ckg com_ushareit_listenit_ckg, ckg com_ushareit_listenit_ckg2) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (com_ushareit_listenit_ckg2 != null) {
                iBinder = com_ushareit_listenit_ckg2.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f9443a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            czw a = czx.m13562a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public czw mo1690a(Uri uri, ckg com_ushareit_listenit_ckg, ckg com_ushareit_listenit_ckg2, String str) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (com_ushareit_listenit_ckg2 != null) {
                iBinder = com_ushareit_listenit_ckg2.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeString(str);
            this.f9443a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            czw a = czx.m13562a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public czw mo1691a(Uri uri, ckg com_ushareit_listenit_ckg, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeString(str);
            this.f9443a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            czw a = czx.m13562a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public czw mo1692a(Uri uri, ckg com_ushareit_listenit_ckg, String str, ckg com_ushareit_listenit_ckg2, long j, int i, boolean z) {
        IBinder iBinder = null;
        int i2 = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeString(str);
            if (com_ushareit_listenit_ckg2 != null) {
                iBinder = com_ushareit_listenit_ckg2.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeLong(j);
            obtain.writeInt(i);
            if (!z) {
                i2 = 0;
            }
            obtain.writeInt(i2);
            this.f9443a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            czw a = czx.m13562a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String mo1693a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            this.f9443a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String mo1694a(Uri uri) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f9443a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9443a;
    }

    public czw mo1695b(Uri uri, ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f9443a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            czw a = czx.m13562a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public czw mo1696b(Uri uri, ckg com_ushareit_listenit_ckg, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeString(str);
            this.f9443a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            czw a = czx.m13562a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String mo1697b(Uri uri) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f9443a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public czw mo1698c(Uri uri, ckg com_ushareit_listenit_ckg, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.storage.network.INetworkRequestFactory");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeString(str);
            this.f9443a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            czw a = czx.m13562a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
