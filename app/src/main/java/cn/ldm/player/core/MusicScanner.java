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

import java.io.File;
import java.util.ArrayList;


/**
 * 音乐扫描器
 */
public class MusicScanner {

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

}
