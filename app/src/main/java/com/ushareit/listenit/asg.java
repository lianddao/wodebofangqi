package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.umeng.analytics.pro.C0321x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asg {
    private static asg f5314a = new asg();

    public static synchronized asg m6966a() {
        asg com_ushareit_listenit_asg;
        synchronized (asg.class) {
            com_ushareit_listenit_asg = f5314a;
        }
        return com_ushareit_listenit_asg;
    }

    private asj m6967a(JSONObject jSONObject) {
        int i = 0;
        JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
        aok com_ushareit_listenit_aok = new aok(aol.m6462a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config"));
        if (jSONObject2.has("ads")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("ads");
            while (i < jSONArray.length()) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                com_ushareit_listenit_aok.m6459a(new aog(jSONObject3.optString("adapter"), jSONObject3.optJSONObject("data"), jSONObject3.optJSONArray("trackers")));
                i++;
            }
        }
        return new asj(com_ushareit_listenit_aok);
    }

    private ask m6968b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
            return new ask(jSONObject.optString("message", ""), jSONObject.optInt("code", 0), new aok(aol.m6462a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config")));
        } catch (JSONException e) {
            return m6969c(jSONObject);
        }
    }

    private ask m6969c(JSONObject jSONObject) {
        return new ask(jSONObject.optString("message", ""), jSONObject.optInt("code", 0), null);
    }

    public ash m6970a(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(VastExtensionXmlManager.TYPE);
            Object obj = -1;
            switch (optString.hashCode()) {
                case 96432:
                    if (optString.equals("ads")) {
                        obj = null;
                        break;
                    }
                    break;
                case 96784904:
                    if (optString.equals(C0321x.aF)) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    return m6967a(jSONObject);
                case 1:
                    return m6968b(jSONObject);
                default:
                    JSONObject optJSONObject = jSONObject.optJSONObject(C0321x.aF);
                    if (optJSONObject != null) {
                        return m6969c(optJSONObject);
                    }
                    break;
            }
        }
        return new ash(asi.UNKNOWN, null);
    }
}
