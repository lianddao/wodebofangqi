package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.C0154a;

public class euh {
    public static String m18003a(Context context, faj com_ushareit_listenit_faj) {
        exz com_ushareit_listenit_eug = new eug(context);
        Object b = com_ushareit_listenit_eug.m17993b("BEYLA_DEVICE_ID");
        if (!TextUtils.isEmpty(b) && !fah.m18705b((String) b) && !fah.m18708c((String) b)) {
            return b;
        }
        faj com_ushareit_listenit_faj2 = faj.UNKNOWN;
        if (com_ushareit_listenit_faj == faj.MAC) {
            b = fah.m18704b(context);
            com_ushareit_listenit_faj2 = faj.MAC;
        } else if (com_ushareit_listenit_faj == null) {
            try {
                if (TextUtils.isEmpty(b)) {
                    b = fah.m18704b(context);
                    com_ushareit_listenit_faj2 = faj.MAC;
                }
                if (TextUtils.isEmpty(b)) {
                    b = fah.m18707c(context);
                    com_ushareit_listenit_faj2 = faj.ANDROID;
                    if (fah.m18708c((String) b)) {
                        b = null;
                    }
                }
                if (TextUtils.isEmpty(b)) {
                    b = fah.m18706c();
                    com_ushareit_listenit_faj2 = faj.UUID;
                }
            } catch (Exception e) {
                b = fah.m18706c();
                com_ushareit_listenit_faj2 = faj.UUID;
            }
        } else {
            exu.m18432a("Can not support ID type:" + com_ushareit_listenit_faj.m18714a());
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        String str = com_ushareit_listenit_faj2.m18714a() + "." + b;
        com_ushareit_listenit_eug.m17991a("BEYLA_DEVICE_ID", str);
        return str;
    }

    public static long m18002a(long j, long j2) {
        return (j / C0154a.f2953i) - (j2 / C0154a.f2953i);
    }
}
