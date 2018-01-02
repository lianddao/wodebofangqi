package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;

public final class ean {
    private final String f10774a;
    private final String f10775b;
    private final String f10776c;
    private final String f10777d;
    private final String f10778e;
    private final String f10779f;

    private ean(String str, String str2, String str3, String str4, String str5, String str6) {
        cfi.m11086a(!ciw.m11419a(str), (Object) "ApplicationId must be set.");
        this.f10775b = str;
        this.f10774a = str2;
        this.f10776c = str3;
        this.f10777d = str4;
        this.f10778e = str5;
        this.f10779f = str6;
    }

    public static ean m16631a(Context context) {
        cfo com_ushareit_listenit_cfo = new cfo(context);
        Object a = com_ushareit_listenit_cfo.m11111a("google_app_id");
        return TextUtils.isEmpty(a) ? null : new ean(a, com_ushareit_listenit_cfo.m11111a("google_api_key"), com_ushareit_listenit_cfo.m11111a("firebase_database_url"), com_ushareit_listenit_cfo.m11111a("ga_trackingId"), com_ushareit_listenit_cfo.m11111a("gcm_defaultSenderId"), com_ushareit_listenit_cfo.m11111a("google_storage_bucket"));
    }

    public String m16632a() {
        return this.f10774a;
    }

    public String m16633b() {
        return this.f10775b;
    }

    public String m16634c() {
        return this.f10776c;
    }

    public String m16635d() {
        return this.f10778e;
    }

    public String m16636e() {
        return this.f10779f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ean)) {
            return false;
        }
        ean com_ushareit_listenit_ean = (ean) obj;
        return cff.m11078a(this.f10775b, com_ushareit_listenit_ean.f10775b) && cff.m11078a(this.f10774a, com_ushareit_listenit_ean.f10774a) && cff.m11078a(this.f10776c, com_ushareit_listenit_ean.f10776c) && cff.m11078a(this.f10777d, com_ushareit_listenit_ean.f10777d) && cff.m11078a(this.f10778e, com_ushareit_listenit_ean.f10778e) && cff.m11078a(this.f10779f, com_ushareit_listenit_ean.f10779f);
    }

    public int hashCode() {
        return cff.m11076a(this.f10775b, this.f10774a, this.f10776c, this.f10777d, this.f10778e, this.f10779f);
    }

    public String toString() {
        return cff.m11077a((Object) this).m11079a("applicationId", this.f10775b).m11079a("apiKey", this.f10774a).m11079a("databaseUrl", this.f10776c).m11079a("gcmSenderId", this.f10778e).m11079a("storageBucket", this.f10779f).toString();
    }
}
