package com.ushareit.listenit;

import org.json.JSONObject;

public class fcn extends fcb {
    protected long f12116b;
    protected int f12117e;
    protected String f12118f;

    public fcn(JSONObject jSONObject) {
        super(fcg.VIDEO, jSONObject);
    }

    public fcn(fcf com_ushareit_listenit_fcf) {
        super(fcg.VIDEO, com_ushareit_listenit_fcf);
    }

    protected void mo2306a(fcf com_ushareit_listenit_fcf) {
        super.mo2306a(com_ushareit_listenit_fcf);
        this.f12116b = com_ushareit_listenit_fcf.m18847a("duration", 0);
        this.f12117e = com_ushareit_listenit_fcf.m18846a("album_id", -1);
        this.f12118f = com_ushareit_listenit_fcf.m18848a("album_name", "");
    }

    public String m18376i() {
        return this.f12118f;
    }

    protected void mo2307a(JSONObject jSONObject) {
        super.mo2307a(jSONObject);
        this.f12116b = jSONObject.has("duration") ? jSONObject.getLong("duration") : 0;
        this.f12117e = jSONObject.has("albumid") ? jSONObject.getInt("albumid") : -1;
        this.f12118f = jSONObject.has("albumname") ? jSONObject.getString("albumname") : "";
    }
}
