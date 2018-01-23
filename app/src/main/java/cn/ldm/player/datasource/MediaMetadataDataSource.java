package cn.ldm.player.datasource;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MediaMetadataDataSource {
    private static final String TAG = MediaMetadataDataSource.class.getSimpleName();
    private static final String[] PROJECTION_DEFAULT = null;
    private static final String SELECTION_DEFAULT = MediaStore.Audio.Media.IS_MUSIC + "!=0";
    private static final String UNKNOWN = "unknown";

    public static ArrayList<MediaMetadata> queryAll(Context context) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    PROJECTION_DEFAULT, SELECTION_DEFAULT, null, null);
            if (!cursor.moveToFirst()) {
                return null;
            }
            ArrayList<MediaMetadata> result = new ArrayList<>(cursor.getCount());
            do {
                String id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                MediaMetadata mediaMetadata = new MediaMetadata.Builder()
                        .putString(MediaMetadata.METADATA_KEY_MEDIA_ID, id)
                        .putString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE, title)
                        .putString(MediaMetadata.METADATA_KEY_ARTIST, artist)
                        .putString(MediaMetadata.METADATA_KEY_ALBUM, album)
                        .putString(MediaMetadata.METADATA_KEY_DISPLAY_SUBTITLE, artist + " - " + album)
                        .putLong(MediaMetadata.METADATA_KEY_DURATION, duration)
                        .putString(MediaMetadata.METADATA_KEY_ART_URI, data)
                        .build();
                result.add(mediaMetadata);
                Log.i(TAG, "queryAll: ");
            } while (cursor.moveToNext());
            return result;
        } finally {
            if (cursor != null) cursor.close();
        }
    }

    public static ConcurrentHashMap<String, List<MediaMetadata>> queryByAlbum(Context context) {
        ArrayList<MediaMetadata> metadataArrayList = queryAll(context);
        ConcurrentHashMap<String, List<MediaMetadata>> result = new ConcurrentHashMap<>();
        for (MediaMetadata metadata : metadataArrayList) {
            String thisAlbum = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
            if (thisAlbum == null) thisAlbum = UNKNOWN;
            if (!result.containsKey(thisAlbum)) {
                result.put(thisAlbum, new ArrayList<MediaMetadata>());
            }
            result.get(thisAlbum).add(metadata);
        }
        return result;
    }
}
