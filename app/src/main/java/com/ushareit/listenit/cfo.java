package com.ushareit.listenit;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C0148R;

public class cfo {
    private final Resources f8220a;
    private final String f8221b = this.f8220a.getResourcePackageName(C0148R.string.common_google_play_services_unknown_issue);

    public cfo(Context context) {
        cfi.m11080a((Object) context);
        this.f8220a = context.getResources();
    }

    public String m11111a(String str) {
        int identifier = this.f8220a.getIdentifier(str, "string", this.f8221b);
        return identifier == 0 ? null : this.f8220a.getString(identifier);
    }
}
