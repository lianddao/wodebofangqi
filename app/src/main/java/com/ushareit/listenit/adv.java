package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.app.Activity;
import java.util.HashSet;

public class adv extends ah {
    private tw f4178a;
    private final ade f4179b;
    private final adt f4180c;
    private final HashSet<adv> f4181d;
    private adv f4182e;

    public adv() {
        this(new ade());
    }

    @SuppressLint({"ValidFragment"})
    public adv(ade com_ushareit_listenit_ade) {
        this.f4180c = new adx();
        this.f4181d = new HashSet();
        this.f4179b = com_ushareit_listenit_ade;
    }

    public void m5314a(tw twVar) {
        this.f4178a = twVar;
    }

    ade m5312a() {
        return this.f4179b;
    }

    public tw m5315b() {
        return this.f4178a;
    }

    public adt m5316c() {
        return this.f4180c;
    }

    private void m5310a(adv com_ushareit_listenit_adv) {
        this.f4181d.add(com_ushareit_listenit_adv);
    }

    private void m5311b(adv com_ushareit_listenit_adv) {
        this.f4181d.remove(com_ushareit_listenit_adv);
    }

    public void mo591a(Activity activity) {
        super.mo591a(activity);
        this.f4182e = ads.m5294a().m5298a(m1328m().m709f());
        if (this.f4182e != this) {
            this.f4182e.m5310a(this);
        }
    }

    public void mo171e() {
        super.mo171e();
        if (this.f4182e != null) {
            this.f4182e.m5311b(this);
            this.f4182e = null;
        }
    }

    public void mo173f() {
        super.mo173f();
        this.f4179b.m5268a();
    }

    public void mo174g() {
        super.mo174g();
        this.f4179b.m5270b();
    }

    public void mo203z() {
        super.mo203z();
        this.f4179b.m5271c();
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.f4178a != null) {
            this.f4178a.m26482a();
        }
    }
}
