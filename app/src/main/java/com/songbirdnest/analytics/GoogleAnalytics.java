package com.songbirdnest.analytics;

import android.content.Context;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.util.Logger;
import java.util.Map;

public class GoogleAnalytics implements AnalyticsProvider {
    private static final int SCOPE_LEVEL_PAGE = 3;
    private static final int SCOPE_LEVEL_SESSION = 2;
    private static final int SCOPE_LEVEL_VISITOR = 1;
    private GoogleAnalyticsTracker mGoogleAnalytics;

    private static class SingletonHolder {
        public static final GoogleAnalytics instance = new GoogleAnalytics();

        private SingletonHolder() {
        }
    }

    private GoogleAnalytics() {
    }

    public static AnalyticsProvider getInstance() {
        return SingletonHolder.instance;
    }

    public void init(Context aContext) {
        this.mGoogleAnalytics = GoogleAnalyticsTracker.getInstance();
        this.mGoogleAnalytics.setProductVersion(Analytics.getPackageName(aContext), Analytics.getVersionName(aContext));
        this.mGoogleAnalytics.start(getGoogleAnalyticsId(aContext), 600, aContext);
        this.mGoogleAnalytics.setCustomVar(1, Analytics.CORE_VERSION, Analytics.getCoreVersion(aContext), 2);
        this.mGoogleAnalytics.setCustomVar(3, Analytics.PARTNER_PACKAGENAME, Analytics.getPartnerPackageName(aContext), 2);
    }

    public void track(String aName) {
        try {
            this.mGoogleAnalytics.trackPageView(aName);
        } catch (Exception e) {
            Logger.error(this, "Problems with track", e);
        }
    }

    public void trackEvent(String aCategory) {
        trackEvent(aCategory, null);
    }

    public void trackEvent(String aCategory, String aAction) {
        try {
            GoogleAnalyticsTracker googleAnalyticsTracker = this.mGoogleAnalytics;
            if (aAction == null) {
                aAction = "";
            }
            googleAnalyticsTracker.trackEvent(aCategory, aAction, null, 0);
        } catch (Exception e) {
            Logger.error(this, "Problems with trackEvent", e);
        }
    }

    public void trackEvent(String aCategory, String aAction, Map<String, String> properties) {
        if (properties == null || properties.size() <= 0) {
            trackEvent(aCategory, aAction);
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (String property : properties.keySet()) {
            if (property != null && property.length() > 0) {
                builder.append(property).append("=").append((String) properties.get(property)).append(" ");
            }
        }
        trackEvent(aCategory, aAction, builder.toString(), 0);
    }

    public void trackEvent(String aCategory, String aAction, String aOptLabel, int aOptValue) {
        try {
            GoogleAnalyticsTracker googleAnalyticsTracker = this.mGoogleAnalytics;
            if (aAction == null) {
                aAction = "";
            }
            googleAnalyticsTracker.trackEvent(aCategory, aAction, aOptLabel, aOptValue);
        } catch (Exception e) {
            Logger.error(this, "Problems with trackEvent", e);
        }
    }

    public void trackError(String aAction, Throwable aThrowable) {
        String stackTrace = Analytics.stackTrace(aThrowable);
        trackEvent(Analytics.EVENT_DEVICEINFO, aAction, Analytics.getDeviceParametersString() + " " + stackTrace, 1);
        trackEvent(Analytics.EVENT_CRUMBS, aAction, Breadcrumbs.get() + " " + stackTrace, 1);
        trackEvent(Analytics.EVENT_CRASH, aAction, stackTrace, 1);
        this.mGoogleAnalytics.dispatch();
    }

    public void queueEvent(String aCategory, String aAction, Map<String, String> properties) {
        trackEvent(aCategory, aAction, properties);
    }

    public void flush() {
        this.mGoogleAnalytics.dispatch();
    }

    public void shutdown() {
        this.mGoogleAnalytics.dispatch();
        this.mGoogleAnalytics.stop();
    }

    private String getGoogleAnalyticsId(Context aContext) {
        return aContext.getResources().getString(C0116R.string.google_analytics_id);
    }
}
