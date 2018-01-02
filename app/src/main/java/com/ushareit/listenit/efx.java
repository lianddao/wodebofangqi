package com.ushareit.listenit;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class efx {
    private static final efx f11004a = new efx();
    private final Map<String, WeakReference<efm>> f11005b = new HashMap();
    private final Object f11006c = new Object();

    efx() {
    }

    static efx m17042a() {
        return f11004a;
    }

    public void m17043a(efm com_ushareit_listenit_efm) {
        synchronized (this.f11006c) {
            this.f11005b.put(com_ushareit_listenit_efm.mo2150e().toString(), new WeakReference(com_ushareit_listenit_efm));
        }
    }

    public void m17044b(efm com_ushareit_listenit_efm) {
        synchronized (this.f11006c) {
            String com_ushareit_listenit_efl = com_ushareit_listenit_efm.mo2150e().toString();
            WeakReference weakReference = (WeakReference) this.f11005b.get(com_ushareit_listenit_efl);
            efm com_ushareit_listenit_efm2 = weakReference != null ? (efm) weakReference.get() : null;
            if (com_ushareit_listenit_efm2 == null || com_ushareit_listenit_efm2 == com_ushareit_listenit_efm) {
                this.f11005b.remove(com_ushareit_listenit_efl);
            }
        }
    }
}
