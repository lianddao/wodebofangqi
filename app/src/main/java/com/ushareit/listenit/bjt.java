package com.ushareit.listenit;

final class bjt {
    public static bjv m8741a(int i, long[] jArr, int[] iArr, long j) {
        int i2 = 8192 / i;
        int i3 = 0;
        int i4 = 0;
        while (i3 < iArr.length) {
            i3++;
            i4 = btc.m9760a(iArr[i3], i2) + i4;
        }
        long[] jArr2 = new long[i4];
        int[] iArr2 = new int[i4];
        long[] jArr3 = new long[i4];
        int[] iArr3 = new int[i4];
        i3 = 0;
        i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < iArr.length) {
            int i7 = iArr[i3];
            long j2 = jArr[i3];
            int i8 = i6;
            i6 = i5;
            i5 = i4;
            i4 = i8;
            while (i7 > 0) {
                int min = Math.min(i2, i7);
                jArr2[i4] = j2;
                iArr2[i4] = i * min;
                int max = Math.max(i5, iArr2[i4]);
                jArr3[i4] = ((long) i6) * j;
                iArr3[i4] = 1;
                j2 += (long) iArr2[i4];
                i4++;
                i7 -= min;
                i6 += min;
                i5 = max;
            }
            i3++;
            i8 = i4;
            i4 = i5;
            i5 = i6;
            i6 = i8;
        }
        return new bjv(jArr2, iArr2, i4, jArr3, iArr3);
    }
}
