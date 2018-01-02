package com.ushareit.listenit;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class ddu extends dfx {
    private static final Writer f9631a = new ddv();
    private static final dbg f9632b = new dbg("closed");
    private final List<dba> f9633c = new ArrayList();
    private String f9634d;
    private dba f9635e = dbc.f9489a;

    public ddu() {
        super(f9631a);
    }

    private void m13943a(dba com_ushareit_listenit_dba) {
        if (this.f9634d != null) {
            if (!com_ushareit_listenit_dba.m13698k() || m13942i()) {
                ((dbd) m13944j()).m13714a(this.f9634d, com_ushareit_listenit_dba);
            }
            this.f9634d = null;
        } else if (this.f9633c.isEmpty()) {
            this.f9635e = com_ushareit_listenit_dba;
        } else {
            dba j = m13944j();
            if (j instanceof dax) {
                ((dax) j).m13705a(com_ushareit_listenit_dba);
                return;
            }
            throw new IllegalStateException();
        }
    }

    private dba m13944j() {
        return (dba) this.f9633c.get(this.f9633c.size() - 1);
    }

    public dba mo1729a() {
        if (this.f9633c.isEmpty()) {
            return this.f9635e;
        }
        String valueOf = String.valueOf(this.f9633c);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 34).append("Expected one JSON element but was ").append(valueOf).toString());
    }

    public dfx mo1730a(long j) {
        m13943a(new dbg(Long.valueOf(j)));
        return this;
    }

    public dfx mo1731a(Number number) {
        if (number == null) {
            return mo1740f();
        }
        if (!m13940g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                String valueOf = String.valueOf(number);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("JSON forbids NaN and infinities: ").append(valueOf).toString());
            }
        }
        m13943a(new dbg(number));
        return this;
    }

    public dfx mo1732a(String str) {
        if (this.f9633c.isEmpty() || this.f9634d != null) {
            throw new IllegalStateException();
        } else if (m13944j() instanceof dbd) {
            this.f9634d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public dfx mo1733a(boolean z) {
        m13943a(new dbg(Boolean.valueOf(z)));
        return this;
    }

    public dfx mo1734b() {
        dba com_ushareit_listenit_dax = new dax();
        m13943a(com_ushareit_listenit_dax);
        this.f9633c.add(com_ushareit_listenit_dax);
        return this;
    }

    public dfx mo1735b(String str) {
        if (str == null) {
            return mo1740f();
        }
        m13943a(new dbg(str));
        return this;
    }

    public dfx mo1736c() {
        if (this.f9633c.isEmpty() || this.f9634d != null) {
            throw new IllegalStateException();
        } else if (m13944j() instanceof dax) {
            this.f9633c.remove(this.f9633c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void close() {
        if (this.f9633c.isEmpty()) {
            this.f9633c.add(f9632b);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public dfx mo1738d() {
        dba com_ushareit_listenit_dbd = new dbd();
        m13943a(com_ushareit_listenit_dbd);
        this.f9633c.add(com_ushareit_listenit_dbd);
        return this;
    }

    public dfx mo1739e() {
        if (this.f9633c.isEmpty() || this.f9634d != null) {
            throw new IllegalStateException();
        } else if (m13944j() instanceof dbd) {
            this.f9633c.remove(this.f9633c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public dfx mo1740f() {
        m13943a(dbc.f9489a);
        return this;
    }

    public void flush() {
    }
}
