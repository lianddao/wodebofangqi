package com.ushareit.listenit;

import android.text.TextUtils;
import com.facebook.ads.C0016g;

public class amu {
    private final ajw f4878a;
    private final String f4879b;

    public amu(int i, String str) {
        this(ajw.m5819a(i), str);
    }

    public amu(ajw com_ushareit_listenit_ajw, String str) {
        if (TextUtils.isEmpty(str)) {
            str = com_ushareit_listenit_ajw.m5823b();
        }
        this.f4878a = com_ushareit_listenit_ajw;
        this.f4879b = str;
    }

    public ajw m6333a() {
        return this.f4878a;
    }

    public C0016g m6334b() {
        return this.f4878a.m5824c() ? new C0016g(this.f4878a.m5821a(), this.f4879b) : new C0016g(ajw.UNKNOWN_ERROR.m5821a(), ajw.UNKNOWN_ERROR.m5823b());
    }
}
