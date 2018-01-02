package com.miui.player.ui.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.miui.player.C0329R;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.controller.OnlineLoadingStatusBarController;
import com.xiaomi.music.online.model.MetaList;
import java.io.Serializable;

public abstract class ListFragmentWithLoading<E extends Serializable, D extends MetaList<E>> extends AsyncFragment<E, D> implements OnClickListener {
    private static final float INIT_TRANSLATE_Y_WITHOUT_DATA;
    private static final float INIT_TRANSLATE_Y_WITH_DATA;
    public static final String KEY_FRAGMETN_BACKGROUND = "fragment_background";
    private boolean mIsLoadingCompleted;
    OnlineLoadingStatusBarController mLoadingBar;
    private float mLoadingBarDeltaY;
    private Observer mObserver = null;
    private boolean mTranslateEnable = false;

    interface Observer {
        void update();
    }

    protected abstract int getLoadFailedId();

    protected abstract int getLoadInProcessId();

    static {
        Resources resources = MusicApplication.getApplication().getResources();
        INIT_TRANSLATE_Y_WITHOUT_DATA = (float) (-resources.getDimensionPixelOffset(C0329R.dimen.movable_action_bar_scroll_range));
        INIT_TRANSLATE_Y_WITH_DATA = INIT_TRANSLATE_Y_WITHOUT_DATA + ((float) resources.getDimensionPixelOffset(101318691));
    }

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int resId = bundle.getInt(KEY_FRAGMETN_BACKGROUND, 0);
            if (resId != 0) {
                view.setBackgroundResource(resId);
            }
        }
        this.mLoadingBar = new OnlineLoadingStatusBarController(view.findViewById(C0329R.id.online_loading_status_bar), this);
        this.mLoadingBar.setLoadingHintTextId(getLoadInProcessId(), getLoadFailedId());
        onTabTranslate(0.0f);
        updateLoadingBar(false);
    }

    public void onCompleted(D data, boolean isFinal) {
        super.onCompleted((MetaList) data, isFinal);
        if (this.mObserver != null && (isDataReady() || isFinal)) {
            this.mObserver.update();
        }
        if (this.mLoadingBar != null) {
            boolean z = isLastPage() && isFinal;
            this.mIsLoadingCompleted = z;
            if (this.mLoadingBar.isVisible()) {
                updateLoadingBar(isFinal);
            }
        }
    }

    protected void launch() {
        updateLoadingBar(false);
        super.launch();
    }

    public void onClick(View view) {
        launch();
    }

    private void updateLoadingBar(boolean isFinal) {
        if (this.mLoadingBar != null) {
            if (isLastPage() && isFinal) {
                if (isDataReady()) {
                    this.mList.setVisibility(0);
                    this.mLoadingBar.setLoadSuccess();
                } else {
                    this.mList.setVisibility(8);
                    this.mLoadingBar.setLoadFailed();
                }
            } else if (isDataReady()) {
                this.mList.setVisibility(0);
                if (needLoadingByPage()) {
                    this.mLoadingBar.setLoadInProcess(true);
                } else {
                    this.mLoadingBar.setLoadSuccess();
                }
            } else {
                this.mList.setVisibility(8);
                this.mLoadingBar.setLoadInProcess(false);
            }
            onTabTranslate(this.mLoadingBarDeltaY);
        }
    }

    public boolean isLoadingCompleted() {
        return this.mIsLoadingCompleted;
    }

    public void setObserver(Observer observer) {
        this.mObserver = observer;
    }

    public void setTranslateEnble(boolean enalbe) {
        this.mTranslateEnable = enalbe;
    }

    public void onTabTranslate(float deltaY) {
        if (this.mTranslateEnable && this.mLoadingBar != null) {
            this.mLoadingBarDeltaY = deltaY;
            if (isDataReady()) {
                this.mLoadingBar.setTranslateY(INIT_TRANSLATE_Y_WITH_DATA - deltaY);
            } else {
                this.mLoadingBar.setTranslateY((INIT_TRANSLATE_Y_WITHOUT_DATA - deltaY) / 2.0f);
            }
        }
    }

    public boolean isDataReady() {
        return this.mAdapter != null && this.mAdapter.hasContent();
    }

    public void setLoadFailed() {
        if (this.mLoadingBar != null) {
            this.mLoadingBar.setLoadFailed();
        }
    }
}
