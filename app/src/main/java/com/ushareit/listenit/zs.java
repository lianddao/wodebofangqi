package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

public class zs extends zj<ParcelFileDescriptor> implements zn<Uri> {
    public zs(Context context, ze<yq, ParcelFileDescriptor> zeVar) {
        super(context, zeVar);
    }

    protected vc<ParcelFileDescriptor> mo549a(Context context, Uri uri) {
        return new ve(context, uri);
    }

    protected vc<ParcelFileDescriptor> mo550a(Context context, String str) {
        return new vd(context.getApplicationContext().getAssets(), str);
    }
}
