package com.ushareit.listenit;

import android.content.Context;
import android.os.Looper;

final class dsp extends cdp<dtu, cdm> {
    dsp() {
    }

    public /* synthetic */ cdt mo1238a(Context context, Looper looper, cgs com_ushareit_listenit_cgs, Object obj, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        return m15444a(context, looper, com_ushareit_listenit_cgs, (cdm) obj, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
    }

    public dtu m15444a(Context context, Looper looper, cgs com_ushareit_listenit_cgs, cdm com_ushareit_listenit_cdm, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        return new dtu(context, looper, com_ushareit_listenit_ceb, com_ushareit_listenit_cec, "locationServices", com_ushareit_listenit_cgs);
    }
}
