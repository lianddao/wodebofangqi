package com.ushareit.listenit;

import android.util.Pair;

public class fem {
    public static int f12543a = 0;
    public static int f12544b = 0;

    public static boolean m18970a() {
        return m18977h() && gef.m21805a().m21838h() && fqo.m20423e() && ((m18981l() || m18982m()) && gvj.m23037v() > 0);
    }

    public static boolean m18971b() {
        return m18977h() && gef.m21805a().m21838h() && fqo.m20427i() && ((m18981l() || m18982m()) && gvj.m23035u() > 0 && gyp.m23285b() && gyp.m23272a().mo2410D() >= fqo.m20430l());
    }

    public static boolean m18972c() {
        return m18977h() && gef.m21805a().m21838h() && fqo.m20431m() && ((m18981l() || m18982m()) && gvj.m23039w() > 0 && gyp.m23285b() && gyp.m23272a().mo2410D() >= fqo.m20435q());
    }

    public static boolean m18973d() {
        return m18977h() && gef.m21805a().m21838h() && fqo.m20439u() && ((m18981l() || m18982m()) && gvj.m23041x() > 0 && gyp.m23285b() && gyp.m23272a().mo2410D() >= fqo.m20443y());
    }

    public static boolean m18974e() {
        return m18977h() && gef.m21805a().m21838h() && fqo.m20404A() && ((m18981l() || m18982m()) && gvj.m23043y() > 0);
    }

    public static boolean m18975f() {
        return m18977h() && gef.m21805a().m21838h() && fqo.m20408E() && ((m18981l() || m18982m()) && gyp.m23285b() && gyp.m23272a().mo2410D() >= fqo.m20410G());
    }

    public static boolean m18976g() {
        return m18977h() && gef.m21805a().m21838h() && fqo.m20409F();
    }

    public static boolean m18977h() {
        Pair a = eyw.m18568a(eys.m18562a());
        return ((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue();
    }

    public static boolean m18978i() {
        return f12543a >= fqo.m20444z();
    }

    public static boolean m18979j() {
        return f12544b >= fqo.m20438t();
    }

    private static boolean m18981l() {
        long x = gvj.m23042x(eys.m18562a());
        int H = fqo.m20411H();
        return x >= ((long) H) && x % ((long) H) == 0;
    }

    private static boolean m18982m() {
        if (gyp.m23285b() && gyp.m23272a().mo2410D() / 60000 >= fqo.m20412I()) {
            return true;
        }
        return false;
    }

    public static void m18980k() {
        if (gef.m21805a().m21838h()) {
            m18983n();
            m18984o();
            m18985p();
            m18986q();
            m18987r();
        }
    }

    private static void m18983n() {
        int k = fqo.m20429k();
        int F = gvj.m22864F();
        k += F;
        if (gvj.m23046z()) {
            k++;
            int j = fqo.m20428j();
            if (k <= j) {
                gvj.m22988k(F + 1);
            } else {
                k = j;
            }
            gvj.m22968h(false);
        }
        gvj.m22938e(k);
    }

    private static void m18984o() {
        int p = fqo.m20434p();
        int E = gvj.m22862E();
        p += E;
        int n;
        if (gvj.m22855A()) {
            p++;
            n = fqo.m20432n();
            if (p <= n) {
                gvj.m22979j(E + 1);
            } else {
                p = n;
            }
            gvj.m22976i(false);
        } else if (gvj.m22859C()) {
            p--;
            n = fqo.m20433o();
            if (p >= n) {
                gvj.m22979j(E - 1);
            } else {
                p = n;
            }
            gvj.m22993k(false);
        }
        gvj.m22955g(p);
    }

    private static void m18985p() {
        int x = fqo.m20442x();
        int G = gvj.m22866G();
        x += G;
        int v;
        if (gvj.m22856B()) {
            x++;
            v = fqo.m20440v();
            if (x <= v) {
                gvj.m22996l(G + 1);
            } else {
                x = v;
            }
            gvj.m22983j(false);
        } else if (gvj.m22861D()) {
            x--;
            v = fqo.m20441w();
            if (x >= v) {
                gvj.m22996l(G - 1);
            } else {
                x = v;
            }
            gvj.m23001l(false);
        }
        gvj.m22963h(x);
    }

    private static void m18986q() {
        gvj.m22971i(fqo.m20405B());
    }

    private static void m18987r() {
        gvj.m22947f(fqo.m20426h());
    }
}
