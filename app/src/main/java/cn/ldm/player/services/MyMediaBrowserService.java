package cn.ldm.player.services;

import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.MediaPlayer;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.service.media.MediaBrowserService;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.ldm.player.core.MusicMetadataDataSource;
import cn.ldm.player.loader.PlaylistLoader;
import cn.ldm.player.model.Playlist;
import cn.ldm.player.model.Song;


/**
 * 我的媒体浏览服务
 */
public class MyMediaBrowserService extends MediaBrowserService {
    private static final String TAG = MyMediaBrowserService.class.getSimpleName();
    public final static String MEDIA_ID_ROOT = "__ROOT__";
    public final static String MEDIA_ID_MUSIC_BY_TITLE = "__BY_TITLE__";
    public final static String MEDIA_ID_MUSIC_BY_ARTIST = "__BY_ARTIST__";
    public final static String MEDIA_ID_MUSIC_BY_ALBUM = "__BY_ALBUM__";
    public final static String MEDIA_ID_MUSIC_BY_PLAYLIST = "__BY_PLAYLIST__";

    private MediaSession mSession;
    private MediaPlayer mMediaPlayer;

    private List<MediaItem> mediaItems = new ArrayList<>();

    //region 当运行mediaBrowser.subscribe(..)时,才运行
    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        return new BrowserRoot(MEDIA_ID_ROOT, null);// 知道 __ROOT__ 的人可以浏览
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaItem>> result) {
        if (parentId == null) {
            result.sendResult(null);
            return;
        }
        result.detach();
        // 获取本地或网络文件
        MusicMetadataDataSource dataSource = MusicMetadataDataSource.getInstance(this);
        mediaItems.clear();
        switch (parentId) {
            case MEDIA_ID_ROOT:
                //region ..
                Log.i(TAG, "根据'__ROOT__'组织数据");
                mediaItems.add(
                        new MediaItem(
                                new MediaDescription.Builder()
                                        .setMediaId(MEDIA_ID_MUSIC_BY_TITLE)
                                        .setTitle("全部歌曲")
                                        .build(),
                                MediaItem.FLAG_BROWSABLE)
                );
                mediaItems.add(
                        new MediaItem(
                                new MediaDescription.Builder()
                                        .setMediaId(MEDIA_ID_MUSIC_BY_ARTIST)
                                        .setTitle("歌手")
                                        .build(),
                                MediaItem.FLAG_BROWSABLE)
                );
                mediaItems.add(
                        new MediaItem(
                                new MediaDescription.Builder()
                                        .setMediaId(MEDIA_ID_MUSIC_BY_ALBUM)
                                        .setTitle("专辑")
                                        .build(),
                                MediaItem.FLAG_BROWSABLE)
                );
                mediaItems.add(
                        new MediaItem(
                                new MediaDescription.Builder()
                                        .setMediaId(MEDIA_ID_MUSIC_BY_PLAYLIST)
                                        .setTitle("播放列表")
                                        .build(),
                                MediaItem.FLAG_BROWSABLE
                        )
                );
                //endregion
                break;
            case MEDIA_ID_MUSIC_BY_TITLE:
                //region ..
                Log.i(TAG, "根据'__BY_TITLE__'组织数据");
                for (Map.Entry<String, MediaMetadata> entry : dataSource.getMusicListByTitle().entrySet()) {
                    MediaItem item = new MediaItem(
                            new MediaDescription.Builder()
                                    .setMediaId(MEDIA_ID_MUSIC_BY_TITLE + CATEGORY_SEPARATOR + entry.getValue().getDescription()
                                            .getTitle())
                                    .setTitle(entry.getValue().getDescription().getTitle())
                                    .setMediaUri(Uri.parse(entry.getValue().getString(MediaMetadata.METADATA_KEY_ART_URI)))
                                    .build(),
                            MediaItem.FLAG_PLAYABLE
                    );
                    mediaItems.add(item);
                }
                //endregion
                break;
            case MEDIA_ID_MUSIC_BY_ALBUM:
                //region ..
                Log.i(TAG, "根据'__BY_ALBUM__'组织数据");
                for (Map.Entry<String, List<MediaMetadata>> entry : dataSource.getMusicListByAlbum().entrySet()) {
                    MediaItem item = new MediaItem(
                            new MediaDescription.Builder()
                                    .setMediaId(MEDIA_ID_MUSIC_BY_ALBUM + CATEGORY_SEPARATOR + entry.getKey())
                                    .setTitle(entry.getKey())
                                    .setDescription("专辑名称")
                                    .build(),
                            MediaItem.FLAG_BROWSABLE
                    );
                    mediaItems.add(item);
                }
                //endregion
                break;
            case MEDIA_ID_MUSIC_BY_ARTIST:
                //region ..
                Log.i(TAG, "根据'__BY_ARTIST__'组织数据");
                for (Map.Entry<String, Map<String, MediaMetadata>> entry : dataSource.getMusicListByArtist().entrySet()) {
                    MediaItem item = new MediaItem(
                            new MediaDescription.Builder()
                                    .setMediaId(MEDIA_ID_MUSIC_BY_ARTIST + CATEGORY_SEPARATOR + entry.getKey())
                                    .setTitle(entry.getKey())
                                    .setDescription("音乐人名称")
                                    .build(),
                            MediaItem.FLAG_BROWSABLE);
                    mediaItems.add(item);
                }
                // TODO: 2018.01.16.0016 简化 将数据转换为MediaItem集合
                //endregion
                break;
            case MEDIA_ID_MUSIC_BY_PLAYLIST:
                //region ..
                Log.i(TAG, "根据'__BY_PLAYLIST__'组织数据");
                for (Playlist playlist : new PlaylistLoader(this).loadInBackground()) {
                    MediaItem item = new MediaItem(
                            new MediaDescription.Builder()
                                    .setMediaId(parentId + LEAF_SEPARATOR + playlist.mPlaylistId)
                                    .setTitle(playlist.mPlaylistName)
                                    .build(),
                            MediaItem.FLAG_BROWSABLE
                    );
                    mediaItems.add(item);
                }
                //endregion
                break;
            default:
                if (!parentId.endsWith(String.valueOf(LEAF_SEPARATOR))) {
                    if (parentId.startsWith(MEDIA_ID_MUSIC_BY_ALBUM)) {
                        Log.i(TAG, "根据'__BY_ALBUM__专辑名称'组织数据");
                        //region ..
                        String album = parentId.split(String.valueOf(CATEGORY_SEPARATOR))[1];
                        for (MediaMetadata metadata : dataSource.getMusicListByAlbum(album)) {
                            MediaItem item = new MediaItem(
                                    new MediaDescription.Builder()
                                            .setMediaId(MEDIA_ID_MUSIC_BY_ALBUM + CATEGORY_SEPARATOR + album + LEAF_SEPARATOR
                                                    + metadata.getDescription().getMediaId())
                                            .setTitle(metadata.getDescription().getTitle())
                                            .setMediaUri(Uri.parse(metadata.getString(MediaMetadata.METADATA_KEY_ART_URI)))
                                            .build(),
                                    MediaItem.FLAG_PLAYABLE
                            );
                            mediaItems.add(item);
                        }
                        //endregion
                    } else if (parentId.startsWith(MEDIA_ID_MUSIC_BY_ARTIST)) {
                        Log.i(TAG, "根据'__BY_ARTIST__歌手名称'组织数据");
                        //region ..
                        String artist = parentId.split(String.valueOf(CATEGORY_SEPARATOR))[1];
                        for (Map.Entry<String, MediaMetadata> entry : dataSource.getMusicListByArtist(artist).entrySet()) {
                            MediaItem item = new MediaItem(
                                    new MediaDescription.Builder()
                                            .setMediaId(MEDIA_ID_MUSIC_BY_ARTIST + CATEGORY_SEPARATOR + artist + CATEGORY_SEPARATOR
                                                    + entry.getKey() + LEAF_SEPARATOR)
                                            .setTitle(entry.getKey())
                                            .setMediaUri(Uri.parse(entry.getValue().getString(MediaMetadata.METADATA_KEY_ART_URI)))
                                            .build(),
                                    MediaItem.FLAG_BROWSABLE);
                            mediaItems.add(item);
                        }
                        //endregion
                    } else if (parentId.startsWith(MEDIA_ID_MUSIC_BY_PLAYLIST)) {
                        Log.i(TAG, "根据'__BY_PLAYLIST__播放列表名称'组织数据 " + parentId);
                        //region ..
                        long playlistId = Long.valueOf(parentId.split(String.valueOf(LEAF_SEPARATOR))[1]);
                        if (playlistId < 0) break;
                        PlaylistLoader playlistLoader = new PlaylistLoader(this);
                        for (Song song : playlistLoader.getSongForPlaylist(playlistId)) {
                            MediaItem item = new MediaItem(
                                    new MediaDescription.Builder()
                                            .setMediaId(parentId + LEAF_SEPARATOR + song.mSongId)
                                            .setTitle(song.mSongName)
                                            .build(),
                                    MediaItem.FLAG_PLAYABLE
                            );
                            mediaItems.add(item);
                        }
                        //endregion
                    }
                } else {
                    Log.i(TAG, parentId);
                    //region ..
                    String[] split = parentId.split(String.valueOf(LEAF_SEPARATOR))[0].split(String.valueOf(CATEGORY_SEPARATOR));
                    for (MediaMetadata metadata : dataSource.getMusicListByAlbumForArtist(split[1], split[2])) {
                        MediaItem item = new MediaItem(
                                new MediaDescription.Builder()
                                        .setMediaId(parentId + metadata.getDescription().getTitle())
                                        .setTitle(metadata.getDescription().getTitle())
                                        .setMediaUri(Uri.parse(metadata.getString(MediaMetadata.METADATA_KEY_ART_URI)))
                                        .build(),
                                MediaItem.FLAG_PLAYABLE);
                        mediaItems.add(item);
                    }
                    //endregion
                }
                break;
        }

        result.sendResult(mediaItems);
    }
    //endregion


    @Override
    public void onCreate() {
        super.onCreate();
        mSession = new MediaSession(this, MyMediaBrowserService.class.getName());
        setSessionToken(mSession.getSessionToken());
        mSession.setCallback(new MediaSession.Callback() {
            @Override
            public void onPlayFromMediaId(String mediaId, Bundle extras) {
                MediaItem mediaItem = null;
                for (MediaItem item : mediaItems) {
                    if (item.getMediaId().equals(mediaId)) {
                        Log.d(TAG, "onPlayFromMediaId: " + mediaId);
                        mediaItem = item;
                        break;
                    }
                }
                try {
                    createMediaPlayerIfNeeded();
                    mMediaPlayer.setDataSource(getApplicationContext(), mediaItem.getDescription().getMediaUri());
                    mMediaPlayer.prepare();
                    mMediaPlayer.start();
                } catch (Exception ex) {
                    Log.i(TAG, "onPlayFromMediaId: " + ex.toString());
                }
            }
        });
    }

    private void createMediaPlayerIfNeeded() {
        Log.d(TAG, "createMediaPlayerIfNeeded. needed? " + (mMediaPlayer == null));
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        } else {
            mMediaPlayer.reset();
        }
    }

    public static final char CATEGORY_SEPARATOR = 31;  //单元分隔符 US ␟
    public static final char LEAF_SEPARATOR = 30;      //记录分隔符 RS ␞
    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public MyMediaBrowserService getService() {
            return MyMediaBrowserService.this;
        }
    }

}
