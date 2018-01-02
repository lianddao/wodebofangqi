package com.ushareit.listenit;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.umeng.analytics.pro.C0277j;

class us {
    protected int f16987a;
    protected byte[] f16988b;
    protected int f16989c;
    protected int f16990d;
    protected int[][] f16991e;
    protected int[] f16992f = new int[C0277j.f3694e];
    protected int[] f16993g = new int[C0277j.f3694e];
    protected int[] f16994h = new int[C0277j.f3694e];
    protected int[] f16995i = new int[32];

    public us(byte[] bArr, int i, int i2) {
        this.f16988b = bArr;
        this.f16989c = i;
        this.f16990d = i2;
        this.f16991e = new int[C0277j.f3694e][];
        for (int i3 = 0; i3 < C0277j.f3694e; i3++) {
            this.f16991e[i3] = new int[4];
            int[] iArr = this.f16991e[i3];
            int i4 = (i3 << 12) / C0277j.f3694e;
            iArr[2] = i4;
            iArr[1] = i4;
            iArr[0] = i4;
            this.f16994h[i3] = C0277j.f3694e;
            this.f16993g[i3] = 0;
        }
    }

    public byte[] m26610a() {
        int i;
        byte[] bArr = new byte[768];
        int[] iArr = new int[C0277j.f3694e];
        for (i = 0; i < C0277j.f3694e; i++) {
            iArr[this.f16991e[i][3]] = i;
        }
        int i2 = 0;
        for (i = 0; i < C0277j.f3694e; i++) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            bArr[i2] = (byte) this.f16991e[i3][0];
            int i5 = i4 + 1;
            bArr[i4] = (byte) this.f16991e[i3][1];
            i2 = i5 + 1;
            bArr[i5] = (byte) this.f16991e[i3][2];
        }
        return bArr;
    }

    public void m26612b() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < C0277j.f3694e) {
            int[] iArr = this.f16991e[i3];
            int i4 = iArr[1];
            int i5 = i3;
            for (int i6 = i3 + 1; i6 < C0277j.f3694e; i6++) {
                int[] iArr2 = this.f16991e[i6];
                if (iArr2[1] < i4) {
                    i4 = iArr2[1];
                    i5 = i6;
                }
            }
            int[] iArr3 = this.f16991e[i5];
            if (i3 != i5) {
                i5 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i5;
                i5 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i5;
                i5 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i5;
                i5 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i5;
            }
            if (i4 != i2) {
                this.f16992f[i2] = (i + i3) >> 1;
                for (i5 = i2 + 1; i5 < i4; i5++) {
                    this.f16992f[i5] = i3;
                }
                i5 = i4;
                i4 = i3;
            } else {
                i4 = i;
                i5 = i2;
            }
            i3++;
            i = i4;
            i2 = i5;
        }
        this.f16992f[i2] = (i + 255) >> 1;
        for (i4 = i2 + 1; i4 < C0277j.f3694e; i4++) {
            this.f16992f[i4] = 255;
        }
    }

    public void m26614c() {
        int i;
        int i2;
        if (this.f16989c < 1509) {
            this.f16990d = 1;
        }
        this.f16987a = ((this.f16990d - 1) / 3) + 30;
        byte[] bArr = this.f16988b;
        int i3 = this.f16989c;
        int i4 = this.f16989c / (this.f16990d * 3);
        int i5 = i4 / 100;
        for (i = 0; i < 32; i++) {
            this.f16995i[i] = (((1024 - (i * i)) * C0277j.f3694e) / 1024) * 1024;
        }
        if (this.f16989c < 1509) {
            i2 = 3;
        } else if (this.f16989c % 499 != 0) {
            i2 = 1497;
        } else if (this.f16989c % 491 != 0) {
            i2 = 1473;
        } else if (this.f16989c % 487 != 0) {
            i2 = 1461;
        } else {
            i2 = 1509;
        }
        int i6 = 0;
        int i7 = 32;
        int i8 = 2048;
        int i9 = 0;
        i = 1024;
        while (i9 < i4) {
            int i10 = (bArr[i6 + 0] & 255) << 4;
            int i11 = (bArr[i6 + 1] & 255) << 4;
            int i12 = (bArr[i6 + 2] & 255) << 4;
            int b = m26611b(i10, i11, i12);
            m26613b(i, b, i10, i11, i12);
            if (i7 != 0) {
                m26609a(i7, b, i10, i11, i12);
            }
            int i13 = i6 + i2;
            if (i13 >= i3) {
                i10 = i13 - this.f16989c;
            } else {
                i10 = i13;
            }
            int i14 = i9 + 1;
            if (i5 == 0) {
                i13 = 1;
            } else {
                i13 = i5;
            }
            if (i14 % i13 == 0) {
                i11 = i - (i / this.f16987a);
                i12 = i8 - (i8 / 30);
                i = i12 >> 6;
                if (i <= 1) {
                    i = 0;
                }
                for (b = 0; b < i; b++) {
                    this.f16995i[b] = ((((i * i) - (b * b)) * C0277j.f3694e) / (i * i)) * i11;
                }
                i6 = i10;
                i5 = i13;
                i7 = i;
                i8 = i12;
                i9 = i14;
                i = i11;
            } else {
                i6 = i10;
                i5 = i13;
                i9 = i14;
            }
        }
    }

    public int m26608a(int i, int i2, int i3) {
        int i4 = this.f16992f[i2];
        int i5 = -1;
        int i6 = 1000;
        int i7 = i4 - 1;
        int i8 = i4;
        while (true) {
            if (i8 >= C0277j.f3694e && i7 < 0) {
                return i5;
            }
            int[] iArr;
            int i9;
            if (i8 < C0277j.f3694e) {
                iArr = this.f16991e[i8];
                i9 = iArr[1] - i2;
                if (i9 >= i6) {
                    i8 = i6;
                    i4 = C0277j.f3694e;
                    i6 = i5;
                } else {
                    i4 = i8 + 1;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    i8 = iArr[0] - i;
                    if (i8 < 0) {
                        i8 = -i8;
                    }
                    i8 += i9;
                    if (i8 < i6) {
                        i9 = iArr[2] - i3;
                        if (i9 < 0) {
                            i9 = -i9;
                        }
                        i8 += i9;
                        if (i8 < i6) {
                            i6 = iArr[3];
                        }
                    }
                    i8 = i6;
                    i6 = i5;
                }
            } else {
                i4 = i8;
                i8 = i6;
                i6 = i5;
            }
            if (i7 >= 0) {
                iArr = this.f16991e[i7];
                i9 = i2 - iArr[1];
                if (i9 >= i8) {
                    i5 = i6;
                    i7 = -1;
                    i6 = i8;
                    i8 = i4;
                } else {
                    i7--;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    i5 = iArr[0] - i;
                    if (i5 < 0) {
                        i5 = -i5;
                    }
                    i5 += i9;
                    if (i5 < i8) {
                        i9 = iArr[2] - i3;
                        if (i9 < 0) {
                            i9 = -i9;
                        }
                        i9 += i5;
                        if (i9 < i8) {
                            i5 = iArr[3];
                            i8 = i4;
                            i6 = i9;
                        }
                    }
                }
            }
            i5 = i6;
            i6 = i8;
            i8 = i4;
        }
    }

    public byte[] m26615d() {
        m26614c();
        m26616e();
        m26612b();
        return m26610a();
    }

    public void m26616e() {
        for (int i = 0; i < C0277j.f3694e; i++) {
            int[] iArr = this.f16991e[i];
            iArr[0] = iArr[0] >> 4;
            iArr = this.f16991e[i];
            iArr[1] = iArr[1] >> 4;
            iArr = this.f16991e[i];
            iArr[2] = iArr[2] >> 4;
            this.f16991e[i][3] = i;
        }
    }

    protected void m26609a(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i2 - i;
        if (i7 < -1) {
            i6 = -1;
        } else {
            i6 = i7;
        }
        i7 = i2 + i;
        if (i7 > C0277j.f3694e) {
            i7 = C0277j.f3694e;
        }
        int i8 = 1;
        int i9 = i2 - 1;
        int i10 = i2 + 1;
        while (true) {
            if (i10 < i7 || i9 > i6) {
                int i11 = i8 + 1;
                int i12 = this.f16995i[i8];
                if (i10 < i7) {
                    i8 = i10 + 1;
                    int[] iArr = this.f16991e[i10];
                    try {
                        iArr[0] = iArr[0] - (((iArr[0] - i3) * i12) / 262144);
                        iArr[1] = iArr[1] - (((iArr[1] - i4) * i12) / 262144);
                        iArr[2] = iArr[2] - (((iArr[2] - i5) * i12) / 262144);
                    } catch (Exception e) {
                    }
                } else {
                    i8 = i10;
                }
                if (i9 > i6) {
                    i10 = i9 - 1;
                    int[] iArr2 = this.f16991e[i9];
                    try {
                        iArr2[0] = iArr2[0] - (((iArr2[0] - i3) * i12) / 262144);
                        iArr2[1] = iArr2[1] - (((iArr2[1] - i4) * i12) / 262144);
                        iArr2[2] = iArr2[2] - ((i12 * (iArr2[2] - i5)) / 262144);
                        i9 = i10;
                        i10 = i8;
                        i8 = i11;
                    } catch (Exception e2) {
                        i9 = i10;
                        i10 = i8;
                        i8 = i11;
                    }
                } else {
                    i10 = i8;
                    i8 = i11;
                }
            } else {
                return;
            }
        }
    }

    protected void m26613b(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.f16991e[i2];
        iArr[0] = iArr[0] - (((iArr[0] - i3) * i) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i4) * i) / 1024);
        iArr[2] = iArr[2] - (((iArr[2] - i5) * i) / 1024);
    }

    protected int m26611b(int i, int i2, int i3) {
        int i4 = MoPubClientPositioning.NO_REPEAT;
        int i5 = -1;
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        int i8 = 0;
        while (i8 < C0277j.f3694e) {
            int[] iArr = this.f16991e[i8];
            int i9 = iArr[0] - i;
            if (i9 < 0) {
                i9 = -i9;
            }
            int i10 = iArr[1] - i2;
            if (i10 < 0) {
                i10 = -i10;
            }
            i10 += i9;
            i9 = iArr[2] - i3;
            if (i9 < 0) {
                i9 = -i9;
            }
            i10 += i9;
            if (i10 < i6) {
                i9 = i10;
                i6 = i8;
            } else {
                i9 = i6;
                i6 = i7;
            }
            i10 -= this.f16993g[i8] >> 12;
            if (i10 < i4) {
                i7 = i8;
            } else {
                i10 = i4;
                i7 = i5;
            }
            i4 = this.f16994h[i8] >> 10;
            int[] iArr2 = this.f16994h;
            iArr2[i8] = iArr2[i8] - i4;
            iArr2 = this.f16993g;
            iArr2[i8] = (i4 << 10) + iArr2[i8];
            i8++;
            i4 = i10;
            i5 = i7;
            i7 = i6;
            i6 = i9;
        }
        int[] iArr3 = this.f16994h;
        iArr3[i7] = iArr3[i7] + 64;
        iArr3 = this.f16993g;
        iArr3[i7] = iArr3[i7] - 65536;
        return i5;
    }
}
