package com.ushareit.listenit;

import android.os.Parcel;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphValueContainer;

public final class bcw extends bcz<ShareOpenGraphAction, bcw> {
    public bcw m7785a(String str) {
        m7781a("og:type", str);
        return this;
    }

    public ShareOpenGraphAction m7782a() {
        return new ShareOpenGraphAction();
    }

    public bcw m7784a(ShareOpenGraphAction shareOpenGraphAction) {
        return shareOpenGraphAction == null ? this : ((bcw) super.mo849a((ShareOpenGraphValueContainer) shareOpenGraphAction)).m7785a(shareOpenGraphAction.m1974a());
    }

    public bcw m7783a(Parcel parcel) {
        return m7784a((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
    }
}
