package com.ushareit.listenit;

import android.content.Context;
import java.io.IOException;
import java.util.Map;

public class dxz extends duy {
    private final Map<String, Map<String, String>> f10634a = new fq();
    private final Map<String, Map<String, Boolean>> f10635b = new fq();
    private final Map<String, Map<String, Boolean>> f10636c = new fq();
    private final Map<String, drn> f10637d = new fq();
    private final Map<String, String> f10638e = new fq();

    dxz(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    private drn m16338a(String str, byte[] bArr) {
        if (bArr == null) {
            return new drn();
        }
        dfz a = dfz.m14123a(bArr);
        drn com_ushareit_listenit_drn = new drn();
        try {
            drn com_ushareit_listenit_drn2 = (drn) com_ushareit_listenit_drn.mo1670b(a);
            mo2096w().m16235E().m16265a("Parsed config. version, gmp_app_id", com_ushareit_listenit_drn.f10210a, com_ushareit_listenit_drn.f10211b);
            return com_ushareit_listenit_drn;
        } catch (IOException e) {
            mo2096w().m16262z().m16265a("Unable to merge remote config", str, e);
            return null;
        }
    }

    private Map<String, String> m16339a(drn com_ushareit_listenit_drn) {
        Map<String, String> fqVar = new fq();
        if (!(com_ushareit_listenit_drn == null || com_ushareit_listenit_drn.f10213d == null)) {
            for (dro com_ushareit_listenit_dro : com_ushareit_listenit_drn.f10213d) {
                if (com_ushareit_listenit_dro != null) {
                    fqVar.put(com_ushareit_listenit_dro.f10217a, com_ushareit_listenit_dro.f10218b);
                }
            }
        }
        return fqVar;
    }

    private void m16340a(String str, drn com_ushareit_listenit_drn) {
        Map fqVar = new fq();
        Map fqVar2 = new fq();
        if (!(com_ushareit_listenit_drn == null || com_ushareit_listenit_drn.f10214e == null)) {
            for (drm com_ushareit_listenit_drm : com_ushareit_listenit_drn.f10214e) {
                if (com_ushareit_listenit_drm != null) {
                    String str2 = (String) dur.f10335a.get(com_ushareit_listenit_drm.f10207a);
                    if (str2 != null) {
                        com_ushareit_listenit_drm.f10207a = str2;
                    }
                    fqVar.put(com_ushareit_listenit_drm.f10207a, com_ushareit_listenit_drm.f10208b);
                    fqVar2.put(com_ushareit_listenit_drm.f10207a, com_ushareit_listenit_drm.f10209c);
                }
            }
        }
        this.f10635b.put(str, fqVar);
        this.f10636c.put(str, fqVar2);
    }

    private void m16341d(String str) {
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        if (!this.f10637d.containsKey(str)) {
            byte[] d = mo2091r().m16116d(str);
            if (d == null) {
                this.f10634a.put(str, null);
                this.f10635b.put(str, null);
                this.f10636c.put(str, null);
                this.f10637d.put(str, null);
                this.f10638e.put(str, null);
                return;
            }
            drn a = m16338a(str, d);
            this.f10634a.put(str, m16339a(a));
            m16340a(str, a);
            this.f10637d.put(str, a);
            this.f10638e.put(str, null);
        }
    }

    protected drn m16342a(String str) {
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        m16341d(str);
        return (drn) this.f10637d.get(str);
    }

    String m16343a(String str, String str2) {
        mo2083j();
        m16341d(str);
        Map map = (Map) this.f10634a.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    protected boolean m16344a(String str, byte[] bArr, String str2) {
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        drn a = m16338a(str, bArr);
        if (a == null) {
            return false;
        }
        m16340a(str, a);
        this.f10637d.put(str, a);
        this.f10638e.put(str, str2);
        this.f10634a.put(str, m16339a(a));
        mo2084k().m15999a(str, a.f10215f);
        try {
            a.f10215f = null;
            byte[] bArr2 = new byte[a.m13475g()];
            a.mo1666a(dga.m14159a(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            mo2096w().m16262z().m16264a("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        mo2091r().m16103a(str, bArr);
        return true;
    }

    protected String m16345b(String str) {
        mo2083j();
        return (String) this.f10638e.get(str);
    }

    boolean m16346b(String str, String str2) {
        mo2083j();
        m16341d(str);
        Map map = (Map) this.f10635b.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected void m16347c(String str) {
        mo2083j();
        this.f10638e.put(str, null);
    }

    boolean m16348c(String str, String str2) {
        mo2083j();
        m16341d(str);
        Map map = (Map) this.f10636c.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected void mo2080e() {
    }

    public /* bridge */ /* synthetic */ void mo2081h() {
        super.mo2081h();
    }

    public /* bridge */ /* synthetic */ void mo2082i() {
        super.mo2082i();
    }

    public /* bridge */ /* synthetic */ void mo2083j() {
        super.mo2083j();
    }

    public /* bridge */ /* synthetic */ dwm mo2084k() {
        return super.mo2084k();
    }

    public /* bridge */ /* synthetic */ dva mo2085l() {
        return super.mo2085l();
    }

    public /* bridge */ /* synthetic */ dxe mo2086m() {
        return super.mo2086m();
    }

    public /* bridge */ /* synthetic */ dwu mo2087n() {
        return super.mo2087n();
    }

    public /* bridge */ /* synthetic */ dvg mo2088o() {
        return super.mo2088o();
    }

    public /* bridge */ /* synthetic */ cio mo2089p() {
        return super.mo2089p();
    }

    public /* bridge */ /* synthetic */ Context mo2090q() {
        return super.mo2090q();
    }

    public /* bridge */ /* synthetic */ dwo mo2091r() {
        return super.mo2091r();
    }

    public /* bridge */ /* synthetic */ dwk mo2092s() {
        return super.mo2092s();
    }

    public /* bridge */ /* synthetic */ dxz mo2093t() {
        return super.mo2093t();
    }

    public /* bridge */ /* synthetic */ dvx mo2094u() {
        return super.mo2094u();
    }

    public /* bridge */ /* synthetic */ dya mo2095v() {
        return super.mo2095v();
    }

    public /* bridge */ /* synthetic */ dxg mo2096w() {
        return super.mo2096w();
    }

    public /* bridge */ /* synthetic */ dxr mo2097x() {
        return super.mo2097x();
    }

    public /* bridge */ /* synthetic */ dwn mo2098y() {
        return super.mo2098y();
    }
}
