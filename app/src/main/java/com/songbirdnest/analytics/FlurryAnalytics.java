package com.songbirdnest.analytics;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.songbirdnest.database.analytics.EventTable;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;
import java.util.HashMap;
import java.util.Map;

public class FlurryAnalytics implements AnalyticsProvider {
    public static final String TAG = "FlurryAnalytics";
    public static boolean initSuccessful = false;
    private static Context mContext;
    private Handler mHandler;
    private Runnable mSessionFlushTask;

    class C00841 implements Runnable {
        C00841() {
        }

        public void run() {
            FlurryAnalytics.this.sessionFlush();
            FlurryAnalytics.this.mHandler.postDelayed(FlurryAnalytics.this.mSessionFlushTask, FlurryAnalytics.this.getSessionPeriodMillis(FlurryAnalytics.mContext));
        }
    }

    private static class SingletonHolder {
        public static final FlurryAnalytics instance = new FlurryAnalytics();

        private SingletonHolder() {
        }
    }

    private FlurryAnalytics() {
        this.mSessionFlushTask = new C00841();
        this.mHandler = new Handler();
    }

    public static AnalyticsProvider getInstance() {
        return SingletonHolder.instance;
    }

    public void init(Context aContext) {
        mContext = aContext;
        initSuccessful = false;
        FlurryAgent.setReportLocation(false);
        FlurryAgent.setContinueSessionMillis(getContinueSessionMillis(mContext));
        FlurryAgent.onStartSession(mContext, getProjectKey(mContext));
        FlurryAgent.onEvent("init", getSessionParameters(mContext));
        sessionManagerInit();
        initSuccessful = true;
    }

    public void track(String aName) {
        if (initSuccessful) {
            FlurryAgent.onPageView();
            FlurryAgent.onEvent(aName, null);
            return;
        }
        Log.e(TAG, "Flurry not initialized properly. track " + aName);
    }

    public void trackEvent(String aCategory) {
        if (initSuccessful) {
            FlurryAgent.onEvent(aCategory, null);
        } else {
            Log.e(TAG, "Flurry not initialized properly. aCategory " + aCategory);
        }
    }

    public void trackEvent(String aCategory, String aAction) {
        if (initSuccessful) {
            Map<String, String> parameters = new HashMap();
            parameters.put("action", aAction);
            FlurryAgent.onEvent(aCategory, parameters);
            return;
        }
        Log.e(TAG, "Flurry not initialized properly. aCategory " + aCategory + " action " + aAction);
    }

    public void trackEvent(String aCategory, String aAction, Map<String, String> properties) {
        if (initSuccessful) {
            Map<String, String> parameters = new HashMap();
            if (aAction != null) {
                parameters.put("action", aAction);
            }
            for (String property : properties.keySet()) {
                if (property != null && property.length() > 0) {
                    parameters.put(property, properties.get(property));
                }
            }
            FlurryAgent.onEvent(aCategory, parameters);
            return;
        }
        Log.e(TAG, "Flurry not initialized properly. aCategory " + aCategory);
    }

    public void trackError(String aCategory, Throwable aThrowable) {
        if (initSuccessful) {
            String stackTrace = Analytics.stackTrace(aThrowable);
            Map<String, String> deviceInfo = Analytics.getDeviceParameters();
            deviceInfo.put("trace", aThrowable.getMessage());
            FlurryAgent.onEvent(Analytics.EVENT_DEVICEINFO, deviceInfo);
            Map<String, String> parameters1 = new HashMap();
            parameters1.put(EventTable.CATEGORY, aCategory);
            parameters1.put(Analytics.EVENT_CRUMBS, Breadcrumbs.get() + " " + stackTrace);
            FlurryAgent.onEvent(Analytics.EVENT_CRUMBS, parameters1);
            Map<String, String> parameters = new HashMap();
            parameters.put(EventTable.CATEGORY, aCategory);
            parameters.put("trace", stackTrace);
            FlurryAgent.onEvent(Analytics.EVENT_CRASH, parameters);
            sessionFlush();
            return;
        }
        Log.e(TAG, "trackError:Flurry not initialized properly. aCategory " + aCategory);
    }

    public void queueEvent(String aCategory, String aAction, Map<String, String> properties) {
        trackEvent(aCategory, aAction, properties);
    }

    public void flush() {
        sessionFlush();
    }

    public void shutdown() {
        if (initSuccessful) {
            trackEvent("finalize-session");
            FlurryAgent.onEndSession(mContext);
            sessionManagerFinalize();
            return;
        }
        Log.e(TAG, "finalize: Flurry not initialized properly.");
    }

    private void sessionFlush() {
        initSuccessful = false;
        FlurryAgent.onEndSession(mContext);
        FlurryAgent.onStartSession(mContext, getProjectKey(mContext));
        initSuccessful = true;
    }

    private Map<String, String> getSessionParameters(Context aContext) {
        Map<String, String> parameters = new HashMap();
        parameters.put(Analytics.PACKAGE_NAME, Analytics.getPackageName(aContext));
        parameters.put(Analytics.VERSION_NAME, Analytics.getVersionName(aContext));
        parameters.put(Analytics.CORE_VERSION, Analytics.getCoreVersion(aContext));
        parameters.put(Analytics.PARTNER_PACKAGENAME, Analytics.getPartnerPackageName(aContext));
        parameters.put("flurry_version", "" + FlurryAgent.getAgentVersion());
        return parameters;
    }

    private String getProjectKey(Context aContext) {
        return aContext.getResources().getString(C0116R.string.flurry_project_key);
    }

    private long getContinueSessionMillis(Context aContext) {
        return (long) ((Integer.parseInt(aContext.getResources().getString(C0116R.string.flurry_continue_session_minutes)) * 60) * SongbirdMedia.PODCAST_BACKUP);
    }

    private long getSessionPeriodMillis(Context aContext) {
        return (long) ((Integer.parseInt(aContext.getResources().getString(C0116R.string.flurry_session_period_minutes)) * 60) * SongbirdMedia.PODCAST_BACKUP);
    }

    private void sessionManagerInit() {
        this.mHandler.postDelayed(this.mSessionFlushTask, getSessionPeriodMillis(mContext));
    }

    private void sessionManagerFinalize() {
        this.mHandler.removeCallbacks(this.mSessionFlushTask);
    }
}
