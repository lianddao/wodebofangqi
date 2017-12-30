package cn.ldm.player.core;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.provider.MediaStore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by LDM on 2017.12.30.0030.
 */

public final class MusicDataSource {

    public final static String UNKNOWN = "unknown";
    private static MusicDataSource instance;
    private ConcurrentMap<String, Map<String, MediaMetadata>> mArtistList;
    private MediaMetadata.Builder mMediaMetadataBuilder;

    public static MusicDataSource getInstance() {
        synchronized (MusicDataSource.class) {
            if (instance == null) {
                instance = new MusicDataSource();
                instance.mMediaMetadataBuilder = new MediaMetadata.Builder();
            }
            return instance;
        }
    }

    private void addMusicToArtistList(MediaMetadata metadata) {
        String thisArtist = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
        if (thisArtist == null) {
            thisArtist = UNKNOWN;
        }
        String thisAlbum = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
        if (thisAlbum == null) {
            thisAlbum = UNKNOWN;
        }
        if (!mArtistList.containsKey(thisArtist)) {
            mArtistList.put(thisArtist, new ConcurrentHashMap<String, MediaMetadata>());
        }
        Map<String, MediaMetadata> albumsMap = mArtistList.get(thisArtist);
        MediaMetadata.Builder builder;
        long count = 0;
        //        Bitmap thisAlbumArt = metadata.getBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART);
        if (albumsMap.containsKey(thisAlbum)) {
            MediaMetadata album_metadata = albumsMap.get(thisAlbum);
            count = album_metadata.getLong(MediaMetadata.METADATA_KEY_NUM_TRACKS);
            Bitmap nAlbumArt = album_metadata.getBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART);
            builder = new MediaMetadata.Builder(album_metadata);
            if (nAlbumArt != null) {
                //                thisAlbumArt = null;
            }
        } else {
            builder = new MediaMetadata.Builder();
            builder.putString(MediaMetadata.METADATA_KEY_ALBUM, thisAlbum)
                    .putString(MediaMetadata.METADATA_KEY_ARTIST, thisArtist);
        }
        //        if (thisAlbumArt != null) {
        //            builder.putBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART, thisAlbumArt);
        //        }
        builder.putLong(MediaMetadata.METADATA_KEY_NUM_TRACKS, count + 1);
        albumsMap.put(thisAlbum, builder.build());
    }
}
