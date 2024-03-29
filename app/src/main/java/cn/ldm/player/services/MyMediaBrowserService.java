package cn.ldm.player.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
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

import cn.ldm.player.R;
import cn.ldm.player.activities.PlayingActivity;
import cn.ldm.player.core.MusicMetadataDataSource;
import cn.ldm.player.core.MusicScanner;
import cn.ldm.player.datasource.MediaItemDataSource;
import cn.ldm.player.loader.PlaylistLoader;
import cn.ldm.player.model.Playlist;
import cn.ldm.player.model.Song;
import cn.ldm.player.player.MediaPlayerAdapter;


/**
 * 我的媒体浏览服务
 */
public class MyMediaBrowserService extends MediaBrowserService {

    private static MyMediaBrowserService instance;

    public static MyMediaBrowserService getRunningInstance() {
        if (instance == null) {
            throw new RuntimeException("服务尚未创建");
        }
        return instance;
    }

    //能正确返回 '网络歌曲' 的持续时间长度
    public int getDuration() {
        return _mediaPlayerAdapter.getDuration();
    }

    public MediaSession getSession() {
        return instance._session;
    }

    public void setCurrentMediaMetadata(MediaMetadata mediaMetadata, int playbackState) {
        _session.setMetadata(mediaMetadata);
        switch (playbackState) {
            case PlaybackState.STATE_BUFFERING:
                //                _playbackStateBuilder.setState(playbackState,-1,PLAYBACK_SPEED)
                //                        .setActions(ACTION)
                break;
        }
    }

    public MediaMetadata getCurrentMediaMetadata() {
        return _session.getController().getMetadata();
    }

    public MyMediaBrowserService() {
    }


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

    private MediaSession _session;

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
                //                _session.setQueue(formatToQueueItem(mediaItems));
                //                _session.setQueueTitle("根据 '__BY_TITLE__' 组织数据");
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
        _session.setQueue(formatToQueueItem(mediaItems));
        result.sendResult(mediaItems);
    }
    //endregion

    private ArrayList<MediaSession.QueueItem> formatToQueueItem(List<MediaItem> items) {
        ArrayList<MediaSession.QueueItem> result = new ArrayList(items.size());
        for (MediaItem item : items) {
            if (item.isPlayable()) {
                result.add(new MediaSession.QueueItem(item.getDescription(), Long.valueOf(filterMediaId(item))));
            }
        }
        return result;
    }

    private MediaNotificationManager _mediaNotificationManager;

    private MyNotificationManager _myNotificationManager;

    private static final PlaybackState.Builder _playbackStateBuilder = new PlaybackState.Builder();


    /**
     * 设置当前哪些音乐在会话中.(告知整个框架的各方，目前有哪些音乐可以播放)
     *
     * @param queueItems
     * @return
     */
    public List<MediaSession.QueueItem> setQueue(List<MediaSession.QueueItem> queueItems) {
        if (_session.getController().getQueue() == null) {
            Log.i(TAG, "setQueue: 一开始队列为 null");
        }
        _session.setQueue(queueItems);
        return _session.getController().getQueue();
    }

    public List<MediaSession.QueueItem> addToQueue(List<MediaSession.QueueItem> queueItems) {
        _session.getController().getQueue().addAll(queueItems);
        Log.i(TAG, "addToQueue: 检测是否可以触发 onQueueChanged");
        return _session.getController().getQueue();
    }

    public void clearQueue() {
        _session.getController().getQueue().clear();
        //        _session.setQueue(null);
    }

    private MediaSession.Callback myMediaSessionCallback = new MediaSession.Callback() {
        @Override
        public void onPlayFromMediaId(String mediaId, Bundle extras) {
            Log.i(TAG, "onPlayFromMediaId: 本地播放" + mediaId);
            _mediaPlayerAdapter.local_play(mediaId);
            buildNotification();
        }

        @Override
        public void onPause() {
            _mediaPlayerAdapter.pause();
            buildNotification();
        }

        @Override
        public void onPlay() {
            _mediaPlayerAdapter.play();
            buildNotification();
        }

        @Override
        public void onSkipToNext() {
            _mediaPlayerAdapter.skipToNext();
            buildNotification();
        }

        @Override
        public void onSkipToPrevious() {
            _mediaPlayerAdapter.skipToPrevious();
            buildNotification();
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

        //        @Override
        //        public void onPrepareFromUri(Uri uri, Bundle extras) {
        //            super.onPrepareFromUri(uri, extras);
        //            Log.i(TAG, "onPrepareFromUri: ");
        //        }

        @Override
        public void onPlayFromUri(Uri uri, Bundle extras) {
            _mediaPlayerAdapter.playFromUri(uri, extras);
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        //region 设置 MediaSession 字段
        _session = new MediaSession(this, TAG);
        _session.setFlags(MediaSession.FLAG_HANDLES_MEDIA_BUTTONS | MediaSession.FLAG_HANDLES_TRANSPORT_CONTROLS);
        Intent intent = new Intent(this, PlayingActivity.class);
        intent.putExtra("token", _session.getSessionToken());
        _session.setSessionActivity(PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT));
        _session.getController().registerCallback(new MediaController.Callback() {
            @Override
            public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                super.onMetadataChanged(metadata);
                buildNotification();
            }
        });
        _session.setCallback(myMediaSessionCallback);
        //endregion

        setSessionToken(_session.getSessionToken());
        _mediaPlayerAdapter = new MediaPlayerAdapter(this, _session);

        try {
            _mediaNotificationManager = new MediaNotificationManager(this);
            _myNotificationManager = new MyNotificationManager();
            IntentFilter filter = new IntentFilter();
            filter.addAction(PAUSE);
            filter.addAction(PLAY);
            filter.addAction(PREV);
            filter.addAction(NEXT);
            MyMediaBrowserService.this.registerReceiver(_myNotificationManager, filter);
        } catch (Exception ex) {
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
        if (_session.isActive()){
            Log.i(TAG, "onDestroy: 会话在后台活动");
        }else {
            unregisterReceiver(_myNotificationManager);
        }
    }

    private static final int REQUEST_CODE = 1;
    private static final String PAUSE = "暂停", PLAY = "播放", PREV = "上一曲", NEXT = "下一曲";

    private void buildNotification() {

        final Icon
                ICON_PAUSE = Icon.createWithResource(this, android.R.drawable.ic_media_pause),
                ICON_PLAY = Icon.createWithResource(this, android.R.drawable.ic_media_play),
                ICON_PREV = Icon.createWithResource(this, android.R.drawable.ic_media_previous),
                ICON_NEXT = Icon.createWithResource(this, android.R.drawable.ic_media_next);
        final Intent
                INTENT_PAUSE = new Intent(PAUSE).setPackage(this.getPackageName()),
                INTENT_PLAY = new Intent(PLAY).setPackage(this.getPackageName()),
                INTENT_PREV = new Intent(PREV).setPackage(this.getPackageName()),
                INTENT_NEXT = new Intent(NEXT).setPackage(this.getPackageName());
        final PendingIntent
                PI_PAUSE = PendingIntent.getBroadcast(this, REQUEST_CODE, INTENT_PAUSE, PendingIntent.FLAG_CANCEL_CURRENT),
                PI_PLAY = PendingIntent.getBroadcast(this, REQUEST_CODE, INTENT_PLAY, PendingIntent.FLAG_CANCEL_CURRENT),
                PI_PREV = PendingIntent.getBroadcast(this, REQUEST_CODE, INTENT_PREV, PendingIntent.FLAG_CANCEL_CURRENT),
                PI_NEXT = PendingIntent.getBroadcast(this, REQUEST_CODE, INTENT_NEXT, PendingIntent.FLAG_CANCEL_CURRENT);
        final Notification.Action
                ACTION_PAUSE = new Notification.Action.Builder(ICON_PAUSE, PAUSE, PI_PAUSE).build(),
                ACTION_PLAY = new Notification.Action.Builder(ICON_PLAY, PLAY, PI_PLAY).build(),
                ACTION_PREV = new Notification.Action.Builder(ICON_PREV, PREV, PI_PREV).build(),
                ACTION_NEXT = new Notification.Action.Builder(ICON_NEXT, NEXT, PI_NEXT).build();

        MediaMetadata metadata = _session.getController().getMetadata();
        Notification.Builder builder = new Notification.Builder(this);
        String title = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE);
        String subtitle = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST)
                + " - " + metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);

        Notification.Action actionPlayOrPause;
        boolean isPlaying;
        if (_session.getController().getPlaybackState().getState() == PlaybackState.STATE_PLAYING) {
            actionPlayOrPause = ACTION_PAUSE;
            isPlaying = true;
        } else {
            actionPlayOrPause = ACTION_PLAY;
            isPlaying = false;
        }


        Log.i(TAG, "buildNotification: 新建一个通知");

        Bitmap bitmap;
        try {
            bitmap = MusicScanner.getInstance(this).retrieveAlbumArt(metadata);
        } catch (Exception ex) {
            Log.i(TAG, "buildNotification: " + ex.toString());
            bitmap=metadata.getBitmap(MediaMetadata.METADATA_KEY_ART);
            if (bitmap==null){
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.offline);
            }
        }

        Notification notification = builder
                .setContentTitle(title)
                .setContentText(subtitle)
                .setSmallIcon(android.R.drawable.ic_menu_directions)//通知栏顶部的图片
                .setLargeIcon(bitmap)//展开通知栏所展示的图片
                .setContentIntent(createContentIntent(metadata.getDescription()))
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .addAction(ACTION_PREV)
                .addAction(actionPlayOrPause)
                .addAction(ACTION_NEXT)
                .setWhen(System.currentTimeMillis() - _session.getController().getPlaybackState().getPosition())
                .setShowWhen(isPlaying)
                .setUsesChronometer(true)
                .setStyle(new Notification.MediaStyle().setMediaSession(_session.getSessionToken()))
                .build();
        startForeground(1, notification);
    }

    //私有的广播管理器,集中处理通知栏操作
    private class MyNotificationManager extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case PAUSE:
                    Log.i(TAG, "onReceive: 暂停");
                    _session.getController().getTransportControls().pause();
                    break;
                case PLAY:
                    Log.i(TAG, "onReceive: 播放");
                    _session.getController().getTransportControls().play();
                    break;
                case PREV:
                    Log.i(TAG, "onReceive: 上一曲");
                    _session.getController().getTransportControls().skipToPrevious();
                    break;
                case NEXT:
                    Log.i(TAG, "onReceive: 下一曲");
                    _session.getController().getTransportControls().skipToNext();
                    break;
                default:
                    Log.i(TAG, "onReceive: 意图无效");
                    break;
            }
        }
    }


    private PendingIntent createContentIntent(MediaDescription description) {
        PendingIntent pendingIntent = _session.getController().getSessionActivity();
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
