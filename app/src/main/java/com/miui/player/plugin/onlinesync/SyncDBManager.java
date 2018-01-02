package com.miui.player.plugin.onlinesync;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.miui.player.plugin.onlinesync.SyncObject.PlaylistRecord;
import com.miui.player.plugin.onlinesync.SyncObject.TrackRecord;
import com.miui.player.provider.PlayerStore.BaiduSyncState;
import com.miui.player.provider.PlayerStore.MemberColomns;
import com.miui.player.provider.PlayerStore.MiuiAudioPlaylistView;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Columns;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.SqlUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SyncDBManager {
    private static final int APPLY_BATCH_NUM_LIMIT = 100;
    private static final boolean DEBUG = true;
    private static final String TAG = "SyncDBManager";

    public static ArrayList<PlaylistRecord> getPlaylistRecordList() {
        Context context = MusicApplication.getApplication();
        Uri uri = MiuiPlaylists.EXTERNAL_URI;
        String[] projection = new String[]{"sync_state", "_id", "name", Columns.BAIDU_CLOUD_ID};
        String[] args = new String[]{BaiduSyncState.SYNCED};
        ArrayList<PlaylistRecord> playlistList = new ArrayList();
        Cursor cursor = SqlUtils.query(context, uri, projection, "sync_state != ? AND list_type != -2 AND list_type != -3", args, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    PlaylistRecord record = new PlaylistRecord();
                    record.mSyncState = cursor.getString(0);
                    record.mPlaylistLocalId = cursor.getInt(1);
                    record.mPlaylistName = cursor.getString(2);
                    record.mPlaylistCloudId = cursor.getString(3);
                    playlistList.add(record);
                } finally {
                    cursor.close();
                }
            }
        }
        return playlistList;
    }

    public static ArrayList<TrackRecord> getTrackRecordList() {
        Cursor cursor = SqlUtils.query(MusicApplication.getApplication(), MiuiAudioPlaylistView.EXTERNAL_URI, new String[]{"sync_state", "online_id", MemberColomns.PLAYLIST_ID, MiuiAudioPlaylistView.Columns.BAIDU_PLAYLIST_CLOUD_ID, "playlist_name"}, "sync_state != ? AND online_id is not null AND online_id !='' AND playlist_cloud_id is not null", new String[]{BaiduSyncState.SYNCED}, "playlist_cloud_id ASC, sync_state DESC");
        ArrayList<TrackRecord> trackRecordList = new ArrayList();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    TrackRecord record = new TrackRecord();
                    record.mSyncState = cursor.getString(0);
                    record.mTrackOnlineId = cursor.getString(1);
                    record.mPlaylistLocalId = cursor.getInt(2);
                    record.mPlaylistCloudId = cursor.getString(3);
                    record.mPlaylistName = cursor.getString(4);
                    trackRecordList.add(record);
                } finally {
                    cursor.close();
                }
            }
        }
        return trackRecordList;
    }

    public static void updatePlaylists(PlaylistRecord record) {
        if (record == null || !record.canUpdate()) {
            Log.e(TAG, "update playlist: record is null or not valid.");
            return;
        }
        Context context = MusicApplication.getApplication();
        Uri uri = MiuiPlaylists.EXTERNAL_URI;
        String where = "_id = " + record.mPlaylistLocalId;
        String[] args;
        ContentValues values;
        String renameWhere;
        if (BaiduSyncState.INSERT.equals(record.mSyncState)) {
            String syncWhere = where + " AND " + "sync_state" + " =? AND " + "name" + " =?";
            args = new String[]{BaiduSyncState.INSERT, record.mPlaylistName};
            values = new ContentValues();
            values.put(Columns.BAIDU_CLOUD_ID, record.mPlaylistCloudId);
            values.put("sync_state", BaiduSyncState.SYNCED);
            if (SqlUtils.update(context, uri, values, syncWhere, args) > 0) {
                Log.d(TAG, "update playlist: insert --> synced");
                return;
            }
            renameWhere = where + " AND " + "sync_state" + " =? AND " + "name" + " !=?";
            args = new String[]{BaiduSyncState.INSERT, record.mPlaylistName};
            values = new ContentValues();
            values.put(Columns.BAIDU_CLOUD_ID, record.mPlaylistCloudId);
            values.put("sync_state", BaiduSyncState.RENAME);
            if (SqlUtils.update(context, uri, values, renameWhere, args) > 0) {
                Log.d(TAG, "update playlist: insert ---> rename");
                return;
            }
            String deleteWhere = where + " AND " + "sync_state" + " =?";
            args = new String[]{BaiduSyncState.DELETE};
            values = new ContentValues();
            values.put(Columns.BAIDU_CLOUD_ID, record.mPlaylistCloudId);
            if (SqlUtils.update(context, uri, values, deleteWhere, args) > 0) {
                Log.d(TAG, "update playlist: insert ---> delete");
            }
        } else if (BaiduSyncState.DELETE.equals(record.mSyncState)) {
            if (SqlUtils.delete(context, uri, where + " AND " + "sync_state" + " =?", new String[]{BaiduSyncState.DELETE}) > 0) {
                Log.d(TAG, "delete playlist: delete ---> remove");
            }
        } else if (BaiduSyncState.RENAME.equals(record.mSyncState)) {
            renameWhere = where + " AND " + "sync_state" + " =? AND " + "name" + " =?";
            args = new String[]{BaiduSyncState.RENAME, record.mPlaylistName};
            values = new ContentValues(1);
            values.put("sync_state", BaiduSyncState.SYNCED);
            if (SqlUtils.update(context, uri, values, renameWhere, args) > 0) {
                Log.d(TAG, "rename playlist: rename ---> synced");
            }
        }
    }

    public static HashMap<String, PlaylistRecord> getInsertedPlaylistListFromDB() {
        Uri url = MiuiPlaylists.EXTERNAL_URI;
        Cursor cursor = SqlUtils.query(MusicApplication.getApplication(), url, new String[]{"sync_state", "_id", "name"}, "sync_state = ? AND (cloud_id is null OR cloud_id = '')", new String[]{BaiduSyncState.INSERT}, null);
        HashMap<String, PlaylistRecord> playlistMap = new HashMap();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    PlaylistRecord record = new PlaylistRecord();
                    record.mSyncState = cursor.getString(0);
                    record.mPlaylistLocalId = cursor.getInt(1);
                    record.mPlaylistName = cursor.getString(2);
                    playlistMap.put(record.mPlaylistName, record);
                } finally {
                    cursor.close();
                }
            }
        }
        return playlistMap;
    }

    public static HashMap<String, PlaylistRecord> getPlaylistListFromDB() {
        Uri url = MiuiPlaylists.EXTERNAL_URI;
        Cursor cursor = SqlUtils.query(MusicApplication.getApplication(), url, new String[]{"sync_state", "_id", Columns.BAIDU_CLOUD_ID, "name"}, "cloud_id is not null AND cloud_id != ''", null, null);
        HashMap<String, PlaylistRecord> playlistMap = new HashMap();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    PlaylistRecord record = new PlaylistRecord();
                    record.mSyncState = cursor.getString(0);
                    record.mPlaylistLocalId = cursor.getInt(1);
                    record.mPlaylistCloudId = cursor.getString(2);
                    record.mPlaylistName = cursor.getString(3);
                    playlistMap.put(record.mPlaylistCloudId, record);
                } finally {
                    cursor.close();
                }
            }
        }
        return playlistMap;
    }

    public static HashMap<String, TrackRecord> getOnlineTracksFromDB(String playlistCloudId) {
        if (playlistCloudId == null || Integer.valueOf(playlistCloudId).intValue() < 0) {
            Log.e(TAG, "getOnlineTracksFromDB(...): playlistCloudId is not valid.");
            return null;
        }
        HashMap<String, TrackRecord> trackMap = new HashMap();
        Cursor cursor = SqlUtils.query(MusicApplication.getApplication(), MiuiAudioPlaylistView.EXTERNAL_URI, new String[]{"sync_state", "online_id", MemberColomns.PLAYLIST_ID, MiuiAudioPlaylistView.Columns.BAIDU_PLAYLIST_CLOUD_ID, "playlist_name"}, "playlist_cloud_id = " + playlistCloudId + " AND " + "online_id" + " is not null" + " AND " + "online_id" + " !=''", null, null);
        if (cursor == null) {
            return trackMap;
        }
        while (cursor.moveToNext()) {
            try {
                TrackRecord record = new TrackRecord();
                record.mSyncState = cursor.getString(0);
                record.mTrackOnlineId = cursor.getString(1);
                record.mPlaylistLocalId = cursor.getInt(2);
                record.mPlaylistCloudId = cursor.getString(3);
                record.mPlaylistName = cursor.getString(4);
                trackMap.put(record.mTrackOnlineId, record);
            } finally {
                cursor.close();
            }
        }
        return trackMap;
    }

    public static void deletePlaylistsInDB(List<String> deletePlaylistList) {
        if (deletePlaylistList == null || deletePlaylistList.isEmpty()) {
            Log.e(TAG, "deletePlaylistsInDB(...): delete 0:0 playlist(s).");
            return;
        }
        Log.d(TAG, "merge playlists: delete " + deletePlaylistList.size() + ":" + SqlUtils.delete(MusicApplication.getApplication(), MiuiPlaylists.EXTERNAL_URI, "cloud_id IN " + SqlUtils.concatStringAsSet(deletePlaylistList), null) + " playlist(s)");
    }

    public static void updatePlaylistsInDB(List<String> updatePlaylistList, Map<String, PlaylistRecord> cloudPlaylistMap) {
        if (updatePlaylistList == null || updatePlaylistList.isEmpty() || cloudPlaylistMap == null) {
            Log.e(TAG, "updatePlaylistsInDB(...): update 0:0 playlist(s).");
            return;
        }
        ArrayList<ContentProviderOperation> ops = new ArrayList();
        Context context = MusicApplication.getApplication();
        Uri url = MiuiPlaylists.EXTERNAL_URI;
        for (String playlistCloudId : updatePlaylistList) {
            PlaylistRecord record = (PlaylistRecord) cloudPlaylistMap.get(playlistCloudId);
            ContentValues values = new ContentValues(3);
            values.put("name", record.mPlaylistName);
            values.put(Columns.BAIDU_CLOUD_ID, record.mPlaylistCloudId);
            values.put("sync_state", BaiduSyncState.SYNCED);
            String[] args = new String[]{record.mPlaylistName, record.mPlaylistCloudId};
            ops.add(ContentProviderOperation.newUpdate(url).withValues(values).withSelection("name =?  OR cloud_id =? ", args).build());
        }
        int start = 0;
        try {
            int end = Math.min(100, ops.size());
            while (start < ops.size()) {
                int i;
                ContentProviderResult[] results = context.getContentResolver().applyBatch("com.miui.player", new ArrayList(ops.subList(start, end)));
                String str = TAG;
                StringBuilder append = new StringBuilder().append("merge playlists: update ").append(end - start).append(":");
                if (results == null) {
                    i = 0;
                } else {
                    i = results.length;
                }
                Log.d(str, append.append(i).append(" playlist(s)").toString());
                start += end;
                end = Math.min(end + 100, ops.size());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (OperationApplicationException e2) {
            e2.printStackTrace();
        }
    }

    public static void insertPlaylistsInDB(List<String> insertPlaylistList, Map<String, PlaylistRecord> cloudPlaylistMap) {
        if (insertPlaylistList == null || insertPlaylistList.isEmpty() || cloudPlaylistMap == null) {
            Log.e(TAG, "insertPlaylistsInDB(...): insert 0:0 playlist(s).");
            return;
        }
        Context context = MusicApplication.getApplication();
        Uri url = MiuiPlaylists.EXTERNAL_URI;
        int size = insertPlaylistList.size();
        ContentValues[] values = new ContentValues[size];
        for (int i = 0; i < size; i++) {
            PlaylistRecord record = (PlaylistRecord) cloudPlaylistMap.get((String) insertPlaylistList.get(i));
            values[i] = new ContentValues(4);
            values[i].put(Columns.BAIDU_CLOUD_ID, record.mPlaylistCloudId);
            values[i].put("name", record.mPlaylistName);
            if (TextUtils.equals("$miui$", record.mPlaylistName) || TextUtils.equals("$my_ktv$", record.mPlaylistName)) {
                values[i].put("list_type", Integer.valueOf(1));
            } else {
                values[i].put("list_type", Integer.valueOf(0));
            }
            values[i].put("sync_state", BaiduSyncState.SYNCED);
        }
        Log.d(TAG, "merge playlists: insert " + size + ":" + SqlUtils.bulkInsert(context, url, values) + " playlist(s)");
    }

    public static void deleteOnlineTracksInDB(int playlistLocalId, List<String> deleteTrackList) {
        if (playlistLocalId < 0 || deleteTrackList == null || deleteTrackList.isEmpty()) {
            Log.e(TAG, "deleteOnlineTracksInDB(...): delete 0:0 track(s).");
            return;
        }
        Log.d(TAG, "merge tracks: delete " + deleteTrackList.size() + ":" + SqlUtils.delete(MusicApplication.getApplication(), MiuiPlaylistsAudioMap.EXTERNAL_URI, "playlist_id = " + playlistLocalId + " AND " + "online_id" + " IN " + SqlUtils.concatStringAsSet(deleteTrackList), null) + " track(s)");
    }

    public static void updateOnlineTracksInDB(int playlistLocalId, List<String> updateTrackList) {
        if (playlistLocalId < 0 || updateTrackList == null || updateTrackList.isEmpty()) {
            Log.e(TAG, "updateOnlineTracksInDB(...): update 0:0 track(s).");
            return;
        }
        Context context = MusicApplication.getApplication();
        Uri url = MiuiPlaylistsAudioMap.EXTERNAL_URI;
        ContentValues values = new ContentValues(1);
        values.put("sync_state", BaiduSyncState.SYNCED);
        Log.d(TAG, "merge tracks: update " + updateTrackList.size() + ":" + SqlUtils.update(context, url, values, "playlist_id = " + playlistLocalId + " AND " + "online_id" + " IN " + SqlUtils.concatStringAsSet(updateTrackList) + " AND (" + "sync_state" + " =?)", new String[]{BaiduSyncState.INSERT}) + " track(s)");
    }

    public static PlaylistRecord getPlaylistRecord(String playlistCloudId) {
        Throwable th;
        if (playlistCloudId == null || Integer.valueOf(playlistCloudId).intValue() < 0) {
            Log.e(TAG, "getPlaylistRecord(...): playlistCloudId is not valid.");
            return null;
        }
        Cursor cursor = SqlUtils.query(MusicApplication.getApplication(), MiuiPlaylists.EXTERNAL_URI, new String[]{"sync_state", "_id", "name", Columns.BAIDU_CLOUD_ID}, "cloud_id =?", new String[]{playlistCloudId}, null);
        if (cursor == null) {
            return null;
        }
        try {
            if (cursor.moveToNext()) {
                PlaylistRecord record = new PlaylistRecord();
                try {
                    record.mSyncState = cursor.getString(0);
                    record.mPlaylistLocalId = cursor.getInt(1);
                    record.mPlaylistName = cursor.getString(2);
                    record.mPlaylistCloudId = cursor.getString(3);
                    cursor.close();
                    return record;
                } catch (Throwable th2) {
                    th = th2;
                    PlaylistRecord playlistRecord = record;
                    cursor.close();
                    throw th;
                }
            }
            cursor.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor.close();
            throw th;
        }
    }
}
