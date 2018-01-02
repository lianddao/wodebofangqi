package com.ushareit.listenit;

import android.text.TextUtils;
import com.umeng.analytics.C0154a;
import org.json.JSONObject;

public abstract class fcc extends eyr {
    private static fbn f12074g = null;
    private fcg f12075a;
    private String f12076b;
    private String f12077c;
    protected fce f12078d;
    private String f12079e;
    private boolean f12080f;

    public fcc(fcg com_ushareit_listenit_fcg, JSONObject jSONObject) {
        this.f12075a = com_ushareit_listenit_fcg;
        mo2307a(jSONObject);
    }

    public fcc(fcg com_ushareit_listenit_fcg, fcf com_ushareit_listenit_fcf) {
        this.f12075a = com_ushareit_listenit_fcg;
        mo2306a(com_ushareit_listenit_fcf);
    }

    public final fcg m18337e() {
        return this.f12075a;
    }

    public final String m18338f() {
        return this.f12076b;
    }

    public final String m18339g() {
        return this.f12076b + "|" + this.f12077c;
    }

    public final String m18340h() {
        return this.f12079e;
    }

    public final void m18335a(String str) {
        this.f12079e = str;
    }

    protected void mo2306a(fcf com_ushareit_listenit_fcf) {
        this.f12076b = com_ushareit_listenit_fcf.m18848a("id", "");
        this.f12077c = com_ushareit_listenit_fcf.m18848a("ver", "");
        this.f12079e = com_ushareit_listenit_fcf.m18848a("name", "");
        this.f12080f = com_ushareit_listenit_fcf.m18851a("has_thumbnail", false);
    }

    protected void mo2307a(JSONObject jSONObject) {
        int i;
        if (TextUtils.isEmpty(this.f12076b) && jSONObject.has("id")) {
            this.f12076b = jSONObject.getString("id");
        }
        if (TextUtils.isEmpty(this.f12077c) && jSONObject.has("ver")) {
            this.f12077c = jSONObject.getString("ver");
        }
        if (TextUtils.isEmpty(this.f12076b) && this.f12075a == fcg.APP && jSONObject.has("packagename")) {
            this.f12076b = jSONObject.getString("packagename");
        }
        if (TextUtils.isEmpty(this.f12077c) && this.f12075a == fcg.APP && jSONObject.has(C0154a.f2942B)) {
            this.f12077c = String.valueOf(jSONObject.getInt(C0154a.f2942B));
        }
        if (TextUtils.isEmpty(this.f12076b) && this.f12075a == fcg.FILE && jSONObject.has("filepath")) {
            this.f12076b = jSONObject.getString("filepath");
        }
        if (TextUtils.isEmpty(this.f12076b) && this.f12075a == fcg.FILE && jSONObject.has("fileid")) {
            this.f12076b = jSONObject.getString("fileid");
        }
        if (TextUtils.isEmpty(this.f12077c) && this.f12075a == fcg.FILE && jSONObject.has("last_time")) {
            this.f12077c = String.valueOf(jSONObject.getLong("last_time"));
        }
        if (jSONObject.has("contactid")) {
            i = jSONObject.getInt("contactid");
        } else {
            i = -1;
        }
        if (jSONObject.has("musicid")) {
            i = jSONObject.getInt("musicid");
        }
        if (jSONObject.has("photoid")) {
            i = jSONObject.getInt("photoid");
        }
        if (TextUtils.isEmpty(this.f12076b) && i != -1) {
            this.f12076b = String.valueOf(i);
        }
        if (this.f12077c == null) {
            this.f12077c = "";
        }
        if (jSONObject.has("name")) {
            this.f12079e = jSONObject.getString("name");
        }
        if (TextUtils.isEmpty(this.f12079e) && this.f12075a == fcg.FILE) {
            this.f12079e = eye.m18482c(this.f12076b);
        }
        if (TextUtils.isEmpty(this.f12079e)) {
            String str = null;
            switch (fcd.f12419a[this.f12075a.ordinal()]) {
                case 1:
                case 4:
                    str = "appname";
                    break;
                case 2:
                case 3:
                case 6:
                    str = "showname";
                    break;
                case 5:
                    str = "contact_name";
                    break;
            }
            if (str != null && jSONObject.has(str)) {
                this.f12079e = jSONObject.getString(str);
            }
        }
        if (jSONObject.has("has_thumbnail")) {
            this.f12080f = jSONObject.getBoolean("has_thumbnail");
        }
        if (jSONObject.has("filename")) {
            this.f12080f = true;
        }
    }
}
