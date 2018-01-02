package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.firebase.database.connection.idl.ConnectionConfig;

public abstract class edy extends Binder implements edx {
    public edy() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IPersistentConnection");
    }

    public static edx asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof edx)) ? new edz(iBinder) : (edx) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                setup(parcel.readInt() != 0 ? (ConnectionConfig) ConnectionConfig.CREATOR.createFromParcel(parcel) : null, edp.m16779a(parcel.readStrongBinder()), ckh.m11511a(parcel.readStrongBinder()), eeb.m16765a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                initialize();
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                shutdown();
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                refreshAuthToken();
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                listen(parcel.createStringArrayList(), ckh.m11511a(parcel.readStrongBinder()), edv.m16816a(parcel.readStrongBinder()), parcel.readLong(), eee.m16821a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                unlisten(parcel.createStringArrayList(), ckh.m11511a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                purgeOutstandingWrites();
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                put(parcel.createStringArrayList(), ckh.m11511a(parcel.readStrongBinder()), eee.m16821a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                compareAndPut(parcel.createStringArrayList(), ckh.m11511a(parcel.readStrongBinder()), parcel.readString(), eee.m16821a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                merge(parcel.createStringArrayList(), ckh.m11511a(parcel.readStrongBinder()), eee.m16821a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                onDisconnectPut(parcel.createStringArrayList(), ckh.m11511a(parcel.readStrongBinder()), eee.m16821a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                onDisconnectMerge(parcel.createStringArrayList(), ckh.m11511a(parcel.readStrongBinder()), eee.m16821a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                onDisconnectCancel(parcel.createStringArrayList(), eee.m16821a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                interrupt(parcel.readString());
                parcel2.writeNoException();
                return true;
            case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                resume(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                boolean isInterrupted = isInterrupted(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(isInterrupted ? 1 : 0);
                return true;
            case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
                parcel.enforceInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
                refreshAuthToken2(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.firebase.database.connection.idl.IPersistentConnection");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
