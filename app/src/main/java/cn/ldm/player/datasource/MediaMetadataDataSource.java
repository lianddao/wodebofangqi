package cn.ldm.player.datasource;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import cn.ldm.player.model.SongInfo;

public class MediaMetadataDataSource {
    private static final String TAG = MediaMetadataDataSource.class.getSimpleName();
    private static final Uri MEDIA_URI = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    private static final String[] PROJECTION = null;
    private static final String SELECTION = MediaStore.Audio.Media.IS_MUSIC + "!=0";
    private static final String UNKNOWN = "unknown";

    //返回所有歌曲
    public static ArrayList<SongInfo> queryAll(Context context) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(MEDIA_URI, PROJECTION, SELECTION, null, null);
            if (!cursor.moveToFirst()) {
                return null;
            }
            ArrayList<SongInfo> result = new ArrayList<>(cursor.getCount());
            do {
                SongInfo songInfo = new SongInfo(cursor);
                result.add(songInfo);
            } while (cursor.moveToNext());
            return result;
        } finally {
            if (cursor != null) cursor.close();
        }
    }

    //返回 ConcurrentHashMap<'专辑','专辑包含的歌曲'>>
    public static ConcurrentHashMap<String, List<SongInfo>> queryByAlbum(Context context) {
        ConcurrentHashMap<String, List<SongInfo>> result = new ConcurrentHashMap<>();
        for (SongInfo songInfo : queryAll(context)) {
            String thisAlbum = songInfo.getAlbum();
            if (thisAlbum == null) thisAlbum = UNKNOWN;
            if (!result.containsKey(thisAlbum)) {
                result.put(thisAlbum, new ArrayList<SongInfo>());
            }
            result.get(thisAlbum).add(songInfo);
        }
        return result;
    }

    public static List<SongInfo> querySongsByAlbum(Context context, String album) {
        ConcurrentHashMap<String, List<SongInfo>> albums_songs = queryByAlbum(context);
        return albums_songs.get(album);
    }

    //返回 ConcurrentHashMap<'歌手',Map<'专辑','专辑包含的歌曲'>>
    public static ConcurrentHashMap<String, LinkedHashMap<String, SongInfo>> queryByArtist(Context context) {
        ConcurrentHashMap<String, LinkedHashMap<String, SongInfo>> result = new ConcurrentHashMap<>();
        for (SongInfo songInfo : queryAll(context)) {
            String thisArtist = songInfo.getArtist();
            if (thisArtist == null) thisArtist = UNKNOWN;
            String thisAlbum = songInfo.getAlbum();
            if (thisAlbum == null) thisAlbum = UNKNOWN;
            if (!result.containsKey(thisArtist)) {
                result.put(thisArtist, new LinkedHashMap<String, SongInfo>());
            }
            LinkedHashMap<String, SongInfo> albums = result.get(thisArtist);
            albums.put(thisAlbum, songInfo);
        }
        return result;
    }

    public static SongInfo queryById(Context context, String mediaId) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(MEDIA_URI, PROJECTION,
                    MediaStore.Audio.Media._ID + "=" + mediaId, null, null);
            if (!cursor.moveToFirst()) {
                return null;
            }

            SongInfo songInfo = new SongInfo(cursor);
            return songInfo;
        } finally {
            if (cursor != null) cursor.close();
        }
    }
}
