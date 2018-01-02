package com.ushareit.listenit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

public class hjz implements hjm {
    private final String f15557a;
    private volatile hjm f15558b;
    private Boolean f15559c;
    private Method f15560d;
    private hjp f15561e;
    private Queue<hjs> f15562f;
    private final boolean f15563g;

    public hjz(String str, Queue<hjs> queue, boolean z) {
        this.f15557a = str;
        this.f15562f = queue;
        this.f15563g = z;
    }

    public String m24003a() {
        return this.f15557a;
    }

    public void mo2789a(String str) {
        m24010b().mo2789a(str);
    }

    public void mo2793b(String str) {
        m24010b().mo2793b(str);
    }

    public void mo2794c(String str) {
        m24010b().mo2794c(str);
    }

    public void mo2790a(String str, Object obj) {
        m24010b().mo2790a(str, obj);
    }

    public void mo2791a(String str, Object obj, Object obj2) {
        m24010b().mo2791a(str, obj, obj2);
    }

    public void mo2795d(String str) {
        m24010b().mo2795d(str);
    }

    public void mo2792a(String str, Throwable th) {
        m24010b().mo2792a(str, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.f15557a.equals(((hjz) obj).f15557a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f15557a.hashCode();
    }

    hjm m24010b() {
        if (this.f15558b != null) {
            return this.f15558b;
        }
        if (this.f15563g) {
            return hjw.f15556a;
        }
        return m24002f();
    }

    private hjm m24002f() {
        if (this.f15561e == null) {
            this.f15561e = new hjp(this, this.f15562f);
        }
        return this.f15561e;
    }

    public void m24004a(hjm com_ushareit_listenit_hjm) {
        this.f15558b = com_ushareit_listenit_hjm;
    }

    public boolean m24013c() {
        if (this.f15559c != null) {
            return this.f15559c.booleanValue();
        }
        try {
            this.f15560d = this.f15558b.getClass().getMethod("log", new Class[]{hjr.class});
            this.f15559c = Boolean.TRUE;
        } catch (NoSuchMethodException e) {
            this.f15559c = Boolean.FALSE;
        }
        return this.f15559c.booleanValue();
    }

    public void m24005a(hjr com_ushareit_listenit_hjr) {
        if (m24013c()) {
            try {
                this.f15560d.invoke(this.f15558b, new Object[]{com_ushareit_listenit_hjr});
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
    }

    public boolean m24015d() {
        return this.f15558b == null;
    }

    public boolean m24016e() {
        return this.f15558b instanceof hjw;
    }
}
