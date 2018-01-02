package com.songbirdnest.analytics;

import android.content.Context;
import java.util.Map;

public interface AnalyticsProvider {
    void flush();

    void init(Context context);

    void queueEvent(String str, String str2, Map<String, String> map);

    void shutdown();

    void track(String str);

    void trackError(String str, Throwable th);

    void trackEvent(String str);

    void trackEvent(String str, String str2);

    void trackEvent(String str, String str2, Map<String, String> map);
}
