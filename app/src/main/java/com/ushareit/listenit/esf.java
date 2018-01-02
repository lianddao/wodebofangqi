package com.ushareit.listenit;

import android.content.Context;
import android.util.Pair;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class esf implements esn {
    private static esa f11693a = null;
    private static esf f11694b = null;
    private final Map<ese, esm> f11695c = new LinkedHashMap();
    private final Map<ese, eso> f11696d = new LinkedHashMap();
    private final Map<Object, esg> f11697e = new LinkedHashMap();

    public static void m17732a(esa com_ushareit_listenit_esa, esp com_ushareit_listenit_esp) {
        f11693a = com_ushareit_listenit_esa;
        f11693a.m17694a(com_ushareit_listenit_esp);
    }

    private static esf m17740b() {
        if (f11694b == null) {
            synchronized (esf.class) {
                if (f11694b == null) {
                    exw.m18443a("AD.Manager", "AdManager inited");
                    f11694b = new esf(f11693a.m17695b());
                }
            }
        }
        return f11694b;
    }

    private esf(List<esj> list) {
        for (esj a : list) {
            a.m17786a((esn) this);
        }
    }

    public static void m17731a(Context context) {
        f11693a.m17693a(context);
    }

    public static boolean m17739a(ese com_ushareit_listenit_ese) {
        return f11693a.m17697c().m17687b(com_ushareit_listenit_ese);
    }

    public static List<esi> m17730a(ese com_ushareit_listenit_ese, eso com_ushareit_listenit_eso) {
        List a = f11693a.m17697c().m17684a(com_ushareit_listenit_ese);
        if (!(com_ushareit_listenit_eso == null || a == null || a.isEmpty())) {
            m17740b().m17736a(com_ushareit_listenit_ese.f11685b, a, com_ushareit_listenit_eso);
        }
        return a;
    }

    public static void m17738a(List<esi> list) {
        f11693a.m17697c().m17686a((List) list);
    }

    public static void m17735a(ese com_ushareit_listenit_ese, esm com_ushareit_listenit_esm) {
        m17740b().m17741b(com_ushareit_listenit_ese, com_ushareit_listenit_esm);
    }

    public static void m17742b(ese com_ushareit_listenit_ese, eso com_ushareit_listenit_eso) {
        m17740b().m17747c(com_ushareit_listenit_ese, com_ushareit_listenit_eso);
    }

    private void m17741b(ese com_ushareit_listenit_ese, esm com_ushareit_listenit_esm) {
        if (!m17744b(com_ushareit_listenit_ese)) {
            esd com_ushareit_listenit_esd;
            for (esj com_ushareit_listenit_esj : f11693a.m17695b()) {
                int a = com_ushareit_listenit_esj.mo2369a(com_ushareit_listenit_ese);
                if (a != 9003) {
                    if (a == 0) {
                        if (com_ushareit_listenit_esm != null) {
                            m17748c(com_ushareit_listenit_ese, com_ushareit_listenit_esm);
                        }
                        exw.m18449b("AD.Manager", "doStartPreload(): " + com_ushareit_listenit_ese.mo2366a() + " start preload and count is " + com_ushareit_listenit_ese.f11689f);
                        com_ushareit_listenit_esj.m17788b(com_ushareit_listenit_ese);
                        return;
                    } else if (com_ushareit_listenit_esm != null) {
                        com_ushareit_listenit_esd = new esd(a);
                        m17733a(com_ushareit_listenit_ese, com_ushareit_listenit_esd, com_ushareit_listenit_esm);
                        esh.m17759a(f11693a.m17691a(), com_ushareit_listenit_ese, com_ushareit_listenit_esd);
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (com_ushareit_listenit_esm != null) {
                com_ushareit_listenit_esd = new esd(9003);
                m17733a(com_ushareit_listenit_ese, com_ushareit_listenit_esd, com_ushareit_listenit_esm);
                esh.m17759a(f11693a.m17691a(), com_ushareit_listenit_ese, com_ushareit_listenit_esd);
            }
        }
    }

    private void m17747c(ese com_ushareit_listenit_ese, eso com_ushareit_listenit_eso) {
        m17749d(com_ushareit_listenit_ese);
        if (com_ushareit_listenit_eso != null) {
            List a = f11693a.m17697c().m17684a(com_ushareit_listenit_ese);
            if (a != null) {
                m17743b(com_ushareit_listenit_ese.f11685b, a, com_ushareit_listenit_eso);
                return;
            }
        }
        if (!m17744b(com_ushareit_listenit_ese)) {
            esd com_ushareit_listenit_esd;
            for (esj com_ushareit_listenit_esj : f11693a.m17695b()) {
                int a2 = com_ushareit_listenit_esj.mo2369a(com_ushareit_listenit_ese);
                if (a2 != 9003) {
                    if (a2 == 0) {
                        if (com_ushareit_listenit_eso != null) {
                            m17750d(com_ushareit_listenit_ese, com_ushareit_listenit_eso);
                        }
                        exw.m18449b("AD.Manager", "doStartLoad(): " + com_ushareit_listenit_ese.mo2366a() + " start load and count is " + com_ushareit_listenit_ese.f11689f);
                        com_ushareit_listenit_esj.m17788b(com_ushareit_listenit_ese);
                        return;
                    } else if (com_ushareit_listenit_eso != null) {
                        com_ushareit_listenit_esd = new esd(a2);
                        m17734a(com_ushareit_listenit_ese, com_ushareit_listenit_esd, com_ushareit_listenit_eso);
                        esh.m17759a(f11693a.m17691a(), com_ushareit_listenit_ese, com_ushareit_listenit_esd);
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (com_ushareit_listenit_eso != null) {
                com_ushareit_listenit_esd = new esd(9003);
                m17734a(com_ushareit_listenit_ese, com_ushareit_listenit_esd, com_ushareit_listenit_eso);
                esh.m17759a(f11693a.m17691a(), com_ushareit_listenit_ese, com_ushareit_listenit_esd);
            }
        }
    }

    public void mo2283a(ese com_ushareit_listenit_ese, List<esi> list) {
        m17749d(com_ushareit_listenit_ese);
        eso c = m17746c(com_ushareit_listenit_ese);
        if (c == null) {
            exw.m18449b("AD.Manager", "onAdLoaded(): " + com_ushareit_listenit_ese.mo2366a() + " is loaded but has no listener");
            f11693a.m17697c().m17686a((List) list);
        } else {
            exw.m18449b("AD.Manager", "onAdLoaded(): " + com_ushareit_listenit_ese.mo2366a() + " is loaded and notify caller");
            m17743b(com_ushareit_listenit_ese.f11685b, list, c);
        }
        m17737a(com_ushareit_listenit_ese.f11686c, false);
    }

    public void mo2282a(ese com_ushareit_listenit_ese, esd com_ushareit_listenit_esd) {
        int a = com_ushareit_listenit_esd == null ? 1 : com_ushareit_listenit_esd.mo2345a();
        if (a == 2002) {
            m17737a(com_ushareit_listenit_ese.f11686c, true);
        }
        esm d = m17749d(com_ushareit_listenit_ese);
        if (!(d == null || a == 2002)) {
            m17733a(com_ushareit_listenit_ese, com_ushareit_listenit_esd, d);
        }
        if (m17744b(com_ushareit_listenit_ese)) {
            eso c = m17746c(com_ushareit_listenit_ese);
            if (c == null) {
                exw.m18449b("AD.Manager", "onAdError(): " + com_ushareit_listenit_ese.mo2366a() + " load error but has no listener");
                return;
            }
            exw.m18449b("AD.Manager", "onAdError(): " + com_ushareit_listenit_ese.mo2366a() + " load error and notify caller");
            m17734a(com_ushareit_listenit_ese, com_ushareit_listenit_esd, c);
        }
    }

    public void mo2284a(Object obj) {
        esg c = m17745c(obj);
        if (c != null) {
            c.m17755a();
        }
    }

    public void mo2285b(Object obj) {
        esg c = m17745c(obj);
        if (c != null) {
            c.m17756b();
        }
    }

    private void m17737a(String str, boolean z) {
        List<Pair> arrayList = new ArrayList();
        synchronized (this.f11696d) {
            for (Entry entry : this.f11696d.entrySet()) {
                if (((ese) entry.getKey()).f11686c.equals(str)) {
                    arrayList.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
        }
        for (Pair pair : arrayList) {
            List a = f11693a.m17697c().m17685a((ese) pair.first, z);
            if (a != null) {
                m17749d((ese) pair.first);
                m17746c((ese) pair.first);
                m17743b(((ese) pair.first).f11685b, a, (eso) pair.second);
            }
        }
    }

    private boolean m17744b(ese com_ushareit_listenit_ese) {
        boolean containsKey;
        synchronized (this.f11696d) {
            containsKey = this.f11696d.containsKey(com_ushareit_listenit_ese);
        }
        return containsKey;
    }

    private boolean m17750d(ese com_ushareit_listenit_ese, eso com_ushareit_listenit_eso) {
        synchronized (this.f11696d) {
            if (this.f11696d.containsKey(com_ushareit_listenit_ese)) {
                return false;
            }
            this.f11696d.put(com_ushareit_listenit_ese, com_ushareit_listenit_eso);
            return true;
        }
    }

    private eso m17746c(ese com_ushareit_listenit_ese) {
        eso com_ushareit_listenit_eso;
        synchronized (this.f11696d) {
            com_ushareit_listenit_eso = (eso) this.f11696d.remove(com_ushareit_listenit_ese);
        }
        return com_ushareit_listenit_eso;
    }

    private boolean m17748c(ese com_ushareit_listenit_ese, esm com_ushareit_listenit_esm) {
        synchronized (this.f11695c) {
            if (this.f11695c.containsKey(com_ushareit_listenit_ese)) {
                return false;
            }
            this.f11695c.put(com_ushareit_listenit_ese, com_ushareit_listenit_esm);
            return true;
        }
    }

    private esm m17749d(ese com_ushareit_listenit_ese) {
        esm com_ushareit_listenit_esm;
        synchronized (this.f11695c) {
            com_ushareit_listenit_esm = (esm) this.f11695c.remove(com_ushareit_listenit_ese);
        }
        return com_ushareit_listenit_esm;
    }

    private esg m17745c(Object obj) {
        esg com_ushareit_listenit_esg;
        synchronized (this.f11697e) {
            com_ushareit_listenit_esg = (esg) this.f11697e.get(obj);
        }
        return com_ushareit_listenit_esg;
    }

    private void m17736a(String str, List<esi> list, eso com_ushareit_listenit_eso) {
        synchronized (this.f11697e) {
            for (esi com_ushareit_listenit_esi : list) {
                this.f11697e.put(com_ushareit_listenit_esi.m17769c(), new esg(str, com_ushareit_listenit_esi, com_ushareit_listenit_eso));
            }
        }
    }

    private void m17743b(String str, List<esi> list, eso com_ushareit_listenit_eso) {
        m17736a(str, (List) list, com_ushareit_listenit_eso);
        exw.m18449b("AD.Manager", "notifyAdLoaded(): " + str + " loaded");
        try {
            com_ushareit_listenit_eso.mo2356a(str, (List) list);
        } catch (Throwable th) {
            esh.m17763a(f11693a.m17691a(), str, "notifyAdLoaded", th);
        }
    }

    private void m17734a(ese com_ushareit_listenit_ese, esd com_ushareit_listenit_esd, eso com_ushareit_listenit_eso) {
        if (com_ushareit_listenit_eso != null) {
            exw.m18449b("AD.Manager", "notifyAdError(): " + com_ushareit_listenit_ese.mo2366a() + " load error");
            try {
                com_ushareit_listenit_eso.mo2355a(com_ushareit_listenit_ese.f11685b, com_ushareit_listenit_ese.f11684a, com_ushareit_listenit_esd);
            } catch (Throwable th) {
                esh.m17763a(f11693a.m17691a(), com_ushareit_listenit_ese.f11685b, "notifyAdError", th);
            }
        }
    }

    private void m17733a(ese com_ushareit_listenit_ese, esd com_ushareit_listenit_esd, esm com_ushareit_listenit_esm) {
        if (com_ushareit_listenit_esm != null) {
            exw.m18449b("AD.Manager", "notifyAdPreloadError(): " + com_ushareit_listenit_ese.mo2366a() + " load error");
            try {
                com_ushareit_listenit_esm.mo2358a(com_ushareit_listenit_ese.f11685b, com_ushareit_listenit_ese.f11684a, com_ushareit_listenit_esd);
            } catch (Throwable th) {
                esh.m17763a(f11693a.m17691a(), com_ushareit_listenit_ese.f11685b, "notifyAdPreloadError", th);
            }
        }
    }
}
