package com.ushareit.listenit;

import com.google.android.gms.measurement.internal.EventParams;
import java.util.Iterator;

public class duw implements Iterator<String> {
    Iterator<String> f10338a = this.f10339b.f1898b.keySet().iterator();
    final /* synthetic */ EventParams f10339b;

    public duw(EventParams eventParams) {
        this.f10339b = eventParams;
    }

    public String m15630a() {
        return (String) this.f10338a.next();
    }

    public boolean hasNext() {
        return this.f10338a.hasNext();
    }

    public /* synthetic */ Object next() {
        return m15630a();
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
