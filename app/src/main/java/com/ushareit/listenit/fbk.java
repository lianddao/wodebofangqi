package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;

public final class fbk {
    private static fbl f12381a = null;

    public static String m18788a(String str) {
        if (f12381a == null) {
            f12381a = fbl.m18789a();
        }
        ArrayList a = f12381a.m18792a(str);
        if (a == null || a.size() <= 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            fbm com_ushareit_listenit_fbm = (fbm) it.next();
            if (com_ushareit_listenit_fbm.f12387a == 2) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append(com_ushareit_listenit_fbm.f12389c);
                stringBuilder.append(' ');
                stringBuilder.append(com_ushareit_listenit_fbm.f12388b);
            } else {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append(com_ushareit_listenit_fbm.f12388b);
            }
        }
        return stringBuilder.toString();
    }
}
