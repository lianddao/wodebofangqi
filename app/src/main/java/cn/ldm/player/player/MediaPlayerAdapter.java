package cn.ldm.player.player;

import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.MediaPlayer;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.util.Log;

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
                }
            });
            _mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Log.i(TAG, "onPrepared: 播放器准备就绪");
                }
            });
        }
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

    private void play() {
        _mediaPlayer.start();
        setNewState(PlaybackState.STATE_PLAYING, -1);
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

    public void play(MediaMetadata metadata) {
        try {
            metadata.getDescription().getMediaUri() 为空
            play(metadata.getString(MediaMetadata.METADATA_KEY_MEDIA_ID),
                 Uri.parse(metadata.getString(MediaMetadata.METADATA_KEY_ART_URI))   );
        } catch (Exception ex) {
        }
    }

    public void play(MediaBrowser.MediaItem mediaItem) {
        try {
            play(mediaItem.getMediaId(), mediaItem.getDescription().getMediaUri());
        } catch (Exception ex) {
            Log.e(TAG, "play: " + ex.toString());
        }
    }

    public void play(String mediaId, Uri data) throws Exception {
        if (isInitializing()) {
            Log.i(TAG, "play: 初始化");
        } else {
            if (isChanged(mediaId)) {
                Log.i(TAG, "play: 歌曲不同");
            } else {
                Log.i(TAG, "play: 歌曲相同");
                if (isPlaying()) {
                    _mediaPlayer.pause();
                    return;
                } else {
                    Log.i(TAG, "play: 判断当前的媒体状态,根据状态时暂停或停止等做处理");
                    _mediaPlayer.start();
                    return;
                }
            }
        }
        _currentMediaId = mediaId;
        initializeMediaPlayer();
        if (_mediaPlayer.isPlaying()) {
            _mediaPlayer.reset();
        }
        _mediaPlayer.setDataSource(data.toString());
        _mediaPlayer.prepare();
        play();
    }

    public static String _filterMediaId(String mediaId) {
        String[] split = mediaId.split(String.valueOf(LEAF_SEPARATOR));
        if (split.length == 2) return mediaId.split(String.valueOf(LEAF_SEPARATOR))[1];
        return mediaId.split(String.valueOf(LEAF_SEPARATOR))[2];
    }

}
