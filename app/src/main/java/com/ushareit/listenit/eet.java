package com.ushareit.listenit;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class eet {
    private static final long f10905d = TimeUnit.DAYS.toMillis(7);
    public final String f10906a;
    final String f10907b;
    final long f10908c;

    private eet(String str, String str2, long j) {
        this.f10906a = str;
        this.f10907b = str2;
        this.f10908c = j;
    }

    static eet m16891a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new eet(str, null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new eet(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to parse token: ").append(valueOf).toString());
            return null;
        }
    }

    static String m16892a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to encode token: ").append(valueOf).toString());
            return null;
        }
    }

    public boolean m16893b(String str) {
        return System.currentTimeMillis() > this.f10908c + f10905d || !str.equals(this.f10907b);
    }
}
