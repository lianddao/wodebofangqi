package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class efk {
    efi f10974a;
    boolean f10975b;

    public efk() {
        this.f10974a = new efi();
    }

    efk(JSONObject jSONObject) {
        this.f10974a = new efi();
        if (jSONObject != null) {
            m16999a(jSONObject);
            this.f10975b = true;
        }
    }

    efk(JSONObject jSONObject, efl com_ushareit_listenit_efl) {
        this(jSONObject);
        this.f10974a.f10959c = com_ushareit_listenit_efl;
    }

    private void m16999a(JSONObject jSONObject) {
        this.f10974a.f10961e = jSONObject.optString("generation");
        this.f10974a.f10957a = jSONObject.optString("name");
        this.f10974a.f10960d = jSONObject.optString("bucket");
        this.f10974a.f10963g = jSONObject.optString("metageneration");
        this.f10974a.f10964h = jSONObject.optString("timeCreated");
        this.f10974a.f10965i = jSONObject.optString("updated");
        this.f10974a.f10966j = jSONObject.optLong("size");
        this.f10974a.f10967k = jSONObject.optString("md5Hash");
        this.f10974a.m16980a(jSONObject.optString("downloadTokens"));
        m17006e(jSONObject.optString("contentType"));
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                m17002a(str, jSONObject2.getString(str));
            }
        }
        m17005d(jSONObject.optString("cacheControl"));
        m17004c(jSONObject.optString("contentDisposition"));
        m17003b(jSONObject.optString("'contentEncoding"));
        m17001a(jSONObject.optString("'contentLanguage"));
    }

    public efi m17000a() {
        return new efi(this.f10975b);
    }

    public efk m17001a(String str) {
        this.f10974a.f10971o = str;
        return this;
    }

    public efk m17002a(String str, String str2) {
        if (this.f10974a.f10972p == null) {
            this.f10974a.f10972p = new HashMap();
        }
        this.f10974a.f10972p.put(str, str2);
        return this;
    }

    public efk m17003b(String str) {
        this.f10974a.f10970n = str;
        return this;
    }

    public efk m17004c(String str) {
        this.f10974a.f10969m = str;
        return this;
    }

    public efk m17005d(String str) {
        this.f10974a.f10968l = str;
        return this;
    }

    public efk m17006e(String str) {
        this.f10974a.f10962f = str;
        return this;
    }
}
