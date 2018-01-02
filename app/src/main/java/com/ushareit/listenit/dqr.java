package com.ushareit.listenit;

import android.content.Context;

final class dqr implements dqu {
    dqr() {
    }

    public dqw mo2023a(Context context, String str, dqv com_ushareit_listenit_dqv) {
        dqw com_ushareit_listenit_dqw = new dqw();
        com_ushareit_listenit_dqw.f10173a = com_ushareit_listenit_dqv.mo2021a(context, str);
        if (com_ushareit_listenit_dqw.f10173a != 0) {
            com_ushareit_listenit_dqw.f10174b = com_ushareit_listenit_dqv.mo2022a(context, str, false);
        } else {
            com_ushareit_listenit_dqw.f10174b = com_ushareit_listenit_dqv.mo2022a(context, str, true);
        }
        if (com_ushareit_listenit_dqw.f10173a == 0 && com_ushareit_listenit_dqw.f10174b == 0) {
            com_ushareit_listenit_dqw.f10175c = 0;
        } else if (com_ushareit_listenit_dqw.f10174b >= com_ushareit_listenit_dqw.f10173a) {
            com_ushareit_listenit_dqw.f10175c = 1;
        } else {
            com_ushareit_listenit_dqw.f10175c = -1;
        }
        return com_ushareit_listenit_dqw;
    }
}
