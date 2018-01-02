package com.ushareit.listenit;

import org.json.JSONObject;

public class evp {
    public String f11981a;
    public String f11982b;
    public String f11983c;
    public long f11984d;

    public evp(eva com_ushareit_listenit_eva, String str, String str2) {
        this.f11981a = com_ushareit_listenit_eva.m18099a();
        this.f11982b = str;
        this.f11984d = System.currentTimeMillis() - com_ushareit_listenit_eva.m18131p();
        m18196a(str2);
    }

    public evp(String str, String str2, String str3, long j) {
        this.f11981a = str;
        this.f11982b = str2;
        this.f11984d = j;
        m18196a(str3);
    }

    private void m18196a(String str) {
        String str2 = null;
        try {
            str2 = etc.m17843a(eyw.m18568a(eys.m18562a()));
        } catch (Exception e) {
        }
        if (fbb.m18763c(str2)) {
            this.f11983c = str;
        } else if (fbb.m18765d(str)) {
            this.f11983c = str + "|" + str2;
        } else {
            this.f11983c = str2;
        }
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd_id", this.f11981a);
            jSONObject.put("status", this.f11982b);
            jSONObject.put("detail", this.f11983c);
            jSONObject.put("duration", this.f11984d);
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
