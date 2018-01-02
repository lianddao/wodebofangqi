package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.util.Map;

public class akr extends ako {
    private static final String f4604a = akr.class.getSimpleName();
    private final Context f4605b;
    private final String f4606c;
    private final Uri f4607d;
    private final Map<String, String> f4608e;

    public akr(Context context, String str, Uri uri, Map<String, String> map) {
        this.f4605b = context;
        this.f4606c = str;
        this.f4607d = uri;
        this.f4608e = map;
    }

    public atr mo666a() {
        return atr.OPEN_LINK;
    }

    public void mo667b() {
        m5926a(this.f4605b, this.f4606c, this.f4608e);
        try {
            atz.m7168a(this.f4605b, Uri.parse(this.f4607d.getQueryParameter("link")), this.f4606c);
        } catch (Throwable e) {
            Log.d(f4604a, "Failed to open link url: " + this.f4607d.toString(), e);
        }
    }
}
