package com.miui.player.plugin.onlinesync;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import com.miui.player.plugin.onlinesync.SyncObject.PlaylistRecord;
import com.miui.player.plugin.onlinesync.SyncObject.TrackRecord;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkInterface;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkInterface.PlaylistResult;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkManager;
import com.miui.player.provider.IndeterminateIds;
import com.miui.player.provider.PlayerStore;
import com.miui.player.provider.PlayerStore.BaiduSyncState;
import com.miui.player.provider.PlayerStore.MemberColomns;
import com.miui.player.provider.PlayerStore.MiuiAudioPlaylistView;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Columns;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.SqlUtils.SimpleItem;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.model.Song;
import com.xiaomi.music.online.model.SongList;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.NetworkUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaiduSyncManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "BaiduSyncManager";

    public static boolean sync(Context context) {
        if (NetworkUtil.isActiveNetworkMetered(context) || !BaiduSdkManager.initSdkEnvironment()) {
            return false;
        }
        Map<String, PlaylistRecord> cloudPlaylists = BaiduSdkManager.downloadPlaylistListFromServer();
        if (cloudPlaylists == null) {
            MusicLog.m395d(TAG, "Download playlist failed");
            return false;
        }
        fillBaiduId(context);
        List<PlaylistRecord> playlists = uploadPlaylists(context, cloudPlaylists, queryPlaylistFromLocal(context));
        List<TrackRecord> allTracks = queryAllTracksFromLocal(context);
        for (PlaylistRecord pl : playlists) {
            if (!TextUtils.isEmpty(pl.mPlaylistCloudId)) {
                HashMap<String, TrackRecord> cloudTracks = BaiduSdkManager.downloadTracksFromServer(pl.mPlaylistCloudId);
                if (cloudTracks == null) {
                    MusicLog.m395d(TAG, "Download tracks failed, playlist=" + pl);
                } else {
                    uploadTracks(context, pl, cloudTracks, filterLocalTracks(pl, allTracks));
                }
            }
        }
        return true;
    }

    private static List<PlaylistRecord> queryPlaylistFromLocal(Context context) {
        List<PlaylistRecord> result = Lists.newArrayList();
        String[] projection = new String[]{"_id", "name", Columns.BAIDU_CLOUD_ID, "sync_state"};
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, MiuiPlaylists.EXTERNAL_URI, projection, "list_type=0 OR list_type=1", null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    PlaylistRecord r = new PlaylistRecord();
                    r.mPlaylistLocalId = cursor.getInt(0);
                    r.mPlaylistName = cursor.getString(1);
                    r.mPlaylistCloudId = cursor.getString(2);
                    r.mSyncState = cursor.getString(3);
                    result.add(r);
                } finally {
                    cursor.close();
                }
            }
        }
        return result;
    }

    private static List<TrackRecord> queryAllTracksFromLocal(Context context) {
        List<TrackRecord> result = Lists.newArrayList();
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, MiuiAudioPlaylistView.EXTERNAL_URI, new String[]{"online_id", MiuiAudioPlaylistView.Columns.BAIDU_PLAYLIST_CLOUD_ID, MemberColomns.PLAYLIST_ID, "sync_state", "playlist_name", "provider_id"}, String.format("%s=? AND (%s=? OR %s=?)", new Object[]{"provider_id", "list_type", "list_type"}), new String[]{String.valueOf(1), String.valueOf(0), String.valueOf(1)}, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    TrackRecord t = new TrackRecord();
                    t.mTrackOnlineId = cursor.getString(0);
                    t.mPlaylistCloudId = cursor.getString(1);
                    t.mPlaylistLocalId = cursor.getInt(2);
                    t.mSyncState = cursor.getString(3);
                    t.mPlaylistName = cursor.getString(4);
                    t.mProvider = cursor.getString(5);
                    result.add(t);
                } finally {
                    cursor.close();
                }
            }
        }
        return result;
    }

    private static List<PlaylistRecord> uploadPlaylists(Context context, Map<String, PlaylistRecord> cloudPlaylists, List<PlaylistRecord> localPlaylists) {
        Map<String, PlaylistRecord> existCloud = Maps.newHashMap();
        Map<String, PlaylistRecord> nameMap = Maps.newHashMap();
        for (PlaylistRecord pl : cloudPlaylists.values()) {
            nameMap.put(pl.mPlaylistName, pl);
        }
        ContentValues values = new ContentValues();
        for (PlaylistRecord pl2 : localPlaylists) {
            PlaylistRecord cloud = (PlaylistRecord) nameMap.get(pl2.mPlaylistName);
            if (cloud != null) {
                existCloud.put(pl2.mPlaylistCloudId, pl2);
                if (TextUtils.isEmpty(pl2.mPlaylistCloudId)) {
                    pl2.mPlaylistCloudId = cloud.mPlaylistCloudId;
                    values.put(Columns.BAIDU_CLOUD_ID, pl2.mPlaylistCloudId);
                    values.put("sync_state", BaiduSyncState.SYNCED);
                    SqlUtils.update(context, MiuiPlaylists.EXTERNAL_URI, values, "_id=?", new String[]{String.valueOf(pl2.mPlaylistLocalId)});
                }
            }
        }
        List<String> deleteCloudIds = Lists.newArrayList();
        for (String pl3 : cloudPlaylists.keySet()) {
            if (!existCloud.containsKey(pl3)) {
                deleteCloudIds.add(pl3);
            }
        }
        deleteCloudPlaylists(deleteCloudIds);
        List<PlaylistRecord> addCloud = Lists.newArrayList();
        for (PlaylistRecord pl22 : localPlaylists) {
            addCloud.add(pl22);
        }
        List<PlaylistRecord> pl4 = addPlaylistsToCloud(context, addCloud);
        pl4.addAll(existCloud.values());
        return pl4;
    }

    private static List<PlaylistRecord> addPlaylistsToCloud(Context context, List<PlaylistRecord> addCloud) {
        List<PlaylistRecord> added = Lists.newArrayList();
        ContentValues values = new ContentValues();
        String[] args = new String[1];
        for (PlaylistRecord pl : addCloud) {
            PlaylistResult result = BaiduSdkInterface.addPlaylist(pl.mPlaylistName);
            if (result.mResultCode == 50000 && !TextUtils.isEmpty(result.mPlaylistCloudId)) {
                values.clear();
                values.put(Columns.BAIDU_CLOUD_ID, result.mPlaylistCloudId);
                values.put("sync_state", BaiduSyncState.SYNCED);
                args[0] = String.valueOf(pl.mPlaylistLocalId);
                SqlUtils.update(context, MiuiPlaylists.EXTERNAL_URI, values, "_id=?", args);
                pl.mPlaylistCloudId = result.mPlaylistCloudId;
                pl.mSyncState = BaiduSyncState.SYNCED;
                added.add(pl);
            }
        }
        return added;
    }

    private static void deleteCloudPlaylists(List<String> deleteCloudIds) {
        for (String pl : deleteCloudIds) {
            BaiduSdkInterface.delPlaylist(pl);
        }
    }

    private static List<TrackRecord> filterLocalTracks(PlaylistRecord pl, List<TrackRecord> allTracks) {
        List<TrackRecord> result = Lists.newArrayList();
        String playlistCloudId = pl.mPlaylistCloudId;
        for (TrackRecord t : allTracks) {
            if (TextUtils.equals(t.mPlaylistCloudId, playlistCloudId)) {
                result.add(t);
            }
        }
        return result;
    }

    private static void uploadTracks(Context context, PlaylistRecord pl, HashMap<String, TrackRecord> tracks, List<TrackRecord> localTracks) {
        int i;
        Map<String, TrackRecord> existCloud = Maps.newHashMap();
        for (TrackRecord t : localTracks) {
            if (tracks.containsKey(t.mTrackOnlineId)) {
                existCloud.put(t.mTrackOnlineId, t);
            }
        }
        List<String> deleteCloudIds = Lists.newArrayList();
        for (String tid : tracks.keySet()) {
            if (!existCloud.containsKey(tid)) {
                deleteCloudIds.add(tid);
            }
        }
        int delSize = deleteCloudIds.size();
        for (i = 0; i < delSize; i += 100) {
            deleteCloudTracks(pl, deleteCloudIds.subList(i, Math.min(i + 100, delSize)));
        }
        List<String> addCloudIds = Lists.newArrayList();
        for (TrackRecord t2 : localTracks) {
            addCloudIds.add(t2.mTrackOnlineId);
        }
        int addSize = addCloudIds.size();
        for (i = 0; i < addCloudIds.size(); i += 100) {
            addTracksToPlaylist(context, pl, addCloudIds.subList(i, Math.min(i + 100, addSize)));
        }
    }

    private static void addTracksToPlaylist(Context context, PlaylistRecord pl, List<String> addCloudIds) {
        if (BaiduSdkInterface.addTracksToPlaylist(pl.mPlaylistCloudId, SqlUtils.concatAsString(addCloudIds, new SimpleItem())).mResultCode == 50000) {
            Context context2 = context;
            Cursor plCursor = SqlUtils.query(context2, MiuiPlaylists.EXTERNAL_URI, new String[]{"_id"}, "cloud_id=?", new String[]{pl.mPlaylistCloudId}, null, 1);
            if (plCursor != null) {
                long plId = -1;
                try {
                    if (plCursor.moveToFirst()) {
                        plId = plCursor.getLong(0);
                    }
                    plCursor.close();
                    if (plId != -1) {
                        ContentValues values = new ContentValues();
                        values.put("sync_state", BaiduSyncState.SYNCED);
                        SqlUtils.update(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, values, String.format("%s=? AND %s=? AND %s!=? ", new Object[]{MemberColomns.PLAYLIST_ID, "provider_id", "sync_state"}), new String[]{String.valueOf(plId), String.valueOf(1), BaiduSyncState.SYNCED});
                    }
                } catch (Throwable th) {
                    plCursor.close();
                }
            }
        }
    }

    private static void deleteCloudTracks(PlaylistRecord pl, List<String> deleteCloudIds) {
        BaiduSdkInterface.delTracksInPlaylist(pl.mPlaylistCloudId, SqlUtils.concatAsString(deleteCloudIds, new SimpleItem()));
    }

    private static void fillBaiduId(Context context) {
        String where = String.format("%s=? AND (%s='' OR %s is null)", new Object[]{"provider_id", "online_id", "online_id"});
        Cursor cursor = SqlUtils.query(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, new String[]{"mi_online_id"}, where, new String[]{PlayerStore.ID_PROVIDER_BAIDU_STR}, null);
        if (cursor != null) {
            ContentValues values = new ContentValues();
            List<String> onlineIds = Lists.newArrayList();
            while (cursor.moveToNext()) {
                String onlineId = cursor.getString(0);
                if (!IndeterminateIds.isValid(onlineId)) {
                    try {
                        onlineIds.add(onlineId);
                    } finally {
                        cursor.close();
                    }
                } else if (TextUtils.equals(PlayerStore.ID_PROVIDER_BAIDU_STR, IndeterminateIds.getSource(onlineId))) {
                    values.clear();
                    values.put("online_id", IndeterminateIds.getId(onlineId));
                    SqlUtils.update(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, values, "mi_online_id=?", new String[]{onlineId});
                }
            }
            if (!onlineIds.isEmpty()) {
                Result<SongList> r = MusicEngine.get(context).getOnlineEngine().getSongsDetail(context, onlineIds);
                if (r.mErrorCode == 1 && r.mData != null) {
                    for (Song s : ((SongList) r.mData).getContent()) {
                        if (TextUtils.equals(s.mCpId, PlayerStore.ID_PROVIDER_BAIDU_STR)) {
                            values.clear();
                            values.put("online_id", s.mCpSongId);
                            SqlUtils.update(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, values, "mi_online_id=?", new String[]{s.mId});
                        }
                    }
                }
            }
        }
    }

    private static void dumpBaiduData(Context context) {
        MusicLog.m395d(TAG, "Dump start");
        if (NetworkUtil.isActiveNetworkMetered(context)) {
            MusicLog.m395d(TAG, "Network is not connected");
        } else if (BaiduSdkManager.initSdkEnvironment()) {
            Map<String, PlaylistRecord> playlists = BaiduSdkManager.downloadPlaylistListFromServer();
            if (playlists == null) {
                MusicLog.m395d(TAG, "Download cloud playlists failed");
                return;
            }
            int i = 0;
            MusicLog.m395d(TAG, "Cloud playlist count=" + playlists.size());
            for (PlaylistRecord pl : playlists.values()) {
                i++;
                MusicLog.m395d(TAG, i + ": playlist=" + pl);
                HashMap<String, TrackRecord> tracks = BaiduSdkManager.downloadTracksFromServer(pl.mPlaylistCloudId);
                if (tracks != null) {
                    int j = 0;
                    for (TrackRecord t : tracks.values()) {
                        j++;
                        MusicLog.m395d(TAG, "    " + j + String.valueOf(t));
                    }
                }
            }
            MusicLog.m395d(TAG, "Dump end");
        } else {
            MusicLog.m395d(TAG, "SDK is not init");
        }
    }
}
