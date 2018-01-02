package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public class atx {
    public static Collection<String> m7150a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        Set hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.optString(i));
        }
        return hashSet;
    }

    public static boolean m7151a(Context context, aty com_ushareit_listenit_aty) {
        atw z = com_ushareit_listenit_aty.mo729z();
        if (z == null || z == atw.NONE) {
            return false;
        }
        Collection<String> A = com_ushareit_listenit_aty.mo728A();
        if (A == null || A.isEmpty()) {
            return false;
        }
        boolean z2;
        for (String a : A) {
            if (m7152a(context, a)) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (z2 != (z == atw.INSTALLED)) {
            return false;
        }
        Object y = com_ushareit_listenit_aty.mo698y();
        if (TextUtils.isEmpty(y)) {
            return true;
        }
        apb.m6565a(context).m6585f(y, null);
        return true;
    }

    public static boolean m7152a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        } catch (RuntimeException e2) {
            return false;
        }
    }
}
