package com.ushareit.listenit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.C0016g;

class aka implements aky {
    final /* synthetic */ Runnable f4573a;
    final /* synthetic */ ajx f4574b;

    aka(ajx com_ushareit_listenit_ajx, Runnable runnable) {
        this.f4574b = com_ushareit_listenit_ajx;
        this.f4573a = runnable;
    }

    public void mo642a(akx com_ushareit_listenit_akx) {
        if (com_ushareit_listenit_akx == this.f4574b.f4557o) {
            this.f4574b.f4551g.removeCallbacks(this.f4573a);
            this.f4574b.f4558p = com_ushareit_listenit_akx;
            this.f4574b.f4546a.mo78a((aku) com_ushareit_listenit_akx);
            this.f4574b.m5863n();
        }
    }

    public void mo643a(akx com_ushareit_listenit_akx, C0016g c0016g) {
        if (com_ushareit_listenit_akx == this.f4574b.f4557o) {
            this.f4574b.f4551g.removeCallbacks(this.f4573a);
            this.f4574b.m5834a((aku) com_ushareit_listenit_akx);
            this.f4574b.m5858l();
            this.f4574b.f4546a.mo79a(new amu(c0016g.m958a(), c0016g.m959b()));
        }
    }

    public void mo644a(akx com_ushareit_listenit_akx, String str, boolean z) {
        this.f4574b.f4546a.mo76a();
        Object obj = !TextUtils.isEmpty(str) ? 1 : null;
        if (z && obj != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (!(this.f4574b.f4561s.f5069d instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setData(Uri.parse(str));
            this.f4574b.f4561s.f5069d.startActivity(intent);
        }
    }

    public void mo645b(akx com_ushareit_listenit_akx) {
        this.f4574b.f4546a.mo80b();
    }

    public void mo646c(akx com_ushareit_listenit_akx) {
        this.f4574b.f4546a.mo81d();
    }

    public void mo647d(akx com_ushareit_listenit_akx) {
        this.f4574b.f4546a.mo82e();
    }
}
