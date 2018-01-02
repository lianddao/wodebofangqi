package com.ushareit.listenit;

import android.view.View;

final class arw extends ato<aru> {
    public arw(aru com_ushareit_listenit_aru) {
        super(com_ushareit_listenit_aru);
    }

    public void run() {
        int i = 0;
        aru com_ushareit_listenit_aru = (aru) m5924a();
        if (com_ushareit_listenit_aru != null) {
            View a = com_ushareit_listenit_aru.f5256b;
            arv b = com_ushareit_listenit_aru.f5259e;
            if (a != null && b != null) {
                arx a2 = aru.m6918a(a, com_ushareit_listenit_aru.f5257c);
                if (a2.m6938a()) {
                    com_ushareit_listenit_aru.f5269o = com_ushareit_listenit_aru.f5269o + 1;
                } else {
                    com_ushareit_listenit_aru.f5269o = 0;
                }
                int i2 = com_ushareit_listenit_aru.f5269o > com_ushareit_listenit_aru.f5258d ? 1 : 0;
                int i3 = (com_ushareit_listenit_aru.f5266l == null || !com_ushareit_listenit_aru.f5266l.m6938a()) ? 0 : 1;
                if (!(i2 == 0 && a2.m6938a())) {
                    com_ushareit_listenit_aru.f5266l = a2;
                }
                String valueOf = String.valueOf(a2.m6939b());
                synchronized (com_ushareit_listenit_aru) {
                    if (com_ushareit_listenit_aru.f5267m.containsKey(valueOf)) {
                        i = ((Integer) com_ushareit_listenit_aru.f5267m.get(valueOf)).intValue();
                    }
                    com_ushareit_listenit_aru.f5267m.put(valueOf, Integer.valueOf(i + 1));
                }
                if (i2 != 0 && i3 == 0) {
                    com_ushareit_listenit_aru.f5268n = System.currentTimeMillis();
                    b.mo98a();
                    if (!com_ushareit_listenit_aru.f5262h) {
                        return;
                    }
                } else if (i2 == 0 && i3 != 0) {
                    b.mo820b();
                }
                if (!com_ushareit_listenit_aru.f5265k) {
                    com_ushareit_listenit_aru.f5260f.postDelayed(com_ushareit_listenit_aru.f5261g, (long) com_ushareit_listenit_aru.f5264j);
                }
            }
        }
    }
}
