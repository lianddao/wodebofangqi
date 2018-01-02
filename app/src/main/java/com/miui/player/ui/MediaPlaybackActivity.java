package com.miui.player.ui;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.music.player.StreamPlayer;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.In;
import com.miui.player.PlayerActions.Out;
import com.miui.player.meta.AlbumManager;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.meta.MediaFileManager;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.ID3Correcter;
import com.miui.player.network.ID3Correcter.AsyncCorrectID3Task;
import com.miui.player.network.ImageDownloader.AlbumUrlListGetTask;
import com.miui.player.network.ImageDownloader.ImageItemInfoList;
import com.miui.player.network.LyricDownloader;
import com.miui.player.network.LyricDownloader.LyricAsyncCallback;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.plugin.onlineimage.ImageItemInfo;
import com.miui.player.plugin.onlinelyric.LyricContent;
import com.miui.player.plugin.onlinelyric.LyricItemInfo;
import com.miui.player.plugin.onlinelyric.LyricProvider;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkEnvironment;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.OnlineAudioDetailHelper;
import com.miui.player.provider.PlayerProviderUtils;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.LyricManager;
import com.miui.player.service.ServiceHelper;
import com.miui.player.service.ShakeListener;
import com.miui.player.ui.SingleChoiceDialog.ICheckedCommond;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.controller.PlayerCommonController;
import com.miui.player.ui.controller.PlayerCommonController.RepeatClickCallback;
import com.miui.player.ui.controller.TimeIndicatorController;
import com.miui.player.ui.controller.TimeIndicatorController.OnProgressSeekListener;
import com.miui.player.ui.controller.TitleBarController;
import com.miui.player.ui.controller.ToolBar;
import com.miui.player.ui.fragment.AlbumFragment;
import com.miui.player.ui.fragment.LyricFragment;
import com.miui.player.ui.fragment.NowplayingBgFragment;
import com.miui.player.ui.fragment.TrackListFragment;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.ui.model.AlbumListAdapter;
import com.miui.player.util.FileOperations;
import com.miui.player.util.MusicAnalyticsUtils;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.ServiceActions;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Utils;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import miui.analytics.XiaomiAnalytics;
import miui.v5.android.support.app.FragmentPagerAdapter;
import miui.v5.android.support.view.PagerAdapter;
import miui.v5.android.support.view.ViewPager;
import miui.v5.widget.CooperativeViewPager;
import miui.v5.widget.PageChangeAdapter;
import miui.v5.widget.PageChangeAdapter.OnPageScrollListener;

public class MediaPlaybackActivity extends MusicBaseActivity implements OnPageScrollListener, DialogCallback {
    private static final int ALBUM_SEARCH = 37;
    private static final int ID3_EDIT = 38;
    public static final int INDEX_ALBUM = 1;
    public static final int INDEX_LIST = 0;
    public static final int INDEX_LYRIC = 2;
    static final int[] INDICATOR_ICONS = new int[]{C0329R.drawable.page_icon_left, C0329R.drawable.page_icon_mid, C0329R.drawable.page_icon_right};
    static final int[] INDICATOR_ICONS_DOUBLE = new int[]{C0329R.drawable.page_icon_left_double, C0329R.drawable.page_icon_right_double};
    private static final int LOCAL_ALBUM_SET = 39;
    private static final int LOCAL_LYRIC_SET = 40;
    private static final int LYRIC_PROGRESS_MODIFY = 43;
    private static final int MAX_CHOOSE_COUNT = 5;
    private static final int META_MODIFY = 36;
    static final int MSG_REFRESH = 1;
    public static final int PAGE_COUNT = 3;
    static final String PREF_KEY_LAST_PAGER = "last_pager";
    static final String PREF_KEY_LAST_PAGER_COUNT = "last_pager_count";
    static final int REFRESH_INTERVAL = 500;
    private static final int SAVE_AS_PLAYLIST = 34;
    private static final int SEND_TO = 41;
    private static final int SEND_TO_APPLICATION = 42;
    static final String TAG = MediaPlaybackActivity.class.getName();
    private static final String TAG_ALBUM = "album_fragment";
    private static final String TAG_LIST = "list_fragment";
    private static final String TAG_LYRIC = "lyric_fragment";
    private PlayerFragmentPagerAdapter mAdapter;
    AlbumFragment mAlbumFragment;
    NowplayingBgFragment mBackgroudFragment;
    private View mBottomLine;
    private AsyncCorrectID3Task mCorrectID3Task = null;
    ProgressDialog mDownloadFreezeDialog = null;
    final Handler mHandler = new C04342();
    private ImageView mImageIndicar;
    private File mLastLyricPickerDir;
    TrackListFragment mListFragment;
    private ImageView mLowerBottomMask;
    private ImageView mLowerTopMask;
    LyricFragment mLyricFragment;
    PlayerCommonController mPlayerCommonController;
    IMediaPlaybackService mService;
    private StreamPlayer mStreamPlayer;
    private TimeIndicatorController mTimeIndicator;
    private TitleBarController mTitleBar;
    ToolBar mToolBar;
    private boolean mToolBarHandled = false;
    private boolean mToolBarVisible = false;
    private View mTopLine;
    private TextView mTrackLink;
    private ImageView mUpperBottomMask;
    private ImageView mUpperTopMask;
    private CooperativeViewPager mViewPager;
    private WakeLock mWakeLock;

    class C04331 implements OnClickListener {
        C04331() {
        }

        public void onClick(View v) {
            MediaPlaybackActivity.this.updateFavorite(UIHelper.toggleCurrentAudioFavorite(MediaPlaybackActivity.this));
        }
    }

    class C04342 extends Handler {
        C04342() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    long next = MediaPlaybackActivity.this.refreshNow();
                    if (next > 0) {
                        MediaPlaybackActivity.this.queueNextRefresh(next);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C04353 implements OnClickListener {
        C04353() {
        }

        public void onClick(View v) {
            UIHelper.setViewAlpha(MediaPlaybackActivity.this.mTopLine, MediaPlaybackActivity.this.mToolBar.toggleState() ? ShakeListener.ACCELATION_FACTOR_X : 0.0f);
            MediaPlaybackActivity.this.showUserGuide();
        }
    }

    private class AlbumDownloadTask extends AlbumUrlListGetTask {
        private final long mAlbumId;
        private final boolean mModifyId3Success;
        private final String mOnlineId;
        private final long mTrackId;

        public AlbumDownloadTask(Context context, ImageSearchInfo metaInfo, ImageSearchInfo searchInfo, boolean modifyId3Success, long trackId, long albumId, String onlineId) {
            super(context, metaInfo, searchInfo);
            this.mModifyId3Success = modifyId3Success;
            this.mTrackId = trackId;
            this.mAlbumId = albumId;
            this.mOnlineId = onlineId;
        }

        protected ImageItemInfoList doInBackground(Void... params) {
            ImageItemInfoList result = super.doInBackground(params);
            if (this.mOnlineId != null) {
                String url = OnlineAudioDetailHelper.queryAlbumPictureURL(MusicApplication.getApplication(), this.mOnlineId);
                if (url != null) {
                    if (result == null || result.mContent == null) {
                        result = new ImageItemInfoList(new ArrayList(1), null);
                    }
                    result.mContent.add(0, new ImageItemInfo(url));
                }
            }
            return result;
        }

        public void onPostExecute(ImageItemInfoList result) {
            super.onPostExecute(result);
            if (MediaPlaybackActivity.this.mDownloadFreezeDialog == null || !MediaPlaybackActivity.this.mDownloadFreezeDialog.isShowing()) {
                MediaPlaybackActivity.this.mDownloadFreezeDialog = null;
                return;
            }
            MediaPlaybackActivity.this.mDownloadFreezeDialog.dismiss();
            MediaPlaybackActivity.this.mDownloadFreezeDialog = null;
            Uri localAlbumUri = AlbumManager.getAlbumUriForDB(MediaPlaybackActivity.this, this.mTrackId, this.mAlbumId);
            if (localAlbumUri != null) {
                if (result == null || result.mContent == null) {
                    result = new ImageItemInfoList(new ArrayList(1), null);
                }
                result.mContent.add(new ImageItemInfo(localAlbumUri.toString()));
            }
            if (result == null || result.mContent == null) {
                Toast.makeText(MediaPlaybackActivity.this, C0329R.string.album_search_failed, 0).show();
                return;
            }
            String album = this.mMetaInfo.mAlbumName;
            String artist = this.mMetaInfo.mArtistName;
            if (this.mModifyId3Success) {
                album = this.mSearchInfo.mAlbumName;
                artist = this.mSearchInfo.mArtistName;
            }
            if (!TextUtils.isEmpty(album) || !TextUtils.isEmpty(artist)) {
                String savePath = MetaManager.getMainSdcardFilePath(album, artist, "album");
                Intent intent = new Intent();
                intent.setClass(MediaPlaybackActivity.this.getApplication(), AlbumSearchResultActivity.class);
                intent.putExtra(AlbumSearchResultActivity.SEARCH_RESULT, result);
                intent.putExtra("save_path", savePath);
                intent.putExtra("album", album);
                intent.putExtra("artist", artist);
                intent.putExtra(AlbumSearchResultActivity.RAW_ALBUM_NAME, this.mMetaInfo.mAlbumName);
                intent.putExtra(AlbumSearchResultActivity.RAW_ARTIST_NAME, this.mMetaInfo.mAlbumName);
                MediaPlaybackActivity.this.startActivityForResult(intent, 37);
            }
        }
    }

    private class LyricAsyncChooseRunnable extends LyricAsyncCallback {
        final String mArtistName;
        final String mTrackName;

        public LyricAsyncChooseRunnable(String track, String artist) {
            this.mTrackName = track;
            this.mArtistName = artist;
        }

        public boolean isAutoChoose() {
            return false;
        }

        public void run() {
            ArrayList<LyricItemInfo> infoList = null;
            if (this.mInfoList != null) {
                infoList = new ArrayList(this.mInfoList.size());
                for (LyricItemInfo info : this.mInfoList) {
                    infoList.add(info);
                }
            }
            MediaPlaybackActivity.this.mHandler.post(new LyricChooseRunnable(this.mTrackName, this.mArtistName, this.mProvider, infoList));
        }
    }

    private class LyricChooseRunnable implements Runnable {
        final String mArtistName;
        final List<LyricItemInfo> mInfoList;
        final LyricProvider mProvider;
        final String mTrackName;

        class C04361 implements ICheckedCommond {
            C04361() {
            }

            public void excute(CharSequence[] items, int which) {
                if (which >= 0 && which < LyricChooseRunnable.this.mInfoList.size() && MediaPlaybackActivity.this.showDownloadDialog(C0329R.string.lrc_searching)) {
                    LyricDownloader.download(LyricChooseRunnable.this.mProvider, (LyricItemInfo) LyricChooseRunnable.this.mInfoList.get(which), new LyricSaveRunnable(LyricChooseRunnable.this.mTrackName, LyricChooseRunnable.this.mArtistName));
                }
            }
        }

        public LyricChooseRunnable(String track, String artist, LyricProvider provider, List<LyricItemInfo> infoList) {
            this.mTrackName = track;
            this.mArtistName = artist;
            this.mProvider = provider;
            this.mInfoList = infoList;
        }

        public void run() {
            if (MediaPlaybackActivity.this.mDownloadFreezeDialog != null && MediaPlaybackActivity.this.mDownloadFreezeDialog.isShowing()) {
                MediaPlaybackActivity.this.mDownloadFreezeDialog.dismiss();
                MediaPlaybackActivity.this.mDownloadFreezeDialog = null;
            }
            if (this.mInfoList == null || this.mInfoList.isEmpty()) {
                Toast.makeText(MediaPlaybackActivity.this, C0329R.string.lrc_search_failed, 0).show();
                return;
            }
            while (this.mInfoList.size() > 5) {
                this.mInfoList.remove(this.mInfoList.size() - 1);
            }
            CharSequence[] names = new CharSequence[this.mInfoList.size()];
            for (int i = 0; i < this.mInfoList.size(); i++) {
                LyricItemInfo item = (LyricItemInfo) this.mInfoList.get(i);
                String artist = item.getArtist();
                String str = "%s %s";
                Object[] objArr = new Object[2];
                objArr[0] = item.getTrack();
                if (artist == null) {
                    artist = MetaManager.UNKNOWN_STRING;
                }
                objArr[1] = artist;
                names[i] = String.format(str, objArr);
            }
            new SingleChoiceDialog(names, new C04361(), MediaPlaybackActivity.this, -1, C0329R.string.lrc_select).show();
        }
    }

    private class LyricSaveRunnable extends LyricAsyncCallback {
        private final String mArtistName;
        private final String mTrackName;

        public LyricSaveRunnable(String track, String artist) {
            this.mTrackName = track;
            this.mArtistName = artist;
        }

        public boolean isAutoChoose() {
            return true;
        }

        public void run() {
            LyricContent content = null;
            if (!(this.mInfoList == null || this.mInfoList.isEmpty())) {
                content = ((LyricItemInfo) this.mInfoList.get(0)).getContent();
            }
            if (content != null) {
                LyricManager.saveLyricFile(MediaPlaybackActivity.this.getApplication(), this.mTrackName, this.mArtistName, content);
            }
            final LyricContent lyric = content;
            MediaPlaybackActivity.this.mHandler.post(new Runnable() {
                public void run() {
                    if (MediaPlaybackActivity.this.mDownloadFreezeDialog != null && MediaPlaybackActivity.this.mDownloadFreezeDialog.isShowing()) {
                        MediaPlaybackActivity.this.mDownloadFreezeDialog.dismiss();
                        MediaPlaybackActivity.this.mDownloadFreezeDialog = null;
                    }
                    if (lyric == null) {
                        Toast.makeText(MediaPlaybackActivity.this, C0329R.string.lrc_search_failed, 0).show();
                    } else {
                        MediaPlaybackActivity.this.requestUpdate("lyric");
                    }
                }
            });
        }
    }

    class OnPlayerSeekListener implements OnProgressSeekListener {
        OnPlayerSeekListener() {
        }

        public void seek(int progress, int max) {
            if (MediaPlaybackActivity.this.mService != null) {
                try {
                    MediaPlaybackActivity.this.mService.seek((((long) progress) * MediaPlaybackActivity.this.mService.duration()) / ((long) max));
                    if (!MediaPlaybackActivity.this.mService.isPlaying()) {
                        MediaPlaybackActivity.this.refreshNow();
                    }
                } catch (RemoteException e) {
                }
            }
        }
    }

    class OnRepeatClickListener implements RepeatClickCallback {
        OnRepeatClickListener() {
        }

        public void update() {
            MediaPlaybackActivity.this.refreshTimeIndicator();
        }
    }

    private class PlayerFragmentPagerAdapter extends FragmentPagerAdapter {
        public PlayerFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            position = MediaPlaybackActivity.this.adjustPosition(position);
            switch (position) {
                case 0:
                    return MediaPlaybackActivity.this.mListFragment;
                case 1:
                    return MediaPlaybackActivity.this.mAlbumFragment;
                case 2:
                    return MediaPlaybackActivity.this.mLyricFragment;
                default:
                    throw new IllegalArgumentException("Out of range, position=" + position);
            }
        }

        public int getCount() {
            return MediaPlaybackActivity.this.mListFragment != null ? 3 : 2;
        }

        public int getItemPosition(Object object) {
            int position = -2;
            if (object == MediaPlaybackActivity.this.mAlbumFragment) {
                position = 1;
            } else if (object == MediaPlaybackActivity.this.mLyricFragment) {
                position = 2;
            } else if (object == MediaPlaybackActivity.this.mListFragment) {
                position = 0;
            }
            if (position == -2 || MediaPlaybackActivity.this.mListFragment != null) {
                return position;
            }
            return position - 1;
        }
    }

    protected void onCreateContent(Bundle icicle) {
        super.onCreateContent(icicle);
        BaiduSdkEnvironment.getInstance().initialize();
        this.mWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(536870922, TAG);
        setContentView(C0329R.layout.media_player);
        this.mTopLine = findViewById(C0329R.id.divider_line_top);
        this.mBottomLine = findViewById(C0329R.id.divider_line_bottom);
        this.mBackgroudFragment = (NowplayingBgFragment) getFragmentManager().findFragmentById(C0329R.id.background_fragment);
        this.mUpperTopMask = (ImageView) findViewById(C0329R.id.nowplaying_upper_top_mask);
        this.mUpperBottomMask = (ImageView) findViewById(C0329R.id.nowplaying_upper_bottom_mask);
        this.mLowerTopMask = (ImageView) findViewById(C0329R.id.nowplaying_lower_top_mask);
        this.mLowerBottomMask = (ImageView) findViewById(C0329R.id.nowplaying_lower_bottom_mask);
        this.mImageIndicar = (ImageView) findViewById(C0329R.id.page_indicator);
        this.mViewPager = (CooperativeViewPager) findViewById(101384373);
        this.mViewPager.setOnPageChangeListener(new PageChangeAdapter(this.mViewPager, this));
        initFragments();
        this.mAdapter = new PlayerFragmentPagerAdapter(getFragmentManager());
        this.mViewPager.setAdapter(this.mAdapter);
        updatePageCount();
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setCustomView(C0329R.layout.media_playback_activity_title_bar);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setBackgroundDrawable(null);
        this.mTitleBar = new TitleBarController(this, actionBar.getCustomView());
        this.mTitleBar.setToggleListener(new C04331());
        View bottomBar = findViewById(C0329R.id.bottom_bar);
        this.mPlayerCommonController = new PlayerCommonController(bottomBar, new OnRepeatClickListener(), new OnPlayerSeekListener(), C0329R.drawable.nowplaying_play_selector, C0329R.drawable.nowplaying_pause_selector, C0329R.drawable.nowplaying_prev_selector, C0329R.drawable.nowplaying_next_selector);
        this.mTimeIndicator = new TimeIndicatorController(bottomBar, new OnPlayerSeekListener());
        this.mToolBar = new ToolBar(this, findViewById(C0329R.id.tool_bar));
        this.mToolBar.setVisible(false);
        this.mTrackLink = (TextView) findViewById(C0329R.id.track_link);
        Intent intent = getIntent();
        if ("com.miui.player.NOWPLAYING_PLAYLIST".equals(intent != null ? intent.getAction() : null)) {
            this.mViewPager.setCurrentItem(0);
            saveLastPager(this, this.mViewPager);
        } else if (!restoreLastPager(this, this.mViewPager)) {
            updateBackground(this.mViewPager.getCurrentItem());
        }
        XiaomiAnalytics analytics = XiaomiAnalytics.getInstance();
        analytics.startSession(this);
        analytics.trackEvent(MusicAnalyticsUtils.EVENT_CREATE_NOWPLAYING_PAGE);
        analytics.endSession();
    }

    protected void onDestroyContent() {
        if (this.mStreamPlayer != null) {
            try {
                this.mStreamPlayer.release();
            } catch (Throwable t) {
                MusicLog.m398e(TAG, "Internal error in baidu SDK!", t);
            }
            this.mStreamPlayer = null;
        }
        saveLastPager(this, this.mViewPager);
        if (this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
        this.mTitleBar.destory();
        super.onDestroyContent();
    }

    protected void onResume() {
        super.onResume();
        if (PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_SCREEN_BRIGHT_WAKE)) {
            this.mWakeLock.acquire();
        }
        this.mToolBar.onResume();
        updateTrackInfo();
        this.mPlayerCommonController.refresh();
        queueNextRefresh(refreshNow());
        updateListFragment();
    }

    protected void onPause() {
        if (this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
        this.mToolBar.onPause();
        super.onPause();
    }

    protected boolean saveData(Bundle outcicle) {
        super.saveData(outcicle);
        if (this.mListFragment != null) {
            this.mListFragment.saveData(outcicle);
        }
        Intent intent = getIntent();
        if (intent != null) {
            String action = intent.getAction();
            if (action != null) {
                outcicle.putString("old_activity_action", action);
            }
        }
        return true;
    }

    void refreshTimeIndicator() {
        if (this.mService != null) {
            try {
                this.mTimeIndicator.refresh(this.mService.position(), this.mService.duration(), this.mService.getBufferedPercent(), this.mService.isPlaying(), this.mService.isBuffering(), true);
            } catch (RemoteException e) {
            }
        }
    }

    protected String[] getObservedServiceActions() {
        return new String[]{Out.STATUS_META_CHANGED, Out.STATUS_PLAYSTATE_CHANGED, Out.STATUS_PLAYBACK_COMPLETE, Out.STATUS_REFRESH_PROGRESS, Out.STATUS_QUEUE_CHANGED, Out.STATUS_SHOW_LINK_CHANGED};
    }

    protected void handleServiceConnected(IMediaPlaybackService service) throws RemoteException {
        super.handleServiceConnected(service);
        this.mService = service;
        updateListFragment();
        if (this.mListFragment != null) {
            this.mListFragment.setService(service);
        }
        this.mLyricFragment.setService(service);
        this.mBackgroudFragment.setService(service);
        this.mToolBar.setService(service);
        this.mToolBar.refreshRepeatMode();
        this.mPlayerCommonController.refresh();
        updateTrackInfo();
        queueNextRefresh(refreshNow());
        this.mTitleBar.setService(service);
    }

    protected void handleServiceDisconnected() {
        if (this.mListFragment != null) {
            this.mListFragment.setService(null);
        }
        this.mLyricFragment.setService(null);
        this.mBackgroudFragment.setService(null);
        this.mService = null;
    }

    protected void handleServiceNotification(Intent intent) {
        super.handleServiceNotification(intent);
        if (this.mService != null) {
            String action = intent.getAction();
            if (action.equals(Out.STATUS_META_CHANGED)) {
                refreshTimeIndicator();
                if (Out.META_CHANGED_TRACK.equals(intent.getStringExtra(Out.KEY_OTHER))) {
                    updateTrackInfo();
                }
            } else if (action.equals(Out.STATUS_PLAYBACK_COMPLETE)) {
                this.mPlayerCommonController.refresh();
                refreshTimeIndicator();
            } else if (action.equals(Out.STATUS_PLAYSTATE_CHANGED)) {
                this.mPlayerCommonController.refresh();
                refreshTimeIndicator();
            } else if (action.equals(Out.STATUS_QUEUE_CHANGED)) {
                if (ServiceHelper.isMusicLoaded()) {
                    updateListFragment();
                    this.mPlayerCommonController.refresh();
                } else {
                    finish();
                    return;
                }
            } else if (action.equals(Out.STATUS_SHOW_LINK_CHANGED)) {
                updateTrackInfo();
            }
            if (isResumed()) {
                queueNextRefresh(refreshNow());
            }
        }
    }

    private void updateTrackInfo() {
        boolean isThirdLink = false;
        String showLink = null;
        if (this.mService != null && isResumed()) {
            try {
                showLink = this.mService.getShowLink();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(showLink)) {
            this.mTrackLink.setVisibility(4);
        } else {
            this.mTrackLink.setVisibility(0);
            this.mTrackLink.setText(getString(C0329R.string.source_from, new Object[]{showLink}));
            isThirdLink = true;
        }
        updateTitleBar(isThirdLink);
    }

    private void updateTitleBar(boolean isThirdLink) {
        if (this.mService != null) {
            try {
                this.mTitleBar.setPrimaryText(this.mService.getTrackName());
                CharSequence channel = this.mService.getChannelName();
                if (channel == null) {
                    this.mTitleBar.setSecondaryText(this.mService.getAlbumName());
                    this.mTitleBar.setTertiaryText(this.mService.getArtistName());
                } else {
                    this.mTitleBar.setSecondaryText(this.mService.getArtistName());
                    this.mTitleBar.setTertiaryText(channel);
                }
                String onlineId = this.mService.getOnlineId();
                if (onlineId == null || isThirdLink) {
                    this.mTitleBar.setIcon(null);
                } else {
                    this.mTitleBar.setIcon(new BitmapDrawable(getResources(), OnlineMusicProxy.getProviderLogo(this)));
                }
                this.mTitleBar.refreshBitRateIcon(onlineId != null);
                this.mTitleBar.showUserGuide();
                updateFavorite(FavoriteCache.contains(this, this.mService.getAudioId(), this.mService.getOnlineId()));
            } catch (RemoteException e) {
            }
        }
    }

    private void updateFavorite(boolean favorite) {
        this.mTitleBar.setToggle(favorite ? C0329R.drawable.nowplaying_favorite_on : C0329R.drawable.nowplaying_favorite_off);
    }

    long refreshNow() {
        boolean isPlaying = false;
        IMediaPlaybackService service = this.mService;
        if (service != null) {
            try {
                isPlaying = service.isPlaying();
                this.mTimeIndicator.refresh(service.position(), service.duration(), service.getBufferedPercent(), isPlaying, service.isBuffering(), false);
            } catch (RemoteException e) {
            }
        }
        return isPlaying ? 500 : -1;
    }

    void queueNextRefresh(long delay) {
        if (isResumed() && this.mService != null && delay > 0) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), delay);
        }
    }

    private static void saveLastPager(Context context, ViewPager pager) {
        if (pager != null) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            PagerAdapter adapter = pager.getAdapter();
            if (adapter != null) {
                sp.edit().putInt(PREF_KEY_LAST_PAGER, pager.getCurrentItem()).putInt(PREF_KEY_LAST_PAGER_COUNT, adapter.getCount()).apply();
            }
        }
    }

    private static boolean restoreLastPager(Context context, ViewPager pager) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        int last = sp.getInt(PREF_KEY_LAST_PAGER, 1);
        int lastCount = sp.getInt(PREF_KEY_LAST_PAGER_COUNT, 3);
        if (last < 0 || last >= pager.getAdapter().getCount() || last == pager.getCurrentItem() || lastCount != pager.getAdapter().getCount()) {
            return false;
        }
        pager.setCurrentItem(last);
        return true;
    }

    private void initFragments() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        int pagerId = this.mViewPager.getId();
        this.mLyricFragment = (LyricFragment) fm.findFragmentByTag(TAG_LYRIC);
        if (this.mLyricFragment == null) {
            this.mLyricFragment = new LyricFragment();
            transaction.add(pagerId, this.mLyricFragment, TAG_LYRIC);
        }
        transaction.hide(this.mLyricFragment);
        this.mAlbumFragment = (AlbumFragment) fm.findFragmentByTag(TAG_ALBUM);
        if (this.mAlbumFragment == null) {
            this.mAlbumFragment = new AlbumFragment();
            transaction.add(pagerId, this.mAlbumFragment, TAG_ALBUM);
        }
        transaction.hide(this.mAlbumFragment);
        transaction.commit();
        this.mAlbumFragment.setOnClickListener(new C04353());
        if (this.mService != null) {
            this.mLyricFragment.setService(this.mService);
            this.mBackgroudFragment.setService(this.mService);
        }
    }

    private void updatePageCount() {
        this.mBackgroudFragment.setPageCount(this.mAdapter.getCount());
    }

    private void updateListFragment() {
        if (this.mService != null) {
            try {
                FragmentTransaction transaction;
                if (this.mService.getChannelName() == null) {
                    if (this.mListFragment == null) {
                        transaction = getFragmentManager().beginTransaction();
                        int pagerId = this.mViewPager.getId();
                        this.mListFragment = (TrackListFragment) getFragmentManager().findFragmentByTag(TAG_LIST);
                        if (this.mListFragment == null) {
                            this.mListFragment = new TrackListFragment();
                            transaction.add(pagerId, this.mListFragment, TAG_LIST);
                        }
                        this.mListFragment.setService(this.mService);
                        transaction.hide(this.mListFragment);
                        transaction.commitAllowingStateLoss();
                        this.mAdapter.notifyDataSetChanged();
                        updatePageCount();
                        if (!restoreLastPager(this, this.mViewPager)) {
                            updateBackground(this.mViewPager.getCurrentItem());
                            return;
                        }
                        return;
                    }
                    this.mListFragment.launchLoader(true);
                } else if (this.mListFragment != null) {
                    transaction = getFragmentManager().beginTransaction();
                    transaction.remove(this.mListFragment);
                    transaction.commitAllowingStateLoss();
                    this.mListFragment = null;
                    this.mAdapter.notifyDataSetChanged();
                    updatePageCount();
                    updateBackground(this.mViewPager.getCurrentItem());
                }
            } catch (RemoteException e) {
            }
        }
    }

    int adjustPosition(int pos) {
        if (this.mListFragment == null) {
            return pos + 1;
        }
        return pos;
    }

    public void updateBackground(int position) {
        if (this.mListFragment != null) {
            this.mImageIndicar.setImageResource(INDICATOR_ICONS[position]);
        } else {
            this.mImageIndicar.setImageResource(INDICATOR_ICONS_DOUBLE[position]);
        }
        float alpha = adjustPosition(position) == 1 ? 0.0f : ShakeListener.ACCELATION_FACTOR_X;
        setLineAlpha(alpha);
        this.mBackgroudFragment.setMaskAlpha(alpha);
        this.mBackgroudFragment.setPostion(position);
        if (adjustPosition(position) == 0) {
            updateMask(0.0f);
        } else {
            updateMask(ShakeListener.ACCELATION_FACTOR_X);
        }
    }

    public void onReset(ViewPager pager, int from, int to) {
        updateBackground(to);
        this.mToolBarHandled = false;
        if (adjustPosition(to) == 1 && this.mToolBarVisible) {
            this.mToolBar.setVisible(true);
            UIHelper.setViewAlpha(this.mTopLine, ShakeListener.ACCELATION_FACTOR_X);
        }
        invalidateOptionsMenu();
        saveLastPager(this, this.mViewPager);
    }

    public void onScroll(ViewPager pager, int from, int to, float percent) {
        this.mBackgroudFragment.scrollX(from, to, percent);
        from = adjustPosition(from);
        to = adjustPosition(to);
        if (from == 1 && !this.mToolBarHandled) {
            this.mToolBarHandled = true;
            this.mToolBarVisible = this.mToolBar.isVisible();
            this.mToolBar.setVisible(false);
        }
        float alpha;
        if (to == 1) {
            alpha = ShakeListener.ACCELATION_FACTOR_X - percent;
            setLineAlpha(alpha);
            this.mBackgroudFragment.setMaskAlpha(alpha);
        } else if (from == 1) {
            alpha = percent;
            setLineAlpha(alpha);
            this.mBackgroudFragment.setMaskAlpha(alpha);
        }
        if (to == 0 && this.mListFragment != null) {
            updateMask(ShakeListener.ACCELATION_FACTOR_X - percent);
            try {
                this.mListFragment.setListSelectedPosition(Math.max(0, this.mService.getQueuePosition() - 2));
            } catch (RemoteException e) {
            }
        } else if (from == 0 && this.mListFragment != null) {
            updateMask(percent);
        }
    }

    private void setLineAlpha(float alpha) {
        UIHelper.setViewAlpha(this.mTopLine, alpha);
        UIHelper.setViewAlpha(this.mBottomLine, alpha);
    }

    private void updateMask(float upperAlpha) {
        UIHelper.setViewAlpha(this.mUpperTopMask, upperAlpha);
        UIHelper.setViewAlpha(this.mUpperBottomMask, upperAlpha);
        UIHelper.setViewAlpha(this.mLowerTopMask, ShakeListener.ACCELATION_FACTOR_X - upperAlpha);
        UIHelper.setViewAlpha(this.mLowerBottomMask, ShakeListener.ACCELATION_FACTOR_X - upperAlpha);
    }

    public void onActionModeStarted(ActionMode mode) {
        super.onActionModeStarted(mode);
        this.mPlayerCommonController.setEnabled(false);
        this.mViewPager.setDraggable(false);
    }

    public void onActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);
        this.mPlayerCommonController.setEnabled(true);
        this.mViewPager.setDraggable(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 10, 0, C0329R.string.delete_item);
        menu.addSubMenu(0, 1, 0, C0329R.string.add_to_playlist);
        SubMenu subMeta = menu.addSubMenu(0, 36, 0, C0329R.string.modify_meta);
        if (Utils.isOnlineVaild()) {
            subMeta.add(1, 22, 0, C0329R.string.correct_id3_by_internet);
        }
        subMeta.add(1, 21, 0, C0329R.string.id3_edit);
        if (Utils.isOnlineVaild()) {
            subMeta.add(1, 23, 0, C0329R.string.lyric_download);
        }
        subMeta.add(1, 24, 0, C0329R.string.use_local_lyric);
        if (Utils.isOnlineVaild()) {
            subMeta.add(1, 25, 0, C0329R.string.album_download);
        }
        subMeta.add(1, 26, 0, C0329R.string.use_local_album);
        subMeta.add(1, LYRIC_PROGRESS_MODIFY, 0, C0329R.string.lrc_progress_modify);
        subMeta = menu.addSubMenu(0, SEND_TO, 0, C0329R.string.send_to);
        subMeta.add(0, 2, 0, C0329R.string.ringtone_menu);
        subMeta.add(0, SEND_TO_APPLICATION, 0, C0329R.string.send_to_application);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.mService == null) {
            return false;
        }
        if (!Utils.isExternalStorageMounted()) {
            return false;
        }
        long audioId = ServiceHelper.getCurrentAudioId();
        if (audioId < 0) {
            return false;
        }
        long localId = -1;
        String tr = null;
        String ar = null;
        String al = null;
        try {
            tr = this.mService.getTrackName();
            ar = this.mService.getArtistName();
            al = this.mService.getAlbumName();
            localId = PlayerProviderUtils.getDownloadedAudioId(this, tr, ar, audioId);
        } catch (RemoteException e) {
        }
        Intent extra = new Intent();
        extra.putExtra(In.KEY_LOACAL_ID, localId);
        extra.putExtra("audio_id", audioId);
        MenuItem item = menu.findItem(10);
        if (item != null) {
            item.setVisible(localId > 0).setIntent(extra);
        }
        item = menu.findItem(21);
        if (item != null) {
            item.setVisible(localId >= 0);
        }
        item = menu.findItem(22);
        if (item != null) {
            item.setVisible(localId >= 0).setIntent(extra);
        }
        item = menu.findItem(23);
        if (item != null) {
            item.setVisible(localId >= 0).setIntent(extra);
        }
        item = menu.findItem(24);
        if (item != null) {
            boolean z = (TextUtils.isEmpty(ar) && TextUtils.isEmpty(tr)) ? false : true;
            item.setVisible(z);
        }
        item = menu.findItem(25);
        if (item != null) {
            item.setVisible(localId >= 0).setIntent(extra);
        }
        item = menu.findItem(26);
        if (item != null) {
            z = (TextUtils.isEmpty(ar) && TextUtils.isEmpty(al)) ? false : true;
            item.setVisible(z);
        }
        item = menu.findItem(LYRIC_PROGRESS_MODIFY);
        if (item != null) {
            z = this.mViewPager.getCurrentItem() == 2 && this.mLyricFragment.hasLyric();
            item.setVisible(z);
        }
        item = menu.findItem(2);
        if (item != null) {
            item.setVisible(localId >= 0).setIntent(extra);
        }
        SubMenu subPlaylist = menu.findItem(1).getSubMenu();
        if (subPlaylist != null) {
            UIHelper.makePlaylistMenu(this, subPlaylist, extra);
        }
        item = menu.findItem(SEND_TO_APPLICATION);
        if (item != null) {
            item.setVisible(localId >= 0).setIntent(extra);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        long localId = -1;
        if (this.mService == null) {
            return false;
        }
        Intent extra = item.getIntent();
        if (extra != null) {
            localId = extra.getLongExtra(In.KEY_LOACAL_ID, -1);
        }
        try {
            switch (item.getItemId()) {
                case 2:
                    if (Utils.isSupportAsRingtone(this.mService.getAbsolutePath())) {
                        UIHelper.setRingtone(this, localId);
                    } else {
                        Toast.makeText(this, C0329R.string.ringtone_not_support, 0).show();
                    }
                    return true;
                case 3:
                    PlaylistHelper.addToPlaylist(this, new long[]{this.mService.getAudioId()}, item.getIntent().getLongExtra(UIHelper.DST_PLAYLIST_KEY, -1), true);
                    return true;
                case 4:
                    OperationDialog.makePlaylistCreator(this, this, 4, null).show();
                    return true;
                case 10:
                    long[] list = new long[]{localId};
                    Bundle b = new Bundle();
                    b.putString("description", getString(C0329R.string.delete_song_desc, new Object[]{this.mService.getTrackName()}));
                    b.putLongArray(CloudJsonTag.TAG_ITEMS, list);
                    DeleteItems.show(this, list, null, 1, this, 10);
                    return true;
                case BaseMenuId.EDIT_ID3 /*21*/:
                    showDialogForID3Edit();
                    return true;
                case BaseMenuId.CORRECT_ID3 /*22*/:
                    startTaskForID3Correct(localId);
                    return true;
                case BaseMenuId.SEARCH_LYRIC /*23*/:
                    showDialogForLyricSearch(localId);
                    return true;
                case BaseMenuId.USE_LOCAL_LYRIC /*24*/:
                    startPickerForLyric();
                    return true;
                case 25:
                    showDialogForAlbumSearch(localId);
                    return true;
                case BaseMenuId.USE_LOCAL_ALBUM /*26*/:
                    startPickerForAlbum();
                    return true;
                case 34:
                    OperationDialog.makePlaylistCreator(this, this, 34, null).show();
                    return true;
                case SEND_TO_APPLICATION /*42*/:
                    if (localId >= 0) {
                        UIHelper.sendByChooser(this, localId);
                    }
                    return true;
                case LYRIC_PROGRESS_MODIFY /*43*/:
                    if (!this.mLyricFragment.enterLyricEditMode()) {
                        Toast.makeText(this, C0329R.string.lrc_search_failed, 0).show();
                    }
                    return true;
            }
        } catch (RemoteException e) {
        }
        return super.onOptionsItemSelected(item);
    }

    public void onDialogResult(int requestCode, boolean confirm, Intent intent) {
        Uri uri;
        switch (requestCode) {
            case 4:
                if (confirm) {
                    uri = intent.getData();
                    if (uri != null) {
                        PlaylistHelper.addToPlaylist(this, new long[]{ServiceHelper.getCurrentAudioId()}, (long) Integer.parseInt(uri.getLastPathSegment()), true);
                        return;
                    }
                    return;
                }
                return;
            case BaseMenuId.SEARCH_LYRIC /*23*/:
                if (confirm && intent != null) {
                    startLyricSearchTask(intent);
                    return;
                }
                return;
            case 34:
                if (confirm) {
                    uri = intent.getData();
                    if (uri != null && this.mService != null) {
                        try {
                            PlaylistHelper.addToPlaylist(this, this.mService.getQueue(), (long) Integer.parseInt(uri.getLastPathSegment()), true, false);
                            return;
                        } catch (RemoteException e) {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 37:
                if (confirm && intent != null) {
                    startAlbumSearchTask(intent);
                    return;
                }
                return;
            case 38:
                if (confirm && intent != null) {
                    editId3(intent);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (this.mService != null && intent != null && resultCode == -1) {
            switch (requestCode) {
                case 37:
                    try {
                        requestUpdateAlbum(intent);
                        return;
                    } catch (RemoteException e) {
                        return;
                    }
                case LOCAL_ALBUM_SET /*39*/:
                    setLocalFileAsAlbum(intent);
                    return;
                case LOCAL_LYRIC_SET /*40*/:
                    setLocalFileAsLyric(intent);
                    return;
                default:
                    return;
            }
        }
    }

    boolean showDownloadDialog(int titleId) {
        if (this.mDownloadFreezeDialog != null) {
            return false;
        }
        this.mDownloadFreezeDialog = UIHelper.showDownloadDialog(this, titleId);
        return true;
    }

    void requestUpdate(String command) {
        Intent intent = new Intent(ServiceActions.In.UPDATE_META_ACTION);
        intent.putExtra(ServiceActions.In.CMDNAME, command);
        sendBroadcast(intent);
    }

    private void showDialogForID3Edit() throws RemoteException {
        if (Utils.isSupportID3(this.mService.getAbsolutePath())) {
            Bundle editID3Bundle = new Bundle();
            editID3Bundle.putString(MediaEditDialog.DIALOG_TITLE, getString(C0329R.string.id3_edit));
            String album = this.mService.getAlbumName();
            String artist = this.mService.getArtistName();
            String track = this.mService.getTrackName();
            String filePath = this.mService.getPath();
            editID3Bundle.putString(MediaEditDialog.RAW_ALBUM_NAME, MetaManager.getRawName(album));
            editID3Bundle.putString(MediaEditDialog.RAW_ARTIST_NAME, MetaManager.getRawName(artist));
            editID3Bundle.putString(MediaEditDialog.RAW_TRACK_NAME, track);
            editID3Bundle.putString(MediaEditDialog.RAW_FILE_PATH, filePath);
            editID3Bundle.putBoolean(MediaEditDialog.MODIFY_ID3_ENABLED, false);
            new MediaEditDialog(this, editID3Bundle, this, 38).show();
            return;
        }
        Toast.makeText(this, C0329R.string.correct_id3_not_support, 0).show();
    }

    private void startTaskForID3Correct(long localId) throws RemoteException {
        if (this.mCorrectID3Task != null) {
            this.mCorrectID3Task.cancel(true);
        }
        String trackPath = this.mService.getAbsolutePath();
        this.mCorrectID3Task = ID3Correcter.startTaskForID3Correct(this, new String[]{trackPath}, new long[]{localId}, true, true);
    }

    private boolean editId3(Intent intent) {
        String editTrack = intent.getStringExtra(MediaEditDialog.NEW_TRACK_NAME);
        String editArtist = intent.getStringExtra(MediaEditDialog.NEW_ARTIST_NAME);
        String editAlbum = intent.getStringExtra(MediaEditDialog.NEW_ALBUM_NAME);
        String filePath = intent.getStringExtra(MediaEditDialog.RAW_FILE_PATH);
        String rawTrack = intent.getStringExtra(MediaEditDialog.RAW_TRACK_NAME);
        String rawArtist = intent.getStringExtra(MediaEditDialog.RAW_ARTIST_NAME);
        String rawAlbum = intent.getStringExtra(MediaEditDialog.RAW_ALBUM_NAME);
        if (editTrack.equals(rawTrack) && editArtist.equals(rawArtist) && (editAlbum.equals(rawAlbum) || TextUtils.isEmpty(editAlbum))) {
            return false;
        }
        Uri fileUri = SqlUtils.translateToFileUri(this, Uri.parse(filePath));
        if (fileUri == null) {
            return false;
        }
        boolean isModifyed = MediaFileManager.correctID3(this, new File(fileUri.getPath()), editTrack, editArtist, editAlbum);
        if (isModifyed) {
            return isModifyed;
        }
        Toast.makeText(this, C0329R.string.id3_edit_failed, 0).show();
        return isModifyed;
    }

    private void startPickerForAlbum() throws RemoteException {
        try {
            MetaManager.makeDirIfNotExists(this, "album");
            String album = this.mService.getAlbumName();
            String artist = this.mService.getArtistName();
            if (!TextUtils.isEmpty(album) || !TextUtils.isEmpty(artist)) {
                String path = MetaManager.getMainSdcardFilePath(album, artist, "album");
                Intent intent = new Intent("android.intent.action.GET_CONTENT", null);
                intent.setType("image/*");
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", this.mBackgroudFragment.getAlbumViewWidth());
                intent.putExtra("aspectY", this.mBackgroudFragment.getAlbumViewHeight());
                intent.putExtra("output", Uri.fromFile(new File(path)));
                intent.putExtra("noFaceDetection", true);
                intent.putExtra("noShowToast", true);
                startActivityForResult(intent, LOCAL_ALBUM_SET);
            }
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, C0329R.string.album_picker_not_found, 0).show();
        }
    }

    private void setLocalFileAsAlbum(Intent intent) throws RemoteException {
        if (MetaManager.makeDirIfNotExists(this, "album")) {
            String artistName = this.mService.getArtistName();
            String albumName = this.mService.getAlbumName();
            String albumFilePath = MetaManager.getMainSdcardFilePath(albumName, artistName, "album");
            if (albumFilePath != null) {
                Uri uri = intent.getData();
                if (uri != null) {
                    FileOperations.copyFileSafe(this, uri, Uri.fromFile(new File(albumFilePath)));
                }
                AlbumListAdapter.removeCacheAlbum(new ImageSearchInfo(this.mService.getAlbumId(), null, albumName, artistName));
                requestUpdate("album");
            }
        }
    }

    private void showDialogForAlbumSearch(long localId) throws RemoteException {
        Bundle albumSearchBundle = new Bundle();
        albumSearchBundle.putString(MediaEditDialog.DIALOG_TITLE, getString(C0329R.string.album_download));
        String album = this.mService.getAlbumName();
        String artist = this.mService.getArtistName();
        String track = this.mService.getTrackName();
        long trackId = this.mService.getAudioId();
        long albumId = this.mService.getAlbumId();
        albumSearchBundle.putString(MediaEditDialog.RAW_ALBUM_NAME, MetaManager.getRawName(album));
        albumSearchBundle.putString(MediaEditDialog.RAW_ARTIST_NAME, MetaManager.getRawName(artist));
        albumSearchBundle.putString(MediaEditDialog.RAW_TRACK_NAME, track);
        if (localId >= 0) {
            albumSearchBundle.putString(MediaEditDialog.RAW_FILE_PATH, this.mService.getPath());
            albumSearchBundle.putBoolean(MediaEditDialog.MODIFY_ID3_ENABLED, true);
        }
        Bundle tracer = new Bundle();
        tracer.putLong("track_id", trackId);
        tracer.putLong("album_id", albumId);
        albumSearchBundle.putBundle(MediaEditDialog.TRACE_KEY, tracer);
        new MediaEditDialog(this, albumSearchBundle, this, 37).show();
    }

    private void startAlbumSearchTask(Intent intent) {
        if (!NetworkUtil.isActive(this)) {
            Toast.makeText(this, getString(C0329R.string.network_error), 0).show();
        } else if (showDownloadDialog(C0329R.string.album_download)) {
            String searchAlbumArtist = intent.getStringExtra(MediaEditDialog.NEW_ARTIST_NAME);
            String searchAlbumAlbum = intent.getStringExtra(MediaEditDialog.NEW_ALBUM_NAME);
            String rawAlbumArtist = intent.getStringExtra(MediaEditDialog.RAW_ARTIST_NAME);
            String rawAlbumAlbum = intent.getStringExtra(MediaEditDialog.RAW_ALBUM_NAME);
            ImageSearchInfo searchInfo = new ImageSearchInfo(searchAlbumAlbum, searchAlbumArtist);
            ImageSearchInfo rawInfo = new ImageSearchInfo(rawAlbumAlbum, rawAlbumArtist);
            boolean needModifyId3 = intent.getBooleanExtra(MediaEditDialog.MODIFY_ID3, false);
            Bundle tracer = intent.getBundleExtra(MediaEditDialog.TRACE_KEY);
            long trackId = tracer.getLong("track_id", -1);
            long albumId = tracer.getLong("album_id", -1);
            boolean modifyId3Success = false;
            if (needModifyId3) {
                modifyId3Success = editId3(intent);
            }
            String onlineId = null;
            if (this.mService != null) {
                try {
                    onlineId = this.mService.getOnlineId();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            new AlbumDownloadTask(getApplication(), rawInfo, searchInfo, modifyId3Success, trackId, albumId, onlineId).execute(new Void[0]);
        }
    }

    private void requestUpdateAlbum(Intent intent) throws RemoteException {
        String albumArtist = intent.getStringExtra("artist");
        String albumAlbum = intent.getStringExtra("album");
        String rawAlbumArtist = intent.getStringExtra(AlbumSearchResultActivity.RAW_ARTIST_NAME);
        String rawAlbumAlbum = intent.getStringExtra(AlbumSearchResultActivity.RAW_ALBUM_NAME);
        AlbumListAdapter.removeCacheAlbum(new ImageSearchInfo(albumAlbum, albumArtist));
        String currentArtistName = this.mService.getArtistName();
        String currentAlbumName = this.mService.getAlbumName();
        if ((currentArtistName.equals(albumArtist) && currentAlbumName.equals(albumAlbum)) || (currentArtistName.equals(rawAlbumArtist) && currentAlbumName.equals(rawAlbumAlbum))) {
            requestUpdate("album");
        }
    }

    private void startPickerForLyric() {
        try {
            Intent intent = new Intent("android.intent.action.PICK");
            if (this.mLastLyricPickerDir == null) {
                this.mLastLyricPickerDir = Environment.getExternalStorageDirectory();
            }
            intent.setData(Uri.fromFile(this.mLastLyricPickerDir));
            intent.putExtra("root_directory", File.separator);
            intent.putExtra("ext_filter", new String[]{"lrc"});
            intent.putExtra("ext_file_first", true);
            intent.putExtra("back_to_parent_directory", false);
            startActivityForResult(intent, LOCAL_LYRIC_SET);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, C0329R.string.lyric_picker_not_found, 0).show();
        }
    }

    private void setLocalFileAsLyric(Intent intent) throws RemoteException {
        if (MetaManager.makeDirIfNotExists(this, "lyric")) {
            String lyricOldPath = intent.getData().getPath();
            String artistName = this.mService.getArtistName();
            String trackName = this.mService.getTrackName();
            if (!TextUtils.isEmpty(artistName) || !TextUtils.isEmpty(trackName)) {
                String lyricNewPath = MetaManager.getMainSdcardFilePath(trackName, artistName, "lyric");
                if (lyricNewPath != null && lyricOldPath != null && FileOperations.copyFile(lyricOldPath, lyricNewPath)) {
                    this.mLastLyricPickerDir = new File(lyricOldPath).getParentFile();
                    requestUpdate("lyric");
                }
            }
        }
    }

    private void showDialogForLyricSearch(long localId) throws RemoteException {
        UIHelper.showDialogForLyricSearch(this, this, this.mService.getAlbumName(), this.mService.getArtistName(), this.mService.getTrackName(), this.mService.getPath(), localId);
    }

    private void startLyricSearchTask(Intent intent) {
        if (showDownloadDialog(C0329R.string.lrc_searching)) {
            String searchLrcTrack = intent.getStringExtra(MediaEditDialog.NEW_TRACK_NAME);
            String searchLrcArtist = intent.getStringExtra(MediaEditDialog.NEW_ARTIST_NAME);
            String searchLrcAlbum = intent.getStringExtra(MediaEditDialog.NEW_ALBUM_NAME);
            String rawLrcTrack = intent.getStringExtra(MediaEditDialog.RAW_TRACK_NAME);
            String rawLrcArtist = intent.getStringExtra(MediaEditDialog.RAW_ARTIST_NAME);
            String rawPath = intent.getStringExtra(MediaEditDialog.RAW_FILE_PATH);
            String saveTrack = rawLrcTrack;
            String saveArtist = rawLrcArtist;
            if (intent.getBooleanExtra(MediaEditDialog.MODIFY_ID3, false) && editId3(intent)) {
                saveTrack = searchLrcTrack;
                saveArtist = searchLrcArtist;
            }
            String path = null;
            if (!TextUtils.isEmpty(rawPath)) {
                Uri fileUri = SqlUtils.translateToFileUri(this, Uri.parse(rawPath));
                if (fileUri != null) {
                    path = fileUri.getPath();
                }
            }
            int downloadStatus = LyricManager.download(getApplication(), new LyricSearchInfo(searchLrcTrack, searchLrcArtist, searchLrcAlbum, path), new LyricAsyncChooseRunnable(saveTrack, saveArtist));
            if (downloadStatus != 4) {
                if (this.mDownloadFreezeDialog != null && this.mDownloadFreezeDialog.isShowing()) {
                    this.mDownloadFreezeDialog.dismiss();
                    this.mDownloadFreezeDialog = null;
                }
                if (downloadStatus == 5) {
                    Toast.makeText(this, getString(C0329R.string.network_error), 0).show();
                } else if (downloadStatus == 6) {
                    Toast.makeText(this, getString(C0329R.string.lyric_open_other_connect), 0).show();
                }
            }
        }
    }

    private void showUserGuide() {
        if (this.mService != null) {
            try {
                if (this.mService.getOnlineId() != null) {
                    this.mTitleBar.showUserGuide();
                    this.mToolBar.showUserGuide();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isTrackListFragmentVisible() {
        return this.mViewPager.getCurrentItem() == 0;
    }
}
