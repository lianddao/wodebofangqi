package com.ushareit.listenit;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class faf {
    public static boolean m18696a(Context context, String str, String str2) {
        Throwable th;
        Closeable closeable = null;
        exw.m18449b("AssetsUtils", "Start extractAssetsFile() : " + str);
        Closeable fileOutputStream;
        try {
            byte[] bArr = new byte[4096];
            Closeable open = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                while (true) {
                    try {
                        int read = open.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fbb.m18757a(fileOutputStream);
                            fbb.m18757a(open);
                            boolean exists = new File(str2).exists();
                            exw.m18449b("AssetsUtils", "Finish extractAssetsFile() : " + str + " and exists: " + exists);
                            return exists;
                        }
                    } catch (IOException e) {
                        closeable = open;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = open;
                    }
                }
            } catch (IOException e2) {
                fileOutputStream = null;
                closeable = open;
                try {
                    exw.m18449b("AssetsUtils", "IOException in extractAssetsFile(): " + str);
                    fbb.m18757a(fileOutputStream);
                    fbb.m18757a(closeable);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fbb.m18757a(fileOutputStream);
                    fbb.m18757a(closeable);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                closeable = open;
                fbb.m18757a(fileOutputStream);
                fbb.m18757a(closeable);
                throw th;
            }
        } catch (IOException e3) {
            fileOutputStream = null;
            exw.m18449b("AssetsUtils", "IOException in extractAssetsFile(): " + str);
            fbb.m18757a(fileOutputStream);
            fbb.m18757a(closeable);
            return false;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            fbb.m18757a(fileOutputStream);
            fbb.m18757a(closeable);
            throw th;
        }
    }
}
