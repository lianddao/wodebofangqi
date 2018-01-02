package com.ushareit.listenit;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class efi {
    private String f10957a;
    private efe f10958b;
    private efl f10959c;
    private String f10960d;
    private String f10961e;
    private String f10962f;
    private String f10963g;
    private String f10964h;
    private String f10965i;
    private long f10966j;
    private String f10967k;
    private String f10968l;
    private String f10969m;
    private String f10970n;
    private String f10971o;
    private Map<String, String> f10972p;
    private String[] f10973q;

    public efi() {
        this.f10957a = null;
        this.f10958b = null;
        this.f10959c = null;
        this.f10960d = null;
        this.f10961e = null;
        this.f10962f = null;
        this.f10963g = null;
        this.f10964h = null;
        this.f10965i = null;
        this.f10967k = null;
        this.f10968l = null;
        this.f10969m = null;
        this.f10970n = null;
        this.f10971o = null;
        this.f10972p = null;
        this.f10973q = null;
    }

    private efi(efi com_ushareit_listenit_efi, boolean z) {
        this.f10957a = null;
        this.f10958b = null;
        this.f10959c = null;
        this.f10960d = null;
        this.f10961e = null;
        this.f10962f = null;
        this.f10963g = null;
        this.f10964h = null;
        this.f10965i = null;
        this.f10967k = null;
        this.f10968l = null;
        this.f10969m = null;
        this.f10970n = null;
        this.f10971o = null;
        this.f10972p = null;
        this.f10973q = null;
        cfi.m11080a((Object) com_ushareit_listenit_efi);
        this.f10957a = com_ushareit_listenit_efi.f10957a;
        this.f10958b = com_ushareit_listenit_efi.f10958b;
        this.f10959c = com_ushareit_listenit_efi.f10959c;
        this.f10960d = com_ushareit_listenit_efi.f10960d;
        this.f10962f = com_ushareit_listenit_efi.f10962f;
        this.f10968l = com_ushareit_listenit_efi.f10968l;
        this.f10969m = com_ushareit_listenit_efi.f10969m;
        this.f10970n = com_ushareit_listenit_efi.f10970n;
        this.f10971o = com_ushareit_listenit_efi.f10971o;
        if (com_ushareit_listenit_efi.f10972p != null) {
            this.f10972p = new HashMap(com_ushareit_listenit_efi.f10972p);
        }
        this.f10973q = com_ushareit_listenit_efi.f10973q;
        if (z) {
            this.f10967k = com_ushareit_listenit_efi.f10967k;
            this.f10966j = com_ushareit_listenit_efi.f10966j;
            this.f10965i = com_ushareit_listenit_efi.f10965i;
            this.f10964h = com_ushareit_listenit_efi.f10964h;
            this.f10963g = com_ushareit_listenit_efi.f10963g;
            this.f10961e = com_ushareit_listenit_efi.f10961e;
        }
    }

    private void m16980a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f10973q = str.split(",");
        }
    }

    public String m16993a() {
        return this.f10962f;
    }

    public String m16994b() {
        return this.f10968l;
    }

    public String m16995c() {
        return this.f10969m;
    }

    public String m16996d() {
        return this.f10970n;
    }

    public String m16997e() {
        return this.f10971o;
    }

    JSONObject m16998f() {
        JSONObject jSONObject = new JSONObject();
        if (m16993a() != null) {
            jSONObject.put("contentType", m16993a());
        }
        if (this.f10972p != null) {
            jSONObject.put("metadata", new JSONObject(this.f10972p));
        }
        if (m16994b() != null) {
            jSONObject.put("cacheControl", m16994b());
        }
        if (m16995c() != null) {
            jSONObject.put("contentDisposition", m16995c());
        }
        if (m16996d() != null) {
            jSONObject.put("'contentEncoding", m16996d());
        }
        if (m16997e() != null) {
            jSONObject.put("'contentLanguage", m16997e());
        }
        return jSONObject;
    }
}
