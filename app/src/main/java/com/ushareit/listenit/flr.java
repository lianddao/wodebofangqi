package com.ushareit.listenit;

import java.util.List;

public class flr extends fjy {
    public void m19792d() {
        if (fbb.m18763c(gyn.m23252k())) {
            exw.m18457e("ShareListSync", "Warnning: country code is null!");
        } else if (((double) gvj.am(eys.m18562a())) < 0.0d) {
            exw.m18457e("ShareListSync", "startSyncShareLists, no longitude");
        } else {
            List<fnl> n = fqs.m20481n();
            int a = m19786a(n);
            if (a == gvj.m22970i()) {
                exw.m18457e("ShareListSync", "startSyncShareLists, songNumber=0");
                return;
            }
            exw.m18457e("ShareListSync", "startSyncShareLists");
            fjz com_ushareit_listenit_fls = new fls(this, n.size(), n, a);
            for (fnl a2 : n) {
                m19789a(a2, com_ushareit_listenit_fls);
            }
        }
    }

    private void m19789a(fnl com_ushareit_listenit_fnl, fjz com_ushareit_listenit_fjz) {
        fjy.m19571a().m16736a("sharelists").m16736a(com_ushareit_listenit_fnl.getId()).m16736a("sgN").m16726a(new flt(this, com_ushareit_listenit_fnl, com_ushareit_listenit_fjz));
    }

    private void m19787a(int i, int i2) {
        m19790b(i, i2);
    }

    private void m19790b(int i, int i2) {
        fni c = m19791c(i, i2);
        exw.m18457e("ShareListSync", "syncNearby, longitude=" + c.getLg() + ", city=" + c.getAd());
        String m = fle.m19717b().m19747m();
        fjy.m19574b().m16736a(m).m16736a("sgN").m16726a(new flv(this, m, c));
    }

    private fni m19791c(int i, int i2) {
        return new fni(fle.m19717b().m19747m(), fle.m19717b().m19748n(), i, i2, gvj.am(eys.m18562a()), 0, gvj.aw(eys.m18562a()));
    }

    private int m19786a(List<fnl> list) {
        int i = 0;
        for (fnl sgN : list) {
            i = sgN.getSgN() + i;
        }
        return i;
    }
}
