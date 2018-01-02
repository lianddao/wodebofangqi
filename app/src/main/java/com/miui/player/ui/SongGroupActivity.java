package com.miui.player.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import com.miui.player.C0329R;
import com.miui.player.meta.AlbumManager;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.service.ShakeListener;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.controller.TitleBarController;
import com.miui.player.ui.fragment.ListFragmentWithLoading;
import com.miui.player.ui.fragment.OnlineSongListFragment;
import com.miui.player.util.Actions;
import com.miui.player.util.ThreadManager.AsyncRequestCallback;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.model.SongGroup;
import com.xiaomi.music.util.MusicLog;
import miui.cache.RequestManager;
import miui.cache.RequestManager.Request;
import miui.v5.app.MiuiActionBar;
import miui.v5.view.ActionBarMovableLayout;
import miui.v5.view.ActionBarMovableLayout.Callback;
import miui.v5.view.ActionBarMovableLayout.OnScrollListener;

public class SongGroupActivity extends MusicBaseActivity implements Callback, OnScrollListener {
    private static final float ALBUM_INIT_TRANSLATION_Y;
    static final int MSG_UPDATE_BG = 1;
    private static final int SCROLL_RANGE;
    private static final String TAG = "SongGroupActivity";
    private static final String TAG_AUDIOS = "audios";
    static RequestManager<String, SongGroup, String> sRequestManager = null;
    private ImageView mAlbumBackground;
    final Handler mHandler = new C04613();
    private final AsyncRequestCallback<Bitmap> mImageRequester = new C04602();
    private OnlineSongListFragment mListFragment;
    private SongGroup mSongGroup;
    private String mSongGroupId;
    private TitleBarController mTitleBar;
    private ImageView mTopRoundCorner;

    class C04591 implements OnClickListener {
        C04591() {
        }

        public void onClick(View v) {
            UIHelper.startPlaybackView(SongGroupActivity.this);
        }
    }

    class C04602 extends AsyncRequestCallback<Bitmap> {
        C04602() {
        }

        public void run() {
            if (!SongGroupActivity.this.isFinishing()) {
                Bitmap bm = (Bitmap) getResult();
                if (bm != null) {
                    SongGroupActivity.this.mHandler.obtainMessage(1, bm).sendToTarget();
                }
            }
        }
    }

    class C04613 extends Handler {
        C04613() {
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (!SongGroupActivity.this.isFinishing()) {
                switch (msg.what) {
                    case 1:
                        SongGroupActivity.this.mAlbumBackground.setBackground(new BitmapDrawable(SongGroupActivity.this.getResources(), (Bitmap) msg.obj));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    class SongGroupRequest implements Request<String, SongGroup, String> {
        private final String mSongGroupId;

        public SongGroupRequest(String songGroupId) {
            this.mSongGroupId = songGroupId;
        }

        public String getKey() {
            return this.mSongGroupId;
        }

        public SongGroup computAsync() {
            Context context = MusicApplication.getApplication();
            Result<SongGroup> result = MusicEngine.get(context).getOnlineEngine().getSongGroup(context, this.mSongGroupId);
            if (result.mErrorCode == 1) {
                return (SongGroup) result.mData;
            }
            return null;
        }

        public void onCompleted(SongGroup value, boolean finalValue) {
            if (value != null && !value.equals(SongGroupActivity.this.mSongGroup)) {
                SongGroupActivity.this.mSongGroup = value;
                SongGroupActivity.this.mListFragment.updateSongGroup(SongGroupActivity.this.mSongGroup);
                SongGroupActivity.this.init(true);
            } else if (finalValue && SongGroupActivity.this.mSongGroup == null) {
                SongGroupActivity.this.mListFragment.setLoadFailed();
            }
        }

        public boolean needCache() {
            return true;
        }

        public boolean isRemovable() {
            return true;
        }

        public String getRemoveKey() {
            return this.mSongGroupId;
        }

        public void onRemoved() {
        }
    }

    static {
        Resources resources = MusicApplication.getApplication().getResources();
        ALBUM_INIT_TRANSLATION_Y = (float) ((-resources.getDimensionPixelOffset(101318691)) / 4);
        SCROLL_RANGE = resources.getDimensionPixelOffset(C0329R.dimen.online_tab_scroll_range);
    }

    protected void onCreateContent(Bundle icicle) {
        Bundle data = icicle != null ? icicle : getIntent().getExtras();
        if (data != null) {
            this.mSongGroup = (SongGroup) data.getSerializable(Actions.KEY_AUDIO_LIST_SONG_GROUP);
            this.mSongGroupId = data.getString(Actions.KEY_PLAYLIST_ONLINE_ID);
        }
        this.mTitleBar = new TitleBarController(this, findViewById(C0329R.id.title_bar));
        this.mTitleBar.setIcon(new BitmapDrawable(getResources(), OnlineMusicProxy.getProviderLogo(this)));
        this.mTitleBar.setToggle((int) C0329R.drawable.goto_nowplaying_large_title);
        this.mTitleBar.setToggleListener(new C04591());
        this.mAlbumBackground = (ImageView) findViewById(C0329R.id.album);
        this.mAlbumBackground.setTranslationY(ALBUM_INIT_TRANSLATION_Y);
        MiuiActionBar actionBar = getMiuiActionBar();
        actionBar.setFragmentViewPagerMode(this, getFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putInt(ListFragmentWithLoading.KEY_FRAGMETN_BACKGROUND, C0329R.drawable.online_pager_bg);
        actionBar.addFragmentTab(TAG_AUDIOS, actionBar.newTab(), OnlineSongListFragment.class, bundle, false);
        ActionBarMovableLayout actionBarMovableLayout = (ActionBarMovableLayout) findViewById(101384347);
        actionBarMovableLayout.setCallback(this);
        actionBarMovableLayout.setOnScrollListener(this);
        actionBarMovableLayout.setSpringBackEnabled(true);
        this.mListFragment = (OnlineSongListFragment) actionBar.getFragmentAt(0);
        this.mListFragment.setTranslateEnble(true);
        this.mTopRoundCorner = (ImageView) findViewById(C0329R.id.top_round_corner);
        init(false);
    }

    protected void onDestroyContent() {
        if (this.mTitleBar != null) {
            this.mTitleBar.destory();
        }
        super.onDestroyContent();
    }

    protected void onResume() {
        super.onResume();
        this.mTopRoundCorner.setVisibility(UIHelper.maskWindowCorner(this) ? 8 : 0);
    }

    protected boolean saveData(Bundle outcicle) {
        super.saveData(outcicle);
        outcicle.putSerializable(Actions.KEY_AUDIO_LIST_SONG_GROUP, this.mSongGroup);
        return true;
    }

    public boolean isContentVerticalScrolled() {
        ListView listView = this.mListFragment != null ? (ListView) this.mListFragment.getListView() : null;
        if (listView == null) {
            return false;
        }
        View view = listView.getChildAt(0);
        if (listView.getFirstVisiblePosition() == 0 && (view == null || view.getTop() == 0)) {
            return false;
        }
        return true;
    }

    public void onScrollBegin() {
    }

    public void onScrollEnd() {
    }

    public void onScroll(int state, float offset) {
        float deltaY = (offset - ShakeListener.ACCELATION_FACTOR_X) * ((float) SCROLL_RANGE);
        this.mAlbumBackground.setTranslationY(Math.min(ALBUM_INIT_TRANSLATION_Y, ALBUM_INIT_TRANSLATION_Y + (deltaY / 4.0f)));
        this.mListFragment.onTabTranslate(deltaY);
    }

    public void onFling(float distance, int duration) {
    }

    protected boolean needBindToService() {
        return false;
    }

    private void init(boolean forceLaunch) {
        if (this.mSongGroup != null) {
            updateTitle();
            Drawable d = getResources().getDrawable(C0329R.drawable.floating_view_src_def);
            AlbumManager.requestOnlineImageAsync(this, this.mSongGroup.getLargeImageUrl(), d.getIntrinsicWidth(), d.getIntrinsicHeight(), this.mImageRequester);
            this.mListFragment.requestAudioList(6, this.mSongGroup.mId, forceLaunch);
        }
    }

    private void updateTitle() {
        this.mTitleBar.setPrimaryText(this.mSongGroup.mName);
        this.mTitleBar.setSecondaryText(this.mSongGroup.mSubTitle);
    }

    private static RequestManager<String, SongGroup, String> getRequestManager() {
        if (sRequestManager == null) {
            sRequestManager = RequestManager.create(10, null);
            sRequestManager.setup(true);
        }
        return sRequestManager;
    }

    public boolean needLaunch() {
        return this.mSongGroup == null;
    }

    public void launch() {
        if (this.mSongGroup != null) {
            init(true);
        } else if (TextUtils.isEmpty(this.mSongGroupId)) {
            MusicLog.m395d(TAG, "song group id is null!");
            this.mListFragment.setLoadFailed();
        } else {
            getRequestManager().request(new SongGroupRequest(this.mSongGroupId));
        }
    }
}
