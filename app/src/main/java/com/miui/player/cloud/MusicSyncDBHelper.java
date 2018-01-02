package com.miui.player.cloud;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import com.miui.player.meta.Audio;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioOutline;
import com.miui.player.meta.MetaManager;
import com.miui.player.plugin.onlinesync.BaiduSyncManager;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.IndeterminateIds;
import com.miui.player.provider.KtvPlaylistCache;
import com.miui.player.provider.PlayerStore.BaiduSyncState;
import com.miui.player.provider.PlayerStore.MemberColomns;
import com.miui.player.provider.PlayerStore.MiuiAudioPlaylistView;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Columns;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.util.SqlUtils;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.Result;
import com.xiaomi.music.cloud.CloudCommand;
import com.xiaomi.music.cloud.CloudEngine;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.MusicCloudServerException;
import com.xiaomi.music.cloud.model.DeleteInfo;
import com.xiaomi.music.cloud.model.Playlist;
import com.xiaomi.music.cloud.model.PlaylistInfo;
import com.xiaomi.music.cloud.model.Track;
import com.xiaomi.music.cloud.model.TrackInfo;
import com.xiaomi.music.online.OnlineEngine;
import com.xiaomi.music.online.model.Song;
import com.xiaomi.music.online.model.SongList;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.NetworkUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.json.JSONException;

class MusicSyncDBHelper {
    private static final String CLOUD_DB_UPDATE_INDETERMINATE_IDS = "cloud_db_update_indeterminate_ids";
    static final String TAG = "MusicSyncDBHelper";

    MusicSyncDBHelper() {
    }

    public static List<Long> getFilterTags(Context context, long from) {
        List<Long> result = Lists.newArrayList();
        String where = String.format("%s>? AND %s=?", new Object[]{"mi_sync_playlist_tag", "mi_sync_playlist_state"});
        Cursor cursor = SqlUtils.query(context, MiuiPlaylists.EXTERNAL_URI, new String[]{"mi_sync_playlist_tag"}, where, new String[]{String.valueOf(from), String.valueOf(3)}, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    result.add(Long.valueOf(cursor.getLong(0)));
                } finally {
                    cursor.close();
                }
            }
        }
        where = String.format("%s>? AND %s=?", new Object[]{"mi_sync_track_tag", "mi_sync_track_state"});
        cursor = SqlUtils.query(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, new String[]{"mi_sync_track_tag"}, where, new String[]{String.valueOf(from), String.valueOf(3)}, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    result.add(Long.valueOf(cursor.getLong(0)));
                } finally {
                    cursor.close();
                }
            }
        }
        return result;
    }

    public static void mergeTrack(Context context, Track track, Map<String, Song> songs) throws MusicSyncException {
        synchronized (MiuiPlaylists.EXTERNAL_URI) {
            MusicLog.m395d(TAG, "Merge track, track=" + track);
            if (track.mStatus == 0) {
                handleNormalTrack(context, track, songs);
            } else if (track.mStatus == 1) {
                handleDeleteTrack(context, track);
            } else {
                MusicLog.m404w(TAG, "Unhandle track, obj=" + track);
            }
        }
    }

    private static void handleNormalTrack(Context context, Track track, Map<String, Song> tracks) throws MusicSyncException {
        String where = String.format("%s=? AND %s=? ", new Object[]{"mi_online_id", "mi_sync_playlist_id"});
        String[] columns = new String[]{"mi_sync_track_state", MemberColomns.PLAYLIST_ID, "mi_online_id"};
        Cursor cursor = SqlUtils.query(context, MiuiAudioPlaylistView.EXTERNAL_URI, columns, where, new String[]{((TrackInfo) track.mInfo).getOnlineId(), ((TrackInfo) track.mInfo).getPlaylistCloudId()}, null, 1);
        if (cursor == null) {
            throw new MusicSyncException("Query db failed, obj=" + track);
        }
        boolean update = false;
        String miOnlineId = null;
        try {
            long playlistId;
            if (cursor.moveToFirst()) {
                playlistId = cursor.getLong(1);
                miOnlineId = cursor.getString(2);
                int state = cursor.getInt(0);
                MusicLog.m395d(TAG, "Track exists, track=" + track + ", state=" + state);
                if (state == 0 || state == 3) {
                    update = true;
                } else {
                    MusicLog.m404w(TAG, "Unhandle state, state=" + state);
                }
            } else {
                MusicLog.m395d(TAG, "Track does not exist, track=" + track);
                playlistId = queryPlaylistIdByCloudId(context, ((TrackInfo) track.mInfo).getPlaylistCloudId());
                if (playlistId >= 0) {
                    Song song = (Song) tracks.get(((TrackInfo) track.mInfo).getOnlineId());
                    if (song != null) {
                        miOnlineId = song.mId;
                        Context context2 = context;
                        PlaylistHelper.addOnlineToPlaylist(context2, Arrays.asList(new Audio[]{songToAudio(song)}), song.mCpId, playlistId, false, false);
                        update = true;
                    } else {
                        MusicLog.m397e(TAG, "*** Cannot find song, obj=" + track);
                    }
                } else {
                    MusicLog.m404w(TAG, "No playlist, obj=" + track);
                }
            }
            if (update && playlistId >= 0 && miOnlineId != null) {
                ContentValues cv = new ContentValues();
                cv.put("mi_sync_track_id", ((TrackInfo) track.mInfo).getCloudId());
                cv.put("mi_sync_track_state", Integer.valueOf(3));
                cv.put("mi_sync_track_tag", Long.valueOf(track.mSyncTag));
                cv.put("date_added", Long.valueOf(((TrackInfo) track.mInfo).getAddTime()));
                Context context3 = context;
                SqlUtils.update(context3, MiuiPlaylistsAudioMap.EXTERNAL_URI, cv, String.format("%s=? AND %s=? AND (%s=? OR (%s=? AND %s!=?))", new Object[]{MemberColomns.PLAYLIST_ID, "mi_online_id", "mi_sync_track_state", "mi_sync_track_state", "mi_sync_track_tag"}), new String[]{String.valueOf(playlistId), miOnlineId, String.valueOf(0), String.valueOf(3), String.valueOf(track.mSyncTag)});
            }
            cursor.close();
        } catch (Throwable th) {
            cursor.close();
        }
    }

    private static void handleDeleteTrack(Context context, Track track) throws MusicSyncException {
        long playlistId = queryPlaylistIdByCloudId(context, ((TrackInfo) track.mInfo).getPlaylistCloudId());
        MusicLog.m395d(TAG, "Delete track, track=" + track + ", playlist id=" + playlistId);
        if (playlistId >= 0) {
            MusicLog.m395d(TAG, "Delete track, track=" + track + ", delete count=" + SqlUtils.delete(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, String.format("(%s=? AND %s=? AND (%s=? OR %s=?))", new Object[]{MemberColomns.PLAYLIST_ID, "mi_online_id", "mi_sync_track_state", "mi_sync_track_state"}), new String[]{String.valueOf(playlistId), ((TrackInfo) track.mInfo).getOnlineId(), String.valueOf(3), String.valueOf(1)}));
        }
    }

    private static long queryPlaylistIdByCloudId(Context context, String playlistCloudId) throws MusicSyncException {
        Context context2 = context;
        Cursor plCursor = SqlUtils.query(context2, MiuiPlaylists.EXTERNAL_URI, new String[]{"_id"}, "mi_sync_playlist_id=?", new String[]{playlistCloudId}, null);
        if (plCursor != null) {
            try {
                long j;
                if (plCursor.moveToFirst()) {
                    j = plCursor.getLong(0);
                } else {
                    j = -1;
                }
                plCursor.close();
                return j;
            } catch (Throwable th) {
                plCursor.close();
            }
        } else {
            throw new MusicSyncException("Query db failed, playlistCloudId=" + playlistCloudId);
        }
    }

    public static void mergePlaylist(Context context, Playlist playlist) throws MusicSyncException {
        synchronized (MiuiPlaylists.EXTERNAL_URI) {
            if (playlist.mStatus == 0) {
                handleNormalPlaylist(context, playlist);
            } else if (playlist.mStatus == 1) {
                handleDeletePlaylist(context, playlist);
            } else {
                MusicLog.m404w(TAG, "Unhandle playlist, obj=" + playlist);
            }
        }
    }

    private static void handleDeletePlaylist(Context context, Playlist playlist) {
        SqlUtils.delete(context, MiuiPlaylists.EXTERNAL_URI, String.format("%s=? AND (%s=? OR %s=?)", new Object[]{"mi_sync_playlist_id", "mi_sync_playlist_state", "mi_sync_playlist_state"}), new String[]{((PlaylistInfo) playlist.mInfo).getCloudId(), String.valueOf(1), String.valueOf(3)});
    }

    private static void handleNormalPlaylist(Context context, Playlist playlist) throws MusicSyncException {
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, MiuiPlaylists.EXTERNAL_URI, new String[]{"mi_sync_playlist_state"}, String.format("%s=? AND %s=?", new Object[]{"name", "list_type"}), new String[]{((PlaylistInfo) playlist.mInfo).getName(), String.valueOf(((PlaylistInfo) playlist.mInfo).getType())}, null, 1);
        if (cursor == null) {
            throw new MusicSyncException("Open db failed, obj=" + playlist);
        }
        boolean accept = false;
        try {
            if (cursor.moveToFirst()) {
                int state = cursor.getInt(0);
                if (state == 0 || state == 3) {
                    accept = true;
                }
            } else {
                PlaylistHelper.createPlaylist(context, ((PlaylistInfo) playlist.mInfo).getOnlineId(), ((PlaylistInfo) playlist.mInfo).getName(), ((PlaylistInfo) playlist.mInfo).getType());
                accept = true;
            }
            if (accept) {
                ContentValues cv = new ContentValues();
                cv.put("mi_sync_playlist_id", ((PlaylistInfo) playlist.mInfo).getCloudId());
                cv.put("mi_sync_playlist_state", Integer.valueOf(3));
                cv.put("mi_sync_playlist_tag", Long.valueOf(playlist.mSyncTag));
                cv.put(Columns.DATE_MODIFIED, Long.valueOf(((PlaylistInfo) playlist.mInfo).getCreateTime()));
                SqlUtils.update(context, MiuiPlaylists.EXTERNAL_URI, cv, String.format("%s=? AND %s=? AND (%s=? OR (%s=? AND %s!=?))", new Object[]{"name", "list_type", "mi_sync_playlist_state", "mi_sync_playlist_state", "mi_sync_playlist_tag"}), new String[]{((PlaylistInfo) playlist.mInfo).getName(), String.valueOf(((PlaylistInfo) playlist.mInfo).getType()), String.valueOf(0), String.valueOf(3), String.valueOf(playlist.mSyncTag)});
            }
            cursor.close();
        } catch (Throwable th) {
            cursor.close();
        }
    }

    public static void uploadTrack(Context context, Account account, MusicAuthToken token) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException {
        String[] projection = new String[]{"_id", "mi_online_id", "mi_sync_track_id", "mi_sync_track_state", "mi_sync_playlist_id"};
        String where = String.format("%s!=?", new Object[]{"mi_sync_track_state"});
        String[] args = new String[]{String.valueOf(3)};
        CloudEngine engine = MusicEngine.get(context).getCloudEngine();
        List<CloudCommand<Track>> addTracks = Lists.newArrayList();
        List<CloudCommand<DeleteInfo>> delTracks = Lists.newArrayList();
        List<Long> localDelIds = Lists.newArrayList();
        List<Long> cloudDelIds = Lists.newArrayList();
        List<Long> cloudAddIds = Lists.newArrayList();
        Cursor cursor = SqlUtils.query(context, MiuiAudioPlaylistView.EXTERNAL_URI, projection, where, args, "date_added ASC");
        if (cursor != null) {
            Context context2;
            int size;
            int i;
            while (cursor.moveToNext()) {
                try {
                    int state = cursor.getInt(3);
                    String playlistCloudId;
                    if (state == 1) {
                        playlistCloudId = cursor.getString(4);
                        String trackCloudId = cursor.getString(2);
                        if (TextUtils.isEmpty(trackCloudId) || TextUtils.isEmpty(playlistCloudId)) {
                            localDelIds.add(Long.valueOf(cursor.getLong(0)));
                            MusicLog.m395d(TAG, "Upload track[local cloud], id=" + cursor.getLong(0));
                        } else {
                            delTracks.add(engine.deleteTrackFromPlaylist(account, token, playlistCloudId, trackCloudId));
                            cloudDelIds.add(Long.valueOf(cursor.getLong(0)));
                            MusicLog.m395d(TAG, "Upload track[delete cloud], trackCloudId=" + trackCloudId + ", playlistCloudId=" + playlistCloudId);
                        }
                    } else if (state == 0) {
                        playlistCloudId = cursor.getString(4);
                        String trackOnlineId = cursor.getString(1);
                        if (!(TextUtils.isEmpty(trackOnlineId) || TextUtils.isEmpty(playlistCloudId) || IndeterminateIds.isValid(trackOnlineId))) {
                            addTracks.add(engine.addTrackToPlaylist(account, token, playlistCloudId, trackOnlineId));
                            cloudAddIds.add(Long.valueOf(cursor.getLong(0)));
                            MusicLog.m395d(TAG, "Upload track[insert], trackOnlineId=" + trackOnlineId + ", playlistCloudId=" + playlistCloudId);
                        }
                    } else {
                        MusicLog.m404w(TAG, "Unhandle state, obj=" + cursor.getString(0));
                    }
                } finally {
                    cursor.close();
                }
            }
            if (!localDelIds.isEmpty()) {
                context2 = context;
                MusicLog.m395d(TAG, "Delete track local, expect count=" + localDelIds.size() + ", success count=" + SqlUtils.delete(context2, MiuiPlaylistsAudioMap.EXTERNAL_URI, "_id in " + SqlUtils.concatNumberAsSet(localDelIds), null));
            }
            if (!delTracks.isEmpty()) {
                List<Result<DeleteInfo>> result = engine.applyBatch(delTracks);
                int count = 0;
                size = Math.min(result.size(), delTracks.size());
                for (i = 0; i < size; i++) {
                    if (((Result) result.get(i)).mErrorCode != 0) {
                        cloudDelIds.set(i, Long.valueOf(-1));
                    } else {
                        count++;
                    }
                }
                if (count > 0) {
                    context2 = context;
                    SqlUtils.delete(context2, MiuiPlaylistsAudioMap.EXTERNAL_URI, "_id in " + SqlUtils.concatNumberAsSet(cloudDelIds), null);
                }
                MusicLog.m395d(TAG, "Delete track cloud, expect count=" + delTracks.size() + ", success count=" + count);
            }
            if (!addTracks.isEmpty()) {
                List<Result<Track>> result2 = engine.applyBatch(addTracks);
                ContentValues values = new ContentValues();
                size = Math.min(cloudAddIds.size(), result2.size());
                for (i = 0; i < size; i++) {
                    Result<Track> r = (Result) result2.get(i);
                    if (r.mErrorCode == 0) {
                        Track track = r.mData;
                        if (track != null) {
                            values.clear();
                            values.put("mi_sync_track_id", ((TrackInfo) track.mInfo).getCloudId());
                            values.put("mi_sync_track_state", Integer.valueOf(3));
                            values.put("mi_sync_track_tag", Long.valueOf(track.mSyncTag));
                            values.put("date_added", Long.valueOf(((TrackInfo) track.mInfo).getAddTime()));
                            context2 = context;
                            SqlUtils.update(context2, MiuiPlaylistsAudioMap.EXTERNAL_URI, values, String.format("%s=? AND %s=?", new Object[]{"_id", "mi_sync_track_state"}), new String[]{String.valueOf(cloudAddIds.get(i)), String.valueOf(0)});
                            MusicLog.m395d(TAG, "Add track cloud, track=" + track);
                        }
                    }
                }
            }
        }
    }

    public static void uploadPlaylist(Context context, Account account, MusicAuthToken token) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException {
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, MiuiPlaylists.EXTERNAL_URI, new String[]{"_id", "name", "list_type", "mi_sync_playlist_state", "mi_sync_playlist_id", Columns.MI_ONLINE_LIST_ID}, String.format("%s!=? AND %s>=0", new Object[]{"mi_sync_playlist_state", "list_type"}), new String[]{String.valueOf(3)}, "date_modified ASC");
        if (cursor != null) {
            Context context3;
            int size;
            int i;
            List<CloudCommand<Playlist>> addPlaylists = Lists.newArrayList();
            List<Long> cloudAddIds = Lists.newArrayList();
            List<CloudCommand<DeleteInfo>> delPlaylists = Lists.newArrayList();
            List<Long> cloudDelIds = Lists.newArrayList();
            List<Long> localDelIds = Lists.newArrayList();
            CloudEngine engine = MusicEngine.get(context).getCloudEngine();
            while (cursor.moveToNext()) {
                try {
                    int state = cursor.getInt(3);
                    String playlistCloudId;
                    if (state == 0) {
                        String name = cursor.getString(1);
                        int type = cursor.getInt(2);
                        playlistCloudId = cursor.getString(4);
                        addPlaylists.add(engine.createPlaylist(account, token, name, type, playlistCloudId, cursor.getString(5)));
                        cloudAddIds.add(Long.valueOf(cursor.getLong(0)));
                        MusicLog.m395d(TAG, "Upload playlist[insert], name=" + name + ", type=" + type + ", playlistCloudId=" + playlistCloudId);
                    } else if (state == 1) {
                        playlistCloudId = cursor.getString(4);
                        if (TextUtils.isEmpty(playlistCloudId)) {
                            localDelIds.add(Long.valueOf(cursor.getLong(0)));
                            MusicLog.m395d(TAG, "Upload playlist[delete local], id=" + cursor.getLong(0));
                        } else {
                            delPlaylists.add(engine.deletePlaylist(account, token, playlistCloudId));
                            cloudDelIds.add(Long.valueOf(cursor.getLong(0)));
                            MusicLog.m395d(TAG, "Upload playlist[delete cloud], playlistCloudId=" + playlistCloudId);
                        }
                    } else {
                        MusicLog.m404w(TAG, "Unhandle state, obj=" + cursor.getString(0));
                    }
                } finally {
                    cursor.close();
                }
            }
            if (!localDelIds.isEmpty()) {
                context3 = context;
                MusicLog.m395d(TAG, "Delete playlist local, expect count=" + localDelIds.size() + ", success count=" + SqlUtils.delete(context3, MiuiPlaylists.EXTERNAL_URI, "_id in " + SqlUtils.concatNumberAsSet(localDelIds), null));
            }
            if (!delPlaylists.isEmpty()) {
                List<Result<DeleteInfo>> result = engine.applyBatch(delPlaylists);
                int count = 0;
                size = Math.min(result.size(), cloudDelIds.size());
                for (i = 0; i < size; i++) {
                    if (((Result) result.get(i)).mErrorCode != 0) {
                        cloudDelIds.set(i, Long.valueOf(-1));
                    } else {
                        count++;
                    }
                }
                if (count > 0) {
                    context3 = context;
                    SqlUtils.delete(context3, MiuiPlaylists.EXTERNAL_URI, "_id in " + SqlUtils.concatNumberAsSet(cloudDelIds), null);
                }
                MusicLog.m395d(TAG, "Delete playlist cloud, expect count=" + delPlaylists.size() + ", success count=" + count);
            }
            if (!addPlaylists.isEmpty()) {
                List<Result<Playlist>> result2 = engine.applyBatch(addPlaylists);
                size = Math.min(result2.size(), cloudAddIds.size());
                ContentValues values = new ContentValues();
                for (i = 0; i < size; i++) {
                    Result<Playlist> r = (Result) result2.get(i);
                    if (r.mErrorCode == 0) {
                        Playlist pl = r.mData;
                        if (pl != null) {
                            values.clear();
                            values.put("mi_sync_playlist_id", ((PlaylistInfo) pl.mInfo).getCloudId());
                            values.put("mi_sync_playlist_tag", Long.valueOf(pl.mSyncTag));
                            values.put("mi_sync_playlist_state", Integer.valueOf(3));
                            values.put(Columns.DATE_MODIFIED, Long.valueOf(((PlaylistInfo) pl.mInfo).getCreateTime()));
                            context3 = context;
                            SqlUtils.update(context3, MiuiPlaylists.EXTERNAL_URI, values, String.format("%s=? AND %s=?", new Object[]{"_id", "mi_sync_playlist_state"}), new String[]{String.valueOf(cloudAddIds.get(i)), String.valueOf(0)});
                            MusicLog.m395d(TAG, "Upload playlist cloud, playlist=" + pl);
                        }
                    }
                }
            }
        }
    }

    public static Map<String, Song> getAllOnlineSongs(Context context, Set<String> unknownIds) throws MusicSyncException {
        Map<String, Song> result = Maps.newHashMap();
        getSongsFromDB(context, unknownIds, result);
        if (unknownIds.size() != result.size()) {
            for (String songId : result.keySet()) {
                unknownIds.remove(songId);
            }
            getSongsFromOnline(context, unknownIds, result);
        }
        return result;
    }

    private static void getSongsFromOnline(Context context, Set<String> unknownIds, Map<String, Song> result) throws MusicSyncException {
        OnlineEngine engine = MusicEngine.get(context).getOnlineEngine();
        List<String> ids = Lists.newArrayList();
        ids.addAll(unknownIds);
        Result<SongList> list = engine.getSongsDetail(context, ids);
        if (list.mErrorCode != 1 || list.mData == null) {
            throw new MusicSyncException("get songs from online error! code=" + list.mErrorCode);
        }
        List<Song> songs = ((SongList) list.mData).getContent();
        if (songs != null) {
            for (Song s : songs) {
                result.put(s.mId, s);
            }
        }
    }

    private static void getSongsFromDB(Context context, Set<String> ids, Map<String, Song> result) {
        String[] projection = new String[]{"mi_online_id", "provider_id", "online_id", "title", "artist", "album"};
        String set = SqlUtils.concatStringAsSet(ids);
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, MiuiPlaylistsAudioMap.EXTERNAL_URI, projection, String.format("%s in %s", new Object[]{"mi_online_id", set}), null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    String songId = cursor.getString(0);
                    Song song = new Song(songId, cursor.getString(1), cursor.getString(2), cursor.getString(3));
                    song.mArtistName = cursor.getString(4);
                    song.mAlbumName = cursor.getString(5);
                    result.put(songId, song);
                } finally {
                    cursor.close();
                }
            }
        }
    }

    public static void updateDatabase(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        if (!sp.getBoolean(CLOUD_DB_UPDATE_INDETERMINATE_IDS, false) && updateIndeterminateIds(context)) {
            sp.edit().putBoolean(CLOUD_DB_UPDATE_INDETERMINATE_IDS, true).commit();
        }
    }

    private static boolean updateIndeterminateIds(Context context) {
        if (!NetworkUtil.isActive(context)) {
            return false;
        }
        Cursor cursor = SqlUtils.query(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, new String[]{"mi_online_id"}, null, null, null);
        if (cursor == null) {
            return false;
        }
        List<String> ids = Lists.newArrayList();
        while (cursor.moveToNext()) {
            try {
                String id = cursor.getString(0);
                if (IndeterminateIds.isValid(id)) {
                    ids.add(IndeterminateIds.getId(id));
                }
            } finally {
                cursor.close();
            }
        }
        if (ids.isEmpty()) {
            return true;
        }
        Result<SongList> result = MusicEngine.get(context).getOnlineEngine().getSongsDetailByBaiduOnlineIds(context, ids);
        if (result.mErrorCode == 1 && result.mData != null) {
            ContentValues values = new ContentValues();
            String[] args = new String[1];
            for (Song s : ((SongList) result.mData).getContent()) {
                values.clear();
                values.put("mi_online_id", s.mId);
                args[0] = IndeterminateIds.toIndeterminateId(s.mCpSongId, s.mCpId);
                SqlUtils.update(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, values, "mi_online_id=?", args);
            }
        }
        return false;
    }

    private static Audio songToAudio(Song s) {
        Audio audio = new Audio(new AudioOutline(s.mId, s.mName));
        audio.mDetail = new AudioDetail();
        audio.mDetail.mAlbumName = s.mAlbumName;
        audio.mDetail.mArtistName = s.mArtistName;
        return audio;
    }

    public static boolean syncFromBaidu(Context context) {
        return BaiduSyncManager.sync(context);
    }

    public static void cleanTimeOutTag(Context context) {
        SqlUtils.delete(context, MiuiPlaylists.EXTERNAL_URI, "mi_sync_playlist_state=?", new String[]{String.valueOf(3)});
        SqlUtils.delete(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, "mi_sync_track_state=?", new String[]{String.valueOf(3)});
    }

    public static void wipePlaylists(Context context) {
        MusicLog.m399i(TAG, "Clear all data");
        synchronized (MiuiPlaylists.EXTERNAL_URI) {
            SqlUtils.delete(context, MiuiPlaylists.EXTERNAL_URI, null, null);
            FavoriteCache.reset();
            KtvPlaylistCache.reset();
        }
    }

    public static void clearSyncState(Context context) {
        Throwable th;
        MusicLog.m399i(TAG, "Clear all sync data");
        synchronized (MiuiPlaylistsAudioMap.EXTERNAL_URI) {
            SqlUtils.delete(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, "mi_sync_track_state=?", new String[]{String.valueOf(1)});
            ContentValues values = new ContentValues();
            values.put("sync_state", BaiduSyncState.INSERT);
            values.put("mi_sync_track_id", (String) null);
            values.put("mi_sync_track_state", Integer.valueOf(0));
            values.put("mi_sync_track_tag", Integer.valueOf(0));
            SqlUtils.update(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, values, "mi_sync_track_state=?", new String[]{String.valueOf(3)});
        }
        synchronized (MiuiPlaylists.EXTERNAL_URI) {
            try {
                SqlUtils.delete(context, MiuiPlaylists.EXTERNAL_URI, "mi_sync_playlist_state=?", new String[]{String.valueOf(1)});
                ContentValues values2 = new ContentValues();
                try {
                    values2.put("sync_state", BaiduSyncState.INSERT);
                    values2.put("mi_sync_playlist_id", (String) null);
                    values2.put("mi_sync_playlist_state", Integer.valueOf(0));
                    values2.put("mi_sync_playlist_tag", Integer.valueOf(0));
                    SqlUtils.update(context, MiuiPlaylists.EXTERNAL_URI, values2, "mi_sync_playlist_state=?", new String[]{String.valueOf(3)});
                } catch (Throwable th2) {
                    th = th2;
                    values = values2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    public static void syncByLocal(Context context) {
        Throwable th;
        synchronized (MiuiPlaylists.EXTERNAL_URI) {
            MusicLog.m395d(TAG, "Delete local playlists, count=" + SqlUtils.delete(context, MiuiPlaylists.EXTERNAL_URI, String.format("%s=? AND (%s=? OR %s is null)", new Object[]{"mi_sync_playlist_state", "mi_sync_playlist_id", "mi_sync_playlist_id"}), new String[]{String.valueOf(1), MetaManager.UNKNOWN_STRING}));
        }
        synchronized (MiuiPlaylistsAudioMap.EXTERNAL_URI) {
            try {
                String[] args = new String[]{String.valueOf(1), MetaManager.UNKNOWN_STRING};
                try {
                    MusicLog.m395d(TAG, "Delete local members, count=" + SqlUtils.delete(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, String.format("%s=? AND (%s=? OR %s is null)", new Object[]{"mi_sync_track_state", "mi_sync_track_id", "mi_sync_track_id"}), args));
                } catch (Throwable th2) {
                    th = th2;
                    String[] strArr = args;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }
}
