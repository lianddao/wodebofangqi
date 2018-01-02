package com.ushareit.listenit;

import android.content.Context;
import com.umeng.analytics.pro.C0321x;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class eyv {
    public static void m18566a(Context context, eyh com_ushareit_listenit_eyh, Throwable th) {
        exu.m18430a((Object) com_ushareit_listenit_eyh);
        try {
            Object e;
            Object obj;
            eyh d = com_ushareit_listenit_eyh.mo2329d();
            if (d != null) {
                e = d.mo2330e();
            } else {
                String str = "file is null";
            }
            String f = com_ushareit_listenit_eyh.mo2331f();
            if (d != null) {
                obj = "path exist:" + d.mo2328c() + ", path can write:" + d.mo2324a();
            } else {
                String str2 = "file is null";
            }
            String a = etc.m17841a(eye.m18474a());
            Object message = th != null ? th.getMessage() : null;
            HashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("file_path", e);
            linkedHashMap.put("file_name", f);
            linkedHashMap.put("file_info", obj);
            linkedHashMap.put("free_space", a);
            linkedHashMap.put(C0321x.aF, message);
            esr.m17820b(context, "TS_CreateFileError", linkedHashMap);
        } catch (Exception e2) {
        }
    }

    public static void m18567a(String str, boolean z, int i) {
        URL url = null;
        try {
            url = new URL(str);
        } catch (Exception e) {
        }
        if (url != null) {
            try {
                int port = url.getPort();
            } catch (Exception e2) {
                return;
            }
        }
        port = -1;
        String host = url != null ? url.getHost() : "";
        Object obj = "cloud";
        if (port >= 52999 && port < 53009) {
            obj = "share_stp";
        } else if (port >= 2999 && port < 3009 && host.startsWith("192.168.")) {
            obj = "share_tcp";
        }
        HashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("urltype", obj);
        linkedHashMap.put("iscomplete", String.valueOf(z));
        linkedHashMap.put("timeout", (i / 1000) + "s");
        esr.m17820b(eys.m18562a(), "net_download_read_timeout", linkedHashMap);
    }
}
