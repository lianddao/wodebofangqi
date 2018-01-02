package com.ushareit.listenit;

import android.util.SparseArray;

public class ayw {
    private final SparseArray<int[]> f5706a = new SparseArray();

    public void m7404a(int i, int[] iArr) {
        this.f5706a.put(i, iArr);
    }

    public int[] m7405a(int i) {
        return (int[]) this.f5706a.get(i);
    }

    public boolean m7406b(int i) {
        return this.f5706a.indexOfKey(i) >= 0;
    }
}
