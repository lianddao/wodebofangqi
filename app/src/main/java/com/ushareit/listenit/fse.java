package com.ushareit.listenit;

import android.database.Cursor;
import org.json.JSONObject;

public class fse extends gla {
    public long f13343a;
    public String f13344b;
    public String f13345c;
    public String f13346d;
    public String f13347e;
    public long f13348f;
    public long f13349g;
    public long f13350h;
    public String f13351i;
    public long f13352j;
    public long f13353k;

    public fse(JSONObject jSONObject, boolean z) {
        this.f13344b = jSONObject.getString("name");
        this.f13345c = jSONObject.getString("artist");
        this.f13346d = jSONObject.getString("album");
        this.f13347e = jSONObject.getString("artwork");
        this.f13348f = jSONObject.getLong("duration");
        this.f13349g = jSONObject.getLong("size");
        this.f13350h = jSONObject.getLong("playcount");
        this.f13351i = jSONObject.getString("streamurl");
        this.f13353k = 0;
        if (!z) {
            if (frg.m20692a(this.f13351i)) {
                this.f13343a = frg.m20693b(this.f13351i);
                return;
            }
            this.f13343a = gvj.m22916c();
            frg.m20697c(new glg(this));
        }
    }

    public fse(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("title");
        int columnIndex3 = cursor.getColumnIndex("artist");
        int columnIndex4 = cursor.getColumnIndex("album");
        int columnIndex5 = cursor.getColumnIndex("artwork");
        int columnIndex6 = cursor.getColumnIndex("streamurl");
        int columnIndex7 = cursor.getColumnIndex("size");
        int columnIndex8 = cursor.getColumnIndex("duration");
        int columnIndex9 = cursor.getColumnIndex(fnl.PLAY_COUNT);
        int columnIndex10 = cursor.getColumnIndex("like_it");
        int columnIndex11 = cursor.getColumnIndex("last_play_timestamp");
        this.f13343a = cursor.getLong(columnIndex);
        this.f13344b = cursor.getString(columnIndex2);
        this.f13345c = cursor.getString(columnIndex3);
        this.f13346d = cursor.getString(columnIndex4);
        this.f13347e = cursor.getString(columnIndex5);
        this.f13351i = cursor.getString(columnIndex6);
        this.f13349g = (long) cursor.getInt(columnIndex7);
        this.f13348f = (long) cursor.getInt(columnIndex8);
        this.f13350h = cursor.getLong(columnIndex9);
        this.f13352j = cursor.getLong(columnIndex10);
        this.f13353k = cursor.getLong(columnIndex11);
    }

    public void mo2560a(Cursor cursor) {
    }

    public String mo2557a() {
        return String.valueOf(this.f13343a);
    }

    public int mo2561b() {
        return 0;
    }

    public void mo2559a(int i) {
    }

    public String mo2562c() {
        return this.f13344b;
    }
}
