package com.ushareit.listenit;

import com.umeng.analytics.pro.C0321x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class atq {
    public static String f5446a = null;
    private String f5447b;
    private Map<String, Object> f5448c;
    private int f5449d;
    private String f5450e;

    public atq(String str, Map<String, Object> map, int i, String str2) {
        this.f5447b = str;
        this.f5448c = map;
        this.f5449d = i;
        this.f5450e = str2;
    }

    public static atq m7136a(long j, atr com_ushareit_listenit_atr, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put("Time", String.valueOf(currentTimeMillis - j));
        hashMap.put("AdAction", String.valueOf(com_ushareit_listenit_atr.f5457f));
        return new atq("bounceback", hashMap, (int) (currentTimeMillis / 1000), str);
    }

    public static atq m7137a(ats com_ushareit_listenit_ats, arz com_ushareit_listenit_arz, long j, String str) {
        Map hashMap = new HashMap();
        hashMap.put("LatencyType", String.valueOf(com_ushareit_listenit_ats.f5460b));
        hashMap.put("AdPlacementType", com_ushareit_listenit_arz.toString());
        hashMap.put("Time", String.valueOf(j));
        String str2 = C0321x.ao;
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str == null) {
            str = f5446a;
        }
        return new atq(str2, hashMap, currentTimeMillis, str);
    }

    public static atq m7138a(Throwable th, String str) {
        Map hashMap = new HashMap();
        if (th != null) {
            hashMap.put("ex", th.getClass().getSimpleName());
            hashMap.put("ex_msg", th.getMessage());
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str2 = C0321x.aF;
        if (str == null) {
            str = f5446a;
        }
        return new atq(str2, hashMap, currentTimeMillis, str);
    }

    public JSONObject m7139a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f5447b);
            jSONObject.put("data", new JSONObject(this.f5448c));
            jSONObject.put("time", this.f5449d);
            jSONObject.put("request_id", this.f5450e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
