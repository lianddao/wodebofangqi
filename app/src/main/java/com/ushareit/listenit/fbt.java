package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

abstract class fbt {
    protected abstract fbu mo2347a(Context context, String str);

    protected abstract boolean mo2348a(Context context);

    protected abstract fbu mo2349b(String str);

    private fbt() {
    }

    public int m18815a(Context context, fby com_ushareit_listenit_fby, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
        if (packageArchiveInfo == null) {
            return 4;
        }
        String str2 = packageArchiveInfo.packageName;
        int i = packageArchiveInfo.versionCode;
        if (com_ushareit_listenit_fby != fby.SECURITY) {
            str = m18818a(str, true);
        }
        long currentTimeMillis = System.currentTimeMillis();
        exw.m18449b("RootUtils", "[AS.Nucleus] quietInstallPackage(1) " + str2 + ", start " + currentTimeMillis);
        fbu a = mo2347a(context, str);
        exw.m18449b("RootUtils", "[AS.Nucleus] quietInstallPackage(2) " + str2 + ", elapsed " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        return m18814a(context, str2, i, a);
    }

    private int m18814a(Context context, String str, int i, fbu com_ushareit_listenit_fbu) {
        try {
            if (com_ushareit_listenit_fbu.f12405c) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 1);
                if (packageInfo == null || packageInfo.versionCode != i) {
                    return 3;
                }
                return 0;
            }
        } catch (Exception e) {
        }
        if (m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_UID_CHANGED")) {
            return 9;
        }
        if (m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_PARSE_FAILED_NO_CERTIFICA") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_SHARED_USER_INCOMPATIBLE")) {
            return 6;
        }
        if (m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_CONFLICTING_PROVIDER") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_DEXOPT") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_OLDER_SDK") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_REPLACE_COULDNT_DELETE") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_PARSE_FAILED_BAD_MANIFEST") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_PARSE_FAILED_MANIFEST_EMPTY") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_PARSE_FAILED_MANIFEST_MALFORMED")) {
            return 5;
        }
        if (m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_MISSING_SHARED_LIBRARY")) {
            return 7;
        }
        if (m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_INVALID_URI") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_INVALID_APK") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_PARSE_FAILED_NOT_APK")) {
            return 4;
        }
        if (m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_UPDATE_INCOMPATIBLE") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_DUPLICATE_PACKAGE") || m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_VERSION_DOWNGRADE")) {
            return 3;
        }
        if (m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_CONTAINER_ERROR")) {
            return 2;
        }
        if (m18821a(com_ushareit_listenit_fbu.f12404b, "INSTALL_FAILED_INSUFFICIENT_STORAGE")) {
            return 8;
        }
        if (m18823b(com_ushareit_listenit_fbu.f12404b, "operation not permitted") || m18823b(com_ushareit_listenit_fbu.f12404b, "permisson denied")) {
            return -1;
        }
        exw.m18449b("RootUtils", "[AS.Nucleus] Install " + str + ", errcode: " + com_ushareit_listenit_fbu.f12404b);
        return 1;
    }

    public fbu m18817a(String str) {
        return mo2349b(str);
    }

    protected String m18818a(String str, boolean z) {
        if (z) {
            return "pm install -r \"" + str + "\"";
        }
        return "pm install \"" + str + "\"";
    }

    protected boolean m18821a(List<String> list, String str) {
        if (list.size() == 0) {
            return false;
        }
        for (String contains : list) {
            if (contains.contains(str)) {
                return true;
            }
        }
        return false;
    }

    protected boolean m18823b(List<String> list, String str) {
        if (list.size() == 0) {
            return false;
        }
        for (String a : list) {
            if (fbp.m18797a(a).contains(str)) {
                return true;
            }
        }
        return false;
    }

    protected void m18819a(String str, String str2) {
        Closeable fileOutputStream;
        IOException e;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(str2);
            try {
                fileOutputStream.write(str.getBytes());
                fbb.m18757a(fileOutputStream);
            } catch (IOException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    fbb.m18757a(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    fbb.m18757a(fileOutputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            e.printStackTrace();
            fbb.m18757a(fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fbb.m18757a(fileOutputStream);
            throw th;
        }
    }
}
