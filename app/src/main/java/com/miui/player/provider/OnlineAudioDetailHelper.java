package com.miui.player.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Pair;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.provider.PlayerStore.OnlineAudioDetail;
import com.miui.player.provider.PlayerStore.OnlineAudioDetail.Columns;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Utils;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.OnlineEngine;
import com.xiaomi.music.online.model.Song;
import java.util.List;

public class OnlineAudioDetailHelper {
    private static final String KEY_LAST_CLEAN_TIME = "online_audio_detail_last_clean";
    private static final long PERIOD_OF_BELIEVE = 604800000;
    private static final long PERIOD_OF_DOUBT = 1800000;
    static final String TAG = OnlineAudioDetailHelper.class.getName();

    public interface QueryDetail {
        String getColumn();

        String getResult(AudioDetail audioDetail);
    }

    public static class QueryAlbumId implements QueryDetail {
        public String getColumn() {
            return "album_id";
        }

        public String getResult(AudioDetail detail) {
            return detail.mAlbumId;
        }
    }

    public static class QueryAlbumPictureURL implements QueryDetail {
        public String getColumn() {
            return Columns.ALBUM_URL;
        }

        public String getResult(AudioDetail detail) {
            return detail.getAlbumPictureUrl();
        }
    }

    public static class QueryCpSongId implements QueryDetail {
        public String getColumn() {
            return "online_id";
        }

        public String getResult(AudioDetail detail) {
            return detail.mCpSongId;
        }
    }

    public static class QueryLyricURL implements QueryDetail {
        public String getColumn() {
            return "lyric_url";
        }

        public String getResult(AudioDetail detail) {
            return detail.mURLLrc;
        }
    }

    public static void clean(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        long lastClean = sp.getLong(KEY_LAST_CLEAN_TIME, 0);
        long current = System.currentTimeMillis();
        if (Utils.isOutOfTime(lastClean, 604800000)) {
            String format = "(%s<?)OR(%s>?)";
            String lastModifyColumn = "time_last_modified";
            String where = String.format("(%s<?)OR(%s>?)", new Object[]{"time_last_modified", "time_last_modified"});
            context.getContentResolver().delete(OnlineAudioDetail.EXTERNAL_URI, where, new String[]{String.valueOf(current - 604800000), String.valueOf(current)});
            sp.edit().putLong(KEY_LAST_CLEAN_TIME, current).apply();
            Log.d(TAG, "update OnlineAudioDetail " + current);
        }
    }

    public static int updateDB(Context context, String onlineId, AudioDetail detail) {
        if (onlineId == null || detail == null) {
            return 0;
        }
        boolean exist = false;
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, OnlineAudioDetail.EXTERNAL_URI, new String[]{"mi_online_id"}, "mi_online_id =?", new String[]{onlineId}, null, 1);
        if (cursor != null) {
            try {
                exist = cursor.moveToFirst();
            } finally {
                cursor.close();
            }
        }
        ContentValues cv = new ContentValues();
        putIfNotNull(cv, "mi_online_id", onlineId);
        putIfNotNull(cv, "album_id", detail.mAlbumId);
        putIfNotNull(cv, Columns.ARTIST_ID, detail.mArtistId);
        putIfNotNull(cv, "lyric_url", detail.mURLLrc);
        putIfNotNull(cv, Columns.ALBUM_URL, detail.getAlbumPictureUrl());
        putIfNotNull(cv, "online_id", detail.mCpSongId);
        putIfNotNull(cv, "provider_id", detail.mCpId);
        if (exist) {
            return context.getContentResolver().update(OnlineAudioDetail.EXTERNAL_URI, cv, "mi_online_id=?", new String[]{onlineId});
        } else if (context.getContentResolver().insert(OnlineAudioDetail.EXTERNAL_URI, cv) == null) {
            return 0;
        } else {
            return 1;
        }
    }

    private static void putIfNotNull(ContentValues cv, String key, String value) {
        if (value != null) {
            cv.put(key, value);
        }
    }

    private static Cursor queryByOnlineId(Context context, String onlineId, String[] projection) {
        return SqlUtils.query(context, OnlineAudioDetail.EXTERNAL_URI, projection, "mi_online_id=?", new String[]{onlineId}, null, 1);
    }

    public static String queryAlbumId(Context context, String onlineId) {
        return query(context, onlineId, new QueryAlbumId());
    }

    public static String queryLyricURL(Context context, String onlineId) {
        return query(context, onlineId, new QueryLyricURL());
    }

    public static String queryAlbumPictureURL(Context context, String onlineId) {
        return query(context, onlineId, new QueryAlbumPictureURL());
    }

    public static String queryCpSongId(Context context, String onlineId) {
        return query(context, onlineId, new QueryCpSongId());
    }

    public static String query(Context context, String onlineId, QueryDetail queryDetail) {
        if (onlineId == null) {
            return null;
        }
        long lastModified = 0;
        String result = null;
        Cursor c = queryByOnlineId(context, onlineId, new String[]{queryDetail.getColumn(), "time_last_modified"});
        if (c != null) {
            try {
                if (c.moveToFirst()) {
                    result = c.getString(0);
                    lastModified = c.getLong(1);
                }
                c.close();
            } catch (Throwable th) {
                c.close();
            }
        }
        if (result != null || !Utils.isOutOfTime(lastModified, PERIOD_OF_DOUBT)) {
            return result;
        }
        OnlineEngine onlineEngine = MusicEngine.get(context).getOnlineEngine();
        String cpSongId = null;
        if (IndeterminateIds.isValid(onlineId)) {
            cpSongId = IndeterminateIds.getId(onlineId);
        } else {
            Result<Song> res = onlineEngine.getSongDetail(context, onlineId);
            if (res.mErrorCode == 1 && res.mData != null) {
                cpSongId = ((Song) res.mData).mCpSongId;
            }
        }
        if (cpSongId == null) {
            return result;
        }
        Pair<AudioDetail, List<AudioLink>> pair = OnlineMusicProxy.requestAudioDetail(context, cpSongId, null, 2);
        if (pair == null || pair.first == null) {
            return result;
        }
        updateDB(context, onlineId, (AudioDetail) pair.first);
        return queryDetail.getResult((AudioDetail) pair.first);
    }
}
