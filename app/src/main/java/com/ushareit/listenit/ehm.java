package com.ushareit.listenit;

import android.content.Context;
import com.mopub.common.UrlHandler;

public class ehm implements ehn {
    final /* synthetic */ Context f11060a;
    final /* synthetic */ boolean f11061b;
    final /* synthetic */ Iterable f11062c;
    final /* synthetic */ String f11063d;
    final /* synthetic */ UrlHandler f11064e;

    public ehm(UrlHandler urlHandler, Context context, boolean z, Iterable iterable, String str) {
        this.f11064e = urlHandler;
        this.f11060a = context;
        this.f11061b = z;
        this.f11062c = iterable;
        this.f11063d = str;
    }

    public void onSuccess(String str) {
        this.f11064e.f2157i = false;
        this.f11064e.handleResolvedUrl(this.f11060a, str, this.f11061b, this.f11062c);
    }

    public void onFailure(String str, Throwable th) {
        this.f11064e.f2157i = false;
        this.f11064e.m2703a(this.f11063d, null, str, th);
    }
}
