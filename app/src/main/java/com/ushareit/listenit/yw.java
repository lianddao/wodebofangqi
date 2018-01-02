package com.ushareit.listenit;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

public class yw implements uu<yv> {
    private final uu<InputStream> f17590a;
    private final uu<ParcelFileDescriptor> f17591b;
    private String f17592c;

    public yw(uu<InputStream> uuVar, uu<ParcelFileDescriptor> uuVar2) {
        this.f17590a = uuVar;
        this.f17591b = uuVar2;
    }

    public boolean m27268a(yv yvVar, OutputStream outputStream) {
        if (yvVar.m27265a() != null) {
            return this.f17590a.mo552a(yvVar.m27265a(), outputStream);
        }
        return this.f17591b.mo552a(yvVar.m27266b(), outputStream);
    }

    public String mo551a() {
        if (this.f17592c == null) {
            this.f17592c = this.f17590a.mo551a() + this.f17591b.mo551a();
        }
        return this.f17592c;
    }
}
