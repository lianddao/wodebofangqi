package com.ushareit.listenit;

import android.text.TextUtils;
import com.umeng.analytics.C0154a;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class bpn {
    private static final Pattern f7328a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final bss f7329b = new bss();
    private final StringBuilder f7330c = new StringBuilder();

    public bpq m9410a(bss com_ushareit_listenit_bss) {
        this.f7330c.setLength(0);
        int d = com_ushareit_listenit_bss.m9708d();
        m9405c(com_ushareit_listenit_bss);
        this.f7329b.m9702a(com_ushareit_listenit_bss.f7639a, com_ushareit_listenit_bss.m9708d());
        this.f7329b.m9707c(d);
        String b = m9402b(this.f7329b, this.f7330c);
        if (b == null || !"{".equals(m9399a(this.f7329b, this.f7330c))) {
            return null;
        }
        bpq com_ushareit_listenit_bpq = new bpq();
        m9400a(com_ushareit_listenit_bpq, b);
        int i = 0;
        Object obj = null;
        while (i == 0) {
            int d2 = this.f7329b.m9708d();
            obj = m9399a(this.f7329b, this.f7330c);
            if (obj == null || "}".equals(obj)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                this.f7329b.m9707c(d2);
                m9401a(this.f7329b, com_ushareit_listenit_bpq, this.f7330c);
            }
        }
        return !"}".equals(obj) ? null : com_ushareit_listenit_bpq;
    }

    private static String m9402b(bss com_ushareit_listenit_bss, StringBuilder stringBuilder) {
        m9403b(com_ushareit_listenit_bss);
        if (com_ushareit_listenit_bss.m9704b() < 5) {
            return null;
        }
        if (!"::cue".equals(com_ushareit_listenit_bss.m9711e(5))) {
            return null;
        }
        int d = com_ushareit_listenit_bss.m9708d();
        String a = m9399a(com_ushareit_listenit_bss, stringBuilder);
        if (a == null) {
            return null;
        }
        if ("{".equals(a)) {
            com_ushareit_listenit_bss.m9707c(d);
            return "";
        }
        String d2;
        if ("(".equals(a)) {
            d2 = m9406d(com_ushareit_listenit_bss);
        } else {
            d2 = null;
        }
        a = m9399a(com_ushareit_listenit_bss, stringBuilder);
        if (!")".equals(a) || a == null) {
            return null;
        }
        return d2;
    }

    private static String m9406d(bss com_ushareit_listenit_bss) {
        int d = com_ushareit_listenit_bss.m9708d();
        int c = com_ushareit_listenit_bss.m9706c();
        int i = d;
        Object obj = null;
        while (i < c && r0 == null) {
            int i2 = i + 1;
            if (((char) com_ushareit_listenit_bss.f7639a[i]) == ')') {
                obj = 1;
            } else {
                obj = null;
            }
            i = i2;
        }
        return com_ushareit_listenit_bss.m9711e((i - 1) - com_ushareit_listenit_bss.m9708d()).trim();
    }

    private static void m9401a(bss com_ushareit_listenit_bss, bpq com_ushareit_listenit_bpq, StringBuilder stringBuilder) {
        m9403b(com_ushareit_listenit_bss);
        String d = m9407d(com_ushareit_listenit_bss, stringBuilder);
        if (!"".equals(d) && ":".equals(m9399a(com_ushareit_listenit_bss, stringBuilder))) {
            m9403b(com_ushareit_listenit_bss);
            String c = m9404c(com_ushareit_listenit_bss, stringBuilder);
            if (c != null && !"".equals(c)) {
                int d2 = com_ushareit_listenit_bss.m9708d();
                String a = m9399a(com_ushareit_listenit_bss, stringBuilder);
                if (!";".equals(a)) {
                    if ("}".equals(a)) {
                        com_ushareit_listenit_bss.m9707c(d2);
                    } else {
                        return;
                    }
                }
                if ("color".equals(d)) {
                    com_ushareit_listenit_bpq.m9420a(bsi.m9667b(c));
                } else if ("background-color".equals(d)) {
                    com_ushareit_listenit_bpq.m9426b(bsi.m9667b(c));
                } else if ("text-decoration".equals(d)) {
                    if ("underline".equals(c)) {
                        com_ushareit_listenit_bpq.m9421a(true);
                    }
                } else if ("font-family".equals(d)) {
                    com_ushareit_listenit_bpq.m9432d(c);
                } else if ("font-weight".equals(d)) {
                    if ("bold".equals(c)) {
                        com_ushareit_listenit_bpq.m9427b(true);
                    }
                } else if ("font-style".equals(d) && "italic".equals(c)) {
                    com_ushareit_listenit_bpq.m9429c(true);
                }
            }
        }
    }

    static void m9403b(bss com_ushareit_listenit_bss) {
        Object obj = 1;
        while (com_ushareit_listenit_bss.m9704b() > 0 && r0 != null) {
            obj = (m9408e(com_ushareit_listenit_bss) || m9409f(com_ushareit_listenit_bss)) ? 1 : null;
        }
    }

    static String m9399a(bss com_ushareit_listenit_bss, StringBuilder stringBuilder) {
        m9403b(com_ushareit_listenit_bss);
        if (com_ushareit_listenit_bss.m9704b() == 0) {
            return null;
        }
        String d = m9407d(com_ushareit_listenit_bss, stringBuilder);
        return "".equals(d) ? "" + ((char) com_ushareit_listenit_bss.m9713g()) : d;
    }

    private static boolean m9408e(bss com_ushareit_listenit_bss) {
        switch (m9398a(com_ushareit_listenit_bss, com_ushareit_listenit_bss.m9708d())) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case C0154a.f2957m /*32*/:
                com_ushareit_listenit_bss.m9709d(1);
                return true;
            default:
                return false;
        }
    }

    static void m9405c(bss com_ushareit_listenit_bss) {
        do {
        } while (!TextUtils.isEmpty(com_ushareit_listenit_bss.m9730x()));
    }

    private static char m9398a(bss com_ushareit_listenit_bss, int i) {
        return (char) com_ushareit_listenit_bss.f7639a[i];
    }

    private static String m9404c(bss com_ushareit_listenit_bss, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder();
        Object obj = null;
        while (obj == null) {
            int d = com_ushareit_listenit_bss.m9708d();
            String a = m9399a(com_ushareit_listenit_bss, stringBuilder);
            if (a == null) {
                return null;
            }
            if ("}".equals(a) || ";".equals(a)) {
                com_ushareit_listenit_bss.m9707c(d);
                obj = 1;
            } else {
                stringBuilder2.append(a);
            }
        }
        return stringBuilder2.toString();
    }

    private static boolean m9409f(bss com_ushareit_listenit_bss) {
        int d = com_ushareit_listenit_bss.m9708d();
        int c = com_ushareit_listenit_bss.m9706c();
        byte[] bArr = com_ushareit_listenit_bss.f7639a;
        if (d + 2 <= c) {
            int i = d + 1;
            if (bArr[d] == (byte) 47) {
                d = i + 1;
                if (bArr[i] == (byte) 42) {
                    i = d;
                    while (i + 1 < c) {
                        d = i + 1;
                        if (((char) bArr[i]) == '*' && ((char) bArr[d]) == '/') {
                            c = d + 1;
                            d = c;
                        }
                        i = d;
                    }
                    com_ushareit_listenit_bss.m9709d(c - com_ushareit_listenit_bss.m9708d());
                    return true;
                }
            }
        }
        return false;
    }

    private static String m9407d(bss com_ushareit_listenit_bss, StringBuilder stringBuilder) {
        int i = 0;
        stringBuilder.setLength(0);
        int d = com_ushareit_listenit_bss.m9708d();
        int c = com_ushareit_listenit_bss.m9706c();
        while (d < c && r0 == 0) {
            char c2 = (char) com_ushareit_listenit_bss.f7639a[d];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                i = 1;
            } else {
                d++;
                stringBuilder.append(c2);
            }
        }
        com_ushareit_listenit_bss.m9709d(d - com_ushareit_listenit_bss.m9708d());
        return stringBuilder.toString();
    }

    private void m9400a(bpq com_ushareit_listenit_bpq, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = f7328a.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    com_ushareit_listenit_bpq.m9430c(matcher.group(1));
                }
                str = str.substring(0, indexOf);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                com_ushareit_listenit_bpq.m9428b(str2.substring(0, indexOf2));
                com_ushareit_listenit_bpq.m9423a(str2.substring(indexOf2 + 1));
            } else {
                com_ushareit_listenit_bpq.m9428b(str2);
            }
            if (split.length > 1) {
                com_ushareit_listenit_bpq.m9424a((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
    }
}
