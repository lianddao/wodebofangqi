package com.ushareit.listenit;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class etl {
    private static etn f11789a = new etn();

    public static eto m17902a(String str) {
        eto com_ushareit_listenit_eto;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (str != null && str.equals(f11789a.f11790a)) {
            j = currentTimeMillis - f11789a.f11791b;
        }
        f11789a.f11790a = str;
        f11789a.f11791b = currentTimeMillis;
        synchronized (etl.class) {
            com_ushareit_listenit_eto = new eto(etp.PageIn, str, null, j, null);
        }
        return com_ushareit_listenit_eto;
    }

    public static eto m17905b(String str) {
        eto com_ushareit_listenit_eto = null;
        exu.m18430a((Object) str);
        if (str == null || !str.equals(f11789a.f11790a)) {
            exw.m18456d("EntityFactory", "Abnormal page out, page in name:" + f11789a.f11790a + ", page out name:" + str);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - f11789a.f11791b;
            f11789a.f11791b = currentTimeMillis;
            synchronized (etl.class) {
                com_ushareit_listenit_eto = new eto(etp.PageOut, str, null, j, null);
            }
        }
        return com_ushareit_listenit_eto;
    }

    public static eto m17903a(String str, String str2, long j, List<Pair<String, String>> list) {
        eto com_ushareit_listenit_eto;
        synchronized (etl.class) {
            com_ushareit_listenit_eto = new eto(etp.Custom, str, str2, j, list);
        }
        return com_ushareit_listenit_eto;
    }

    public static eto m17904a(Throwable th) {
        eto com_ushareit_listenit_eto = null;
        if (th != null) {
            while (th.getCause() != null) {
                th = th.getCause();
            }
            String name = th.getClass().getName();
            String message = th.getMessage();
            if (!(name == null || name.length() == 0)) {
                StringBuilder stringBuilder = new StringBuilder(4096);
                stringBuilder.append(message).append("\\n");
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    stringBuilder.append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("() ").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append("\\n");
                }
                Object substring = stringBuilder.length() >= 4096 ? stringBuilder.toString().substring(0, 4096) : stringBuilder.toString();
                List arrayList = new ArrayList();
                arrayList.add(new Pair("stack", substring));
                synchronized (etl.class) {
                    com_ushareit_listenit_eto = new eto(etp.UnhandledException, name, message, 0, arrayList);
                }
            }
        }
        return com_ushareit_listenit_eto;
    }
}
