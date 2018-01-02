package com.ushareit.listenit;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class asa {
    private static final ava f5300i = new ava();
    private static final ThreadPoolExecutor f5301j = ((ThreadPoolExecutor) Executors.newCachedThreadPool(f5300i));
    Map<String, String> f5302a;
    private final Context f5303b;
    private final asg f5304c = asg.m6966a();
    private final app f5305d = new app(this.f5303b);
    private ase f5306e;
    private aom f5307f;
    private aps f5308g;
    private final String f5309h = asf.m6964a();

    public asa(Context context) {
        this.f5303b = context.getApplicationContext();
    }

    private void m6947a(amu com_ushareit_listenit_amu) {
        if (this.f5306e != null) {
            this.f5306e.mo640a(com_ushareit_listenit_amu);
        }
        m6958a();
    }

    private void m6950a(asj com_ushareit_listenit_asj) {
        if (this.f5306e != null) {
            this.f5306e.mo641a(com_ushareit_listenit_asj);
        }
        m6958a();
    }

    private void m6951a(String str) {
        try {
            ash a = this.f5304c.m6970a(str);
            aok b = a.m6972b();
            if (b != null) {
                this.f5305d.m6637a(b.m6460b());
                atu.m7143a(b.m6458a().m6465c(), this.f5307f);
            }
            switch (asd.f5313a[a.m6971a().ordinal()]) {
                case 1:
                    asj com_ushareit_listenit_asj = (asj) a;
                    if (b != null && b.m6458a().m6466d()) {
                        atu.m7144a(str, this.f5307f);
                    }
                    m6950a(com_ushareit_listenit_asj);
                    return;
                case 2:
                    ask com_ushareit_listenit_ask = (ask) a;
                    String c = com_ushareit_listenit_ask.m6973c();
                    ajw a2 = ajw.m5820a(com_ushareit_listenit_ask.m6974d(), ajw.ERROR_MESSAGE);
                    if (c != null) {
                        str = c;
                    }
                    m6947a(a2.m5822a(str));
                    return;
                default:
                    m6947a(ajw.UNKNOWN_RESPONSE.m5822a(str));
                    return;
            }
        } catch (Exception e) {
            m6947a(ajw.PARSER_FAILURE.m5822a(e.getMessage()));
        }
        m6947a(ajw.PARSER_FAILURE.m5822a(e.getMessage()));
    }

    private apu m6952b() {
        return new asc(this);
    }

    public void m6958a() {
        if (this.f5308g != null) {
            this.f5308g.m6736c(1);
            this.f5308g.m6734b(1);
            this.f5308g = null;
        }
    }

    public void m6959a(aom com_ushareit_listenit_aom) {
        m6958a();
        if (auv.m7234c(this.f5303b) == auw.NONE) {
            m6947a(new amu(ajw.NETWORK_ERROR, "No network connection"));
            return;
        }
        this.f5307f = com_ushareit_listenit_aom;
        asm.m6976a(this.f5303b);
        if (atu.m7145a(com_ushareit_listenit_aom)) {
            String c = atu.m7147c(com_ushareit_listenit_aom);
            if (c != null) {
                m6951a(c);
                return;
            } else {
                m6947a(ajw.LOAD_TOO_FREQUENTLY.m5822a(null));
                return;
            }
        }
        f5301j.submit(new asb(this, com_ushareit_listenit_aom));
    }

    public void m6960a(ase com_ushareit_listenit_ase) {
        this.f5306e = com_ushareit_listenit_ase;
    }
}
