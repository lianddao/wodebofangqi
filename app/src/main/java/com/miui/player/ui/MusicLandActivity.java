package com.miui.player.ui;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.Out;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.fragment.LyricFragment;
import com.miui.player.ui.fragment.TrackListFragment;
import com.miui.player.ui.fragment.TrackListFragment.OnCursorChangedListener;
import com.miui.player.ui.model.LandAlbumAdapter;
import com.miui.player.ui.model.LandDefaultAdapter;
import com.miui.player.ui.view.CascadingView;
import com.miui.player.ui.view.CascadingView.OnRotationChangedListener;
import com.miui.player.ui.view.CascadingView.OnScrollListener;
import com.miui.player.ui.view.CascadingView.OnSingleTapUpListener;
import com.miui.player.util.PreferenceCache;

public class MusicLandActivity extends MusicBaseActivity implements OnSingleTapUpListener, OnClickListener, OnCursorChangedListener, OnRotationChangedListener {
    private static final int FLYBACK_DELAYED = 3000;
    private static final int MAX_ROTATION = 25;
    private static final int MAX_VISIBLE_ITEM_COUNT = 5;
    static final String TAG = "MusicLandActivity";
    CascadingView mAlbum;
    private LandAlbumAdapter mAlbumAdapter;
    TextView mArtistNameText;
    private final OnScrollListener mCascadingScrollListener = new C04482();
    private int mCascadingScrollState = 0;
    private LandDefaultAdapter mDefaultAdapter;
    private Handler mFlybackHandler = new Handler();
    private Runnable mFlybackRunnable = new C04471();
    private boolean mIsInListFragment = false;
    private TrackListFragment mListFragment;
    private LyricFragment mLyricFragment;
    ImageView mPlayButton;
    private IMediaPlaybackService mService;
    TextView mTrackNameText;
    private WakeLock mWakeLock;

    class C04471 implements Runnable {
        C04471() {
        }

        public void run() {
            try {
                if (MusicLandActivity.this.mService != null) {
                    MusicLandActivity.this.mAlbum.smoothToSelection(MusicLandActivity.this.mService.getQueuePosition());
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    class C04482 implements OnScrollListener {
        C04482() {
        }

        public void onScroll(CascadingView view, int position, float offset) {
        }

        public void onScrollStateChanged(CascadingView view, int state) {
            MusicLandActivity.this.mCascadingScrollState = state;
            switch (state) {
                case 0:
                    MusicLandActivity.this.mFlybackHandler.postDelayed(MusicLandActivity.this.mFlybackRunnable, 3000);
                    return;
                case 1:
                case 2:
                    MusicLandActivity.this.mFlybackHandler.removeCallbacks(MusicLandActivity.this.mFlybackRunnable);
                    return;
                default:
                    return;
            }
        }
    }

    protected void onCreateContent(Bundle icicle) {
        try {
            setContentView(C0329R.layout.music_land_activity);
            this.mWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(536870922, TAG);
            this.mAlbum = (CascadingView) findViewById(C0329R.id.albums_wrapper);
            this.mAlbum.setMaxVisibleItemCount(5);
            this.mAlbum.setMaxRotationHorizontal(25.0f);
            this.mPlayButton = (ImageView) findViewById(C0329R.id.play_button);
            this.mPlayButton.setOnClickListener(this);
            this.mTrackNameText = (TextView) findViewById(C0329R.id.track_name);
            this.mArtistNameText = (TextView) findViewById(C0329R.id.artist_name);
            this.mListFragment = (TrackListFragment) getFragmentManager().findFragmentById(C0329R.id.track_list_fragment);
            this.mListFragment.setOnCursorChangedListener(this);
            this.mLyricFragment = (LyricFragment) getFragmentManager().findFragmentById(C0329R.id.lyric_fragment);
            switchFragment();
        } catch (RuntimeException e) {
            e.printStackTrace();
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        if (PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_SCREEN_BRIGHT_WAKE)) {
            this.mWakeLock.acquire();
        }
        LandAlbumAdapter.startCache();
        setupAdapter();
    }

    protected void onPause() {
        if (this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
        LandAlbumAdapter.quitCache();
        super.onPause();
    }

    protected void onDestroyContent() {
        this.mFlybackHandler.removeCallbacks(this.mFlybackRunnable);
        this.mService = null;
        if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
        super.onDestroyContent();
    }

    private void switchFragment() {
        boolean z = true;
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (isChannel()) {
            ft.hide(this.mListFragment);
            ft.show(this.mLyricFragment);
            this.mIsInListFragment = false;
        } else if (this.mIsInListFragment) {
            try {
                int pos = this.mAlbum.getSelection();
                if (this.mService == null || pos == this.mService.getQueuePosition()) {
                    ft.hide(this.mListFragment);
                    ft.show(this.mLyricFragment);
                    if (this.mIsInListFragment) {
                        z = false;
                    }
                    this.mIsInListFragment = z;
                } else {
                    this.mListFragment.setListSelectedPosition(pos);
                    this.mService.setQueuePosition(pos);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            ft.hide(this.mLyricFragment);
            ft.show(this.mListFragment);
            this.mListFragment.setListSelectedPosition(this.mAlbum.getSelection());
            if (this.mIsInListFragment) {
                z = false;
            }
            this.mIsInListFragment = z;
        }
        ft.commit();
    }

    protected String[] getObservedServiceActions() {
        return new String[]{Out.STATUS_META_CHANGED, Out.STATUS_PLAYSTATE_CHANGED, Out.STATUS_PLAYBACK_COMPLETE, Out.STATUS_QUEUE_CHANGED};
    }

    protected void handleServiceConnected(IMediaPlaybackService service) throws RemoteException {
        float f = 0.0f;
        super.handleServiceConnected(service);
        if (!isFinishing()) {
            this.mService = service;
            this.mListFragment.setService(service);
            this.mLyricFragment.setService(service);
            updateTrackInfo(true);
            refreshPlayButton();
            if (isChannel()) {
                switchFragment();
                this.mAlbum.setRotationHorizontal(0.0f);
                return;
            }
            this.mAlbum.setOnSingleTapUpListener(this);
            this.mAlbum.setOnScrollListener(this.mCascadingScrollListener);
            this.mAlbum.setOnRotationChangedListener(this);
            CascadingView cascadingView = this.mAlbum;
            if (this.mIsInListFragment) {
                f = 25.0f;
            }
            cascadingView.setRotationHorizontal(f);
        }
    }

    protected void handleServiceDisconnected() {
        this.mService = null;
        this.mListFragment.setService(null);
        this.mLyricFragment.setService(null);
    }

    protected void handleServiceNotification(Intent intent) {
        super.handleServiceNotification(intent);
        if (this.mService != null) {
            String action = intent.getAction();
            if (action.equals(Out.STATUS_META_CHANGED)) {
                updateTrackInfo(false);
            } else if (action.equals(Out.STATUS_PLAYBACK_COMPLETE) || action.equals(Out.STATUS_PLAYSTATE_CHANGED)) {
                refreshPlayButton();
            } else if (action.equals(Out.STATUS_QUEUE_CHANGED)) {
                setupAdapter();
            }
        }
    }

    private void updateTrackInfo(boolean updateAlbumSelection) {
        if (this.mService != null) {
            try {
                if (ServiceHelper.isMusicLoaded()) {
                    this.mTrackNameText.setText(this.mService.getTrackName());
                    this.mArtistNameText.setText(this.mService.getArtistName());
                }
                if (updateAlbumSelection || this.mAlbum.getRotationHorizontal() == 0.0f) {
                    this.mAlbum.setSelection(this.mService.getQueuePosition());
                } else if (this.mCascadingScrollState == 0) {
                    this.mAlbum.smoothToSelection(this.mService.getQueuePosition());
                }
                if (this.mAlbumAdapter != null) {
                    this.mAlbumAdapter.notifyDataSetChanged();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void refreshPlayButton() {
        if (this.mService != null) {
            try {
                this.mPlayButton.setBackgroundResource(this.mService.isPlaying() ? C0329R.drawable.music_land_pause_button : C0329R.drawable.music_land_play_button);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void onClick(View v) {
        if (this.mService != null && v == this.mPlayButton) {
            try {
                if (this.mService.isPlaying()) {
                    this.mService.pause();
                } else {
                    this.mService.play();
                }
                refreshPlayButton();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean isLandScape() {
        return true;
    }

    public void onCursorChanged(Cursor cursor) {
        if (ServiceHelper.isMusicLoaded()) {
            setAlbumAdapter();
            this.mAlbumAdapter.changeCursor(cursor);
            return;
        }
        setDefaultAdapter();
        MatrixCursor defaultCursor = new MatrixCursor(new String[]{"_id"});
        for (int i = 0; i < 5; i++) {
            defaultCursor.addRow(new Object[]{String.valueOf(i)});
        }
        this.mDefaultAdapter.changeCursor(defaultCursor);
    }

    public void onSingleTapUp(CascadingView view) {
        switchFragment();
        this.mAlbum.smoothToRotationHorizontal(this.mIsInListFragment ? 25.0f : 0.0f);
    }

    private boolean isChannel() {
        if (this.mService == null) {
            return false;
        }
        try {
            if (this.mService.getChannelName() != null) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onRotationChanged(CascadingView v, float rotation) {
        if (rotation == 0.0f && this.mService != null) {
            try {
                v.setSelection(this.mService.getQueuePosition());
            } catch (RemoteException e) {
            }
        }
    }

    private void setupAdapter() {
        if (ServiceHelper.isMusicLoaded()) {
            setAlbumAdapter();
        } else {
            setDefaultAdapter();
        }
    }

    private void setAlbumAdapter() {
        this.mDefaultAdapter = null;
        if (this.mAlbumAdapter == null) {
            this.mAlbumAdapter = new LandAlbumAdapter(this, C0329R.layout.land_album_item, null, null, null);
            this.mAlbum.setAdapter(this.mAlbumAdapter);
            this.mAlbum.setViewEffectUpdater(this.mAlbumAdapter);
        }
    }

    private void setDefaultAdapter() {
        this.mAlbumAdapter = null;
        if (this.mDefaultAdapter == null) {
            this.mDefaultAdapter = new LandDefaultAdapter(this, C0329R.layout.land_album_item, null, null, null);
            this.mAlbum.setAdapter(this.mDefaultAdapter);
            this.mAlbum.setViewEffectUpdater(this.mDefaultAdapter);
        }
    }
}
