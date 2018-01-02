package com.songbirdnest.mediaplayer;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore.Audio.Playlists;
import android.provider.MediaStore.Audio.Playlists.Members;
import com.songbirdnest.database.cookies.CookieTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PlaylistExporter {
    public static final String DEFAULT_EXPORT_LOCATION = (File.separator + Constants.TOP_MENU_PLAYLISTS + File.separator);
    public static final File DEFAULT_MOUNT_POINT = Environment.getExternalStorageDirectory();
    public static final int TYPE_M3U8 = 1;
    public static final String TYPE_M3U8_FILE_EXT = "m3u";

    public static int exportPlaylistsToFiles(Context aContext, int aPlaylistType) {
        if (aPlaylistType != 1) {
            return -1;
        }
        Cursor playlistsCursor = aContext.getContentResolver().query(Playlists.EXTERNAL_CONTENT_URI, new String[]{"_id"}, null, null, null);
        if (playlistsCursor == null) {
            closeCursor(playlistsCursor);
            return -1;
        }
        int exportedCount = 0;
        while (playlistsCursor.moveToNext()) {
            if (exportPlaylistToFile(aContext, playlistsCursor.getLong(0), aPlaylistType) > -1) {
                exportedCount++;
            }
        }
        closeCursor(playlistsCursor);
        return exportedCount;
    }

    public static void exportPlaylistsToFilesAsync(Context aContext, int aPlaylistType) {
        AnonymousClass1PlaylistExportTask task = new AsyncTask<Void, Void, Void>() {
            private Context mContext = null;
            private int mPlaylistExportType = 1;

            public void setContext(Context aContext) {
                this.mContext = aContext;
            }

            public void setPlaylistExportType(int aPlaylistExportType) {
                this.mPlaylistExportType = aPlaylistExportType;
            }

            protected Void doInBackground(Void... params) {
                PlaylistExporter.exportPlaylistsToFiles(this.mContext, this.mPlaylistExportType);
                return null;
            }
        };
        task.setContext(aContext);
        task.setPlaylistExportType(aPlaylistType);
        task.execute(new Void[0]);
    }

    public static int exportPlaylistToFileRun(Context aContext, long aPlaylistId, int aPlaylistType, Runnable aExtra) {
        int aRet = exportPlaylistToFile(aContext, aPlaylistId, aPlaylistType);
        aExtra.run();
        return aRet;
    }

    public static int exportPlaylistToFile(Context aContext, long aPlaylistId, int aPlaylistType) {
        if (aPlaylistType != 1) {
            return -1;
        }
        ContentResolver contentResolver = aContext.getContentResolver();
        Cursor playlistCursor = contentResolver.query(Playlists.EXTERNAL_CONTENT_URI, new String[]{CookieTable.NAME}, "_id = ?", new String[]{Long.toString(aPlaylistId)}, null);
        if (playlistCursor.moveToFirst()) {
            String playlistName = playlistCursor.getString(0);
            ContentResolver contentResolver2 = contentResolver;
            Cursor playlistEntriesCursor = contentResolver2.query(Members.getContentUri(Utils.sExternalStorageVolumeName, aPlaylistId), new String[]{"_data", "play_order"}, null, null, "play_order ASC");
            if (playlistEntriesCursor == null) {
                closeCursor(playlistEntriesCursor);
                closeCursor(playlistCursor);
                return -1;
            }
            File externalStorageDir = Environment.getExternalStorageDirectory();
            String playlistDirectoryPath = externalStorageDir.getPath() + DEFAULT_EXPORT_LOCATION;
            File playlistDirectory = new File(playlistDirectoryPath);
            if (!playlistDirectory.exists()) {
                playlistDirectory.mkdirs();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDir.getPath() + DEFAULT_EXPORT_LOCATION + playlistName + "." + TYPE_M3U8_FILE_EXT));
                int entryCount = 0;
                int columnId = playlistEntriesCursor.getColumnIndex("_data");
                while (playlistEntriesCursor.moveToNext()) {
                    try {
                        fileOutputStream.write(makeRelativePathFile(playlistEntriesCursor.getString(columnId), playlistDirectoryPath).getBytes());
                        fileOutputStream.write(10);
                        entryCount++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileOutputStream.close();
                    closeCursor(playlistCursor);
                    closeCursor(playlistEntriesCursor);
                    return entryCount;
                } catch (IOException e2) {
                    closeCursor(playlistCursor);
                    closeCursor(playlistEntriesCursor);
                    e2.printStackTrace();
                    return -1;
                }
            } catch (FileNotFoundException fnfe) {
                closeCursor(playlistCursor);
                closeCursor(playlistEntriesCursor);
                fnfe.printStackTrace();
                return -1;
            } catch (SecurityException se) {
                closeCursor(playlistCursor);
                closeCursor(playlistEntriesCursor);
                se.printStackTrace();
                return -1;
            }
        }
        closeCursor(playlistCursor);
        return 0;
    }

    public static void exportPlaylistToFileAsync(Context aContext, int aPlaylistId, int aPlaylistType) {
        AnonymousClass2PlaylistExportTask task = new AsyncTask<Void, Void, Void>() {
            private Context mContext = null;
            private int mPlaylistExportType = 1;
            private int mPlaylistId = -1;

            public void setContext(Context aContext) {
                this.mContext = aContext;
            }

            public void setPlaylistExportType(int aPlaylistExportType) {
                this.mPlaylistExportType = aPlaylistExportType;
            }

            public void setPlaylistId(int aPlaylistId) {
                this.mPlaylistId = aPlaylistId;
            }

            protected Void doInBackground(Void... params) {
                PlaylistExporter.exportPlaylistToFile(this.mContext, (long) this.mPlaylistId, this.mPlaylistExportType);
                return null;
            }
        };
        task.setContext(aContext);
        task.setPlaylistExportType(aPlaylistType);
        task.setPlaylistId(aPlaylistId);
        task.execute(new Void[0]);
    }

    private static void closeCursor(Cursor aCursor) {
        try {
            aCursor.close();
        } catch (Exception e) {
        }
    }

    private static String makeRelativePathFile(String aFile, String aRelativeToFile) {
        String[] filePathParts = aFile.split(File.separator);
        String[] relativeToFileParts = aRelativeToFile.split(File.separator);
        String relativePath = "";
        String relativePathDepth = "";
        int i = 2;
        while (i < relativeToFileParts.length) {
            if (filePathParts.length <= i || !filePathParts[i].equals(relativeToFileParts[i])) {
                relativePathDepth = relativePathDepth + ".." + File.separator;
                if (filePathParts.length > i) {
                    relativePath = relativePath + filePathParts[i];
                }
                if (i + 1 >= relativeToFileParts.length || i + 1 >= filePathParts.length) {
                    for (int j = i + 1; j < filePathParts.length; j++) {
                        relativePath = (relativePath + File.separator) + filePathParts[j];
                    }
                } else {
                    relativePath = relativePath + File.separator;
                }
            }
            i++;
        }
        return relativePathDepth + relativePath;
    }
}
