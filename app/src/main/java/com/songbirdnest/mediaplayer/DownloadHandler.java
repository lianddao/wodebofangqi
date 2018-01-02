package com.songbirdnest.mediaplayer;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.songbirdnest.mediaplayer.service.IMediaServiceBinder;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;

public class DownloadHandler {
    private static final String fileUriPrefix = "file://";

    static class C01111 extends BroadcastReceiver {
        C01111() {
        }

        public void onReceive(final Context aContext, Intent intent) {
            if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                try {
                    final String mFilename = DownloadHandler.getDownloadFilename(aContext, intent.getLongExtra("extra_download_id", 0));
                    ((SongbirdApplication) aContext.getApplicationContext()).getMediaService(new IMediaServiceBinder() {
                        public void onMediaServiceConnected(SongbirdMediaService aMediaService) {
                            SingleMediaScanner singleMediaScanner = new SingleMediaScanner(aContext, mFilename, aMediaService);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static long requestEnqueue(Context aContext, Uri aUri) {
        if (!isSupported()) {
            return -1;
        }
        Request request = new Request(aUri);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_MUSIC, aUri.getLastPathSegment());
        return ((DownloadManager) aContext.getSystemService(Utils.ANDROID_DOWNLOAD_FOLDER)).enqueue(request);
    }

    public static BroadcastReceiver getBroadcastReceiver() {
        return new C01111();
    }

    protected static String getDownloadFilename(Context aContext, long downloadId) throws Exception {
        Query query = new Query();
        query.setFilterById(new long[]{downloadId});
        Cursor cursor = ((DownloadManager) aContext.getSystemService(Utils.ANDROID_DOWNLOAD_FOLDER)).query(query);
        if (cursor.moveToFirst()) {
            int status = cursor.getInt(cursor.getColumnIndex("status"));
            if (8 != status) {
                throw new Exception("DownloadHandler: Status not successful " + status);
            }
            String localUri = cursor.getString(cursor.getColumnIndex("local_uri"));
            if (localUri.startsWith(fileUriPrefix)) {
                return localUri.substring(fileUriPrefix.length());
            }
            throw new Exception("DownloadHandler: Unknown uri " + localUri);
        }
        throw new Exception("DownloadHandler: Empty cursor for id " + downloadId);
    }

    public static IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        return intentFilter;
    }

    public static boolean isSupported() {
        return VERSION.SDK_INT >= 9;
    }
}
