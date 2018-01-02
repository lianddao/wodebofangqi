package com.ushareit.listenit;

import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.NativeAd;
import java.util.List;

public class ens {
    public static final int NOT_FOUND = -1;
    private final int[] f11325a = new int[200];
    private final int[] f11326b = new int[200];
    private int f11327c = 0;
    private final int[] f11328d = new int[200];
    private final int[] f11329e = new int[200];
    private final NativeAd[] f11330f = new NativeAd[200];
    private int f11331g = 0;

    private ens(int[] iArr) {
        this.f11327c = Math.min(iArr.length, 200);
        System.arraycopy(iArr, 0, this.f11326b, 0, this.f11327c);
        System.arraycopy(iArr, 0, this.f11325a, 0, this.f11327c);
    }

    public static ens m17215a(MoPubClientPositioning moPubClientPositioning) {
        int size;
        int i = 0;
        List<Integer> a = moPubClientPositioning.m3196a();
        int b = moPubClientPositioning.m3197b();
        if (b == MoPubClientPositioning.NO_REPEAT) {
            size = a.size();
        } else {
            size = 200;
        }
        int[] iArr = new int[size];
        int i2 = 0;
        for (Integer intValue : a) {
            i2 = intValue.intValue() - i;
            int i3 = i + 1;
            iArr[i] = i2;
            i = i3;
        }
        while (i < size) {
            i2 = (i2 + b) - 1;
            i3 = i + 1;
            iArr[i] = i2;
            i = i3;
        }
        return new ens(iArr);
    }

    public static ens m17214a() {
        return new ens(new int[0]);
    }

    public boolean m17219a(int i) {
        if (m17213a(this.f11326b, 0, this.f11327c, i) >= 0) {
            return true;
        }
        return false;
    }

    public int m17220b(int i) {
        int b = m17216b(this.f11326b, this.f11327c, i);
        if (b == this.f11327c) {
            return -1;
        }
        return this.f11326b[b];
    }

    public void m17218a(int i, NativeAd nativeAd) {
        int a = m17212a(this.f11326b, this.f11327c, i);
        if (a == this.f11327c || this.f11326b[a] != i) {
            MoPubLog.m2761w("Attempted to insert an ad at an invalid position");
            return;
        }
        int i2 = this.f11325a[a];
        int b = m17216b(this.f11328d, this.f11331g, i2);
        if (b < this.f11331g) {
            int i3 = this.f11331g - b;
            System.arraycopy(this.f11328d, b, this.f11328d, b + 1, i3);
            System.arraycopy(this.f11329e, b, this.f11329e, b + 1, i3);
            System.arraycopy(this.f11330f, b, this.f11330f, b + 1, i3);
        }
        this.f11328d[b] = i2;
        this.f11329e[b] = i;
        this.f11330f[b] = nativeAd;
        this.f11331g++;
        i2 = (this.f11327c - a) - 1;
        System.arraycopy(this.f11326b, a + 1, this.f11326b, a, i2);
        System.arraycopy(this.f11325a, a + 1, this.f11325a, a, i2);
        this.f11327c--;
        while (a < this.f11327c) {
            int[] iArr = this.f11326b;
            iArr[a] = iArr[a] + 1;
            a++;
        }
        for (a = b + 1; a < this.f11331g; a++) {
            iArr = this.f11329e;
            iArr[a] = iArr[a] + 1;
        }
    }

    public boolean m17224c(int i) {
        if (m17213a(this.f11329e, 0, this.f11331g, i) >= 0) {
            return true;
        }
        return false;
    }

    public NativeAd m17225d(int i) {
        int a = m17213a(this.f11329e, 0, this.f11331g, i);
        if (a < 0) {
            return null;
        }
        return this.f11330f[a];
    }

    public int[] m17222b() {
        Object obj = new int[this.f11331g];
        System.arraycopy(this.f11329e, 0, obj, 0, this.f11331g);
        return obj;
    }

    public int m17226e(int i) {
        int a = m17213a(this.f11329e, 0, this.f11331g, i);
        if (a < 0) {
            return i - (a ^ -1);
        }
        return -1;
    }

    public int m17227f(int i) {
        return m17216b(this.f11328d, this.f11331g, i) + i;
    }

    public int m17228g(int i) {
        if (i == 0) {
            return 0;
        }
        int e = m17226e(i - 1);
        if (e != -1) {
            return e + 1;
        }
        return -1;
    }

    public int m17229h(int i) {
        if (i == 0) {
            return 0;
        }
        return m17227f(i - 1) + 1;
    }

    public int m17217a(int i, int i2) {
        int i3;
        int i4 = 0;
        int[] iArr = new int[this.f11331g];
        int[] iArr2 = new int[this.f11331g];
        int i5 = 0;
        for (i3 = 0; i3 < this.f11331g; i3++) {
            int i6 = this.f11328d[i3];
            int i7 = this.f11329e[i3];
            if (i <= i7 && i7 < i2) {
                iArr[i5] = i6;
                iArr2[i5] = i7 - i5;
                this.f11330f[i3].destroy();
                this.f11330f[i3] = null;
                i5++;
            } else if (i5 > 0) {
                int i8 = i3 - i5;
                this.f11328d[i8] = i6;
                this.f11329e[i8] = i7 - i5;
                this.f11330f[i8] = this.f11330f[i3];
            }
        }
        if (i5 == 0) {
            return 0;
        }
        i6 = m17212a(this.f11326b, this.f11327c, iArr2[0]);
        for (i3 = this.f11327c - 1; i3 >= i6; i3--) {
            this.f11325a[i3 + i5] = this.f11325a[i3];
            this.f11326b[i3 + i5] = this.f11326b[i3] - i5;
        }
        while (i4 < i5) {
            this.f11325a[i6 + i4] = iArr[i4];
            this.f11326b[i6 + i4] = iArr2[i4];
            i4++;
        }
        this.f11327c += i5;
        this.f11331g -= i5;
        return i5;
    }

    public void m17223c() {
        if (this.f11331g != 0) {
            m17217a(0, this.f11329e[this.f11331g - 1] + 1);
        }
    }

    public void m17230i(int i) {
        int a;
        for (a = m17212a(this.f11325a, this.f11327c, i); a < this.f11327c; a++) {
            int[] iArr = this.f11325a;
            iArr[a] = iArr[a] + 1;
            iArr = this.f11326b;
            iArr[a] = iArr[a] + 1;
        }
        for (a = m17212a(this.f11328d, this.f11331g, i); a < this.f11331g; a++) {
            iArr = this.f11328d;
            iArr[a] = iArr[a] + 1;
            iArr = this.f11329e;
            iArr[a] = iArr[a] + 1;
        }
    }

    public void m17231j(int i) {
        int b;
        for (b = m17216b(this.f11325a, this.f11327c, i); b < this.f11327c; b++) {
            int[] iArr = this.f11325a;
            iArr[b] = iArr[b] - 1;
            iArr = this.f11326b;
            iArr[b] = iArr[b] - 1;
        }
        for (b = m17216b(this.f11328d, this.f11331g, i); b < this.f11331g; b++) {
            iArr = this.f11328d;
            iArr[b] = iArr[b] - 1;
            iArr = this.f11329e;
            iArr[b] = iArr[b] - 1;
        }
    }

    public void m17221b(int i, int i2) {
        m17231j(i);
        m17230i(i2);
    }

    private static int m17212a(int[] iArr, int i, int i2) {
        int a = m17213a(iArr, 0, i, i2);
        if (a < 0) {
            return a ^ -1;
        }
        int i3 = iArr[a];
        while (a >= 0 && iArr[a] == i3) {
            a--;
        }
        return a + 1;
    }

    private static int m17216b(int[] iArr, int i, int i2) {
        int a = m17213a(iArr, 0, i, i2);
        if (a < 0) {
            return a ^ -1;
        }
        int i3 = iArr[a];
        while (a < i && iArr[a] == i3) {
            a++;
        }
        return a;
    }

    private static int m17213a(int[] iArr, int i, int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = i;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else if (i7 <= i3) {
                return i6;
            } else {
                i4 = i6 - 1;
            }
        }
        return i5 ^ -1;
    }
}
