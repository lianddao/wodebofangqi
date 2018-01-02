package com.songbirdnest.analytics;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Utils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Analytics implements AnalyticsProvider {
    public static final String ALERT_KEY = "alert";
    public static final String ARTIST_KEY = "artist";
    public static final String ARTIST_VALUE = "artist";
    public static final String AUTH_KEY = "auth";
    public static final String BUILD_API = "api";
    public static final String BUILD_BRAND = "brand";
    public static final String BUILD_DEVICE = "device";
    public static final String BUILD_MANUFACTURER = "manufacturer";
    public static final String BUILD_MODEL = "model";
    public static final String BUILD_PRODUCT = "product";
    public static final String CANCEL_VALUE = "cancel";
    public static final String COMPLETE_VALUE = "complete";
    public static final String CONTINUE_VALUE = "continue";
    public static final String CORE_VERSION = "core_version";
    public static final String DAILY_VALUE = "daily";
    public static final String DEFAULT_VALUE = "default";
    public static final String DEPLOYMENT_PRODUCTION = "production";
    public static final String DEPLOYMENT_TEST = "test";
    public static final String ENTRY_VALUE = "entry";
    public static final String EVENTID_ALBUM_NAME = "<album_name>";
    public static final String EVENTID_ARTIST_NAME = "<artist_name>";
    public static final String EVENTID_GENRE_NAME = "<genre_name>";
    public static final String EVENTID_PLAYLIST = "<playlist_name>";
    public static final String EVENTPART_ALBUMS = "/albums";
    public static final String EVENTPART_ARTISTS = "/artists";
    public static final String EVENTPART_SONGS = "/songs";
    public static final String EVENT_4X1_WIDGET_OFF = "4x1_widget_off";
    public static final String EVENT_4X1_WIDGET_ON = "4x1_widget_on";
    public static final String EVENT_ABOUT = "/about";
    public static final String EVENT_ARTIST_COMMENT = "/artist_tile/comment";
    public static final String EVENT_ARTIST_FEED = "/artist_feed/";
    public static final String EVENT_ARTIST_VIEW_SEARCH = "/artist_view_search";
    public static final String EVENT_BACK_TO_LIST = "back_to_list";
    public static final String EVENT_BROADCAST = "broadcast_request";
    public static final String EVENT_COMMENT = "comment";
    public static final String EVENT_CONTENT_ALERT = "/artist_content_alert/";
    public static final String EVENT_CRASH = "crash";
    public static final String EVENT_CRUMBS = "crumbs";
    public static final String EVENT_DEVICEINFO = "deviceinfo";
    public static final String EVENT_FACEBOOK_LIKE = "facebook_like";
    public static final String EVENT_FACEBOOK_LIKE_SUCCESS = "facebook_like_success";
    public static final String EVENT_FLICKR_IMAGE = "flickr_image";
    public static final String EVENT_FOLLOW = "follow";
    public static final String EVENT_FOLLOW_FRIEND_VIEW = "/friend_following_view";
    public static final String EVENT_FOLLOW_ME_VIEW = "/my_following_view";
    public static final String EVENT_FRIEND_VIEW = "/friend_list_view";
    public static final String EVENT_HOME = "/home";
    public static final String EVENT_INVITE = "invite";
    public static final String EVENT_LIKE_AUTH = "/like_auth";
    public static final String EVENT_LIST_CHANGE = "list_change";
    public static final String EVENT_LOCK_SCREEN = "/lock_screen";
    public static final String EVENT_MEDIA_SERVER_DEATH = "Media_server_death";
    public static final String EVENT_MUSIC_ALBUMS = "/music/albums/";
    public static final String EVENT_MUSIC_ARTIST = "/music/artists/";
    public static final String EVENT_MUSIC_DRAWER = "/music/drawer";
    public static final String EVENT_MUSIC_GENRES = "/music/genres/";
    public static final String EVENT_MUSIC_MORE = "/music/more";
    public static final String EVENT_MUSIC_PLAYLISTS = "/music/playlists/";
    public static final String EVENT_MUSIC_PODCASTS = "/music/podcasts";
    public static final String EVENT_MUSIC_SONGS = "/music/songs";
    public static final String EVENT_NEXT = "next";
    public static final String EVENT_NO_HEADSET_MEDIA = "no_headset_mediabutton";
    public static final String EVENT_PHOTOSTREAM_OFF = "photostream_off";
    public static final String EVENT_PHOTOSTREAM_ON = "photostream_on";
    public static final String EVENT_PLAYBACK_INITIATED = "playback_initiated";
    public static final String EVENT_PREVIOUS = "previous";
    public static final String EVENT_REPEAT_ALL = "repeat_all";
    public static final String EVENT_REPEAT_NONE = "repeat_none";
    public static final String EVENT_REPEAT_ONE = "repeat_one";
    public static final String EVENT_SD_BUSY = "/sd_card_busy";
    public static final String EVENT_SEARCH = "/search";
    public static final String EVENT_SEARCH_VIEW_SEARCH = "/search_view_search";
    public static final String EVENT_SETTINGS = "/settings";
    public static final String EVENT_SHUFFLE_DISABLED = "shuffle_disabled";
    public static final String EVENT_SHUFFLE_ENABLED = "shuffle_enabled";
    public static final String EVENT_SONGBIRD_ME_ARTIST_VIEW = "/songbird.me/artist_info";
    public static final String EVENT_SONGBIRD_ME_AUTH = "/songbird.me_auth";
    public static final String EVENT_SONGBIRD_ME_ENTRY = "/songbird.me_entry";
    public static final String EVENT_SONG_VIEW_SEARCH = "/song_view_search";
    public static final String EVENT_SPLASH = "/splash";
    public static final String EVENT_UNCAUGHTEXCEPTION = "uncaughtException";
    public static final String EVENT_UNFOLLOW = "unfollow";
    public static final String EVENT_VIDEO_LISTING = "/video";
    public static final String EVENT_WELCOME = "/welcome";
    public static final String EVENT_WELCOME_CONTINUE = "/songbird.me/welcome_next";
    public static final String EVENT_WELCOME_VIEW = "/songbird.me/welcome_view";
    public static final String EVENT_WHATS_NEW = "/whats_new";
    public static final String EVENT_WHATS_NEW_EXTEND = "/whats_new/extend_content";
    public static final String EVENT_WHATS_NEW_LIKE = "/whats_new/item_like";
    public static final String EVENT_WHATS_NEW_VIEW = "/whats_new/content_item_view";
    public static final String FBCONNECT_VALUE = "fbConnect";
    public static final String FRIEND_VALUE = "friend";
    public static final String FROM_KEY = "from";
    public static final String GENRE_KEY = "genre";
    public static final String HOME_VALUE = "home";
    public static final String HOURLY_VALUE = "hourly";
    public static final String LIKE_VALUE = "like";
    public static final String ME_VALUE = "me";
    public static final String MORE_VALUE = "more";
    public static final String NEVER_VALUE = "never";
    public static final String PACKAGE_NAME = "package_name";
    public static final String PARTNER_PACKAGENAME = "partner_packageName";
    public static final String SONGBIRD_ME_VALUE = "songbird.me";
    public static final String TAB_CLICK_VALUE = "tabclick";
    public static final String TAG = "Analytics";
    public static final String TRACK_KEY = "track";
    public static final String USER_FEED_VALUE = "userfeed";
    public static final String VERSION_NAME = "version_name";
    public static final String WEEKLY_VALUE = "weekly";
    public static final boolean enableFlurry = false;

    private static class SingletonHolder {
        public static final AnalyticsProvider instance = new Analytics();

        private SingletonHolder() {
        }
    }

    private Analytics() {
    }

    public static AnalyticsProvider getInstance() {
        return SingletonHolder.instance;
    }

    public static AnalyticsProvider getAnalytics() {
        return getInstance();
    }

    public static AnalyticsProvider get() {
        return getInstance();
    }

    public void init(Context aContext) {
        try {
            LogAnalytics.getInstance().init(aContext);
            GoogleAnalytics.getInstance().init(aContext);
            MixPanel.getInstance().init(aContext);
        } catch (Exception e) {
            Log.e(TAG, "init exception", e);
        }
    }

    public void track(String aName) {
        try {
            Breadcrumbs.add(aName);
            LogAnalytics.getInstance().track(aName);
            GoogleAnalytics.getInstance().track(aName);
            MixPanel.getInstance().track(aName);
        } catch (Exception e) {
            Log.e(TAG, "track exception", e);
        }
    }

    public void trackEvent(String aCategory) {
        try {
            Breadcrumbs.add(aCategory);
            LogAnalytics.getInstance().trackEvent(aCategory);
            GoogleAnalytics.getInstance().trackEvent(aCategory);
            MixPanel.getInstance().trackEvent(aCategory);
        } catch (Exception e) {
            Log.e(TAG, "trackEvent exception", e);
        }
    }

    public void trackEvent(String aCategory, String aAction) {
        try {
            Breadcrumbs.add(aCategory);
            LogAnalytics.getInstance().trackEvent(aCategory, aAction);
            GoogleAnalytics.getInstance().trackEvent(aCategory, aAction);
            MixPanel.getInstance().trackEvent(aCategory, aAction);
        } catch (Exception e) {
            Log.e(TAG, "trackEvent exception", e);
        }
    }

    public void trackEvent(String aCategory, String aAction, Map<String, String> properties) {
        try {
            Breadcrumbs.add(aCategory);
            LogAnalytics.getInstance().trackEvent(aCategory, aAction, properties);
            GoogleAnalytics.getInstance().trackEvent(aCategory, aAction, properties);
            MixPanel.getInstance().trackEvent(aCategory, aAction, properties);
        } catch (Exception e) {
            Log.e(TAG, "trackEvent exception", e);
        }
    }

    public void trackError(String aCategory, Throwable aThrowable) {
        try {
            LogAnalytics.getInstance().trackError(aCategory, aThrowable);
            GoogleAnalytics.getInstance().trackError(aCategory, aThrowable);
            MixPanel.getInstance().trackError(aCategory, aThrowable);
        } catch (Exception e) {
            Log.e(TAG, "TrackError exception", e);
        }
    }

    public void queueEvent(String aCategory, String aAction, Map<String, String> properties) {
        try {
            LogAnalytics.getInstance().queueEvent(aCategory, aAction, properties);
            GoogleAnalytics.getInstance().queueEvent(aCategory, aAction, properties);
            MixPanel.getInstance().queueEvent(aCategory, aAction, properties);
        } catch (Exception e) {
            Log.e(TAG, "TrackError exception", e);
        }
    }

    public void shutdown() {
        try {
            LogAnalytics.getInstance().shutdown();
            GoogleAnalytics.getInstance().shutdown();
            MixPanel.getInstance().shutdown();
        } catch (Exception e) {
            Log.e(TAG, "shutdown exception", e);
        }
    }

    public void flush() {
        try {
            LogAnalytics.getInstance().flush();
            GoogleAnalytics.getInstance().flush();
            MixPanel.getInstance().flush();
        } catch (Exception e) {
            Log.e(TAG, "flush exception", e);
        }
    }

    public static String getPackageName(Context aContext) {
        return aContext.getPackageName();
    }

    public static String getVersionName(Context aContext) {
        try {
            return aContext.getPackageManager().getPackageInfo(aContext.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return "Unknown";
        }
    }

    public static String getCoreVersion(Context aContext) {
        return aContext.getResources().getString(C0116R.string.core_version);
    }

    public static String getPartnerPackageName(Context aContext) {
        if (Utils.containsGingerPackage(Utils.getPhilipsIntent(false, 0), aContext.getPackageManager())) {
            return aContext.getResources().getString(C0116R.string.partner_packageName);
        }
        return "";
    }

    public static String stackTrace(Throwable aThrowable) {
        StringWriter stringWriter = new StringWriter();
        aThrowable.printStackTrace(new PrintWriter(stringWriter));
        return stackTraceCompress(stringWriter.toString());
    }

    public static String stackTraceCompress(String uncompressed) {
        return uncompressed.replaceAll("java\\.[^.]+\\.", "").replaceAll("com\\.[^.]+\\.", "").replaceAll("android\\.[^.]+\\.", "").replaceAll("org\\.[^.]+\\.", "").replaceAll("@[^\\s]+", "");
    }

    public static Map<String, String> getSessionParameters(Context aContext) {
        Map<String, String> parameters = new HashMap();
        parameters.put(PACKAGE_NAME, getPackageName(aContext));
        parameters.put(VERSION_NAME, getVersionName(aContext));
        parameters.put(CORE_VERSION, getCoreVersion(aContext));
        parameters.put(PARTNER_PACKAGENAME, getPartnerPackageName(aContext));
        return parameters;
    }

    public static Map<String, String> getDeviceParameters() {
        Map<String, String> parameters = new HashMap();
        parameters.put(BUILD_DEVICE, Build.DEVICE);
        parameters.put(BUILD_API, VERSION.SDK);
        parameters.put(BUILD_MODEL, Build.MODEL);
        parameters.put(BUILD_PRODUCT, Build.PRODUCT);
        parameters.put(BUILD_MANUFACTURER, Build.MANUFACTURER);
        parameters.put(BUILD_BRAND, Build.BRAND);
        return parameters;
    }

    public static String getDeviceParametersString() {
        String string = "";
        for (Entry<String, String> entry : getDeviceParameters().entrySet()) {
            string = string + entry + ",";
        }
        return string;
    }
}
