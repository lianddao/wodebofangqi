package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.mobileads.resource.DrawableConstants.RadialCountdown;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.dm;

public final class boy extends boz {
    private static final int[] f7263a = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] f7264b = new int[]{174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] f7265c = new int[]{193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] f7266d = new int[]{195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final bss f7267e = new bss();
    private final StringBuilder f7268f = new StringBuilder();
    private int f7269g;
    private int f7270h;
    private String f7271i;
    private String f7272j;
    private boolean f7273k;
    private byte f7274l;
    private byte f7275m;

    public /* bridge */ /* synthetic */ bov mo1075g() {
        return super.mo1075g();
    }

    public /* bridge */ /* synthetic */ bou mo1076h() {
        return super.mo1076h();
    }

    public boy() {
        m9298a(0);
        this.f7270h = 4;
    }

    public void mo955c() {
        super.mo955c();
        m9298a(0);
        this.f7270h = 4;
        this.f7268f.setLength(0);
        this.f7271i = null;
        this.f7272j = null;
        this.f7273k = false;
        this.f7274l = (byte) 0;
        this.f7275m = (byte) 0;
    }

    public void mo956d() {
    }

    protected boolean mo1073e() {
        return !TextUtils.equals(this.f7271i, this.f7272j);
    }

    protected bop mo1074f() {
        this.f7272j = this.f7271i;
        return new bpb(new bom(this.f7271i));
    }

    protected void mo1071a(bou com_ushareit_listenit_bou) {
        this.f7267e.m9702a(com_ushareit_listenit_bou.b.array(), com_ushareit_listenit_bou.b.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.f7267e.m9704b() > 0) {
            byte g = (byte) (this.f7267e.m9713g() & 127);
            byte g2 = (byte) (this.f7267e.m9713g() & 127);
            if (((byte) (this.f7267e.m9713g() & 7)) == (byte) 4 && !(g == (byte) 0 && g2 == (byte) 0)) {
                if ((g == (byte) 17 || g == (byte) 25) && (g2 & 112) == 48) {
                    this.f7268f.append(m9303c(g2));
                    z2 = true;
                } else {
                    if ((g2 & 96) == 32) {
                        if (g == (byte) 18 || g == (byte) 26) {
                            m9308i();
                            this.f7268f.append(m9305d(g2));
                            z2 = true;
                        } else if (g == (byte) 19 || g == (byte) 27) {
                            m9308i();
                            this.f7268f.append(m9306e(g2));
                            z2 = true;
                        }
                    }
                    if (g < (byte) 32) {
                        z = m9299a(g, g2);
                        z2 = true;
                    } else {
                        this.f7268f.append(m9301b(g));
                        if (g2 >= (byte) 32) {
                            this.f7268f.append(m9301b(g2));
                        }
                        z2 = true;
                    }
                }
            }
        }
        if (z2) {
            if (!z) {
                this.f7273k = false;
            }
            if (this.f7269g == 1 || this.f7269g == 3) {
                this.f7271i = m9310k();
            }
        }
    }

    private boolean m9299a(byte b, byte b2) {
        boolean f = m9307f(b);
        if (f) {
            if (this.f7273k && this.f7274l == b && this.f7275m == b2) {
                this.f7273k = false;
                return true;
            }
            this.f7273k = true;
            this.f7274l = b;
            this.f7275m = b2;
        }
        if (m9302b(b, b2)) {
            m9297a(b2);
        } else if (m9304c(b, b2)) {
            m9309j();
        }
        return f;
    }

    private void m9297a(byte b) {
        switch (b) {
            case C0154a.f2957m /*32*/:
                m9298a(2);
                return;
            case (byte) 37:
                this.f7270h = 2;
                m9298a(1);
                return;
            case CtaButton.HEIGHT_DIPS /*38*/:
                this.f7270h = 3;
                m9298a(1);
                return;
            case (byte) 39:
                this.f7270h = 4;
                m9298a(1);
                return;
            case (byte) 41:
                m9298a(3);
                return;
            default:
                if (this.f7269g != 0) {
                    switch (b) {
                        case (byte) 33:
                            if (this.f7268f.length() > 0) {
                                this.f7268f.setLength(this.f7268f.length() - 1);
                                return;
                            }
                            return;
                        case (byte) 44:
                            this.f7271i = null;
                            if (this.f7269g == 1 || this.f7269g == 3) {
                                this.f7268f.setLength(0);
                                return;
                            }
                            return;
                        case RadialCountdown.SIDE_LENGTH_DIPS /*45*/:
                            m9309j();
                            return;
                        case CloseButton.WIDGET_HEIGHT_DIPS /*46*/:
                            this.f7268f.setLength(0);
                            return;
                        case (byte) 47:
                            this.f7271i = m9310k();
                            this.f7268f.setLength(0);
                            return;
                        default:
                            return;
                    }
                }
                return;
        }
    }

    private void m9308i() {
        if (this.f7268f.length() > 0) {
            this.f7268f.setLength(this.f7268f.length() - 1);
        }
    }

    private void m9309j() {
        int length = this.f7268f.length();
        if (length > 0 && this.f7268f.charAt(length - 1) != '\n') {
            this.f7268f.append('\n');
        }
    }

    private String m9310k() {
        int length = this.f7268f.length();
        if (length == 0) {
            return null;
        }
        int i;
        if (this.f7268f.charAt(length - 1) == '\n') {
            i = 1;
        } else {
            i = 0;
        }
        if (length == 1 && i != 0) {
            return null;
        }
        if (i != 0) {
            length--;
        }
        if (this.f7269g != 1) {
            return this.f7268f.substring(0, length);
        }
        int i2;
        i = length;
        for (i2 = 0; i2 < this.f7270h && i != -1; i2++) {
            i = this.f7268f.lastIndexOf("\n", i - 1);
        }
        if (i != -1) {
            i2 = i + 1;
        } else {
            i2 = 0;
        }
        this.f7268f.delete(0, i2);
        return this.f7268f.substring(0, length - i2);
    }

    private void m9298a(int i) {
        if (this.f7269g != i) {
            this.f7269g = i;
            this.f7268f.setLength(0);
            if (i == 1 || i == 0) {
                this.f7271i = null;
            }
        }
    }

    private static char m9301b(byte b) {
        return (char) f7263a[(b & 127) - 32];
    }

    private static char m9303c(byte b) {
        return (char) f7264b[b & 15];
    }

    private static char m9305d(byte b) {
        return (char) f7265c[b & 31];
    }

    private static char m9306e(byte b) {
        return (char) f7266d[b & 31];
    }

    private static boolean m9302b(byte b, byte b2) {
        return (b == (byte) 20 || b == (byte) 28) && b2 >= (byte) 32 && b2 <= (byte) 47;
    }

    private static boolean m9304c(byte b, byte b2) {
        return b >= dm.f3664n && b <= (byte) 31 && b2 >= (byte) 64 && b2 <= Byte.MAX_VALUE;
    }

    private static boolean m9307f(byte b) {
        return b >= dm.f3664n && b <= (byte) 31;
    }

    public static boolean m9300a(int i, int i2, bss com_ushareit_listenit_bss) {
        if (i != 4 || i2 < 8) {
            return false;
        }
        int d = com_ushareit_listenit_bss.m9708d();
        int g = com_ushareit_listenit_bss.m9713g();
        int h = com_ushareit_listenit_bss.m9714h();
        int n = com_ushareit_listenit_bss.m9720n();
        int g2 = com_ushareit_listenit_bss.m9713g();
        com_ushareit_listenit_bss.m9707c(d);
        if (g == 181 && h == 49 && n == 1195456820 && g2 == 3) {
            return true;
        }
        return false;
    }
}
