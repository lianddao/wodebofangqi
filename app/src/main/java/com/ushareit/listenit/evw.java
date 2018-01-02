package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.common.Constants;

public class evw extends evd {
    public evw(Context context, evl com_ushareit_listenit_evl) {
        super(context, com_ushareit_listenit_evl);
    }

    protected void mo2299b(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        super.mo2299b(i, com_ushareit_listenit_eva, bundle);
        if (com_ushareit_listenit_eva.m18125j() == evf.WAITING) {
            eva com_ushareit_listenit_evx = new evx(com_ushareit_listenit_eva);
            evy u = com_ushareit_listenit_evx.m18252u();
            if (!com_ushareit_listenit_evx.m18248q()) {
                return;
            }
            if (u == evy.NONE || u == evy.EXECUTED) {
                evi c = com_ushareit_listenit_evx.m18246c(com_ushareit_listenit_eva.m18099a().hashCode());
                evb h = com_ushareit_listenit_eva.m18123h();
                if (c != null && fbb.m18765d(c.f11958f) && c.f11958f.startsWith(Constants.HTTP) && m18147a(i, com_ushareit_listenit_evx, h) && !eux.m18082c(c)) {
                    try {
                        eux.m18077b(c);
                        if (eux.m18082c(c)) {
                            m18150b(com_ushareit_listenit_evx, "downloaded", null);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public evf mo2300c(int i, eva com_ushareit_listenit_eva, Bundle bundle) {
        m18143a(com_ushareit_listenit_eva, evf.RUNNING);
        eva com_ushareit_listenit_evx = new evx(com_ushareit_listenit_eva);
        evy u = com_ushareit_listenit_evx.m18252u();
        if (u != evy.NONE && u != evy.EXECUTED) {
            m18143a(com_ushareit_listenit_eva, evf.WAITING);
            return com_ushareit_listenit_eva.m18125j();
        } else if (!m18147a(i, com_ushareit_listenit_evx, com_ushareit_listenit_eva.m18123h())) {
            m18143a(com_ushareit_listenit_eva, evf.WAITING);
            return com_ushareit_listenit_eva.m18125j();
        } else if ((com_ushareit_listenit_evx.m18248q() || com_ushareit_listenit_evx.m18249r()) && !m18147a(i, com_ushareit_listenit_evx, com_ushareit_listenit_eva.m18124i())) {
            m18143a(com_ushareit_listenit_eva, evf.WAITING);
            return com_ushareit_listenit_eva.m18125j();
        } else {
            if (u == evy.NONE) {
                m18150b(com_ushareit_listenit_eva, "executed", null);
                m18241a(com_ushareit_listenit_eva, evy.EXECUTED);
            }
            if (com_ushareit_listenit_evx.m18248q()) {
                if (m18242a(com_ushareit_listenit_evx)) {
                    m18241a(com_ushareit_listenit_eva, evy.NOTIFY_SHOWED);
                }
                m18143a(com_ushareit_listenit_eva, evf.WAITING);
            } else if (com_ushareit_listenit_evx.m18249r()) {
                m18144a(com_ushareit_listenit_eva, com_ushareit_listenit_evx.m18247d(com_ushareit_listenit_eva.m18099a().hashCode()));
                m18241a(com_ushareit_listenit_eva, evy.MSGBOX_SHOWED);
                m18143a(com_ushareit_listenit_eva, evf.WAITING);
            } else {
                exw.m18449b("CMD.NotificationHandler", "silent execute the command " + com_ushareit_listenit_evx.m18099a());
                if (ewt.m18321a(this.a, com_ushareit_listenit_evx.m18099a(), com_ushareit_listenit_evx.m18250s(), com_ushareit_listenit_evx.m18251t())) {
                    m18143a(com_ushareit_listenit_eva, evf.COMPLETED);
                    m18150b(com_ushareit_listenit_eva, "completed", null);
                } else {
                    m18143a(com_ushareit_listenit_eva, evf.ERROR);
                    m18146a(com_ushareit_listenit_eva, "error_reason", "silent execute failed: " + com_ushareit_listenit_evx.m18122g());
                    m18152c(com_ushareit_listenit_evx);
                }
            }
            return com_ushareit_listenit_eva.m18125j();
        }
    }

    public void mo2304a(eva com_ushareit_listenit_eva, Intent intent) {
        if (intent.hasExtra("update_route")) {
            m18241a(com_ushareit_listenit_eva, evy.m18253a(intent.getStringExtra("update_route")));
        }
        super.mo2304a(com_ushareit_listenit_eva, intent);
    }

    private void m18241a(eva com_ushareit_listenit_eva, evy com_ushareit_listenit_evy) {
        m18146a(com_ushareit_listenit_eva, "notify_cmd_route", com_ushareit_listenit_evy.toString());
    }

    private boolean m18242a(evx com_ushareit_listenit_evx) {
        evi c = com_ushareit_listenit_evx.m18246c(com_ushareit_listenit_evx.m18099a().hashCode());
        if (fbb.m18765d(c.f11958f) && c.f11958f.startsWith(Constants.HTTP) && !eux.m18082c(c)) {
            if (c.f11959g) {
                try {
                    eux.m18077b(c);
                    if (eux.m18082c(c)) {
                        m18150b((eva) com_ushareit_listenit_evx, "downloaded", null);
                        super.m18145a((eva) com_ushareit_listenit_evx, c);
                        return true;
                    }
                } catch (Exception e) {
                }
                return false;
            }
            c.f11954b = 0;
        }
        super.m18145a((eva) com_ushareit_listenit_evx, c);
        return true;
    }
}
