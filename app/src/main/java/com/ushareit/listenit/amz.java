package com.ushareit.listenit;

import android.os.Bundle;

public class amz implements atd<Bundle> {
    private amx f4901a;
    private final amx f4902b;
    private final amw f4903c;
    private boolean f4904d = false;
    private boolean f4905e = false;
    private boolean f4906f = false;

    public amz(amw com_ushareit_listenit_amw) {
        this.f4903c = com_ushareit_listenit_amw;
        this.f4902b = new amx(com_ushareit_listenit_amw.f4884a);
        this.f4901a = new amx(com_ushareit_listenit_amw.f4884a);
    }

    public amz(amw com_ushareit_listenit_amw, Bundle bundle) {
        this.f4903c = com_ushareit_listenit_amw;
        this.f4902b = (amx) bundle.getSerializable("testStats");
        this.f4901a = (amx) bundle.getSerializable("viewableStats");
        this.f4904d = bundle.getBoolean("ended");
        this.f4905e = bundle.getBoolean("passed");
        this.f4906f = bundle.getBoolean("complete");
    }

    private void m6352a() {
        this.f4905e = true;
        m6353b();
    }

    private void m6353b() {
        this.f4906f = true;
        m6354c();
    }

    private void m6354c() {
        this.f4904d = true;
        this.f4903c.mo802a(this.f4906f, this.f4905e, this.f4905e ? this.f4901a : this.f4902b);
    }

    public void m6355a(double d, double d2) {
        if (!this.f4904d) {
            this.f4902b.m6340a(d, d2);
            this.f4901a.m6340a(d, d2);
            double f = this.f4901a.m6341b().m6350f();
            if (this.f4903c.f4887d && d2 < this.f4903c.f4884a) {
                this.f4901a = new amx(this.f4903c.f4884a);
            }
            if (this.f4903c.f4885b >= 0.0d && this.f4902b.m6341b().m6349e() > this.f4903c.f4885b && f == 0.0d) {
                m6353b();
            } else if (f >= this.f4903c.f4886c) {
                m6352a();
            }
        }
    }

    public Bundle getSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("viewableStats", this.f4901a);
        bundle.putSerializable("testStats", this.f4902b);
        bundle.putBoolean("ended", this.f4904d);
        bundle.putBoolean("passed", this.f4905e);
        bundle.putBoolean("complete", this.f4906f);
        return bundle;
    }
}
