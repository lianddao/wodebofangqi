package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.List;

public final class adz {
    private final Context f4184a;

    public adz(Context context) {
        this.f4184a = context;
    }

    public List<ady> m5324a() {
        List<ady> arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f4184a.getPackageManager().getApplicationInfo(this.f4184a.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(m5323a(str));
                    }
                }
            }
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    private static ady m5323a(String str) {
        try {
            Object newInstance;
            try {
                newInstance = Class.forName(str).newInstance();
                if (newInstance instanceof ady) {
                    return (ady) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (Throwable e) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + newInstance, e);
            } catch (Throwable e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + newInstance, e2);
            }
        } catch (Throwable e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }
}
