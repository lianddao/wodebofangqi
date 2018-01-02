package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class cip {
    public static <T> List<T> m11390a(T t) {
        return Collections.singletonList(t);
    }

    public static <K, V> Map<K, V> m11391a() {
        return Collections.emptyMap();
    }

    public static <K, V> Map<K, V> m11392a(K k, V v) {
        return Collections.singletonMap(k, v);
    }

    public static <K, V> Map<K, V> m11393a(K[] kArr, V[] vArr) {
        int i = 0;
        m11394b(kArr, vArr);
        int length = kArr.length;
        switch (length) {
            case 0:
                return m11391a();
            case 1:
                return m11392a(kArr[0], vArr[0]);
            default:
                Map fqVar = length <= 32 ? new fq(length) : new HashMap(length, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                while (i < length) {
                    fqVar.put(kArr[i], vArr[i]);
                    i++;
                }
                return Collections.unmodifiableMap(fqVar);
        }
    }

    private static <K, V> void m11394b(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + vArr.length);
        }
    }
}
