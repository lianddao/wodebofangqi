package com.ushareit.listenit;

import java.util.Comparator;

public class cod<A extends Comparable<A>> implements Comparator<A> {
    private static cod f8541a = new cod();

    private cod() {
    }

    public static <T extends Comparable<T>> cod<T> m11998a(Class<T> cls) {
        return f8541a;
    }

    public int m11999a(A a, A a2) {
        return a.compareTo(a2);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m11999a((Comparable) obj, (Comparable) obj2);
    }
}
