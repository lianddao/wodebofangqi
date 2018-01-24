package cn.ldm.player.services;

import android.app.Notification;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaController;
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

import cn.ldm.player.core.MusicMetadataDataSource;
import cn.ldm.player.core.MusicScanner;
import cn.ldm.player.datasource.MediaItemDataSource;
import cn.ldm.player.datasource.MediaMetadataDataSource;
import cn.ldm.player.loader.PlaylistLoader;
import cn.ldm.player.model.Playlist;
import cn.ldm.player.model.Song;
import cn.ldm.player.player.MediaPlayerAdapter;


/**
 * 我的媒体浏览服务
 */
public class MyMediaBrowserService extends MediaBrowserService {

    private static final String TAG = MyMediaBrowserService.class.getSimpleName();
    private static final String MEDIA_ID_ROOT = "__ROOT__";
    private static final String MEDIA_ID_MUSIC_BY_TITLE = "__BY_TITLE__";
    private static final String MEDIA_ID_MUSIC_BY_ARTIST = "__BY_ARTIST__";
    private static final String MEDIA_ID_MUSIC_BY_ALBUM = "__BY_ALBUM__";
    private static final String MEDIA_ID_MUSIC_BY_PLAYLIST = "__BY_PLAYLIST__";

    private MediaPlayerAdapter _mediaPlayerAdapter;

    private MediaSession _mediaSession;

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
                Log.i(TAG, "根据 '__ROOT__' 组织数据");
                mediaItems.addAll(MediaItemDataSource.getByRootFlag());
                break;
            case MEDIA_ID_MUSIC_BY_TITLE:
                Log.i(TAG, "根据 '__BY_TITLE__' 组织数据");
                mediaItems.addAll(MediaItemDataSource.getSongsByTitleFlag(this));
                break;
            case MEDIA_ID_MUSIC_BY_ALBUM:
                Log.i(TAG, "根据 '__BY_ALBUM__' 组织数据");
                mediaItems.addAll(MediaItemDataSource.getByAlbumFlag(this));
                break;
            case MEDIA_ID_MUSIC_BY_ARTIST:
                Log.i(TAG, "根据 '__BY_ARTIST__' 组织数据");
                mediaItems.addAll(MediaItemDataSource.getByArtistFlag(this));
                break;
            case MEDIA_ID_MUSIC_BY_PLAYLIST:
                //region ..
                Log.i(TAG, "根据 '__BY_PLAYLIST__' 组织数据");
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
                        Log.i(TAG, "根据 '__BY_ALBUM__专辑名称' 组织数据");
                        String album = parentId.split(String.valueOf(CATEGORY_SEPARATOR))[1];
                        mediaItems.addAll(MediaItemDataSource.getByAlbum(this, album));
                    } else if (parentId.startsWith(MEDIA_ID_MUSIC_BY_ARTIST)) {
                        Log.i(TAG, "根据 '__BY_ARTIST__歌手名称' 组织数据");
                        String artist = parentId.split(String.valueOf(CATEGORY_SEPARATOR))[1];
                        mediaItems.addAll(MediaItemDataSource.getAlbumsByArtist(this, artist));
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
                                            .setMediaUri(song.mData)
                                            .setTitle(song.mSongName)
                                            .build(),
                                    MediaItem.FLAG_PLAYABLE
                            );
                            mediaItems.add(item);
                        }
                        //endregion
                    }
                } else {
                    Log.i(TAG, "根据 '__BY_ARTIST__歌手名称_专辑名称' 组织数据");
                    String[] split = parentId.split(String.valueOf(LEAF_SEPARATOR))[0].split(String.valueOf(CATEGORY_SEPARATOR));
                    mediaItems.addAll(MediaItemDataSource.getSongsByAlbumForArtist(this, split[1], split[2]));
                }
                break;
        }

        result.sendResult(mediaItems);
    }
    //endregion


    @Override
    public void onCreate() {
        super.onCreate();
        _mediaSession = new MediaSession(this, TAG);
        setSessionToken(_mediaSession.getSessionToken());
        _mediaPlayerAdapter = new MediaPlayerAdapter(_mediaSession);
        _mediaSession.setCallback(new MediaSession.Callback() {
            private List<MediaSession.QueueItem> mPlaylist = new ArrayList<>();
            private int mQueueIndex = -1;
            private MediaMetadata mPreparedMedia;

            @Override
            public void onSeekTo(long pos) {
                //                mMediaPlayer.seekTo((int)pos);
            }

            @Override
            public void onPrepareFromMediaId(String mediaId, Bundle extras) {
                super.onPrepareFromMediaId(mediaId, extras);
                Log.i(TAG, "onPrepareFromMediaId: ");
            }

            @Override
            public void onPrepare() {
                super.onPrepare();
                Log.i(TAG, "onPrepare: ");
            }

            @Override
            public void onPause() {
                super.onPause();
            }

            @Override
            public void onStop() {
                super.onStop();
            }

            @Override
            public void onPlayFromUri(Uri uri, Bundle extras) {
                super.onPlayFromUri(uri, extras);
            }

            @Override
            public void onPlayFromMediaId(String mediaId, Bundle extras) {
                MediaMetadata metadata = MediaMetadataDataSource.queryById(getApplicationContext(), mediaId).getMediaMetadata();
                Log.i(TAG, "onPlayFromMediaId: " + metadata.getDescription().getTitle());
                _mediaSession.setActive(true);
                _mediaSession.setMetadata(metadata);
                _mediaPlayerAdapter.play(metadata);
                loadNotification();
            }
        });
    }

    public void loadNotification() {
        Log.i(TAG, "loadNotification: ");
        MediaController controller = _mediaSession.getController();
        MediaMetadata metadata = controller.getMetadata();
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        String title = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE);
        String subtitle = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST) + " - "
                + metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
        builder.setContentTitle(title)
                .setContentText(subtitle)
                .setSmallIcon(android.R.drawable.ic_media_play)//通知栏顶部的图片
                .setLargeIcon(MusicScanner.getInstance(this).retrieveAlbumArt(metadata))//展开通知栏所展示的图片
                .setContentIntent(controller.getSessionActivity())
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setStyle(new Notification.MediaStyle().setMediaSession(_mediaSession.getSessionToken()));

        MyMediaBrowserService.this.startForeground(1, builder.build());
    }

    public static final char CATEGORY_SEPARATOR = 31;  //单元分隔符 US ␟
    public static final char LEAF_SEPARATOR = 30;      //记录分隔符 RS ␞
    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public MyMediaBrowserService getService() {
            return MyMediaBrowserService.this;
        }
    }

    public static String filterMediaId(String mediaId) {
        String[] split = mediaId.split(String.valueOf(LEAF_SEPARATOR));
        if (split.length == 2) return mediaId.split(String.valueOf(LEAF_SEPARATOR))[1];
        return mediaId.split(String.valueOf(LEAF_SEPARATOR))[2];
    }

    public static String filterMediaId(MediaItem mediaItem) {
        return filterMediaId(mediaItem.getMediaId());
    }

}
