package com.ushareit.listenit;

import android.content.Context;
import java.io.File;

class xu implements xp {
    final /* synthetic */ Context f17544a;
    final /* synthetic */ String f17545b;

    xu(Context context, String str) {
        this.f17544a = context;
        this.f17545b = str;
    }

    public File mo3139a() {
        File cacheDir = this.f17544a.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        return this.f17545b != null ? new File(cacheDir, this.f17545b) : cacheDir;
    }
}
