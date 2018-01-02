package com.ushareit.listenit;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.text.TextUtils;

public class gbk {
    public static boolean m21599a(Context context, String... strArr) {
        for (String a : strArr) {
            if (!(dw.m15878a(context, a) == 0)) {
                return false;
            }
        }
        return true;
    }

    public static void m21597a(Object obj, gbn com_ushareit_listenit_gbn, String str, String... strArr) {
        m21596a(obj, com_ushareit_listenit_gbn, str, 17039370, 17039360, strArr);
    }

    public static void m21596a(Object obj, gbn com_ushareit_listenit_gbn, String str, int i, int i2, String... strArr) {
        m21601b(obj);
        boolean z = false;
        for (String str2 : strArr) {
            if (z || m21600a(obj, str2)) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z || TextUtils.isEmpty(str)) {
            m21602b(obj, strArr, 257);
        } else {
            new Builder(m21595a(obj)).setMessage(str).setCancelable(false).setPositiveButton(i, new gbm(obj, strArr)).setNegativeButton(i2, new gbl(com_ushareit_listenit_gbn)).create().show();
        }
    }

    private static boolean m21600a(Object obj, String str) {
        if (obj instanceof Activity) {
            return C0364n.m25144a((Activity) obj, str);
        }
        if (obj instanceof ah) {
            return ((ah) obj).m1296a(str);
        }
        return false;
    }

    private static void m21602b(Object obj, String[] strArr, int i) {
        m21601b(obj);
        if (obj instanceof Activity) {
            C0364n.m25143a((Activity) obj, strArr, i);
        } else if (obj instanceof ah) {
            ((ah) obj).m1294a(strArr, i);
        }
    }

    private static Activity m21595a(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        if (obj instanceof ah) {
            return ((ah) obj).m1328m();
        }
        return null;
    }

    private static void m21601b(Object obj) {
        if (!(obj instanceof ah) && !(obj instanceof Activity)) {
            throw new IllegalArgumentException("Caller must be an Activity or a Fragment.");
        }
    }
}
