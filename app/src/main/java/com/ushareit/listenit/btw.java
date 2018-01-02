package com.ushareit.listenit;

import android.content.Context;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;

public class btw {
    private final Context f7748a;
    private final bxf f7749b;

    btw(Context context, bxf com_ushareit_listenit_bxf) {
        this.f7748a = context;
        this.f7749b = com_ushareit_listenit_bxf;
    }

    public btw(Context context, String str) {
        this((Context) cfi.m11081a((Object) context, (Object) "context cannot be null"), bwt.m10270b().m10223a(context, str, new dih()));
    }

    public btv m9841a() {
        try {
            return new btv(this.f7748a, this.f7749b.mo1120a());
        } catch (Throwable e) {
            bze.m10489b("Failed to build AdLoader.", e);
            return null;
        }
    }

    public btw m9842a(btu com_ushareit_listenit_btu) {
        try {
            this.f7749b.mo1122a(new bwc(com_ushareit_listenit_btu));
        } catch (Throwable e) {
            bze.m10491c("Failed to set AdListener.", e);
        }
        return this;
    }

    public btw m9843a(buq com_ushareit_listenit_buq) {
        try {
            this.f7749b.mo1121a(new NativeAdOptionsParcel(com_ushareit_listenit_buq));
        } catch (Throwable e) {
            bze.m10491c("Failed to specify native ad options", e);
        }
        return this;
    }

    public btw m9844a(buu com_ushareit_listenit_buu) {
        try {
            this.f7749b.mo1124a(new dif(com_ushareit_listenit_buu));
        } catch (Throwable e) {
            bze.m10491c("Failed to add app install ad listener", e);
        }
        return this;
    }

    public btw m9845a(buw com_ushareit_listenit_buw) {
        try {
            this.f7749b.mo1125a(new dig(com_ushareit_listenit_buw));
        } catch (Throwable e) {
            bze.m10491c("Failed to add content ad listener", e);
        }
        return this;
    }
}
