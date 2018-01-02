package com.ushareit.listenit;

import com.facebook.GraphRequest;
import com.facebook.internal.bk;
import com.facebook.internal.cb;
import com.mopub.mobileads.VastExtensionXmlManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class ait implements aix {
    final /* synthetic */ aix f4450a;
    final /* synthetic */ GraphRequest f4451b;

    public ait(GraphRequest graphRequest, aix com_ushareit_listenit_aix) {
        this.f4451b = graphRequest;
        this.f4450a = com_ushareit_listenit_aix;
    }

    public void mo166a(ajh com_ushareit_listenit_ajh) {
        JSONArray optJSONArray;
        JSONObject b = com_ushareit_listenit_ajh.m5777b();
        b = b != null ? b.optJSONObject("__debug__") : null;
        if (b != null) {
            optJSONArray = b.optJSONArray("messages");
        } else {
            optJSONArray = null;
        }
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString;
                String optString2;
                String optString3;
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    optString = optJSONObject.optString("message");
                } else {
                    optString = null;
                }
                if (optJSONObject != null) {
                    optString2 = optJSONObject.optString(VastExtensionXmlManager.TYPE);
                } else {
                    optString2 = null;
                }
                if (optJSONObject != null) {
                    optString3 = optJSONObject.optString("link");
                } else {
                    optString3 = null;
                }
                if (!(optString == null || optString2 == null)) {
                    ajk com_ushareit_listenit_ajk = ajk.GRAPH_API_DEBUG_INFO;
                    if (optString2.equals("warning")) {
                        com_ushareit_listenit_ajk = ajk.GRAPH_API_DEBUG_WARNING;
                    }
                    if (!cb.m1591a(optString3)) {
                        optString = optString + " Link: " + optString3;
                    }
                    bk.m1464a(com_ushareit_listenit_ajk, GraphRequest.f456a, optString);
                }
            }
        }
        if (this.f4450a != null) {
            this.f4450a.mo166a(com_ushareit_listenit_ajh);
        }
    }
}
