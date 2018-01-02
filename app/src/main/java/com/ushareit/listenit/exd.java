package com.ushareit.listenit;

import org.json.JSONObject;

public class exd extends fcj implements exf {
    protected exe f12094a;
    public int f12095b;

    public exd(JSONObject jSONObject) {
        super(jSONObject);
    }

    public exd(fcg com_ushareit_listenit_fcg, JSONObject jSONObject) {
        super(com_ushareit_listenit_fcg, jSONObject);
    }

    public exe mo2308a() {
        return this.f12094a;
    }

    protected void mo2306a(fcf com_ushareit_listenit_fcf) {
        super.mo2306a(com_ushareit_listenit_fcf);
        m18352b(com_ushareit_listenit_fcf);
        this.f12095b = com_ushareit_listenit_fcf.m18846a("detail_src", 1);
    }

    protected void mo2307a(JSONObject jSONObject) {
        super.mo2307a(jSONObject);
        m18353b(jSONObject);
        if (jSONObject.has("detail_src")) {
            this.f12095b = jSONObject.getInt("detail_src");
        } else {
            this.f12095b = 1;
        }
    }

    protected void m18352b(fcf com_ushareit_listenit_fcf) {
        this.f12094a = new exe(com_ushareit_listenit_fcf);
    }

    protected void m18353b(JSONObject jSONObject) {
        this.f12094a = new exe(jSONObject);
    }
}
