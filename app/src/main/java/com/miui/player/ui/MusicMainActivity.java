package com.miui.player.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.RemoteException;
import android.os.storage.StorageManager;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.Out;
import com.miui.player.cloud.MusicSyncAdapter;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkEnvironment;
import com.miui.player.provider.HMSwitcher;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.service.ShakeListener;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.ui.controller.MultiChoiceController.ModeChangedListener;
import com.miui.player.ui.controller.MusicBrowserController;
import com.miui.player.ui.controller.SuspendBar;
import com.miui.player.ui.fragment.ArtistListFragment;
import com.miui.player.ui.fragment.OnlineCatalogFragment;
import com.miui.player.ui.fragment.PlaylistFragment;
import com.miui.player.ui.fragment.TrackListFragment;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.util.Actions;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.Utils;
import miui.media.MiuiMediaScannerUtil;
import miui.v5.app.MiuiActionBar;
import miui.v5.app.MiuiActionBar.FragmentViewPagerChangeListener;
import miui.v5.view.ActionBarMovableLayout;
import miui.v5.view.ActionBarMovableLayout.Callback;
import miui.v5.view.ActionBarMovableLayout.OnScrollListener;
import miui.v5.view.SearchActionMode;
import miui.v5.view.ViewPager;
import miui.v5.widget.Views;

public class MusicMainActivity extends MusicBaseActivity implements Callback, ModeChangedListener, OnScrollListener, FragmentViewPagerChangeListener, SearchActionMode.Callback {
    private static final float ALBUM_BASE_TRANSLATION_X;
    private static final float ALBUM_INIT_TRANSLATION_X;
    private static final float ALBUM_INIT_TRANSLATION_Y = ((-DOUBLE_LINE_HEIGHT) / 4.0f);
    private static final int ARTIST_FRAGMENT_INDEX = 1;
    private static final float DOUBLE_LINE_HEIGHT;
    private static final String KEY_SELECTED_TAB_POSITION = "selected_tab_position";
    private static final int ONLINE_FRAGMENT_INDEX = 3;
    private static final int PLAYLIST_FRAGMENT_INDEX = 2;
    private static final float SCROLL_RANGE;
    private static final int TAB_COUNT;
    private static final float TAB_INDICATOR_INIT_TRANSLATION_X;
    private static final float TAB_LIGHT_INIT_TRANSLATION_X;
    private static final float TAB_WIDTH;
    private static final int TRACK_FRAGMENT_INDEX = 0;
    protected static final int VIEW_PAGER_ID = 101384373;
    MusicBrowserController mBrowserController;
    boolean mIsRefreshMediaProvider = false;
    String mLastSearchKey = null;
    private View mOnlineAnchor;
    private SharedPreferences mPreferences;
    private final BroadcastReceiver mScanListener = new C04502();
    SearchHelper mSearchHelper = null;
    SearchActionMode mSearchMode;
    private final BroadcastReceiver mStatusListener = new C04491();
    private SuspendBar mSuspendBar;
    private ImageView mTabIndicator;
    private ImageView mTabLight;
    private TrackListFragment mTrackListFragment;
    private ViewPager mViewPager;

    class C04491 extends BroadcastReceiver {
        C04491() {
        }

        public void onReceive(Context context, Intent intent) {
            MusicMainActivity.this.mBrowserController.refreshTrackCount();
        }
    }

    class C04502 extends BroadcastReceiver {
        C04502() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!MusicMainActivity.this.mIsRefreshMediaProvider) {
                return;
            }
            if ("android.intent.action.MEDIA_SCANNER_FINISHED".equals(action)) {
                Toast.makeText(context, C0329R.string.refresh_finish, 0).show();
                MusicMainActivity.this.mIsRefreshMediaProvider = false;
                HMSwitcher.matchTracks(MusicMainActivity.this);
            } else if ("android.intent.action.MEDIA_SCANNER_STARTED".equals(action)) {
                Toast.makeText(context, C0329R.string.refresh_start, 0).show();
            }
        }
    }

    class C04513 implements OnEditorActionListener {
        C04513() {
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String key = v.getText().toString().trim();
            if (TextUtils.isEmpty(key) || TextUtils.equals(key, MusicMainActivity.this.mLastSearchKey)) {
                return false;
            }
            MusicMainActivity.this.mLastSearchKey = key;
            MusicMainActivity.this.doSearch(key);
            return true;
        }
    }

    static {
        int i;
        if (Utils.isOnlineVaild()) {
            i = 4;
        } else {
            i = 3;
        }
        TAB_COUNT = i;
        Resources resources = MusicApplication.getApplication().getResources();
        ALBUM_BASE_TRANSLATION_X = (float) resources.getDimensionPixelOffset(C0329R.dimen.mainpage_album_base_translation_x);
        ALBUM_INIT_TRANSLATION_X = (float) resources.getDimensionPixelOffset(C0329R.dimen.mainpage_album_init_translation_x);
        DOUBLE_LINE_HEIGHT = (float) resources.getDimensionPixelOffset(101318691);
        SCROLL_RANGE = resources.getDimension(C0329R.dimen.movable_action_bar_scroll_range);
        float screenWidth = (float) Resources.getSystem().getDisplayMetrics().widthPixels;
        TAB_WIDTH = screenWidth / ((float) TAB_COUNT);
        TAB_LIGHT_INIT_TRANSLATION_X = (TAB_WIDTH / 2.0f) - (screenWidth / 4.0f);
        TAB_INDICATOR_INIT_TRANSLATION_X = (TAB_WIDTH / 2.0f) - ((float) (resources.getDimensionPixelOffset(C0329R.dimen.mainpage_tab_indicator_width) / 2));
    }

    public void onCreateContent(Bundle icicle) {
        int selectedTabPositon;
        getWindow().addExtraFlags(2);
        BaiduSdkEnvironment.getInstance().initialize();
        createTabFragment();
        this.mViewPager = (ViewPager) findViewById(VIEW_PAGER_ID);
        this.mViewPager.setBackgroundResource(C0329R.drawable.main_viewpager_bg);
        this.mTabLight = (ImageView) findViewById(C0329R.id.tab_light);
        this.mTabLight.setTranslationX(TAB_LIGHT_INIT_TRANSLATION_X);
        this.mTabIndicator = (ImageView) findViewById(C0329R.id.tab_indicator);
        this.mTabIndicator.setTranslationX(TAB_INDICATOR_INIT_TRANSLATION_X);
        this.mOnlineAnchor = findViewById(C0329R.id.online_anchor);
        MiuiActionBar actionBar = getMiuiActionBar();
        if (actionBar != null) {
            actionBar.addOnFragmentViewPagerChangeListener(this);
            ActionBarMovableLayout actionBarMovableLayout = (ActionBarMovableLayout) findViewById(101384347);
            actionBarMovableLayout.setCallback(this);
            actionBarMovableLayout.setOnScrollListener(this);
            actionBarMovableLayout.setScrollStart(getResources().getDimensionPixelOffset(101318691));
            actionBarMovableLayout.setSpringBackEnabled(true);
        }
        this.mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.mBrowserController = new MusicBrowserController(this);
        this.mBrowserController.setAlbumBackgroundTranslationX(ALBUM_INIT_TRANSLATION_X);
        this.mBrowserController.setAlbumBackgroundTranslationY(ALBUM_INIT_TRANSLATION_Y);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        filter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        filter.addDataScheme("file");
        registerReceiver(this.mScanListener, filter);
        registerReceiver(this.mStatusListener, new IntentFilter(Actions.ACTION_MEDIA_PROVIDER_CHANGED));
        if (icicle != null) {
            selectedTabPositon = icicle.getInt(KEY_SELECTED_TAB_POSITION, 0);
        } else {
            selectedTabPositon = 0;
        }
        onPageScrolled(selectedTabPositon, 0.0f, false, false);
        onPageSelected(selectedTabPositon);
        initKtvBar();
        SyncAlertHelper.showDialogIfNeed(this);
        MusicSyncAdapter.requestSync(this);
    }

    protected void onResume() {
        super.onResume();
        this.mBrowserController.onResume();
        showUserGuide();
        this.mSuspendBar.refresh();
    }

    protected void onSaveInstanceState(Bundle outState) {
        MiuiActionBar bar = getMiuiActionBar();
        outState.putInt(KEY_SELECTED_TAB_POSITION, bar != null ? bar.getSelectedTab().getPosition() : 0);
        super.onSaveInstanceState(outState);
    }

    protected void onPause() {
        this.mBrowserController.onPause();
        if (this.mSearchMode != null) {
            this.mSearchMode.finish();
        }
        if (this.mSearchHelper != null) {
            this.mSearchHelper.finish();
            this.mSearchHelper = null;
        }
        super.onPause();
    }

    public void onDestroyContent() {
        UIHelper.unregistBroadcastReceiverSafe(this, this.mScanListener);
        UIHelper.unregistBroadcastReceiverSafe(this, this.mStatusListener);
        if (this.mBrowserController != null) {
            this.mBrowserController.onDestroy();
        }
        super.onDestroyContent();
    }

    protected boolean saveData(Bundle outcicle) {
        super.saveData(outcicle);
        if (this.mTrackListFragment != null) {
            this.mTrackListFragment.saveData(outcicle);
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

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 31, 31, C0329R.string.refresh_media_db);
        menu.add(0, 32, 32, C0329R.string.search_title);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case BaseMenuId.MEDIA_SCAN /*31*/:
                refreshMediaProvider();
                return true;
            case 32:
                this.mSearchHelper = new SearchHelper(this, 1);
                this.mSearchHelper.setSearchHint(getString(C0329R.string.search_hint));
                startActionMode(this.mSearchHelper);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void doSearch(String key) {
        Intent intent = new Intent("android.intent.action.SEARCH");
        intent.addFlags(268435456);
        intent.putExtra("user_query", key);
        intent.putExtra("query", key);
        intent.setClass(this, QueryBrowserActivity.class);
        startActivity(intent);
    }

    protected void handleServiceConnected(IMediaPlaybackService service) throws RemoteException {
        if (!isPaused()) {
            this.mBrowserController.refreshMediaInfo(true, ServiceHelper.getUpdateVersion());
        }
        if (this.mTrackListFragment != null) {
            this.mTrackListFragment.setService(service);
        }
    }

    protected void handleServiceDisconnected() {
        if (this.mTrackListFragment != null) {
            this.mTrackListFragment.setService(null);
        }
    }

    protected String[] getObservedServiceActions() {
        return new String[]{Out.STATUS_PLAYSTATE_CHANGED, Out.STATUS_META_CHANGED, Out.STATUS_PLAYBACK_COMPLETE, Actions.ACTION_KTV_CONNECT_CHANGED, Actions.ACTION_SUSPEND_BAR_VISIBILITY_CHANGED};
    }

    protected void handleServiceNotification(Intent intent) {
        super.handleServiceNotification(intent);
        boolean updateAlbum = false;
        String action = intent.getAction();
        if (Out.STATUS_META_CHANGED.equals(action)) {
            String extra = intent.getStringExtra(Out.KEY_OTHER);
            updateAlbum = Out.META_CHANGED_ALBUM.equals(extra) || Out.META_CHANGED_TRACK.equals(extra);
        } else if (Actions.ACTION_KTV_CONNECT_CHANGED.equals(action) || Actions.ACTION_SUSPEND_BAR_VISIBILITY_CHANGED.equals(action)) {
            this.mSuspendBar.refresh();
        }
        this.mBrowserController.refreshMediaInfo(updateAlbum, intent.getIntExtra(Out.KEY_UPDATE_VERSION, -1));
    }

    private void refreshMediaProvider() {
        if (!Utils.isExternalStorageMounted()) {
            return;
        }
        if (this.mIsRefreshMediaProvider) {
            Toast.makeText(this, C0329R.string.refresh_in_processing, 0).show();
            return;
        }
        triggerMediaMounted();
        this.mIsRefreshMediaProvider = true;
    }

    private void triggerMediaMounted() {
        try {
            Intent intent = new Intent("android.intent.action.MEDIA_MOUNTED");
            intent.setData(Uri.parse("file://" + Environment.getExternalStorageDirectory()));
            intent.setClassName("com.android.providers.media", "com.android.providers.media.MediaScannerReceiver");
            sendBroadcast(intent);
        } catch (SecurityException e) {
            for (String path : ((StorageManager) getSystemService("storage")).getVolumePaths()) {
                MiuiMediaScannerUtil.scanFolder(this, path);
            }
        }
    }

    private void createTabFragment() {
        MiuiActionBar bar = getMiuiActionBar();
        bar.setFragmentViewPagerMode(this, getFragmentManager());
        bar.addFragmentTab(Integer.toString(0), bar.newTab().setText(C0329R.string.tracks_title), TrackListFragment.class, null, false);
        bar.addFragmentTab(Integer.toString(1), bar.newTab().setText(C0329R.string.artists_title), ArtistListFragment.class, null, false);
        bar.addFragmentTab(Integer.toString(2), bar.newTab().setText(C0329R.string.playlists_title), PlaylistFragment.class, null, false);
        if (Utils.isOnlineVaild()) {
            bar.addFragmentTab(Integer.toString(3), bar.newTab().setText(C0329R.string.online_title), OnlineCatalogFragment.class, null, false);
        }
        this.mTrackListFragment = (TrackListFragment) bar.getFragmentAt(0);
        this.mTrackListFragment.setAlphabetFastIndexerVisible(false);
    }

    private void showUserGuide() {
        if (Utils.isOnlineVaild()) {
            UIHelper.showUserGuide(this, this.mOnlineAnchor, 0, 0, PreferenceCache.PREF_PAY_SERVICE_GUIDE_NEW, C0329R.string.pay_service_guide_new);
        }
    }

    private MusicBaseFragment getCurrentFragment() {
        MiuiActionBar bar = getMiuiActionBar();
        return (MusicBaseFragment) bar.getFragmentAt(bar.getSelectedTab().getPosition());
    }

    protected ListView getCurrentListView() {
        MusicBaseFragment f = getCurrentFragment();
        return f != null ? (ListView) f.getListView() : null;
    }

    public boolean isContentVerticalScrolled() {
        ListView listView = getCurrentListView();
        if (listView == null) {
            return false;
        }
        View view = listView.getChildAt(0);
        if (listView.getFirstVisiblePosition() == 0 && (view == null || view.getTop() == 0)) {
            return false;
        }
        return true;
    }

    public void onModeChanged(boolean enabled, AbsListView lv) {
        boolean z;
        boolean z2 = true;
        ViewPager viewPager = this.mViewPager;
        if (enabled) {
            z = false;
        } else {
            z = true;
        }
        viewPager.setDraggable(z);
        SuspendBar suspendBar = this.mSuspendBar;
        if (enabled) {
            z2 = false;
        }
        suspendBar.setVisible(z2);
    }

    public void onPageScrolled(int position, float ratio, boolean fromHasActionMenu, boolean toHasActionMenu) {
        this.mTabIndicator.setTranslationX(TAB_INDICATOR_INIT_TRANSLATION_X + ((((float) position) + ratio) * TAB_WIDTH));
        this.mBrowserController.setAlbumBackgroundTranslationX(ALBUM_INIT_TRANSLATION_X + (ALBUM_BASE_TRANSLATION_X * (((float) position) + ratio)));
    }

    public void onPageSelected(int position) {
        this.mTabLight.setTranslationX(TAB_LIGHT_INIT_TRANSLATION_X + (TAB_WIDTH * ((float) position)));
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onScrollBegin() {
    }

    public void onScrollEnd() {
    }

    public void onScroll(int state, float offset) {
        float translationY = (offset - ShakeListener.ACCELATION_FACTOR_X) * SCROLL_RANGE;
        this.mTabLight.setTranslationY(translationY);
        this.mTabIndicator.setTranslationY(translationY);
        this.mOnlineAnchor.setTranslationY(translationY);
        this.mBrowserController.setAlbumBackgroundTranslationY(Math.min(0.0f, ALBUM_INIT_TRANSLATION_Y + (translationY / 4.0f)));
        float deltaY = DOUBLE_LINE_HEIGHT - (SCROLL_RANGE * offset);
        if (deltaY > 0.0f) {
            this.mTrackListFragment.setAlphabetFastIndexerVisible(true);
            this.mTrackListFragment.setAlphabetFastIndexerAlpha(deltaY / DOUBLE_LINE_HEIGHT);
            return;
        }
        this.mTrackListFragment.setAlphabetFastIndexerVisible(false);
    }

    public void onFling(float distance, int duration) {
    }

    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        this.mSearchMode = (SearchActionMode) mode;
        this.mSearchMode.setAnchorViewHint(getString(C0329R.string.search_hint));
        this.mSearchMode.setAnimateView(getActionBar().getCustomView());
        this.mSearchMode.setAnchorView(getActionBar().getCustomView());
        this.mSearchMode.getSearchView().setOnEditorActionListener(new C04513());
        return true;
    }

    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        this.mLastSearchKey = null;
        return true;
    }

    public void onDestroyActionMode(ActionMode mode) {
        this.mSearchMode = null;
    }

    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return true;
    }

    private void initKtvBar() {
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
        View suspendView = Views.inflate(this, C0329R.layout.suspend_bar, decorView, false);
        suspendView.setClickable(true);
        decorView.addView(suspendView);
        this.mSuspendBar = new SuspendBar(this);
    }
}
