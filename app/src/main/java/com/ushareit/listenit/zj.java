package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.Constants;

public abstract class zj<T> implements ze<Uri, T> {
    private final Context f3989a;
    private final ze<yq, T> f3990b;

    protected abstract vc<T> mo549a(Context context, Uri uri);

    protected abstract vc<T> mo550a(Context context, String str);

    public zj(Context context, ze<yq, T> zeVar) {
        this.f3989a = context;
        this.f3990b = zeVar;
    }

    public final vc<T> m4972a(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (m4969a(scheme)) {
            if (!ym.m27241a(uri)) {
                return mo549a(this.f3989a, uri);
            }
            return mo550a(this.f3989a, ym.m27242b(uri));
        } else if (this.f3990b == null) {
            return null;
        } else {
            if (Constants.HTTP.equals(scheme) || Constants.HTTPS.equals(scheme)) {
                return this.f3990b.mo546a(new yq(uri.toString()), i, i2);
            }
            return null;
        }
    }

    private static boolean m4969a(String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }
}
