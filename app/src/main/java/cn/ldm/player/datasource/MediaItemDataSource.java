package cn.ldm.player.datasource;

import android.app.Activity;
import android.content.Context;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.ldm.player.model.SongInfo;

import static android.media.browse.MediaBrowser.MediaItem;

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

    //返回所有歌曲
    public static List<MediaItem> getSongsByTitleFlag(Context context) {
        ArrayList<SongInfo> songInfoArrayList = MediaMetadataDataSource.queryAll(context);
        ArrayList<MediaMetadata> metadataArrayList = new ArrayList<>(songInfoArrayList.size());
        for (SongInfo songInfo : songInfoArrayList) {
            metadataArrayList.add(songInfo.getMediaMetadata());
        }

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

    //返回所有专辑
    public static ArrayList<MediaItem> getByAlbumFlag(Context context) {
        ConcurrentHashMap<String, List<SongInfo>> albums_songs = MediaMetadataDataSource.queryByAlbum(context);
        ArrayList<MediaItem> mediaItems = new ArrayList<>(albums_songs.size());
        for (Map.Entry<String, List<SongInfo>> entry : albums_songs.entrySet()) {
            MediaItem item = new MediaItem(
                    builder.setMediaId(MEDIA_ID_MUSIC_BY_ALBUM + CATEGORY_SEPARATOR + entry.getKey())
                            .setTitle(entry.getKey())//专辑名称
                            .build(),
                    MediaItem.FLAG_BROWSABLE
            );
            mediaItems.add(item);
        }
        return mediaItems;
    }

    //返回指定专辑的歌曲
    public static ArrayList<MediaItem> getByAlbum(Context context, String album) {
        ConcurrentHashMap<String, List<SongInfo>> albums_songs = MediaMetadataDataSource.queryByAlbum(context);
        ArrayList<MediaItem> mediaItems = new ArrayList<>(albums_songs.size());
        for (SongInfo songInfo : albums_songs.get(album)) {
            String mediaId = MEDIA_ID_MUSIC_BY_ALBUM + CATEGORY_SEPARATOR + album
                    + LEAF_SEPARATOR + songInfo.getId();
            MediaItem item = new MediaItem(
                    builder.setMediaId(mediaId)
                            .setMediaUri(songInfo.getUri())
                            .setTitle(songInfo.getTitle())
                            .setSubtitle(songInfo.getSubtitle())
                            .build(),
                    MediaItem.FLAG_PLAYABLE
            );
            mediaItems.add(item);
        }
        return mediaItems;
    }

    //返回所有歌手
    public static ArrayList<MediaItem> getByArtistFlag(Context context) {
        ConcurrentHashMap<String, LinkedHashMap<String, SongInfo>> artists_albums = MediaMetadataDataSource.queryByArtist(context);
        ArrayList<MediaItem> mediaItems = new ArrayList<>(artists_albums.size());
        for (String artist : artists_albums.keySet()) {
            String mediaId = MEDIA_ID_MUSIC_BY_ARTIST + CATEGORY_SEPARATOR + artist;
            MediaItem item = new MediaItem(builder.setMediaId(mediaId).setTitle(artist).build(), MediaItem.FLAG_BROWSABLE);
            mediaItems.add(item);
        }
        return mediaItems;
    }

    //返回指定歌手的所有专辑
    public static ArrayList<MediaItem> getAlbumsByArtist(Context context, String artist) {
        ConcurrentHashMap<String, LinkedHashMap<String, SongInfo>> artists_albums = MediaMetadataDataSource.queryByArtist(context);
        ArrayList<MediaItem> mediaItems = new ArrayList<>();
        for (String album : artists_albums.get(artist).keySet()) {
            String mediaId = MEDIA_ID_MUSIC_BY_ARTIST + CATEGORY_SEPARATOR + artist + CATEGORY_SEPARATOR + album + LEAF_SEPARATOR;
            MediaItem item = new MediaItem(builder.setMediaId(mediaId).setTitle(album).build(), MediaItem.FLAG_BROWSABLE);
            mediaItems.add(item);
        }
        return mediaItems;
    }

    //为歌手按专辑获取歌曲
    public static ArrayList<MediaItem> getSongsByAlbumForArtist(Context context, String artist, String album) {
        ConcurrentHashMap<String, LinkedHashMap<String, SongInfo>> artists_albums = MediaMetadataDataSource.queryByArtist(context);
        LinkedHashMap<String, SongInfo> albums_songs = artists_albums.get(artist);
        if (albums_songs.containsKey(album)) {
            List<SongInfo> metadataList = MediaMetadataDataSource.querySongsByAlbum(context, album);
            ArrayList<MediaItem> mediaItems = new ArrayList<>(metadataList.size());
            for (SongInfo songInfo : metadataList) {
                String mediaId = MEDIA_ID_MUSIC_BY_ARTIST + CATEGORY_SEPARATOR + artist + CATEGORY_SEPARATOR
                        + album + LEAF_SEPARATOR + songInfo.getId();
                MediaItem item = new MediaItem(
                        builder.setMediaId(mediaId)
                                .setMediaUri(songInfo.getUri())
                                .setTitle(songInfo.getTitle())
                                .setSubtitle(songInfo.getSubtitle())
                                .build(),
                        MediaItem.FLAG_PLAYABLE);
                mediaItems.add(item);
            }
            return mediaItems;
        }
        return null;
    }

}
