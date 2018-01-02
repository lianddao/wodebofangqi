package com.ushareit.listenit;

import android.content.Context;
import android.os.Environment;
import java.io.File;

final class agw {
    private static final hjm f4352a = hjn.m23936a("StorageUtils");

    public static File m5601a(Context context) {
        return new File(m5602a(context, true), "video-cache");
    }

    private static File m5602a(Context context, boolean z) {
        File file = null;
        Object externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException e) {
            externalStorageState = "";
        }
        if (z && "mounted".equals(r1)) {
            file = m5603b(context);
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file != null) {
            return file;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        f4352a.mo2794c("Can't define system cache directory! '" + str + "%s' will be used.");
        return new File(str);
    }

    private static File m5603b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        f4352a.mo2794c("Unable to create external cache directory");
        return null;
    }
}
