package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.Map;

public class aks extends ako {
    private static final String f4609a = aks.class.getSimpleName();
    private final Context f4610b;
    private final String f4611c;
    private final Uri f4612d;
    private final Map<String, String> f4613e;

    public aks(Context context, String str, Uri uri, Map<String, String> map) {
        this.f4610b = context;
        this.f4611c = str;
        this.f4612d = uri;
        this.f4613e = map;
    }

    public atr mo666a() {
        return null;
    }

    public void mo667b() {
        apb a = apb.m6565a(this.f4610b);
        apd com_ushareit_listenit_apd = apd.IMMEDIATE;
        Object queryParameter = this.f4612d.getQueryParameter("priority");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                com_ushareit_listenit_apd = apd.values()[Integer.valueOf(queryParameter).intValue()];
            } catch (Exception e) {
            }
        }
        a.m6576a(this.f4611c, this.f4613e, this.f4612d.getQueryParameter(VastExtensionXmlManager.TYPE), com_ushareit_listenit_apd);
    }
}
