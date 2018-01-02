package com.ushareit.listenit;

import com.mopub.mobileads.VastExtensionXmlManager;
import org.json.JSONObject;

public final class exb {
    public static fcb m18333a(JSONObject jSONObject) {
        fcg a = fcg.m18853a(jSONObject.getString(VastExtensionXmlManager.TYPE));
        switch (exc.f12073a[a.ordinal()]) {
            case 1:
            case 2:
                return new exd(a, jSONObject);
            case 3:
                return new exh(jSONObject);
            case 4:
                return new exi(jSONObject);
            case 5:
                return new exg(jSONObject);
            default:
                exu.m18432a("createCloudItem(): Unsupport type:" + a.toString());
                return null;
        }
    }
}
