package cn.ldm.player.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.MediaPlayer;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.util.Log;

import java.util.List;

import cn.ldm.player.datasource.MediaMetadataDataSource;
import cn.ldm.player.model.SongInfo;

import static android.media.session.PlaybackState.STATE_PAUSED;
import static android.media.session.PlaybackState.STATE_PLAYING;
import static android.media.session.PlaybackState.STATE_STOPPED;
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

    public static final float PLAYBACK_SPEED = 1.0f;
    private static final PlaybackState.Builder _playbackStateBuilder = new PlaybackState.Builder();

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
                    _mediaSession.getController().getTransportControls().rewind();
                    skipToNext();
                    //                    _mediaSession.setPlaybackState(_builder.setState(PlaybackState.STATE_STOPPED, -1, PLAYBACK_SPEED).build());

                }
            });
            _mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Log.i(TAG, "onPrepared: 播放器准备就绪");
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

    private void setNewState(int playbackState, int position) {
        _mediaSession.setPlaybackState(new PlaybackState.Builder().setState(playbackState, position, 1.0f).build());
        switch (playbackState) {
            case STATE_PLAYING:
                break;
            case STATE_PAUSED:
                break;
            case STATE_STOPPED:
                break;
        }
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
                    setNewState(PlaybackState.STATE_PAUSED, _mediaPlayer.getCurrentPosition());
                    return;
                } else {
                    Log.i(TAG, "play: 判断当前的媒体状态,根据状态时暂停或停止等做处理");
                    _mediaPlayer.start();
                    setNewState(PlaybackState.STATE_PLAYING, _mediaPlayer.getCurrentPosition());
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
                _playbackStateBuilder
                        .setState(PlaybackState.STATE_PLAYING, -1, PLAYBACK_SPEED)
                        .setActiveQueueItemId((Long.valueOf(_currentMediaId)))
                        .build()
        );
        //        setNewState(PlaybackState.STATE_PLAYING, -1);
    }

    public void play(MediaSession.QueueItem queueItem) {
        initializeMediaPlayer();
        try {
            _mediaPlayer.setDataSource(queueItem.getDescription().getMediaUri().toString());
            _mediaPlayer.prepare();
        } catch (Exception ex) {
        }
        _mediaPlayer.start();
        _mediaSession.setMetadata(MediaMetadataDataSource.queryById(_context, queueItem.getQueueId()).getMediaMetadata());
        _mediaSession.setPlaybackState(_playbackStateBuilder
                .setState(PlaybackState.STATE_PLAYING, getCurrentPosition(), PLAYBACK_SPEED)
                .setActiveQueueItemId(queueItem.getQueueId())
                .build()
        );
    }


    public void pause() {
        _mediaPlayer.pause();
        _mediaSession.setPlaybackState(_playbackStateBuilder
                .setState(PlaybackState.STATE_PAUSED, getCurrentPosition(), PLAYBACK_SPEED)
                .build()
        );
    }

    public void play() {
        _mediaPlayer.start();
        _mediaSession.setPlaybackState(_playbackStateBuilder
                .setState(PlaybackState.STATE_PLAYING, _mediaSession.getController().getPlaybackState().getPosition(), 1.0f)
                .build()
        );
    }

    public void seekTo(int progress) {
        _mediaPlayer.seekTo(progress);
        _mediaSession.setPlaybackState(_playbackStateBuilder
                .setState(PlaybackState.STATE_PLAYING, getCurrentPosition(), 1.0f)
                .build()
        );
    }

    public void skipToNext() {
        int nextIndex = -1;
        List<MediaSession.QueueItem> queueItems = _mediaSession.getController().getQueue();
        long id = _mediaSession.getController().getPlaybackState().getActiveQueueItemId();
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
        play(queueItem);
    }

    public int getCurrentPosition() {
        return _mediaPlayer.getCurrentPosition();
    }

    public static String _filterMediaId(String mediaId) {
        String[] split = mediaId.split(String.valueOf(LEAF_SEPARATOR));
        if (split.length == 2) return mediaId.split(String.valueOf(LEAF_SEPARATOR))[1];
        return mediaId.split(String.valueOf(LEAF_SEPARATOR))[2];
    }

}
