package com.ushareit.listenit;

class cwn implements cwo {
    private final long f9276a;

    public cwn(cxa com_ushareit_listenit_cxa) {
        this.f9276a = Math.max(512, (long) Math.sqrt((double) (cyn.m13376a(com_ushareit_listenit_cxa) * 100)));
    }

    public boolean mo1651a(cwm com_ushareit_listenit_cwm) {
        return ((long) com_ushareit_listenit_cwm.m13199b()) > this.f9276a && (com_ushareit_listenit_cwm.m13200c().m12347h() || !com_ushareit_listenit_cwm.m13200c().m12346g().equals(cwc.m13142c()));
    }
}
