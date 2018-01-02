package com.songbirdnest.mediaplayer;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import com.songbirdnest.mediaplayer.service.SongbirdMediaService;
import java.util.ArrayList;

public class SingleMediaScanner implements MediaScannerConnectionClient {
    private Context mContext;
    private String mFilename;
    private MediaScannerConnection mMediaScannerConnection;
    private SongbirdMediaService mService;

    public SingleMediaScanner(Context aContext, String filename, SongbirdMediaService aService) {
        this.mContext = aContext;
        this.mFilename = filename;
        this.mService = aService;
        this.mMediaScannerConnection = new MediaScannerConnection(aContext, this);
        this.mMediaScannerConnection.connect();
    }

    public void onMediaScannerConnected() {
        this.mMediaScannerConnection.scanFile(this.mFilename, null);
    }

    public void onScanCompleted(String aPath, Uri aUri) {
        this.mMediaScannerConnection.disconnect();
        try {
            PlayableItem item = Utils.createPlayableItemFromContentUri(this.mContext, aUri);
            if (item != null) {
                ArrayList<PlayableItem> list = new ArrayList(1);
                list.add(item);
                this.mService.setPlayableList(list, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
