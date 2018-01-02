package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.firebase.database.connection.idl.ConnectionConfig;
import java.util.List;

class edz implements edx {
    private IBinder f10866a;

    edz(IBinder iBinder) {
        this.f10866a = iBinder;
    }

    public IBinder asBinder() {
        return this.f10866a;
    }

    public void compareAndPut(List<String> list, ckg com_ushareit_listenit_ckg, String str, eed com_ushareit_listenit_eed) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeString(str);
            if (com_ushareit_listenit_eed != null) {
                iBinder = com_ushareit_listenit_eed.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f10866a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void initialize() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            this.f10866a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void interrupt(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeString(str);
            this.f10866a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean isInterrupted(String str) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeString(str);
            this.f10866a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void listen(List<String> list, ckg com_ushareit_listenit_ckg, edu com_ushareit_listenit_edu, long j, eed com_ushareit_listenit_eed) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeStrongBinder(com_ushareit_listenit_edu != null ? com_ushareit_listenit_edu.asBinder() : null);
            obtain.writeLong(j);
            if (com_ushareit_listenit_eed != null) {
                iBinder = com_ushareit_listenit_eed.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f10866a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void merge(List<String> list, ckg com_ushareit_listenit_ckg, eed com_ushareit_listenit_eed) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (com_ushareit_listenit_eed != null) {
                iBinder = com_ushareit_listenit_eed.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f10866a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void onDisconnectCancel(List<String> list, eed com_ushareit_listenit_eed) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(com_ushareit_listenit_eed != null ? com_ushareit_listenit_eed.asBinder() : null);
            this.f10866a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void onDisconnectMerge(List<String> list, ckg com_ushareit_listenit_ckg, eed com_ushareit_listenit_eed) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (com_ushareit_listenit_eed != null) {
                iBinder = com_ushareit_listenit_eed.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f10866a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void onDisconnectPut(List<String> list, ckg com_ushareit_listenit_ckg, eed com_ushareit_listenit_eed) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (com_ushareit_listenit_eed != null) {
                iBinder = com_ushareit_listenit_eed.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f10866a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void purgeOutstandingWrites() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            this.f10866a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void put(List<String> list, ckg com_ushareit_listenit_ckg, eed com_ushareit_listenit_eed) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (com_ushareit_listenit_eed != null) {
                iBinder = com_ushareit_listenit_eed.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f10866a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void refreshAuthToken() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            this.f10866a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void refreshAuthToken2(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeString(str);
            this.f10866a.transact(17, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void resume(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeString(str);
            this.f10866a.transact(15, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void setup(ConnectionConfig connectionConfig, edo com_ushareit_listenit_edo, ckg com_ushareit_listenit_ckg, eea com_ushareit_listenit_eea) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            if (connectionConfig != null) {
                obtain.writeInt(1);
                connectionConfig.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_edo != null ? com_ushareit_listenit_edo.asBinder() : null);
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (com_ushareit_listenit_eea != null) {
                iBinder = com_ushareit_listenit_eea.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f10866a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void shutdown() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            this.f10866a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void unlisten(List<String> list, ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IPersistentConnection");
            obtain.writeStringList(list);
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f10866a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
