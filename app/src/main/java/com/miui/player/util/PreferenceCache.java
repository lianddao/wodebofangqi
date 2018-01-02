package com.miui.player.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.miui.player.C0329R;
import com.miui.player.ui.base.ApplicationHelper;
import java.util.HashMap;

public class PreferenceCache {
    public static boolean IS_LPA_DECODE = ApplicationHelper.instance().getDeviceCompat().isLPADecode();
    public static final String PREF_ACCOUNT_SETTING = "account_setting";
    public static final String PREF_ANDROID_ALBUM = "android_album";
    public static final String PREF_AUTO_CORRECT_ID3 = "auto_correct_id3";
    public static final String PREF_BAIDU_ACCOUNT_SETTING = "baidu_account_setting";
    public static final String PREF_CATEGORY_FILTER = "music_filter";
    public static final String PREF_CATEGORY_MOBILE_CONNECT_SETTINGS = "mobile_connect_settings";
    public static final String PREF_CATEGORY_OTHER_SETTINGS = "other_settings";
    public static final String PREF_CORRECT_ID3_SETTINGS = "correct_id3_settings";
    public static final String PREF_DISPLAY_ALBUM = "display_album";
    public static final String PREF_DISPLAY_LYRIC = "display_lyric";
    public static final String PREF_DOWNLOAD_ALBUM_OTHER = "other_connect_album";
    public static final String PREF_DOWNLOAD_LYRIC_OTHER = "other_connect_lyric";
    public static final String PREF_ENABLE_CONNECT_NETWORK_ALERT = "enable_connect_network_alert";
    public static final String PREF_FADE_EFFECT_ACTIVE = "fade_effect_active";
    public static final String PREF_FILTER_BY_DURATION = "filter_by_duration";
    public static final String PREF_FILTER_BY_DURATION_PROGRESS = "filter_by_duration_progress";
    public static final String PREF_FILTER_BY_SIZE = "filter_by_size";
    public static final String PREF_FILTER_BY_SIZE_PROGRESS = "filter_by_size_progress";
    public static final String PREF_FOLDERS_UNSELECTED = "filter_music_folder";
    public static final String PREF_HIGHER_MUSIC_QUALITY = "higher_quality_music";
    public static final String PREF_KEEP_QUIT_LOCATION = "keep_quit_location";
    public static final String PREF_LISTEN_TO_MUSIC_OTHER = "other_connect_listen";
    public static final String PREF_MUSIC_QUALITY = "music_quality";
    public static final String PREF_PAY_SERVICE_GUIDE_DOWNLOAD_ONE = "pay_service_guide_download_one";
    public static final String PREF_PAY_SERVICE_GUIDE_DOWNLOAD_THREE = "pay_service_guide_download_three";
    public static final String PREF_PAY_SERVICE_GUIDE_DOWNLOAD_TWO = "pay_service_guide_download_two";
    public static final String PREF_PAY_SERVICE_GUIDE_LISTEN = "pay_service_guide_listen";
    public static final String PREF_PAY_SERVICE_GUIDE_NEW = "pay_service_guide_new";
    public static final String PREF_PLAY_AND_DOWNLOAD = "play_and_download";
    public static final String PREF_SCREEN_BRIGHT_WAKE = "screen_bright_wake";
    public static final String PREF_SHAKE = "shake";
    public static final String PREF_SHAKE_DEGREE = "shake_degree";
    public static final String PREF_SHAKE_WHILE_SCREEN_ON = "shake_while_screen_on";
    public static final String PREF_SYNCHRONIZE_PLAYLIST = "synchronize_playlist_setting";
    public static final String PREF_TRACK_BIT_RATE = "user_like_track_bit_rate";
    public static final String PREF_VIP_END_TIME = "vip_end_time";
    public static final String PREF_VIP_REMINDED = "vip_reminded";
    public static final String PREF_VIP_START_TIME = "vip_start_time";
    public static final String PREF_VIP_TIME_OUT = "vip_time_out";
    public static final String PREF_XIAOMI_ACCOUNT_SETTING = "xiaomi_account_setting";
    private static HashMap<String, Object> sPrefCache = null;

    public interface OTHERS {
        public static final String PERF_MUSIC_SEARCH_HISTROY = "music_search_histroy";
    }

    public static void initialize(Context context) {
        if (sPrefCache == null) {
            synchronized (PreferenceCache.class) {
                if (sPrefCache == null) {
                    HashMap<String, Object> cache = new HashMap();
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
                    Resources res = context.getResources();
                    cache.put(PREF_DOWNLOAD_ALBUM_OTHER, Boolean.valueOf(sp.getBoolean(PREF_DOWNLOAD_ALBUM_OTHER, false)));
                    cache.put(PREF_DOWNLOAD_LYRIC_OTHER, Boolean.valueOf(sp.getBoolean(PREF_DOWNLOAD_LYRIC_OTHER, true)));
                    cache.put(PREF_LISTEN_TO_MUSIC_OTHER, Boolean.valueOf(sp.getBoolean(PREF_LISTEN_TO_MUSIC_OTHER, false)));
                    cache.put(PREF_FILTER_BY_SIZE, Boolean.valueOf(sp.getBoolean(PREF_FILTER_BY_SIZE, true)));
                    cache.put(PREF_FILTER_BY_SIZE_PROGRESS, Integer.valueOf(sp.getInt(PREF_FILTER_BY_SIZE_PROGRESS, res.getInteger(C0329R.integer.filter_by_size_default))));
                    cache.put(PREF_FILTER_BY_DURATION, Boolean.valueOf(sp.getBoolean(PREF_FILTER_BY_DURATION, false)));
                    cache.put(PREF_FILTER_BY_DURATION_PROGRESS, Integer.valueOf(sp.getInt(PREF_FILTER_BY_DURATION_PROGRESS, res.getInteger(C0329R.integer.filter_by_duration_default))));
                    cache.put(PREF_FOLDERS_UNSELECTED, sp.getString(PREF_FOLDERS_UNSELECTED, null));
                    cache.put(PREF_ANDROID_ALBUM, Boolean.valueOf(sp.getBoolean(PREF_ANDROID_ALBUM, false)));
                    cache.put(PREF_PLAY_AND_DOWNLOAD, Boolean.valueOf(sp.getBoolean(PREF_PLAY_AND_DOWNLOAD, false)));
                    cache.put(PREF_SCREEN_BRIGHT_WAKE, Boolean.valueOf(sp.getBoolean(PREF_SCREEN_BRIGHT_WAKE, true)));
                    cache.put(PREF_KEEP_QUIT_LOCATION, Boolean.valueOf(sp.getBoolean(PREF_KEEP_QUIT_LOCATION, true)));
                    cache.put(PREF_SHAKE, Boolean.valueOf(sp.getBoolean(PREF_SHAKE, false)));
                    cache.put(PREF_SHAKE_DEGREE, Integer.valueOf(sp.getInt(PREF_SHAKE_DEGREE, res.getInteger(C0329R.integer.shake_degree_default))));
                    cache.put(PREF_DISPLAY_LYRIC, Boolean.valueOf(sp.getBoolean(PREF_DISPLAY_LYRIC, true)));
                    cache.put(PREF_DISPLAY_ALBUM, Boolean.valueOf(sp.getBoolean(PREF_DISPLAY_ALBUM, true)));
                    cache.put(PREF_FADE_EFFECT_ACTIVE, Boolean.valueOf(sp.getBoolean(PREF_FADE_EFFECT_ACTIVE, true)));
                    cache.put(PREF_SHAKE_WHILE_SCREEN_ON, Boolean.valueOf(sp.getBoolean(PREF_SHAKE_WHILE_SCREEN_ON, false)));
                    cache.put(PREF_CORRECT_ID3_SETTINGS, Boolean.valueOf(sp.getBoolean(PREF_CORRECT_ID3_SETTINGS, false)));
                    cache.put(PREF_AUTO_CORRECT_ID3, Boolean.valueOf(sp.getBoolean(PREF_AUTO_CORRECT_ID3, false)));
                    cache.put(PREF_TRACK_BIT_RATE, Integer.valueOf(sp.getInt(PREF_TRACK_BIT_RATE, StorageConfig.BIT_RATE_UHD)));
                    cache.put(PREF_PAY_SERVICE_GUIDE_NEW, Boolean.valueOf(sp.getBoolean(PREF_PAY_SERVICE_GUIDE_NEW, true)));
                    cache.put(PREF_PAY_SERVICE_GUIDE_LISTEN, Boolean.valueOf(sp.getBoolean(PREF_PAY_SERVICE_GUIDE_LISTEN, true)));
                    cache.put(PREF_PAY_SERVICE_GUIDE_DOWNLOAD_ONE, Boolean.valueOf(sp.getBoolean(PREF_PAY_SERVICE_GUIDE_DOWNLOAD_ONE, true)));
                    cache.put(PREF_PAY_SERVICE_GUIDE_DOWNLOAD_TWO, Boolean.valueOf(sp.getBoolean(PREF_PAY_SERVICE_GUIDE_DOWNLOAD_TWO, true)));
                    cache.put(PREF_PAY_SERVICE_GUIDE_DOWNLOAD_THREE, Boolean.valueOf(sp.getBoolean(PREF_PAY_SERVICE_GUIDE_DOWNLOAD_THREE, true)));
                    cache.put(PREF_VIP_START_TIME, sp.getString(PREF_VIP_START_TIME, null));
                    cache.put(PREF_VIP_END_TIME, sp.getString(PREF_VIP_END_TIME, null));
                    cache.put(PREF_VIP_REMINDED, Boolean.valueOf(sp.getBoolean(PREF_VIP_REMINDED, false)));
                    cache.put(PREF_VIP_TIME_OUT, Boolean.valueOf(sp.getBoolean(PREF_VIP_TIME_OUT, false)));
                    cache.put(PREF_ENABLE_CONNECT_NETWORK_ALERT, Boolean.valueOf(sp.getBoolean(PREF_ENABLE_CONNECT_NETWORK_ALERT, true)));
                    sPrefCache = cache;
                }
            }
        }
    }

    public static synchronized Integer getPrefAsInteger(Context context, String key) {
        Integer num;
        synchronized (PreferenceCache.class) {
            initialize(context);
            num = (Integer) sPrefCache.get(key);
        }
        return num;
    }

    public static synchronized boolean getPrefAsBoolean(Context context, String key) {
        boolean booleanValue;
        synchronized (PreferenceCache.class) {
            initialize(context);
            booleanValue = ((Boolean) sPrefCache.get(key)).booleanValue();
        }
        return booleanValue;
    }

    public static synchronized String getPrefAsString(Context context, String key) {
        String str;
        synchronized (PreferenceCache.class) {
            initialize(context);
            str = (String) sPrefCache.get(key);
        }
        return str;
    }

    public static synchronized void setPrefAsInteger(Context context, String key, int value) {
        synchronized (PreferenceCache.class) {
            Editor e = PreferenceManager.getDefaultSharedPreferences(context).edit();
            e.putInt(key, value);
            e.commit();
            initialize(context);
            sPrefCache.put(key, Integer.valueOf(value));
        }
    }

    public static synchronized void setPrefAsBoolean(Context context, String key, boolean value) {
        synchronized (PreferenceCache.class) {
            Editor e = PreferenceManager.getDefaultSharedPreferences(context).edit();
            e.putBoolean(key, value);
            e.commit();
            initialize(context);
            sPrefCache.put(key, Boolean.valueOf(value));
        }
    }

    public static synchronized void setPrefAsString(Context context, String key, String value) {
        synchronized (PreferenceCache.class) {
            Editor e = PreferenceManager.getDefaultSharedPreferences(context).edit();
            if (value == null) {
                e.remove(key);
            } else {
                e.putString(key, value);
            }
            e.commit();
            initialize(context);
            sPrefCache.put(key, value);
        }
    }

    public static synchronized void put(Context context, String key, Object objValue) {
        synchronized (PreferenceCache.class) {
            initialize(context);
            sPrefCache.put(key, objValue);
        }
    }
}
