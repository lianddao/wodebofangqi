package com.ushareit.listenit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class cvy {
    private final cvz f9235a;
    private final String f9236b;
    private final String f9237c;

    public cvy(cvz com_ushareit_listenit_cvz, String str) {
        this(com_ushareit_listenit_cvz, str, null);
    }

    public cvy(cvz com_ushareit_listenit_cvz, String str, String str2) {
        this.f9235a = com_ushareit_listenit_cvz;
        this.f9236b = str;
        this.f9237c = str2;
    }

    private static String m13087a(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private long m13088b() {
        return System.currentTimeMillis();
    }

    private String m13089b(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (this.f9237c == null) {
            return str;
        }
        String str2 = this.f9237c;
        return new StringBuilder((String.valueOf(str2).length() + 3) + String.valueOf(str).length()).append(str2).append(" - ").append(str).toString();
    }

    public void m13090a(String str) {
        m13096b(str, null);
    }

    public void m13091a(String str, Throwable th) {
        String valueOf = String.valueOf(m13089b(str, new Object[0]));
        String valueOf2 = String.valueOf(m13087a(th));
        this.f9235a.mo1623b(cwa.ERROR, this.f9236b, new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("\n").append(valueOf2).toString(), m13088b());
    }

    public void m13092a(String str, Throwable th, Object... objArr) {
        if (m13094a()) {
            String b = m13089b(str, objArr);
            if (th != null) {
                String valueOf = String.valueOf(m13087a(th));
                b = new StringBuilder((String.valueOf(b).length() + 1) + String.valueOf(valueOf).length()).append(b).append("\n").append(valueOf).toString();
            }
            this.f9235a.mo1623b(cwa.DEBUG, this.f9236b, b, m13088b());
        }
    }

    public void m13093a(String str, Object... objArr) {
        m13092a(str, null, objArr);
    }

    public boolean m13094a() {
        return this.f9235a.mo1622a().ordinal() <= cwa.DEBUG.ordinal();
    }

    public void m13095b(String str) {
        this.f9235a.mo1623b(cwa.INFO, this.f9236b, m13089b(str, new Object[0]), m13088b());
    }

    public void m13096b(String str, Throwable th) {
        String b = m13089b(str, new Object[0]);
        if (th != null) {
            String valueOf = String.valueOf(m13087a(th));
            b = new StringBuilder((String.valueOf(b).length() + 1) + String.valueOf(valueOf).length()).append(b).append("\n").append(valueOf).toString();
        }
        this.f9235a.mo1623b(cwa.WARN, this.f9236b, b, m13088b());
    }
}
