package com.ushareit.listenit;

import android.content.Intent;

public class evx extends eva {
    public evx(eva com_ushareit_listenit_eva) {
        super(com_ushareit_listenit_eva, true);
    }

    public boolean m18248q() {
        return m18106a("has_notify", false);
    }

    public evi m18246c(int i) {
        if (!m18248q()) {
            return null;
        }
        Intent a;
        evi a2 = m18098a(i, "");
        evh d = m18247d(i);
        if (d != null) {
            a = evd.m18136a(this, null, 95, d.toString());
            a.putExtra("update_route", evy.MSGBOX_SHOWED.toString());
        } else {
            a = evd.m18137a(this, evf.COMPLETED, m18250s(), m18251t(), "completed", null);
        }
        a2.f11963k = 3;
        a2.f11964l = a.toUri(0);
        a = evd.m18137a(this, evf.CANCELED, 0, null, "canceled", evy.NOTIFY_CANCELED.toString());
        a.putExtra("update_route", evy.NOTIFY_CANCELED.toString());
        a2.f11965m = 3;
        a2.f11966n = a.toUri(0);
        return a2;
    }

    public boolean m18249r() {
        return m18106a("has_msgbox", false);
    }

    public evh m18247d(int i) {
        if (!m18249r()) {
            return null;
        }
        evh f = m18121f("");
        Intent a = evd.m18137a(this, evf.COMPLETED, m18250s(), m18251t(), "completed", null);
        f.f11948g = 3;
        f.f11949h = a.toUri(0);
        a = evd.m18137a(this, evf.CANCELED, 0, null, "canceled", evy.MSGBOX_CANCELED.toString());
        a.putExtra("update_route", evy.MSGBOX_CANCELED.toString());
        f.f11950i = 3;
        f.f11951j = a.toUri(0);
        return f;
    }

    public int m18250s() {
        return m18096a("intent_event", 0);
    }

    public String m18251t() {
        return m18119e("intent_uri");
    }

    public evy m18252u() {
        return evy.m18253a(m18108b("notify_cmd_route", evy.NONE.toString()));
    }
}
