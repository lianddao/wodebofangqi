package com.ushareit.listenit;

public class ewj extends ewq {
    private String f12021b;
    private long f12022c;
    private int f12023d;
    private boolean f12024e;

    public ewj(ewr com_ushareit_listenit_ewr, ewf com_ushareit_listenit_ewf) {
        super(com_ushareit_listenit_ewr, com_ushareit_listenit_ewf);
    }

    public boolean m18298a() {
        return fbb.m18765d(this.f12021b);
    }

    protected void mo2305a(ewf com_ushareit_listenit_ewf) {
        super.mo2305a(com_ushareit_listenit_ewf);
        this.f12021b = com_ushareit_listenit_ewf.m18108b("msg_land_thumb_url", "");
        this.f12022c = com_ushareit_listenit_ewf.m18097a("msg_duration", 3000);
        this.f12023d = com_ushareit_listenit_ewf.m18096a("msg_layout", 0);
        this.f12024e = com_ushareit_listenit_ewf.m18106a("can_skip", false);
    }
}
