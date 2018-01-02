package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class bnl implements bne<List<bnm>> {
    public /* synthetic */ Object mo1021a(byte[] bArr, int i) {
        return m9147b(bArr, i);
    }

    public boolean mo1022a(String str) {
        return str.equals("application/id3");
    }

    public List<bnm> m9147b(byte[] bArr, int i) {
        List arrayList = new ArrayList();
        bss com_ushareit_listenit_bss = new bss(bArr, i);
        int a = m9135a(com_ushareit_listenit_bss);
        while (a > 0) {
            int g = com_ushareit_listenit_bss.m9713g();
            int g2 = com_ushareit_listenit_bss.m9713g();
            int g3 = com_ushareit_listenit_bss.m9713g();
            int g4 = com_ushareit_listenit_bss.m9713g();
            int s = com_ushareit_listenit_bss.m9725s();
            if (s <= 1) {
                break;
            }
            Object a2;
            com_ushareit_listenit_bss.m9709d(2);
            if (g == 84 && g2 == 88 && g3 == 88 && g4 == 88) {
                try {
                    a2 = m9138a(com_ushareit_listenit_bss, s);
                } catch (Throwable e) {
                    throw new bnf("Unsupported encoding", e);
                }
            } else if (g == 80 && g2 == 82 && g3 == 73 && g4 == 86) {
                a2 = m9140b(com_ushareit_listenit_bss, s);
            } else if (g == 71 && g2 == 69 && g3 == 79 && g4 == 66) {
                a2 = m9143c(com_ushareit_listenit_bss, s);
            } else if (g == 65 && g2 == 80 && g3 == 73 && g4 == 67) {
                a2 = m9144d(com_ushareit_listenit_bss, s);
            } else if (g == 84) {
                a2 = m9137a(com_ushareit_listenit_bss, s, String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(g), Integer.valueOf(g2), Integer.valueOf(g3), Integer.valueOf(g4)}));
            } else {
                a2 = m9139b(com_ushareit_listenit_bss, s, String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(g), Integer.valueOf(g2), Integer.valueOf(g3), Integer.valueOf(g4)}));
            }
            arrayList.add(a2);
            a -= s + 10;
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static int m9136a(byte[] bArr, int i, int i2) {
        int c = m9142c(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return c;
        }
        while (c < bArr.length - 1) {
            if (c % 2 == 0 && bArr[c + 1] == (byte) 0) {
                return c;
            }
            c = m9142c(bArr, c + 1);
        }
        return bArr.length;
    }

    private static int m9142c(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == (byte) 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static int m9134a(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int m9135a(bss com_ushareit_listenit_bss) {
        int g = com_ushareit_listenit_bss.m9713g();
        int g2 = com_ushareit_listenit_bss.m9713g();
        int g3 = com_ushareit_listenit_bss.m9713g();
        if (g == 73 && g2 == 68 && g3 == 51) {
            com_ushareit_listenit_bss.m9709d(2);
            g2 = com_ushareit_listenit_bss.m9713g();
            g = com_ushareit_listenit_bss.m9725s();
            if ((g2 & 2) != 0) {
                g3 = com_ushareit_listenit_bss.m9725s();
                if (g3 > 4) {
                    com_ushareit_listenit_bss.m9709d(g3 - 4);
                }
                g -= g3;
            }
            if ((g2 & 8) != 0) {
                return g - 10;
            }
            return g;
        }
        throw new bnf(String.format(Locale.US, "Unexpected ID3 file identifier, expected \"ID3\", actual \"%c%c%c\".", new Object[]{Integer.valueOf(g), Integer.valueOf(g2), Integer.valueOf(g3)}));
    }

    private static bnp m9138a(bss com_ushareit_listenit_bss, int i) {
        int g = com_ushareit_listenit_bss.m9713g();
        String b = m9141b(g);
        byte[] bArr = new byte[(i - 1)];
        com_ushareit_listenit_bss.m9703a(bArr, 0, i - 1);
        int a = m9136a(bArr, 0, g);
        String str = new String(bArr, 0, a, b);
        a += m9134a(g);
        return new bnp(str, new String(bArr, a, m9136a(bArr, a, g) - a, b));
    }

    private static bnn m9140b(bss com_ushareit_listenit_bss, int i) {
        byte[] bArr = new byte[i];
        com_ushareit_listenit_bss.m9703a(bArr, 0, i);
        int c = m9142c(bArr, 0);
        return new bnn(new String(bArr, 0, c, "ISO-8859-1"), Arrays.copyOfRange(bArr, c + 1, bArr.length));
    }

    private static bnk m9143c(bss com_ushareit_listenit_bss, int i) {
        int g = com_ushareit_listenit_bss.m9713g();
        String b = m9141b(g);
        byte[] bArr = new byte[(i - 1)];
        com_ushareit_listenit_bss.m9703a(bArr, 0, i - 1);
        int c = m9142c(bArr, 0);
        String str = new String(bArr, 0, c, "ISO-8859-1");
        c++;
        int a = m9136a(bArr, c, g);
        String str2 = new String(bArr, c, a - c, b);
        c = m9134a(g) + a;
        a = m9136a(bArr, c, g);
        return new bnk(str, str2, new String(bArr, c, a - c, b), Arrays.copyOfRange(bArr, m9134a(g) + a, bArr.length));
    }

    private static bni m9144d(bss com_ushareit_listenit_bss, int i) {
        int g = com_ushareit_listenit_bss.m9713g();
        String b = m9141b(g);
        byte[] bArr = new byte[(i - 1)];
        com_ushareit_listenit_bss.m9703a(bArr, 0, i - 1);
        int c = m9142c(bArr, 0);
        String str = new String(bArr, 0, c, "ISO-8859-1");
        int i2 = bArr[c + 1] & 255;
        c += 2;
        int a = m9136a(bArr, c, g);
        return new bni(str, new String(bArr, c, a - c, b), i2, Arrays.copyOfRange(bArr, m9134a(g) + a, bArr.length));
    }

    private static bno m9137a(bss com_ushareit_listenit_bss, int i, String str) {
        int g = com_ushareit_listenit_bss.m9713g();
        String b = m9141b(g);
        byte[] bArr = new byte[(i - 1)];
        com_ushareit_listenit_bss.m9703a(bArr, 0, i - 1);
        return new bno(str, new String(bArr, 0, m9136a(bArr, 0, g), b));
    }

    private static bnj m9139b(bss com_ushareit_listenit_bss, int i, String str) {
        byte[] bArr = new byte[i];
        com_ushareit_listenit_bss.m9703a(bArr, 0, i);
        return new bnj(str, bArr);
    }

    private static String m9141b(int i) {
        switch (i) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return "UTF-8";
            default:
                return "ISO-8859-1";
        }
    }
}
