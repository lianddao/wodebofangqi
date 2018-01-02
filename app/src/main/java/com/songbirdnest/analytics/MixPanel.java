package com.songbirdnest.analytics;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.mixpanel.android.mpmetrics.MPMetrics;
import com.songbirdnest.database.analytics.AnalyticsDBHelper;
import com.songbirdnest.database.analytics.Event;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MixPanel implements AnalyticsProvider {
    private static final int EVENT_STORE_COUNT = 10;
    private Context context;
    private Map<String, Event> eventMap = new HashMap();
    private String[] eventWhiteList = new String[]{Analytics.EVENT_FRIEND_VIEW, Analytics.EVENT_FOLLOW_FRIEND_VIEW, Analytics.EVENT_FOLLOW_ME_VIEW, Analytics.EVENT_WELCOME_VIEW, Analytics.EVENT_WELCOME_CONTINUE, Analytics.EVENT_SONGBIRD_ME_ARTIST_VIEW, Analytics.EVENT_FACEBOOK_LIKE, Analytics.EVENT_INVITE, Analytics.EVENT_COMMENT, Analytics.EVENT_FOLLOW, Analytics.EVENT_UNFOLLOW, Analytics.EVENT_SONGBIRD_ME_ENTRY, Analytics.EVENT_SONGBIRD_ME_AUTH, Analytics.EVENT_LIKE_AUTH, Analytics.EVENT_WELCOME, Analytics.EVENT_WHATS_NEW, Analytics.EVENT_WHATS_NEW_EXTEND, Analytics.EVENT_WHATS_NEW_VIEW, Analytics.EVENT_SPLASH, Analytics.EVENT_SEARCH, Analytics.EVENT_CRASH, Analytics.EVENT_VIDEO_LISTING, Analytics.EVENT_ARTIST_COMMENT, Analytics.EVENT_WHATS_NEW_LIKE, Analytics.EVENT_ARTIST_FEED, Analytics.EVENT_CONTENT_ALERT};
    private MPMetrics mMPMetrics;
    private List<String> whiteListEvents;

    private static class SingletonHolder {
        public static final AnalyticsProvider mProvider = new C00871();

        static class C00871 implements AnalyticsProvider {
            C00871() {
            }

            public void trackEvent(String aCategory, String aAction, Map<String, String> map) {
            }

            public void trackEvent(String aCategory, String aAction) {
            }

            public void trackEvent(String aCategory) {
            }

            public void trackError(String aCategory, Throwable aThrowable) {
            }

            public void track(String aName) {
            }

            public void shutdown() {
            }

            public void queueEvent(String aCategory, String aAction, Map<String, String> map) {
            }

            public void init(Context aContext) {
            }

            public void flush() {
            }
        }

        private SingletonHolder() {
        }
    }

    private MixPanel() {
    }

    public static AnalyticsProvider getInstance() {
        return SingletonHolder.mProvider;
    }

    public void init(Context aContext) {
        this.context = aContext;
        this.whiteListEvents = new ArrayList(Arrays.asList(this.eventWhiteList));
        this.mMPMetrics = MPMetrics.getInstance(aContext, getProjectKey(aContext));
        JSONObject superProperties = new JSONObject();
        try {
            superProperties.put(Analytics.CORE_VERSION, Analytics.getCoreVersion(aContext));
            superProperties.put(Analytics.PARTNER_PACKAGENAME, Analytics.getPartnerPackageName(aContext));
            superProperties.put(Analytics.BUILD_DEVICE, Build.DEVICE);
            superProperties.put(Analytics.BUILD_API, VERSION.SDK);
            superProperties.put(Analytics.BUILD_MANUFACTURER, Build.MANUFACTURER);
            this.mMPMetrics.registerSuperProperties(superProperties);
        } catch (JSONException e) {
            Logger.error(this, "Problems initializing MixPanel", e);
        }
        AnalyticsDBHelper analyticsDBHelper = new AnalyticsDBHelper(aContext);
        for (Event event : analyticsDBHelper.getAllEvents(true)) {
            this.eventMap.put(event.getCategory(), event);
        }
        analyticsDBHelper.close();
    }

    public void shutdown() {
        flush();
    }

    public void flush() {
        this.mMPMetrics.flush();
    }

    private String getProjectKey(Context aContext) {
        return aContext.getResources().getString(C0116R.string.mixPanel_key);
    }

    public void track(String aName) {
        trackEvent(aName);
    }

    public void trackEvent(String aCategory) {
        if (isValidEvent(aCategory)) {
            this.mMPMetrics.track(aCategory, null);
        }
    }

    public void trackEvent(String aCategory, String aAction) {
        if (isValidEvent(aCategory)) {
            try {
                JSONObject properties = new JSONObject();
                if (aAction != null) {
                    properties.put("action", aAction);
                }
                this.mMPMetrics.track(aCategory, properties);
            } catch (JSONException e) {
                Logger.error(this, "Problems tracking Event " + aCategory, e);
            }
        }
    }

    public void trackEvent(String aCategory, String aAction, Map<String, String> properties) {
        if (isValidEvent(aCategory)) {
            try {
                JSONObject jsonObject = new JSONObject();
                if (aAction != null) {
                    jsonObject.put("action", aAction);
                }
                for (String property : properties.keySet()) {
                    if (property != null && property.length() > 0) {
                        jsonObject.put(property, properties.get(property));
                    }
                }
                this.mMPMetrics.track(aCategory, jsonObject);
            } catch (JSONException e) {
                Logger.error(this, "Problems tracking Event " + aCategory, e);
            }
        }
    }

    public void trackError(String aAction, Throwable aThrowable) {
        String stackTrace = Analytics.stackTrace(aThrowable);
        String deviceInfoString = Analytics.getDeviceParametersString();
        Map<String, String> deviceInfo = Analytics.getDeviceParameters();
        deviceInfo.put(Analytics.BUILD_DEVICE, deviceInfoString);
        deviceInfo.put("trace", stackTrace);
        trackEvent(Analytics.EVENT_DEVICEINFO, aAction, deviceInfo);
        Map<String, String> parameters1 = new HashMap();
        parameters1.put(Analytics.EVENT_CRUMBS, Breadcrumbs.get() + " " + stackTrace);
        trackEvent(Analytics.EVENT_CRUMBS, aAction, parameters1);
        Map<String, String> parameters = new HashMap();
        parameters.put("trace", stackTrace);
        trackEvent(Analytics.EVENT_CRASH, aAction, parameters);
        flush();
    }

    private boolean isValidEvent(String event) {
        if (this.whiteListEvents.contains(event)) {
            return true;
        }
        return false;
    }

    public void queueEvent(String aCategory, String aAction, Map<String, String> map) {
    }
}
