package com.ushareit.listenit;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

public class zi<T> implements ze<String, T> {
    private final ze<Uri, T> f3988a;

    public zi(ze<Uri, T> zeVar) {
        this.f3988a = zeVar;
    }

    public vc<T> m4966a(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object a;
        if (str.startsWith("/")) {
            a = m4964a(str);
        } else {
            a = Uri.parse(str);
            if (a.getScheme() == null) {
                a = m4964a(str);
            }
        }
        return this.f3988a.mo546a(a, i, i2);
    }

    private static Uri m4964a(String str) {
        return Uri.fromFile(new File(str));
    }
}
