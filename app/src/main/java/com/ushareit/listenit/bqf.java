package com.ushareit.listenit;

import android.graphics.Point;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class bqf extends bqi {
    private static final int[] f7413a = new int[0];
    private final bqm f7414b;
    private final AtomicReference<bqg> f7415c = new AtomicReference(new bqg());

    public bqf(Handler handler, bqm com_ushareit_listenit_bqm) {
        super(handler);
        this.f7414b = com_ushareit_listenit_bqm;
    }

    protected bql[] mo1084a(bfy[] com_ushareit_listenit_bfyArr, bok[] com_ushareit_listenit_bokArr, int[][][] iArr) {
        bql[] com_ushareit_listenit_bqlArr = new bql[com_ushareit_listenit_bfyArr.length];
        bqg com_ushareit_listenit_bqg = (bqg) this.f7415c.get();
        for (int i = 0; i < com_ushareit_listenit_bfyArr.length; i++) {
            switch (com_ushareit_listenit_bfyArr[i].mo864a()) {
                case 1:
                    com_ushareit_listenit_bqlArr[i] = m9526a(com_ushareit_listenit_bokArr[i], iArr[i], com_ushareit_listenit_bqg.f7416a);
                    break;
                case 2:
                    com_ushareit_listenit_bqlArr[i] = m9525a(com_ushareit_listenit_bfyArr[i], com_ushareit_listenit_bokArr[i], iArr[i], com_ushareit_listenit_bqg.f7420e, com_ushareit_listenit_bqg.f7421f, com_ushareit_listenit_bqg.f7419d, com_ushareit_listenit_bqg.f7418c, com_ushareit_listenit_bqg.f7423h, com_ushareit_listenit_bqg.f7424i, com_ushareit_listenit_bqg.f7425j, this.f7414b, com_ushareit_listenit_bqg.f7422g);
                    break;
                case 3:
                    com_ushareit_listenit_bqlArr[i] = m9527a(com_ushareit_listenit_bokArr[i], iArr[i], com_ushareit_listenit_bqg.f7417b, com_ushareit_listenit_bqg.f7416a);
                    break;
                default:
                    com_ushareit_listenit_bqlArr[i] = m9524a(com_ushareit_listenit_bfyArr[i].mo864a(), com_ushareit_listenit_bokArr[i], iArr[i]);
                    break;
            }
        }
        return com_ushareit_listenit_bqlArr;
    }

    protected bql m9525a(bfy com_ushareit_listenit_bfy, bok com_ushareit_listenit_bok, int[][] iArr, int i, int i2, boolean z, boolean z2, int i3, int i4, boolean z3, bqm com_ushareit_listenit_bqm, boolean z4) {
        bql com_ushareit_listenit_bql = null;
        if (com_ushareit_listenit_bqm != null) {
            com_ushareit_listenit_bql = m9516a(com_ushareit_listenit_bfy, com_ushareit_listenit_bok, iArr, i, i2, z, z2, i3, i4, z3, com_ushareit_listenit_bqm);
        }
        if (com_ushareit_listenit_bql == null) {
            return m9517a(com_ushareit_listenit_bok, iArr, i, i2, i3, i4, z3, z4);
        }
        return com_ushareit_listenit_bql;
    }

    private static bql m9516a(bfy com_ushareit_listenit_bfy, bok com_ushareit_listenit_bok, int[][] iArr, int i, int i2, boolean z, boolean z2, int i3, int i4, boolean z3, bqm com_ushareit_listenit_bqm) {
        int i5 = z ? 12 : 8;
        boolean z4 = z2 && (com_ushareit_listenit_bfy.mo880l() & i5) != 0;
        for (int i6 = 0; i6 < com_ushareit_listenit_bok.f7223a; i6++) {
            boj a = com_ushareit_listenit_bok.m9239a(i6);
            int[] a2 = m9522a(a, iArr[i6], z4, i5, i, i2, i3, i4, z3);
            if (a2.length > 0) {
                return com_ushareit_listenit_bqm.mo1082b(a, a2);
            }
        }
        return null;
    }

    private static int[] m9522a(boj com_ushareit_listenit_boj, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, boolean z2) {
        if (com_ushareit_listenit_boj.f7220a < 2) {
            return f7413a;
        }
        List a = m9518a(com_ushareit_listenit_boj, i4, i5, z2);
        if (a.size() < 2) {
            return f7413a;
        }
        String str;
        String str2 = null;
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            int i6 = 0;
            int i7 = 0;
            while (i7 < a.size()) {
                int a2;
                str = com_ushareit_listenit_boj.m9237a(((Integer) a.get(i7)).intValue()).f1431e;
                if (!hashSet.contains(str)) {
                    hashSet.add(str);
                    a2 = m9514a(com_ushareit_listenit_boj, iArr, i, str, i2, i3, a);
                    if (a2 > i6) {
                        i7++;
                        i6 = a2;
                        str2 = str;
                    }
                }
                a2 = i6;
                str = str2;
                i7++;
                i6 = a2;
                str2 = str;
            }
            str = str2;
        }
        m9523b(com_ushareit_listenit_boj, iArr, i, str, i2, i3, a);
        return a.size() < 2 ? f7413a : btc.m9771a(a);
    }

    private static int m9514a(boj com_ushareit_listenit_boj, int[] iArr, int i, String str, int i2, int i3, List<Integer> list) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < list.size()) {
            int intValue = ((Integer) list.get(i4)).intValue();
            if (m9521a(com_ushareit_listenit_boj.m9237a(intValue), str, iArr[intValue], i, i2, i3)) {
                intValue = i5 + 1;
            } else {
                intValue = i5;
            }
            i4++;
            i5 = intValue;
        }
        return i5;
    }

    private static void m9523b(boj com_ushareit_listenit_boj, int[] iArr, int i, String str, int i2, int i3, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (!m9521a(com_ushareit_listenit_boj.m9237a(intValue), str, iArr[intValue], i, i2, i3)) {
                list.remove(size);
            }
        }
    }

    private static boolean m9521a(Format format, String str, int i, int i2, int i3, int i4) {
        return m9519a(i) && (i & i2) != 0 && ((str == null || btc.m9770a(format.f1431e, (Object) str)) && ((format.f1435i == -1 || format.f1435i <= i3) && (format.f1436j == -1 || format.f1436j <= i4)));
    }

    private static bql m9517a(bok com_ushareit_listenit_bok, int[][] iArr, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boj com_ushareit_listenit_boj = null;
        int i5 = 0;
        int i6 = -1;
        Object obj = null;
        for (int i7 = 0; i7 < com_ushareit_listenit_bok.f7223a; i7++) {
            boj a = com_ushareit_listenit_bok.m9239a(i7);
            List a2 = m9518a(a, i3, i4, z);
            int[] iArr2 = iArr[i7];
            int i8 = 0;
            while (i8 < a.f7220a) {
                Object obj2;
                int a3;
                int i9;
                boj com_ushareit_listenit_boj2;
                if (m9519a(iArr2[i8])) {
                    Format a4 = a.m9237a(i8);
                    obj2 = (!a2.contains(Integer.valueOf(i8)) || ((a4.f1435i != -1 && a4.f1435i > i) || (a4.f1436j != -1 && a4.f1436j > i2))) ? null : 1;
                    a3 = a4.m2076a();
                    Object obj3 = obj != null ? (obj2 == null || m9513a(a3, i6) <= 0) ? null : 1 : (obj2 != null || (z2 && (com_ushareit_listenit_boj == null || m9513a(a3, i6) < 0))) ? 1 : null;
                    if (obj3 != null) {
                        i9 = a3;
                        com_ushareit_listenit_boj2 = a;
                        a3 = i8;
                        i8++;
                        i5 = a3;
                        com_ushareit_listenit_boj = com_ushareit_listenit_boj2;
                        i6 = i9;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                a3 = i5;
                i9 = i6;
                com_ushareit_listenit_boj2 = com_ushareit_listenit_boj;
                i8++;
                i5 = a3;
                com_ushareit_listenit_boj = com_ushareit_listenit_boj2;
                i6 = i9;
                obj = obj2;
            }
        }
        return com_ushareit_listenit_boj == null ? null : new bqh(com_ushareit_listenit_boj, i5);
    }

    private static int m9513a(int i, int i2) {
        return i == -1 ? i2 == -1 ? 0 : -1 : i2 == -1 ? 1 : i - i2;
    }

    protected bql m9526a(bok com_ushareit_listenit_bok, int[][] iArr, String str) {
        Object obj = null;
        int i = 0;
        boj com_ushareit_listenit_boj = null;
        for (int i2 = 0; i2 < com_ushareit_listenit_bok.f7223a; i2++) {
            boj a = com_ushareit_listenit_bok.m9239a(i2);
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < a.f7220a) {
                Object obj2;
                int i4;
                boj com_ushareit_listenit_boj2;
                if (m9519a(iArr2[i3])) {
                    Format a2 = a.m9237a(i3);
                    if ((a2.f1448v & 1) != 0) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (m9520a(a2, str)) {
                        obj2 = obj2 != null ? 4 : 3;
                    } else if (obj2 != null) {
                        obj2 = 2;
                    } else {
                        int i5 = 1;
                    }
                    if (obj2 > obj) {
                        i4 = i3;
                        com_ushareit_listenit_boj2 = a;
                        i3++;
                        com_ushareit_listenit_boj = com_ushareit_listenit_boj2;
                        i = i4;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                i4 = i;
                com_ushareit_listenit_boj2 = com_ushareit_listenit_boj;
                i3++;
                com_ushareit_listenit_boj = com_ushareit_listenit_boj2;
                i = i4;
                obj = obj2;
            }
        }
        if (com_ushareit_listenit_boj == null) {
            return null;
        }
        return new bqh(com_ushareit_listenit_boj, i);
    }

    protected bql m9527a(bok com_ushareit_listenit_bok, int[][] iArr, String str, String str2) {
        boj com_ushareit_listenit_boj = null;
        int i = 0;
        Object obj = null;
        for (int i2 = 0; i2 < com_ushareit_listenit_bok.f7223a; i2++) {
            boj a = com_ushareit_listenit_bok.m9239a(i2);
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < a.f7220a) {
                Object obj2;
                int i4;
                boj com_ushareit_listenit_boj2;
                if (m9519a(iArr2[i3])) {
                    Format a2 = a.m9237a(i3);
                    obj2 = (a2.f1448v & 1) != 0 ? 1 : null;
                    Object obj3 = (a2.f1448v & 2) != 0 ? 1 : null;
                    if (m9520a(a2, str)) {
                        if (obj2 != null) {
                            obj2 = 6;
                        } else if (obj3 == null) {
                            obj2 = 5;
                        } else {
                            obj2 = 4;
                        }
                    } else if (obj2 != null) {
                        obj2 = 3;
                    } else if (obj3 == null) {
                        obj2 = null;
                    } else if (m9520a(a2, str2)) {
                        obj2 = 2;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 > obj) {
                        i4 = i3;
                        com_ushareit_listenit_boj2 = a;
                        i3++;
                        com_ushareit_listenit_boj = com_ushareit_listenit_boj2;
                        i = i4;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                i4 = i;
                com_ushareit_listenit_boj2 = com_ushareit_listenit_boj;
                i3++;
                com_ushareit_listenit_boj = com_ushareit_listenit_boj2;
                i = i4;
                obj = obj2;
            }
        }
        return com_ushareit_listenit_boj == null ? null : new bqh(com_ushareit_listenit_boj, i);
    }

    protected bql m9524a(int i, bok com_ushareit_listenit_bok, int[][] iArr) {
        Object obj = null;
        int i2 = 0;
        boj com_ushareit_listenit_boj = null;
        for (int i3 = 0; i3 < com_ushareit_listenit_bok.f7223a; i3++) {
            boj a = com_ushareit_listenit_bok.m9239a(i3);
            int[] iArr2 = iArr[i3];
            int i4 = 0;
            while (i4 < a.f7220a) {
                Object obj2;
                int i5;
                boj com_ushareit_listenit_boj2;
                if (m9519a(iArr2[i4])) {
                    if ((a.m9237a(i4).f1448v & 1) != 0) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        obj2 = 2;
                    } else {
                        int i6 = 1;
                    }
                    if (obj2 > obj) {
                        i5 = i4;
                        com_ushareit_listenit_boj2 = a;
                        i4++;
                        com_ushareit_listenit_boj = com_ushareit_listenit_boj2;
                        i2 = i5;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                i5 = i2;
                com_ushareit_listenit_boj2 = com_ushareit_listenit_boj;
                i4++;
                com_ushareit_listenit_boj = com_ushareit_listenit_boj2;
                i2 = i5;
                obj = obj2;
            }
        }
        if (com_ushareit_listenit_boj == null) {
            return null;
        }
        return new bqh(com_ushareit_listenit_boj, i2);
    }

    private static boolean m9519a(int i) {
        return (i & 3) == 3;
    }

    private static boolean m9520a(Format format, String str) {
        return str != null && str.equals(btc.m9774b(format.f1449w));
    }

    private static List<Integer> m9518a(boj com_ushareit_listenit_boj, int i, int i2, boolean z) {
        int i3;
        int i4 = 0;
        ArrayList arrayList = new ArrayList(com_ushareit_listenit_boj.f7220a);
        for (i3 = 0; i3 < com_ushareit_listenit_boj.f7220a; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i == MoPubClientPositioning.NO_REPEAT || i2 == MoPubClientPositioning.NO_REPEAT) {
            return arrayList;
        }
        int i5 = Integer.MAX_VALUE;
        while (i4 < com_ushareit_listenit_boj.f7220a) {
            Format a = com_ushareit_listenit_boj.m9237a(i4);
            if (a.f1435i > 0 && a.f1436j > 0) {
                Point a2 = m9515a(z, i, i2, a.f1435i, a.f1436j);
                i3 = a.f1435i * a.f1436j;
                if (a.f1435i >= ((int) (((float) a2.x) * 0.98f)) && a.f1436j >= ((int) (((float) a2.y) * 0.98f)) && i3 < i5) {
                    i4++;
                    i5 = i3;
                }
            }
            i3 = i5;
            i4++;
            i5 = i3;
        }
        if (i5 != Integer.MAX_VALUE) {
            for (i4 = arrayList.size() - 1; i4 >= 0; i4--) {
                i3 = com_ushareit_listenit_boj.m9237a(((Integer) arrayList.get(i4)).intValue()).m2076a();
                if (i3 == -1 || i3 > i5) {
                    arrayList.remove(i4);
                }
            }
        }
        return arrayList;
    }

    private static Point m9515a(boolean z, int i, int i2, int i3, int i4) {
        Object obj = 1;
        if (z) {
            Object obj2 = i3 > i4 ? 1 : null;
            if (i <= i2) {
                obj = null;
            }
            if (obj2 != obj) {
                int i5 = i;
                i = i2;
                i2 = i5;
            }
        }
        if (i3 * i2 >= i4 * i) {
            return new Point(i, btc.m9760a(i * i4, i3));
        }
        return new Point(btc.m9760a(i2 * i3, i4), i2);
    }
}
