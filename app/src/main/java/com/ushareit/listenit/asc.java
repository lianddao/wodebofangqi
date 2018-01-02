package com.ushareit.listenit;

import org.json.JSONException;

class asc extends apu {
    final /* synthetic */ asa f5312a;

    asc(asa com_ushareit_listenit_asa) {
        this.f5312a = com_ushareit_listenit_asa;
    }

    public void m6961a(aqf com_ushareit_listenit_aqf) {
        atu.m7146b(this.f5312a.f5307f);
        this.f5312a.f5308g = null;
        try {
            aqg a = com_ushareit_listenit_aqf.m6775a();
            if (a != null) {
                String e = a.m6780e();
                ash a2 = this.f5312a.f5304c.m6970a(e);
                if (a2.m6971a() == asi.ERROR) {
                    ask com_ushareit_listenit_ask = (ask) a2;
                    String c = com_ushareit_listenit_ask.m6973c();
                    this.f5312a.m6947a(ajw.m5820a(com_ushareit_listenit_ask.m6974d(), ajw.ERROR_MESSAGE).m5822a(c == null ? e : c));
                    return;
                }
            }
        } catch (JSONException e2) {
        }
        this.f5312a.m6947a(new amu(ajw.NETWORK_ERROR, com_ushareit_listenit_aqf.getMessage()));
    }

    public void mo792a(aqg com_ushareit_listenit_aqg) {
        if (com_ushareit_listenit_aqg != null) {
            String e = com_ushareit_listenit_aqg.m6780e();
            atu.m7146b(this.f5312a.f5307f);
            this.f5312a.f5308g = null;
            this.f5312a.m6951a(e);
        }
    }

    public void mo793a(Exception exception) {
        if (aqf.class.equals(exception.getClass())) {
            m6961a((aqf) exception);
        } else {
            this.f5312a.m6947a(new amu(ajw.NETWORK_ERROR, exception.getMessage()));
        }
    }
}
