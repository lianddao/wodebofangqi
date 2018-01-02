package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

public class aaf extends zj<InputStream> implements aaa<Uri> {
    public aaf(Context context, ze<yq, InputStream> zeVar) {
        super(context, zeVar);
    }

    protected vc<InputStream> mo549a(Context context, Uri uri) {
        return new vl(context, uri);
    }

    protected vc<InputStream> mo550a(Context context, String str) {
        return new vk(context.getApplicationContext().getAssets(), str);
    }
}
