package com.ushareit.listenit;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.util.Log;
import android.view.Window;
import java.util.HashMap;
import java.util.Map;

public class atp {
    private static final String f5445a = atp.class.getSimpleName();

    private atp() {
    }

    public static Map<String, String> m7131a(Context context) {
        Map<String, String> hashMap = new HashMap();
        try {
            hashMap.put("kgr", String.valueOf(m7133b(context)));
            if (context == null || !(context instanceof Activity)) {
                Log.v(f5445a, "Invalid Activity context in window interactive check, assuming interactive.");
                return hashMap;
            }
            Window window = ((Activity) context).getWindow();
            if (window != null) {
                int i = window.getAttributes().flags;
                hashMap.put("wt", Integer.toString(window.getAttributes().type));
                hashMap.put("wfdkg", (4194304 & i) > 0 ? "1" : "0");
                hashMap.put("wfswl", (524288 & i) > 0 ? "1" : "0");
            } else {
                Log.v(f5445a, "Invalid window in window interactive check, assuming interactive.");
            }
            return hashMap;
        } catch (Exception e) {
            Log.e(f5445a, "Exception in window info check", e);
            auj.m7198a(e, context);
        }
    }

    public static boolean m7132a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            Log.v(f5445a, "Invalid Window info in window interactive check, assuming not obstructed by Keyguard.");
            return false;
        }
        String str = (String) map.get("wfdkg");
        String str2 = (String) map.get("wfswl");
        if (str != null && str.equals("1")) {
            return false;
        }
        if (str2 != null && str2.equals("1")) {
            return false;
        }
        str = (String) map.get("kgr");
        boolean z = str != null && str.equals("true");
        return z;
    }

    public static boolean m7133b(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean m7134b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            Log.v(f5445a, "Invalid Window info in window interactive check, assuming is not a Lockscreen.");
            return false;
        }
        String str = (String) map.get("wfdkg");
        String str2 = (String) map.get("wfswl");
        String str3 = (String) map.get("kgr");
        return str != null && str.equals("1") && str2 != null && str2.equals("1") && str3 != null && str3.equals("true");
    }

    public static boolean m7135c(Context context) {
        return !m7132a(m7131a(context));
    }
}
