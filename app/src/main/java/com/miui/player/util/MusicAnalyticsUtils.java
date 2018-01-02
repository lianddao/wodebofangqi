package com.miui.player.util;

import android.content.Context;
import android.text.TextUtils;
import com.miui.player.meta.Audio;
import com.miui.player.reporter.OnlinePlayStatus;
import com.miui.player.ui.base.MusicApplication;
import com.xiaomi.music.util.MusicLog;
import java.util.HashMap;
import java.util.Map;
import miui.analytics.XiaomiAnalytics;

public class MusicAnalyticsUtils {
    public static final String ALBUM_NAME = "album_name";
    public static final String ARTIST_NAME = "artist_name";
    public static final String BIT_RATE = "bit_rate";
    public static final String BUFFER_COUNT = "buffer_count";
    public static final String CLICK_CATEGORY_ALBUMS = "click_category_albums";
    public static final String CLICK_CATEGORY_ARTISTS = "click_category_artists";
    public static final String CLICK_CATEGORY_FOLDERS = "click_category_folders";
    public static final String CLICK_CATEGORY_ONLINE_MUSIC = "click_category_online_music";
    public static final String CLICK_CATEGORY_PLAYLISTS = "click_category_playlists";
    public static final String CLICK_CATEGORY_SEARCH = "click_category_search";
    public static final String CLICK_CATEGORY_TRACKS = "click_category_tracks";
    public static final String CLICK_HOMEPAGE_ENTER_NOWPLAYING = "click_homepage_enter_nowplaying";
    public static final String CLICK_HOMEPAGE_PLAY = "click_homepage_play";
    public static final String CLICK_NOWPLAYING_TOOL_AIRKAN = "click_nowplaying_tool_airkan";
    public static final String CLICK_NOWPLAYING_TOOL_AUDIO_EFFECT = "click_nowplaying_tool_audio_effect";
    public static final String CLICK_NOWPLAYING_TOOL_DOWNLOAD = "click_nowplaying_tool_download";
    public static final String CLICK_NOWPLAYING_TOOL_SHUFFLE = "click_nowplaying_tool_shuffle";
    public static final String[] CLICK_ONLINE_FRAGMENTS = new String[]{"click_online_recommend_page", "click_online_billlist_page", "click_online_channellist_page"};
    public static final String CONNECT_TIME = "connect_time";
    public static final String DEVICE_IMEI = "device_imei";
    public static final String DOWNLOAD_URL = "download_url";
    public static final String ERROR_MESSAGE = "error_message";
    public static final String EVENT_ADJUST_VOLUME_WHEN_NOT_PLAYING = "event_adjust_volume_when_not_playing";
    public static final String EVENT_ADJUST_VOLUME_WHEN_PLAYING = "event_adjust_when_volume_playing";
    public static final String EVENT_CREATE_NOWPLAYING_PAGE = "event_create_nowplaying_page";
    public static final String EVENT_DISPLAY_TOOL_BAR = "event_display_tool_bar";
    public static final String EVENT_DOWNLOAD_RESULT = "event_download_result";
    public static final String EVENT_LOGIN = "登录";
    public static final String EVENT_ONLINE_SEARCH = "在线搜索关键字";
    public static final String EVENT_PAYMENT = "支付";
    public static final String EVENT_PAYMENT_EXTRANCE = "购买入口";
    public static final String EVENT_PAYMENT_TRACK = "触发购买歌曲";
    public static final String EVENT_SKIP_RESULT = "event_skip_result";
    public static final String FILE_NAME = "file_name";
    public static final String IS_AUTO_SKIP = "is_auto_skip";
    public static final String IS_SUCCESS = "is_success";
    public static final String ONLINE_ID = "online_id";
    public static final String PLAY_DURATION = "play_duration";
    public static final String SEARCH_KEY = "search_key";
    public static final String TAG = "MusicAnalyticsUtils";
    public static final String TIME_STAMP = "time_stamp";
    public static final String TOTLE_DURATION = "totle_duration";
    public static final String TRACK_NAME = "track_name";
    public static final String TRACK_TYPE = "track_type";
    public static final String XIAOMI_ID = "xiaomi_id";

    public static void trackSkipEvent(Context context, OnlinePlayStatus playStatus) {
        Map<String, String> parameters = new HashMap();
        parameters.put(XIAOMI_ID, playStatus.mXiaomiId);
        parameters.put("online_id", playStatus.mOnlineId);
        parameters.put(DOWNLOAD_URL, playStatus.mURL);
        parameters.put("bit_rate", Integer.toString(playStatus.mBitrate));
        parameters.put(IS_AUTO_SKIP, playStatus.mAutoSkip ? "1" : "0");
        parameters.put("track_name", playStatus.mTrackName);
        parameters.put("artist_name", playStatus.mArtistName);
        parameters.put("album_name", playStatus.mAlbumName);
        parameters.put("file_name", playStatus.mFileName);
        parameters.put("track_type", playStatus.mTrackType);
        parameters.put(PLAY_DURATION, Long.toString(playStatus.mPlayDurationInMs));
        parameters.put(TOTLE_DURATION, Long.toString(playStatus.mTotleDurationInMs));
        parameters.put(CONNECT_TIME, Long.toString(playStatus.mConnectTimeInMs));
        parameters.put(BUFFER_COUNT, Integer.toString(playStatus.mBufferCount));
        parameters.put("time_stamp", Utils.getTimeStamp());
        XiaomiAnalytics analytics = XiaomiAnalytics.getInstance();
        analytics.startSession(context);
        analytics.trackEvent(EVENT_SKIP_RESULT, parameters);
        analytics.endSession();
    }

    public static void trackDownloadEvent(Context context, String xiaomiId, String onlineId, String url, int bitRate, boolean isSuccess, String errorMessage) {
        Map<String, String> parameters = new HashMap();
        parameters.put(XIAOMI_ID, xiaomiId);
        parameters.put("online_id", onlineId);
        parameters.put(DOWNLOAD_URL, url);
        parameters.put("bit_rate", Integer.toString(bitRate));
        parameters.put(IS_SUCCESS, isSuccess ? "1" : "0");
        parameters.put(ERROR_MESSAGE, errorMessage);
        parameters.put("time_stamp", Utils.getTimeStamp());
        XiaomiAnalytics analytics = XiaomiAnalytics.getInstance();
        analytics.startSession(context);
        analytics.trackEvent(EVENT_DOWNLOAD_RESULT, parameters);
        analytics.endSession();
    }

    public static void trackEvent(String eventId, String extra) {
        if (!TextUtils.isEmpty(extra)) {
            eventId = eventId + "_" + extra;
        }
        Context context = MusicApplication.getApplication();
        XiaomiAnalytics analytics = XiaomiAnalytics.getInstance();
        analytics.startSession(context);
        analytics.trackEvent(eventId);
        analytics.endSession();
        MusicLog.m395d(TAG, "eventId=" + eventId);
    }

    public static void trackLoginResult() {
        trackEvent(EVENT_LOGIN, AccountUtils.hasLoginXiaomiAccount() ? "成功" : "失败");
    }

    public static void trackPaymentEvent(Audio audio) {
        Map<String, String> parameters = new HashMap();
        parameters.put("track_name", audio.getTitle());
        parameters.put("artist_name", audio.getArtistName());
        parameters.put("album_name", audio.getAlbumName());
        MusicLog.m395d(TAG, "Payment from audio, parameters=" + parameters.toString());
        Context context = MusicApplication.getApplication();
        XiaomiAnalytics analytics = XiaomiAnalytics.getInstance();
        analytics.startSession(context);
        analytics.trackEvent(EVENT_PAYMENT_TRACK, parameters);
        analytics.endSession();
    }

    public static void trackOnlineSearch(String key) {
        Map<String, String> parameters = new HashMap();
        parameters.put("search_key", key);
        MusicLog.m395d(TAG, "Online search, parameters=" + parameters.toString());
        Context context = MusicApplication.getApplication();
        XiaomiAnalytics analytics = XiaomiAnalytics.getInstance();
        analytics.startSession(context);
        analytics.trackEvent(EVENT_ONLINE_SEARCH, parameters);
        analytics.endSession();
    }
}
