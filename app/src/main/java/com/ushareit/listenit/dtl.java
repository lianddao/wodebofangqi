package com.ushareit.listenit;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.location.ActivityRecognitionRequest;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.location.internal.ParcelableGeofence;
import com.mopub.mobileads.resource.DrawableConstants.GradientStrip;
import com.umeng.analytics.C0154a;

public abstract class dtl extends Binder implements dtk {
    public static dtk m15520a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof dtk)) ? new dtm(iBinder) : (dtk) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = false;
        Location a;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2060a(parcel.createTypedArrayList(ParcelableGeofence.CREATOR), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dti.m15482a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2042a(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dti.m15482a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2062a(parcel.createStringArray(), dti.m15482a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2058a(dti.m15482a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2039a(parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2040a(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                a = mo2037a();
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2050a(parcel.readInt() != 0 ? (LocationRequest) LocationRequest.CREATOR.createFromParcel(parcel) : null, dul.m15573a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2049a(parcel.readInt() != 0 ? (LocationRequest) LocationRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2059a(dul.m15573a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2064b(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                mo2061a(z);
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2043a(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2051a(parcel.readInt() != 0 ? (LocationRequest) LocationRequest.CREATOR.createFromParcel(parcel) : null, dul.m15573a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                a = mo2063b(parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 26:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2044a(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 34:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                LocationAvailability c = mo2066c(parcel.readString());
                parcel2.writeNoException();
                if (c != null) {
                    parcel2.writeInt(1);
                    c.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 52:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2054a(parcel.readInt() != 0 ? (LocationRequestInternal) LocationRequestInternal.CREATOR.createFromParcel(parcel) : null, dul.m15573a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 53:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2053a(parcel.readInt() != 0 ? (LocationRequestInternal) LocationRequestInternal.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 57:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2047a(parcel.readInt() != 0 ? (GeofencingRequest) GeofencingRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dti.m15482a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 59:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2055a(parcel.readInt() != 0 ? (LocationRequestUpdateData) LocationRequestUpdateData.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case C0154a.f2959o /*60*/:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2048a(parcel.readInt() != 0 ? (GestureRequest) GestureRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dny.m15146a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 61:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2068d(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dny.m15146a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 63:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2052a(parcel.readInt() != 0 ? (LocationSettingsRequest) LocationSettingsRequest.CREATOR.createFromParcel(parcel) : null, dto.m15556a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 64:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                ActivityRecognitionResult a2 = mo2038a(parcel.readString());
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 65:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2065b(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dny.m15146a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 66:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2067c(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dny.m15146a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 67:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2057a(dtf.m15473a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 68:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2069e(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dny.m15146a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 69:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2070f(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dny.m15146a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 70:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2045a(parcel.readInt() != 0 ? (ActivityRecognitionRequest) ActivityRecognitionRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dny.m15146a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 71:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2056a(dny.m15146a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case GradientStrip.GRADIENT_STRIP_HEIGHT_DIPS /*72*/:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2046a(parcel.readInt() != 0 ? (ActivityTransitionRequest) ActivityTransitionRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dny.m15146a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 73:
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                mo2041a(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, dny.m15146a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
