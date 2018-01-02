package com.ushareit.listenit;

import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.mobileads.resource.DrawableConstants.RadialCountdown;
import com.umeng.analytics.C0154a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class dfu implements Closeable {
    private static final char[] f9601a = ")]}'\n".toCharArray();
    private final Reader f9602b;
    private boolean f9603c = false;
    private final char[] f9604d = new char[1024];
    private int f9605e = 0;
    private int f9606f = 0;
    private int f9607g = 0;
    private int f9608h = 0;
    private int f9609i = 0;
    private long f9610j;
    private int f9611k;
    private String f9612l;
    private int[] f9613m = new int[32];
    private int f9614n = 0;
    private String[] f9615o;
    private int[] f9616p;

    static {
        dcq.f9549a = new dfv();
    }

    public dfu(Reader reader) {
        int[] iArr = this.f9613m;
        int i = this.f9614n;
        this.f9614n = i + 1;
        iArr[i] = 6;
        this.f9615o = new String[32];
        this.f9616p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f9602b = reader;
    }

    private void m13857A() {
        m13864b(true);
        this.f9605e--;
        if (this.f9605e + f9601a.length <= this.f9606f || m13867b(f9601a.length)) {
            int i = 0;
            while (i < f9601a.length) {
                if (this.f9604d[this.f9605e + i] == f9601a[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f9605e += f9601a.length;
        }
    }

    private void m13860a(int i) {
        if (this.f9614n == this.f9613m.length) {
            Object obj = new int[(this.f9614n * 2)];
            Object obj2 = new int[(this.f9614n * 2)];
            Object obj3 = new String[(this.f9614n * 2)];
            System.arraycopy(this.f9613m, 0, obj, 0, this.f9614n);
            System.arraycopy(this.f9616p, 0, obj2, 0, this.f9614n);
            System.arraycopy(this.f9615o, 0, obj3, 0, this.f9614n);
            this.f9613m = obj;
            this.f9616p = obj2;
            this.f9615o = obj3;
        }
        int[] iArr = this.f9613m;
        int i2 = this.f9614n;
        this.f9614n = i2 + 1;
        iArr[i2] = i;
    }

    private boolean m13861a(char c) {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case C0154a.f2957m /*32*/:
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                m13878x();
                break;
            default:
                return true;
        }
        return false;
    }

    private boolean m13862a(String str) {
        while (true) {
            if (this.f9605e + str.length() > this.f9606f && !m13867b(str.length())) {
                return false;
            }
            if (this.f9604d[this.f9605e] == '\n') {
                this.f9607g++;
                this.f9608h = this.f9605e + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.f9604d[this.f9605e + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.f9605e++;
        }
    }

    private int m13864b(boolean z) {
        char[] cArr = this.f9604d;
        int i = this.f9605e;
        int i2 = this.f9606f;
        while (true) {
            int v;
            if (i == i2) {
                this.f9605e = i;
                if (m13867b(1)) {
                    i = this.f9605e;
                    i2 = this.f9606f;
                } else if (!z) {
                    return -1;
                } else {
                    String valueOf = String.valueOf("End of input at line ");
                    v = m13876v();
                    throw new EOFException(new StringBuilder(String.valueOf(valueOf).length() + 30).append(valueOf).append(v).append(" column ").append(m13877w()).toString());
                }
            }
            v = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f9607g++;
                this.f9608h = v;
                i = v;
            } else if (c == ' ' || c == '\r') {
                i = v;
            } else if (c == '\t') {
                i = v;
            } else if (c == '/') {
                this.f9605e = v;
                if (v == i2) {
                    this.f9605e--;
                    boolean b = m13867b(2);
                    this.f9605e++;
                    if (!b) {
                        return c;
                    }
                }
                m13878x();
                switch (cArr[this.f9605e]) {
                    case '*':
                        this.f9605e++;
                        if (m13862a("*/")) {
                            i = this.f9605e + 2;
                            i2 = this.f9606f;
                            break;
                        }
                        throw m13865b("Unterminated comment");
                    case '/':
                        this.f9605e++;
                        m13879y();
                        i = this.f9605e;
                        i2 = this.f9606f;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.f9605e = v;
                m13878x();
                m13879y();
                i = this.f9605e;
                i2 = this.f9606f;
            } else {
                this.f9605e = v;
                return c;
            }
        }
    }

    private IOException m13865b(String str) {
        int v = m13876v();
        int w = m13877w();
        String q = m13897q();
        throw new dfy(new StringBuilder((String.valueOf(str).length() + 45) + String.valueOf(q).length()).append(str).append(" at line ").append(v).append(" column ").append(w).append(" path ").append(q).toString());
    }

    private String m13866b(char c) {
        char[] cArr = this.f9604d;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int i = this.f9605e;
            int i2 = this.f9606f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f9605e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                }
                if (c2 == '\\') {
                    this.f9605e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(m13880z());
                    i = this.f9605e;
                    i2 = this.f9606f;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.f9607g++;
                    this.f9608h = i4;
                }
                i3 = i4;
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.f9605e = i3;
        } while (m13867b(1));
        throw m13865b("Unterminated string");
    }

    private boolean m13867b(int i) {
        Object obj = this.f9604d;
        this.f9608h -= this.f9605e;
        if (this.f9606f != this.f9605e) {
            this.f9606f -= this.f9605e;
            System.arraycopy(obj, this.f9605e, obj, 0, this.f9606f);
        } else {
            this.f9606f = 0;
        }
        this.f9605e = 0;
        do {
            int read = this.f9602b.read(obj, this.f9606f, obj.length - this.f9606f);
            if (read == -1) {
                return false;
            }
            this.f9606f = read + this.f9606f;
            if (this.f9607g == 0 && this.f9608h == 0 && this.f9606f > 0 && obj[0] == '﻿') {
                this.f9605e++;
                this.f9608h++;
                i++;
            }
        } while (this.f9606f < i);
        return true;
    }

    private void m13869c(char c) {
        char[] cArr = this.f9604d;
        do {
            int i = this.f9605e;
            int i2 = this.f9606f;
            int i3 = i;
            while (i3 < i2) {
                i = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f9605e = i;
                    return;
                }
                if (c2 == '\\') {
                    this.f9605e = i;
                    m13880z();
                    i = this.f9605e;
                    i2 = this.f9606f;
                } else if (c2 == '\n') {
                    this.f9607g++;
                    this.f9608h = i;
                }
                i3 = i;
            }
            this.f9605e = i3;
        } while (m13867b(1));
        throw m13865b("Unterminated string");
    }

    private int mo1727o() {
        int b;
        int i = this.f9613m[this.f9614n - 1];
        if (i == 1) {
            this.f9613m[this.f9614n - 1] = 2;
        } else if (i == 2) {
            switch (m13864b(true)) {
                case 44:
                    break;
                case 59:
                    m13878x();
                    break;
                case 93:
                    this.f9609i = 4;
                    return 4;
                default:
                    throw m13865b("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.f9613m[this.f9614n - 1] = 4;
            if (i == 5) {
                switch (m13864b(true)) {
                    case 44:
                        break;
                    case 59:
                        m13878x();
                        break;
                    case 125:
                        this.f9609i = 2;
                        return 2;
                    default:
                        throw m13865b("Unterminated object");
                }
            }
            b = m13864b(true);
            switch (b) {
                case 34:
                    this.f9609i = 13;
                    return 13;
                case 39:
                    m13878x();
                    this.f9609i = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.f9609i = 2;
                        return 2;
                    }
                    throw m13865b("Expected name");
                default:
                    m13878x();
                    this.f9605e--;
                    if (m13861a((char) b)) {
                        this.f9609i = 14;
                        return 14;
                    }
                    throw m13865b("Expected name");
            }
        } else if (i == 4) {
            this.f9613m[this.f9614n - 1] = 5;
            switch (m13864b(true)) {
                case 58:
                    break;
                case 61:
                    m13878x();
                    if ((this.f9605e < this.f9606f || m13867b(1)) && this.f9604d[this.f9605e] == '>') {
                        this.f9605e++;
                        break;
                    }
                default:
                    throw m13865b("Expected ':'");
            }
        } else if (i == 6) {
            if (this.f9603c) {
                m13857A();
            }
            this.f9613m[this.f9614n - 1] = 7;
        } else if (i == 7) {
            if (m13864b(false) == -1) {
                this.f9609i = 17;
                return 17;
            }
            m13878x();
            this.f9605e--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (m13864b(true)) {
            case 34:
                if (this.f9614n == 1) {
                    m13878x();
                }
                this.f9609i = 9;
                return 9;
            case 39:
                m13878x();
                this.f9609i = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.f9609i = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.f9609i = 4;
                    return 4;
                }
                break;
            case 123:
                this.f9609i = 1;
                return 1;
            default:
                this.f9605e--;
                if (this.f9614n == 1) {
                    m13878x();
                }
                b = m13872r();
                if (b != 0) {
                    return b;
                }
                b = m13873s();
                if (b != 0) {
                    return b;
                }
                if (m13861a(this.f9604d[this.f9605e])) {
                    m13878x();
                    this.f9609i = 10;
                    return 10;
                }
                throw m13865b("Expected value");
        }
        if (i == 1 || i == 2) {
            m13878x();
            this.f9605e--;
            this.f9609i = 7;
            return 7;
        }
        throw m13865b("Unexpected value");
    }

    private int m13872r() {
        String str;
        int i;
        char c = this.f9604d[this.f9605e];
        String str2;
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            if (this.f9605e + i2 >= this.f9606f && !m13867b(i2 + 1)) {
                return 0;
            }
            char c2 = this.f9604d[this.f9605e + i2];
            if (c2 != str.charAt(i2) && c2 != r1.charAt(i2)) {
                return 0;
            }
            i2++;
        }
        if ((this.f9605e + length < this.f9606f || m13867b(length + 1)) && m13861a(this.f9604d[this.f9605e + length])) {
            return 0;
        }
        this.f9605e += length;
        this.f9609i = i;
        return i;
    }

    private int m13873s() {
        char[] cArr = this.f9604d;
        int i = this.f9605e;
        long j = 0;
        Object obj = null;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f9606f;
        int i6 = i;
        while (true) {
            Object obj2;
            if (i6 + i4 == i5) {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (m13867b(i4 + 1)) {
                    i6 = this.f9605e;
                    i5 = this.f9606f;
                } else if (i3 != 2 && i2 != 0 && (j != Long.MIN_VALUE || obj != null)) {
                    if (obj == null) {
                        j = -j;
                    }
                    this.f9610j = j;
                    this.f9605e += i4;
                    this.f9609i = 15;
                    return 15;
                } else if (i3 == 2 && i3 != 4 && i3 != 7) {
                    return 0;
                } else {
                    this.f9611k = i4;
                    this.f9609i = 16;
                    return 16;
                }
            }
            char c = cArr[i6 + i4];
            int i7;
            switch (c) {
                case '+':
                    if (i3 != 5) {
                        return 0;
                    }
                    i = 6;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case RadialCountdown.SIDE_LENGTH_DIPS /*45*/:
                    if (i3 == 0) {
                        i = 1;
                        i7 = i2;
                        obj2 = 1;
                        i3 = i7;
                        continue;
                    } else if (i3 == 5) {
                        i = 6;
                        i3 = i2;
                        obj2 = obj;
                        break;
                    } else {
                        return 0;
                    }
                case CloseButton.WIDGET_HEIGHT_DIPS /*46*/:
                    if (i3 != 2) {
                        return 0;
                    }
                    i = 3;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case 'E':
                case 'e':
                    if (i3 != 2 && i3 != 4) {
                        return 0;
                    }
                    i = 5;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i3 != 1 && i3 != 0) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5 && i3 != 6) {
                                        i = i3;
                                        i3 = i2;
                                        obj2 = obj;
                                        break;
                                    }
                                    i = 7;
                                    i3 = i2;
                                    obj2 = obj;
                                    break;
                                }
                                i = 4;
                                i3 = i2;
                                obj2 = obj;
                                break;
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - 48));
                                i = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) ? 1 : 0;
                                i &= i2;
                                obj2 = obj;
                                j = j2;
                                i7 = i3;
                                i3 = i;
                                i = i7;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = 2;
                        i3 = i2;
                        obj2 = obj;
                        continue;
                    } else if (m13861a(c)) {
                        return 0;
                    }
                    break;
            }
            if (i3 != 2) {
            }
            if (i3 == 2) {
            }
            this.f9611k = i4;
            this.f9609i = 16;
            return 16;
            i4++;
            obj = obj2;
            i2 = i3;
            i3 = i;
        }
    }

    private String m13874t() {
        StringBuilder stringBuilder = null;
        int i = 0;
        while (true) {
            String str;
            if (this.f9605e + i < this.f9606f) {
                switch (this.f9604d[this.f9605e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case C0154a.f2957m /*32*/:
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m13878x();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.f9604d.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.f9604d, this.f9605e, i);
                this.f9605e = i + this.f9605e;
                i = !m13867b(1) ? 0 : 0;
            } else if (m13867b(i + 1)) {
            }
            if (stringBuilder == null) {
                str = new String(this.f9604d, this.f9605e, i);
            } else {
                stringBuilder.append(this.f9604d, this.f9605e, i);
                str = stringBuilder.toString();
            }
            this.f9605e = i + this.f9605e;
            return str;
        }
    }

    private void m13875u() {
        do {
            int i = 0;
            while (this.f9605e + i < this.f9606f) {
                switch (this.f9604d[this.f9605e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case C0154a.f2957m /*32*/:
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m13878x();
                        break;
                    default:
                        i++;
                }
                this.f9605e = i + this.f9605e;
                return;
            }
            this.f9605e = i + this.f9605e;
        } while (m13867b(1));
    }

    private int m13876v() {
        return this.f9607g + 1;
    }

    private int m13877w() {
        return (this.f9605e - this.f9608h) + 1;
    }

    private void m13878x() {
        if (!this.f9603c) {
            throw m13865b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void m13879y() {
        char c;
        do {
            if (this.f9605e < this.f9606f || m13867b(1)) {
                char[] cArr = this.f9604d;
                int i = this.f9605e;
                this.f9605e = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.f9607g++;
                    this.f9608h = this.f9605e;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private char m13880z() {
        if (this.f9605e != this.f9606f || m13867b(1)) {
            char[] cArr = this.f9604d;
            int i = this.f9605e;
            this.f9605e = i + 1;
            char c = cArr[i];
            switch (c) {
                case '\n':
                    this.f9607g++;
                    this.f9608h = this.f9605e;
                    return c;
                case 'b':
                    return '\b';
                case 'f':
                    return '\f';
                case 'n':
                    return '\n';
                case 'r':
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.f9605e + 4 <= this.f9606f || m13867b(4)) {
                        int i2 = this.f9605e;
                        int i3 = i2 + 4;
                        int i4 = i2;
                        c = '\u0000';
                        for (i = i4; i < i3; i++) {
                            char c2 = this.f9604d[i];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                c = (char) (c + ((c2 - 97) + 10));
                            } else if (c2 < 'A' || c2 > 'F') {
                                String str = "\\u";
                                String valueOf = String.valueOf(new String(this.f9604d, this.f9605e, 4));
                                throw new NumberFormatException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                            } else {
                                c = (char) (c + ((c2 - 65) + 10));
                            }
                        }
                        this.f9605e += 4;
                        return c;
                    }
                    throw m13865b("Unterminated escape sequence");
                default:
                    return c;
            }
        }
        throw m13865b("Unterminated escape sequence");
    }

    public void mo1712a() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        if (i == 3) {
            m13860a(1);
            this.f9616p[this.f9614n - 1] = 0;
            this.f9609i = 0;
            return;
        }
        String valueOf = String.valueOf(mo1718f());
        int v = m13876v();
        int w = m13877w();
        String q = m13897q();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 74) + String.valueOf(q).length()).append("Expected BEGIN_ARRAY but was ").append(valueOf).append(" at line ").append(v).append(" column ").append(w).append(" path ").append(q).toString());
    }

    public final void m13882a(boolean z) {
        this.f9603c = z;
    }

    public void mo1713b() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        if (i == 4) {
            this.f9614n--;
            int[] iArr = this.f9616p;
            int i2 = this.f9614n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f9609i = 0;
            return;
        }
        String valueOf = String.valueOf(mo1718f());
        int v = m13876v();
        int w = m13877w();
        String q = m13897q();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 72) + String.valueOf(q).length()).append("Expected END_ARRAY but was ").append(valueOf).append(" at line ").append(v).append(" column ").append(w).append(" path ").append(q).toString());
    }

    public void mo1714c() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        if (i == 1) {
            m13860a(3);
            this.f9609i = 0;
            return;
        }
        String valueOf = String.valueOf(mo1718f());
        int v = m13876v();
        int w = m13877w();
        String q = m13897q();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 75) + String.valueOf(q).length()).append("Expected BEGIN_OBJECT but was ").append(valueOf).append(" at line ").append(v).append(" column ").append(w).append(" path ").append(q).toString());
    }

    public void close() {
        this.f9609i = 0;
        this.f9613m[0] = 8;
        this.f9614n = 1;
        this.f9602b.close();
    }

    public void mo1716d() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        if (i == 2) {
            this.f9614n--;
            this.f9615o[this.f9614n] = null;
            int[] iArr = this.f9616p;
            int i2 = this.f9614n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f9609i = 0;
            return;
        }
        String valueOf = String.valueOf(mo1718f());
        int v = m13876v();
        int w = m13877w();
        String q = m13897q();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 73) + String.valueOf(q).length()).append("Expected END_OBJECT but was ").append(valueOf).append(" at line ").append(v).append(" column ").append(w).append(" path ").append(q).toString());
    }

    public boolean mo1717e() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public dfw mo1718f() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        switch (i) {
            case 1:
                return dfw.BEGIN_OBJECT;
            case 2:
                return dfw.END_OBJECT;
            case 3:
                return dfw.BEGIN_ARRAY;
            case 4:
                return dfw.END_ARRAY;
            case 5:
            case 6:
                return dfw.BOOLEAN;
            case 7:
                return dfw.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return dfw.STRING;
            case 12:
            case 13:
            case 14:
                return dfw.NAME;
            case C0349R.styleable.DragSortListView_drag_handle_id /*15*/:
            case 16:
                return dfw.NUMBER;
            case C0349R.styleable.DragSortListView_click_remove_id /*17*/:
                return dfw.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String mo1719g() {
        String t;
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        if (i == 14) {
            t = m13874t();
        } else if (i == 12) {
            t = m13866b('\'');
        } else if (i == 13) {
            t = m13866b('\"');
        } else {
            String valueOf = String.valueOf(mo1718f());
            int v = m13876v();
            int w = m13877w();
            String q = m13897q();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(q).length()).append("Expected a name but was ").append(valueOf).append(" at line ").append(v).append(" column ").append(w).append(" path ").append(q).toString());
        }
        this.f9609i = 0;
        this.f9615o[this.f9614n - 1] = t;
        return t;
    }

    public String mo1720h() {
        String t;
        int v;
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        if (i == 10) {
            t = m13874t();
        } else if (i == 8) {
            t = m13866b('\'');
        } else if (i == 9) {
            t = m13866b('\"');
        } else if (i == 11) {
            t = this.f9612l;
            this.f9612l = null;
        } else if (i == 15) {
            t = Long.toString(this.f9610j);
        } else if (i == 16) {
            t = new String(this.f9604d, this.f9605e, this.f9611k);
            this.f9605e += this.f9611k;
        } else {
            String valueOf = String.valueOf(mo1718f());
            v = m13876v();
            int w = m13877w();
            String q = m13897q();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 71) + String.valueOf(q).length()).append("Expected a string but was ").append(valueOf).append(" at line ").append(v).append(" column ").append(w).append(" path ").append(q).toString());
        }
        this.f9609i = 0;
        int[] iArr = this.f9616p;
        v = this.f9614n - 1;
        iArr[v] = iArr[v] + 1;
        return t;
    }

    public boolean mo1721i() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        if (i == 5) {
            this.f9609i = 0;
            int[] iArr = this.f9616p;
            i = this.f9614n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        } else if (i == 6) {
            this.f9609i = 0;
            int[] iArr2 = this.f9616p;
            r2 = this.f9614n - 1;
            iArr2[r2] = iArr2[r2] + 1;
            return false;
        } else {
            String valueOf = String.valueOf(mo1718f());
            r2 = m13876v();
            int w = m13877w();
            String q = m13897q();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 72) + String.valueOf(q).length()).append("Expected a boolean but was ").append(valueOf).append(" at line ").append(r2).append(" column ").append(w).append(" path ").append(q).toString());
        }
    }

    public void mo1722j() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        if (i == 7) {
            this.f9609i = 0;
            int[] iArr = this.f9616p;
            int i2 = this.f9614n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String valueOf = String.valueOf(mo1718f());
        int v = m13876v();
        int w = m13877w();
        String q = m13897q();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 67) + String.valueOf(q).length()).append("Expected null but was ").append(valueOf).append(" at line ").append(v).append(" column ").append(w).append(" path ").append(q).toString());
    }

    public double mo1723k() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        if (i == 15) {
            this.f9609i = 0;
            int[] iArr = this.f9616p;
            int i2 = this.f9614n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f9610j;
        }
        if (i == 16) {
            this.f9612l = new String(this.f9604d, this.f9605e, this.f9611k);
            this.f9605e += this.f9611k;
        } else if (i == 8 || i == 9) {
            this.f9612l = m13866b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f9612l = m13874t();
        } else if (i != 11) {
            String valueOf = String.valueOf(mo1718f());
            int v = m13876v();
            int w = m13877w();
            String q = m13897q();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 71) + String.valueOf(q).length()).append("Expected a double but was ").append(valueOf).append(" at line ").append(v).append(" column ").append(w).append(" path ").append(q).toString());
        }
        this.f9609i = 11;
        double parseDouble = Double.parseDouble(this.f9612l);
        if (this.f9603c || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.f9612l = null;
            this.f9609i = 0;
            int[] iArr2 = this.f9616p;
            w = this.f9614n - 1;
            iArr2[w] = iArr2[w] + 1;
            return parseDouble;
        }
        w = m13876v();
        int w2 = m13877w();
        String q2 = m13897q();
        throw new dfy(new StringBuilder(String.valueOf(q2).length() + 102).append("JSON forbids NaN and infinities: ").append(parseDouble).append(" at line ").append(w).append(" column ").append(w2).append(" path ").append(q2).toString());
    }

    public long mo1724l() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        if (i == 15) {
            this.f9609i = 0;
            int[] iArr = this.f9616p;
            int i2 = this.f9614n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f9610j;
        }
        long parseLong;
        int i3;
        if (i == 16) {
            this.f9612l = new String(this.f9604d, this.f9605e, this.f9611k);
            this.f9605e += this.f9611k;
        } else if (i == 8 || i == 9) {
            this.f9612l = m13866b(i == 8 ? '\'' : '\"');
            try {
                parseLong = Long.parseLong(this.f9612l);
                this.f9609i = 0;
                int[] iArr2 = this.f9616p;
                i3 = this.f9614n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(mo1718f());
            int v = m13876v();
            i3 = m13877w();
            String q = m13897q();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(q).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(v).append(" column ").append(i3).append(" path ").append(q).toString());
        }
        this.f9609i = 11;
        double parseDouble = Double.parseDouble(this.f9612l);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            valueOf = this.f9612l;
            v = m13876v();
            i3 = m13877w();
            q = m13897q();
            throw new NumberFormatException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(q).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(v).append(" column ").append(i3).append(" path ").append(q).toString());
        }
        this.f9612l = null;
        this.f9609i = 0;
        iArr2 = this.f9616p;
        i3 = this.f9614n - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseLong;
    }

    public int mo1725m() {
        int i = this.f9609i;
        if (i == 0) {
            i = mo1727o();
        }
        int[] iArr;
        int i2;
        if (i == 15) {
            i = (int) this.f9610j;
            if (this.f9610j != ((long) i)) {
                long j = this.f9610j;
                int v = m13876v();
                int w = m13877w();
                String q = m13897q();
                throw new NumberFormatException(new StringBuilder(String.valueOf(q).length() + 89).append("Expected an int but was ").append(j).append(" at line ").append(v).append(" column ").append(w).append(" path ").append(q).toString());
            }
            this.f9609i = 0;
            iArr = this.f9616p;
            i2 = this.f9614n - 1;
            iArr[i2] = iArr[i2] + 1;
        } else {
            String valueOf;
            int w2;
            String q2;
            if (i == 16) {
                this.f9612l = new String(this.f9604d, this.f9605e, this.f9611k);
                this.f9605e += this.f9611k;
            } else if (i == 8 || i == 9) {
                this.f9612l = m13866b(i == 8 ? '\'' : '\"');
                try {
                    i = Integer.parseInt(this.f9612l);
                    this.f9609i = 0;
                    iArr = this.f9616p;
                    i2 = this.f9614n - 1;
                    iArr[i2] = iArr[i2] + 1;
                } catch (NumberFormatException e) {
                }
            } else {
                valueOf = String.valueOf(mo1718f());
                i2 = m13876v();
                w2 = m13877w();
                q2 = m13897q();
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(q2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(i2).append(" column ").append(w2).append(" path ").append(q2).toString());
            }
            this.f9609i = 11;
            double parseDouble = Double.parseDouble(this.f9612l);
            i = (int) parseDouble;
            if (((double) i) != parseDouble) {
                valueOf = this.f9612l;
                i2 = m13876v();
                w2 = m13877w();
                q2 = m13897q();
                throw new NumberFormatException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(q2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(i2).append(" column ").append(w2).append(" path ").append(q2).toString());
            }
            this.f9612l = null;
            this.f9609i = 0;
            iArr = this.f9616p;
            i2 = this.f9614n - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return i;
    }

    public void mo1726n() {
        int i = 0;
        do {
            int i2 = this.f9609i;
            if (i2 == 0) {
                i2 = mo1727o();
            }
            if (i2 == 3) {
                m13860a(1);
                i++;
            } else if (i2 == 1) {
                m13860a(3);
                i++;
            } else if (i2 == 4) {
                this.f9614n--;
                i--;
            } else if (i2 == 2) {
                this.f9614n--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                m13875u();
            } else if (i2 == 8 || i2 == 12) {
                m13869c('\'');
            } else if (i2 == 9 || i2 == 13) {
                m13869c('\"');
            } else if (i2 == 16) {
                this.f9605e += this.f9611k;
            }
            this.f9609i = 0;
        } while (i != 0);
        int[] iArr = this.f9616p;
        int i3 = this.f9614n - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f9615o[this.f9614n - 1] = "null";
    }

    public final boolean m13896p() {
        return this.f9603c;
    }

    public String m13897q() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.f9614n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f9613m[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.f9616p[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.f9615o[i2] == null) {
                        break;
                    }
                    append.append(this.f9615o[i2]);
                    break;
                default:
                    break;
            }
        }
        return append.toString();
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        int v = m13876v();
        return new StringBuilder(String.valueOf(valueOf).length() + 39).append(valueOf).append(" at line ").append(v).append(" column ").append(m13877w()).toString();
    }
}
