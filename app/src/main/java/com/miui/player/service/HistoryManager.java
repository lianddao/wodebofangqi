package com.miui.player.service;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.music.log.LogHelper;
import com.miui.player.plugin.onlinemusic2.baidu.BaiduConstants;
import com.miui.player.provider.PlayerStore.MemberColomns;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistoryManager {
    public static final int CURRENT = 0;
    static EntryKey[] ENTRY_KEYS = new EntryKey[]{new EntryKey(0), new EntryKey(1), new EntryKey(2), new EntryKey(3)};
    public static final int LAST_HISTORY_SIZE = (ENTRY_KEYS.length - 1);
    public static final int LATEST_1 = 1;
    public static final int LATEST_2 = 2;
    public static final int LATEST_3 = 3;
    static final String PREF_PREFIX_AUDIO_ID = "audio_id";
    static final String PREF_PREFIX_QUEUE = "queue";
    static final String PREF_PREFIX_QUEUE_POS = "queue_pos";
    private static int sHistoryPlaylistId = -1;

    static class EntryKey {
        public final String mAudioId;
        public int mPlaylistId = -1;
        public final String mPlaylistName;
        public final String mPosition;
        public final String mQueue;

        public EntryKey(int index) {
            this.mQueue = HistoryManager.PREF_PREFIX_QUEUE + index;
            this.mPosition = HistoryManager.PREF_PREFIX_QUEUE_POS + index;
            this.mAudioId = "audio_id" + index;
            this.mPlaylistName = BaiduConstants.QUERY_IMAGE_CONNECTOR + this.mQueue;
        }
    }

    public static long[] load(SharedPreferences sp, int index) {
        String q = sp.getString(ENTRY_KEYS[index].mQueue, null);
        if (q == null || q.length() < 1) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        ArrayList<Long> a = new ArrayList();
        CollectionHelper.decodeFromString(a, q, -1);
        long[] values = new long[a.size()];
        int i = 0;
        Iterator i$ = a.iterator();
        while (i$.hasNext()) {
            int i2 = i + 1;
            values[i] = ((Long) i$.next()).longValue();
            i = i2;
        }
        return values;
    }

    public static long[] loadLatest(Context context) {
        return load(PreferenceManager.getDefaultSharedPreferences(context), 1);
    }

    private static List<Long> loadAllHistoryId(SharedPreferences sp) {
        List<Long> list = new ArrayList();
        for (int i = 1; i < ENTRY_KEYS.length; i++) {
            String q = sp.getString(ENTRY_KEYS[i].mQueue, null);
            if (q != null && q.length() > 0) {
                ArrayList<Long> a = new ArrayList();
                CollectionHelper.decodeFromString(a, q, -1);
                list.addAll(a);
            }
        }
        return list;
    }

    public static int loadPostion(SharedPreferences sp, int index) {
        return sp.getInt(ENTRY_KEYS[index].mPosition, -1);
    }

    public static long loadAudioId(SharedPreferences sp, int index) {
        return sp.getLong(ENTRY_KEYS[index].mAudioId, -1);
    }

    public static void save(Editor editor, int index, long[] values, int len) {
        if (values == null || values.length < 1) {
            editor.remove(ENTRY_KEYS[index].mQueue);
        } else {
            editor.putString(ENTRY_KEYS[index].mQueue, CollectionHelper.compressToString(values, len));
        }
    }

    public static void savePosition(Editor editor, int index, long audioId, int position) {
        if (position >= 0) {
            editor.putInt(ENTRY_KEYS[index].mPosition, position);
            editor.putLong(ENTRY_KEYS[index].mAudioId, audioId);
            return;
        }
        editor.remove(ENTRY_KEYS[index].mPosition);
        editor.remove(ENTRY_KEYS[index].mAudioId);
    }

    public static boolean shift(Context context, long[] queue, int pos, long audioId, SharedPreferences sp, int replaceFrom) {
        if (queue == null || queue.length == 0) {
            return false;
        }
        Editor editor = sp.edit();
        while (replaceFrom > 0) {
            EntryKey key = ENTRY_KEYS[replaceFrom];
            EntryKey newer = ENTRY_KEYS[replaceFrom - 1];
            editor.putInt(key.mPosition, sp.getInt(newer.mPosition, -1));
            editor.putLong(key.mAudioId, sp.getLong(newer.mAudioId, -1));
            editor.putString(key.mQueue, sp.getString(newer.mQueue, null));
            replaceFrom--;
        }
        save(editor, 1, queue, queue.length);
        savePosition(editor, 1, audioId, pos);
        editor.apply();
        removeOldestHistory(context, sp);
        return true;
    }

    public static void moveNowplayingOnlineToHistory(Context context) {
        updatePlaylistId(context, 0, queryHistoryPlaylistId(context));
    }

    public static boolean moveHistoryToNowplayingOnline(Context context, List<Long> audioIds) {
        boolean isAllHistory = false;
        String where = "audio_id IN " + SqlUtils.concatNumberAsSet(audioIds) + " AND " + MemberColomns.PLAYLIST_ID + LogHelper.SEPARATE_DOT + queryHistoryPlaylistId(context);
        Cursor c = SqlUtils.query(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, new String[]{"_id"}, where, null, null);
        if (c != null) {
            try {
                isAllHistory = c.getCount() == audioIds.size();
                c.close();
            } catch (Throwable th) {
                c.close();
            }
        }
        if (!isAllHistory) {
            return false;
        }
        ContentValues cv = new ContentValues();
        cv.put(MemberColomns.PLAYLIST_ID, Integer.valueOf(0));
        context.getContentResolver().update(MiuiPlaylistsAudioMap.EXTERNAL_URI, cv, where, null);
        return true;
    }

    public static void removeOldestHistory(Context context, SharedPreferences sp) {
        context.getContentResolver().delete(MiuiPlaylistsAudioMap.EXTERNAL_URI, "audio_id NOT IN " + SqlUtils.concatNumberAsSet(loadAllHistoryId(sp)) + " AND " + MemberColomns.PLAYLIST_ID + LogHelper.SEPARATE_DOT + queryHistoryPlaylistId(context), null);
    }

    public static boolean isEmpty(Context context) {
        if (ServiceHelper.getQueueSize() > 0) {
            return false;
        }
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        for (EntryKey key : ENTRY_KEYS) {
            if (!TextUtils.isEmpty(sp.getString(key.mQueue, null))) {
                return false;
            }
        }
        return true;
    }

    private static int updatePlaylistId(Context context, int from, int to) {
        ContentValues values = new ContentValues();
        values.put(MemberColomns.PLAYLIST_ID, Integer.valueOf(to));
        return context.getContentResolver().update(MiuiPlaylistsAudioMap.EXTERNAL_URI, values, "playlist_id=?", new String[]{String.valueOf(from)});
    }

    private static int queryHistoryPlaylistId(Context context) {
        if (sHistoryPlaylistId < 0) {
            synchronized (MiuiPlaylists.NAME_HISTORY) {
                if (sHistoryPlaylistId < 0) {
                    Uri uri = PlaylistHelper.createPlaylist(context, null, MiuiPlaylists.NAME_HISTORY, -3);
                    if (uri != null) {
                        sHistoryPlaylistId = (int) ContentUris.parseId(uri);
                    }
                }
            }
        }
        return sHistoryPlaylistId;
    }
}
