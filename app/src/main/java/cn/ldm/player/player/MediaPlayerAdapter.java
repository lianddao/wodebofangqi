package cn.ldm.player.player;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.util.Log;

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

    private static final float PLAYBACK_SPEED = 1.0f;
    private PlaybackState.Builder _builder = new PlaybackState.Builder();

    public MediaPlayerAdapter(MediaSession mediaSession) {
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
                    _mediaSession.setPlaybackState(_builder.setState(
                            PlaybackState.STATE_STOPPED,
                            -1,
                            PLAYBACK_SPEED).build());
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
        setNewState(PlaybackState.STATE_PLAYING, -1);
    }

    public void pause() {
        _mediaPlayer.pause();
    }

    public void play() {
        _mediaPlayer.start();
    }

    public void seekTo(int progress) {
        _mediaPlayer.seekTo(progress);
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
