package com.ushareit.listenit;

import android.app.Activity;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class czp extends dod {
    private final List<czo> f9433a = new ArrayList();

    private czp(doe com_ushareit_listenit_doe) {
        super(com_ushareit_listenit_doe);
        this.d.mo2014a("StorageOnStopCallback", (dod) this);
    }

    public static czp m13529a(Activity activity) {
        doe b = dod.m13520b(new doc(activity));
        czp com_ushareit_listenit_czp = (czp) b.mo2013a("StorageOnStopCallback", czp.class);
        return com_ushareit_listenit_czp == null ? new czp(b) : com_ushareit_listenit_czp;
    }

    public void mo1671a() {
        ArrayList arrayList;
        synchronized (this.f9433a) {
            arrayList = new ArrayList(this.f9433a);
            this.f9433a.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            czo com_ushareit_listenit_czo = (czo) it.next();
            if (com_ushareit_listenit_czo != null) {
                Log.d("StorageOnStopCallback", "removing subscription from activity.");
                com_ushareit_listenit_czo.m13518b().run();
                czn.m13514a().m13516a(com_ushareit_listenit_czo.m13519c());
            }
        }
    }

    public void m13531a(czo com_ushareit_listenit_czo) {
        synchronized (this.f9433a) {
            this.f9433a.add(com_ushareit_listenit_czo);
        }
    }

    public void m13532b(czo com_ushareit_listenit_czo) {
        synchronized (this.f9433a) {
            this.f9433a.remove(com_ushareit_listenit_czo);
        }
    }
}
