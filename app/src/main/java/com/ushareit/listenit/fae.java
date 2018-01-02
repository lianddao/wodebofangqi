package com.ushareit.listenit;

import android.content.pm.ResolveInfo;
import java.util.Comparator;
import java.util.List;

class fae implements Comparator<ResolveInfo> {
    private List<String> f12302a;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m18695a((ResolveInfo) obj, (ResolveInfo) obj2);
    }

    public fae(List<String> list) {
        this.f12302a = list;
    }

    public int m18695a(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
        int indexOf;
        int indexOf2;
        if (this.f12302a.contains(resolveInfo.activityInfo.packageName)) {
            indexOf = this.f12302a.indexOf(resolveInfo.activityInfo.packageName);
        } else {
            indexOf = this.f12302a.size();
        }
        if (this.f12302a.contains(resolveInfo2.activityInfo.packageName)) {
            indexOf2 = this.f12302a.indexOf(resolveInfo2.activityInfo.packageName);
        } else {
            indexOf2 = this.f12302a.size();
        }
        return indexOf - indexOf2;
    }
}
