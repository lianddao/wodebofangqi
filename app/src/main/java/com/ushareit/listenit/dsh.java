package com.ushareit.listenit;

import com.google.android.gms.location.DetectedActivity;
import java.util.Comparator;

public final class dsh implements Comparator<DetectedActivity> {
    public int m15427a(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
        int compareTo = Integer.valueOf(detectedActivity2.m2363b()).compareTo(Integer.valueOf(detectedActivity.m2363b()));
        return compareTo == 0 ? Integer.valueOf(detectedActivity.m2362a()).compareTo(Integer.valueOf(detectedActivity2.m2362a())) : compareTo;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15427a((DetectedActivity) obj, (DetectedActivity) obj2);
    }
}
