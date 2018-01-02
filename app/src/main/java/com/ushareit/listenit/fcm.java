package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.mobileads.VastIconXmlManager;
import org.json.JSONObject;

public class fcm extends fcb {
    protected int f12109b;
    protected String f12110e;
    protected int f12111f;
    protected long f12112g;
    protected int f12113h;
    protected int f12114i;

    public fcm(JSONObject jSONObject) {
        super(fcg.PHOTO, jSONObject);
    }

    public fcm(fcf com_ushareit_listenit_fcf) {
        super(fcg.PHOTO, com_ushareit_listenit_fcf);
    }

    protected void mo2306a(fcf com_ushareit_listenit_fcf) {
        super.mo2306a(com_ushareit_listenit_fcf);
        this.f12109b = com_ushareit_listenit_fcf.m18846a("album_id", -1);
        this.f12110e = com_ushareit_listenit_fcf.m18848a("album_name", "");
        this.f12111f = com_ushareit_listenit_fcf.m18846a("orientation", 0);
        this.f12112g = com_ushareit_listenit_fcf.m18847a("date_taken", 0);
        this.f12113h = com_ushareit_listenit_fcf.m18846a(VastIconXmlManager.WIDTH, 0);
        this.f12114i = com_ushareit_listenit_fcf.m18846a(VastIconXmlManager.HEIGHT, 0);
    }

    public String m18368i() {
        return this.f12110e;
    }

    protected void mo2307a(JSONObject jSONObject) {
        int i;
        int i2 = 0;
        super.mo2307a(jSONObject);
        if (TextUtils.isEmpty(super.m18340h())) {
            String b = super.m18343b();
            if (TextUtils.isEmpty(b) && jSONObject.has("filename")) {
                b = jSONObject.getString("filename");
            }
            super.m18335a(eye.m18480b(b));
        }
        this.f12109b = jSONObject.has("albumid") ? jSONObject.getInt("albumid") : -1;
        this.f12110e = jSONObject.has("albumname") ? jSONObject.getString("albumname") : "";
        if (jSONObject.has("orientation")) {
            i = jSONObject.getInt("orientation");
        } else {
            i = 0;
        }
        this.f12111f = i;
        if (jSONObject.has(VastIconXmlManager.WIDTH)) {
            i = jSONObject.getInt(VastIconXmlManager.WIDTH);
        } else {
            i = 0;
        }
        this.f12113h = i;
        if (jSONObject.has(VastIconXmlManager.HEIGHT)) {
            i2 = jSONObject.getInt(VastIconXmlManager.HEIGHT);
        }
        this.f12114i = i2;
    }
}
