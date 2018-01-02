package com.ushareit.listenit;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

public class him {
    public static boolean m23904a(Context context) {
        return m23902a(context, null).size() > 0;
    }

    public static boolean m23905b(Context context) {
        return m23902a(context, null).size() == 2 || m23902a(context, null).size() == 3;
    }

    public static List<hip> m23902a(Context context, hik com_ushareit_listenit_hik) {
        List<hip> arrayList = new ArrayList();
        if (VERSION.SDK_INT > 8) {
            m23903a((List) arrayList, new hin(context));
        }
        m23903a((List) arrayList, new hiv(context));
        m23903a((List) arrayList, new hix(context));
        m23903a((List) arrayList, new hir(context));
        m23903a((List) arrayList, new hit(context));
        if (com_ushareit_listenit_hik != null) {
            for (hip a : arrayList) {
                a.m23908a(com_ushareit_listenit_hik);
            }
        }
        return arrayList;
    }

    private static void m23903a(List<hip> list, hip com_ushareit_listenit_hip) {
        if (com_ushareit_listenit_hip.f15501f) {
            list.add(com_ushareit_listenit_hip);
        }
    }
}
