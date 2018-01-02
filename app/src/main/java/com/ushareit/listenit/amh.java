package com.ushareit.listenit;

import android.content.Intent;
import android.os.Bundle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amh implements aty {
    private final String f4839a;
    private final String f4840b;
    private final atw f4841c;
    private final Collection<String> f4842d;
    private final Map<String, String> f4843e;
    private final String f4844f;
    private final int f4845g;
    private final int f4846h;
    private final int f4847i;
    private final String f4848j;

    private amh(String str, String str2, atw com_ushareit_listenit_atw, Collection<String> collection, Map<String, String> map, String str3, int i, int i2, int i3, String str4) {
        this.f4839a = str;
        this.f4840b = str2;
        this.f4841c = com_ushareit_listenit_atw;
        this.f4842d = collection;
        this.f4843e = map;
        this.f4844f = str3;
        this.f4845g = i;
        this.f4846h = i2;
        this.f4847i = i3;
        this.f4848j = str4;
    }

    public static amh m6274a(Bundle bundle) {
        return new amh(atz.m7164a(bundle.getByteArray("markup")), null, atw.NONE, null, null, bundle.getString("request_id"), bundle.getInt("viewability_check_initial_delay"), bundle.getInt("viewability_check_interval"), bundle.getInt("skip_after_seconds", 0), bundle.getString("ct"));
    }

    public static amh m6275a(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray;
        String optString = jSONObject.optString("markup");
        String optString2 = jSONObject.optString("activation_command");
        String optString3 = jSONObject.optString("request_id");
        String a = atz.m7162a(jSONObject, "ct");
        atw a2 = atw.m7149a(jSONObject.optString("invalidation_behavior"));
        try {
            jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        Collection a3 = atx.m7150a(jSONArray);
        JSONObject optJSONObject = jSONObject.optJSONObject("metadata");
        Map hashMap = new HashMap();
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, optJSONObject.optString(str));
            }
        }
        int i2 = 1000;
        int parseInt = hashMap.containsKey("viewability_check_initial_delay") ? Integer.parseInt((String) hashMap.get("viewability_check_initial_delay")) : 0;
        if (hashMap.containsKey("viewability_check_interval")) {
            i2 = Integer.parseInt((String) hashMap.get("viewability_check_interval"));
        }
        if (hashMap.containsKey("skip_after_seconds")) {
            i = Integer.parseInt((String) hashMap.get("skip_after_seconds"));
        }
        return new amh(optString, optString2, a2, a3, hashMap, optString3, parseInt, i2, i, a);
    }

    public static amh m6276b(Intent intent) {
        return new amh(atz.m7164a(intent.getByteArrayExtra("markup")), intent.getStringExtra("activation_command"), atw.NONE, null, null, intent.getStringExtra("request_id"), intent.getIntExtra("viewability_check_initial_delay", 0), intent.getIntExtra("viewability_check_interval", 1000), intent.getIntExtra("skipAfterSeconds", 0), intent.getStringExtra("ct"));
    }

    public Collection<String> mo728A() {
        return this.f4842d;
    }

    public String m6278a() {
        return this.f4839a;
    }

    public void m6279a(Intent intent) {
        intent.putExtra("markup", atz.m7173a(this.f4839a));
        intent.putExtra("activation_command", this.f4840b);
        intent.putExtra("request_id", this.f4844f);
        intent.putExtra("viewability_check_initial_delay", this.f4845g);
        intent.putExtra("viewability_check_interval", this.f4846h);
        intent.putExtra("skipAfterSeconds", this.f4847i);
        intent.putExtra("ct", this.f4848j);
    }

    public Map<String, String> m6280b() {
        return this.f4843e;
    }

    public String m6281c() {
        return this.f4844f;
    }

    public int m6282d() {
        return this.f4845g;
    }

    public int m6283e() {
        return this.f4846h;
    }

    public Bundle m6284f() {
        Bundle bundle = new Bundle();
        bundle.putByteArray("markup", atz.m7173a(this.f4839a));
        bundle.putString("request_id", this.f4844f);
        bundle.putInt("viewability_check_initial_delay", this.f4845g);
        bundle.putInt("viewability_check_interval", this.f4846h);
        bundle.putInt("skip_after_seconds", this.f4847i);
        bundle.putString("ct", this.f4848j);
        return bundle;
    }

    public String mo698y() {
        return this.f4848j;
    }

    public atw mo729z() {
        return this.f4841c;
    }
}
