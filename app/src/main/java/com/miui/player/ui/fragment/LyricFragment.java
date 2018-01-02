package com.miui.player.ui.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.Out;
import com.miui.player.meta.LyricParser;
import com.miui.player.meta.LyricParser.Lyric;
import com.miui.player.meta.MetaManager;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ShakeListener;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.ui.controller.LyricMovementController;
import com.miui.player.ui.view.ExtendScrollView;
import com.miui.player.util.Actions;
import com.miui.player.util.PreferenceCache;
import java.io.File;
import miui.v5.view.EditActionMode;

public class LyricFragment extends MusicBaseFragment {
    static final int MIN_REFRESH_INTERVAL = 30;
    static final int MSG_REFRESH = 1;
    static final int REFRESH_INTERVAL = 120;
    private Animator mAnimator;
    private LyricChangeAnimatorListener mAnimatorListener;
    private ActionMode mCurrentMode;
    final Handler mHandler = new C04981();
    private Lyric mLyric;
    View mLyricAnimView;
    View mLyricEditModeLine;
    final LyricInfo mLyricInfo = new LyricInfo();
    LyricMovementController mLyricMovementController;
    private LyricStatusView mLyricStatusView;

    class C04981 extends Handler {
        C04981() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    LyricFragment.this.queueNextRefresh(LyricFragment.this.refreshNow());
                    return;
                default:
                    return;
            }
        }
    }

    private class LyricChangeAnimatorListener implements AnimatorListener, AnimatorUpdateListener {
        private long mProgress = -1;
        private boolean mUpdated = false;

        LyricChangeAnimatorListener() {
        }

        public boolean isUpdated() {
            return this.mUpdated;
        }

        public void onAnimationCancel(Animator animation) {
        }

        public void onAnimationEnd(Animator animation) {
            LyricFragment.this.mLyricAnimView.setAlpha(ShakeListener.ACCELATION_FACTOR_X);
            if (this.mProgress >= 0) {
                LyricFragment.this.mLyricMovementController.refreshLyric(this.mProgress);
                this.mProgress = -1;
            }
        }

        public void onAnimationRepeat(Animator animation) {
        }

        public void onAnimationStart(Animator animation) {
            this.mUpdated = false;
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            float progress = ((Float) animation.getAnimatedValue()).floatValue();
            if (progress > ShakeListener.ACCELATION_FACTOR_X && !this.mUpdated) {
                this.mUpdated = true;
                LyricFragment.this.showLyric();
                if (this.mProgress >= 0) {
                    LyricFragment.this.mLyricMovementController.refreshLyric(this.mProgress);
                    this.mProgress = -1;
                }
            }
            if (progress < ShakeListener.ACCELATION_FACTOR_X) {
                LyricFragment.this.mLyricAnimView.setAlpha(ShakeListener.ACCELATION_FACTOR_X - progress);
            } else {
                LyricFragment.this.mLyricAnimView.setAlpha(progress - ShakeListener.ACCELATION_FACTOR_X);
            }
        }

        public void setInitProgress(long progress) {
            this.mProgress = progress;
        }
    }

    private class LyricEditModeCallback implements Callback {
        private boolean mSaved = false;

        LyricEditModeCallback() {
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            menu.close();
            return true;
        }

        public void onDestroyActionMode(ActionMode mode) {
            if (!this.mSaved) {
                LyricFragment.this.cancelModify();
            }
            LyricFragment.this.onFininshEditMode();
        }

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            EditActionMode actionMode = (EditActionMode) mode;
            actionMode.setTitle(C0329R.string.lrc_progress_modify_helper);
            actionMode.setButton(16908313, C0329R.string.cancel);
            actionMode.setButton(16908314, C0329R.string.confirm);
            LyricFragment.this.onStartEditMode(mode);
            return true;
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case 16908313:
                    LyricFragment.this.cancelModify();
                    break;
                case 16908314:
                    LyricFragment.this.saveModify();
                    this.mSaved = true;
                    break;
            }
            mode.finish();
            return true;
        }
    }

    private static class LyricInfo {
        public String mArtistName;
        public int mLyricStatus;
        public String mTrackName;
        public String mTrackPath;

        public void update(Intent intent) {
            this.mTrackName = intent.getStringExtra("track");
            this.mArtistName = intent.getStringExtra("artist");
            this.mTrackPath = intent.getStringExtra(Out.KEY_TRACK_PATH);
            this.mLyricStatus = intent.getIntExtra(Out.KEY_LYRIC_STATUS, 0);
        }

        public void update(IMediaPlaybackService service) {
            this.mTrackName = null;
            this.mArtistName = null;
            this.mTrackPath = null;
            this.mLyricStatus = 2;
            if (service != null) {
                try {
                    this.mTrackName = service.getTrackName();
                    this.mArtistName = service.getArtistName();
                    this.mTrackPath = service.getAbsolutePath();
                    this.mLyricStatus = service.getLyricStatus();
                } catch (RemoteException e) {
                }
            }
        }

        public boolean isValid() {
            return this.mTrackName != null;
        }
    }

    private static class LyricStatusView {
        private final View mContainer;
        private final View mNoLyricIndicator;
        private final TextView mStatusText;

        public LyricStatusView(View parent) {
            this.mContainer = parent.findViewById(C0329R.id.lyric_status);
            this.mStatusText = (TextView) parent.findViewById(C0329R.id.lyric_status_text);
            this.mNoLyricIndicator = parent.findViewById(C0329R.id.no_lyric_indicator);
        }

        public void setVisible(boolean visible) {
            this.mContainer.setVisibility(visible ? 0 : 8);
        }

        public void setIndicatorVisible(boolean visible) {
            this.mNoLyricIndicator.setVisibility(visible ? 0 : 4);
        }

        public void setStatusText(CharSequence text) {
            this.mStatusText.setText(text);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
        return inflater.inflate(C0329R.layout.lyric_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        boolean isLandScape = false;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            if (Actions.ACTION_LANDSCAPE_VIEW.equals(intent.getAction())) {
                isLandScape = true;
            }
        }
        this.mLyricAnimView = view.findViewById(C0329R.id.lyric_anim);
        ExtendScrollView lyricFrame = (ExtendScrollView) view.findViewById(C0329R.id.lyric_frame);
        lyricFrame.setVerticalFadingEdgeEnabled(true);
        lyricFrame.setFadingEdgeLength(view.getResources().getDimensionPixelSize(isLandScape ? C0329R.dimen.land_lyric_fading_length : C0329R.dimen.lyric_fading_length));
        this.mLyricMovementController = new LyricMovementController(lyricFrame);
        if (isLandScape) {
            this.mLyricMovementController.setHighLightTextStyle(C0329R.dimen.land_lyric_high_light_text_size);
            this.mLyricMovementController.setNormalTextStyle(C0329R.dimen.land_lyric_nomal_text_size);
            this.mLyricMovementController.setLineSpacing(C0329R.dimen.land_lyric_line_extra_spacing);
        }
        this.mLyricStatusView = new LyricStatusView(view);
        this.mLyricEditModeLine = view.findViewById(C0329R.id.lyric_nowplaying_line);
        MarginLayoutParams lyricLineParams = (MarginLayoutParams) this.mLyricEditModeLine.getLayoutParams();
        Resources resources = view.getResources();
        lyricLineParams.topMargin = (this.mLyricMovementController.getLyricNowplayingMarginTop() + resources.getDimensionPixelOffset(C0329R.dimen.spacing_to_border)) + resources.getDimensionPixelOffset(C0329R.dimen.lyric_current_margin_top);
        this.mLyricEditModeLine.setLayoutParams(lyricLineParams);
    }

    public void onResume() {
        super.onResume();
        this.mLyricInfo.update(this.mService);
        updateInternel();
        queueNextRefresh(refreshNow());
    }

    public void onPause() {
        leaveLyricEditMode();
        super.onPause();
    }

    public void onDestroy() {
        clearAll();
        super.onDestroy();
    }

    public void setService(IMediaPlaybackService service) {
        super.setService(service);
        this.mLyricInfo.update(service);
        updateInternel();
        queueNextRefresh(refreshNow());
    }

    public void setLyricProgress(long pos) {
        if (this.mLyric == null) {
            return;
        }
        if (this.mAnimator.isRunning()) {
            this.mAnimatorListener.setInitProgress(pos);
        } else {
            this.mLyricMovementController.refreshLyric(pos);
        }
    }

    public boolean hasLyric() {
        if (PreferenceCache.getPrefAsBoolean(getActivity(), PreferenceCache.PREF_DISPLAY_LYRIC) && this.mLyricInfo.isValid() && this.mLyric != null) {
            return true;
        }
        return false;
    }

    protected String[] getObservedServiceActions() {
        return new String[]{Out.STATUS_META_CHANGED, Out.STATUS_PLAYSTATE_CHANGED, Out.STATUS_PLAYBACK_COMPLETE};
    }

    protected void handleServiceNotification(Intent intent) {
        if (Out.STATUS_META_CHANGED.equals(intent.getAction())) {
            String extra = intent.getStringExtra(Out.KEY_OTHER);
            if (Out.META_CHANGED_LYRIC.equals(extra) || Out.META_CHANGED_TRACK.equals(extra) || Out.META_CHANGED_BUFFERED_OVER.equals(extra)) {
                this.mLyricInfo.update(intent);
                updateInternel();
            }
        }
        if (isResumed()) {
            queueNextRefresh(refreshNow());
        }
    }

    void updateInternel() {
        if (this.mService != null && isResumed()) {
            leaveLyricEditMode();
            if (readLyric()) {
                getActivity().invalidateOptionsMenu();
                ensureAnimator();
                try {
                    this.mAnimatorListener.setInitProgress(this.mService.position());
                } catch (RemoteException e) {
                }
                if (!this.mAnimator.isRunning()) {
                    this.mAnimator.start();
                    return;
                } else if (this.mAnimatorListener.isUpdated()) {
                    this.mAnimator.cancel();
                    this.mAnimator.start();
                    return;
                } else {
                    return;
                }
            }
            showLyric();
        }
    }

    private void clearAll() {
        this.mLyric = null;
        this.mLyricMovementController.resetLyric(null);
        this.mLyricMovementController.clearText();
    }

    private boolean readLyric() {
        if (!PreferenceCache.getPrefAsBoolean(getActivity(), PreferenceCache.PREF_DISPLAY_LYRIC)) {
            return false;
        }
        Lyric oldLyric = this.mLyric;
        this.mLyric = null;
        File lyricFile = MetaManager.getLyricFile(this.mLyricInfo.mTrackName, this.mLyricInfo.mArtistName, this.mLyricInfo.mTrackPath);
        if (lyricFile != null && lyricFile.exists()) {
            if (oldLyric == null || oldLyric.getOpenTime() <= lyricFile.lastModified() || !oldLyric.getFilePath().equals(lyricFile.getAbsolutePath())) {
                this.mLyric = LyricParser.parseLyric(lyricFile);
                if (this.mLyric == null) {
                    lyricFile.delete();
                }
            } else {
                this.mLyric = oldLyric;
            }
        }
        if (oldLyric != this.mLyric) {
            return true;
        }
        return false;
    }

    boolean showLyric() {
        boolean z = false;
        if (!this.mLyricInfo.isValid()) {
            clearAll();
            return false;
        } else if (PreferenceCache.getPrefAsBoolean(getActivity(), PreferenceCache.PREF_DISPLAY_LYRIC)) {
            this.mLyricMovementController.resetLyric(this.mLyric);
            int hint = 0;
            switch (this.mLyricInfo.mLyricStatus) {
                case 0:
                    if (this.mLyric == null) {
                        hint = C0329R.string.lrc_searching;
                        break;
                    }
                    break;
                case 2:
                    hint = C0329R.string.lrc_search_failed;
                    break;
                case 3:
                    if (this.mLyric == null) {
                        hint = C0329R.string.lrc_search_failed;
                        break;
                    }
                    break;
                case 4:
                    hint = C0329R.string.lrc_searching;
                    break;
                case 5:
                    hint = C0329R.string.network_error;
                    break;
                case 6:
                    hint = C0329R.string.lyric_open_other_connect;
                    break;
            }
            if (hint > 0) {
                this.mLyricMovementController.clearText();
                this.mLyricStatusView.setVisible(true);
                this.mLyricStatusView.setStatusText(MusicApplication.getApplication().getText(hint));
                LyricStatusView lyricStatusView = this.mLyricStatusView;
                if (hint != C0329R.string.lrc_searching) {
                    z = true;
                }
                lyricStatusView.setIndicatorVisible(z);
            } else {
                this.mLyricStatusView.setVisible(false);
            }
            return true;
        } else {
            clearAll();
            return false;
        }
    }

    private void ensureAnimator() {
        if (this.mAnimator == null) {
            ValueAnimator anim = ValueAnimator.ofFloat(new float[]{0.0f, 2.0f});
            this.mAnimator = anim;
            LyricChangeAnimatorListener l = new LyricChangeAnimatorListener();
            this.mAnimatorListener = l;
            anim.setDuration((long) (getActivity().getResources().getInteger(C0329R.integer.anim_duration_normal) * 2));
            anim.addListener(l);
            anim.addUpdateListener(l);
        }
    }

    public boolean enterLyricEditMode() {
        if (this.mCurrentMode != null || this.mLyric == null) {
            return false;
        }
        this.mLyricAnimView.startActionMode(new LyricEditModeCallback());
        return true;
    }

    public void leaveLyricEditMode() {
        if (this.mCurrentMode != null) {
            this.mCurrentMode.finish();
        }
    }

    void onStartEditMode(ActionMode mode) {
        this.mCurrentMode = mode;
        this.mLyricMovementController.setLyricMode(1);
        this.mLyricEditModeLine.setVisibility(0);
    }

    void onFininshEditMode() {
        this.mCurrentMode = null;
        this.mLyricMovementController.setLyricMode(0);
        this.mLyricEditModeLine.setVisibility(8);
    }

    void saveModify() {
        if (this.mLyric != null) {
            this.mLyric.save();
        }
    }

    void cancelModify() {
        if (this.mLyric != null) {
            this.mLyric.resetHeaderOffset();
        }
    }

    long refreshNow() {
        long ret = -1;
        boolean isPlaying = false;
        IMediaPlaybackService service = this.mService;
        if (service != null) {
            try {
                isPlaying = service.isPlaying();
                long pos = service.position();
                long duration = service.duration();
                ret = Math.max(120 - (pos % 120), 30);
                if (pos >= 0 && duration > 0) {
                    setLyricProgress(pos);
                }
            } catch (RemoteException e) {
            }
        }
        return isPlaying ? ret : -1;
    }

    void queueNextRefresh(long delay) {
        if (isResumed() && this.mService != null && delay > 0) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), delay);
        }
    }
}
