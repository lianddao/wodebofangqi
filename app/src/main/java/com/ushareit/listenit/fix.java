package com.ushareit.listenit;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class fix extends etd {
    public fix(boolean z, boolean z2) {
        super(z, z2);
    }

    public void mo2384a(Context context) {
    }

    public void mo2294d(Context context) {
        MobclickAgent.onResume(context);
    }

    public void mo2295e(Context context) {
        MobclickAgent.onPause(context);
    }

    public void mo2287a(Context context, String str) {
        MobclickAgent.onEvent(context, str);
    }

    public void mo2288a(Context context, String str, String str2) {
        MobclickAgent.onEvent(context, str, str2);
    }

    public void mo2289a(Context context, String str, HashMap<String, String> hashMap) {
        Map linkedHashMap = new LinkedHashMap();
        for (Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (str3 != null) {
                linkedHashMap.put(str2, str3);
            }
        }
        MobclickAgent.onEvent(context, str, linkedHashMap);
    }

    public void mo2292c() {
    }

    public void mo2290a(Context context, Throwable th) {
        MobclickAgent.reportError(context, th);
    }
}
