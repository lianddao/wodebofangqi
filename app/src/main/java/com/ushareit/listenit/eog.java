package com.ushareit.listenit;

import android.view.View;
import java.util.ArrayList;
import java.util.Map.Entry;

class eog implements Runnable {
    final /* synthetic */ eoc f11373a;
    private final ArrayList<View> f11374b = new ArrayList();
    private final ArrayList<View> f11375c = new ArrayList();

    eog(eoc com_ushareit_listenit_eoc) {
        this.f11373a = com_ushareit_listenit_eoc;
    }

    public void run() {
        this.f11373a.f11366j = false;
        for (Entry entry : this.f11373a.f11361e.entrySet()) {
            View view = (View) entry.getKey();
            int i = ((eoe) entry.getValue()).f11368a;
            int i2 = ((eoe) entry.getValue()).f11369b;
            View view2 = ((eoe) entry.getValue()).f11371d;
            if (this.f11373a.f11362f.m17258a(view2, view, i)) {
                this.f11374b.add(view);
            } else if (!this.f11373a.f11362f.m17258a(view2, view, i2)) {
                this.f11375c.add(view);
            }
        }
        if (this.f11373a.f11363g != null) {
            this.f11373a.f11363g.onVisibilityChanged(this.f11374b, this.f11375c);
        }
        this.f11374b.clear();
        this.f11375c.clear();
    }
}
