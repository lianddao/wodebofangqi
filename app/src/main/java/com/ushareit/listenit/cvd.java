package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class cvd {
    public static final cvd f9184a = new cvd();
    static final /* synthetic */ boolean f9185b = (!cvd.class.desiredAssertionStatus());
    private Integer f9186c;
    private cvf f9187d;
    private cxa f9188e = null;
    private cwc f9189f = null;
    private cxa f9190g = null;
    private cwc f9191h = null;
    private cws f9192i = cxf.m13282d();
    private String f9193j = null;

    public static cvd m12977a(Map<String, Object> map) {
        String str;
        cvd com_ushareit_listenit_cvd = new cvd();
        com_ushareit_listenit_cvd.f9186c = (Integer) map.get("l");
        if (map.containsKey("sp")) {
            com_ushareit_listenit_cvd.f9188e = m12978a(cxd.m13275a(map.get("sp")));
            str = (String) map.get("sn");
            if (str != null) {
                com_ushareit_listenit_cvd.f9189f = cwc.m13139a(str);
            }
        }
        if (map.containsKey("ep")) {
            com_ushareit_listenit_cvd.f9190g = m12978a(cxd.m13275a(map.get("ep")));
            str = (String) map.get("en");
            if (str != null) {
                com_ushareit_listenit_cvd.f9191h = cwc.m13139a(str);
            }
        }
        str = (String) map.get("vf");
        if (str != null) {
            com_ushareit_listenit_cvd.f9187d = str.equals("l") ? cvf.LEFT : cvf.RIGHT;
        }
        str = (String) map.get("i");
        if (str != null) {
            com_ushareit_listenit_cvd.f9192i = cws.m13234a(str);
        }
        return com_ushareit_listenit_cvd;
    }

    private static cxa m12978a(cxa com_ushareit_listenit_cxa) {
        if ((com_ushareit_listenit_cxa instanceof cxi) || (com_ushareit_listenit_cxa instanceof cwb) || (com_ushareit_listenit_cxa instanceof cwq) || (com_ushareit_listenit_cxa instanceof cwr)) {
            return com_ushareit_listenit_cxa;
        }
        if (com_ushareit_listenit_cxa instanceof cwy) {
            return new cwq(Double.valueOf(((Long) com_ushareit_listenit_cxa.mo1643a()).doubleValue()), cxg.m13288a());
        }
        String valueOf = String.valueOf(com_ushareit_listenit_cxa.mo1643a());
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Unexpected value passed to normalizeValue: ").append(valueOf).toString());
    }

    private cvd m12979r() {
        cvd com_ushareit_listenit_cvd = new cvd();
        com_ushareit_listenit_cvd.f9186c = this.f9186c;
        com_ushareit_listenit_cvd.f9188e = this.f9188e;
        com_ushareit_listenit_cvd.f9189f = this.f9189f;
        com_ushareit_listenit_cvd.f9190g = this.f9190g;
        com_ushareit_listenit_cvd.f9191h = this.f9191h;
        com_ushareit_listenit_cvd.f9187d = this.f9187d;
        com_ushareit_listenit_cvd.f9192i = this.f9192i;
        return com_ushareit_listenit_cvd;
    }

    public cvd m12980a(int i) {
        cvd r = m12979r();
        r.f9186c = Integer.valueOf(i);
        r.f9187d = cvf.LEFT;
        return r;
    }

    public cvd m12981a(cws com_ushareit_listenit_cws) {
        cvd r = m12979r();
        r.f9192i = com_ushareit_listenit_cws;
        return r;
    }

    public cvd m12982a(cxa com_ushareit_listenit_cxa, cwc com_ushareit_listenit_cwc) {
        if (f9185b || com_ushareit_listenit_cxa.mo1639e() || com_ushareit_listenit_cxa.mo1635b()) {
            cyr.m13387a(!(com_ushareit_listenit_cxa instanceof cwy));
            cvd r = m12979r();
            r.f9188e = com_ushareit_listenit_cxa;
            r.f9189f = com_ushareit_listenit_cwc;
            return r;
        }
        throw new AssertionError();
    }

    public boolean m12983a() {
        return this.f9188e != null;
    }

    public cxa m12984b() {
        if (m12983a()) {
            return this.f9188e;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }

    public cwc m12985c() {
        if (m12983a()) {
            return this.f9189f != null ? this.f9189f : cwc.m13138a();
        } else {
            throw new IllegalArgumentException("Cannot get index start name if start has not been set");
        }
    }

    public boolean m12986d() {
        return this.f9190g != null;
    }

    public cxa m12987e() {
        if (m12986d()) {
            return this.f9190g;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cvd com_ushareit_listenit_cvd = (cvd) obj;
        return (this.f9186c == null ? com_ushareit_listenit_cvd.f9186c != null : !this.f9186c.equals(com_ushareit_listenit_cvd.f9186c)) ? false : (this.f9192i == null ? com_ushareit_listenit_cvd.f9192i != null : !this.f9192i.equals(com_ushareit_listenit_cvd.f9192i)) ? false : (this.f9191h == null ? com_ushareit_listenit_cvd.f9191h != null : !this.f9191h.equals(com_ushareit_listenit_cvd.f9191h)) ? false : (this.f9190g == null ? com_ushareit_listenit_cvd.f9190g != null : !this.f9190g.equals(com_ushareit_listenit_cvd.f9190g)) ? false : (this.f9189f == null ? com_ushareit_listenit_cvd.f9189f != null : !this.f9189f.equals(com_ushareit_listenit_cvd.f9189f)) ? false : (this.f9188e == null ? com_ushareit_listenit_cvd.f9188e != null : !this.f9188e.equals(com_ushareit_listenit_cvd.f9188e)) ? false : m12993k() == com_ushareit_listenit_cvd.m12993k();
    }

    public cwc m12988f() {
        if (m12986d()) {
            return this.f9191h != null ? this.f9191h : cwc.m13140b();
        } else {
            throw new IllegalArgumentException("Cannot get index end name if start has not been set");
        }
    }

    public boolean m12989g() {
        return this.f9186c != null;
    }

    public boolean m12990h() {
        return m12989g() && this.f9187d != null;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f9191h != null ? this.f9191h.hashCode() : 0) + (((this.f9190g != null ? this.f9190g.hashCode() : 0) + (((this.f9189f != null ? this.f9189f.hashCode() : 0) + (((this.f9188e != null ? this.f9188e.hashCode() : 0) + (((m12993k() ? 1231 : 1237) + ((this.f9186c != null ? this.f9186c.intValue() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f9192i != null) {
            i = this.f9192i.hashCode();
        }
        return hashCode + i;
    }

    public int m12991i() {
        if (m12989g()) {
            return this.f9186c.intValue();
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }

    public cws m12992j() {
        return this.f9192i;
    }

    public boolean m12993k() {
        return this.f9187d != null ? this.f9187d == cvf.LEFT : m12983a();
    }

    public Map<String, Object> m12994l() {
        Map<String, Object> hashMap = new HashMap();
        if (m12983a()) {
            hashMap.put("sp", this.f9188e.mo1643a());
            if (this.f9189f != null) {
                hashMap.put("sn", this.f9189f.m13144d());
            }
        }
        if (m12986d()) {
            hashMap.put("ep", this.f9190g.mo1643a());
            if (this.f9191h != null) {
                hashMap.put("en", this.f9191h.m13144d());
            }
        }
        if (this.f9186c != null) {
            hashMap.put("l", this.f9186c);
            cvf com_ushareit_listenit_cvf = this.f9187d;
            if (com_ushareit_listenit_cvf == null) {
                com_ushareit_listenit_cvf = m12983a() ? cvf.LEFT : cvf.RIGHT;
            }
            switch (cve.f9194a[com_ushareit_listenit_cvf.ordinal()]) {
                case 1:
                    hashMap.put("vf", "l");
                    break;
                case 2:
                    hashMap.put("vf", "r");
                    break;
            }
        }
        if (!this.f9192i.equals(cxf.m13282d())) {
            hashMap.put("i", this.f9192i.mo1661c());
        }
        return hashMap;
    }

    public boolean m12995m() {
        return (m12983a() || m12986d() || m12989g()) ? false : true;
    }

    public boolean m12996n() {
        return m12995m() && this.f9192i.equals(cxf.m13282d());
    }

    public boolean m12997o() {
        return (m12983a() && m12986d() && m12989g() && !m12990h()) ? false : true;
    }

    public String m12998p() {
        if (this.f9193j == null) {
            try {
                this.f9193j = cyg.m13366a(m12994l());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return this.f9193j;
    }

    public cvs m12999q() {
        return m12995m() ? new cvq(m12992j()) : m12989g() ? new cvr(this) : new cvu(this);
    }

    public String toString() {
        return m12994l().toString();
    }
}
