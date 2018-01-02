package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;

public class evz extends evd {
    public evz(Context context, evl com_ushareit_listenit_evl) {
        super(context, com_ushareit_listenit_evl);
    }

    protected void mo2299b(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        super.mo2299b(i, com_ushareit_listenit_eva, bundle);
        if (com_ushareit_listenit_eva.m18125j() == evf.WAITING || com_ushareit_listenit_eva.m18125j() == evf.COMPLETED) {
            ewf com_ushareit_listenit_ews = new ews(com_ushareit_listenit_eva);
            ewl s = com_ushareit_listenit_ews.m18287s();
            evb h = com_ushareit_listenit_eva.m18123h();
            if (s != null && (s instanceof ewp) && m18147a(i, (eva) com_ushareit_listenit_ews, h)) {
                ewp com_ushareit_listenit_ewp = (ewp) s;
                try {
                    if (com_ushareit_listenit_ewp.m18289c() && !eux.m18083c(com_ushareit_listenit_ews)) {
                        eux.m18078b(com_ushareit_listenit_ews);
                    }
                    if (com_ushareit_listenit_ewp.m18295f() && !eux.m18079b(com_ushareit_listenit_ews, false) && ewt.m18318a(this.a, i, com_ushareit_listenit_ews.m18286r())) {
                        eux.m18070a(com_ushareit_listenit_ews);
                        if (eux.m18074a(this.a, com_ushareit_listenit_ews)) {
                            eux.m18073a(com_ushareit_listenit_ews, true);
                        }
                        if (eux.m18079b(com_ushareit_listenit_ews, false)) {
                            m18150b((eva) com_ushareit_listenit_ews, "downloaded", null);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public evf mo2300c(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        eva com_ushareit_listenit_ews = new ews(com_ushareit_listenit_eva);
        m18143a(com_ushareit_listenit_eva, evf.RUNNING);
        if (!com_ushareit_listenit_ews.m18117d("personal_cmd_date")) {
            if (com_ushareit_listenit_ews.m18115d() > 0) {
                m18146a(com_ushareit_listenit_ews, "personal_cmd_date", String.valueOf(com_ushareit_listenit_ews.m18115d()));
            } else {
                m18146a(com_ushareit_listenit_ews, "personal_cmd_date", String.valueOf(System.currentTimeMillis()));
            }
        }
        if (m18147a(i, com_ushareit_listenit_ews, com_ushareit_listenit_eva.m18123h())) {
            if (!com_ushareit_listenit_eva.m18106a("msg_cmd_report_executed", false)) {
                m18150b(com_ushareit_listenit_eva, "executed", null);
                m18146a(com_ushareit_listenit_eva, "msg_cmd_report_executed", String.valueOf(true));
            }
            m18254a(i, com_ushareit_listenit_ews);
            m18143a(com_ushareit_listenit_eva, evf.COMPLETED);
            if (!com_ushareit_listenit_eva.m18106a("msg_cmd_report_completed", false)) {
                m18150b(com_ushareit_listenit_eva, "completed", null);
                m18146a(com_ushareit_listenit_eva, "msg_cmd_report_completed", String.valueOf(true));
            }
            return com_ushareit_listenit_eva.m18125j();
        }
        m18143a(com_ushareit_listenit_eva, evf.WAITING);
        return com_ushareit_listenit_eva.m18125j();
    }

    private void m18254a(int i, ews com_ushareit_listenit_ews) {
        m18146a((eva) com_ushareit_listenit_ews, "personal_cmd_read", String.valueOf(false));
    }
}
