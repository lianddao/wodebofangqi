package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import java.io.File;

public class cix {
    @TargetApi(21)
    public static File m11420a(Context context) {
        return ciu.m11414j() ? context.getNoBackupFilesDir() : m11421a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File m11421a(File file) {
        synchronized (cix.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                String str = "SupportV4Utils";
                String str2 = "Unable to create no-backup dir ";
                String valueOf = String.valueOf(file.getPath());
                Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                file = null;
            }
        }
        return file;
    }
}
