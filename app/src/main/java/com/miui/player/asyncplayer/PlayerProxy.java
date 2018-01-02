package com.miui.player.asyncplayer;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaFile;
import android.media.MediaFile.MediaFileType;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.util.Log;
import com.miui.player.ffmpeg.FFMPEGPlayer;
import com.miui.player.util.ServiceActions.In;
import com.miui.player.util.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class PlayerProxy {
    private static final int[] FFMPEG_SUPPORT_TYPES = new int[]{1001, 10, 6, 26};
    private static final String TAG = PlayerProxy.class.getName();
    private static final boolean USE_SYS_PLAER = true;
    private Set<String> mFFMPEGExcludeFilePathSet;
    private final FFMPEGPlayer mFFMPEGPlayer = FFMPEGPlayer.createFFMPEGPlayer(3, this.mMediaPlayer.getAudioSessionId());
    private final MediaPlayer mMediaPlayer = new MediaPlayer();
    private boolean mUsingSysPlayer = false;

    public void setFFMPEGExcludeFilePathSet(Set<String> set) {
        this.mFFMPEGExcludeFilePathSet = set;
    }

    public int getAudioSessionId() {
        return this.mMediaPlayer.getAudioSessionId();
    }

    public int getCurrentPosition() {
        return isUsingSysPlayer() ? this.mMediaPlayer.getCurrentPosition() : this.mFFMPEGPlayer.getCurrentPosition();
    }

    public boolean isPlaying() {
        return isUsingSysPlayer() ? this.mMediaPlayer.isPlaying() : this.mFFMPEGPlayer.isPlaying();
    }

    public int getDuration() {
        return isUsingSysPlayer() ? this.mMediaPlayer.getDuration() : this.mFFMPEGPlayer.getDuration();
    }

    public void setVolume(float leftVolume, float rightVolume) {
        this.mMediaPlayer.setVolume(leftVolume, rightVolume);
        if (this.mFFMPEGPlayer != null) {
            this.mFFMPEGPlayer.setVolume(leftVolume, rightVolume);
        }
    }

    public void setAudioStreamType(int streamType) {
        if (isUsingSysPlayer()) {
            this.mMediaPlayer.setAudioStreamType(streamType);
        } else {
            Log.w(TAG, "FFMPEGPlayer is always music stream type!");
        }
    }

    public void seekTo(int msec) {
        if (isUsingSysPlayer()) {
            this.mMediaPlayer.seekTo(msec);
        } else {
            this.mFFMPEGPlayer.seekTo(msec);
        }
    }

    public void setOnCompletionListener(OnCompletionListener l) {
        this.mMediaPlayer.setOnCompletionListener(l);
        if (this.mFFMPEGPlayer != null) {
            this.mFFMPEGPlayer.setOnCompletionListener(l);
        }
    }

    public void setOnErrorListener(OnErrorListener l) {
        this.mMediaPlayer.setOnErrorListener(l);
        if (this.mFFMPEGPlayer != null) {
            this.mFFMPEGPlayer.setOnErrorListener(l);
        }
    }

    public void setOnPreparedListener(OnPreparedListener l) {
        this.mMediaPlayer.setOnPreparedListener(l);
        if (this.mFFMPEGPlayer != null) {
            this.mFFMPEGPlayer.setOnPreparedListener(l);
        }
    }

    public void setDataSourceAndPrepare(Context context, Uri uri) throws IOException {
        Utils.debugLog(TAG, "setDataSourceAndPrepare");
        this.mUsingSysPlayer = true;
        IOException exp = tryMediaPlayer(context, uri, false);
        if (exp != null) {
            if (!(exp instanceof FileNotFoundException) && needTryFFMPEGPlayer(uri)) {
                exp = tryFFMPEGPlayer(context, uri);
                if (exp == null) {
                    this.mUsingSysPlayer = false;
                    return;
                }
            }
            throw exp;
        }
    }

    public void setDataSourceAndPrepareAsync(Context context, Uri uri) throws IOException {
        Utils.debugLog(TAG, "setDataSourceAndPrepare");
        this.mUsingSysPlayer = true;
        if (needTryFFMPEGPlayer(uri) && tryFFMPEGPlayer(context, uri) == null) {
            this.mUsingSysPlayer = false;
        } else if (tryMediaPlayer(context, uri, true) != null) {
            throw new IOException(TAG + " Failed to play with uri=" + uri);
        }
    }

    private boolean needTryFFMPEGPlayer(Uri uri) {
        if (this.mFFMPEGPlayer == null || "http".equalsIgnoreCase(uri.getScheme())) {
            return false;
        }
        if (!"file".equals(uri.getScheme())) {
            return true;
        }
        Set<String> set = this.mFFMPEGExcludeFilePathSet;
        if (set == null || !set.contains(uri.getPath())) {
            return true;
        }
        return false;
    }

    private IOException tryFFMPEGPlayer(Context context, Uri uri) {
        File f = translateToFile(context, uri);
        if (f == null) {
            return new FileNotFoundException("Failed to resolve uri=" + uri);
        }
        try {
            if (isFFMPEGSupported(f)) {
                this.mFFMPEGPlayer.setDataSource(f);
                this.mFFMPEGPlayer.prepare();
                Log.v(TAG, "use ffmpeg MediaPlayer");
                return null;
            }
            throw new IOException("Unsupported by FFMPEG, path=" + f.getAbsolutePath());
        } catch (IOException e) {
            return e;
        } catch (IllegalArgumentException e2) {
            return new IOException("IllegalArgument: " + e2.getMessage());
        }
    }

    private boolean isFFMPEGSupported(File file) {
        MediaFileType type = MediaFile.getFileType(file.getAbsolutePath());
        if (type == null) {
            return false;
        }
        int fileType = type.fileType;
        for (int t : FFMPEG_SUPPORT_TYPES) {
            if (t == fileType) {
                return true;
            }
        }
        return false;
    }

    private IOException tryMediaPlayer(Context context, Uri uri, boolean async) {
        try {
            this.mMediaPlayer.setDataSource(context, uri);
            if (async) {
                this.mMediaPlayer.prepareAsync();
            } else {
                this.mMediaPlayer.prepare();
            }
            Log.v(TAG, "use system MediaPlayer");
            return null;
        } catch (IOException e) {
            return e;
        }
    }

    private File translateToFile(Context context, Uri uri) {
        String path = null;
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equals("file")) {
            path = uri.getPath();
        } else {
            Cursor c = context.getContentResolver().query(uri, null, null, null, null);
            if (c != null) {
                try {
                    int idx = c.getColumnIndex("_data");
                    if (idx >= 0 && c.moveToFirst()) {
                        path = c.getString(idx);
                    }
                    c.close();
                } catch (Throwable th) {
                    c.close();
                }
            }
        }
        if (path == null) {
            return null;
        }
        File f = new File(path);
        if (f.isFile()) {
            return f;
        }
        return null;
    }

    public void start() {
        Utils.debugLog(TAG, "start");
        if (isUsingSysPlayer()) {
            this.mMediaPlayer.start();
        } else {
            this.mFFMPEGPlayer.start();
        }
    }

    public void pause() {
        if (isUsingSysPlayer()) {
            this.mMediaPlayer.pause();
        } else {
            this.mFFMPEGPlayer.pause();
        }
    }

    public void stop() {
        Utils.debugLog(TAG, In.CMDSTOP);
        if (isUsingSysPlayer()) {
            this.mMediaPlayer.stop();
        } else {
            this.mFFMPEGPlayer.stop();
        }
    }

    public void reset() {
        Utils.debugLog(TAG, "reset");
        this.mMediaPlayer.reset();
        if (this.mFFMPEGPlayer != null) {
            this.mFFMPEGPlayer.reset();
        }
    }

    public void release() {
        Utils.debugLog(TAG, "release");
        this.mMediaPlayer.release();
        if (this.mFFMPEGPlayer != null) {
            this.mFFMPEGPlayer.release();
        }
    }

    private boolean isUsingSysPlayer() {
        return this.mUsingSysPlayer || this.mFFMPEGPlayer == null;
    }

    public void setWakeMode(Context context, int mode) {
    }
}
