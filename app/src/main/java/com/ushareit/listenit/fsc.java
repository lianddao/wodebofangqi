package com.ushareit.listenit;

import com.umeng.analytics.pro.C0321x;
import org.json.JSONObject;

public abstract class fsc extends gjc {
    public int f13338a;
    public String f13339b;
    public int f13340c;

    public abstract void mo2556a(JSONObject jSONObject, boolean z);

    public fsc(JSONObject jSONObject, boolean z) {
        this.f13338a = jSONObject.getInt("id");
        this.f13339b = jSONObject.getString("name");
        this.f13340c = jSONObject.getInt(C0321x.f3829P);
        mo2556a(jSONObject, z);
    }

    public String toString() {
        return "id=" + this.f13338a + ", name=" + this.f13339b + ", style=" + this.f13340c;
    }
}
