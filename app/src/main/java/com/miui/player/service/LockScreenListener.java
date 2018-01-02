package com.miui.player.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.miui.player.PlayerActions.In;
import com.miui.player.PlayerActions.Out;
import com.miui.player.meta.AlbumManager;
import com.miui.player.util.FileOperations;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.ServiceActions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LockScreenListener {
    private final LockScreenReceiver mLockScreenListener = new LockScreenReceiver();
    MediaPlaybackService mService;

    class LockScreenReceiver extends BroadcastReceiver {
        private boolean mForceCopyAlbum;
        private String mLockScreenArtistName;
        private String mLockScrenAlbumName;

        LockScreenReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (In.ACTION_LOCKSCREEN_REQUEST.equals(action)) {
                MediaPlaybackService s = LockScreenListener.this.mService;
                if (s != null) {
                    String albumName = s.getAlbumName();
                    String artistName = s.getArtistName();
                    if (s.getTrackName() == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("track", false)) {
                        LockScreenListener.this.notifyScreenManager(null, true);
                        return;
                    }
                    String tempAlbumPath = s.getFilesDir() + File.separator + MediaPlaybackService.TEMP_ALBUM_NAME;
                    if (!this.mForceCopyAlbum && albumName.equals(this.mLockScrenAlbumName) && artistName.equals(this.mLockScreenArtistName) && new File(tempAlbumPath).exists()) {
                        LockScreenListener.this.notifyScreenManager(tempAlbumPath, true);
                        return;
                    }
                    this.mLockScrenAlbumName = albumName;
                    this.mLockScreenArtistName = artistName;
                    LockScreenListener.this.notifyScreenManager(LockScreenListener.this.copyAlbum(tempAlbumPath), true);
                    this.mForceCopyAlbum = false;
                }
            } else if (ServiceActions.In.UPDATE_META_ACTION.equals(action)) {
                String cmd = intent.getStringExtra(ServiceActions.In.CMDNAME);
                if ("album".equals(cmd) || "track".equals(cmd)) {
                    this.mForceCopyAlbum = true;
                }
            }
        }
    }

    public void registerScreenlock(MediaPlaybackService service) {
        IntentFilter screenlockFilter = new IntentFilter();
        screenlockFilter.addAction(In.ACTION_LOCKSCREEN_REQUEST);
        screenlockFilter.addAction(ServiceActions.In.UPDATE_META_ACTION);
        service.registerReceiver(this.mLockScreenListener, screenlockFilter);
        this.mService = service;
    }

    public void unregisterScreenlock() {
        if (this.mService != null) {
            notifyScreenManager(null, false);
            this.mService.unregisterReceiver(this.mLockScreenListener);
            this.mService = null;
        }
    }

    String copyAlbum(String destPath) {
        InputStream inputStream;
        MediaPlaybackService s = this.mService;
        if (s == null) {
            return null;
        }
        InputStream inputStream2 = null;
        if (PreferenceCache.getPrefAsBoolean(s, PreferenceCache.PREF_DISPLAY_ALBUM)) {
            if (PreferenceCache.getPrefAsBoolean(s, PreferenceCache.PREF_ANDROID_ALBUM)) {
                inputStream = AlbumManager.getAlbumStreamFromDB(s, s.getAudioId(), s.getAlbumId());
            } else {
                inputStream = null;
            }
            if (inputStream == null) {
                File albumFile = s.getAlbumFile(s.getAlbumName(), s.getArtistName());
                if (albumFile != null && albumFile.isFile()) {
                    try {
                        inputStream2 = new FileInputStream(albumFile);
                    } catch (FileNotFoundException e) {
                        inputStream2 = inputStream;
                    }
                }
            }
            inputStream2 = inputStream;
        }
        if (inputStream2 == null) {
            File file = new File(destPath);
            if (file.exists()) {
                file.delete();
            }
            destPath = null;
        } else {
            OutputStream outputStream = null;
            try {
                outputStream = s.openFileOutput(MediaPlaybackService.TEMP_ALBUM_NAME, 1);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            if (outputStream != null) {
                FileOperations.copyFile(inputStream2, outputStream);
                try {
                    inputStream2.close();
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
        }
        return destPath;
    }

    void notifyScreenManager(String tempAlbumPath, boolean isShowMusic) {
        MediaPlaybackService s = this.mService;
        if (s != null) {
            Intent intent = new Intent(Out.ACTION_LOCKSRECCN_UPDATE);
            intent.putExtra(Out.KEY_TEMP_ALBUM_PATH, tempAlbumPath);
            intent.putExtra(Out.KEY_MUSIC_SHOW, isShowMusic);
            intent.putExtra("artist", s.getArtistName());
            intent.putExtra("album", s.getAlbumName());
            intent.putExtra("track", s.getTrackName());
            intent.putExtra(Out.KEY_PLAYING, s.isPlaying());
            s.sendBroadcast(intent);
        }
    }
}
