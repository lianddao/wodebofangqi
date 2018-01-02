package com.ushareit.listenit;

import android.content.Intent;

public class evu extends eva {
    public evu(eva com_ushareit_listenit_eva) {
        super(com_ushareit_listenit_eva, true);
    }

    public boolean m18231q() {
        return m18106a("has_notify", false);
    }

    public evi m18229a(int i, boolean z) {
        if (!m18231q()) {
            return null;
        }
        Intent a;
        evi a2 = m18098a(i, "");
        evh b = m18230b(i, z);
        if (b != null) {
            a = evd.m18136a(this, null, 95, b.toString());
        } else {
            a = evd.m18136a(this, null, 96, null);
        }
        a2.f11963k = 3;
        a2.f11964l = a.toUri(0);
        if (z) {
            a = evd.m18137a(this, evf.CANCELED, 0, null, "canceled", "notify_canceled");
            a2.f11965m = 3;
            a2.f11966n = a.toUri(0);
        } else {
            a2.f11965m = 0;
            a2.f11966n = null;
        }
        return a2;
    }

    public boolean m18232r() {
        return m18106a("has_msgbox", false);
    }

    public evh m18230b(int i, boolean z) {
        if (!m18232r()) {
            return null;
        }
        evh f = m18121f("");
        f.f11952k = m18096a("msgbox_disp_count", 0);
        Intent a = evd.m18136a(this, null, 96, null);
        f.f11948g = 3;
        f.f11949h = a.toUri(0);
        if (z) {
            a = evd.m18137a(this, evf.CANCELED, 0, null, "canceled", "msgbox_canceled");
            f.f11950i = 3;
            f.f11951j = a.toUri(0);
        } else {
            f.f11950i = 0;
            f.f11951j = null;
        }
        return f;
    }

    public int m18233s() {
        return m18096a("msgbox_disp_count", 0);
    }

    public int m18234t() {
        return m18096a("msgbox_max_cancel_count", 0);
    }

    public String m18235u() {
        return m18119e("url");
    }

    public String m18236v() {
        return m18119e("pkg_name");
    }

    public int m18237w() {
        return m18096a("ver_code", 0);
    }

    public int m18238x() {
        return m18096a("install_mode", 2);
    }

    public evv m18239y() {
        return evv.m18240a(m18108b("install_cmd_route", evv.NONE.toString()));
    }
}
