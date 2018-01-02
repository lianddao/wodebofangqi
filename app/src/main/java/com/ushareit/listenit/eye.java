package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

public final class eye {
    public static String m18476a(String str) {
        String str2 = "";
        if (str == null || str.length() <= 0) {
            return str2;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= -1 || lastIndexOf >= str.length() - 1) {
            return str2;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String m18480b(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf >= 0) {
            str = str.substring(lastIndexOf + 1);
        }
        lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String m18482c(String str) {
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf < 0) {
            lastIndexOf = str.lastIndexOf(92);
        }
        return lastIndexOf >= 0 ? str.substring(lastIndexOf + 1) : str;
    }

    public static void m18477a(eyh com_ushareit_listenit_eyh, eyh com_ushareit_listenit_eyh2) {
        m18481b(com_ushareit_listenit_eyh, com_ushareit_listenit_eyh2);
        com_ushareit_listenit_eyh.mo2335j();
    }

    public static void m18481b(eyh com_ushareit_listenit_eyh, eyh com_ushareit_listenit_eyh2) {
        if (com_ushareit_listenit_eyh == null) {
            throw new RuntimeException("source file is null.");
        } else if (com_ushareit_listenit_eyh.mo2328c()) {
            try {
                com_ushareit_listenit_eyh.mo2322a(eyi.Read);
                com_ushareit_listenit_eyh2.mo2322a(eyi.Write);
                byte[] bArr = new byte[16384];
                while (true) {
                    int a = com_ushareit_listenit_eyh.mo2320a(bArr);
                    if (a == -1) {
                        break;
                    }
                    com_ushareit_listenit_eyh2.mo2326b(bArr, 0, a);
                }
            } finally {
                com_ushareit_listenit_eyh.mo2337l();
                com_ushareit_listenit_eyh2.mo2337l();
            }
        } else {
            throw new RuntimeException("source file[" + com_ushareit_listenit_eyh.mo2330e() + "] is not exists.");
        }
    }

    public static long m18474a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return m18483d(Environment.getExternalStorageDirectory().getAbsolutePath());
        }
        return 0;
    }

    public static long m18483d(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            return 0;
        }
    }

    @TargetApi(19)
    public static File m18475a(Context context, String str) {
        File file;
        if (VERSION.SDK_INT >= 19) {
            try {
                for (File file2 : context.getExternalFilesDirs(null)) {
                    if (file2 != null && file2.getAbsolutePath().startsWith(str)) {
                        break;
                    }
                }
            } catch (NoSuchMethodError e) {
                ext.m18429a(context, true);
                file2 = null;
            } catch (SecurityException e2) {
                file2 = null;
            } catch (NullPointerException e3) {
                file2 = null;
            }
        }
        file2 = null;
        if (file2 != null) {
            return file2;
        }
        try {
            if (VERSION.SDK_INT < 19) {
                context.getExternalFilesDir(null);
            }
        } catch (NoSuchMethodError e4) {
            ext.m18429a(context, false);
        } catch (SecurityException e5) {
        }
        return m18479b(context, str);
    }

    public static File m18479b(Context context, String str) {
        return new File(str, "/Android/data/" + context.getPackageName());
    }

    public static void m18478a(InputStream inputStream, eyh com_ushareit_listenit_eyh) {
        Throwable th;
        Closeable bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                com_ushareit_listenit_eyh.mo2322a(eyi.Write);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        com_ushareit_listenit_eyh.mo2326b(bArr, 0, read);
                    } else {
                        fbb.m18757a(bufferedInputStream);
                        com_ushareit_listenit_eyh.mo2337l();
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fbb.m18757a(bufferedInputStream);
                com_ushareit_listenit_eyh.mo2337l();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            fbb.m18757a(bufferedInputStream);
            com_ushareit_listenit_eyh.mo2337l();
            throw th;
        }
    }
}
