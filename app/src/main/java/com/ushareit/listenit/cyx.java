package com.ushareit.listenit;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class cyx {
    private static final AtomicReference<cyx> f9387a = new AtomicReference();

    cyx(Context context) {
    }

    public static cyx m13441a() {
        return (cyx) f9387a.get();
    }

    public static cyx m13442a(Context context) {
        f9387a.compareAndSet(null, new cyx(context));
        return (cyx) f9387a.get();
    }

    public void m13443a(eah com_ushareit_listenit_eah) {
    }

    public Set<String> m13444b() {
        return Collections.emptySet();
    }
}
