package com.ushareit.listenit;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class apz implements aqk {
    private void m6760a(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                for (String str2 : (List) map.get(str)) {
                    mo773a(str + ":" + str2);
                }
            }
        }
    }

    public void mo772a(aqg com_ushareit_listenit_aqg) {
        if (com_ushareit_listenit_aqg != null) {
            mo773a("=== HTTP Response ===");
            mo773a("Receive url: " + com_ushareit_listenit_aqg.m6777b());
            mo773a("Status: " + com_ushareit_listenit_aqg.m6776a());
            m6760a(com_ushareit_listenit_aqg.m6778c());
            mo773a("Content:\n" + com_ushareit_listenit_aqg.m6780e());
        }
    }

    public void mo773a(String str) {
        System.out.println(str);
    }

    public void mo774a(HttpURLConnection httpURLConnection, Object obj) {
        mo773a("=== HTTP Request ===");
        mo773a(httpURLConnection.getRequestMethod() + " " + httpURLConnection.getURL().toString());
        if (obj instanceof String) {
            mo773a("Content: " + ((String) obj));
        }
        m6760a(httpURLConnection.getRequestProperties());
    }

    public boolean mo775a() {
        return false;
    }
}
