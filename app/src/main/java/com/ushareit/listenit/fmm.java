package com.ushareit.listenit;

public class fmm extends fjy {
    public void m19915a(fjz com_ushareit_listenit_fjz) {
        fno j = fle.m19717b().m19744j();
        fjy.m19571a().m16736a("devices").m16736a(j.getId()).m16736a(fno.KEY_VERSION).m16726a(new fmn(this, com_ushareit_listenit_fjz, j));
    }

    private void m19914a(fno com_ushareit_listenit_fno, fjz com_ushareit_listenit_fjz) {
        exw.m18443a("UserDeviceSync", "uploadAll: version=" + com_ushareit_listenit_fno.getV());
        fjy.m19571a().m16736a("devices").m16736a(com_ushareit_listenit_fno.getId()).m16733a(com_ushareit_listenit_fno.toMap()).mo2124a(new fmo(this, com_ushareit_listenit_fjz, com_ushareit_listenit_fno));
    }
}
