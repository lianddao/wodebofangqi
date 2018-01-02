package com.ushareit.listenit;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class dba {
    public Number mo1702b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String mo1703c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double mo1704d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long mo1705e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int mo1706f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean mo1707g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean m13695h() {
        return this instanceof dax;
    }

    public boolean m13696i() {
        return this instanceof dbd;
    }

    public boolean m13697j() {
        return this instanceof dbg;
    }

    public boolean m13698k() {
        return this instanceof dbc;
    }

    public dbd m13699l() {
        if (m13696i()) {
            return (dbd) this;
        }
        String valueOf = String.valueOf(this);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Not a JSON Object: ").append(valueOf).toString());
    }

    public dax m13700m() {
        if (m13695h()) {
            return (dax) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public dbg m13701n() {
        if (m13697j()) {
            return (dbg) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    Boolean mo1708o() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            dfx com_ushareit_listenit_dfx = new dfx(stringWriter);
            com_ushareit_listenit_dfx.m13932b(true);
            ddc.m13833a(this, com_ushareit_listenit_dfx);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
