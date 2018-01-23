package cn.ldm.player.datasource;

import android.content.Context;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.net.Uri;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static android.media.browse.MediaBrowser.MediaItem;
import static cn.ldm.player.services.MyMediaBrowserService.LEAF_SEPARATOR;

/**
 * Created by LDM on 2018.01.23.0023.
 */

public class MediaItemDataSource {
    private static final String TAG = MediaItemDataSource.class.getSimpleName();
    private static final String MEDIA_ID_MUSIC_BY_TITLE = "__BY_TITLE__";
    private static final String MEDIA_ID_MUSIC_BY_ARTIST = "__BY_ARTIST__";
    private static final String MEDIA_ID_MUSIC_BY_ALBUM = "__BY_ALBUM__";
    private static final String MEDIA_ID_MUSIC_BY_PLAYLIST = "__BY_PLAYLIST__";
    private static final MediaDescription.Builder builder = new MediaDescription.Builder();
    private static final MediaItem[] ROOT_MEDIA_ITEMS = {
            new MediaItem(builder.setMediaId(MEDIA_ID_MUSIC_BY_TITLE).setTitle("全部歌曲").build(), MediaItem.FLAG_BROWSABLE),
            new MediaItem(builder.setMediaId(MEDIA_ID_MUSIC_BY_ARTIST).setTitle("歌手").build(), MediaItem.FLAG_BROWSABLE),
            new MediaItem(builder.setMediaId(MEDIA_ID_MUSIC_BY_ALBUM).setTitle("专辑").build(), MediaItem.FLAG_BROWSABLE),
            new MediaItem(builder.setMediaId(MEDIA_ID_MUSIC_BY_PLAYLIST).setTitle("播放列表").build(), MediaItem.FLAG_BROWSABLE),
    };
    public static final char CATEGORY_SEPARATOR = 31;  //单元分隔符 US ␟
    public static final char LEAF_SEPARATOR = 30;      //记录分隔符 RS ␞

    public static List<MediaItem> getByRootFlag() {
        return Arrays.asList(ROOT_MEDIA_ITEMS);
    }

    public static List<MediaItem> getByTitleFlag(Context context) {
        ArrayList<MediaMetadata> metadataArrayList = MediaMetadataDataSource.queryAll(context);
        ArrayList<MediaItem> mediaItems = new ArrayList<>(metadataArrayList.size());
        for (MediaMetadata metadata : metadataArrayList) {
            MediaDescription description = new MediaDescription.Builder()
                    .setMediaId(MEDIA_ID_MUSIC_BY_TITLE + LEAF_SEPARATOR + metadata.getString(MediaMetadata.METADATA_KEY_MEDIA_ID))
                    .setMediaUri(Uri.parse(metadata.getString(MediaMetadata.METADATA_KEY_ART_URI)))
                    .setTitle(metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE))
                    .setSubtitle(metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_SUBTITLE))
                    .build();
            MediaItem item = new MediaItem(description, MediaItem.FLAG_PLAYABLE);
            mediaItems.add(item);
        }
        return mediaItems;
    }

    public static ArrayList<MediaItem> getByAlbumFlag(Context context) {
        ConcurrentHashMap<String, List<MediaMetadata>> data = MediaMetadataDataSource.queryByAlbum(context);
        ArrayList<MediaItem> mediaItems = new ArrayList<>(data.size());
        for (Map.Entry<String, List<MediaMetadata>> entry : data.entrySet()) {
            MediaItem item = new MediaItem(
                    builder.setMediaId(MEDIA_ID_MUSIC_BY_ALBUM + CATEGORY_SEPARATOR + entry.getKey())
                            .setTitle(entry.getKey())
                            .build(),
                    MediaItem.FLAG_BROWSABLE
            );
            mediaItems.add(item);
        }
        return mediaItems;
    }

}
