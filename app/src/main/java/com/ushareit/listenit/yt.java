package com.ushareit.listenit;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class yt<A> implements ze<A, yv> {
    private final ze<A, InputStream> f17584a;
    private final ze<A, ParcelFileDescriptor> f17585b;

    public yt(ze<A, InputStream> zeVar, ze<A, ParcelFileDescriptor> zeVar2) {
        if (zeVar == null && zeVar2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.f17584a = zeVar;
        this.f17585b = zeVar2;
    }

    public vc<yv> mo546a(A a, int i, int i2) {
        vc a2;
        vc a3;
        if (this.f17584a != null) {
            a2 = this.f17584a.mo546a(a, i, i2);
        } else {
            a2 = null;
        }
        if (this.f17585b != null) {
            a3 = this.f17585b.mo546a(a, i, i2);
        } else {
            a3 = null;
        }
        if (a2 == null && a3 == null) {
            return null;
        }
        return new yu(a2, a3);
    }
}
