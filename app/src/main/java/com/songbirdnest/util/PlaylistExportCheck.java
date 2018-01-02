package com.songbirdnest.util;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.MediaStore.Audio.Playlists;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.PlaylistExporter;
import com.songbirdnest.mediaplayer.Utils;

public class PlaylistExportCheck extends AsyncTask<Void, Void, Void> {
    Context mContext;

    public PlaylistExportCheck(Context pContext) {
        this.mContext = pContext;
    }

    protected Void doInBackground(Void... params) {
        Cursor aCursor = this.mContext.getContentResolver().query(Playlists.EXTERNAL_CONTENT_URI, new String[]{CookieTable.NAME, "_data", "date_added", "date_modified", "_id"}, null, null, "name ASC");
        if (aCursor == null || !aCursor.moveToFirst()) {
            return null;
        }
        do {
            int aDataCol = aCursor.getColumnIndex("_data");
            int aIDCol = aCursor.getColumnIndex("_id");
            String path = aCursor.getString(aDataCol);
            final int id = aCursor.getInt(aIDCol);
            if (path == null) {
                PlaylistExporter.exportPlaylistToFileRun(this.mContext, (long) id, 1, new Runnable() {
                    public void run() {
                        Utils.removeMediaStorePlaylist(PlaylistExportCheck.this.mContext, id, Utils.sExternalStorageVolumeName);
                        Utils.scanSd(PlaylistExportCheck.this.mContext);
                    }
                });
            }
        } while (aCursor.moveToNext());
        return null;
    }
}
