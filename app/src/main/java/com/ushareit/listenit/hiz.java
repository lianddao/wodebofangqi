package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;

public class hiz {
    private static long f15516a = 0;

    public static void m23914a(Context context) {
        if (System.currentTimeMillis() - gvj.m22888a() >= 180000) {
            int g = fbb.m18768g(context);
            int a = euo.m18007a(context, "upgrade_new_verson", 0);
            if (a > g) {
                int a2 = euo.m18007a(context, "upgrade_flag", 0);
                if ((a2 & 8) != 0 && gvj.m22903b() != a && ((Boolean) eyw.m18568a(context).second).booleanValue()) {
                    hjc.m23926a(context, g, a);
                    m23916a(context, g, a, a2);
                    exw.m18443a("CloudUpdater", "checkWhenAppStart run");
                }
            }
        }
    }

    public static void m23917b(Context context) {
        if (System.currentTimeMillis() - f15516a >= 3000) {
            Pair a = eyw.m18568a(context);
            if (!((Boolean) a.first).booleanValue() && !((Boolean) a.second).booleanValue()) {
                m23915a(context, C0349R.string.update_check_update_no_network);
            } else if (m23918c(context)) {
                fad.m18688a(context, context.getPackageName(), fql.m20387a(), "update_user_check", false);
                exw.m18443a("CloudUpdater", "checkWhenUserRequest run");
            } else {
                m23915a(context, C0349R.string.update_check_version_no_new);
            }
        }
    }

    public static void m23913a() {
    }

    public static boolean m23918c(Context context) {
        if (euo.m18007a(context, "upgrade_new_verson", 0) > fbb.m18768g(context)) {
            return true;
        }
        return false;
    }

    private static void m23916a(Context context, int i, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("msg", context.getString(C0349R.string.update_check_new_version_msg));
        if ((i3 & 1) == 0) {
            bundle.putString("btn2", context.getString(C0349R.string.update_check_new_version_cancel));
        }
        bundle.putString("btn1", context.getString(C0349R.string.update_check_new_version_update));
        hje com_ushareit_listenit_hja = new hja(context, i, i2, i3);
        if ((i3 & 1) == 0) {
            com_ushareit_listenit_hja.m18411a(hjk.TWOBUTTON);
        } else {
            com_ushareit_listenit_hja.m18411a(hjk.ONEBUTTON);
        }
        if ((i3 & 2) == 0) {
            com_ushareit_listenit_hja.m18412a(true, context.getString(C0349R.string.update_prompt_next_time));
        } else {
            com_ushareit_listenit_hja.m18415h(false);
        }
        com_ushareit_listenit_hja.m1317g(bundle);
        com_ushareit_listenit_hja.mo1295a(((ak) context).m709f(), "update confirm dialog");
    }

    private static void m23915a(Context context, int i) {
        if (context != null && System.currentTimeMillis() - f15516a >= 3000) {
            heb.m23597a(context.getResources().getString(i), 0).show();
            f15516a = System.currentTimeMillis();
        }
    }
}
