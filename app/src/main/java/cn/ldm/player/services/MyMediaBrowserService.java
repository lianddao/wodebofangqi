package cn.ldm.player.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.service.media.MediaBrowserService;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import org.w3c.dom.ProcessingInstruction;

import java.util.ArrayList;
import java.util.List;

import cn.ldm.player.MainActivity;
import cn.ldm.player.R;
import cn.ldm.player.core.MusicMetadataDataSource;
import cn.ldm.player.core.MusicScanner;
import cn.ldm.player.datasource.MediaItemDataSource;
import cn.ldm.player.datasource.MediaMetadataDataSource;
import cn.ldm.player.loader.PlaylistLoader;
import cn.ldm.player.model.Playlist;
import cn.ldm.player.model.Song;
import cn.ldm.player.model.SongInfo;
import cn.ldm.player.player.MediaPlayerAdapter;
import cn.ldm.player.tool.MusicTool;


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
    public static final char CATEGORY_SEPARATOR = 31;  //单元分隔符 US ␟
    public static final char LEAF_SEPARATOR = 30;      //记录分隔符 RS ␞

    private static final float PLAYBACK_SPEED = 1.0f;


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
                _mediaSession.setQueue(formatToQueueItem(mediaItems));
                _mediaSession.setQueueTitle("根据 '__BY_TITLE__' 组织数据");
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
                    _mediaSession.setQueue(formatToQueueItem(mediaItems));
                }
                break;
        }

        result.sendResult(mediaItems);
    }
    //endregion

    private ArrayList<MediaSession.QueueItem> formatToQueueItem(List<MediaItem> items) {
        ArrayList<MediaSession.QueueItem> result = new ArrayList(items.size());
        for (MediaItem item : items) {
            result.add(new MediaSession.QueueItem(item.getDescription(), Long.valueOf(filterMediaId(item))));
        }
        return result;
    }

    private MediaNotificationManager _mediaNotificationManager;


    @Override
    public void onCreate() {
        super.onCreate();
        _mediaSession = new MediaSession(this, TAG);
        setSessionToken(_mediaSession.getSessionToken());
        _mediaPlayerAdapter = new MediaPlayerAdapter(this, _mediaSession);

        try {
            _mediaNotificationManager = new MediaNotificationManager(this);
        } catch (Exception ex) {
        }

        //region 统一行为:①播放器执行命令 ②更新状态
        _mediaSession.setCallback(new MediaSession.Callback() {
            @Override
            public void onPlayFromMediaId(String mediaId, Bundle extras) {
                SongInfo songInfo = MediaMetadataDataSource.queryById(getApplicationContext(), mediaId);
                _mediaPlayerAdapter.play(songInfo);
//                _mediaNotificationManager.startNotification();
                loadNotification();
            }

            @Override
            public void onPause() {
                _mediaPlayerAdapter.pause();
                loadNotification();
            }

            @Override
            public void onPlay() {
                _mediaPlayerAdapter.play();
                loadNotification();
            }

            @Override
            public void onSkipToNext() {
                _mediaPlayerAdapter.skipToNext();
                loadNotification();
            }

            @Override
            public void onSkipToPrevious() {
                Log.i(TAG, "onSkipToPrevious: ");
                _mediaPlayerAdapter.skipToPrevious();
                loadNotification();
            }

            @Override
            public void onSeekTo(long pos) {
                _mediaPlayerAdapter.seekTo((int) pos);
            }

            @Override
            public void onSkipToQueueItem(long id) {
                super.onSkipToQueueItem(id);
                Log.i(TAG, "onSkipToQueueItem: ");
            }
        });
    }

    private static final int REQUEST_CODE = 1;
    private static final String LAB_PAUSE = "暂停", LAB_PLAY = "播放", LAB_PREV = "上一曲", LAB_NEXT = "下一曲";

    public void loadNotification() {
        final Icon
                ICON_PAUSE = Icon.createWithResource(this, android.R.drawable.ic_media_pause),
                ICON_PLAY = Icon.createWithResource(this, android.R.drawable.ic_media_play),
                ICON_PREV = Icon.createWithResource(this, android.R.drawable.ic_media_previous),
                ICON_NEXT = Icon.createWithResource(this, android.R.drawable.ic_media_next);
        final PendingIntent
                PI_PAUSE = PendingIntent.getBroadcast(this, REQUEST_CODE, new Intent(LAB_PAUSE), PendingIntent.FLAG_CANCEL_CURRENT),
                PI_PLAY = PendingIntent.getBroadcast(this, REQUEST_CODE, new Intent(LAB_PLAY), PendingIntent.FLAG_CANCEL_CURRENT),
                PI_PREV = PendingIntent.getBroadcast(this, REQUEST_CODE, new Intent(LAB_PREV), PendingIntent.FLAG_CANCEL_CURRENT),
                PI_NEXT = PendingIntent.getBroadcast(this, REQUEST_CODE, new Intent(LAB_NEXT), PendingIntent.FLAG_CANCEL_CURRENT);
        final Notification.Action
                ACTION_PAUSE = new Notification.Action.Builder(ICON_PAUSE, LAB_PAUSE, PI_PAUSE).build(),
                ACTION_PLAY = new Notification.Action.Builder(ICON_PLAY, LAB_PLAY, PI_PLAY).build(),
                ACTION_PREV = new Notification.Action.Builder(ICON_PREV, LAB_PREV, PI_PREV).build(),
                ACTION_NEXT = new Notification.Action.Builder(ICON_NEXT, LAB_NEXT, PI_NEXT).build();

        Log.i(TAG, "loadNotification: ");
        MediaMetadata metadata = _mediaSession.getController().getMetadata();
        Notification.Builder builder = new Notification.Builder(this);
        String title = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE);
        String subtitle = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST)
                + " - " + metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
        Notification notification = builder
                .setContentTitle(title)
                .setContentText(subtitle)
                .setSmallIcon(android.R.drawable.ic_menu_directions)//通知栏顶部的图片
                .setLargeIcon(MusicScanner.getInstance(this).retrieveAlbumArt(metadata))//展开通知栏所展示的图片
                .setContentIntent(createContentIntent(metadata.getDescription()))
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .addAction(ACTION_PREV)
                .addAction(ACTION_PLAY)
                .addAction(ACTION_NEXT)
                .setStyle(new Notification.MediaStyle().setMediaSession(_mediaSession.getSessionToken()))
                .build();
        startForeground(1, notification);
    }


    private PendingIntent createContentIntent(MediaDescription description) {
        PendingIntent pendingIntent = _mediaSession.getController().getSessionActivity();
        return pendingIntent;
        //        Intent openUI = new Intent(this, MainActivity.class);
        //        openUI.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        //        return PendingIntent.getActivity(this, 1, openUI, PendingIntent.FLAG_CANCEL_CURRENT);
    }

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
