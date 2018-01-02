package com.miui.player.network;

import android.app.DownloadManager;
import android.app.MiuiDownloadManager.Request;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.music.download.db.DBHelper;
import com.miui.player.download.IDownloader;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.LyricDownloader.LyricAsyncSaveCallback;
import com.miui.player.provider.OnlineAudioDetailHelper;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.StorageConfig;
import com.xiaomi.music.util.SecurityGruadian;
import java.io.File;
import java.util.List;

public class DownloadProvider implements IDownloader {
    public static final Uri DOWNLOAD_URI = Uri.parse("content://downloads/my_downloads");

    public int updateDB(Context context, String onlineId, AudioDetail detail) {
        return OnlineAudioDetailHelper.updateDB(context, onlineId, detail);
    }

    public void correctId3(Context context, String appointName, String details, boolean forceScan) {
        MP3Downloader.correctId3(context, appointName, details, true);
    }

    public void downloadImageAsync(Context context, String onlineId, ImageSearchInfo info) {
        ImageDownloader.downloadAsync(context, info, onlineId, null);
    }

    public void downloadLyricAsync(Context context, String onlineId, LyricSearchInfo searchInfo) {
        LyricDownloader.downloadAsync(context, onlineId, searchInfo, new LyricAsyncSaveCallback(context, searchInfo.mTrack, searchInfo.mArtist));
    }

    public long[] queryByAppointName(Context context, String appointName) {
        long[] jArr = null;
        if (appointName != null) {
            Cursor cursor = SecurityGruadian.queryDownloadByAppointName(context, appointName);
            if (cursor != null) {
                try {
                    jArr = SqlUtils.getIdsForCursor(cursor, 0);
                } finally {
                    cursor.close();
                }
            }
        }
        return jArr;
    }

    public Uri start(Context context, AudioLink link, String onlineId, String details, String appointName, String subDirectory, List<AudioLink> candidates, boolean visible, long timeOut) {
        String url = null;
        if (link != null) {
            url = link.mURL;
        }
        if (url == null) {
            ApplicationHelper.instance().getDeviceCompat().trackDownloadEvent(context, null, onlineId, null, 0, false, "ERROR:URL_IS_NULL");
            return null;
        }
        Request request = new Request(Uri.parse(url));
        request.setMimeType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(url)));
        if (visible) {
            MetaManager.makeDirIfNotExists(context, StorageConfig.getMusicType(link.mBitrate));
            request.setDestinationUri(Uri.fromFile(new File(subDirectory, appointName)));
            request.setNotificationVisibility(1);
            request.setShowRunningNotification(true);
            request.allowScanningByMediaScanner();
        } else {
            request.setAppointName(appointName);
            request.setNotificationVisibility(2);
            request.setShowRunningNotification(false);
        }
        request.setVisibleInDownloadsUi(visible);
        request.setTitle(appointName);
        request.setUserAgent("Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.3 (KHTML, like Gecko) Chrome/6.0.464.0 Safari/534.3");
        try {
            long id = ((DownloadManager) context.getSystemService(DBHelper.TABLE_DOWNLOAD)).enqueue(request);
            ApplicationHelper.instance().getDownloadInfoManager().register(context, onlineId, id, link, details, candidates);
            if (!TextUtils.isEmpty(details)) {
                StatHelper.uploadDownloadTrack(details);
            }
            if (id >= 0) {
                return ContentUris.withAppendedId(DOWNLOAD_URI, id);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public int markRowDeleted(Context context, long... ids) {
        return ((DownloadManager) context.getSystemService(DBHelper.TABLE_DOWNLOAD)).markRowDeleted(ids);
    }
}
