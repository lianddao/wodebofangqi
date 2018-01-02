package com.miui.player.cloud;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import com.google.android.collect.Maps;
import com.miui.player.util.SqlUtils;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.Result;
import com.xiaomi.music.cloud.CloudEngine;
import com.xiaomi.music.cloud.CloudErrorCode;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.MusicCloudServerException;
import com.xiaomi.music.cloud.model.CloudObject;
import com.xiaomi.music.cloud.model.OperationList;
import com.xiaomi.music.cloud.model.Playlist;
import com.xiaomi.music.cloud.model.Track;
import com.xiaomi.music.cloud.model.TrackInfo;
import com.xiaomi.music.online.model.Song;
import com.xiaomi.music.util.MusicLog;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.json.JSONException;

public class MusicSyncHelper {
    private static final String PREF_LAST_SYNC_TAG = "MusicSyncHelperlast_sync_tag";
    private static final String PREF_LAST_SYNC_TAG_EXTRA = "MusicSyncHelperlast_sync_tag_extra";
    static final String TAG = "MusicSyncHelper";
    private static final int TIME_OUT_ERROR_LIMIT = 10;
    private static int sTimeOutErrorCount = 0;

    public static class SyncInfo {
        public final String mSyncExtraInfo;
        public final long mSyncTag;

        public SyncInfo(long syncTag, String syncExtraInfo) {
            if (syncTag > 0 && syncExtraInfo == null) {
                syncTag = 0;
            }
            this.mSyncTag = syncTag;
            this.mSyncExtraInfo = syncExtraInfo;
        }

        public String toString() {
            return String.format("<%d, %s>", new Object[]{Long.valueOf(this.mSyncTag), this.mSyncExtraInfo});
        }
    }

    static long getCurrentVersion(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(PREF_LAST_SYNC_TAG, 0);
    }

    static void clearSyncInfo(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove(PREF_LAST_SYNC_TAG).remove(PREF_LAST_SYNC_TAG_EXTRA).apply();
    }

    static SyncInfo readSyncInfo(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return new SyncInfo(sp.getLong(PREF_LAST_SYNC_TAG, 0), sp.getString(PREF_LAST_SYNC_TAG_EXTRA, null));
    }

    static void saveSyncInfo(Context context, SyncInfo info) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(PREF_LAST_SYNC_TAG, info.mSyncTag).putString(PREF_LAST_SYNC_TAG_EXTRA, info.mSyncExtraInfo).apply();
    }

    public static SyncInfo download(Context context, Account account, MusicAuthToken token, SyncInfo syncInfo) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException {
        CloudEngine engine = MusicEngine.get(context).getCloudEngine();
        Map<String, Song> songs = Maps.newHashMap();
        long syncTag = syncInfo.mSyncTag;
        String syncExtraInfo = syncInfo.mSyncExtraInfo;
        int i = 0;
        while (i < 1000) {
            MusicLog.m395d(TAG, "Loop to download, i=" + i);
            Result<OperationList> result = engine.apply(engine.getOperationListByTag(account, token, syncTag, syncExtraInfo, MusicSyncDBHelper.getFilterTags(context, syncTag)));
            if (result.mErrorCode == CloudErrorCode.ERROR_SYNC_TAG_TIMEOUT) {
                MusicLog.m395d(TAG, "Clean synced record when error=" + result.mErrorCode);
                MusicSyncDBHelper.cleanTimeOutTag(context);
                syncTag = 0;
                syncExtraInfo = null;
                if (sTimeOutErrorCount < 10) {
                    sTimeOutErrorCount++;
                    MusicSyncAdapter.requestSync(context);
                }
            } else {
                sTimeOutErrorCount = 0;
                if (result.mErrorCode != 0) {
                    MusicLog.m397e(TAG, "Bad result=" + result);
                    break;
                }
                OperationList list = result.mData;
                if (list == null) {
                    MusicLog.m397e(TAG, "error code is ok, but data is null");
                    break;
                }
                MusicLog.m395d(TAG, "Download list size=" + list.getItems().size());
                try {
                    fillExtraSongs(context, list, songs);
                    handleOnceDownload(context, list, songs);
                    syncTag = Long.valueOf(list.getSyncTag()).longValue();
                    syncExtraInfo = list.getSyncExtraInfo();
                    MusicLog.m395d(TAG, "Current tag=" + syncTag);
                    if (list.isLastPage()) {
                        break;
                    }
                    i++;
                } catch (MusicSyncException e) {
                    MusicLog.m398e(TAG, "fillExtraSongs or handleOnceDownload failed!", e);
                }
            }
        }
        return new SyncInfo(syncTag, syncExtraInfo);
    }

    private static void fillExtraSongs(Context context, OperationList list, Map<String, Song> songs) throws MusicSyncException {
        Set<String> unknownIds = new HashSet();
        for (CloudObject<?> obj : list.getItems()) {
            Track track = obj.asTrack();
            if (track != null) {
                String onlineId = ((TrackInfo) track.mInfo).getOnlineId();
                if (!songs.containsKey(onlineId) && track.mStatus == 0) {
                    unknownIds.add(onlineId);
                }
            }
        }
        if (!unknownIds.isEmpty()) {
            Map<String, Song> unknownSongs = MusicSyncDBHelper.getAllOnlineSongs(context, unknownIds);
            if (unknownSongs.size() < unknownIds.size()) {
                Set<String> notFoundSet = new HashSet();
                notFoundSet.addAll(unknownIds);
                notFoundSet.removeAll(unknownSongs.keySet());
                MusicLog.m397e(TAG, "*** Online song not found, id set=" + SqlUtils.concatStringAsSet(notFoundSet));
            }
            songs.putAll(unknownSongs);
        }
    }

    private static void handleOnceDownload(Context context, OperationList list, Map<String, Song> songs) throws MusicSyncException {
        long c = SystemClock.uptimeMillis();
        for (CloudObject<?> obj : list.getItems()) {
            Track track = obj.asTrack();
            if (track != null) {
                MusicSyncDBHelper.mergeTrack(context, track, Collections.unmodifiableMap(songs));
            } else {
                Playlist playlist = obj.asPlaylist();
                if (playlist != null) {
                    MusicSyncDBHelper.mergePlaylist(context, playlist);
                } else {
                    MusicLog.m397e(TAG, "Bad CloudObject, obj=" + obj);
                }
            }
        }
        MusicLog.m401p(TAG, "Download spend time=" + (SystemClock.uptimeMillis() - c) + ", operation count=" + list.getItems());
    }

    public static void upload(Context context, Account account, MusicAuthToken token) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException {
        MusicSyncDBHelper.uploadPlaylist(context, account, token);
        MusicSyncDBHelper.uploadTrack(context, account, token);
    }

    public static void handleAccountChange(Context context, Intent intent) {
        boolean wipe;
        int i = 0;
        String action = intent.getAction();
        Account account = (Account) intent.getParcelableExtra("extra_account");
        Bundle extra = intent.getBundleExtra("extra_bundle");
        if (extra != null) {
            wipe = extra.getBoolean("extra_wipe_data", true);
        } else {
            wipe = true;
        }
        int type = intent.getIntExtra("extra_update_type", -1);
        String str = TAG;
        String str2 = "Handle account changed, action=%s, account=%s, wipe=%d, type=%d";
        Object[] objArr = new Object[4];
        objArr[0] = action;
        objArr[1] = account;
        if (wipe) {
            i = 1;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(type);
        MusicLog.m395d(str, String.format(str2, objArr));
        if (type == 2) {
            MusicSyncAdapter.requestSync(context);
        } else if (type == 1) {
            if (wipe) {
                MusicSyncDBHelper.wipePlaylists(context);
            } else {
                MusicSyncDBHelper.clearSyncState(context);
            }
            clearSyncInfo(context);
            MusicLog.m397e(TAG, "Remove account, wipe=" + wipe);
        } else {
            MusicLog.m397e(TAG, "Bad upload type, type=" + type);
        }
    }
}
