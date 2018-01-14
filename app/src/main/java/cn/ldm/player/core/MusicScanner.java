package cn.ldm.player.core;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadata;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;


/**
 * 音乐扫描器
 */
final class MusicScanner {

    private Context mContext;
    private static final String tag = MusicScanner.class.getSimpleName();
    private static MusicScanner instance;

    public static MusicScanner getInstance(Context context) {
        synchronized (tag) {
            if (instance == null) {
                instance = new MusicScanner();
                instance.mContext = context;
            }
            return instance;
        }
    }

    //region 检索音乐媒体（不包含插图信息）

    /**
     * 检索音乐媒体（不包含插图信息）
     *
     * @return false, 当游标为 null 时
     */
    public boolean retrieveMedia(@NonNull ArrayList<MediaMetadata> outMedias) {
        Cursor cursor = mContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Audio.Media.IS_MUSIC + "!=0", null, null);
        if (cursor == null) return false;
        if (!cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
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
            outMedias.add(mediaMetadata);
        } while (cursor.moveToNext());
        cursor.close();
        return true;
    }
    //endregion

    //region 获取专辑封面

    /**
     * 获取专辑封面
     *
     * @return null, 当媒体没有唱片集封面时
     */
    public Bitmap retrieveAlbumArt(@NonNull MediaMetadata mediaMetadata) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        Uri uri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, Long.valueOf(mediaMetadata.getString(MediaMetadata.METADATA_KEY_MEDIA_ID)));
        String musicPath = mediaMetadata.getString(MediaMetadata.METADATA_KEY_ART_URI);
        if (!(new File(musicPath).exists())) {
            mContext.getContentResolver().delete(uri, null, null);
            return null;
        }
        retriever.setDataSource(mContext, uri);
        byte[] albumArtData = retriever.getEmbeddedPicture();
        retriever.release();
        Bitmap bitmap = null;
        if (albumArtData != null) bitmap = BitmapFactory.decodeByteArray(albumArtData, 0, albumArtData.length);
        return bitmap;
    }
    //endregion

    //region 检索播放列表
    // TODO: 2018.01.04.0004  检索播放列表
    public boolean retrieveAllPlayList(@Nullable ConcurrentMap<String, List<MediaMetadata>> outResult, Map<String, MediaMetadata> metadataMap) {
        Cursor cursor = mContext.getContentResolver().query(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
                null, null, null, null);
        if (cursor == null) return false;
        if (!cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        do {
            String playlistId = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Playlists._ID));
            String playlistName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Playlists.NAME));
            String playlistData = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Playlists.DATA));
            Log.i("abc", "retrieveAllPlayList: " + playlistData);
            Cursor query = mContext.getContentResolver().query(Uri.parse(playlistData), null,
                    MediaStore.Audio.Playlists.Members.PLAYLIST_ID + "==" + playlistId, null, null);
            outResult.put(playlistName, Collections.<MediaMetadata>emptyList());
            if (query == null) continue;
            if (!query.moveToNext()) {
                query.close();
                continue;
            }
            List<MediaMetadata> list = new ArrayList<>(query.getCount());
            do {
                list.add(metadataMap.get(query.getString(query.getColumnIndex(MediaStore.Audio.Playlists.Members.AUDIO_ID))));
            } while (query.moveToNext());
            outResult.get(playlistName).addAll(list);
        } while (cursor.moveToNext());
        return true;
    }
    //endregion
}
