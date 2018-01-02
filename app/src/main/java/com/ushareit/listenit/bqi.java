package com.ushareit.listenit;

import android.os.Handler;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

public abstract class bqi extends bqo<bqj> {
    private final SparseArray<Map<bok, bqk>> f7411a = new SparseArray();
    private final SparseBooleanArray f7412b = new SparseBooleanArray();

    protected abstract bql[] mo1084a(bfy[] com_ushareit_listenit_bfyArr, bok[] com_ushareit_listenit_bokArr, int[][][] iArr);

    public bqi(Handler handler) {
        super(handler);
    }

    public final bqn<bqj> mo1083a(bfy[] com_ushareit_listenit_bfyArr, bok com_ushareit_listenit_bok) {
        int i;
        int[] iArr;
        int i2 = 0;
        int[] iArr2 = new int[(com_ushareit_listenit_bfyArr.length + 1)];
        boj[][] com_ushareit_listenit_bojArr = new boj[(com_ushareit_listenit_bfyArr.length + 1)][];
        int[][][] iArr3 = new int[(com_ushareit_listenit_bfyArr.length + 1)][][];
        for (i = 0; i < com_ushareit_listenit_bojArr.length; i++) {
            com_ushareit_listenit_bojArr[i] = new boj[com_ushareit_listenit_bok.f7223a];
            iArr3[i] = new int[com_ushareit_listenit_bok.f7223a][];
        }
        int[] a = m9510a(com_ushareit_listenit_bfyArr);
        for (i = 0; i < com_ushareit_listenit_bok.f7223a; i++) {
            boj a2 = com_ushareit_listenit_bok.m9239a(i);
            int a3 = m9508a(com_ushareit_listenit_bfyArr, a2);
            if (a3 == com_ushareit_listenit_bfyArr.length) {
                iArr = new int[a2.f7220a];
            } else {
                iArr = m9509a(com_ushareit_listenit_bfyArr[a3], a2);
            }
            int i3 = iArr2[a3];
            com_ushareit_listenit_bojArr[a3][i3] = a2;
            iArr3[a3][i3] = iArr;
            iArr2[a3] = iArr2[a3] + 1;
        }
        bok[] com_ushareit_listenit_bokArr = new bok[com_ushareit_listenit_bfyArr.length];
        iArr = new int[com_ushareit_listenit_bfyArr.length];
        for (a3 = 0; a3 < com_ushareit_listenit_bfyArr.length; a3++) {
            i3 = iArr2[a3];
            com_ushareit_listenit_bokArr[a3] = new bok((boj[]) Arrays.copyOf(com_ushareit_listenit_bojArr[a3], i3));
            iArr3[a3] = (int[][]) Arrays.copyOf(iArr3[a3], i3);
            iArr[a3] = com_ushareit_listenit_bfyArr[a3].mo864a();
        }
        bok com_ushareit_listenit_bok2 = new bok((boj[]) Arrays.copyOf(com_ushareit_listenit_bojArr[com_ushareit_listenit_bfyArr.length], iArr2[com_ushareit_listenit_bfyArr.length]));
        bql[] a4 = mo1084a(com_ushareit_listenit_bfyArr, com_ushareit_listenit_bokArr, iArr3);
        while (i2 < com_ushareit_listenit_bfyArr.length) {
            if (this.f7412b.get(i2)) {
                a4[i2] = null;
            } else {
                bok com_ushareit_listenit_bok3 = com_ushareit_listenit_bokArr[i2];
                Map map = (Map) this.f7411a.get(i2);
                bqk com_ushareit_listenit_bqk = map == null ? null : (bqk) map.get(com_ushareit_listenit_bok3);
                if (com_ushareit_listenit_bqk != null) {
                    a4[i2] = com_ushareit_listenit_bqk.m9529a(com_ushareit_listenit_bok3);
                }
            }
            i2++;
        }
        return new bqn(new bqj(iArr, com_ushareit_listenit_bokArr, a, iArr3, com_ushareit_listenit_bok2), a4);
    }

    private static int m9508a(bfy[] com_ushareit_listenit_bfyArr, boj com_ushareit_listenit_boj) {
        int i = 0;
        int length = com_ushareit_listenit_bfyArr.length;
        for (int i2 = 0; i2 < com_ushareit_listenit_bfyArr.length; i2++) {
            bfy com_ushareit_listenit_bfy = com_ushareit_listenit_bfyArr[i2];
            int i3 = 0;
            while (i3 < com_ushareit_listenit_boj.f7220a) {
                int a = com_ushareit_listenit_bfy.mo931a(com_ushareit_listenit_boj.m9237a(i3));
                if (a <= i) {
                    a = length;
                    length = i;
                } else if (a == 3) {
                    return i2;
                } else {
                    length = a;
                    a = i2;
                }
                i3++;
                i = length;
                length = a;
            }
        }
        return length;
    }

    private static int[] m9509a(bfy com_ushareit_listenit_bfy, boj com_ushareit_listenit_boj) {
        int[] iArr = new int[com_ushareit_listenit_boj.f7220a];
        for (int i = 0; i < com_ushareit_listenit_boj.f7220a; i++) {
            iArr[i] = com_ushareit_listenit_bfy.mo931a(com_ushareit_listenit_boj.m9237a(i));
        }
        return iArr;
    }

    private static int[] m9510a(bfy[] com_ushareit_listenit_bfyArr) {
        int[] iArr = new int[com_ushareit_listenit_bfyArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = com_ushareit_listenit_bfyArr[i].mo880l();
        }
        return iArr;
    }
}
