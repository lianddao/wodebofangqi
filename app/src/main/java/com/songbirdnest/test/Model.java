package com.songbirdnest.test;

import android.app.Activity;
import android.database.Cursor;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;
import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.util.MediaUtils;

public class Model {

    public static class Album {
        public static final String TAG = "Album";

        private static Cursor getCursor(Activity activity) throws Exception {
            return getCursorMerged(activity);
        }

        private static Cursor getCursorMerged(Activity activity) throws Exception {
            Cursor cursor = MediaUtils.getMediaStoreMergeCursorForAlbum(activity, new String[]{"_id", "album_key", "album", "artist", "numsongs", "album_art"}, null, null, "album_key ASC");
            if (cursor != null) {
                return cursor;
            }
            throw new Exception("Database not available. Check 'USB Mount' status");
        }

        public static int getCount(Activity activity) throws Exception {
            return getCursor(activity).getCount();
        }
    }

    public static class Artist {
        public static final String TAG = "Artist";

        private static Cursor getCursor(Activity activity) throws Exception {
            return getCursorMerged(activity);
        }

        private static Cursor getCursorMerged(Activity activity) throws Exception {
            Activity activity2 = activity;
            Cursor cursor = MediaUtils.getMediaStoreMergeCursorForArtist(activity2, new String[]{"_id", "artist", "artist_key", "number_of_tracks", "number_of_albums"}, null, null, "artist_key ASC", false);
            if (cursor != null) {
                return cursor;
            }
            throw new Exception("Database not available. Check 'USB Mount' status");
        }

        public static int getCount(Activity activity) throws Exception {
            return getCursor(activity).getCount();
        }
    }

    public static class Genre {
        public static final String TAG = "Genre";

        private static Cursor getCursor(Activity activity) throws Exception {
            return getCursorMerged(activity);
        }

        private static Cursor getCursorMerged(Activity activity) throws Exception {
            Activity activity2 = activity;
            Cursor cursor = MediaUtils.getMediaStoreMergeCursorForGenre(activity2, new String[]{"_id", CookieTable.NAME}, null, null, "name ASC", false);
            if (cursor != null) {
                return cursor;
            }
            throw new Exception("Database not available. Check 'USB Mount' status");
        }

        public static int getCount(Activity activity) throws Exception {
            return getCursor(activity).getCount();
        }
    }

    public static class Playlist {
        public static void removeAll(Activity activity) throws Exception {
            Cursor cursor = getCursor(activity);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int playlistIdColumn = cursor.getColumnIndex("_id");
                String playlistVolume = Utils.getVolumeFromCursor(cursor);
                do {
                    Utils.removeMediaStorePlaylist(activity, Long.valueOf(cursor.getLong(playlistIdColumn)).intValue(), playlistVolume);
                } while (cursor.moveToNext());
            }
        }

        public static Cursor getCursor(Activity activity) throws Exception {
            Cursor cursor = MediaUtils.getMediaStoreMergeCursorForPlaylist(activity, new String[]{"_id", CookieTable.NAME}, null, null, "name ASC");
            if (cursor != null) {
                return cursor;
            }
            throw new Exception("Database not available. Check 'USB Mount' status");
        }

        public static int getCount(Activity activity) throws Exception {
            return getCursor(activity).getCount();
        }
    }

    public static class Song {
        public static final String TAG = "Song";

        public static void removeAll(Activity activity) throws Exception {
            Cursor cursor = getCursor(activity);
            if (cursor.moveToFirst()) {
                int count = cursor.getCount();
                int dataColumnIndex = cursor.getColumnIndex("_data");
                for (int i = 0; i < count; i++) {
                    String playablePath = cursor.getString(dataColumnIndex);
                    Log.i(TAG, "Removing: " + i + ":" + playablePath);
                    Control.removeFile(playablePath);
                    cursor.moveToNext();
                }
                Control.scanBlocking(activity);
            }
        }

        private static Cursor getCursor(Activity activity) throws Exception {
            return getCursorExternal(activity);
        }

        private static Cursor getCursorExternal(Activity activity) throws Exception {
            String[] proj = new String[]{"_id", "title", "duration", "artist", "album", "_data", "title_key"};
            String[] selectionArgs = new String[]{"1"};
            Cursor externalStorageCursor = activity.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, proj, "is_music = ? ", selectionArgs, "title_key ASC");
            if (externalStorageCursor != null) {
                return externalStorageCursor;
            }
            throw new Exception("Database not available. Check 'USB Mount' status");
        }

        private static Cursor getCursorMerged(Activity activity) throws Exception {
            Cursor songCursor = MediaUtils.getMediaStoreMergeCursor(activity, new String[]{"_id", "title", "duration", "artist", "album", "_data", "title_key"}, "is_music", new String[]{"1"}, "title_key ASC");
            if (songCursor != null) {
                return songCursor;
            }
            throw new Exception("Database not available. Check 'USB Mount' status");
        }

        public static int getCount(Activity activity) throws Exception {
            return getCursor(activity).getCount();
        }
    }
}
