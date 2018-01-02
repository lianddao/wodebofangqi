package com.ushareit.listenit;

import android.net.Uri;
import android.util.Log;
import java.util.Map;

class alo implements avm {
    final /* synthetic */ amh f4694a;
    final /* synthetic */ aln f4695b;

    alo(aln com_ushareit_listenit_aln, amh com_ushareit_listenit_amh) {
        this.f4695b = com_ushareit_listenit_aln;
        this.f4694a = com_ushareit_listenit_amh;
    }

    public void mo162a() {
        if (this.f4695b.f4688c != null) {
            this.f4695b.f4688c.m5951a();
        }
    }

    public void mo163a(int i) {
        if (i == 0 && this.f4695b.f4692g > 0 && this.f4695b.f4693h != null) {
            att.m7141a(atq.m7136a(this.f4695b.f4692g, this.f4695b.f4693h, this.f4694a.m6281c()));
            this.f4695b.f4692g = 0;
            this.f4695b.f4693h = null;
        }
    }

    public void mo164a(String str, Map<String, String> map) {
        Uri parse = Uri.parse(str);
        if ("fbad".equals(parse.getScheme()) && akp.m5929a(parse.getAuthority()) && this.f4695b.f4689d != null) {
            this.f4695b.f4689d.mo665b(this.f4695b);
        }
        ako a = akp.m5928a(this.f4695b.f4691f, this.f4694a.mo698y(), parse, map);
        if (a != null) {
            try {
                this.f4695b.f4693h = a.mo666a();
                this.f4695b.f4692g = System.currentTimeMillis();
                a.mo667b();
            } catch (Throwable e) {
                Log.e(aln.f4686a, "Error executing action", e);
            }
        }
    }
}
