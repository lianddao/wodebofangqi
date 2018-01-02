package com.ushareit.listenit;

import java.util.Map;

class coy implements cpa {
    final /* synthetic */ cor f8610a;

    coy(cor com_ushareit_listenit_cor) {
        this.f8610a = com_ushareit_listenit_cor;
    }

    public void mo1539a(Map<String, Object> map) {
        String str = (String) map.get("s");
        if (!str.equals("ok")) {
            String str2 = (String) map.get("d");
            if (this.f8610a.f8590v.m13094a()) {
                this.f8610a.f8590v.m13093a(new StringBuilder((String.valueOf(str).length() + 34) + String.valueOf(str2).length()).append("Failed to send stats: ").append(str).append(" (message: ").append(str2).append(")").toString(), new Object[0]);
            }
        }
    }
}
