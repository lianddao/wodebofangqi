package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class bvd extends Binder implements bvc {
    public static bvc m9948a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof bvc)) ? new bve(iBinder) : (bvc) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        float e;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                mo1106a();
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                mo1109b();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean z;
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                mo1108a(z);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                boolean c = mo1110c();
                parcel2.writeNoException();
                if (c) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                i3 = mo1111d();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                e = mo1112e();
                parcel2.writeNoException();
                parcel2.writeFloat(e);
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                e = mo1113f();
                parcel2.writeNoException();
                parcel2.writeFloat(e);
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                mo1107a(bvg.m9962a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                e = mo1114g();
                parcel2.writeNoException();
                parcel2.writeFloat(e);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.client.IVideoController");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
