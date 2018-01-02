package com.ushareit.listenit;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

public class zg<T> implements ze<Integer, T> {
    private final ze<Uri, T> f3986a;
    private final Resources f3987b;

    public zg(Context context, ze<Uri, T> zeVar) {
        this(context.getResources(), (ze) zeVar);
    }

    public zg(Resources resources, ze<Uri, T> zeVar) {
        this.f3987b = resources;
        this.f3986a = zeVar;
    }

    public vc<T> m4958a(Integer num, int i, int i2) {
        Object parse;
        try {
            parse = Uri.parse("android.resource://" + this.f3987b.getResourcePackageName(num.intValue()) + '/' + this.f3987b.getResourceTypeName(num.intValue()) + '/' + this.f3987b.getResourceEntryName(num.intValue()));
        } catch (Throwable e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            }
            parse = null;
        }
        if (parse != null) {
            return this.f3986a.mo546a(parse, i, i2);
        }
        return null;
    }
}
