package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public class dqb {
    protected final Context f10150a;

    public dqb(Context context) {
        this.f10150a = context;
    }

    public ApplicationInfo m15261a(String str, int i) {
        return this.f10150a.getPackageManager().getApplicationInfo(str, i);
    }

    public CharSequence m15262a(String str) {
        return this.f10150a.getPackageManager().getApplicationLabel(this.f10150a.getPackageManager().getApplicationInfo(str, 0));
    }

    @TargetApi(19)
    public boolean m15263a(int i, String str) {
        if (ciu.m11412h()) {
            try {
                ((AppOpsManager) this.f10150a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.f10150a.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public PackageInfo m15264b(String str, int i) {
        return this.f10150a.getPackageManager().getPackageInfo(str, i);
    }
}
