package com.miui.player.receiver;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.baidu.music.download.db.DBHelper;
import com.miui.player.download.DownloadProviderProxy;
import com.miui.player.download.IDownloadInfoManager;
import com.miui.player.download.IDownloader;
import com.miui.player.download.IDownloader.CandidateInfo;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.meta.MetaManager;
import com.miui.player.reporter.OnlineMusicReporter;
import com.miui.player.reporter.OnlinePlayStatus;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.util.Actions;
import com.miui.player.util.StorageConfig;
import com.miui.player.util.StorageUtils;
import com.xiaomi.music.util.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenDownloadReceiver extends BroadcastReceiver {
    static final String ACTION_DOWNLOAD_DELETED = "android.intent.action.DOWNLOAD_DELETED";
    static final String INTENT_EXTRA_APPLICATION_PACKAGENAME = "intent_extra_application_packagename";

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        DownloadManager manager = (DownloadManager) context.getSystemService(DBHelper.TABLE_DOWNLOAD);
        Query query = new Query();
        long id = intent.getLongExtra("extra_download_id", -1);
        if (id == -1) {
            openDownloadList(context);
            return;
        }
        query.setFilterById(new long[]{id});
        Cursor c = manager.query(query);
        if (c != null) {
            try {
                handleDownloadNotification(context, action, id, c);
            } catch (Throwable th) {
                if (c != null) {
                    c.close();
                }
            }
        } else {
            openDownloadList(context);
        }
        if (c != null) {
            c.close();
        }
    }

    private static void openDownloadList(Context context) {
        try {
            Intent pageView = new Intent("android.intent.action.VIEW_DOWNLOADS");
            pageView.putExtra(INTENT_EXTRA_APPLICATION_PACKAGENAME, context.getPackageName());
            pageView.setFlags(268435456);
            context.startActivity(pageView);
        } catch (Exception e) {
            Log.e("OpenDowdloadReceiver", MetaManager.UNKNOWN_STRING, e);
        }
    }

    private static void postDownloadStatus(Context context, boolean success, String onlineId, CandidateInfo info) {
        if (onlineId != null && info != null && info.mAudioLink != null) {
            OnlinePlayStatus report = new OnlinePlayStatus(onlineId, success ? 1002 : 1001);
            AudioLink link = info.mAudioLink;
            report.mBitrate = link.mBitrate;
            report.mURL = link.mURL;
            OnlineMusicReporter.postOnlinePlayStatus(context, report);
        }
    }

    private static boolean needReport(String path) {
        return path != null && path.startsWith(ApplicationHelper.instance().getDeviceCompat().getMIUIExternalStorageDirectory().getAbsolutePath());
    }

    private static void handleDownloadNotification(Context context, String action, long id, Cursor c) {
        IDownloader downloader = ApplicationHelper.instance().getDownloader();
        IDownloadInfoManager manager = ApplicationHelper.instance().getDownloadInfoManager();
        if ("android.intent.action.DOWNLOAD_COMPLETE".equals(action) || ACTION_DOWNLOAD_DELETED.equals(action)) {
            File file;
            String details = null;
            String onlineId = null;
            CandidateInfo info = null;
            Entry<String, CandidateInfo> entry = manager.getDownloadInfoByDownloadId(context, id);
            if (!(entry == null || entry.getValue() == null)) {
                onlineId = (String) entry.getKey();
                info = (CandidateInfo) entry.getValue();
                details = info.mDescription;
            }
            boolean retry = false;
            ArrayList<File> trackFiles = null;
            if (details != null) {
                try {
                    JSONObject jSONObject = new JSONObject(details);
                    String album = jSONObject.getString("album");
                    String artist = jSONObject.getString("artist");
                    String track = jSONObject.getString("track");
                    String appointName = StorageConfig.getMp3FileName(track, artist);
                    trackFiles = StorageUtils.getAllSdcardFile(appointName);
                    if (c.moveToFirst()) {
                        int status = c.getInt(c.getColumnIndex("status"));
                        String path = c.getString(c.getColumnIndex("local_filename"));
                        String rawOnlineId = DownloadProviderProxy.unwrapPlayingTag(onlineId);
                        if (DownloadProviderProxy.isStatusSuccess(status)) {
                            AudioLink audioLink = manager.getAudioLink(context, onlineId);
                            if (audioLink != null) {
                                ApplicationHelper.instance().getDeviceCompat().trackDownloadEvent(context, null, rawOnlineId, audioLink.mURL, audioLink.mBitrate, true, null);
                            }
                            if (needReport(path)) {
                                postDownloadStatus(context, true, rawOnlineId, info);
                                downloader.correctId3(context, appointName, details, true);
                                if (!NetworkUtil.isActiveNetworkMetered(context)) {
                                    Context ctx = context.getApplicationContext();
                                    ImageSearchInfo imageSearchInfo = new ImageSearchInfo(album, artist);
                                    file = StorageUtils.findExistFile(new File(StorageConfig.getAlbumDir(true), StorageConfig.getAlbumFileName(album, artist)));
                                    if (file == null || !file.exists()) {
                                        downloader.downloadImageAsync(ctx, rawOnlineId, imageSearchInfo);
                                    }
                                    imageSearchInfo = new ImageSearchInfo(artist);
                                    file = StorageUtils.findExistFile(new File(StorageConfig.getAvatarDir(true), StorageConfig.getAvatarFileName(artist)));
                                    if (file == null || !file.exists()) {
                                        downloader.downloadImageAsync(ctx, null, imageSearchInfo);
                                    }
                                    file = StorageUtils.findExistFile(new File(StorageConfig.getLyricDir(true), StorageConfig.getLyricFileName(track, artist)));
                                    if (file == null || !file.exists()) {
                                        downloader.downloadLyricAsync(ctx, rawOnlineId, new LyricSearchInfo(track, artist, album, path));
                                    }
                                }
                            }
                        } else {
                            ApplicationHelper.instance().getDeviceCompat().trackDownloadEvent(context, null, rawOnlineId, null, 0, false, "ERROR:" + DownloadProviderProxy.getDownloadErrorMessage(status));
                            if (needReport(path)) {
                                postDownloadStatus(context, false, rawOnlineId, info);
                            }
                            List<AudioLink> candidates = manager.getCandidates(context, onlineId);
                            File dir = StorageConfig.getMp3Dir(true);
                            if (candidates != null && dir != null) {
                                while (!candidates.isEmpty()) {
                                    if (DownloadProviderProxy.start(context, (AudioLink) candidates.get(0), onlineId, details, appointName, dir.getAbsolutePath(), candidates.subList(1, candidates.size())) != null) {
                                        retry = true;
                                        break;
                                    }
                                    candidates.remove(0);
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                }
            }
            if (!retry) {
                context.sendBroadcast(new Intent(Actions.ACTION_ONLINE_DOWNLOAD_COMPLETE));
                manager.unregister(context, onlineId);
                if (ACTION_DOWNLOAD_DELETED.equals(action) && trackFiles != null) {
                    Iterator i$ = trackFiles.iterator();
                    while (i$.hasNext()) {
                        file = (File) i$.next();
                        if (file.isFile() && file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        } else if ("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED".equals(action)) {
            boolean allDownloadSuccess = true;
            int statusIdx = c.getColumnIndex("status");
            c.moveToFirst();
            while (!c.isAfterLast()) {
                if (!DownloadProviderProxy.isStatusSuccess(c.getInt(statusIdx))) {
                    allDownloadSuccess = false;
                    break;
                }
                c.moveToNext();
            }
            if (!allDownloadSuccess) {
                openDownloadList(context);
            } else if (c.moveToFirst()) {
                String filename = c.getString(c.getColumnIndex("local_uri"));
                String mimetype = c.getString(c.getColumnIndex("media_type"));
                Intent intent = new Intent("android.intent.action.VIEW");
                Uri path2 = Uri.parse(filename);
                if (path2.getScheme() == null) {
                    path2 = Uri.fromFile(new File(filename));
                }
                intent.setDataAndType(path2, mimetype);
                intent.setFlags(268435456);
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException e2) {
                    Toast.makeText(context, context.getPackageName(), 1).show();
                }
            }
        }
    }
}
