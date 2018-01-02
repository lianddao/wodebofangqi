package com.ushareit.listenit;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class fsg extends gla {
    public long f13355a;
    public String f13356b;
    public String f13357c;
    public String f13358d;
    public long f13359e;
    public List<fse> f13360f;

    public fsg(JSONObject jSONObject, boolean z) {
        this.f13355a = (long) jSONObject.getInt("id");
        this.f13356b = jSONObject.getString("name");
        this.f13357c = jSONObject.getString("artist");
        this.f13358d = jSONObject.getString("artwork");
        this.f13359e = jSONObject.getLong("playcount");
        JSONArray jSONArray = jSONObject.getJSONArray("content");
        int length = jSONArray.length();
        this.f13360f = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.f13360f.add(new fse(jSONArray.getJSONObject(i), z));
        }
    }

    public void mo2560a(Cursor cursor) {
    }

    public String mo2557a() {
        return String.valueOf(this.f13355a);
    }

    public int mo2561b() {
        return this.f13360f.size();
    }

    public void mo2559a(int i) {
    }

    public String mo2562c() {
        return this.f13356b;
    }
}
