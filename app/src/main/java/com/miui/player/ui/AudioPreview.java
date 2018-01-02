package com.miui.player.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.service.AudioPreviewService;
import com.miui.player.service.IAudioPreviewService;
import com.miui.player.service.IAudioPreviewService.Stub;
import com.miui.player.util.ServiceActions.OneShot;

public class AudioPreview extends Activity implements OnClickListener, OnSeekBarChangeListener, ServiceConnection {
    static final int MSG_REFRESH = 1;
    static final long REFRESH_INTERVAL = 200;
    static final String TAG = AudioPreview.class.getName();
    private ProgressBar mLoadingBar;
    private TextView mLoadingText;
    private View mMetaInfoPanel;
    private ImageView mPlayPauseButton;
    private final Handler mProgressRefresher = new C04282();
    private SeekBar mSeekBar;
    private boolean mSeeking = false;
    private IAudioPreviewService mService;
    final BroadcastReceiver mStatusListener = new C04271();
    private TextView mTextLine1;
    private TextView mTextLine2;
    private Uri mUri;

    class C04271 extends BroadcastReceiver {
        C04271() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (OneShot.ACTION_PREPARED.equals(action)) {
                AudioPreview.this.updateMetaInfo();
            } else if (OneShot.ACTION_METAINFO_CHANGED.equals(action)) {
                AudioPreview.this.updateMetaInfo();
            } else if (OneShot.ACTION_PLAYSTATE_CHANGED.equals(action)) {
                AudioPreview.this.updateStatus();
                AudioPreview.this.queueNextRefresh(true);
            } else if (OneShot.ACTION_PLAY_ERROR.equals(action)) {
                Toast.makeText(AudioPreview.this, C0329R.string.playback_failed_no_title_by_bad_file, 0).show();
                AudioPreview.this.finish();
            }
        }
    }

    class C04282 extends Handler {
        C04282() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    AudioPreview.this.queueNextRefresh(true);
                    return;
                default:
                    return;
            }
        }
    }

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setVolumeControlStream(3);
        requestWindowFeature(1);
        setContentView(C0329R.layout.audiopreview);
        this.mMetaInfoPanel = findViewById(C0329R.id.titleandbuttons);
        this.mTextLine1 = (TextView) findViewById(C0329R.id.line1);
        this.mTextLine2 = (TextView) findViewById(C0329R.id.line2);
        this.mLoadingText = (TextView) findViewById(C0329R.id.loading);
        this.mLoadingBar = (ProgressBar) findViewById(C0329R.id.spinner);
        this.mSeekBar = (SeekBar) findViewById(C0329R.id.progress);
        this.mSeekBar.setOnSeekBarChangeListener(this);
        this.mPlayPauseButton = (ImageView) findViewById(C0329R.id.playpause);
        this.mPlayPauseButton.setOnClickListener(this);
        this.mUri = getIntent().getData();
        startService(new Intent(this, AudioPreviewService.class));
        bindService(new Intent().setClass(this, AudioPreviewService.class), this, 0);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Uri uri = intent.getData();
        if (uri != null) {
            this.mUri = uri;
            if (this.mService != null) {
                try {
                    this.mService.prepareAsync(this.mUri.toString());
                } catch (RemoteException e) {
                }
            }
        }
        updateStatus();
        updateMetaInfo();
        queueNextRefresh(true);
    }

    protected void onDestroy() {
        unbindService(this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(OneShot.ACTION_METAINFO_CHANGED);
        filter.addAction(OneShot.ACTION_PLAYSTATE_CHANGED);
        filter.addAction(OneShot.ACTION_PREPARED);
        filter.addAction(OneShot.ACTION_PLAY_ERROR);
        registerReceiver(this.mStatusListener, filter);
        updateMetaInfo();
        updateStatus();
        queueNextRefresh(true);
    }

    protected void onPause() {
        unregisterReceiver(this.mStatusListener);
        queueNextRefresh(false);
        super.onPause();
    }

    public void onBackPressed() {
        if (this.mService != null) {
            try {
                this.mService.pause();
            } catch (RemoteException e) {
            }
        }
        super.onBackPressed();
    }

    void updateStatus() {
        if (this.mService != null) {
            try {
                if (this.mService.isPlaying()) {
                    this.mPlayPauseButton.setImageResource(C0329R.drawable.btn_playback_ic_pause_small);
                } else {
                    this.mPlayPauseButton.setImageResource(C0329R.drawable.btn_playback_ic_play_small);
                }
            } catch (RemoteException e) {
            }
        }
    }

    void updateMetaInfo() {
        boolean loading = false;
        try {
            loading = this.mService == null || !this.mService.isPrepared();
        } catch (RemoteException e) {
        }
        this.mLoadingText.setVisibility(8);
        if (loading) {
            if (this.mUri != null && "http".equalsIgnoreCase(this.mUri.getScheme())) {
                this.mLoadingText.setText(getString(C0329R.string.streamloadingtext, new Object[]{this.mUri.getHost()}));
                this.mLoadingText.setVisibility(0);
            }
            this.mLoadingBar.setVisibility(0);
            this.mMetaInfoPanel.setVisibility(8);
            this.mSeekBar.setVisibility(8);
            return;
        }
        this.mLoadingText.setVisibility(8);
        this.mLoadingBar.setVisibility(8);
        this.mMetaInfoPanel.setVisibility(0);
        if (this.mService != null) {
            try {
                this.mTextLine1.setText(this.mService.getPrimaryText());
                String secondary = this.mService.getSecondaryText();
                if (TextUtils.isEmpty(secondary)) {
                    this.mTextLine2.setVisibility(8);
                } else {
                    this.mTextLine2.setVisibility(0);
                    this.mTextLine2.setText(secondary);
                }
                this.mSeekBar.setMax(this.mService.duration());
                this.mSeekBar.setProgress(this.mService.position());
                this.mSeekBar.setVisibility(0);
            } catch (RemoteException e2) {
            }
        }
    }

    void queueNextRefresh(boolean refresh) {
        this.mProgressRefresher.removeMessages(1);
        if (refresh) {
            try {
                refreshProgress();
                if (this.mService != null && this.mService.isPlaying()) {
                    this.mProgressRefresher.sendMessageDelayed(this.mProgressRefresher.obtainMessage(1), REFRESH_INTERVAL);
                }
            } catch (RemoteException e) {
            }
        }
    }

    private void refreshProgress() {
        try {
            if (this.mService != null && !this.mSeeking && !isFinishing() && this.mService.isPrepared()) {
                this.mSeekBar.setProgress(this.mService.position());
            }
        } catch (RemoteException e) {
        }
    }

    public void onStartTrackingTouch(SeekBar bar) {
        this.mSeeking = true;
    }

    public void onProgressChanged(SeekBar bar, int progress, boolean fromuser) {
    }

    public void onStopTrackingTouch(SeekBar bar) {
        this.mSeeking = false;
        try {
            if (this.mService != null && this.mService.isPrepared()) {
                this.mService.seek(bar.getProgress());
            }
        } catch (RemoteException e) {
        }
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        this.mService = Stub.asInterface(service);
        if (this.mService == null) {
            finish();
            return;
        }
        try {
            String str = this.mService.getUriString();
            Uri playUri = str != null ? Uri.parse(str) : null;
            Uri newUri = getIntent().getData();
            if (newUri == null) {
                this.mUri = playUri;
            } else {
                this.mUri = newUri;
                this.mService.prepareAsync(this.mUri.toString());
            }
            updateStatus();
            updateMetaInfo();
            queueNextRefresh(true);
        } catch (RemoteException e) {
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        finish();
    }

    private void togglePause() {
        if (this.mService != null) {
            try {
                if (this.mService.isPrepared()) {
                    if (this.mService.isPlaying()) {
                        this.mService.pause();
                    } else {
                        this.mService.start();
                    }
                }
            } catch (RemoteException e) {
            }
        }
        updateStatus();
    }

    public void onClick(View v) {
        togglePause();
    }
}
