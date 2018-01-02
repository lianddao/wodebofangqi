package com.ushareit.listenit;

public abstract class ewl {
    private ewr f12008a;
    private int f12009b;
    private String f12010c;
    private String f12011d;
    private String f12012e;

    public ewl(ewr com_ushareit_listenit_ewr, ewf com_ushareit_listenit_ewf) {
        this.f12008a = com_ushareit_listenit_ewr;
        mo2305a(com_ushareit_listenit_ewf);
    }

    public boolean m18289c() {
        return fbb.m18765d(this.f12012e);
    }

    public String m18290d() {
        return this.f12012e;
    }

    protected void mo2305a(ewf com_ushareit_listenit_ewf) {
        this.f12009b = com_ushareit_listenit_ewf.m18096a("intent_event", 0);
        this.f12010c = com_ushareit_listenit_ewf.m18108b("intent_uri", "");
        this.f12011d = com_ushareit_listenit_ewf.m18108b("msg_bg_color", "");
        this.f12012e = com_ushareit_listenit_ewf.m18108b("msg_bg_url", "");
    }

    public ewr m18291e() {
        return this.f12008a;
    }
}
