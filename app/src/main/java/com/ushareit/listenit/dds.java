package com.ushareit.listenit;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class dds extends dfu {
    private static final Reader f9617a = new ddt();
    private static final Object f9618b = new Object();
    private final List<Object> f9619c = new ArrayList();

    public dds(dba com_ushareit_listenit_dba) {
        super(f9617a);
        this.f9619c.add(com_ushareit_listenit_dba);
    }

    private void m13898a(dfw com_ushareit_listenit_dfw) {
        if (mo1718f() != com_ushareit_listenit_dfw) {
            String valueOf = String.valueOf(com_ushareit_listenit_dfw);
            String valueOf2 = String.valueOf(mo1718f());
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
        }
    }

    private Object m13899r() {
        return this.f9619c.get(this.f9619c.size() - 1);
    }

    private Object m13900s() {
        return this.f9619c.remove(this.f9619c.size() - 1);
    }

    public void mo1712a() {
        m13898a(dfw.BEGIN_ARRAY);
        this.f9619c.add(((dax) m13899r()).iterator());
    }

    public void mo1713b() {
        m13898a(dfw.END_ARRAY);
        m13900s();
        m13900s();
    }

    public void mo1714c() {
        m13898a(dfw.BEGIN_OBJECT);
        this.f9619c.add(((dbd) m13899r()).m13713a().iterator());
    }

    public void close() {
        this.f9619c.clear();
        this.f9619c.add(f9618b);
    }

    public void mo1716d() {
        m13898a(dfw.END_OBJECT);
        m13900s();
        m13900s();
    }

    public boolean mo1717e() {
        dfw f = mo1718f();
        return (f == dfw.END_OBJECT || f == dfw.END_ARRAY) ? false : true;
    }

    public dfw mo1718f() {
        if (this.f9619c.isEmpty()) {
            return dfw.END_DOCUMENT;
        }
        Object r = m13899r();
        if (r instanceof Iterator) {
            boolean z = this.f9619c.get(this.f9619c.size() - 2) instanceof dbd;
            Iterator it = (Iterator) r;
            if (!it.hasNext()) {
                return z ? dfw.END_OBJECT : dfw.END_ARRAY;
            } else {
                if (z) {
                    return dfw.NAME;
                }
                this.f9619c.add(it.next());
                return mo1718f();
            }
        } else if (r instanceof dbd) {
            return dfw.BEGIN_OBJECT;
        } else {
            if (r instanceof dax) {
                return dfw.BEGIN_ARRAY;
            }
            if (r instanceof dbg) {
                dbg com_ushareit_listenit_dbg = (dbg) r;
                if (com_ushareit_listenit_dbg.m13735q()) {
                    return dfw.STRING;
                }
                if (com_ushareit_listenit_dbg.m13726a()) {
                    return dfw.BOOLEAN;
                }
                if (com_ushareit_listenit_dbg.m13734p()) {
                    return dfw.NUMBER;
                }
                throw new AssertionError();
            } else if (r instanceof dbc) {
                return dfw.NULL;
            } else {
                if (r == f9618b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public String mo1719g() {
        m13898a(dfw.NAME);
        Entry entry = (Entry) ((Iterator) m13899r()).next();
        this.f9619c.add(entry.getValue());
        return (String) entry.getKey();
    }

    public String mo1720h() {
        dfw f = mo1718f();
        if (f == dfw.STRING || f == dfw.NUMBER) {
            return ((dbg) m13900s()).mo1703c();
        }
        String valueOf = String.valueOf(dfw.STRING);
        String valueOf2 = String.valueOf(f);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public boolean mo1721i() {
        m13898a(dfw.BOOLEAN);
        return ((dbg) m13900s()).mo1707g();
    }

    public void mo1722j() {
        m13898a(dfw.NULL);
        m13900s();
    }

    public double mo1723k() {
        dfw f = mo1718f();
        if (f == dfw.NUMBER || f == dfw.STRING) {
            double d = ((dbg) m13899r()).mo1704d();
            if (m13896p() || !(Double.isNaN(d) || Double.isInfinite(d))) {
                m13900s();
                return d;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + d);
        }
        String valueOf = String.valueOf(dfw.NUMBER);
        String valueOf2 = String.valueOf(f);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public long mo1724l() {
        dfw f = mo1718f();
        if (f == dfw.NUMBER || f == dfw.STRING) {
            long e = ((dbg) m13899r()).mo1705e();
            m13900s();
            return e;
        }
        String valueOf = String.valueOf(dfw.NUMBER);
        String valueOf2 = String.valueOf(f);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public int mo1725m() {
        dfw f = mo1718f();
        if (f == dfw.NUMBER || f == dfw.STRING) {
            int f2 = ((dbg) m13899r()).mo1706f();
            m13900s();
            return f2;
        }
        String valueOf = String.valueOf(dfw.NUMBER);
        String valueOf2 = String.valueOf(f);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public void mo1726n() {
        if (mo1718f() == dfw.NAME) {
            mo1719g();
        } else {
            m13900s();
        }
    }

    public void mo1727o() {
        m13898a(dfw.NAME);
        Entry entry = (Entry) ((Iterator) m13899r()).next();
        this.f9619c.add(entry.getValue());
        this.f9619c.add(new dbg((String) entry.getKey()));
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
