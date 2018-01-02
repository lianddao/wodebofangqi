package com.ushareit.listenit;

import com.google.android.gms.location.ActivityTransition;
import java.util.Comparator;

public final class dsg implements Comparator<ActivityTransition> {
    public int m15426a(ActivityTransition activityTransition, ActivityTransition activityTransition2) {
        int b = activityTransition.m2353b();
        int b2 = activityTransition2.m2353b();
        if (b != b2) {
            return b < b2 ? -1 : 1;
        } else {
            b = activityTransition.m2354c();
            b2 = activityTransition2.m2354c();
            return b == b2 ? 0 : b >= b2 ? 1 : -1;
        }
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15426a((ActivityTransition) obj, (ActivityTransition) obj2);
    }
}
