package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dgv implements dgt {
    private IBinder f9790a;

    dgv(IBinder iBinder) {
        this.f9790a = iBinder;
    }

    public void mo1755a(dgq com_ushareit_listenit_dgq) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
            obtain.writeStrongBinder(com_ushareit_listenit_dgq != null ? com_ushareit_listenit_dgq.asBinder() : null);
            this.f9790a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9790a;
    }
}
