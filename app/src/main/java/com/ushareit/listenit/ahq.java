package com.ushareit.listenit;

import android.util.Log;
import com.facebook.internal.cb;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

class ahq implements aix {
    final /* synthetic */ AtomicBoolean f4373a;
    final /* synthetic */ Set f4374b;
    final /* synthetic */ Set f4375c;
    final /* synthetic */ aho f4376d;

    ahq(aho com_ushareit_listenit_aho, AtomicBoolean atomicBoolean, Set set, Set set2) {
        this.f4376d = com_ushareit_listenit_aho;
        this.f4373a = atomicBoolean;
        this.f4374b = set;
        this.f4375c = set2;
    }

    public void mo166a(ajh com_ushareit_listenit_ajh) {
        JSONObject b = com_ushareit_listenit_ajh.m5777b();
        if (b != null) {
            JSONArray optJSONArray = b.optJSONArray("data");
            if (optJSONArray != null) {
                this.f4373a.set(true);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("permission");
                        String optString2 = optJSONObject.optString("status");
                        if (!(cb.m1591a(optString) || cb.m1591a(optString2))) {
                            optString2 = optString2.toLowerCase(Locale.US);
                            if (optString2.equals("granted")) {
                                this.f4374b.add(optString);
                            } else if (optString2.equals("declined")) {
                                this.f4375c.add(optString);
                            } else {
                                Log.w("AccessTokenManager", "Unexpected status: " + optString2);
                            }
                        }
                    }
                }
            }
        }
    }
}
