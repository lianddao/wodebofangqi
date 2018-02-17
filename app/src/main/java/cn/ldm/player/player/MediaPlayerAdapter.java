package cn.ldm.player.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.MediaPlayer;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import cn.ldm.player.core.maicong.KuGou;
import cn.ldm.player.datasource.MediaMetadataDataSource;
import cn.ldm.player.model.SongInfo;
import cn.ldm.player.services.MyMediaBrowserService;
import cn.ldm.player.tool.MusicTool;

import static cn.ldm.player.services.MyMediaBrowserService.LEAF_SEPARATOR;

/**
 * 媒体播放适配器
 */

public class MediaPlayerAdapter {
    private static final String TAG = MediaPlayerAdapter.class.getSimpleName();
    private MediaSession _mediaSession;
    private MediaPlayer _mediaPlayer;
    private String _currentMediaId = "";
    private Context _context;

    public void setCurrentMediaMetadata(MediaMetadata metadata) {
        _mediaSession.setMetadata(metadata);
    }


    public static final float PLAYBACK_SPEED = 1.0f;
    private static final PlaybackState.Builder _playbackStateBuilder = new PlaybackState.Builder();
    public boolean isLocalPlay = false;

    public int getDuration() {
        return _mediaPlayer.getDuration();
    }

    public MediaPlayerAdapter(Context context, MediaSession mediaSession) {
        _context = context;
        _mediaSession = mediaSession;
        Log.i(TAG, "MediaPlayerAdapter: 初始的媒体id为" + _currentMediaId);
    }

    private void initializeMediaPlayer() {
        if (_mediaPlayer == null) {
            _mediaPlayer = new MediaPlayer();
            _mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            _mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Log.i(TAG, "onCompletion: 播放结束");
                    //                    MediaMetadata next = _mediaSession.getController().getMetadata();
                    //                    _mediaSession.setPlaybackState(
                    //                            _playbackStateBuilder.setState(PlaybackState.STATE_SKIPPING_TO_NEXT, -1, PLAYBACK_SPEED).build()
                    //                    );
                    skipToNext();
                }
            });

            _mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    _mediaSession.setPlaybackState(
                            _playbackStateBuilder.setState(PlaybackState.STATE_PLAYING, -1, PLAYBACK_SPEED).build()
                    );
                    Log.i(TAG, "网络歌曲就绪,它的持续时间 =  " + MusicTool.getDisplayTime(_mediaPlayer.getDuration()));
                }
            });
        }
        _mediaPlayer.reset();
    }

    private boolean isPlaying() {
        return _mediaPlayer != null && _mediaPlayer.isPlaying();
    }

    private boolean isInitializing() {
        return _currentMediaId.length() == 0;
    }

    private boolean isChanged(String mediaId) {
        Log.i(TAG, "isChanged: " + "旧id = " + _currentMediaId + ", 新id = " + mediaId);
        return _currentMediaId.length() > 0 && !_currentMediaId.equals(mediaId);
    }

    public void local_play(String mediaId) {
        isLocalPlay = true;
        if (isInitializing()) {
            Log.i(TAG, "play: 初始化");
            initializeMediaPlayer();
        } else {
            if (isChanged(mediaId)) {
                Log.i(TAG, "play: 歌曲不同");
            } else {
                //region 歌曲相同
                Log.i(TAG, "play: 歌曲相同");
                if (isPlaying()) {
                    _mediaPlayer.pause();
                    _mediaSession.setPlaybackState(
                            _playbackStateBuilder.setState(PlaybackState.STATE_PAUSED, _mediaPlayer.getCurrentPosition(), PLAYBACK_SPEED)
                                    .build()
                    );
                    return;
                } else {
                    Log.i(TAG, "play: 判断当前的媒体状态,根据状态时暂停或停止等做处理");
                    _mediaPlayer.start();
                    _mediaSession.setPlaybackState(
                            _playbackStateBuilder.setState(PlaybackState.STATE_PLAYING, _mediaPlayer.getCurrentPosition(), PLAYBACK_SPEED)
                                    .build()
                    );
                    return;
                }
                //endregion
            }
        }
        _currentMediaId = mediaId;
        MediaMetadata metadata = MediaMetadataDataSource.getById(_context, mediaId);
        try {
            _mediaPlayer.setDataSource(metadata.getString(MediaMetadata.METADATA_KEY_ART_URI));
            _mediaPlayer.prepare();
        } catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
        _mediaPlayer.start();
        _mediaSession.setActive(true);
        _mediaSession.setMetadata(metadata);
        _mediaSession.setPlaybackState(
                _playbackStateBuilder.setState(PlaybackState.STATE_PLAYING, -1, PLAYBACK_SPEED)
                        .setActiveQueueItemId((Long.valueOf(_currentMediaId)))
                        .build()
        );
    }

    public void play(SongInfo songInfo) {
        if (isInitializing()) {
            Log.i(TAG, "play: 初始化");
        } else {
            if (isChanged(songInfo.getId())) {
                Log.i(TAG, "play: 歌曲不同");
            } else {
                Log.i(TAG, "play: 歌曲相同");
                if (isPlaying()) {
                    _mediaPlayer.pause();
                    _mediaSession.setPlaybackState(
                            _playbackStateBuilder.setState(PlaybackState.STATE_PAUSED, _mediaPlayer.getCurrentPosition(), PLAYBACK_SPEED)
                                    .build()
                    );
                    return;
                } else {
                    Log.i(TAG, "play: 判断当前的媒体状态,根据状态时暂停或停止等做处理");
                    _mediaPlayer.start();
                    _mediaSession.setPlaybackState(
                            _playbackStateBuilder.setState(PlaybackState.STATE_PLAYING, _mediaPlayer.getCurrentPosition(), PLAYBACK_SPEED)
                                    .build()
                    );
                    return;
                }
            }
        }
        _currentMediaId = songInfo.getId();
        initializeMediaPlayer();
        try {
            _mediaPlayer.setDataSource(songInfo.getUri().toString());
            _mediaPlayer.prepare();
        } catch (Exception ex) {
            Log.i(TAG, "play: " + ex.toString());
        }
        _mediaPlayer.start();
        _mediaSession.setActive(true);
        _mediaSession.setMetadata(songInfo.getMediaMetadata());
        _mediaSession.setPlaybackState(
                _playbackStateBuilder.setState(PlaybackState.STATE_PLAYING, -1, PLAYBACK_SPEED)
                        .setActiveQueueItemId((Long.valueOf(_currentMediaId)))
                        .build()
        );
        //        setNewState(PlaybackState.STATE_PLAYING, -1);
    }

    public void local_play(MediaSession.QueueItem queueItem) {
        initializeMediaPlayer();
        local_play(String.valueOf(queueItem.getQueueId()));
    }

    public void web_play(final MediaSession.QueueItem queueItem) {
        isLocalPlay = false;
        Future<MediaMetadata> future = Executors.newCachedThreadPool().submit(new Callable<MediaMetadata>() {
            @Override
            public MediaMetadata call() throws Exception {
                return KuGou.getSongInfo(_context, queueItem);
            }
        });
        try {
            MediaMetadata metadata = future.get();
            MyMediaBrowserService.getRunningInstance().setCurrentMediaMetadata(metadata, PlaybackState.STATE_BUFFERING);
            _mediaSession.setPlaybackState(
                    _playbackStateBuilder.setState(PlaybackState.STATE_BUFFERING, -1, 1.0f).build());
            _mediaPlayer.reset();
            _mediaPlayer.setDataSource(metadata.getString("URL"));
            _mediaPlayer.prepare();
//            _mediaPlayer.start();
//            _mediaSession.setPlaybackState(
//                    _playbackStateBuilder.setState(PlaybackState.STATE_PLAYING, -1, PLAYBACK_SPEED).build()
//            );
//            Log.i(TAG, "网络歌曲就绪,它的持续时间 =  " + MusicTool.getDisplayTime(_mediaPlayer.getDuration()));
        } catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    public void play(final MediaSession.QueueItem queueItem) {
        initializeMediaPlayer();
        try {
            Log.i(TAG, "play: " + queueItem.getDescription().getMediaUri());
            if (false) {
                _mediaPlayer.setDataSource(queueItem.getDescription().getMediaUri().toString());
                _mediaPlayer.prepare();
                _mediaSession.setMetadata(MediaMetadataDataSource.queryById(_context, queueItem.getQueueId()).getMediaMetadata());
                _mediaPlayer.start();
            } else {
                new KuGou().getSongById(queueItem, new KuGou.Callback() {
                    @Override
                    public void onPostExecute(Object result) {
                        try {
                            Log.i(TAG, "onPostExecute: " + result.toString());
                            String json = result.toString();
                            MediaMetadata metadata = KuGou.resolve(_context, json).getMediaMetadata();
                            MyMediaBrowserService.getRunningInstance().setCurrentMediaMetadata(metadata, PlaybackState.STATE_BUFFERING);
                            _mediaSession.setMetadata(metadata);
                            _mediaPlayer.setDataSource(metadata.getDescription().getMediaUri().toString());
                            _mediaPlayer.prepareAsync();
                        } catch (Exception ex) {
                        }
                    }
                });
            }
        } catch (Exception ex) {
        }


        Log.i(TAG, "play: 播放");
        _mediaSession.setPlaybackState(
                _playbackStateBuilder.setState(PlaybackState.STATE_PLAYING, _mediaPlayer.getCurrentPosition(), PLAYBACK_SPEED)
                        .setActiveQueueItemId(queueItem.getQueueId())
                        .build()
        );
    }


    public void pause() {
        _mediaPlayer.pause();
        Log.i(TAG, "pause: " + MusicTool.getDisplayTime(_mediaPlayer.getCurrentPosition()));
        _mediaSession.setPlaybackState(
                _playbackStateBuilder.setState(PlaybackState.STATE_PAUSED, _mediaPlayer.getCurrentPosition(), PLAYBACK_SPEED).build()
        );
    }

    public void play() {
        _mediaPlayer.start();
        _mediaSession.setPlaybackState(
                _playbackStateBuilder.setState(PlaybackState.STATE_PLAYING, _mediaPlayer.getCurrentPosition(), 1.0f).build()
        );
    }

    public void seekTo(int progress) {
        _mediaPlayer.seekTo(progress);
        _mediaSession.setPlaybackState(
                _playbackStateBuilder.setState(PlaybackState.STATE_PLAYING, _mediaPlayer.getCurrentPosition(), 1.0f).build()
        );
    }


    public void skipToNext() {
        int nextIndex = -1;
        List<MediaSession.QueueItem> queueItems = _mediaSession.getController().getQueue();
        long id = Long.valueOf(_mediaSession.getController().getMetadata().getDescription().getMediaId());
        for (MediaSession.QueueItem item : queueItems) {
            if (item.getQueueId() == id) {
                nextIndex = queueItems.indexOf(item) + 1;
                break;
            }
        }
        if (nextIndex > queueItems.size() - 1) {
            nextIndex = 0;
        }
        MediaSession.QueueItem queueItem = queueItems.get(nextIndex);

        if (isLocalPlay) {
            Log.i(TAG, "skipToNext: 本地下一曲");
            local_play(queueItem);
        } else {
            Log.i(TAG, "skipToNext: 网络下一曲");
            web_play(queueItem);
        }
    }

    public void skipToPrevious() {
        int prevIndex = -1;
        List<MediaSession.QueueItem> queueItems = _mediaSession.getController().getQueue();
        long id = _mediaSession.getController().getPlaybackState().getActiveQueueItemId();
        for (MediaSession.QueueItem item : queueItems) {
            if (item.getQueueId() == id) {
                prevIndex = queueItems.indexOf(item) - 1;
                break;
            }
        }
        if (prevIndex < 0) {
            prevIndex = queueItems.size() - 1;
        }
        MediaSession.QueueItem queueItem = queueItems.get(prevIndex);
        play(queueItem);
    }

    public void playFromUri(Uri uri, Bundle extras) {
        initializeMediaPlayer();
        try {
            _mediaPlayer.setDataSource(_context, uri);
            _mediaPlayer.prepareAsync();
        } catch (Exception ex) {
        }
    }

    public static String _filterMediaId(String mediaId) {
        String[] split = mediaId.split(String.valueOf(LEAF_SEPARATOR));
        if (split.length == 2) return mediaId.split(String.valueOf(LEAF_SEPARATOR))[1];
        return mediaId.split(String.valueOf(LEAF_SEPARATOR))[2];
    }


}
