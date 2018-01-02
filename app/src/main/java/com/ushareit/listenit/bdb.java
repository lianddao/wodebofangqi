package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.List;

public final class bdb extends bcu<SharePhoto, bdb> {
    private Bitmap f5915a;
    private Uri f5916b;
    private boolean f5917c;
    private String f5918d;

    public bdb m7803a(Bitmap bitmap) {
        this.f5915a = bitmap;
        return this;
    }

    public bdb m7804a(Uri uri) {
        this.f5916b = uri;
        return this;
    }

    public bdb m7808a(boolean z) {
        this.f5917c = z;
        return this;
    }

    public bdb m7807a(String str) {
        this.f5918d = str;
        return this;
    }

    public Uri m7801a() {
        return this.f5916b;
    }

    public Bitmap m7809b() {
        return this.f5915a;
    }

    public SharePhoto m7810c() {
        return new SharePhoto();
    }

    public bdb m7806a(SharePhoto sharePhoto) {
        return sharePhoto == null ? this : ((bdb) super.mo850a((ShareMedia) sharePhoto)).m7803a(sharePhoto.m1977b()).m7804a(sharePhoto.m1978c()).m7808a(sharePhoto.m1979d()).m7807a(sharePhoto.m1980e());
    }

    public bdb m7805a(Parcel parcel) {
        return m7806a((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
    }

    public static void m7796a(Parcel parcel, List<SharePhoto> list) {
        List arrayList = new ArrayList();
        for (SharePhoto add : list) {
            arrayList.add(add);
        }
        parcel.writeTypedList(arrayList);
    }

    public static List<SharePhoto> m7798b(Parcel parcel) {
        List<SharePhoto> arrayList = new ArrayList();
        parcel.readTypedList(arrayList, SharePhoto.CREATOR);
        return arrayList;
    }
}
