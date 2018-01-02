package com.xiaomi.music.statistics;

import android.content.Context;
import com.google.android.collect.Maps;
import java.util.List;
import java.util.Map;
import miui.analytics.XiaomiAnalytics;

public class MusicTrackEvent {
    private static final Object LOCK = new Object();
    static final String TAG = "MusicTrackEvent";
    private final String mId;
    private final Map<String, String> mParams = Maps.newHashMap();

    public MusicTrackEvent(String id) {
        this.mId = id;
    }

    public MusicTrackEvent put(String key, String value) {
        this.mParams.put(key, value);
        return this;
    }

    public static void apply(Context context, List<MusicTrackEvent> events) {
        if (!events.isEmpty()) {
            synchronized (LOCK) {
                XiaomiAnalytics analytics = XiaomiAnalytics.getInstance();
                analytics.startSession(context);
                for (MusicTrackEvent event : events) {
                    analytics.trackEvent(event.mId, event.mParams);
                }
                analytics.endSession();
            }
        }
    }
}
