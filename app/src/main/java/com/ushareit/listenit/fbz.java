package com.ushareit.listenit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

class fbz extends fbt {
    private fbz() {
        super();
    }

    protected boolean mo2348a(Context context) {
        int i;
        Exception e;
        Throwable th;
        Cursor query;
        try {
            query = context.getContentResolver().query(m18838a(), null, null, null, null);
            if (query != null) {
                try {
                    query.moveToFirst();
                    i = query.getInt(0);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        exw.m18449b("RootUtils", "RootUtils, Security loadPermission: " + e.toString());
                        fbb.m18756a(query);
                        i = -1;
                        exw.m18449b("RootUtils", "RootUtils, Security loadPermission: " + i);
                        if (i == 1) {
                            return false;
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        fbb.m18756a(query);
                        throw th;
                    }
                }
            }
            i = -1;
            fbb.m18756a(query);
        } catch (Exception e3) {
            e = e3;
            query = null;
            exw.m18449b("RootUtils", "RootUtils, Security loadPermission: " + e.toString());
            fbb.m18756a(query);
            i = -1;
            exw.m18449b("RootUtils", "RootUtils, Security loadPermission: " + i);
            if (i == 1) {
                return true;
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            fbb.m18756a(query);
            throw th;
        }
        exw.m18449b("RootUtils", "RootUtils, Security loadPermission: " + i);
        if (i == 1) {
            return true;
        }
        return false;
    }

    public fbu mo2347a(Context context, String str) {
        Uri a = m18838a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("PATH", str);
        int i = -1;
        try {
            i = context.getContentResolver().update(a, contentValues, null, null);
        } catch (Exception e) {
            exw.m18449b("RootUtils", "RootUtils, Security: " + e.toString());
        }
        exw.m18449b("RootUtils", "RootUtils, Security: " + i + ", " + eye.m18482c(str));
        fbu com_ushareit_listenit_fbu = new fbu();
        com_ushareit_listenit_fbu.f12405c = i == 1;
        return com_ushareit_listenit_fbu;
    }

    private Uri m18838a() {
        return Uri.parse("content://com.lenovo.security.packageinstall.SilentInstallProvider/install");
    }

    protected fbu mo2349b(String str) {
        return new fbu();
    }
}
