package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class aog {
    private final String f5030a;
    private final JSONObject f5031b;
    private final Map<aoq, List<String>> f5032c = new HashMap();

    public aog(String str, JSONObject jSONObject, JSONArray jSONArray) {
        this.f5030a = str;
        this.f5031b = jSONObject;
        if (jSONArray != null && jSONArray.length() != 0) {
            int i;
            for (Object put : aoq.values()) {
                this.f5032c.put(put, new LinkedList());
            }
            for (i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString(VastExtensionXmlManager.TYPE);
                    CharSequence string2 = jSONObject2.getString("url");
                    aoq valueOf = aoq.valueOf(string.toUpperCase(Locale.US));
                    if (!(valueOf == null || TextUtils.isEmpty(string2))) {
                        ((List) this.f5032c.get(valueOf)).add(string2);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public String m6451a() {
        return this.f5030a;
    }

    public List<String> m6452a(aoq com_ushareit_listenit_aoq) {
        return (List) this.f5032c.get(com_ushareit_listenit_aoq);
    }

    public JSONObject m6453b() {
        return this.f5031b;
    }
}
