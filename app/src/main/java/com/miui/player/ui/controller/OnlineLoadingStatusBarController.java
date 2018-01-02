package com.miui.player.ui.controller;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.ui.base.MusicApplication;
import com.xiaomi.music.util.NetworkUtil;

public class OnlineLoadingStatusBarController implements OnClickListener {
    private int mLoadingFailedId;
    private int mLoadingInProcessId;
    private final ImageView mNoContentIndicatorView = ((ImageView) this.mStatusBar.findViewById(C0329R.id.no_content_indicator));
    private final TextView mRetryButton = ((TextView) this.mStatusBar.findViewById(C0329R.id.btn_retry));
    private final OnClickListener mRetryClick;
    private final LinearLayout mStatusBar;
    private final TextView mStatusHintTextView = ((TextView) this.mStatusBar.findViewById(C0329R.id.online_status_text));
    private final ProgressBar mStatusProgressBar = ((ProgressBar) this.mStatusBar.findViewById(C0329R.id.online_status_progressbar));

    public OnlineLoadingStatusBarController(View container, OnClickListener retryClick) {
        this.mStatusBar = (LinearLayout) container;
        this.mStatusBar.setOnClickListener(this);
        this.mStatusBar.setEnabled(false);
        this.mRetryButton.setOnClickListener(this);
        this.mRetryClick = retryClick;
    }

    public void setLoadingHintTextId(int loadingInProcessId, int loadingFailedId) {
        this.mLoadingInProcessId = loadingInProcessId;
        this.mLoadingFailedId = loadingFailedId;
    }

    public void setVisible(boolean isVisible) {
        if (isVisible) {
            this.mStatusBar.setVisibility(0);
        } else {
            this.mStatusBar.setVisibility(8);
        }
    }

    public void setLoadSuccess() {
        this.mStatusBar.setVisibility(8);
    }

    public void setLoadInProcess(boolean hasData) {
        this.mStatusBar.setVisibility(0);
        this.mStatusProgressBar.setVisibility(0);
        this.mStatusHintTextView.setText(this.mLoadingInProcessId);
        this.mNoContentIndicatorView.setVisibility(8);
        this.mRetryButton.setVisibility(8);
        if (hasData) {
            this.mStatusHintTextView.setVisibility(8);
            this.mStatusBar.getLayoutParams().height = -2;
            this.mStatusBar.setBackgroundResource(C0329R.drawable.loading_view_bg);
        } else {
            this.mStatusHintTextView.setVisibility(0);
            this.mStatusBar.getLayoutParams().height = -1;
            this.mStatusBar.setBackgroundDrawable(null);
        }
        this.mStatusBar.requestLayout();
    }

    public void setLoadFailed() {
        this.mStatusBar.setVisibility(0);
        this.mStatusProgressBar.setVisibility(8);
        if (NetworkUtil.isActive(MusicApplication.getApplication())) {
            this.mStatusHintTextView.setText(this.mLoadingFailedId);
        } else {
            this.mStatusHintTextView.setText(C0329R.string.network_error);
        }
        this.mNoContentIndicatorView.setVisibility(0);
        this.mRetryButton.setVisibility(0);
    }

    public boolean isVisible() {
        return this.mStatusBar.getVisibility() == 0;
    }

    public void onClick(View v) {
        if (this.mRetryClick != null && this.mStatusProgressBar.getVisibility() != 0) {
            setLoadInProcess(false);
            this.mRetryClick.onClick(v);
        }
    }

    public void setTranslateY(float translationY) {
        this.mStatusBar.setTranslationY(translationY);
    }
}
