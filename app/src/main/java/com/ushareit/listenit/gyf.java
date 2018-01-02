package com.ushareit.listenit;

import android.annotation.SuppressLint;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

@SuppressLint({"FloatMath"})
public class gyf<K, V> extends LinkedHashMap<K, V> {
    public int f14912a;

    public gyf(int i) {
        super(m23136a(i), 0.75f, true);
        this.f14912a = i;
    }

    protected static int m23136a(int i) {
        return ((int) Math.ceil(((double) i) / 0.75d)) + 1;
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this.f14912a;
    }
}
