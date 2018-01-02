package com.ushareit.listenit;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class dfx implements Closeable, Flushable {
    private static final String[] f9620a = new String[128];
    private static final String[] f9621b = ((String[]) f9620a.clone());
    private final Writer f9622c;
    private int[] f9623d = new int[32];
    private int f9624e = 0;
    private String f9625f;
    private String f9626g;
    private boolean f9627h;
    private boolean f9628i;
    private String f9629j;
    private boolean f9630k;

    static {
        for (int i = 0; i <= 31; i++) {
            f9620a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f9620a[34] = "\\\"";
        f9620a[92] = "\\\\";
        f9620a[9] = "\\t";
        f9620a[8] = "\\b";
        f9620a[10] = "\\n";
        f9620a[13] = "\\r";
        f9620a[12] = "\\f";
        f9621b[60] = "\\u003c";
        f9621b[62] = "\\u003e";
        f9621b[38] = "\\u0026";
        f9621b[61] = "\\u003d";
        f9621b[39] = "\\u0027";
    }

    public dfx(Writer writer) {
        m13919a(6);
        this.f9626g = ":";
        this.f9630k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f9622c = writer;
    }

    private int mo1729a() {
        if (this.f9624e != 0) {
            return this.f9623d[this.f9624e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private dfx m13917a(int i, int i2, String str) {
        int a = mo1729a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f9629j != null) {
            String str2 = "Dangling name: ";
            String valueOf = String.valueOf(this.f9629j);
            throw new IllegalStateException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            this.f9624e--;
            if (a == i2) {
                m13924k();
            }
            this.f9622c.write(str);
            return this;
        }
    }

    private dfx m13918a(int i, String str) {
        m13922e(true);
        m13919a(i);
        this.f9622c.write(str);
        return this;
    }

    private void m13919a(int i) {
        if (this.f9624e == this.f9623d.length) {
            Object obj = new int[(this.f9624e * 2)];
            System.arraycopy(this.f9623d, 0, obj, 0, this.f9624e);
            this.f9623d = obj;
        }
        int[] iArr = this.f9623d;
        int i2 = this.f9624e;
        this.f9624e = i2 + 1;
        iArr[i2] = i;
    }

    private void m13920b(int i) {
        this.f9623d[this.f9624e - 1] = i;
    }

    private void m13921d(String str) {
        int i = 0;
        String[] strArr = this.f9628i ? f9621b : f9620a;
        this.f9622c.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            String str2;
            if (charAt < '') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i < i2) {
                    this.f9622c.write(str, i, i2 - i);
                }
                this.f9622c.write(str2);
                i = i2 + 1;
            } else {
                if (charAt == ' ') {
                    str2 = "\\u2028";
                } else if (charAt == ' ') {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.f9622c.write(str, i, i2 - i);
                }
                this.f9622c.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.f9622c.write(str, i, length - i);
        }
        this.f9622c.write("\"");
    }

    private void m13922e(boolean z) {
        switch (mo1729a()) {
            case 1:
                m13920b(2);
                m13924k();
                return;
            case 2:
                this.f9622c.append(',');
                m13924k();
                return;
            case 4:
                this.f9622c.append(this.f9626g);
                m13920b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f9627h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.f9627h || z) {
            m13920b(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }

    private void m13923j() {
        if (this.f9629j != null) {
            m13925l();
            m13921d(this.f9629j);
            this.f9629j = null;
        }
    }

    private void m13924k() {
        if (this.f9625f != null) {
            this.f9622c.write("\n");
            int i = this.f9624e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f9622c.write(this.f9625f);
            }
        }
    }

    private void m13925l() {
        int a = mo1729a();
        if (a == 5) {
            this.f9622c.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m13924k();
        m13920b(4);
    }

    public dfx mo1730a(long j) {
        m13923j();
        m13922e(false);
        this.f9622c.write(Long.toString(j));
        return this;
    }

    public dfx mo1731a(Number number) {
        if (number == null) {
            return mo1740f();
        }
        m13923j();
        CharSequence obj = number.toString();
        if (this.f9627h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            m13922e(false);
            this.f9622c.append(obj);
            return this;
        }
        String valueOf = String.valueOf(number);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 39).append("Numeric values must be finite, but was ").append(valueOf).toString());
    }

    public dfx mo1732a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f9629j != null) {
            throw new IllegalStateException();
        } else if (this.f9624e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f9629j = str;
            return this;
        }
    }

    public dfx mo1733a(boolean z) {
        m13923j();
        m13922e(false);
        this.f9622c.write(z ? "true" : "false");
        return this;
    }

    public dfx mo1734b() {
        m13923j();
        return m13918a(1, "[");
    }

    public dfx mo1735b(String str) {
        if (str == null) {
            return mo1740f();
        }
        m13923j();
        m13922e(false);
        m13921d(str);
        return this;
    }

    public final void m13932b(boolean z) {
        this.f9627h = z;
    }

    public dfx mo1736c() {
        return m13917a(1, 2, "]");
    }

    public final void m13934c(String str) {
        if (str.length() == 0) {
            this.f9625f = null;
            this.f9626g = ":";
            return;
        }
        this.f9625f = str;
        this.f9626g = ": ";
    }

    public final void m13935c(boolean z) {
        this.f9628i = z;
    }

    public void close() {
        this.f9622c.close();
        int i = this.f9624e;
        if (i > 1 || (i == 1 && this.f9623d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f9624e = 0;
    }

    public dfx mo1738d() {
        m13923j();
        return m13918a(3, "{");
    }

    public final void m13937d(boolean z) {
        this.f9630k = z;
    }

    public dfx mo1739e() {
        return m13917a(3, 5, "}");
    }

    public dfx mo1740f() {
        if (this.f9629j != null) {
            if (this.f9630k) {
                m13923j();
            } else {
                this.f9629j = null;
                return this;
            }
        }
        m13922e(false);
        this.f9622c.write("null");
        return this;
    }

    public void flush() {
        if (this.f9624e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f9622c.flush();
    }

    public boolean m13940g() {
        return this.f9627h;
    }

    public final boolean m13941h() {
        return this.f9628i;
    }

    public final boolean m13942i() {
        return this.f9630k;
    }
}
