package com.ushareit.listenit;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class cey<T extends SafeParcelable> extends ces<T> {
    private static final String[] f8209b = new String[]{"data"};
    private final Creator<T> f8210c;

    public cey(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.f8210c = creator;
    }

    public static <T extends SafeParcelable> void m11006a(cev com_ushareit_listenit_cev, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        com_ushareit_listenit_cev.mo1299a(contentValues);
        obtain.recycle();
    }

    public static cev m11007c() {
        return DataHolder.m2260a(f8209b);
    }

    public /* synthetic */ Object mo1301a(int i) {
        return m11009b(i);
    }

    public T m11009b(int i) {
        byte[] a = this.a.m2265a("data", i, this.a.m2263a(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(a, 0, a.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.f8210c.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
