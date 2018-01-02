package com.ushareit.listenit;

import org.json.JSONObject;

public class fcl extends fcb {
    protected long f12102b;
    protected int f12103e;
    protected String f12104f;
    protected int f12105g;
    protected String f12106h;
    protected String f12107i;

    public fcl(JSONObject jSONObject) {
        super(fcg.MUSIC, jSONObject);
    }

    public fcl(fcf com_ushareit_listenit_fcf) {
        super(fcg.MUSIC, com_ushareit_listenit_fcf);
    }

    protected void mo2306a(fcf com_ushareit_listenit_fcf) {
        super.mo2306a(com_ushareit_listenit_fcf);
        this.f12102b = com_ushareit_listenit_fcf.m18847a("duration", 0);
        this.f12103e = com_ushareit_listenit_fcf.m18846a("album_id", -1);
        this.f12104f = com_ushareit_listenit_fcf.m18848a("album_name", "");
        this.f12105g = com_ushareit_listenit_fcf.m18846a("artist_id", -1);
        this.f12106h = com_ushareit_listenit_fcf.m18848a("artist_name", "");
        this.f12107i = fbk.m18788a(m18340h());
    }

    public String m18359i() {
        return this.f12104f;
    }

    public String m18360j() {
        return this.f12106h;
    }

    protected void mo2307a(JSONObject jSONObject) {
        super.mo2307a(jSONObject);
        this.f12102b = jSONObject.has("duration") ? jSONObject.getLong("duration") : 0;
        this.f12105g = -1;
        this.f12106h = jSONObject.has("artist") ? jSONObject.getString("artist") : "";
        this.f12103e = -1;
        this.f12104f = jSONObject.has("album") ? jSONObject.getString("album") : "";
    }
}
