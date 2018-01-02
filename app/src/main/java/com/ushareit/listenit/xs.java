package com.ushareit.listenit;

import android.content.Context;
import java.io.File;

class xs implements xp {
    final /* synthetic */ Context f17542a;
    final /* synthetic */ String f17543b;

    xs(Context context, String str) {
        this.f17542a = context;
        this.f17543b = str;
    }

    public File mo3139a() {
        File externalCacheDir = this.f17542a.getExternalCacheDir();
        if (externalCacheDir == null) {
            return null;
        }
        return this.f17543b != null ? new File(externalCacheDir, this.f17543b) : externalCacheDir;
    }
}
