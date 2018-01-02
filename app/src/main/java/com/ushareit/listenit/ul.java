package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import com.umeng.analytics.pro.C0277j;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ul {
    private static final String f16898a = ul.class.getSimpleName();
    private static final Config f16899b = Config.ARGB_8888;
    private int[] f16900c;
    private ByteBuffer f16901d;
    private final byte[] f16902e = new byte[C0277j.f3694e];
    private short[] f16903f;
    private byte[] f16904g;
    private byte[] f16905h;
    private byte[] f16906i;
    private int[] f16907j;
    private int f16908k;
    private byte[] f16909l;
    private uo f16910m;
    private um f16911n;
    private Bitmap f16912o;
    private boolean f16913p;
    private int f16914q;

    public ul(um umVar) {
        this.f16911n = umVar;
        this.f16910m = new uo();
    }

    public void m26556a() {
        this.f16908k = (this.f16908k + 1) % this.f16910m.f16928c;
    }

    public int m26555a(int i) {
        if (i < 0 || i >= this.f16910m.f16928c) {
            return -1;
        }
        return ((un) this.f16910m.f16930e.get(i)).f16923i;
    }

    public int m26558b() {
        if (this.f16910m.f16928c <= 0 || this.f16908k < 0) {
            return -1;
        }
        return m26555a(this.f16908k);
    }

    public int m26559c() {
        return this.f16910m.f16928c;
    }

    public int m26560d() {
        return this.f16908k;
    }

    public int m26561e() {
        return this.f16910m.f16938m;
    }

    public synchronized Bitmap m26562f() {
        Bitmap bitmap;
        int i = 0;
        synchronized (this) {
            if (this.f16910m.f16928c <= 0 || this.f16908k < 0) {
                if (Log.isLoggable(f16898a, 3)) {
                    Log.d(f16898a, "unable to decode frame, frameCount=" + this.f16910m.f16928c + " framePointer=" + this.f16908k);
                }
                this.f16914q = 1;
            }
            if (this.f16914q == 1 || this.f16914q == 2) {
                if (Log.isLoggable(f16898a, 3)) {
                    Log.d(f16898a, "Unable to decode frame, status=" + this.f16914q);
                }
                bitmap = null;
            } else {
                un unVar;
                this.f16914q = 0;
                un unVar2 = (un) this.f16910m.f16930e.get(this.f16908k);
                int i2 = this.f16908k - 1;
                if (i2 >= 0) {
                    unVar = (un) this.f16910m.f16930e.get(i2);
                } else {
                    unVar = null;
                }
                if (unVar2.f16925k == null) {
                    this.f16900c = this.f16910m.f16926a;
                } else {
                    this.f16900c = unVar2.f16925k;
                    if (this.f16910m.f16935j == unVar2.f16922h) {
                        this.f16910m.f16937l = 0;
                    }
                }
                if (unVar2.f16920f) {
                    i2 = this.f16900c[unVar2.f16922h];
                    this.f16900c[unVar2.f16922h] = 0;
                    i = i2;
                }
                if (this.f16900c == null) {
                    if (Log.isLoggable(f16898a, 3)) {
                        Log.d(f16898a, "No Valid Color Table");
                    }
                    this.f16914q = 1;
                    bitmap = null;
                } else {
                    Bitmap a = m26549a(unVar2, unVar);
                    if (unVar2.f16920f) {
                        this.f16900c[unVar2.f16922h] = i;
                    }
                    bitmap = a;
                }
            }
        }
        return bitmap;
    }

    public void m26563g() {
        this.f16910m = null;
        this.f16909l = null;
        this.f16906i = null;
        this.f16907j = null;
        if (this.f16912o != null) {
            this.f16911n.mo571a(this.f16912o);
        }
        this.f16912o = null;
        this.f16901d = null;
    }

    public void m26557a(uo uoVar, byte[] bArr) {
        this.f16910m = uoVar;
        this.f16909l = bArr;
        this.f16914q = 0;
        this.f16908k = -1;
        this.f16901d = ByteBuffer.wrap(bArr);
        this.f16901d.rewind();
        this.f16901d.order(ByteOrder.LITTLE_ENDIAN);
        this.f16913p = false;
        for (un unVar : uoVar.f16930e) {
            if (unVar.f16921g == 3) {
                this.f16913p = true;
                break;
            }
        }
        this.f16906i = new byte[(uoVar.f16931f * uoVar.f16932g)];
        this.f16907j = new int[(uoVar.f16931f * uoVar.f16932g)];
    }

    private Bitmap m26549a(un unVar, un unVar2) {
        int i;
        int i2 = this.f16910m.f16931f;
        int i3 = this.f16910m.f16932g;
        int[] iArr = this.f16907j;
        if (unVar2 != null && unVar2.f16921g > 0) {
            if (unVar2.f16921g == 2) {
                i = 0;
                if (!unVar.f16920f) {
                    i = this.f16910m.f16937l;
                }
                Arrays.fill(iArr, i);
            } else if (unVar2.f16921g == 3 && this.f16912o != null) {
                this.f16912o.getPixels(iArr, 0, i2, 0, 0, i2, i3);
            }
        }
        m26551a(unVar);
        int i4 = 1;
        int i5 = 8;
        int i6 = 0;
        for (i = 0; i < unVar.f16918d; i++) {
            int i7;
            if (unVar.f16919e) {
                if (i6 >= unVar.f16918d) {
                    i4++;
                    switch (i4) {
                        case 2:
                            i6 = 4;
                            break;
                        case 3:
                            i6 = 2;
                            i5 = 4;
                            break;
                        case 4:
                            i6 = 1;
                            i5 = 2;
                            break;
                    }
                }
                int i8 = i6;
                i6 += i5;
                i7 = i8;
            } else {
                i7 = i;
            }
            i7 += unVar.f16916b;
            if (i7 < this.f16910m.f16932g) {
                int i9 = this.f16910m.f16931f * i7;
                int i10 = i9 + unVar.f16915a;
                i7 = unVar.f16917c + i10;
                if (this.f16910m.f16931f + i9 < i7) {
                    i7 = this.f16910m.f16931f + i9;
                }
                i9 = unVar.f16917c * i;
                int i11 = i10;
                while (i11 < i7) {
                    i10 = i9 + 1;
                    i9 = this.f16900c[this.f16906i[i9] & 255];
                    if (i9 != 0) {
                        iArr[i11] = i9;
                    }
                    i11++;
                    i9 = i10;
                }
            }
        }
        if (this.f16913p && (unVar.f16921g == 0 || unVar.f16921g == 1)) {
            if (this.f16912o == null) {
                this.f16912o = m26554j();
            }
            this.f16912o.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        }
        Bitmap j = m26554j();
        j.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return j;
    }

    private void m26551a(un unVar) {
        int i;
        int i2;
        if (unVar != null) {
            this.f16901d.position(unVar.f16924j);
        }
        if (unVar == null) {
            i = this.f16910m.f16931f * this.f16910m.f16932g;
        } else {
            i = unVar.f16917c * unVar.f16918d;
        }
        if (this.f16906i == null || this.f16906i.length < i) {
            this.f16906i = new byte[i];
        }
        if (this.f16903f == null) {
            this.f16903f = new short[4096];
        }
        if (this.f16904g == null) {
            this.f16904g = new byte[4096];
        }
        if (this.f16905h == null) {
            this.f16905h = new byte[4097];
        }
        int h = m26552h();
        int i3 = 1 << h;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        int i6 = -1;
        int i7 = h + 1;
        int i8 = (1 << i7) - 1;
        for (i2 = 0; i2 < i3; i2++) {
            this.f16903f[i2] = (short) 0;
            this.f16904g[i2] = (byte) i2;
        }
        i2 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = i7;
        int i14 = i8;
        int i15 = i5;
        i7 = 0;
        i8 = 0;
        i5 = 0;
        while (i9 < i) {
            if (i8 == 0) {
                i8 = m26553i();
                if (i8 <= 0) {
                    this.f16914q = 3;
                    break;
                }
                i7 = 0;
            }
            i2 += (this.f16902e[i7] & 255) << i12;
            int i16 = i7 + 1;
            int i17 = i8 - 1;
            i7 = i13;
            i8 = i14;
            i13 = i11;
            int i18 = i12 + 8;
            i12 = i2;
            i2 = i5;
            i5 = i15;
            i15 = i18;
            while (i15 >= i7) {
                i11 = i12 & i8;
                i14 = i12 >> i7;
                i15 -= i7;
                if (i11 == i3) {
                    i7 = h + 1;
                    i8 = (1 << i7) - 1;
                    i5 = i3 + 2;
                    i12 = i14;
                    i6 = -1;
                } else if (i11 > i5) {
                    this.f16914q = 3;
                    i11 = i13;
                    i12 = i15;
                    i13 = i7;
                    i15 = i5;
                    i7 = i16;
                    i5 = i2;
                    i2 = i14;
                    i14 = i8;
                    i8 = i17;
                    break;
                } else if (i11 == i4) {
                    i11 = i13;
                    i12 = i15;
                    i13 = i7;
                    i15 = i5;
                    i7 = i16;
                    i5 = i2;
                    i2 = i14;
                    i14 = i8;
                    i8 = i17;
                    break;
                } else if (i6 == -1) {
                    i12 = i10 + 1;
                    this.f16905h[i10] = this.f16904g[i11];
                    i10 = i12;
                    i13 = i11;
                    i6 = i11;
                    i12 = i14;
                } else {
                    if (i11 >= i5) {
                        i12 = i10 + 1;
                        this.f16905h[i10] = (byte) i13;
                        i10 = i12;
                        i13 = i6;
                    } else {
                        i13 = i11;
                    }
                    while (i13 >= i3) {
                        i12 = i10 + 1;
                        this.f16905h[i10] = this.f16904g[i13];
                        short s = this.f16903f[i13];
                        i10 = i12;
                    }
                    i13 = this.f16904g[i13] & 255;
                    i12 = i10 + 1;
                    this.f16905h[i10] = (byte) i13;
                    if (i5 < 4096) {
                        this.f16903f[i5] = (short) i6;
                        this.f16904g[i5] = (byte) i13;
                        i5++;
                        if ((i5 & i8) == 0 && i5 < 4096) {
                            i7++;
                            i8 += i5;
                        }
                    }
                    i10 = i9;
                    while (i12 > 0) {
                        i9 = i12 - 1;
                        i12 = i2 + 1;
                        this.f16906i[i2] = this.f16905h[i9];
                        i10++;
                        i2 = i12;
                        i12 = i9;
                    }
                    i9 = i10;
                    i6 = i11;
                    i10 = i12;
                    i12 = i14;
                }
            }
            i11 = i13;
            i14 = i8;
            i8 = i17;
            i13 = i7;
            i7 = i16;
            i18 = i15;
            i15 = i5;
            i5 = i2;
            i2 = i12;
            i12 = i18;
        }
        for (i7 = i5; i7 < i; i7++) {
            this.f16906i[i7] = (byte) 0;
        }
    }

    private int m26552h() {
        int i = 0;
        try {
            return this.f16901d.get() & 255;
        } catch (Exception e) {
            this.f16914q = 1;
            return i;
        }
    }

    private int m26553i() {
        int h = m26552h();
        int i = 0;
        if (h > 0) {
            while (i < h) {
                int i2 = h - i;
                try {
                    this.f16901d.get(this.f16902e, i, i2);
                    i += i2;
                } catch (Throwable e) {
                    Log.w(f16898a, "Error Reading Block", e);
                    this.f16914q = 1;
                }
            }
        }
        return i;
    }

    private Bitmap m26554j() {
        Bitmap a = this.f16911n.mo570a(this.f16910m.f16931f, this.f16910m.f16932g, f16899b);
        if (a == null) {
            a = Bitmap.createBitmap(this.f16910m.f16931f, this.f16910m.f16932g, f16899b);
        }
        m26550a(a);
        return a;
    }

    @TargetApi(12)
    private static void m26550a(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
