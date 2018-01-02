package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;

public abstract class bxm extends Binder implements bxl {
    public bxm() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static bxl m10110a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof bxl)) ? new bxn(iBinder) : (bxl) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        VideoOptionsParcel videoOptionsParcel = null;
        int i3 = 0;
        IBinder asBinder;
        boolean c;
        AdSizeParcel i4;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                ckg a = mo1130a();
                parcel2.writeNoException();
                if (a != null) {
                    asBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1144b();
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                c = mo1145c();
                parcel2.writeNoException();
                parcel2.writeInt(c ? 1 : 0);
                return true;
            case 4:
                AdRequestParcel adRequestParcel;
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (parcel.readInt() != 0) {
                    adRequestParcel = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(parcel);
                }
                c = mo1143a(adRequestParcel);
                parcel2.writeNoException();
                if (c) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1146d();
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1147e();
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1134a(bxa.m10188a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1135a(bxs.m10209a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1148f();
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1149g();
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1150h();
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                i4 = mo1151i();
                parcel2.writeNoException();
                if (i4 != null) {
                    parcel2.writeInt(1);
                    i4.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 13:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (parcel.readInt() != 0) {
                    i4 = (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel);
                }
                mo1131a(i4);
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1139a(djx.m14702a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1140a(dkj.m14727a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                String j = mo1152j();
                parcel2.writeNoException();
                parcel2.writeString(j);
                return true;
            case Encoder.LINE_GROUPS /*19*/:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1138a(dgu.m14287a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1133a(bwx.m10181a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 21:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1136a(bxy.m10273a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean z;
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                mo1142a(z);
                parcel2.writeNoException();
                return true;
            case 23:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                c = mo1153k();
                parcel2.writeNoException();
                if (c) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 24:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1137a(byp.m10401a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                mo1141a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                bvc l = mo1154l();
                parcel2.writeNoException();
                if (l != null) {
                    asBinder = l.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case 29:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (parcel.readInt() != 0) {
                    videoOptionsParcel = (VideoOptionsParcel) VideoOptionsParcel.CREATOR.createFromParcel(parcel);
                }
                mo1132a(videoOptionsParcel);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
