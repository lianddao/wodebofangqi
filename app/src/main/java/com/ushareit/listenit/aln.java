package com.ushareit.listenit;

import android.content.Context;
import com.facebook.ads.C0016g;
import com.facebook.ads.C0060k;
import com.facebook.ads.internal.view.C0030c;
import java.util.Map;
import org.json.JSONObject;

public class aln extends akv {
    private static final String f4686a = aln.class.getSimpleName();
    private C0030c f4687b;
    private ami f4688c;
    private akw f4689d;
    private Map<String, Object> f4690e;
    private Context f4691f;
    private long f4692g;
    private atr f4693h;

    private void m6059a(aol com_ushareit_listenit_aol) {
        this.f4692g = 0;
        this.f4693h = null;
        amh a = amh.m6275a((JSONObject) this.f4690e.get("data"));
        if (atx.m7151a(this.f4691f, (aty) a)) {
            this.f4689d.mo664a((akv) this, C0016g.f610b);
            return;
        }
        this.f4687b = new C0030c(this.f4691f, new alo(this, a), com_ushareit_listenit_aol.m6467e());
        this.f4687b.m998a(com_ushareit_listenit_aol.m6469g(), com_ushareit_listenit_aol.m6470h());
        this.f4688c = new ami(this.f4691f, this.f4687b, this.f4687b.getViewabilityChecker(), new alp(this));
        this.f4688c.m6287a(a);
        this.f4687b.loadDataWithBaseURL(aub.m7176a(), a.m6278a(), "text/html", "utf-8", null);
        if (this.f4689d != null) {
            this.f4689d.mo663a((akv) this, this.f4687b);
        }
    }

    public void mo705a(Context context, C0060k c0060k, akw com_ushareit_listenit_akw, Map<String, Object> map) {
        this.f4691f = context;
        this.f4689d = com_ushareit_listenit_akw;
        this.f4690e = map;
        m6059a((aol) map.get("definition"));
    }

    public void mo674b() {
        if (this.f4687b != null) {
            aub.m7177a(this.f4687b);
            this.f4687b.destroy();
            this.f4687b = null;
        }
    }
}
