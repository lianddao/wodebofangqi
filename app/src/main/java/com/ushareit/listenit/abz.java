package com.ushareit.listenit;

import android.content.Context;
import java.io.File;
import java.io.InputStream;

public class abz implements aeb<InputStream, abx> {
    private final acl f4090a;
    private final aco f4091b;
    private final zh f4092c;
    private final abr<abx> f4093d = new abr(this.f4090a);

    public abz(Context context, ws wsVar) {
        this.f4090a = new acl(context, wsVar);
        this.f4091b = new aco(wsVar);
        this.f4092c = new zh();
    }

    public ux<File, abx> mo561a() {
        return this.f4093d;
    }

    public ux<InputStream, abx> mo562b() {
        return this.f4090a;
    }

    public uu<InputStream> mo563c() {
        return this.f4092c;
    }

    public uy<abx> mo564d() {
        return this.f4091b;
    }
}
