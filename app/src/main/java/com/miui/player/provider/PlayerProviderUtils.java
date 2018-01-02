package com.miui.player.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.util.Log;
import com.miui.player.meta.Audio;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.provider.PlayerStore.MiuiEqualizer;
import com.miui.player.provider.PlayerStore.MiuiNowPlayingAudio;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Members;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.service.HistoryManager;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.SqlUtils.SQLArguments;
import com.miui.player.util.StorageConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import miui.provider.MusicSearchProvider.MusicMeta;
import org.json.JSONArray;
import org.json.JSONException;

public class PlayerProviderUtils {
    static final String TAG = PlayerProviderUtils.class.getName();

    public static String filterNowPlaying(String where, boolean isFirst) {
        String PATTERN = "%s %s %s != '%s'";
        String AND = isFirst ? MetaManager.UNKNOWN_STRING : " AND ";
        return String.format("%s %s %s != '%s'", new Object[]{where, AND, "_id", String.valueOf(0)});
    }

    public static String[] getOnlineIds(Context context, ArrayList<Long> audioIds, Long playlistId) {
        if (audioIds == null || audioIds.size() < 1) {
            return null;
        }
        Cursor c;
        String WHERE = "audio_id IN " + SqlUtils.concatNumberAsSet(audioIds) + " AND " + "mi_sync_track_state" + "!=?";
        String[] args = new String[]{String.valueOf(1)};
        String[] ONLINE_ID_COL = new String[]{"mi_online_id"};
        String[] ret = new String[0];
        if (playlistId != null) {
            c = context.getContentResolver().query(Members.getMembersUri(playlistId.longValue()), ONLINE_ID_COL, WHERE, args, null);
        } else {
            c = context.getContentResolver().query(MiuiPlaylistsAudioMap.EXTERNAL_URI, ONLINE_ID_COL, WHERE, args, null);
        }
        if (c == null) {
            return ret;
        }
        ret = new String[c.getCount()];
        c.moveToFirst();
        while (!c.isAfterLast()) {
            ret[0] = c.getString(0);
            c.moveToNext();
        }
        c.close();
        return ret;
    }

    public static String getOnlineId(Context context, long audioId, Long playlistId) {
        ArrayList<Long> ids = new ArrayList(1);
        ids.add(Long.valueOf(audioId));
        String[] providerIds = getOnlineIds(context, ids, playlistId);
        if (providerIds == null || providerIds.length < 1) {
            return null;
        }
        return providerIds[0];
    }

    public static ContentValues[] createMemberInfoById(Context context, long[] ids, int orderBase) {
        if (ids == null || ids.length == 0) {
            return null;
        }
        int i$;
        int len$;
        ArrayList<Long> localAudioIds = new ArrayList();
        ArrayList<Long> onlineAudioIds = new ArrayList();
        for (long valueOf : ids) {
            Long id = Long.valueOf(valueOf);
            if (PlayerProvider.isOnlineAudio(id.longValue())) {
                onlineAudioIds.add(Long.valueOf(id.longValue()));
            } else {
                localAudioIds.add(Long.valueOf(id.longValue()));
            }
        }
        HashMap<Long, ContentValues> local = null;
        HashMap<Long, ContentValues> online = null;
        if (localAudioIds.size() > 0) {
            local = createMemberInfoFromLocalLib(context, localAudioIds);
        }
        if (onlineAudioIds.size() > 0) {
            online = createMemberInfoFromPlaylist(context, onlineAudioIds);
        }
        HashMap<Long, ContentValues> temp = null;
        if (local != null && online == null) {
            temp = local;
        } else if (local == null && online != null) {
            temp = online;
        }
        ContentValues[] ret = new ContentValues[ids.length];
        int row = 0;
        long[] arr$;
        int row2;
        int orderBase2;
        ContentValues cv;
        if (temp != null) {
            arr$ = ids;
            len$ = arr$.length;
            i$ = 0;
            row2 = 0;
            orderBase2 = orderBase;
            while (i$ < len$) {
                cv = (ContentValues) temp.get(Long.valueOf(arr$[i$]));
                if (cv != null) {
                    orderBase = orderBase2 + 1;
                    cv.put("play_order", Integer.valueOf(orderBase2));
                    row = row2 + 1;
                    ret[row2] = cv;
                } else {
                    row = row2;
                    orderBase = orderBase2;
                }
                i$++;
                row2 = row;
                orderBase2 = orderBase;
            }
            row = row2;
            orderBase = orderBase2;
        } else if (!(local == null || online == null)) {
            arr$ = ids;
            len$ = arr$.length;
            i$ = 0;
            row2 = 0;
            orderBase2 = orderBase;
            while (i$ < len$) {
                long id2 = arr$[i$];
                cv = (ContentValues) local.get(Long.valueOf(id2));
                if (cv == null) {
                    cv = (ContentValues) online.get(Long.valueOf(id2));
                }
                if (cv != null) {
                    orderBase = orderBase2 + 1;
                    cv.put("play_order", Integer.valueOf(orderBase2));
                    row = row2 + 1;
                    ret[row2] = cv;
                } else {
                    row = row2;
                    orderBase = orderBase2;
                }
                i$++;
                row2 = row;
                orderBase2 = orderBase;
            }
            row = row2;
            orderBase = orderBase2;
        }
        if (row >= ids.length) {
            return ret;
        }
        Object tempValues = new ContentValues[row];
        System.arraycopy(ret, 0, tempValues, 0, row);
        return tempValues;
    }

    private static HashMap<Long, ContentValues> createMemberInfoFromPlaylist(Context context, ArrayList<Long> ids) {
        String[] MEMBER_COLS = new String[]{"audio_id", "album", "artist", "_data", "duration", "mi_online_id", "title", "provider_id", "online_id"};
        if (ids == null || ids.size() == 0) {
            return null;
        }
        HashMap<Long, ContentValues> res = new HashMap();
        Cursor c = context.getContentResolver().query(MiuiPlaylistsAudioMap.EXTERNAL_URI, MEMBER_COLS, "audio_id IN " + SqlUtils.concatNumberAsSet(ids), null, null);
        if (c == null) {
            return null;
        }
        try {
            if (c.getCount() <= 0) {
                res = null;
            } else {
                int idIdx = c.getColumnIndexOrThrow("audio_id");
                int dataIdx = c.getColumnIndexOrThrow("_data");
                int titleIdx = c.getColumnIndexOrThrow("title");
                int albumIdx = c.getColumnIndexOrThrow("album");
                int artistIdx = c.getColumnIndexOrThrow("artist");
                int durationIdx = c.getColumnIndexOrThrow("duration");
                int onlineIdx = c.getColumnIndexOrThrow("mi_online_id");
                int providerIdx = c.getColumnIndexOrThrow("provider_id");
                int cpSongIdIdx = c.getColumnIndexOrThrow("online_id");
                c.moveToFirst();
                while (!c.isAfterLast()) {
                    ContentValues cv = new ContentValues();
                    long key = c.getLong(idIdx);
                    cv.put("_data", c.getString(dataIdx));
                    cv.put("title", c.getString(titleIdx));
                    cv.put("album", c.getString(albumIdx));
                    cv.put("artist", c.getString(artistIdx));
                    cv.put("duration", Integer.valueOf(c.getInt(durationIdx)));
                    cv.put("provider_id", c.getString(providerIdx));
                    cv.put("online_id", c.getString(cpSongIdIdx));
                    cv.put("mi_online_id", c.getString(onlineIdx));
                    res.put(Long.valueOf(key), cv);
                    c.moveToNext();
                }
            }
            c.close();
            return res;
        } catch (Throwable th) {
            c.close();
        }
    }

    private static HashMap<Long, ContentValues> createMemberInfoFromLocalLib(Context context, ArrayList<Long> ids) {
        String[] MEMBER_COLS = new String[]{"_id", "_data", "album", "artist", "duration", "title"};
        if (ids == null || ids.size() == 0) {
            return null;
        }
        Cursor c = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, MEMBER_COLS, SqlUtils.wrapWithBlacklist(context, "_id IN " + SqlUtils.concatNumberAsSet(ids)), null, null);
        HashMap<Long, ContentValues> res = new HashMap();
        if (c == null) {
            return null;
        }
        try {
            if (c.getCount() <= 0) {
                res = null;
            } else {
                int idIdx = c.getColumnIndex("_id");
                int dataIdx = c.getColumnIndex("_data");
                int titleIdx = c.getColumnIndexOrThrow("title");
                int albumIdx = c.getColumnIndex("album");
                int artistIdx = c.getColumnIndex("artist");
                int durationIdx = c.getColumnIndex("duration");
                c.moveToFirst();
                while (!c.isAfterLast()) {
                    ContentValues cv = new ContentValues();
                    long key = c.getLong(idIdx);
                    cv.put("audio_id", Long.valueOf(key));
                    cv.put("_data", c.getString(dataIdx));
                    cv.put("title", c.getString(titleIdx));
                    cv.put("album", c.getString(albumIdx));
                    cv.put("artist", c.getString(artistIdx));
                    cv.put("duration", Integer.valueOf(c.getInt(durationIdx)));
                    res.put(Long.valueOf(key), cv);
                    c.moveToNext();
                }
            }
            c.close();
            return res;
        } catch (Throwable th) {
            c.close();
        }
    }

    public static ArrayList<ContentValues> createMemberInfoByProviderId(Context context, Collection<Audio> audioList, String provider, int playOrder) {
        if (CollectionHelper.isEmpty(audioList)) {
            return null;
        }
        ArrayList<ContentValues> ret = new ArrayList(audioList.size());
        for (Audio audio : audioList) {
            if (audio != null) {
                ContentValues cv = new ContentValues();
                cv.put("_data", MetaManager.UNKNOWN_STRING);
                cv.put("mi_online_id", audio.getId());
                String name = noNullValue(audio.getTitle());
                String album = noNullValue(audio.getAlbumName());
                String artist = noNullValue(audio.getArtistName());
                String cpSongId = noNullValue(audio.getCpSongId());
                cv.put("title", name);
                cv.put("album", album);
                cv.put("artist", artist);
                cv.put("provider_id", provider);
                cv.put("online_id", cpSongId);
                cv.put("duration", Long.valueOf(audio.getDurationInSec()));
                int playOrder2 = playOrder + 1;
                cv.put("play_order", Integer.valueOf(playOrder));
                ret.add(cv);
                playOrder = playOrder2;
            }
        }
        return ret;
    }

    private static String noNullValue(String str) {
        return str == null ? MetaManager.UNKNOWN_STRING : str;
    }

    public static int removeMembersFromDB(Context context, long playlistId, long[] audioIds) {
        if (playlistId < 0 || audioIds == null) {
            return -1;
        }
        Uri uri = Members.getMembersUri(playlistId);
        String removeSet = SqlUtils.concatAsSet(audioIds);
        ContentValues values = new ContentValues(1);
        values.put("mi_sync_track_state", Integer.valueOf(1));
        return context.getContentResolver().update(uri, values, "audio_id IN " + removeSet + " AND " + "mi_sync_track_state" + "!=" + 1, null);
    }

    public static int removeOnlineMembersFromDB(Context context, long playlistId, Collection<String> onlineIds, String provider) {
        if (playlistId < 0 || CollectionHelper.isEmpty(onlineIds)) {
            return -1;
        }
        SQLArguments argument = SqlUtils.concatStringFilter("mi_online_id", onlineIds, " OR ");
        if (argument == null) {
            return 0;
        }
        Uri uri = Members.getMembersUri(playlistId);
        String where = "provider_id=? AND (" + argument.mSelection + ")" + " AND " + "mi_sync_track_state" + "!=" + 1;
        String[] args = new String[(argument.mArgs.length + 1)];
        args[0] = provider;
        System.arraycopy(argument.mArgs, 0, args, 1, argument.mArgs.length);
        ContentValues values = new ContentValues(1);
        values.put("mi_sync_track_state", Integer.valueOf(1));
        return context.getContentResolver().update(uri, values, where, args);
    }

    public static void clearNowplayingList(Context context) {
        context.getContentResolver().delete(MiuiNowPlayingAudio.EXTERNAL_URI, null, null);
    }

    public static long[] updateNowplayingList(Context context, Collection<MusicMeta> data, boolean append) {
        int total;
        int onlineCount;
        ArrayList<Audio> items = new ArrayList();
        for (MusicMeta meta : data) {
            if (meta.isOnline()) {
                Audio audio = OnlineMusicProxy.newAudio(meta);
                if (audio != null) {
                    items.add(audio);
                }
            }
        }
        long[] onlineIds = null;
        if (items.isEmpty()) {
            total = data.size();
            onlineCount = 0;
        } else {
            onlineIds = updateNowplayingList(context, items, OnlineMusicProxy.getProviderName(context), append);
            onlineCount = onlineIds != null ? onlineIds.length : 0;
            total = (data.size() - items.size()) + onlineCount;
            if (total > data.size()) {
                Log.e(TAG, String.format("updateNowplayingList failed: item size=%d, online_id size=%d", new Object[]{Integer.valueOf(items.size()), Integer.valueOf(onlineCount)}));
                return null;
            }
        }
        long[] ids = new long[total];
        int i = 0;
        int j = 0;
        for (MusicMeta meta2 : data) {
            int i2;
            if (!meta2.isOnline()) {
                i2 = i + 1;
                ids[i] = meta2.mLocalId;
                i = i2;
            } else if (j < onlineCount && onlineIds != null) {
                i2 = i + 1;
                int j2 = j + 1;
                ids[i] = onlineIds[j];
                j = j2;
                i = i2;
            }
        }
        return ids;
    }

    public static long[] updateNowplayingList(Context context, Collection<Audio> audioList, String provider, boolean append) {
        int base = 0;
        if (CollectionHelper.isEmpty(audioList)) {
            return null;
        }
        ContentResolver resolver = context.getContentResolver();
        Uri uri = MiuiNowPlayingAudio.EXTERNAL_URI;
        if (append) {
            base = SqlUtils.getRecordCount(context, uri);
        } else {
            clearNowplayingList(context);
        }
        long[] jArr = null;
        ArrayList<ContentValues> valueList = createMemberInfoByProviderId(context, audioList, provider, base);
        if (valueList == null) {
            return null;
        }
        ContentValues[] valueArr = new ContentValues[valueList.size()];
        valueList.toArray(valueArr);
        resolver.bulkInsert(uri, valueArr);
        Cursor c = queryAudioIdForNowPlaying(context, base);
        if (c == null) {
            return null;
        }
        try {
            jArr = new long[c.getCount()];
            c.moveToFirst();
            int i = 0;
            while (!c.isAfterLast()) {
                int i2 = i + 1;
                jArr[i] = c.getLong(0);
                c.moveToNext();
                i = i2;
            }
            return jArr;
        } finally {
            c.close();
        }
    }

    public static long[] updateNowplayingList(Context context, long[] ids, boolean append) {
        Throwable th;
        int base = 0;
        if (!append) {
            clearNowplayingList(context);
        }
        if (ids == null) {
            return null;
        }
        int i;
        ContentResolver resolver = context.getContentResolver();
        Uri uri = MiuiNowPlayingAudio.EXTERNAL_URI;
        if (append) {
            base = SqlUtils.getRecordCount(context, uri);
        }
        Object ret = new long[ids.length];
        System.arraycopy(ids, 0, ret, 0, ids.length);
        ArrayList<Long> idList = new ArrayList();
        ArrayList<Integer> indexList = new ArrayList();
        for (i = 0; i < ret.length; i++) {
            if (PlayerProvider.isOnlineAudio(ret[i])) {
                idList.add(Long.valueOf(ret[i]));
                indexList.add(Integer.valueOf(i));
            }
        }
        if (idList.size() == 0) {
            return ret;
        }
        if (HistoryManager.moveHistoryToNowplayingOnline(context, idList)) {
            return ids;
        }
        HashMap<Long, ContentValues> valueMap = createMemberInfoFromPlaylist(context, idList);
        if (valueMap == null) {
            return ret;
        }
        ContentValues[] valueArr = new ContentValues[valueMap.size()];
        int playerOrder = base;
        i = 0;
        Iterator i$ = idList.iterator();
        while (i$.hasNext()) {
            ContentValues cv = (ContentValues) valueMap.get(Long.valueOf(((Long) i$.next()).longValue()));
            if (cv != null) {
                int playerOrder2 = playerOrder + 1;
                cv.put("play_order", Integer.valueOf(playerOrder));
                int i2 = i + 1;
                valueArr[i] = cv;
                i = i2;
                playerOrder = playerOrder2;
            }
        }
        resolver.bulkInsert(uri, valueArr);
        int assignedIndexCount = 0;
        int indexSize = indexList.size();
        Cursor c = queryAudioIdForNowPlaying(context, base);
        if (c != null) {
            try {
                c.moveToFirst();
                int assignedIndexCount2 = 0;
                while (!c.isAfterLast() && assignedIndexCount2 < indexSize) {
                    try {
                        assignedIndexCount = assignedIndexCount2 + 1;
                        ret[((Integer) indexList.get(assignedIndexCount2)).intValue()] = c.getLong(0);
                        c.moveToNext();
                        assignedIndexCount2 = assignedIndexCount;
                    } catch (Throwable th2) {
                        th = th2;
                        assignedIndexCount = assignedIndexCount2;
                    }
                }
                c.close();
                assignedIndexCount = assignedIndexCount2;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        while (assignedIndexCount < indexSize) {
            ret[((Integer) indexList.get(assignedIndexCount)).intValue()] = 0;
            assignedIndexCount++;
        }
        return ret;
        c.close();
        throw th;
    }

    private static Cursor queryAudioIdForNowPlaying(Context context, int minOrder) {
        return context.getContentResolver().query(MiuiNowPlayingAudio.EXTERNAL_URI, new String[]{"_id"}, "play_order >= " + minOrder, null, "play_order");
    }

    public static long getDownloadedAudioId(Context context, String tr, String ar, long audioId) {
        if (audioId > 0 && !PlayerProvider.isOnlineAudio(audioId)) {
            return audioId;
        }
        if (TextUtils.isEmpty(tr) && TextUtils.isEmpty(ar)) {
            return 0;
        }
        long ret = 0;
        if (MetaManager.getSavedFilePath(tr, ar, StorageConfig.META_TYPE_MP3) != null) {
            Cursor c = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{path}, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    ret = c.getLong(0);
                }
                c.close();
            }
        }
        return ret;
    }

    public static Cursor queryNormalEqualizer(Context context) {
        return context.getContentResolver().query(MiuiEqualizer.EXTERNAL_URI, null, "_id != 0", null, "_id");
    }

    public static int[] decodeEqualizerConfig(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONArray arr = new JSONArray(str);
            int[] ret = new int[arr.length()];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = arr.getInt(i);
            }
            return ret;
        } catch (JSONException e) {
            return null;
        }
    }

    public static String codeEqualizerConfig(int[] src) {
        if (src == null) {
            return null;
        }
        JSONArray arr = new JSONArray();
        for (int put : src) {
            arr.put(put);
        }
        return arr.toString();
    }

    public static int[] getEuqalizerDefaultData() {
        int[] levels = new int[5];
        for (int i = 0; i < 5; i++) {
            levels[i] = 0;
        }
        return levels;
    }

    public static int[] getEqualizerConfigData(Context context, int id) {
        return getEqualizerConfigData(context, id, false);
    }

    public static int[] getEqualizerConfigData(Context context, int id, boolean allowNull) {
        int[] levels = null;
        if (id != -1) {
            Cursor c = context.getContentResolver().query(ContentUris.withAppendedId(MiuiEqualizer.EXTERNAL_URI, (long) id), new String[]{"_data"}, null, null, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    levels = decodeEqualizerConfig(c.getString(0));
                }
                c.close();
            }
            if (!(levels == null || levels.length == 5)) {
                levels = null;
            }
        }
        if (levels != null || allowNull) {
            return levels;
        }
        return getEuqalizerDefaultData();
    }

    public static int getEqualizerIdByName(Context context, String defaultName) {
        int ret = -1;
        Cursor c = context.getContentResolver().query(MiuiEqualizer.EXTERNAL_URI, new String[]{"_id"}, "name=?", new String[]{defaultName}, null);
        if (c != null) {
            if (c.moveToFirst()) {
                ret = c.getInt(0);
            }
            c.close();
        }
        return ret;
    }

    public static int updateEqualizerConfig(Context context, int id, int[] src) {
        Uri uri = ContentUris.withAppendedId(MiuiEqualizer.EXTERNAL_URI, (long) id);
        ContentValues cv = new ContentValues(2);
        cv.put("_data", codeEqualizerConfig(src));
        return context.getContentResolver().update(uri, cv, null, null);
    }

    public static Uri createEqualizerConfig(Context context, String name, String data) {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        ContentResolver resolver = context.getContentResolver();
        ContentValues values = new ContentValues(2);
        values.put("name", name);
        values.put("_data", data);
        int id = idForEqualizer(context, name);
        if (id < 0) {
            return resolver.insert(MiuiEqualizer.EXTERNAL_URI, values);
        }
        Uri uri = ContentUris.withAppendedId(MiuiEqualizer.EXTERNAL_URI, (long) id);
        resolver.update(uri, values, null, null);
        return uri;
    }

    public static int idForEqualizer(Context context, String name) {
        Context context2 = context;
        Cursor c = SqlUtils.query(context2, MiuiEqualizer.EXTERNAL_URI, new String[]{"_id"}, "name=?", new String[]{name}, "name");
        int id = -1;
        if (c != null) {
            c.moveToFirst();
            if (!c.isAfterLast()) {
                id = c.getInt(0);
            }
            c.close();
        }
        return id;
    }

    public static int guessAudioIdColumnIndex(Cursor c) {
        try {
            return c.getColumnIndexOrThrow("audio_id");
        } catch (IllegalArgumentException e) {
            return c.getColumnIndexOrThrow("_id");
        }
    }
}
