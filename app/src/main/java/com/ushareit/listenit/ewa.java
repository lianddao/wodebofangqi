package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;

public class ewa extends evd {
    public ewa(Context context, evl com_ushareit_listenit_evl) {
        super(context, com_ushareit_listenit_evl);
    }

    protected evf mo2300c(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        m18143a(com_ushareit_listenit_eva, evf.RUNNING);
        eva com_ushareit_listenit_ewb = new ewb(com_ushareit_listenit_eva);
        if (m18147a(i, com_ushareit_listenit_ewb, com_ushareit_listenit_eva.m18123h())) {
            m18150b(com_ushareit_listenit_eva, "executed", null);
            String q = com_ushareit_listenit_ewb.m18260q();
            eva b = this.b.m18174b(q);
            if (b == null) {
                m18258a(com_ushareit_listenit_eva, "Target command not exist!");
                return com_ushareit_listenit_eva.m18125j();
            }
            ewt.m18313a(this.a, b.m18099a().hashCode());
            if (b.m18125j() == evf.WAITING || b.m18125j() == evf.RUNNING || (b.m18125j() == evf.ERROR && !com_ushareit_listenit_eva.m18128m())) {
                m18143a(b, evf.CANCELED);
                m18150b(b, "canceled", "Removed by command!");
            }
            this.b.m18168a(q);
            m18143a(com_ushareit_listenit_eva, evf.COMPLETED);
            m18150b(com_ushareit_listenit_eva, "completed", null);
            return com_ushareit_listenit_eva.m18125j();
        }
        m18143a(com_ushareit_listenit_eva, evf.WAITING);
        return com_ushareit_listenit_eva.m18125j();
    }

    private void m18258a(eva com_ushareit_listenit_eva, String str) {
        m18143a(com_ushareit_listenit_eva, evf.ERROR);
        m18152c(com_ushareit_listenit_eva);
        m18146a(com_ushareit_listenit_eva, "error_reason", str);
    }
}
