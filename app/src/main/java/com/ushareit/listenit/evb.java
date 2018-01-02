package com.ushareit.listenit;

import org.json.JSONObject;

public class evb {
    public int f11924a;
    public int f11925b;
    public int f11926c;
    public String f11927d;
    public int f11928e;
    public int f11929f;

    public evb() {
        this.f11925b = 65535;
    }

    public evb(String str) {
        this(new JSONObject(str));
    }

    public evb(JSONObject jSONObject) {
        this.f11925b = 65535;
        if (jSONObject.has("cond_nw")) {
            this.f11924a = jSONObject.getInt("cond_nw");
        } else {
            this.f11924a = 0;
        }
        if (jSONObject.has("cond_portal")) {
            this.f11925b = jSONObject.getInt("cond_portal");
        } else {
            this.f11925b = 65535;
        }
        if (jSONObject.has("cond_preinstall")) {
            this.f11926c = jSONObject.getInt("cond_preinstall");
        }
        if (this.f11926c != 0) {
            this.f11927d = jSONObject.getString("pkg_name");
            if (jSONObject.has("min_ver")) {
                this.f11928e = jSONObject.getInt("min_ver");
            } else {
                this.f11928e = -1;
            }
            if (jSONObject.has("max_ver")) {
                this.f11929f = jSONObject.getInt("max_ver");
                return;
            } else {
                this.f11929f = -1;
                return;
            }
        }
        this.f11926c = 0;
        this.f11927d = "";
        this.f11928e = -1;
        this.f11929f = -1;
    }
}
