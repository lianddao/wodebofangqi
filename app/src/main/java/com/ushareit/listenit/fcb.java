package com.ushareit.listenit;

import android.text.TextUtils;
import org.json.JSONObject;

public abstract class fcb extends fcc {
    private long f12081a;
    private String f12082b;
    protected long f12083c;
    private boolean f12084e;
    private String f12085f;
    private String f12086g;

    public fcb(fcg com_ushareit_listenit_fcg, JSONObject jSONObject) {
        super(com_ushareit_listenit_fcg, jSONObject);
    }

    protected fcb(fcg com_ushareit_listenit_fcg, fcf com_ushareit_listenit_fcf) {
        super(com_ushareit_listenit_fcg, com_ushareit_listenit_fcf);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof fcb)) {
            return false;
        }
        fcb com_ushareit_listenit_fcb = (fcb) obj;
        if (com_ushareit_listenit_fcb.m18338f().equals(m18338f()) && com_ushareit_listenit_fcb.m18337e() == m18337e()) {
            return true;
        }
        return false;
    }

    protected void mo2306a(fcf com_ushareit_listenit_fcf) {
        super.mo2306a(com_ushareit_listenit_fcf);
        this.f12081a = com_ushareit_listenit_fcf.m18847a("file_size", -1);
        this.f12082b = com_ushareit_listenit_fcf.m18848a("file_path", "");
        this.f12083c = com_ushareit_listenit_fcf.m18847a("date_modified", 0);
        this.f12084e = com_ushareit_listenit_fcf.m18851a("is_exist", false);
        this.f12085f = com_ushareit_listenit_fcf.m18848a("thumbnail_path", "");
    }

    public final String m18343b() {
        return this.f12082b;
    }

    public final String m18344c() {
        if (TextUtils.isEmpty(this.f12086g)) {
            return eye.m18482c(this.f12082b);
        }
        return this.f12086g;
    }

    public long m18345d() {
        return this.f12081a;
    }

    protected void mo2307a(JSONObject jSONObject) {
        super.mo2307a(jSONObject);
        if (jSONObject.has("filesize")) {
            this.f12081a = jSONObject.getLong("filesize");
        }
        if (jSONObject.has("filepath")) {
            this.f12082b = jSONObject.getString("filepath");
        } else {
            this.f12082b = "";
        }
        if (TextUtils.isEmpty(this.f12082b) && jSONObject.has("fileid")) {
            this.f12082b = jSONObject.getString("fileid");
        }
        if (TextUtils.isEmpty(this.f12082b) && jSONObject.has("rawfilename")) {
            this.f12082b = jSONObject.getString("rawfilename");
        }
        if (jSONObject.has("rawfilename")) {
            this.f12086g = jSONObject.getString("rawfilename");
        } else {
            this.f12086g = "";
        }
        this.f12083c = jSONObject.has("datemodified") ? jSONObject.getLong("datemodified") : 0;
        if (jSONObject.has("thumbnailpath")) {
            this.f12085f = jSONObject.getString("thumbnailpath");
        } else {
            this.f12085f = "";
        }
    }

    public String toString() {
        return "ContentItem [Type = " + m18337e() + ", Name=" + m18340h() + ", " + (this.d == null ? "Keys empty" : this.d.toString()) + "]";
    }
}
