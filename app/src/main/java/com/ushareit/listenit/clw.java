package com.ushareit.listenit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public abstract class clw extends Binder implements clv {
    public static clv m11647a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof clv)) ? new clx(iBinder) : (clv) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        VerifyAssertionRequest verifyAssertionRequest = null;
        String readString;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1413a(parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1416b(parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                if (parcel.readInt() != 0) {
                    verifyAssertionRequest = (VerifyAssertionRequest) VerifyAssertionRequest.CREATOR.createFromParcel(parcel);
                }
                mo1409a(verifyAssertionRequest, clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                UserProfileChangeRequest userProfileChangeRequest;
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    userProfileChangeRequest = (UserProfileChangeRequest) UserProfileChangeRequest.CREATOR.createFromParcel(parcel);
                }
                mo1411a(readString, userProfileChangeRequest, clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1414a(parcel.readString(), parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1417b(parcel.readString(), parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1419c(parcel.readString(), parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1421d(parcel.readString(), parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1418c(parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1420d(parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1415a(parcel.readString(), parcel.readString(), parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    verifyAssertionRequest = (VerifyAssertionRequest) VerifyAssertionRequest.CREATOR.createFromParcel(parcel);
                }
                mo1412a(readString, verifyAssertionRequest, clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1422e(parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1423e(parcel.readString(), parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1424f(parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 16:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1410a(clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1425g(parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case C0349R.styleable.DragSortListView_use_default_controller /*18*/:
                parcel.enforceInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                mo1426h(parcel.readString(), clt.m11621a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.firebase.auth.api.internal.IFirebaseAuthService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
