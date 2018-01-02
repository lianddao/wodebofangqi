package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class fsd extends fsc {
    public List<fse> f13341d;

    public fsd(JSONObject jSONObject, boolean z) {
        super(jSONObject, z);
        m20766b(0);
    }

    public void mo2556a(JSONObject jSONObject, boolean z) {
        JSONArray jSONArray = jSONObject.getJSONArray("content");
        int length = jSONArray.length();
        this.f13341d = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.f13341d.add(new fse(jSONArray.getJSONObject(i), z));
        }
    }
}
