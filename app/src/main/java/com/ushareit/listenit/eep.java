package com.ushareit.listenit;

import android.text.TextUtils;

public class eep {
    private static final Object f10885a = new Object();
    private final ees f10886b;

    public eep(ees com_ushareit_listenit_ees) {
        this.f10886b = com_ushareit_listenit_ees;
    }

    public String m16857a() {
        String str = null;
        synchronized (f10885a) {
            String string = this.f10886b.m16881a().getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    public boolean m16858a(String str) {
        boolean z;
        synchronized (f10885a) {
            String string = this.f10886b.m16881a().getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                valueOf = String.valueOf(",");
                valueOf2 = String.valueOf(str);
                this.f10886b.m16881a().edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
