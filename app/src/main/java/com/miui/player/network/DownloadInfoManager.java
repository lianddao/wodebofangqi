package com.miui.player.network;

import android.app.DownloadManager;
import android.app.MiuiDownloadManager.Query;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.baidu.music.download.db.DBHelper;
import com.google.android.collect.Maps;
import com.google.android.collect.Sets;
import com.miui.player.download.IDownloadInfoManager;
import com.miui.player.download.IDownloader.CandidateInfo;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.meta.MetaManager;
import com.miui.player.provider.PlayerStore.OnlineDownloading;
import com.miui.player.provider.PlayerStore.OnlineDownloading.Columns;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.StorageConfig;
import com.miui.player.util.StorageUtils;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class DownloadInfoManager implements IDownloadInfoManager {
    public static final int STATUS_DOWNLOAD_COMPTELED = 3;
    public static final int STATUS_DOWNLOAD_IN_PROCESS = 2;
    public static final int STATUS_DOWNLOAD_NONE = 0;
    public static final int STATUS_DOWNLOAD_REQUEST = 1;
    static Set<String> sAudioLinkRequest = Sets.newHashSet();
    private static HashMap<String, CandidateInfo> sOnlineIdToCandidateMap;

    private static void initializeFromDB(Context context) {
        if (sOnlineIdToCandidateMap == null) {
            sOnlineIdToCandidateMap = Maps.newHashMap();
            Query query = new Query();
            query.setFilterByNotificationPackage(context.getPackageName());
            query.setFilterByStatus(7);
            Cursor dmCurosr = ((DownloadManager) context.getSystemService(DBHelper.TABLE_DOWNLOAD)).query(query);
            if (dmCurosr != null) {
                try {
                    if (dmCurosr.moveToFirst()) {
                        context.getContentResolver().delete(OnlineDownloading.EXTERNAL_URI, "download_id not in " + SqlUtils.concatIdsAsSet(dmCurosr, dmCurosr.getColumnIndexOrThrow("_id")), null);
                    } else {
                        context.getContentResolver().delete(OnlineDownloading.EXTERNAL_URI, null, null);
                    }
                    dmCurosr.close();
                } catch (Throwable th) {
                    dmCurosr.close();
                }
            }
            Cursor plCursor = SqlUtils.query(context, OnlineDownloading.EXTERNAL_URI, new String[]{"online_id", Columns.DOWNLOAD_ID, Columns.AUDIO_LINK, "bitrate", "description"}, null, null, null);
            if (plCursor != null) {
                try {
                    HashMap<String, CandidateInfo> map = sOnlineIdToCandidateMap;
                    while (plCursor.moveToNext()) {
                        String onlineId = plCursor.getString(0);
                        long downloadId = plCursor.getLong(1);
                        String url = plCursor.getString(2);
                        int bitrate = plCursor.getInt(3);
                        map.put(onlineId, new CandidateInfo(downloadId, url != null ? new AudioLink(url, bitrate) : null, plCursor.getString(4), null));
                    }
                } finally {
                    plCursor.close();
                }
            }
        }
    }

    private static void insert(Context context, String onlineId, long downloadId, AudioLink link, String description) {
        ContentValues cv = new ContentValues();
        cv.put("online_id", onlineId);
        cv.put(Columns.DOWNLOAD_ID, Long.valueOf(downloadId));
        if (link != null) {
            cv.put(Columns.AUDIO_LINK, link.mURL);
            cv.put("bitrate", Integer.valueOf(link.mBitrate));
        }
        cv.put("description", description);
        context.getContentResolver().insert(OnlineDownloading.EXTERNAL_URI, cv);
    }

    private static void delete(Context context, String onlineId) {
        context.getContentResolver().delete(OnlineDownloading.EXTERNAL_URI, "online_id=?", new String[]{onlineId});
    }

    public synchronized void register(Context context, String onlineId, long id, AudioLink link, String descriptin, List<AudioLink> candidates) {
        initializeFromDB(context);
        sOnlineIdToCandidateMap.put(onlineId, new CandidateInfo(id, link, descriptin, candidates));
        insert(context, onlineId, id, link, descriptin);
    }

    public synchronized void unregister(Context context, String onlineId) {
        initializeFromDB(context);
        sOnlineIdToCandidateMap.remove(onlineId);
        delete(context, onlineId);
    }

    public synchronized List<AudioLink> getCandidates(Context context, String onlineId) {
        CandidateInfo info;
        initializeFromDB(context);
        info = (CandidateInfo) sOnlineIdToCandidateMap.get(onlineId);
        return info != null ? info.mCandidates : null;
    }

    public synchronized AudioLink getAudioLink(Context context, String onlineId) {
        CandidateInfo info;
        initializeFromDB(context);
        info = (CandidateInfo) sOnlineIdToCandidateMap.get(onlineId);
        return info != null ? info.mAudioLink : null;
    }

    public synchronized long getDownloadId(Context context, String onlineId) {
        CandidateInfo info;
        initializeFromDB(context);
        info = (CandidateInfo) sOnlineIdToCandidateMap.get(onlineId);
        return info != null ? info.mDownloadId : -1;
    }

    public static synchronized boolean isDownloading(Context context, String onlineId) {
        boolean z;
        synchronized (DownloadInfoManager.class) {
            initializeFromDB(context);
            z = onlineId != null && sOnlineIdToCandidateMap.containsKey(onlineId);
        }
        return z;
    }

    public synchronized Entry<String, CandidateInfo> getDownloadInfoByDownloadId(Context context, long downloadId) {
        Entry<String, CandidateInfo> entry;
        initializeFromDB(context);
        for (Entry<String, CandidateInfo> entry2 : sOnlineIdToCandidateMap.entrySet()) {
            CandidateInfo info = (CandidateInfo) entry2.getValue();
            if (info != null && info.mDownloadId == downloadId) {
                break;
            }
        }
        entry2 = null;
        return entry2;
    }

    static boolean startRequestAudioLink(String onlineId) {
        if (onlineId == null) {
            return false;
        }
        return sAudioLinkRequest.add(onlineId);
    }

    static boolean finishRequestAudioLink(String onlineId) {
        if (onlineId == null) {
            return false;
        }
        return sAudioLinkRequest.remove(onlineId);
    }

    public static boolean isAudioLinkRequested(String onlineId) {
        return sAudioLinkRequest.contains(onlineId);
    }

    public static int getDownloadStatus(Context context, String onlineId, String tr, String ar, String[] sortedDownloadNames) {
        if (isDownloading(context, onlineId)) {
            return 2;
        }
        if (sAudioLinkRequest.contains(onlineId)) {
            return 1;
        }
        String appointName = MetaManager.getMetaFileName(tr, ar, StorageConfig.META_TYPE_MP3);
        if (appointName == null || sortedDownloadNames == null) {
            return 0;
        }
        for (File file : StorageConfig.getAllMp3Dir(false)) {
            if (Arrays.binarySearch(sortedDownloadNames, file.getAbsolutePath() + "/" + appointName) < 0) {
                return 0;
            }
        }
        return 3;
    }

    public static int getDownloadStatus(Context context, String onlineId, String tr, String ar, int quality, String[] sortedDownloadNames) {
        if (isDownloading(context, onlineId)) {
            return 2;
        }
        if (sAudioLinkRequest.contains(onlineId)) {
            return 1;
        }
        String appointName = MetaManager.getMetaFileName(tr, ar, StorageConfig.META_TYPE_MP3);
        File dir = StorageConfig.getMp3Dir(StorageConfig.getMusicType(StorageConfig.getMusicBitRate(quality)), false);
        if (appointName == null || sortedDownloadNames == null) {
            return 0;
        }
        Iterator i$ = StorageUtils.getAllSdcardFilePath(StorageUtils.getLeafPath(new File(dir, appointName).getAbsolutePath())).iterator();
        while (i$.hasNext()) {
            if (Arrays.binarySearch(sortedDownloadNames, (String) i$.next()) >= 0) {
                return 3;
            }
        }
        return 0;
    }
}
