package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

class clx implements clv {
    private IBinder f8437a;

    clx(IBinder iBinder) {
        this.f8437a = iBinder;
    }

    public void mo1409a(VerifyAssertionRequest verifyAssertionRequest, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            if (verifyAssertionRequest != null) {
                obtain.writeInt(1);
                verifyAssertionRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1410a(cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1411a(String str, UserProfileChangeRequest userProfileChangeRequest, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            if (userProfileChangeRequest != null) {
                obtain.writeInt(1);
                userProfileChangeRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1412a(String str, VerifyAssertionRequest verifyAssertionRequest, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            if (verifyAssertionRequest != null) {
                obtain.writeInt(1);
                verifyAssertionRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1413a(String str, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1414a(String str, String str2, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1415a(String str, String str2, String str3, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f8437a;
    }

    public void mo1416b(String str, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1417b(String str, String str2, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1418c(String str, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1419c(String str, String str2, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1420d(String str, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1421d(String str, String str2, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1422e(String str, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1423e(String str, String str2, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1424f(String str, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(15, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1425g(String str, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(17, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1426h(String str, cls com_ushareit_listenit_cls) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.auth.api.internal.IFirebaseAuthService");
            obtain.writeString(str);
            obtain.writeStrongBinder(com_ushareit_listenit_cls != null ? com_ushareit_listenit_cls.asBinder() : null);
            this.f8437a.transact(18, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
