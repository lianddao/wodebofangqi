package com.ushareit.listenit;

import android.util.SparseArray;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.umeng.analytics.pro.C0277j;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

public final class biv implements bhy {
    public static final bib f6448a = new biw();
    private static final byte[] f6449b = new byte[]{(byte) 49, (byte) 10, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 32, (byte) 45, (byte) 45, (byte) 62, (byte) 32, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 10};
    private static final byte[] f6450c = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    private static final UUID f6451d = new UUID(72057594037932032L, -9223371306706625679L);
    private boolean f6452A;
    private long f6453B;
    private long f6454C;
    private long f6455D;
    private bsl f6456E;
    private bsl f6457F;
    private boolean f6458G;
    private int f6459H;
    private long f6460I;
    private long f6461J;
    private int f6462K;
    private int f6463L;
    private int[] f6464M;
    private int f6465N;
    private int f6466O;
    private int f6467P;
    private int f6468Q;
    private boolean f6469R;
    private boolean f6470S;
    private boolean f6471T;
    private boolean f6472U;
    private byte f6473V;
    private int f6474W;
    private int f6475X;
    private int f6476Y;
    private boolean f6477Z;
    private boolean aa;
    private bia ab;
    private final bit f6478e;
    private final bja f6479f;
    private final SparseArray<biy> f6480g;
    private final bss f6481h;
    private final bss f6482i;
    private final bss f6483j;
    private final bss f6484k;
    private final bss f6485l;
    private final bss f6486m;
    private final bss f6487n;
    private final bss f6488o;
    private final bss f6489p;
    private ByteBuffer f6490q;
    private long f6491r;
    private long f6492s;
    private long f6493t;
    private long f6494u;
    private long f6495v;
    private biy f6496w;
    private boolean f6497x;
    private int f6498y;
    private long f6499z;

    public biv() {
        this(new biq());
    }

    biv(bit com_ushareit_listenit_bit) {
        this.f6492s = -1;
        this.f6493t = -9223372036854775807L;
        this.f6494u = -9223372036854775807L;
        this.f6495v = -9223372036854775807L;
        this.f6453B = -1;
        this.f6454C = -1;
        this.f6455D = -9223372036854775807L;
        this.f6478e = com_ushareit_listenit_bit;
        this.f6478e.mo985a(new bix());
        this.f6479f = new bja();
        this.f6480g = new SparseArray();
        this.f6483j = new bss(4);
        this.f6484k = new bss(ByteBuffer.allocate(4).putInt(-1).array());
        this.f6485l = new bss(4);
        this.f6481h = new bss(bso.f7618a);
        this.f6482i = new bss(4);
        this.f6486m = new bss();
        this.f6487n = new bss();
        this.f6488o = new bss(8);
        this.f6489p = new bss();
    }

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        return new biz().m8661a(com_ushareit_listenit_bhz);
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        this.ab = com_ushareit_listenit_bia;
    }

    public void mo980a(long j) {
        this.f6455D = -9223372036854775807L;
        this.f6459H = 0;
        this.f6478e.mo984a();
        this.f6479f.m8665a();
        m8631b();
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        this.f6477Z = false;
        boolean z = true;
        while (z && !this.f6477Z) {
            z = this.f6478e.mo986a(com_ushareit_listenit_bhz);
            if (z && m8627a(com_ushareit_listenit_bie, com_ushareit_listenit_bhz.mo968c())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        return -1;
    }

    int m8633a(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case C0277j.f3691b /*160*/:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
                return 5;
            default:
                return 0;
        }
    }

    boolean m8643b(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    void m8638a(int i, long j, long j2) {
        switch (i) {
            case C0277j.f3691b /*160*/:
                this.aa = false;
                return;
            case 174:
                this.f6496w = new biy();
                return;
            case 187:
                this.f6458G = false;
                return;
            case 19899:
                this.f6498y = -1;
                this.f6499z = -1;
                return;
            case 20533:
                this.f6496w.f6505e = true;
                return;
            case 408125543:
                if (this.f6492s == -1 || this.f6492s == j) {
                    this.f6492s = j;
                    this.f6491r = j2;
                    return;
                }
                throw new bfw("Multiple Segment elements not supported");
            case 475249515:
                this.f6456E = new bsl();
                this.f6457F = new bsl();
                return;
            case 524531317:
                if (!this.f6497x) {
                    if (this.f6453B != -1) {
                        this.f6452A = true;
                        return;
                    }
                    this.ab.mo1028a(new big(this.f6495v));
                    this.f6497x = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    void m8645c(int i) {
        switch (i) {
            case C0277j.f3691b /*160*/:
                if (this.f6459H == 2) {
                    if (!this.aa) {
                        this.f6467P |= 1;
                    }
                    m8625a((biy) this.f6480g.get(this.f6465N), this.f6460I);
                    this.f6459H = 0;
                    return;
                }
                return;
            case 174:
                if (this.f6480g.get(this.f6496w.f6502b) == null && m8628a(this.f6496w.f6501a)) {
                    this.f6496w.m8659a(this.ab, this.f6496w.f6502b);
                    this.f6480g.put(this.f6496w.f6502b, this.f6496w);
                }
                this.f6496w = null;
                return;
            case 19899:
                if (this.f6498y == -1 || this.f6499z == -1) {
                    throw new bfw("Mandatory element SeekID or SeekPosition not found");
                } else if (this.f6498y == 475249515) {
                    this.f6453B = this.f6499z;
                    return;
                } else {
                    return;
                }
            case 25152:
                if (!this.f6496w.f6505e) {
                    return;
                }
                if (this.f6496w.f6507g == null) {
                    throw new bfw("Encrypted Track found but ContentEncKeyID was not found");
                }
                this.f6496w.f6509i = new DrmInitData(new SchemeData(bfg.f6044b, "video/webm", this.f6496w.f6507g));
                return;
            case 28032:
                if (this.f6496w.f6505e && this.f6496w.f6506f != null) {
                    throw new bfw("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.f6493t == -9223372036854775807L) {
                    this.f6493t = 1000000;
                }
                if (this.f6494u != -9223372036854775807L) {
                    this.f6495v = m8630b(this.f6494u);
                    return;
                }
                return;
            case 374648427:
                if (this.f6480g.size() == 0) {
                    throw new bfw("No valid tracks were found");
                }
                this.ab.mo1026a();
                return;
            case 475249515:
                if (!this.f6497x) {
                    this.ab.mo1028a(m8632d());
                    this.f6497x = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    void m8637a(int i, long j) {
        boolean z = true;
        biy com_ushareit_listenit_biy;
        switch (i) {
            case 131:
                this.f6496w.f6503c = (int) j;
                return;
            case 136:
                com_ushareit_listenit_biy = this.f6496w;
                if (j != 1) {
                    z = false;
                }
                com_ushareit_listenit_biy.f6522v = z;
                return;
            case 155:
                this.f6461J = m8630b(j);
                return;
            case 159:
                this.f6496w.f6517q = (int) j;
                return;
            case 176:
                this.f6496w.f6510j = (int) j;
                return;
            case 179:
                this.f6456E.m9675a(m8630b(j));
                return;
            case 186:
                this.f6496w.f6511k = (int) j;
                return;
            case 215:
                this.f6496w.f6502b = (int) j;
                return;
            case 231:
                this.f6455D = m8630b(j);
                return;
            case 241:
                if (!this.f6458G) {
                    this.f6457F.m9675a(j);
                    this.f6458G = true;
                    return;
                }
                return;
            case 251:
                this.aa = true;
                return;
            case 16980:
                if (j != 3) {
                    throw new bfw("ContentCompAlgo " + j + " not supported");
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    throw new bfw("DocTypeReadVersion " + j + " not supported");
                }
                return;
            case 17143:
                if (j != 1) {
                    throw new bfw("EBMLReadVersion " + j + " not supported");
                }
                return;
            case 18401:
                if (j != 5) {
                    throw new bfw("ContentEncAlgo " + j + " not supported");
                }
                return;
            case 18408:
                if (j != 1) {
                    throw new bfw("AESSettingsCipherMode " + j + " not supported");
                }
                return;
            case 20529:
                if (j != 0) {
                    throw new bfw("ContentEncodingOrder " + j + " not supported");
                }
                return;
            case 20530:
                if (j != 1) {
                    throw new bfw("ContentEncodingScope " + j + " not supported");
                }
                return;
            case 21420:
                this.f6499z = this.f6492s + j;
                return;
            case 21432:
                switch ((int) j) {
                    case 0:
                        this.f6496w.f6516p = 0;
                        return;
                    case 1:
                        this.f6496w.f6516p = 2;
                        return;
                    case 3:
                        this.f6496w.f6516p = 1;
                        return;
                    default:
                        return;
                }
            case 21680:
                this.f6496w.f6512l = (int) j;
                return;
            case 21682:
                this.f6496w.f6514n = (int) j;
                return;
            case 21690:
                this.f6496w.f6513m = (int) j;
                return;
            case 21930:
                com_ushareit_listenit_biy = this.f6496w;
                if (j != 1) {
                    z = false;
                }
                com_ushareit_listenit_biy.f6523w = z;
                return;
            case 22186:
                this.f6496w.f6520t = j;
                return;
            case 22203:
                this.f6496w.f6521u = j;
                return;
            case 25188:
                this.f6496w.f6518r = (int) j;
                return;
            case 2352003:
                this.f6496w.f6504d = (int) j;
                return;
            case 2807729:
                this.f6493t = j;
                return;
            default:
                return;
        }
    }

    void m8635a(int i, double d) {
        switch (i) {
            case 181:
                this.f6496w.f6519s = (int) d;
                return;
            case 17545:
                this.f6494u = (long) d;
                return;
            default:
                return;
        }
    }

    void m8639a(int i, String str) {
        switch (i) {
            case 134:
                this.f6496w.f6501a = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new bfw("DocType " + str + " not supported");
                }
                return;
            case 2274716:
                this.f6496w.f6526z = str;
                return;
            default:
                return;
        }
    }

    void m8636a(int i, int i2, bhz com_ushareit_listenit_bhz) {
        switch (i) {
            case 161:
            case 163:
                if (this.f6459H == 0) {
                    this.f6465N = (int) this.f6479f.m8664a(com_ushareit_listenit_bhz, false, true, 8);
                    this.f6466O = this.f6479f.m8666b();
                    this.f6461J = -9223372036854775807L;
                    this.f6459H = 1;
                    this.f6483j.m9699a();
                }
                biy com_ushareit_listenit_biy = (biy) this.f6480g.get(this.f6465N);
                if (com_ushareit_listenit_biy == null) {
                    com_ushareit_listenit_bhz.mo965b(i2 - this.f6466O);
                    this.f6459H = 0;
                    return;
                }
                if (this.f6459H == 1) {
                    int i3;
                    m8621a(com_ushareit_listenit_bhz, 3);
                    int i4 = (this.f6483j.f7639a[2] & 6) >> 1;
                    if (i4 == 0) {
                        this.f6463L = 1;
                        this.f6464M = m8629a(this.f6464M, 1);
                        this.f6464M[0] = (i2 - this.f6466O) - 3;
                    } else if (i != 163) {
                        throw new bfw("Lacing only supported in SimpleBlocks.");
                    } else {
                        m8621a(com_ushareit_listenit_bhz, 4);
                        this.f6463L = (this.f6483j.f7639a[3] & 255) + 1;
                        this.f6464M = m8629a(this.f6464M, this.f6463L);
                        if (i4 == 2) {
                            Arrays.fill(this.f6464M, 0, this.f6463L, ((i2 - this.f6466O) - 4) / this.f6463L);
                        } else if (i4 == 1) {
                            r5 = 0;
                            i3 = 4;
                            for (i4 = 0; i4 < this.f6463L - 1; i4++) {
                                this.f6464M[i4] = 0;
                                do {
                                    i3++;
                                    m8621a(com_ushareit_listenit_bhz, i3);
                                    r6 = this.f6483j.f7639a[i3 - 1] & 255;
                                    r7 = this.f6464M;
                                    r7[i4] = r7[i4] + r6;
                                } while (r6 == 255);
                                r5 += this.f6464M[i4];
                            }
                            this.f6464M[this.f6463L - 1] = ((i2 - this.f6466O) - i3) - r5;
                        } else if (i4 == 3) {
                            r5 = 0;
                            i3 = 4;
                            i4 = 0;
                            while (i4 < this.f6463L - 1) {
                                this.f6464M[i4] = 0;
                                i3++;
                                m8621a(com_ushareit_listenit_bhz, i3);
                                if (this.f6483j.f7639a[i3 - 1] == (byte) 0) {
                                    throw new bfw("No valid varint length mask found");
                                }
                                long j = 0;
                                int i5 = 0;
                                while (i5 < 8) {
                                    int i6 = 1 << (7 - i5);
                                    if ((this.f6483j.f7639a[i3 - 1] & i6) != 0) {
                                        int i7 = i3 - 1;
                                        i3 += i5;
                                        m8621a(com_ushareit_listenit_bhz, i3);
                                        j = (long) ((this.f6483j.f7639a[i7] & 255) & (i6 ^ -1));
                                        for (i6 = i7 + 1; i6 < i3; i6++) {
                                            j = ((long) (this.f6483j.f7639a[i6] & 255)) | (j << 8);
                                        }
                                        if (i4 > 0) {
                                            j -= (1 << ((i5 * 7) + 6)) - 1;
                                        }
                                        if (j >= -2147483648L || j > 2147483647L) {
                                            throw new bfw("EBML lacing sample size out of range.");
                                        }
                                        r6 = (int) j;
                                        r7 = this.f6464M;
                                        if (i4 != 0) {
                                            r6 += this.f6464M[i4 - 1];
                                        }
                                        r7[i4] = r6;
                                        r5 += this.f6464M[i4];
                                        i4++;
                                    } else {
                                        i5++;
                                    }
                                }
                                if (j >= -2147483648L) {
                                    break;
                                }
                                throw new bfw("EBML lacing sample size out of range.");
                            }
                            this.f6464M[this.f6463L - 1] = ((i2 - this.f6466O) - i3) - r5;
                        } else {
                            throw new bfw("Unexpected lacing value: " + i4);
                        }
                    }
                    this.f6460I = this.f6455D + m8630b((long) ((this.f6483j.f7639a[0] << 8) | (this.f6483j.f7639a[1] & 255)));
                    Object obj = (this.f6483j.f7639a[2] & 8) == 8 ? 1 : null;
                    Object obj2 = (com_ushareit_listenit_biy.f6503c == 2 || (i == 163 && (this.f6483j.f7639a[2] & 128) == 128)) ? 1 : null;
                    i3 = obj2 != null ? 1 : 0;
                    if (obj != null) {
                        i4 = Integer.MIN_VALUE;
                    } else {
                        i4 = 0;
                    }
                    this.f6467P = i4 | i3;
                    this.f6459H = 2;
                    this.f6462K = 0;
                }
                if (i == 163) {
                    while (this.f6462K < this.f6463L) {
                        m8622a(com_ushareit_listenit_bhz, com_ushareit_listenit_biy, this.f6464M[this.f6462K]);
                        m8625a(com_ushareit_listenit_biy, this.f6460I + ((long) ((this.f6462K * com_ushareit_listenit_biy.f6504d) / 1000)));
                        this.f6462K++;
                    }
                    this.f6459H = 0;
                    return;
                }
                m8622a(com_ushareit_listenit_bhz, com_ushareit_listenit_biy, this.f6464M[0]);
                return;
            case 16981:
                this.f6496w.f6506f = new byte[i2];
                com_ushareit_listenit_bhz.mo966b(this.f6496w.f6506f, 0, i2);
                return;
            case 18402:
                this.f6496w.f6507g = new byte[i2];
                com_ushareit_listenit_bhz.mo966b(this.f6496w.f6507g, 0, i2);
                return;
            case 21419:
                Arrays.fill(this.f6485l.f7639a, (byte) 0);
                com_ushareit_listenit_bhz.mo966b(this.f6485l.f7639a, 4 - i2, i2);
                this.f6485l.m9707c(0);
                this.f6498y = (int) this.f6485l.m9718l();
                return;
            case 25506:
                this.f6496w.f6508h = new byte[i2];
                com_ushareit_listenit_bhz.mo966b(this.f6496w.f6508h, 0, i2);
                return;
            case 30322:
                this.f6496w.f6515o = new byte[i2];
                com_ushareit_listenit_bhz.mo966b(this.f6496w.f6515o, 0, i2);
                return;
            default:
                throw new bfw("Unexpected id: " + i);
        }
    }

    private void m8625a(biy com_ushareit_listenit_biy, long j) {
        if ("S_TEXT/UTF8".equals(com_ushareit_listenit_biy.f6501a)) {
            m8624a(com_ushareit_listenit_biy);
        }
        com_ushareit_listenit_biy.f6524x.mo974a(j, this.f6467P, this.f6476Y, 0, com_ushareit_listenit_biy.f6507g);
        this.f6477Z = true;
        m8631b();
    }

    private void m8631b() {
        this.f6468Q = 0;
        this.f6476Y = 0;
        this.f6475X = 0;
        this.f6469R = false;
        this.f6470S = false;
        this.f6472U = false;
        this.f6474W = 0;
        this.f6473V = (byte) 0;
        this.f6471T = false;
        this.f6486m.m9699a();
    }

    private void m8621a(bhz com_ushareit_listenit_bhz, int i) {
        if (this.f6483j.m9706c() < i) {
            if (this.f6483j.m9710e() < i) {
                this.f6483j.m9702a(Arrays.copyOf(this.f6483j.f7639a, Math.max(this.f6483j.f7639a.length * 2, i)), this.f6483j.m9706c());
            }
            com_ushareit_listenit_bhz.mo966b(this.f6483j.f7639a, this.f6483j.m9706c(), i - this.f6483j.m9706c());
            this.f6483j.m9705b(i);
        }
    }

    private void m8622a(bhz com_ushareit_listenit_bhz, biy com_ushareit_listenit_biy, int i) {
        int length;
        if ("S_TEXT/UTF8".equals(com_ushareit_listenit_biy.f6501a)) {
            length = f6449b.length + i;
            if (this.f6487n.m9710e() < length) {
                this.f6487n.f7639a = Arrays.copyOf(f6449b, length + i);
            }
            com_ushareit_listenit_bhz.mo966b(this.f6487n.f7639a, f6449b.length, i);
            this.f6487n.m9707c(0);
            this.f6487n.m9705b(length);
            return;
        }
        int t;
        bii com_ushareit_listenit_bii = com_ushareit_listenit_biy.f6524x;
        if (!this.f6469R) {
            if (com_ushareit_listenit_biy.f6505e) {
                this.f6467P &= -1073741825;
                if (!this.f6470S) {
                    com_ushareit_listenit_bhz.mo966b(this.f6483j.f7639a, 0, 1);
                    this.f6468Q++;
                    if ((this.f6483j.f7639a[0] & 128) == 128) {
                        throw new bfw("Extension bit is set in signal byte");
                    }
                    this.f6473V = this.f6483j.f7639a[0];
                    this.f6470S = true;
                }
                if ((this.f6473V & 1) == 1) {
                    boolean z;
                    int i2;
                    if ((this.f6473V & 2) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.f6467P |= 1073741824;
                    if (!this.f6471T) {
                        com_ushareit_listenit_bhz.mo966b(this.f6488o.f7639a, 0, 8);
                        this.f6468Q += 8;
                        this.f6471T = true;
                        byte[] bArr = this.f6483j.f7639a;
                        if (z) {
                            i2 = 128;
                        } else {
                            i2 = 0;
                        }
                        bArr[0] = (byte) (i2 | 8);
                        this.f6483j.m9707c(0);
                        com_ushareit_listenit_bii.mo976a(this.f6483j, 1);
                        this.f6476Y++;
                        this.f6488o.m9707c(0);
                        com_ushareit_listenit_bii.mo976a(this.f6488o, 8);
                        this.f6476Y += 8;
                    }
                    if (z) {
                        if (!this.f6472U) {
                            com_ushareit_listenit_bhz.mo966b(this.f6483j.f7639a, 0, 1);
                            this.f6468Q++;
                            this.f6483j.m9707c(0);
                            this.f6474W = this.f6483j.m9713g();
                            this.f6472U = true;
                        }
                        length = this.f6474W * 4;
                        this.f6483j.m9700a(length);
                        com_ushareit_listenit_bhz.mo966b(this.f6483j.f7639a, 0, length);
                        this.f6468Q = length + this.f6468Q;
                        short s = (short) ((this.f6474W / 2) + 1);
                        int i3 = (s * 6) + 2;
                        if (this.f6490q == null || this.f6490q.capacity() < i3) {
                            this.f6490q = ByteBuffer.allocate(i3);
                        }
                        this.f6490q.position(0);
                        this.f6490q.putShort(s);
                        length = 0;
                        i2 = 0;
                        while (length < this.f6474W) {
                            t = this.f6483j.m9726t();
                            if (length % 2 == 0) {
                                this.f6490q.putShort((short) (t - i2));
                            } else {
                                this.f6490q.putInt(t - i2);
                            }
                            length++;
                            i2 = t;
                        }
                        length = (i - this.f6468Q) - i2;
                        if (this.f6474W % 2 == 1) {
                            this.f6490q.putInt(length);
                        } else {
                            this.f6490q.putShort((short) length);
                            this.f6490q.putInt(0);
                        }
                        this.f6489p.m9702a(this.f6490q.array(), i3);
                        com_ushareit_listenit_bii.mo976a(this.f6489p, i3);
                        this.f6476Y += i3;
                    }
                }
            } else if (com_ushareit_listenit_biy.f6506f != null) {
                this.f6486m.m9702a(com_ushareit_listenit_biy.f6506f, com_ushareit_listenit_biy.f6506f.length);
            }
            this.f6469R = true;
        }
        length = this.f6486m.m9706c() + i;
        if ("V_MPEG4/ISO/AVC".equals(com_ushareit_listenit_biy.f6501a) || "V_MPEGH/ISO/HEVC".equals(com_ushareit_listenit_biy.f6501a)) {
            byte[] bArr2 = this.f6482i.f7639a;
            bArr2[0] = (byte) 0;
            bArr2[1] = (byte) 0;
            bArr2[2] = (byte) 0;
            int i4 = com_ushareit_listenit_biy.f6525y;
            t = 4 - com_ushareit_listenit_biy.f6525y;
            while (this.f6468Q < length) {
                if (this.f6475X == 0) {
                    m8623a(com_ushareit_listenit_bhz, bArr2, t, i4);
                    this.f6482i.m9707c(0);
                    this.f6475X = this.f6482i.m9726t();
                    this.f6481h.m9707c(0);
                    com_ushareit_listenit_bii.mo976a(this.f6481h, 4);
                    this.f6476Y += 4;
                } else {
                    this.f6475X -= m8619a(com_ushareit_listenit_bhz, com_ushareit_listenit_bii, this.f6475X);
                }
            }
        } else {
            while (this.f6468Q < length) {
                m8619a(com_ushareit_listenit_bhz, com_ushareit_listenit_bii, length - this.f6468Q);
            }
        }
        if ("A_VORBIS".equals(com_ushareit_listenit_biy.f6501a)) {
            this.f6484k.m9707c(0);
            com_ushareit_listenit_bii.mo976a(this.f6484k, 4);
            this.f6476Y += 4;
        }
    }

    private void m8624a(biy com_ushareit_listenit_biy) {
        m8626a(this.f6487n.f7639a, this.f6461J);
        com_ushareit_listenit_biy.f6524x.mo976a(this.f6487n, this.f6487n.m9706c());
        this.f6476Y += this.f6487n.m9706c();
    }

    private static void m8626a(byte[] bArr, long j) {
        Object obj;
        if (j == -9223372036854775807L) {
            obj = f6450c;
        } else {
            long j2 = j - (((long) ((int) (j / 3600000000L))) * 3600000000L);
            j2 -= (long) (60000000 * ((int) (j2 / 60000000)));
            int i = (int) ((j2 - ((long) (1000000 * ((int) (j2 / 1000000))))) / 1000);
            obj = btc.m9775c(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf((int) (j / 3600000000L)), Integer.valueOf(r1), Integer.valueOf(r4), Integer.valueOf(i)}));
        }
        System.arraycopy(obj, 0, bArr, 19, 12);
    }

    private void m8623a(bhz com_ushareit_listenit_bhz, byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.f6486m.m9704b());
        com_ushareit_listenit_bhz.mo966b(bArr, i + min, i2 - min);
        if (min > 0) {
            this.f6486m.m9703a(bArr, i, min);
        }
        this.f6468Q += i2;
    }

    private int m8619a(bhz com_ushareit_listenit_bhz, bii com_ushareit_listenit_bii, int i) {
        int b = this.f6486m.m9704b();
        if (b > 0) {
            b = Math.min(i, b);
            com_ushareit_listenit_bii.mo976a(this.f6486m, b);
        } else {
            b = com_ushareit_listenit_bii.mo973a(com_ushareit_listenit_bhz, i, false);
        }
        this.f6468Q += b;
        this.f6476Y += b;
        return b;
    }

    private bif m8632d() {
        int i = 0;
        if (this.f6492s == -1 || this.f6495v == -9223372036854775807L || this.f6456E == null || this.f6456E.m9673a() == 0 || this.f6457F == null || this.f6457F.m9673a() != this.f6456E.m9673a()) {
            this.f6456E = null;
            this.f6457F = null;
            return new big(this.f6495v);
        }
        int a = this.f6456E.m9673a();
        int[] iArr = new int[a];
        long[] jArr = new long[a];
        long[] jArr2 = new long[a];
        long[] jArr3 = new long[a];
        for (int i2 = 0; i2 < a; i2++) {
            jArr3[i2] = this.f6456E.m9674a(i2);
            jArr[i2] = this.f6492s + this.f6457F.m9674a(i2);
        }
        while (i < a - 1) {
            iArr[i] = (int) (jArr[i + 1] - jArr[i]);
            jArr2[i] = jArr3[i + 1] - jArr3[i];
            i++;
        }
        iArr[a - 1] = (int) ((this.f6492s + this.f6491r) - jArr[a - 1]);
        jArr2[a - 1] = this.f6495v - jArr3[a - 1];
        this.f6456E = null;
        this.f6457F = null;
        return new bhp(iArr, jArr, jArr2, jArr3);
    }

    private boolean m8627a(bie com_ushareit_listenit_bie, long j) {
        if (this.f6452A) {
            this.f6454C = j;
            com_ushareit_listenit_bie.f6409a = this.f6453B;
            this.f6452A = false;
            return true;
        } else if (!this.f6497x || this.f6454C == -1) {
            return false;
        } else {
            com_ushareit_listenit_bie.f6409a = this.f6454C;
            this.f6454C = -1;
            return true;
        }
    }

    private long m8630b(long j) {
        if (this.f6493t == -9223372036854775807L) {
            throw new bfw("Can't scale timecode prior to timecodeScale being set.");
        }
        return btc.m9763a(j, this.f6493t, 1000);
    }

    private static boolean m8628a(String str) {
        if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str)) {
            return true;
        }
        return false;
    }

    private static int[] m8629a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length < i ? new int[Math.max(iArr.length * 2, i)] : iArr;
    }
}
