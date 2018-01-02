package com.ushareit.listenit;

import java.util.Iterator;

public class cie {
    private final String f8323a;

    private cie(String str) {
        this.f8323a = str;
    }

    public static cie m11357a(String str) {
        return new cie(str);
    }

    CharSequence m11358a(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String m11359a(Iterable<?> iterable) {
        return m11360a(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder m11360a(StringBuilder stringBuilder, Iterable<?> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            stringBuilder.append(m11358a(it.next()));
            while (it.hasNext()) {
                stringBuilder.append(this.f8323a);
                stringBuilder.append(m11358a(it.next()));
            }
        }
        return stringBuilder;
    }
}
