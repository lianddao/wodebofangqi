package com.ushareit.listenit;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.mopub.volley.DefaultRetryPolicy;
import com.umeng.analytics.C0154a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class bjl {
    private static final int f6615a = btc.m9777e("vide");
    private static final int f6616b = btc.m9777e("soun");
    private static final int f6617c = btc.m9777e("text");
    private static final int f6618d = btc.m9777e("sbtl");
    private static final int f6619e = btc.m9777e("subt");
    private static final int f6620f = btc.m9777e("clcp");
    private static final int f6621g = btc.m9777e("cenc");

    public static bke m8713a(bjj com_ushareit_listenit_bjj, bjk com_ushareit_listenit_bjk, long j, DrmInitData drmInitData, boolean z) {
        bjj e = com_ushareit_listenit_bjj.m8706e(bji.f6566D);
        int c = m8723c(e.m8705d(bji.f6580R).aN);
        if (c == -1) {
            return null;
        }
        long a;
        long j2;
        bjr b = m8721b(com_ushareit_listenit_bjj.m8705d(bji.f6576N).aN);
        if (j == -9223372036854775807L) {
            a = b.f6644b;
        } else {
            a = j;
        }
        long a2 = m8710a(com_ushareit_listenit_bjk.aN);
        if (a == -9223372036854775807L) {
            j2 = -9223372036854775807L;
        } else {
            j2 = btc.m9763a(a, 1000000, a2);
        }
        bjj e2 = e.m8706e(bji.f6567E).m8706e(bji.f6568F);
        Pair d = m8725d(e.m8705d(bji.f6579Q).aN);
        bjo a3 = m8712a(e2.m8705d(bji.f6581S).aN, b.f6643a, b.f6645c, (String) d.second, drmInitData, z);
        Pair a4 = m8711a(com_ushareit_listenit_bjj.m8706e(bji.f6577O));
        if (a3.f6632b == null) {
            return null;
        }
        return new bke(b.f6643a, c, ((Long) d.first).longValue(), a2, j2, a3.f6632b, a3.f6634d, a3.f6631a, a3.f6633c, (long[]) a4.first, (long[]) a4.second);
    }

    public static bkh m8714a(bke com_ushareit_listenit_bke, bjj com_ushareit_listenit_bjj, bic com_ushareit_listenit_bic) {
        bjn com_ushareit_listenit_bjp;
        bjk d = com_ushareit_listenit_bjj.m8705d(bji.ap);
        if (d != null) {
            com_ushareit_listenit_bjp = new bjp(d);
        } else {
            d = com_ushareit_listenit_bjj.m8705d(bji.aq);
            if (d == null) {
                throw new bfw("Track has no sample table size information");
            }
            com_ushareit_listenit_bjp = new bjq(d);
        }
        int a = com_ushareit_listenit_bjp.mo997a();
        if (a == 0) {
            return new bkh(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        int t;
        int i;
        int i2;
        Object obj;
        int i3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long[] jArr;
        int i9;
        Object obj2;
        Object obj3;
        long j2;
        boolean z = false;
        d = com_ushareit_listenit_bjj.m8705d(bji.ar);
        if (d == null) {
            z = true;
            d = com_ushareit_listenit_bjj.m8705d(bji.as);
        }
        bss com_ushareit_listenit_bss = d.aN;
        bss com_ushareit_listenit_bss2 = com_ushareit_listenit_bjj.m8705d(bji.ao).aN;
        bss com_ushareit_listenit_bss3 = com_ushareit_listenit_bjj.m8705d(bji.al).aN;
        d = com_ushareit_listenit_bjj.m8705d(bji.am);
        bss com_ushareit_listenit_bss4 = d != null ? d.aN : null;
        bjk d2 = com_ushareit_listenit_bjj.m8705d(bji.an);
        bss com_ushareit_listenit_bss5 = d2 != null ? d2.aN : null;
        bjm com_ushareit_listenit_bjm = new bjm(com_ushareit_listenit_bss2, com_ushareit_listenit_bss, z);
        com_ushareit_listenit_bss3.m9707c(12);
        int t2 = com_ushareit_listenit_bss3.m9726t() - 1;
        int t3 = com_ushareit_listenit_bss3.m9726t();
        int t4 = com_ushareit_listenit_bss3.m9726t();
        int i10 = 0;
        if (com_ushareit_listenit_bss5 != null) {
            com_ushareit_listenit_bss5.m9707c(12);
            i10 = com_ushareit_listenit_bss5.m9726t();
        }
        if (com_ushareit_listenit_bss4 != null) {
            com_ushareit_listenit_bss4.m9707c(12);
            t = com_ushareit_listenit_bss4.m9726t();
            if (t > 0) {
                i = t;
                t = com_ushareit_listenit_bss4.m9726t() - 1;
                com_ushareit_listenit_bss = com_ushareit_listenit_bss4;
                i2 = i;
            } else {
                i = t;
                t = -1;
                com_ushareit_listenit_bss = null;
                i2 = i;
            }
        } else {
            t = -1;
            com_ushareit_listenit_bss = com_ushareit_listenit_bss4;
            i2 = 0;
        }
        Object obj4 = (com_ushareit_listenit_bjp.mo999c() && "audio/raw".equals(com_ushareit_listenit_bke.f6723f.f1431e) && t2 == 0 && i10 == 0 && i2 == 0) ? 1 : null;
        if (obj4 == null) {
            obj = new long[a];
            Object obj5 = new int[a];
            long[] jArr2 = new long[a];
            Object obj6 = new int[a];
            long j3 = 0;
            int i11 = 0;
            i3 = t3;
            int i12 = 0;
            int i13 = i2;
            i2 = 0;
            i = t;
            t = i10;
            j = 0;
            i4 = 0;
            i5 = 0;
            i6 = t4;
            i7 = t2;
            t4 = i;
            while (i11 < a) {
                long j4 = j3;
                i8 = i5;
                while (i8 == 0) {
                    bsg.m9658b(com_ushareit_listenit_bjm.m8728a());
                    j4 = com_ushareit_listenit_bjm.f6625d;
                    i8 = com_ushareit_listenit_bjm.f6624c;
                }
                if (com_ushareit_listenit_bss5 != null) {
                    while (i12 == 0 && t > 0) {
                        i12 = com_ushareit_listenit_bss5.m9726t();
                        i2 = com_ushareit_listenit_bss5.m9720n();
                        t--;
                    }
                    i12--;
                }
                obj[i11] = j4;
                obj5[i11] = com_ushareit_listenit_bjp.mo998b();
                if (obj5[i11] > i4) {
                    i4 = obj5[i11];
                }
                jArr2[i11] = ((long) i2) + j;
                obj6[i11] = com_ushareit_listenit_bss == null ? 1 : 0;
                if (i11 == t4) {
                    obj6[i11] = 1;
                    i5 = i13 - 1;
                    if (i5 > 0) {
                        t4 = com_ushareit_listenit_bss.m9726t() - 1;
                        i13 = i5;
                    } else {
                        i13 = i5;
                    }
                }
                long j5 = ((long) i6) + j;
                i5 = i3 - 1;
                if (i5 != 0 || i7 <= 0) {
                    i = i6;
                    i6 = i5;
                    i5 = i;
                } else {
                    i6 = com_ushareit_listenit_bss3.m9726t();
                    i5 = com_ushareit_listenit_bss3.m9726t();
                    i7--;
                }
                j4 += (long) obj5[i11];
                i10 = i8 - 1;
                i11++;
                j3 = j4;
                i3 = i6;
                i6 = i5;
                i5 = i10;
                j = j5;
            }
            bsg.m9656a(i12 == 0);
            while (t > 0) {
                bsg.m9656a(com_ushareit_listenit_bss5.m9726t() == 0);
                com_ushareit_listenit_bss5.m9720n();
                t--;
            }
            if (!(i13 == 0 && i3 == 0 && i5 == 0 && i7 == 0)) {
                Log.w("AtomParsers", "Inconsistent stbl box for track " + com_ushareit_listenit_bke.f6718a + ": remainingSynchronizationSamples " + i13 + ", remainingSamplesAtTimestampDelta " + i3 + ", remainingSamplesInChunk " + i5 + ", remainingTimestampDeltaChanges " + i7);
            }
            obj4 = obj6;
            jArr = jArr2;
            i9 = i4;
            obj2 = obj5;
            obj3 = obj;
            j2 = j;
        } else {
            long[] jArr3 = new long[com_ushareit_listenit_bjm.f6622a];
            int[] iArr = new int[com_ushareit_listenit_bjm.f6622a];
            while (com_ushareit_listenit_bjm.m8728a()) {
                jArr3[com_ushareit_listenit_bjm.f6623b] = com_ushareit_listenit_bjm.f6625d;
                iArr[com_ushareit_listenit_bjm.f6623b] = com_ushareit_listenit_bjm.f6624c;
            }
            bjv a2 = bjt.m8741a(com_ushareit_listenit_bjp.mo998b(), jArr3, iArr, (long) t4);
            obj3 = a2.f6650a;
            obj2 = a2.f6651b;
            i9 = a2.f6652c;
            jArr = a2.f6653d;
            obj4 = a2.f6654e;
            j2 = 0;
        }
        if (com_ushareit_listenit_bke.f6726i == null || com_ushareit_listenit_bic.m8552a()) {
            btc.m9768a(jArr, 1000000, com_ushareit_listenit_bke.f6720c);
            return new bkh(obj3, obj2, i9, jArr, obj4);
        }
        long a3;
        if (com_ushareit_listenit_bke.f6726i.length == 1 && com_ushareit_listenit_bke.f6719b == 1 && jArr.length >= 2) {
            long j6 = com_ushareit_listenit_bke.f6727j[0];
            a3 = btc.m9763a(com_ushareit_listenit_bke.f6726i[0], com_ushareit_listenit_bke.f6720c, com_ushareit_listenit_bke.f6721d) + j6;
            if (jArr[0] <= j6 && j6 < jArr[1] && jArr[jArr.length - 1] < a3 && a3 <= j2) {
                j2 -= a3;
                j6 = btc.m9763a(j6 - jArr[0], (long) com_ushareit_listenit_bke.f6723f.f1443q, com_ushareit_listenit_bke.f6720c);
                a3 = btc.m9763a(j2, (long) com_ushareit_listenit_bke.f6723f.f1443q, com_ushareit_listenit_bke.f6720c);
                if (!(j6 == 0 && a3 == 0) && j6 <= 2147483647L && a3 <= 2147483647L) {
                    com_ushareit_listenit_bic.f6393a = (int) j6;
                    com_ushareit_listenit_bic.f6394b = (int) a3;
                    btc.m9768a(jArr, 1000000, com_ushareit_listenit_bke.f6720c);
                    return new bkh(obj3, obj2, i9, jArr, obj4);
                }
            }
        }
        int i14;
        if (com_ushareit_listenit_bke.f6726i.length == 1 && com_ushareit_listenit_bke.f6726i[0] == 0) {
            for (i14 = 0; i14 < jArr.length; i14++) {
                jArr[i14] = btc.m9763a(jArr[i14] - com_ushareit_listenit_bke.f6727j[0], 1000000, com_ushareit_listenit_bke.f6720c);
            }
            return new bkh(obj3, obj2, i9, jArr, obj4);
        }
        long j7;
        Object obj7;
        Object obj8;
        i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i14 < com_ushareit_listenit_bke.f6726i.length) {
            j7 = com_ushareit_listenit_bke.f6727j[i14];
            if (j7 != -1) {
                a3 = btc.m9763a(com_ushareit_listenit_bke.f6726i[i14], com_ushareit_listenit_bke.f6720c, com_ushareit_listenit_bke.f6721d);
                i7 = btc.m9773b(jArr, j7, true, true);
                i5 = btc.m9773b(jArr, a3 + j7, true, false);
                i6 = i17 + (i5 - i7);
                if (i16 != i7) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                i4 |= i15;
            } else {
                i4 = i15;
                i5 = i16;
                i6 = i17;
            }
            i14++;
            i15 = i4;
            i16 = i5;
            i17 = i6;
        }
        t2 = i15 | (i17 != a ? 1 : 0);
        if (t2 != 0) {
            obj7 = new long[i17];
        } else {
            obj7 = obj3;
        }
        if (t2 != 0) {
            obj8 = new int[i17];
        } else {
            obj8 = obj2;
        }
        if (t2 != 0) {
            i6 = 0;
        } else {
            i6 = i9;
        }
        if (t2 != 0) {
            obj = new int[i17];
        } else {
            obj = obj4;
        }
        long[] jArr4 = new long[i17];
        i14 = 0;
        i15 = 0;
        j7 = 0;
        i9 = i6;
        while (i14 < com_ushareit_listenit_bke.f6726i.length) {
            j5 = com_ushareit_listenit_bke.f6727j[i14];
            a3 = com_ushareit_listenit_bke.f6726i[i14];
            if (j5 != -1) {
                j = j5 + btc.m9763a(a3, com_ushareit_listenit_bke.f6720c, com_ushareit_listenit_bke.f6721d);
                i6 = btc.m9773b(jArr, j5, true, true);
                i3 = btc.m9773b(jArr, j, true, false);
                if (t2 != 0) {
                    i7 = i3 - i6;
                    System.arraycopy(obj3, i6, obj7, i15, i7);
                    System.arraycopy(obj2, i6, obj8, i15, i7);
                    System.arraycopy(obj4, i6, obj, i15, i7);
                }
                i17 = i15;
                for (i8 = i6; i8 < i3; i8++) {
                    jArr4[i17] = btc.m9763a(jArr[i8] - j5, 1000000, com_ushareit_listenit_bke.f6720c) + btc.m9763a(j7, 1000000, com_ushareit_listenit_bke.f6721d);
                    if (t2 != 0 && obj8[i17] > i9) {
                        i9 = obj2[i8];
                    }
                    i17++;
                }
                i6 = i9;
                i9 = i17;
            } else {
                i6 = i9;
                i9 = i15;
            }
            i14++;
            i15 = i9;
            j7 = a3 + j7;
            i9 = i6;
        }
        i2 = 0;
        for (i14 = 0; i14 < obj.length && i2 == 0; i14++) {
            i2 |= (obj[i14] & 1) != 0 ? 1 : 0;
        }
        if (i2 != 0) {
            return new bkh(obj7, obj8, i9, jArr4, obj);
        }
        throw new bfw("The edited sample sequence does not contain a sync sample.");
    }

    public static void m8715a(bjk com_ushareit_listenit_bjk, boolean z, bic com_ushareit_listenit_bic) {
        if (!z) {
            bss com_ushareit_listenit_bss = com_ushareit_listenit_bjk.aN;
            com_ushareit_listenit_bss.m9707c(8);
            while (com_ushareit_listenit_bss.m9704b() >= 8) {
                int n = com_ushareit_listenit_bss.m9720n();
                if (com_ushareit_listenit_bss.m9720n() == bji.aA) {
                    com_ushareit_listenit_bss.m9707c(com_ushareit_listenit_bss.m9708d() - 8);
                    com_ushareit_listenit_bss.m9705b(n + com_ushareit_listenit_bss.m9708d());
                    m8718a(com_ushareit_listenit_bss, com_ushareit_listenit_bic);
                    return;
                }
                com_ushareit_listenit_bss.m9709d(n - 8);
            }
        }
    }

    private static void m8718a(bss com_ushareit_listenit_bss, bic com_ushareit_listenit_bic) {
        com_ushareit_listenit_bss.m9709d(12);
        bss com_ushareit_listenit_bss2 = new bss();
        while (com_ushareit_listenit_bss.m9704b() >= 8) {
            int n = com_ushareit_listenit_bss.m9720n() - 8;
            if (com_ushareit_listenit_bss.m9720n() == bji.aB) {
                com_ushareit_listenit_bss2.m9702a(com_ushareit_listenit_bss.f7639a, com_ushareit_listenit_bss.m9708d() + n);
                com_ushareit_listenit_bss2.m9707c(com_ushareit_listenit_bss.m9708d());
                m8722b(com_ushareit_listenit_bss2, com_ushareit_listenit_bic);
                if (com_ushareit_listenit_bic.m8552a()) {
                    return;
                }
            }
            com_ushareit_listenit_bss.m9709d(n);
        }
    }

    private static void m8722b(bss com_ushareit_listenit_bss, bic com_ushareit_listenit_bic) {
        while (com_ushareit_listenit_bss.m9704b() > 0) {
            int d = com_ushareit_listenit_bss.m9708d() + com_ushareit_listenit_bss.m9720n();
            if (com_ushareit_listenit_bss.m9720n() == bji.aL) {
                String str = null;
                String str2 = null;
                Object obj = null;
                while (com_ushareit_listenit_bss.m9708d() < d) {
                    int n = com_ushareit_listenit_bss.m9720n() - 12;
                    int n2 = com_ushareit_listenit_bss.m9720n();
                    com_ushareit_listenit_bss.m9709d(4);
                    if (n2 == bji.aC) {
                        obj = com_ushareit_listenit_bss.m9711e(n);
                    } else if (n2 == bji.aD) {
                        str2 = com_ushareit_listenit_bss.m9711e(n);
                    } else if (n2 == bji.aE) {
                        com_ushareit_listenit_bss.m9709d(4);
                        str = com_ushareit_listenit_bss.m9711e(n - 4);
                    } else {
                        com_ushareit_listenit_bss.m9709d(n);
                    }
                }
                if (!(str2 == null || str == null || !"com.apple.iTunes".equals(r2))) {
                    com_ushareit_listenit_bic.m8554a(str2, str);
                    return;
                }
            }
            com_ushareit_listenit_bss.m9707c(d);
        }
    }

    private static long m8710a(bss com_ushareit_listenit_bss) {
        int i = 8;
        com_ushareit_listenit_bss.m9707c(8);
        if (bji.m8700a(com_ushareit_listenit_bss.m9720n()) != 0) {
            i = 16;
        }
        com_ushareit_listenit_bss.m9709d(i);
        return com_ushareit_listenit_bss.m9718l();
    }

    private static bjr m8721b(bss com_ushareit_listenit_bss) {
        long j;
        int i = 8;
        com_ushareit_listenit_bss.m9707c(8);
        int a = bji.m8700a(com_ushareit_listenit_bss.m9720n());
        com_ushareit_listenit_bss.m9709d(a == 0 ? 8 : 16);
        int n = com_ushareit_listenit_bss.m9720n();
        com_ushareit_listenit_bss.m9709d(4);
        Object obj = 1;
        int d = com_ushareit_listenit_bss.m9708d();
        if (a == 0) {
            i = 4;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (com_ushareit_listenit_bss.f7639a[d + i2] != (byte) -1) {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            com_ushareit_listenit_bss.m9709d(i);
            j = -9223372036854775807L;
        } else {
            j = a == 0 ? com_ushareit_listenit_bss.m9718l() : com_ushareit_listenit_bss.m9728v();
            if (j == 0) {
                j = -9223372036854775807L;
            }
        }
        com_ushareit_listenit_bss.m9709d(16);
        int n2 = com_ushareit_listenit_bss.m9720n();
        int n3 = com_ushareit_listenit_bss.m9720n();
        com_ushareit_listenit_bss.m9709d(4);
        int n4 = com_ushareit_listenit_bss.m9720n();
        int n5 = com_ushareit_listenit_bss.m9720n();
        n2 = (n2 == 0 && n3 == 65536 && n4 == (-65536) && n5 == 0) ? 90 : (n2 == 0 && n3 == (-65536) && n4 == 65536 && n5 == 0) ? 270 : (n2 == (-65536) && n3 == 0 && n4 == 0 && n5 == (-65536)) ? 180 : 0;
        return new bjr(n, j, n2);
    }

    private static int m8723c(bss com_ushareit_listenit_bss) {
        com_ushareit_listenit_bss.m9707c(16);
        int n = com_ushareit_listenit_bss.m9720n();
        if (n == f6616b) {
            return 1;
        }
        if (n == f6615a) {
            return 2;
        }
        if (n == f6617c || n == f6618d || n == f6619e || n == f6620f) {
            return 3;
        }
        return -1;
    }

    private static Pair<Long, String> m8725d(bss com_ushareit_listenit_bss) {
        int i = 8;
        com_ushareit_listenit_bss.m9707c(8);
        int a = bji.m8700a(com_ushareit_listenit_bss.m9720n());
        com_ushareit_listenit_bss.m9709d(a == 0 ? 8 : 16);
        long l = com_ushareit_listenit_bss.m9718l();
        if (a == 0) {
            i = 4;
        }
        com_ushareit_listenit_bss.m9709d(i);
        int h = com_ushareit_listenit_bss.m9714h();
        return Pair.create(Long.valueOf(l), "" + ((char) (((h >> 10) & 31) + 96)) + ((char) (((h >> 5) & 31) + 96)) + ((char) ((h & 31) + 96)));
    }

    private static bjo m8712a(bss com_ushareit_listenit_bss, int i, int i2, String str, DrmInitData drmInitData, boolean z) {
        com_ushareit_listenit_bss.m9707c(12);
        int n = com_ushareit_listenit_bss.m9720n();
        bjo com_ushareit_listenit_bjo = new bjo(n);
        for (int i3 = 0; i3 < n; i3++) {
            int d = com_ushareit_listenit_bss.m9708d();
            int n2 = com_ushareit_listenit_bss.m9720n();
            bsg.m9657a(n2 > 0, "childAtomSize should be positive");
            int n3 = com_ushareit_listenit_bss.m9720n();
            if (n3 == bji.f6590b || n3 == bji.f6591c || n3 == bji.f6587Y || n3 == bji.ak || n3 == bji.f6592d || n3 == bji.f6593e || n3 == bji.f6594f || n3 == bji.aI || n3 == bji.aJ) {
                m8716a(com_ushareit_listenit_bss, n3, d, n2, i, i2, drmInitData, com_ushareit_listenit_bjo, i3);
            } else if (n3 == bji.f6597i || n3 == bji.f6588Z || n3 == bji.f6601m || n3 == bji.f6603o || n3 == bji.f6605q || n3 == bji.f6608t || n3 == bji.f6606r || n3 == bji.f6607s || n3 == bji.ax || n3 == bji.ay || n3 == bji.f6599k || n3 == bji.f6600l) {
                m8717a(com_ushareit_listenit_bss, n3, d, n2, i, str, z, drmInitData, com_ushareit_listenit_bjo, i3);
            } else if (n3 == bji.ai) {
                com_ushareit_listenit_bjo.f6632b = Format.m2069a(Integer.toString(i), "application/ttml+xml", null, -1, 0, str, drmInitData);
            } else if (n3 == bji.at) {
                com_ushareit_listenit_bjo.f6632b = Format.m2069a(Integer.toString(i), "application/x-quicktime-tx3g", null, -1, 0, str, drmInitData);
            } else if (n3 == bji.au) {
                com_ushareit_listenit_bjo.f6632b = Format.m2069a(Integer.toString(i), "application/x-mp4vtt", null, -1, 0, str, drmInitData);
            } else if (n3 == bji.av) {
                com_ushareit_listenit_bjo.f6632b = Format.m2070a(Integer.toString(i), "application/ttml+xml", null, -1, 0, str, drmInitData, 0);
            } else if (n3 == bji.aw) {
                com_ushareit_listenit_bjo.f6632b = Format.m2069a(Integer.toString(i), "application/cea-608", null, -1, 0, str, drmInitData);
                com_ushareit_listenit_bjo.f6634d = 1;
            }
            com_ushareit_listenit_bss.m9707c(d + n2);
        }
        return com_ushareit_listenit_bjo;
    }

    private static void m8716a(bss com_ushareit_listenit_bss, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, bjo com_ushareit_listenit_bjo, int i6) {
        com_ushareit_listenit_bss.m9707c(i2 + 8);
        com_ushareit_listenit_bss.m9709d(24);
        int h = com_ushareit_listenit_bss.m9714h();
        int h2 = com_ushareit_listenit_bss.m9714h();
        Object obj = null;
        float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        com_ushareit_listenit_bss.m9709d(50);
        int d = com_ushareit_listenit_bss.m9708d();
        if (i == bji.f6587Y) {
            i = m8709a(com_ushareit_listenit_bss, i2, i3, com_ushareit_listenit_bjo, i6);
            com_ushareit_listenit_bss.m9707c(d);
        }
        List list = null;
        String str = null;
        byte[] bArr = null;
        int i7 = -1;
        int i8 = d;
        while (i8 - i2 < i3) {
            com_ushareit_listenit_bss.m9707c(i8);
            int d2 = com_ushareit_listenit_bss.m9708d();
            int n = com_ushareit_listenit_bss.m9720n();
            if (n != 0 || com_ushareit_listenit_bss.m9708d() - i2 != i3) {
                Object obj2;
                bsg.m9657a(n > 0, "childAtomSize should be positive");
                d = com_ushareit_listenit_bss.m9720n();
                if (d == bji.f6569G) {
                    bsg.m9658b(str == null);
                    str = "video/avc";
                    com_ushareit_listenit_bss.m9707c(d2 + 8);
                    btf a = btf.m9785a(com_ushareit_listenit_bss);
                    list = a.f7672a;
                    com_ushareit_listenit_bjo.f6633c = a.f7673b;
                    if (obj == null) {
                        f = a.f7676e;
                    }
                    obj2 = obj;
                } else if (d == bji.f6570H) {
                    bsg.m9658b(str == null);
                    str = "video/hevc";
                    com_ushareit_listenit_bss.m9707c(d2 + 8);
                    btg a2 = btg.m9787a(com_ushareit_listenit_bss);
                    list = a2.f7677a;
                    com_ushareit_listenit_bjo.f6633c = a2.f7678b;
                    obj2 = obj;
                } else if (d == bji.aK) {
                    bsg.m9658b(str == null);
                    str = i == bji.aI ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    obj2 = obj;
                } else if (d == bji.f6595g) {
                    bsg.m9658b(str == null);
                    str = "video/3gpp";
                    obj2 = obj;
                } else if (d == bji.f6571I) {
                    bsg.m9658b(str == null);
                    Pair b = m8719b(com_ushareit_listenit_bss, d2);
                    String str2 = (String) b.first;
                    list = Collections.singletonList(b.second);
                    str = str2;
                    obj2 = obj;
                } else if (d == bji.ah) {
                    f = m8707a(com_ushareit_listenit_bss, d2);
                    obj2 = 1;
                } else if (d == bji.aG) {
                    bArr = m8726d(com_ushareit_listenit_bss, d2, n);
                    obj2 = obj;
                } else {
                    if (d == bji.aF) {
                        d = com_ushareit_listenit_bss.m9713g();
                        com_ushareit_listenit_bss.m9709d(3);
                        if (d == 0) {
                            switch (com_ushareit_listenit_bss.m9713g()) {
                                case 0:
                                    i7 = 0;
                                    obj2 = obj;
                                    continue;
                                case 1:
                                    i7 = 1;
                                    obj2 = obj;
                                    continue;
                                case 2:
                                    i7 = 2;
                                    obj2 = obj;
                                    continue;
                            }
                        }
                    }
                    obj2 = obj;
                }
                i8 += n;
                obj = obj2;
            } else if (str == null) {
                com_ushareit_listenit_bjo.f6632b = Format.m2065a(Integer.toString(i4), str, null, -1, -1, h, h2, -1.0f, list, i5, f, bArr, i7, drmInitData);
            }
        }
        if (str == null) {
            com_ushareit_listenit_bjo.f6632b = Format.m2065a(Integer.toString(i4), str, null, -1, -1, h, h2, -1.0f, list, i5, f, bArr, i7, drmInitData);
        }
    }

    private static Pair<long[], long[]> m8711a(bjj com_ushareit_listenit_bjj) {
        if (com_ushareit_listenit_bjj != null) {
            bjk d = com_ushareit_listenit_bjj.m8705d(bji.f6578P);
            if (d != null) {
                bss com_ushareit_listenit_bss = d.aN;
                com_ushareit_listenit_bss.m9707c(8);
                int a = bji.m8700a(com_ushareit_listenit_bss.m9720n());
                int t = com_ushareit_listenit_bss.m9726t();
                Object obj = new long[t];
                Object obj2 = new long[t];
                for (int i = 0; i < t; i++) {
                    obj[i] = a == 1 ? com_ushareit_listenit_bss.m9728v() : com_ushareit_listenit_bss.m9718l();
                    obj2[i] = a == 1 ? com_ushareit_listenit_bss.m9722p() : (long) com_ushareit_listenit_bss.m9720n();
                    if (com_ushareit_listenit_bss.m9716j() != (short) 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    com_ushareit_listenit_bss.m9709d(2);
                }
                return Pair.create(obj, obj2);
            }
        }
        return Pair.create(null, null);
    }

    private static float m8707a(bss com_ushareit_listenit_bss, int i) {
        com_ushareit_listenit_bss.m9707c(i + 8);
        return ((float) com_ushareit_listenit_bss.m9726t()) / ((float) com_ushareit_listenit_bss.m9726t());
    }

    private static void m8717a(bss com_ushareit_listenit_bss, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, bjo com_ushareit_listenit_bjo, int i5) {
        int h;
        int i6;
        int h2;
        com_ushareit_listenit_bss.m9707c(i2 + 8);
        if (z) {
            com_ushareit_listenit_bss.m9709d(8);
            h = com_ushareit_listenit_bss.m9714h();
            com_ushareit_listenit_bss.m9709d(6);
            i6 = h;
        } else {
            com_ushareit_listenit_bss.m9709d(16);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            h2 = com_ushareit_listenit_bss.m9714h();
            com_ushareit_listenit_bss.m9709d(6);
            h = com_ushareit_listenit_bss.m9724r();
            if (i6 == 1) {
                com_ushareit_listenit_bss.m9709d(16);
            }
        } else if (i6 == 2) {
            com_ushareit_listenit_bss.m9709d(16);
            h = (int) Math.round(com_ushareit_listenit_bss.m9729w());
            h2 = com_ushareit_listenit_bss.m9726t();
            com_ushareit_listenit_bss.m9709d(20);
        } else {
            return;
        }
        int d = com_ushareit_listenit_bss.m9708d();
        if (i == bji.f6588Z) {
            i = m8709a(com_ushareit_listenit_bss, i2, i3, com_ushareit_listenit_bjo, i5);
            com_ushareit_listenit_bss.m9707c(d);
        }
        String str2 = null;
        if (i == bji.f6601m) {
            str2 = "audio/ac3";
        } else if (i == bji.f6603o) {
            str2 = "audio/eac3";
        } else if (i == bji.f6605q) {
            str2 = "audio/vnd.dts";
        } else if (i == bji.f6606r || i == bji.f6607s) {
            str2 = "audio/vnd.dts.hd";
        } else if (i == bji.f6608t) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i == bji.ax) {
            str2 = "audio/3gpp";
        } else if (i == bji.ay) {
            str2 = "audio/amr-wb";
        } else if (i == bji.f6599k || i == bji.f6600l) {
            str2 = "audio/raw";
        }
        Object obj = null;
        int i7 = h;
        int i8 = h2;
        String str3 = str2;
        while (d - i2 < i3) {
            com_ushareit_listenit_bss.m9707c(d);
            int n = com_ushareit_listenit_bss.m9720n();
            bsg.m9657a(n > 0, "childAtomSize should be positive");
            h = com_ushareit_listenit_bss.m9720n();
            if (h == bji.f6571I || (z && h == bji.f6598j)) {
                Object obj2;
                if (h == bji.f6571I) {
                    h = d;
                } else {
                    h = m8708a(com_ushareit_listenit_bss, d, n);
                }
                if (h != -1) {
                    Pair b = m8719b(com_ushareit_listenit_bss, h);
                    str3 = (String) b.first;
                    obj2 = (byte[]) b.second;
                    if ("audio/mp4a-latm".equals(str3)) {
                        Pair a = bsh.m9660a(obj2);
                        i7 = ((Integer) a.first).intValue();
                        i8 = ((Integer) a.second).intValue();
                    }
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            } else if (h == bji.f6602n) {
                com_ushareit_listenit_bss.m9707c(d + 8);
                com_ushareit_listenit_bjo.f6632b = bgg.m8231a(com_ushareit_listenit_bss, Integer.toString(i4), str, drmInitData);
            } else if (h == bji.f6604p) {
                com_ushareit_listenit_bss.m9707c(d + 8);
                com_ushareit_listenit_bjo.f6632b = bgg.m8234b(com_ushareit_listenit_bss, Integer.toString(i4), str, drmInitData);
            } else if (h == bji.f6609u) {
                com_ushareit_listenit_bjo.f6632b = Format.m2068a(Integer.toString(i4), str3, null, -1, -1, i8, i7, null, drmInitData, 0, str);
            }
            d += n;
        }
        if (com_ushareit_listenit_bjo.f6632b == null && str3 != null) {
            List list;
            int i9 = "audio/raw".equals(str3) ? 2 : -1;
            String num = Integer.toString(i4);
            if (obj == null) {
                list = null;
            } else {
                list = Collections.singletonList(obj);
            }
            com_ushareit_listenit_bjo.f6632b = Format.m2067a(num, str3, null, -1, -1, i8, i7, i9, list, drmInitData, 0, str);
        }
    }

    private static int m8708a(bss com_ushareit_listenit_bss, int i, int i2) {
        int d = com_ushareit_listenit_bss.m9708d();
        while (d - i < i2) {
            com_ushareit_listenit_bss.m9707c(d);
            int n = com_ushareit_listenit_bss.m9720n();
            bsg.m9657a(n > 0, "childAtomSize should be positive");
            if (com_ushareit_listenit_bss.m9720n() == bji.f6571I) {
                return d;
            }
            d += n;
        }
        return -1;
    }

    private static Pair<String, byte[]> m8719b(bss com_ushareit_listenit_bss, int i) {
        Object obj = null;
        com_ushareit_listenit_bss.m9707c((i + 8) + 4);
        com_ushareit_listenit_bss.m9709d(1);
        m8727e(com_ushareit_listenit_bss);
        com_ushareit_listenit_bss.m9709d(2);
        int g = com_ushareit_listenit_bss.m9713g();
        if ((g & 128) != 0) {
            com_ushareit_listenit_bss.m9709d(2);
        }
        if ((g & 64) != 0) {
            com_ushareit_listenit_bss.m9709d(com_ushareit_listenit_bss.m9714h());
        }
        if ((g & 32) != 0) {
            com_ushareit_listenit_bss.m9709d(2);
        }
        com_ushareit_listenit_bss.m9709d(1);
        m8727e(com_ushareit_listenit_bss);
        switch (com_ushareit_listenit_bss.m9713g()) {
            case C0154a.f2957m /*32*/:
                obj = "video/mp4v-es";
                break;
            case 33:
                obj = "video/avc";
                break;
            case 35:
                obj = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                obj = "audio/mp4a-latm";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                obj = "audio/ac3";
                break;
            case 166:
                obj = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        com_ushareit_listenit_bss.m9709d(12);
        com_ushareit_listenit_bss.m9709d(1);
        g = m8727e(com_ushareit_listenit_bss);
        Object obj2 = new byte[g];
        com_ushareit_listenit_bss.m9703a(obj2, 0, g);
        return Pair.create(obj, obj2);
    }

    private static int m8709a(bss com_ushareit_listenit_bss, int i, int i2, bjo com_ushareit_listenit_bjo, int i3) {
        int d = com_ushareit_listenit_bss.m9708d();
        while (d - i < i2) {
            com_ushareit_listenit_bss.m9707c(d);
            int n = com_ushareit_listenit_bss.m9720n();
            bsg.m9657a(n > 0, "childAtomSize should be positive");
            if (com_ushareit_listenit_bss.m9720n() == bji.f6583U) {
                Pair b = m8720b(com_ushareit_listenit_bss, d, n);
                if (b != null) {
                    com_ushareit_listenit_bjo.f6631a[i3] = (bkf) b.second;
                    return ((Integer) b.first).intValue();
                }
            }
            d += n;
        }
        return 0;
    }

    private static Pair<Integer, bkf> m8720b(bss com_ushareit_listenit_bss, int i, int i2) {
        boolean z = true;
        Object obj = null;
        boolean z2 = false;
        int i3 = i + 8;
        Object obj2 = null;
        while (i3 - i < i2) {
            com_ushareit_listenit_bss.m9707c(i3);
            int n = com_ushareit_listenit_bss.m9720n();
            int n2 = com_ushareit_listenit_bss.m9720n();
            if (n2 == bji.aa) {
                obj2 = Integer.valueOf(com_ushareit_listenit_bss.m9720n());
            } else if (n2 == bji.f6584V) {
                com_ushareit_listenit_bss.m9709d(4);
                z2 = com_ushareit_listenit_bss.m9720n() == f6621g;
            } else if (n2 == bji.f6585W) {
                obj = m8724c(com_ushareit_listenit_bss, i3, n);
            }
            i3 += n;
        }
        if (!z2) {
            return null;
        }
        if (obj2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        bsg.m9657a(z2, "frma atom is mandatory");
        if (obj == null) {
            z = false;
        }
        bsg.m9657a(z, "schi->tenc atom is mandatory");
        return Pair.create(obj2, obj);
    }

    private static bkf m8724c(bss com_ushareit_listenit_bss, int i, int i2) {
        boolean z = true;
        int i3 = i + 8;
        while (i3 - i < i2) {
            com_ushareit_listenit_bss.m9707c(i3);
            int n = com_ushareit_listenit_bss.m9720n();
            if (com_ushareit_listenit_bss.m9720n() == bji.f6586X) {
                com_ushareit_listenit_bss.m9709d(6);
                if (com_ushareit_listenit_bss.m9713g() != 1) {
                    z = false;
                }
                i3 = com_ushareit_listenit_bss.m9713g();
                byte[] bArr = new byte[16];
                com_ushareit_listenit_bss.m9703a(bArr, 0, bArr.length);
                return new bkf(z, i3, bArr);
            }
            i3 += n;
        }
        return null;
    }

    private static byte[] m8726d(bss com_ushareit_listenit_bss, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            com_ushareit_listenit_bss.m9707c(i3);
            int n = com_ushareit_listenit_bss.m9720n();
            if (com_ushareit_listenit_bss.m9720n() == bji.aH) {
                return Arrays.copyOfRange(com_ushareit_listenit_bss.f7639a, i3, n + i3);
            }
            i3 += n;
        }
        return null;
    }

    private static int m8727e(bss com_ushareit_listenit_bss) {
        int g = com_ushareit_listenit_bss.m9713g();
        int i = g & 127;
        while ((g & 128) == 128) {
            g = com_ushareit_listenit_bss.m9713g();
            i = (i << 7) | (g & 127);
        }
        return i;
    }
}
