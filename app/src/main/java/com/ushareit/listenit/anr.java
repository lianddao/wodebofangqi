package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.Cursor;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class anr extends any {
    public static final anq f4979a = new anq(0, "event_id", "TEXT PRIMARY KEY");
    public static final anq f4980b = new anq(1, "token_id", "TEXT REFERENCES tokens ON UPDATE CASCADE ON DELETE RESTRICT");
    public static final anq f4981c = new anq(2, "priority", "INTEGER");
    public static final anq f4982d = new anq(3, VastExtensionXmlManager.TYPE, "TEXT");
    public static final anq f4983e = new anq(4, "time", "REAL");
    public static final anq f4984f = new anq(5, "session_time", "REAL");
    public static final anq f4985g = new anq(6, "session_id", "TEXT");
    public static final anq f4986h = new anq(7, "data", "TEXT");
    public static final anq[] f4987i = new anq[]{f4979a, f4980b, f4981c, f4982d, f4983e, f4984f, f4985g, f4986h};
    private static final String f4988k = any.m6399a("events", f4987i);

    public anr(ans com_ushareit_listenit_ans) {
        super(com_ushareit_listenit_ans);
    }

    public String mo733a() {
        return "events";
    }

    String m6409a(String str, int i, String str2, double d, double d2, String str3, Map<String, String> map) {
        String uuid = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues(7);
        contentValues.put(f4979a.f4976b, uuid);
        contentValues.put(f4980b.f4976b, str);
        contentValues.put(f4981c.f4976b, Integer.valueOf(i));
        contentValues.put(f4982d.f4976b, str2);
        contentValues.put(f4983e.f4976b, Double.valueOf(d));
        contentValues.put(f4984f.f4976b, Double.valueOf(d2));
        contentValues.put(f4985g.f4976b, str3);
        contentValues.put(f4986h.f4976b, map != null ? new JSONObject(map).toString() : null);
        m6407f().insertOrThrow("events", null, contentValues);
        return uuid;
    }

    boolean m6410a(String str) {
        return m6407f().delete("events", new StringBuilder().append(f4979a.f4976b).append(" = ?").toString(), new String[]{str}) > 0;
    }

    public anq[] mo734b() {
        return f4987i;
    }

    Cursor mo735c() {
        return m6407f().rawQuery("SELECT count(*) FROM events", null);
    }

    Cursor m6413d() {
        return m6407f().rawQuery(f4988k, null);
    }
}
