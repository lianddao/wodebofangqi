package com.miui.player.ui.controller;

import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.miui.player.C0329R;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.controller.TimeIndicatorController.OnProgressSeekListener;
import com.miui.player.ui.view.RepeatingImageButton;
import com.miui.player.ui.view.RepeatingImageButton.RepeatListener;

public class PlayerCommonController {
    private static final int REPEAT_INTEVAL = 260;
    private final View mCommonBar;
    private final RepeatingImageButton mNextButton;
    private final ImageView mPauseButton;
    private final int mPauseResId;
    private final int mPlayResId;
    private final RepeatingImageButton mPrevButton = ((RepeatingImageButton) this.mCommonBar.findViewById(C0329R.id.prev));
    private final RepeatClickCallback mRepeatClickCallback;

    public interface RepeatClickCallback {
        void update();
    }

    private class OnBackwardRepeatingClick implements RepeatListener {
        private RepeatClickCallback mCallback;

        public OnBackwardRepeatingClick(RepeatClickCallback callback) {
            this.mCallback = callback;
        }

        public void onRepeat(View v, long delta, int repcnt) {
            IMediaPlaybackService service = ServiceHelper.sService;
            if (service != null) {
                try {
                    service.backward();
                } catch (RemoteException e) {
                }
            }
            if (this.mCallback != null) {
                this.mCallback.update();
            }
        }
    }

    private class OnForwardRepeatingClick implements RepeatListener {
        private RepeatClickCallback mCallback;

        public OnForwardRepeatingClick(RepeatClickCallback callback) {
            this.mCallback = callback;
        }

        public void onRepeat(View v, long delta, int repcnt) {
            IMediaPlaybackService service = ServiceHelper.sService;
            if (service != null) {
                try {
                    service.forward();
                } catch (RemoteException e) {
                }
            }
            if (this.mCallback != null) {
                this.mCallback.update();
            }
        }
    }

    class OnNextClickListener implements OnClickListener {
        OnNextClickListener() {
        }

        public void onClick(View v) {
            IMediaPlaybackService service = ServiceHelper.sService;
            if (service != null) {
                try {
                    service.next();
                    PlayerCommonController.this.refresh();
                } catch (RemoteException e) {
                }
            }
        }
    }

    class OnPauseResumeClickListener implements OnClickListener {
        OnPauseResumeClickListener() {
        }

        public void onClick(View v) {
            try {
                IMediaPlaybackService service = ServiceHelper.sService;
                if (service != null) {
                    if (service.isPlaying()) {
                        service.pause();
                    } else {
                        service.play();
                    }
                    PlayerCommonController.this.refresh();
                }
            } catch (RemoteException e) {
            }
        }
    }

    class OnPrevClickListener implements OnClickListener {
        OnPrevClickListener() {
        }

        public void onClick(View v) {
            IMediaPlaybackService service = ServiceHelper.sService;
            if (service != null) {
                try {
                    service.prev();
                    PlayerCommonController.this.refresh();
                } catch (RemoteException e) {
                }
            }
        }
    }

    public PlayerCommonController(View container, RepeatClickCallback repeatClickCallback, OnProgressSeekListener seekListener, int playId, int pauseId, int prevId, int nextId) {
        this.mRepeatClickCallback = repeatClickCallback;
        this.mPlayResId = playId;
        this.mPauseResId = pauseId;
        this.mCommonBar = container.findViewById(C0329R.id.common_tabs);
        this.mPrevButton.setImageResource(prevId);
        this.mPrevButton.setOnClickListener(new OnPrevClickListener());
        this.mPrevButton.setRepeatListener(new OnBackwardRepeatingClick(this.mRepeatClickCallback), 260);
        this.mNextButton = (RepeatingImageButton) this.mCommonBar.findViewById(C0329R.id.next);
        this.mNextButton.setImageResource(nextId);
        this.mNextButton.setOnClickListener(new OnNextClickListener());
        this.mNextButton.setRepeatListener(new OnForwardRepeatingClick(this.mRepeatClickCallback), 260);
        this.mPauseButton = (ImageView) this.mCommonBar.findViewById(C0329R.id.pause);
        this.mPauseButton.setOnClickListener(new OnPauseResumeClickListener());
        this.mPauseButton.setImageResource(playId);
        refresh();
    }

    public void refresh() {
        IMediaPlaybackService service = ServiceHelper.sService;
        if (service != null) {
            try {
                if (service.isPlaying()) {
                    this.mPauseButton.setImageResource(this.mPauseResId);
                } else {
                    this.mPauseButton.setImageResource(this.mPlayResId);
                }
                this.mPrevButton.setEnabled(service.getChannelName() == null);
            } catch (RemoteException e) {
            }
        }
    }

    public View getView() {
        return this.mCommonBar;
    }

    public void setVisibility(int visible) {
        this.mCommonBar.setVisibility(visible);
    }

    public void setEnabled(boolean enabled) {
        IMediaPlaybackService service = ServiceHelper.sService;
        try {
            RepeatingImageButton repeatingImageButton = this.mPrevButton;
            boolean z = (!enabled || service == null || service.getChannelName() == null) ? false : true;
            repeatingImageButton.setEnabled(z);
        } catch (RemoteException e) {
        }
        this.mNextButton.setEnabled(enabled);
        this.mPauseButton.setEnabled(enabled);
    }
}
