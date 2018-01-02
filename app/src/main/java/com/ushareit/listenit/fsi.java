package com.ushareit.listenit;

import android.database.Cursor;
import org.json.JSONObject;

public class fsi extends gla {
    public String f13362a;
    public String f13363b;
    public String f13364c;
    public String f13365d;
    public String f13366e;
    public long f13367f;
    public long f13368g;
    public long f13369h;
    public String f13370i;

    public fsi(JSONObject jSONObject) {
        this.f13362a = jSONObject.getString("id");
        this.f13363b = jSONObject.getString("name");
        this.f13365d = jSONObject.getString("artist");
        this.f13366e = jSONObject.getString("album");
        this.f13364c = jSONObject.getString("artwork");
        this.f13367f = jSONObject.getLong("duration");
        this.f13368g = jSONObject.getLong("size");
        this.f13369h = jSONObject.getLong("playcount");
        this.f13370i = jSONObject.getString("streamurl");
    }

    public void mo2560a(Cursor cursor) {
    }

    public String mo2557a() {
        return this.f13362a;
    }

    public int mo2561b() {
        return 0;
    }

    public void mo2559a(int i) {
    }

    public String mo2562c() {
        return this.f13363b;
    }
}
