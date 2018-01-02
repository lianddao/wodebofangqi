package com.ushareit.listenit;

public class bko implements bhy {
    public static final bib f6793a = new bkp();
    private bku f6794b;

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        try {
            bkr com_ushareit_listenit_bkr = new bkr();
            if (!com_ushareit_listenit_bkr.m8872a(com_ushareit_listenit_bhz, true) || (com_ushareit_listenit_bkr.f6802b & 2) != 2) {
                return false;
            }
            int min = Math.min(com_ushareit_listenit_bkr.f6809i, 8);
            bss com_ushareit_listenit_bss = new bss(min);
            com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, min);
            if (bkl.m8847a(m8860a(com_ushareit_listenit_bss))) {
                this.f6794b = new bkl();
            } else if (bkz.m8888a(m8860a(com_ushareit_listenit_bss))) {
                this.f6794b = new bkz();
            } else if (!bkt.m8875a(m8860a(com_ushareit_listenit_bss))) {
                return false;
            } else {
                this.f6794b = new bkt();
            }
            return true;
        } catch (bfw e) {
            return false;
        }
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        bii a = com_ushareit_listenit_bia.mo1025a(0);
        com_ushareit_listenit_bia.mo1026a();
        this.f6794b.m8839a(com_ushareit_listenit_bia, a);
    }

    public void mo980a(long j) {
        this.f6794b.m8838a(j);
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        return this.f6794b.m8837a(com_ushareit_listenit_bhz, com_ushareit_listenit_bie);
    }

    private static bss m8860a(bss com_ushareit_listenit_bss) {
        com_ushareit_listenit_bss.m9707c(0);
        return com_ushareit_listenit_bss;
    }
}
