package com.ushareit.listenit;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class dow {
    private static final dma<?>[] f10115b = new dma[0];
    final Set<dma<?>> f10116a;
    private final doz f10117c;
    private final Map<cdr<?>, cdt> f10118d;
    private final cdt f10119e;
    private dpa f10120f;

    public dow(cdt com_ushareit_listenit_cdt) {
        this.f10116a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f10117c = new dox(this);
        this.f10120f = null;
        this.f10118d = null;
        this.f10119e = com_ushareit_listenit_cdt;
    }

    public dow(Map<cdr<?>, cdt> map) {
        this.f10116a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f10117c = new dox(this);
        this.f10120f = null;
        this.f10118d = map;
        this.f10119e = null;
    }

    private static void m15203a(dma<?> com_ushareit_listenit_dma_, cep com_ushareit_listenit_cep, IBinder iBinder) {
        if (com_ushareit_listenit_dma_.m10795d()) {
            com_ushareit_listenit_dma_.m10791a(new doy(com_ushareit_listenit_dma_, com_ushareit_listenit_cep, iBinder, null));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            com_ushareit_listenit_dma_.m10791a(null);
            com_ushareit_listenit_dma_.m10796e();
            com_ushareit_listenit_cep.m10987a(com_ushareit_listenit_dma_.mo1271a().intValue());
        } else {
            doz com_ushareit_listenit_doy = new doy(com_ushareit_listenit_dma_, com_ushareit_listenit_cep, iBinder, null);
            com_ushareit_listenit_dma_.m10791a(com_ushareit_listenit_doy);
            try {
                iBinder.linkToDeath(com_ushareit_listenit_doy, 0);
            } catch (RemoteException e) {
                com_ushareit_listenit_dma_.m10796e();
                com_ushareit_listenit_cep.m10987a(com_ushareit_listenit_dma_.mo1271a().intValue());
            }
        }
    }

    public void m15205a() {
        for (dma com_ushareit_listenit_dma : (dma[]) this.f10116a.toArray(f10115b)) {
            com_ushareit_listenit_dma.m10791a(null);
            if (com_ushareit_listenit_dma.mo1271a() != null) {
                IBinder l;
                com_ushareit_listenit_dma.m10799h();
                if (this.f10119e != null) {
                    l = this.f10119e.m10648l();
                } else if (this.f10118d != null) {
                    l = ((cdt) this.f10118d.get(((dlu) com_ushareit_listenit_dma).mo1275b())).m10648l();
                } else {
                    Log.wtf("UnconsumedApiCalls", "Could not get service broker binder", new Exception());
                    l = null;
                }
                m15203a(com_ushareit_listenit_dma, null, l);
                this.f10116a.remove(com_ushareit_listenit_dma);
            } else if (com_ushareit_listenit_dma.m10797f()) {
                this.f10116a.remove(com_ushareit_listenit_dma);
            }
        }
    }

    void m15206a(dma<? extends ceg> com_ushareit_listenit_dma__extends_com_ushareit_listenit_ceg) {
        this.f10116a.add(com_ushareit_listenit_dma__extends_com_ushareit_listenit_ceg);
        com_ushareit_listenit_dma__extends_com_ushareit_listenit_ceg.m10791a(this.f10117c);
    }

    public void m15207a(dpa com_ushareit_listenit_dpa) {
        if (this.f10116a.isEmpty()) {
            com_ushareit_listenit_dpa.mo2010a();
        }
        this.f10120f = com_ushareit_listenit_dpa;
    }

    public void m15208a(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f10116a.size());
    }

    public void m15209b() {
        for (dma d : (dma[]) this.f10116a.toArray(f10115b)) {
            d.m10794d(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean m15210c() {
        for (dma d : (dma[]) this.f10116a.toArray(f10115b)) {
            if (!d.m10795d()) {
                return true;
            }
        }
        return false;
    }
}
