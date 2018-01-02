package com.ushareit.listenit;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.config.internal.AnalyticsUserProperty;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class cjm {
    static AppMeasurement m11445a(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError e) {
            return null;
        }
    }

    public static List<AnalyticsUserProperty> m11446b(Context context) {
        AppMeasurement a = m11445a(context);
        if (a != null) {
            Map a2;
            try {
                a2 = a.m2425a(false);
            } catch (Throwable e) {
                if (Log.isLoggable("FRCAnalytics", 3)) {
                    Log.d("FRCAnalytics", "Unable to get user properties.", e);
                }
                a2 = null;
            }
            if (a2 == null) {
                return null;
            }
            List<AnalyticsUserProperty> arrayList = new ArrayList();
            for (Entry entry : a2.entrySet()) {
                if (entry.getValue() != null) {
                    arrayList.add(new AnalyticsUserProperty((String) entry.getKey(), entry.getValue().toString()));
                }
            }
            return arrayList;
        } else if (!Log.isLoggable("FRCAnalytics", 3)) {
            return null;
        } else {
            Log.d("FRCAnalytics", "Unable to get user properties: analytics library is missing.");
            return null;
        }
    }
}
