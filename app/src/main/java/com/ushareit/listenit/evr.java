package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;

public class evr extends evd {
    public evr(Context context, evl com_ushareit_listenit_evl) {
        super(context, com_ushareit_listenit_evl);
    }

    protected void mo2299b(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        super.mo2299b(i, com_ushareit_listenit_eva, bundle);
        if (com_ushareit_listenit_eva.m18125j() == evf.WAITING || com_ushareit_listenit_eva.m18125j() == evf.COMPLETED) {
            ewf com_ushareit_listenit_ewe = new ewe(com_ushareit_listenit_eva);
            ewl s = com_ushareit_listenit_ewe.m18287s();
            evb h = com_ushareit_listenit_eva.m18123h();
            if (s == null) {
                return;
            }
            if ((s.m18291e() == ewr.FLASH_MSG || s.m18291e() == ewr.IMAGE_MSG) && !eux.m18079b(com_ushareit_listenit_ewe, false) && m18147a(i, (eva) com_ushareit_listenit_ewe, h) && ewt.m18318a(this.a, i, com_ushareit_listenit_ewe.m18286r())) {
                try {
                    eux.m18070a(com_ushareit_listenit_ewe);
                    if (eux.m18074a(this.a, com_ushareit_listenit_ewe)) {
                        eux.m18073a(com_ushareit_listenit_ewe, true);
                    }
                    if (eux.m18079b(com_ushareit_listenit_ewe, false)) {
                        m18150b((eva) com_ushareit_listenit_ewe, "downloaded", null);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public evf mo2300c(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        eva com_ushareit_listenit_ewe = new ewe(com_ushareit_listenit_eva);
        m18143a(com_ushareit_listenit_eva, evf.RUNNING);
        if (m18147a(i, com_ushareit_listenit_ewe, com_ushareit_listenit_eva.m18123h())) {
            if (!com_ushareit_listenit_eva.m18106a("msg_cmd_report_executed", false)) {
                m18150b(com_ushareit_listenit_eva, "executed", null);
                m18146a(com_ushareit_listenit_eva, "msg_cmd_report_executed", String.valueOf(true));
            }
            if (m18204a(com_ushareit_listenit_ewe)) {
                m18203a(i, com_ushareit_listenit_ewe);
                m18143a(com_ushareit_listenit_eva, evf.COMPLETED);
                if (!com_ushareit_listenit_eva.m18106a("msg_cmd_report_completed", false)) {
                    m18150b(com_ushareit_listenit_eva, "completed", null);
                    m18146a(com_ushareit_listenit_eva, "msg_cmd_report_completed", String.valueOf(true));
                }
                return com_ushareit_listenit_eva.m18125j();
            }
            m18143a(com_ushareit_listenit_eva, evf.ERROR);
            m18146a(com_ushareit_listenit_eva, "error_reason", "not_support_ad_type: " + com_ushareit_listenit_eva.m18122g());
            m18152c(com_ushareit_listenit_eva);
            return com_ushareit_listenit_eva.m18125j();
        }
        m18143a(com_ushareit_listenit_eva, evf.WAITING);
        return com_ushareit_listenit_eva.m18125j();
    }

    private boolean m18204a(ewf com_ushareit_listenit_ewf) {
        if (com_ushareit_listenit_ewf == null) {
            return false;
        }
        switch (com_ushareit_listenit_ewf.m18285q()) {
            case SINGLE_MSG:
            case NORMAL_MSG:
            case NORMAL_BTN_MSG:
            case IMAGE_MSG:
            case MULTI_IMAGE_MSG:
            case SINGLE_CONTENT:
            case MULTI_CONTENT:
            case FLASH_MSG:
                return true;
            default:
                return false;
        }
    }

    private void m18203a(int i, ewf com_ushareit_listenit_ewf) {
        int i2 = 0;
        ewl s = com_ushareit_listenit_ewf.m18287s();
        if (s != null) {
            try {
                if (s.m18289c()) {
                    eux.m18078b(com_ushareit_listenit_ewf);
                }
                switch (s.m18291e()) {
                    case SINGLE_MSG:
                    case NORMAL_MSG:
                    case NORMAL_BTN_MSG:
                        if (ewt.m18318a(this.a, i, com_ushareit_listenit_ewf.m18286r())) {
                            eux.m18070a(com_ushareit_listenit_ewf);
                            return;
                        }
                        return;
                    case IMAGE_MSG:
                        if (ewt.m18318a(this.a, i, com_ushareit_listenit_ewf.m18286r())) {
                            eux.m18070a(com_ushareit_listenit_ewf);
                            if (eux.m18074a(this.a, com_ushareit_listenit_ewf)) {
                                eux.m18073a(com_ushareit_listenit_ewf, true);
                                return;
                            }
                            return;
                        }
                        return;
                    case MULTI_IMAGE_MSG:
                        if ((s instanceof ewn) && ewt.m18318a(this.a, i, com_ushareit_listenit_ewf.m18286r())) {
                            ewn com_ushareit_listenit_ewn = (ewn) s;
                            while (i2 < com_ushareit_listenit_ewn.m18306a()) {
                                eux.m18071a(com_ushareit_listenit_ewf, i2);
                                i2++;
                            }
                            return;
                        }
                        return;
                    case SINGLE_CONTENT:
                        if (s instanceof ewh) {
                            ewh com_ushareit_listenit_ewh = (ewh) s;
                            if (ewt.m18318a(this.a, i, com_ushareit_listenit_ewf.m18286r())) {
                                eux.m18072a(com_ushareit_listenit_ewf, com_ushareit_listenit_ewh.m18292a());
                                return;
                            }
                            return;
                        }
                        return;
                    case MULTI_CONTENT:
                        if (s instanceof ewm) {
                            ewm com_ushareit_listenit_ewm = (ewm) s;
                            while (i2 < com_ushareit_listenit_ewm.m18303a()) {
                                if (ewt.m18318a(this.a, i, com_ushareit_listenit_ewf.m18286r())) {
                                    eux.m18072a(com_ushareit_listenit_ewf, com_ushareit_listenit_ewm.m18304a(i2));
                                }
                                i2++;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    }
}
