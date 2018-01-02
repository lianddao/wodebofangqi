package com.miui.player.ui.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SortableListView;
import android.widget.SortableListView.OnOrderChangedListener;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.In;
import com.miui.player.PlayerActions.Out;
import com.miui.player.meta.Audio;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.provider.KtvPlaylistCache;
import com.miui.player.provider.PlayerProvider;
import com.miui.player.provider.PlayerProviderUtils;
import com.miui.player.provider.PlayerStore.MemberColomns;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Members;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.provider.StatisticsHelper;
import com.miui.player.service.HistoryManager;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.TrackBrowserActivity;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.UIHelper.ListViewPositionWrap;
import com.miui.player.ui.base.MediaCursorLoader.CursorDecorator;
import com.miui.player.ui.base.MediaCursorLoader.MediaLoaderInfo;
import com.miui.player.ui.base.MediaCursorLoader.QueryArgs;
import com.miui.player.ui.base.MediaCursorLoader.Selection;
import com.miui.player.ui.base.MediaCursorLoader.SelectionDecorator;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.ui.base.MusicBaseFragment.SectionCursorDecorator;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.ui.controller.MultiChoiceController.ModeChangedListener;
import com.miui.player.ui.menu.BaseMenuManager;
import com.miui.player.ui.menu.BaseTrackBrowserMenu.ContextInfo;
import com.miui.player.ui.menu.TrackBrowserMenu;
import com.miui.player.ui.menu.TrackBrowserMenu.ContextInfoProvider;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.ui.model.NowplayingCursor;
import com.miui.player.ui.model.TrackListAdapter;
import com.miui.player.ui.model.TrackListAdapter.TrackBrowser;
import com.miui.player.util.Actions;
import com.miui.player.util.PreferenceConstants;
import com.miui.player.util.SectionCursor.CursorConverter;
import com.miui.player.util.ServiceActions;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Utils;
import com.miui.player.util.cursors.Cursors;
import java.util.ArrayList;
import java.util.Arrays;
import miui.widget.AlphabetFastIndexer;

public class TrackListFragment extends MusicBaseFragment implements OnOrderChangedListener, TrackBrowser, ContextInfoProvider {
    private static final int ID_LOADER_NOWPLAYING = 2;
    private static final String KEY_ALBUM_ID = "album_id";
    private static final String KEY_ALBUM_NAME = "album_name";
    private static final String KEY_ARTIST_ID = "artist_id";
    private static final String KEY_ARTIST_NAME = "artist_name";
    private static final String KEY_EDIT_MODE = "editmode";
    private static final String KEY_FOLDER_PATH = "folder_path";
    private static final String KEY_ITEM_NUM = "item_num";
    private static final String KEY_PLAYLIST_NAME = "playlist_name";
    private static final int SPECIAL_ID_ADD_TRACK = -1;
    private static final int SPECIAL_ID_PLAY_ALL = -2;
    private static final String TAG = TrackListFragment.class.getName();
    private static final ListViewPositionWrap sListViewPositionWrap = new ListViewPositionWrap();
    TrackListAdapter mAdapter;
    private Runnable mAdapterUpdateRunnable = new C05071();
    private View mAddTracks;
    private long mAlbumId = -1;
    private String mAlbumName = null;
    private AlphabetFastIndexer mAlphabetIndexer;
    private long mArtistId = -1;
    private String mArtistName = null;
    private int mCachedNum = 0;
    private Cursor mCursor;
    private OnCursorChangedListener mCursorChangedListener;
    private final BroadcastReceiver mDownloadReceiver = new C05082();
    private boolean mEditable = false;
    private String mFolderPath = null;
    private boolean mIsLandPage = false;
    private boolean mIsMainPage = false;
    private ListView mListView;
    private BaseMenuManager<Long> mMenuManager;
    private MultiChoiceController<Long> mMultiChoiceController;
    private View mPlayAll;
    private String mPlaylistId = null;
    private OnScrollListener mScrollListener;
    private boolean mShownAsPicker = true;

    public interface OnCursorChangedListener {
        void onCursorChanged(Cursor cursor);
    }

    class C05071 implements Runnable {
        C05071() {
        }

        public void run() {
            if (TrackListFragment.this.mAdapter != null) {
                TrackListFragment.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    class C05082 extends BroadcastReceiver {
        C05082() {
        }

        public void onReceive(Context context, Intent intent) {
            if (TrackListFragment.this.mAdapter != null) {
                TrackListFragment.this.mAdapter.updateDownloadStatus();
                TrackListFragment.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    class NowplayingLoaderCallback extends TemplateLoaderCallback {
        NowplayingLoaderCallback() {
            super();
        }

        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            return NowplayingCursor.createLoader(MusicApplication.getApplication(), TrackListAdapter.NOWPLAYING_COLUMNS, 6, 1, 1);
        }
    }

    public static class SelectionWithBlacklist extends SelectionDecorator {
        private final boolean mFolderFilter;

        public SelectionWithBlacklist(SelectionDecorator decorated) {
            this(decorated, true);
        }

        public SelectionWithBlacklist(SelectionDecorator decorated, boolean folderFilter) {
            super(decorated);
            this.mFolderFilter = folderFilter;
        }

        protected Selection doDecorate(String where, String[] args) {
            return new Selection(SqlUtils.wrapWithBlacklist(MusicApplication.getApplication(), where, this.mFolderFilter), args);
        }
    }

    static class TransformDecorder implements CursorDecorator {
        private final long[] mIds;
        private final int mIdx;

        public TransformDecorder(int idx, long[] ids) {
            this.mIds = ids;
            this.mIdx = idx;
        }

        public Cursor decorate(Cursor cursor, QueryArgs args) {
            return Cursors.newRowMappedCursor(cursor, this.mIdx, this.mIds);
        }

        public boolean isRawCursorClosable() {
            return false;
        }
    }

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            String action = intent.getAction();
            if ("com.miui.player.PLAYBACK_VIEWER".equals(action) || "com.miui.player.NOWPLAYING_PLAYLIST".equals(action) || Actions.ACTION_LANDSCAPE_VIEW.equals(action)) {
                this.mShownAsPicker = false;
                initAsNowplaying();
                if (Actions.ACTION_LANDSCAPE_VIEW.equals(action)) {
                    this.mIsLandPage = true;
                    return;
                }
                return;
            } else if ("android.intent.action.MAIN".equals(action) || In.ACTION_MUSIC_MAIN.equals(action)) {
                this.mIsMainPage = true;
                return;
            }
        }
        if (icicle == null && intent != null) {
            icicle = intent.getExtras();
        }
        if (icicle == null) {
            icicle = new Bundle();
            Log.e(getTag(), "icicle is NULL");
        }
        this.mAlbumId = icicle.getLong("album_id", -1);
        this.mAlbumName = icicle.getString("album_name", null);
        this.mArtistId = icicle.getLong("artist_id", -1);
        this.mArtistName = icicle.getString("artist_name", null);
        this.mPlaylistId = icicle.getString("playlist_name");
        this.mEditable = icicle.getBoolean(KEY_EDIT_MODE, false);
        this.mFolderPath = icicle.getString("folder_path");
        this.mCachedNum = icicle.getInt(KEY_ITEM_NUM);
    }

    public void saveData(Bundle outcicle) {
        outcicle.putLong("album_id", this.mAlbumId);
        outcicle.putString("album_name", this.mAlbumName);
        outcicle.putLong("artist_id", this.mArtistId);
        outcicle.putString("artist_id", "artist_name");
        outcicle.putString("playlist_name", this.mPlaylistId);
        outcicle.putBoolean(KEY_EDIT_MODE, this.mEditable);
        outcicle.putString("folder_path", this.mFolderPath);
        outcicle.putInt(KEY_ITEM_NUM, this.mCachedNum);
    }

    private void initAsNowplaying() {
        this.mPlaylistId = "nowplaying";
        this.mCachedNum = ServiceHelper.getQueueSize();
    }

    private boolean isNowPlaying() {
        return "nowplaying".equals(this.mPlaylistId);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
        return inflater.inflate(C0329R.layout.track_list_frame, container, false);
    }

    public void onViewCreated(View view, Bundle icicle) {
        int trackItemLayout;
        AlphabetFastIndexer alphabetFastIndexer;
        SortableListView sortableListView;
        boolean z;
        super.onViewCreated(view, icicle);
        Activity a = getActivity();
        ViewGroup lv = (ListView) getListView();
        this.mListView = lv;
        this.mMenuManager = new TrackBrowserMenu(a, this, C0329R.plurals.Nitems_batch_selection, "_id");
        if (this.mShownAsPicker) {
            this.mMultiChoiceController = new MultiChoiceController(lv, this.mMenuManager);
            this.mMultiChoiceController.setItemViewBinder(UIHelper.createBinderForList(C0329R.id.batch_selection_check));
            this.mMultiChoiceController.setOnModeChangedListener(this);
        }
        lv.setOnItemClickListener(this);
        int leftMargin = -1;
        if (this.mIsMainPage) {
            leftMargin = getResources().getDimensionPixelOffset(C0329R.dimen.mainpage_list_item_margin_left);
        } else if (this.mIsLandPage) {
            leftMargin = 0;
        } else if (isNowPlaying()) {
            leftMargin = getResources().getDimensionPixelOffset(C0329R.dimen.nowplaying_list_item_margin_left);
        }
        boolean nowplaying = isNowPlaying();
        if (!this.mIsLandPage) {
            if (nowplaying) {
                this.mAddTracks = UIHelper.makeSpecialView(lv, -1, (int) C0329R.drawable.add_tracks_selector, (int) C0329R.string.add_tracks, leftMargin);
                lv.addFooterView(this.mAddTracks);
            } else {
                this.mPlayAll = UIHelper.makeSpecialView(lv, -2, 0, (int) C0329R.string.play_all, leftMargin);
                updateListHeader(-1);
                lv.addHeaderView(this.mPlayAll);
            }
        }
        if (this.mIsLandPage) {
            trackItemLayout = C0329R.layout.land_track_list_item;
        } else {
            trackItemLayout = C0329R.layout.track_list_item;
        }
        boolean alphabetSort = this.mPlaylistId == null && this.mAlbumId < 0;
        this.mAlphabetIndexer = (AlphabetFastIndexer) view.findViewById(C0329R.id.fast_indexer);
        if (alphabetSort) {
            alphabetFastIndexer = this.mAlphabetIndexer;
        } else {
            alphabetFastIndexer = null;
        }
        if (this.mEditable) {
            sortableListView = (SortableListView) lv;
        } else {
            sortableListView = null;
        }
        MultiChoiceController multiChoiceController = this.mMultiChoiceController;
        boolean z2 = this.mIsLandPage;
        if (this.mAlbumId != -1) {
            z = true;
        } else {
            z = false;
        }
        this.mAdapter = new TrackListAdapter(a, this, trackItemLayout, null, alphabetFastIndexer, sortableListView, multiChoiceController, nowplaying, z2, z, this.mEditable, leftMargin);
        if (alphabetSort) {
            this.mAlphabetIndexer.attatch(lv);
            lv.setVerticalScrollBarEnabled(false);
            lv.setOnScrollListener(this.mAdapter.decorateScrollListener(this.mScrollListener));
            this.mAdapter.setAutoRefreshEnable(!this.mIsMainPage);
        }
        this.mMenuManager.setAdapter(this.mAdapter);
        lv.setAdapter(this.mAdapter);
        setHasOptionsMenu(true);
    }

    public void onDestroyView() {
        ListView lv = this.mListView;
        if (lv != null) {
            if (useLastListPosition()) {
                sListViewPositionWrap.saveListPosition(lv);
            }
            if (this.mEditable) {
                ((SortableListView) lv).setOnDragListener(null);
            }
        }
        this.mListView.setAdapter(null);
        this.mMenuManager.setAdapter(null);
        this.mAdapter = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle outcicle) {
        saveData(outcicle);
        super.onSaveInstanceState(outcicle);
    }

    public void onResume() {
        super.onResume();
        Activity a = getActivity();
        if (getPlaylistId() >= 0) {
            a.registerReceiver(this.mDownloadReceiver, new IntentFilter(Actions.ACTION_ONLINE_DOWNLOAD_COMPLETE));
        }
        update();
        UIHelper.updateSpecialViewText(this.mPlayAll, ServiceHelper.isShuffle() ? C0329R.string.shuffle_all : C0329R.string.play_all);
        refreshChoiceMode();
        if (this.mIsMainPage) {
            refreshFootView();
        }
    }

    public void onPause() {
        super.onPause();
        UIHelper.unregistBroadcastReceiverSafe(getActivity(), this.mDownloadReceiver);
    }

    public void update() {
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setListSelectedPosition(int position) {
        setListSelectedPosition(position, 0.0f);
    }

    public void setListSelectedPosition(int position, float offset) {
        ListView lv = this.mListView;
        if (lv != null) {
            int headerCount = lv.getHeaderViewsCount();
            int footerCount = lv.getFooterViewsCount();
            int itemCount = this.mListView.getCount();
            if (itemCount > headerCount + footerCount) {
                if ((position + headerCount) + ((lv.getLastVisiblePosition() - lv.getFirstVisiblePosition()) + 1) < itemCount) {
                    View v = this.mListView.getChildAt(headerCount);
                    if (v != null) {
                        this.mListView.setSelectionFromTop(position + headerCount, Math.round(((float) v.getHeight()) * offset));
                    } else {
                        this.mListView.setSelectionFromTop(position + headerCount, 0);
                    }
                }
            }
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (this.mMenuManager.onContextItemSelected(item)) {
            return true;
        }
        return false;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (!isNowPlaying()) {
            this.mMenuManager.onCreateOptionsMenu(menu);
            menu.add(0, 28, 0, C0329R.string.add_tracks).setIcon(100795019).setShowAsAction(1);
            if (KtvPlaylistCache.isKtvPlaylistId(getActivity(), getPlaylistId())) {
                menu.add(0, 29, 0, C0329R.string.find_ktv).setIcon(C0329R.drawable.bottom_bar_find_ktv).setShowAsAction(1);
            }
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        this.mMenuManager.onPrepareOptionsMenu(menu);
        MenuItem item = menu.findItem(28);
        if (item != null) {
            boolean z = isEditable() && !KtvPlaylistCache.isKtvPlaylistId(getActivity(), getPlaylistId());
            item.setVisible(z);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case BaseMenuId.ADD_TRACKS /*28*/:
                startActivityForAddTracks();
                return true;
            default:
                return this.mMenuManager.onOptionsItemSelected(item);
        }
    }

    public void startActivityForAddTracks() {
        long plid = getPlaylistId();
        Intent intent = new Intent(Actions.ACTION_TRACKS_PICKER);
        intent.putExtra(MemberColomns.PLAYLIST_ID, plid);
        startActivityForResult(intent, 28);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case BaseMenuId.ADD_TRACKS /*28*/:
                if (resultCode == -1) {
                    long playlistId = intent.getLongExtra(MemberColomns.PLAYLIST_ID, -1);
                    long[] trackIds = intent.getLongArrayExtra("track_ids");
                    if (playlistId >= 0 && trackIds != null && trackIds.length > 0) {
                        if (playlistId == 0) {
                            ServiceHelper.addToCurrentPlaylist(getActivity(), trackIds);
                            return;
                        } else {
                            PlaylistHelper.addToPlaylistAsync(MusicApplication.getApplication(), trackIds, playlistId, false, this.mAdapterUpdateRunnable);
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void handleLoadFinished(int loaderId, Cursor cursor) {
        if (this.mAdapter != null) {
            boolean first;
            if (this.mCursor == null) {
                first = true;
            } else {
                first = false;
            }
            this.mAdapter.changeCursor(cursor);
            if (this.mCursor != null) {
                if (first) {
                    if (isNowPlaying()) {
                        this.mListView.setSelection(Math.max((ServiceHelper.getQueuePosition() + this.mListView.getHeaderViewsCount()) - 2, 0));
                    } else if (useLastListPosition()) {
                        sListViewPositionWrap.restoreListPosition(this.mListView);
                    }
                }
                Activity a = getActivity();
                if (a instanceof TrackBrowserActivity) {
                    ((TrackBrowserActivity) a).setTitleBar();
                }
            }
        }
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        if (l == this.mListView) {
            Object tag = v.getTag();
            if (tag instanceof Integer) {
                int headerId = ((Integer) tag).intValue();
                if (headerId == -1) {
                    long plid = getPlaylistId();
                    if (plid >= 0) {
                        Intent intent = new Intent(Actions.ACTION_TRACKS_PICKER);
                        intent.putExtra(MemberColomns.PLAYLIST_ID, plid);
                        startActivityForResult(intent, 28);
                        return;
                    }
                    return;
                } else if (headerId == -2 && this.mCursor != null && this.mCursor.getCount() > 0) {
                    IMediaPlaybackService service = ServiceHelper.sService;
                    if (service != null) {
                        try {
                            service.setRepeatMode(0);
                        } catch (RemoteException e) {
                        }
                    }
                    ServiceHelper.playAll(getActivity(), this.mCursor);
                    return;
                } else {
                    return;
                }
            }
            position -= this.mListView.getHeaderViewsCount();
            if (this.mCursor.getCount() != 0 && this.mCursor.moveToPosition(position)) {
                if (this.mCursor instanceof NowplayingCursor) {
                    long current = -1;
                    int oldPos = this.mCursor.getPosition();
                    try {
                        this.mCursor.moveToPosition(position);
                        int audioIdx = PlayerProviderUtils.guessAudioIdColumnIndex(this.mCursor);
                        if (audioIdx >= 0) {
                            current = this.mCursor.getLong(audioIdx);
                        }
                        this.mCursor.moveToPosition(oldPos);
                        if (current < 0 || current != ServiceHelper.getCurrentAudioId()) {
                            ServiceHelper.toggleQueuePosition(position);
                        } else {
                            ServiceHelper.togglePause();
                        }
                    } catch (Throwable th) {
                        this.mCursor.moveToPosition(oldPos);
                    }
                } else {
                    ServiceHelper.playAll(getActivity(), this.mCursor, position);
                }
            }
        }
    }

    public void OnOrderChanged(int from, int to) {
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            if (cursor instanceof NowplayingCursor) {
                ((NowplayingCursor) cursor).moveItem(from, to);
                return;
            }
            long plid = getPlaylistId();
            Cursor orderCursor = SqlUtils.query(getActivity(), Members.getMembersUri(plid), new String[]{"play_order"}, null, null, "play_order");
            if (orderCursor != null) {
                int fromOrder = -1;
                int toOrder = -1;
                try {
                    if (orderCursor.moveToPosition(from)) {
                        fromOrder = orderCursor.getInt(0);
                    }
                    if (orderCursor.moveToPosition(to)) {
                        toOrder = orderCursor.getInt(0);
                    }
                    if (toOrder >= 0 && fromOrder >= 0) {
                        PlayerProvider.moveItem(getActivity().getContentResolver(), plid, fromOrder, toOrder);
                    }
                    orderCursor.close();
                } catch (Throwable th) {
                    orderCursor.close();
                }
            }
        }
    }

    public void onModeChanged(boolean enabled, AbsListView lv) {
        boolean z = true;
        if (this.mAddTracks != null) {
            UIHelper.setChildEnabled((ViewGroup) this.mAddTracks, !enabled);
        }
        if (this.mPlayAll != null) {
            ViewGroup viewGroup = (ViewGroup) this.mPlayAll;
            if (enabled) {
                z = false;
            }
            UIHelper.setChildEnabled(viewGroup, z);
        }
        Activity a = getActivity();
        if (a instanceof ModeChangedListener) {
            ((ModeChangedListener) a).onModeChanged(enabled, lv);
        }
    }

    private boolean useLastListPosition() {
        return this.mPlaylistId == null && this.mAlbumId < 0 && this.mArtistId < 0;
    }

    public ContextInfo<Long> getContextInfo() {
        ContextInfo<Long> ctx = new ContextInfo();
        ctx.mAlbumId = this.mAlbumId;
        ctx.mAlbumName = this.mAlbumName;
        ctx.mArtistId = this.mArtistId;
        ctx.mArtistName = this.mArtistName;
        ctx.mCursor = this.mCursor;
        ctx.mEditMode = this.mEditable;
        ctx.mHeaderCount = this.mListView.getHeaderViewsCount();
        ctx.mPlaylistId = getPlaylistId();
        ctx.mRefreshRunnable = this.mAdapterUpdateRunnable;
        ctx.mListView = this.mListView;
        ctx.mMultiChoiceController = this.mMultiChoiceController;
        ctx.mDownloadList = getDownloadList();
        return ctx;
    }

    public AudioList getDownloadList() {
        if (this.mCursor == null) {
            return null;
        }
        int oldPos = this.mCursor.getPosition();
        if (!this.mCursor.moveToFirst()) {
            return null;
        }
        int onlineIdIdx = this.mCursor.getColumnIndex("mi_online_id");
        if (onlineIdIdx < 0) {
            return null;
        }
        int titleIdx = this.mCursor.getColumnIndexOrThrow("title");
        int artistIdx = this.mCursor.getColumnIndexOrThrow("artist");
        ArrayList<Audio> list = new ArrayList();
        while (!this.mCursor.isAfterLast()) {
            String onlineId = this.mCursor.getString(onlineIdIdx);
            if (!TextUtils.isEmpty(onlineId)) {
                Audio audio = new Audio(onlineId, this.mCursor.getString(titleIdx));
                audio.mDetail = new AudioDetail();
                audio.mDetail.mArtistName = this.mCursor.getString(artistIdx);
                list.add(audio);
            }
            this.mCursor.moveToNext();
        }
        this.mCursor.moveToPosition(oldPos);
        return new AudioList(list);
    }

    public boolean isMultiChoiceModeEnabled() {
        return this.mMultiChoiceController != null && this.mMultiChoiceController.isEnabled();
    }

    public boolean leaveMultiChoiceMode() {
        if (this.mMultiChoiceController == null || !this.mMultiChoiceController.leave()) {
            return false;
        }
        return true;
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    public long getPlaylistId() {
        long playlistId = -1;
        if (isNowPlaying()) {
            return 0;
        }
        try {
            return Long.valueOf(this.mPlaylistId).longValue();
        } catch (NumberFormatException e) {
            Utils.debugLog(TAG, e);
            return playlistId;
        }
    }

    public String getPlaylistName() {
        return this.mPlaylistId;
    }

    public int getCachedTrackNum() {
        return this.mCachedNum;
    }

    public long getArtistId() {
        return this.mArtistId;
    }

    public String getArtistName() {
        return this.mArtistName;
    }

    public long getAlbumId() {
        return this.mAlbumId;
    }

    public String getAlbumName() {
        return this.mAlbumName;
    }

    public String getFolderPath() {
        return this.mFolderPath;
    }

    public CursorAdapter getAdapter() {
        return this.mAdapter;
    }

    public boolean isEditable() {
        return this.mEditable;
    }

    public boolean isEditing() {
        return isMultiChoiceModeEnabled();
    }

    public boolean isWorking() {
        return isActivityWorking();
    }

    public boolean swapCursor(Cursor cursor) {
        if (this.mCursor == cursor) {
            return false;
        }
        this.mCursor = cursor;
        if (this.mCursorChangedListener != null) {
            this.mCursorChangedListener.onCursorChanged(cursor);
        }
        if (cursor != null) {
            updateListHeader(cursor.getCount());
        }
        return true;
    }

    private void updateListHeader(int count) {
        Context context = getActivity();
        if (context != null && this.mPlayAll != null) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            if (count >= 0) {
                sp.edit().putInt(PreferenceConstants.TRACK_COUNT, count).commit();
            } else {
                count = sp.getInt(PreferenceConstants.TRACK_COUNT, 0);
            }
            String text = getResources().getQuantityString(C0329R.plurals.Ntracks_total, count, new Object[]{Integer.valueOf(count)});
            TextView tv = (TextView) this.mPlayAll.findViewById(C0329R.id.num);
            tv.setVisibility(0);
            tv.setText(text);
        }
    }

    protected MediaLoaderInfo getMediaLoaderInfo() {
        Uri uri = null;
        String[] projection = null;
        String[] selectionArgs = null;
        String orderBy = null;
        String where = null;
        SelectionDecorator selectionDecorator = null;
        CursorDecorator decorator = null;
        if (getFolderPath() != null) {
            uri = Media.EXTERNAL_CONTENT_URI;
            projection = TrackListAdapter.TRACK_COLUMNS;
            where = SqlUtils.pathLikeWhere(Arrays.asList(new String[]{getFolderPath()}), "_data");
            selectionDecorator = new SelectionWithBlacklist(null);
        } else if (getPlaylistName() == null) {
            uri = Media.EXTERNAL_CONTENT_URI;
            projection = TrackListAdapter.TRACK_COLUMNS;
            StringBuilder sb = new StringBuilder();
            if (getAlbumId() >= 0) {
                sb.append("album_id=" + getAlbumId());
                orderBy = "track, title_key";
            }
            if (getArtistId() >= 0) {
                if (sb.length() > 0) {
                    sb.append(" AND ");
                }
                sb.append("artist_id=" + getArtistId());
            }
            where = sb.toString();
            selectionDecorator = new SelectionWithBlacklist(null);
        } else if (!"nowplaying".equals(getPlaylistName())) {
            if (PlaylistHelper.PLAYLIST_RECENTLY_ADDED.equals(getPlaylistName())) {
                uri = Media.EXTERNAL_CONTENT_URI;
                projection = TrackListAdapter.TRACK_COLUMNS;
                orderBy = Members.DEFAULT_SORT_ORDER;
                where = null;
                selectionDecorator = new SelectionWithBlacklist(new SelectionDecorator(null) {
                    protected Selection doDecorate(String w, String[] args) {
                        return new Selection(PlaylistHelper.recentlyAddedWhere(MusicApplication.getApplication()), null);
                    }
                });
            } else if (PlaylistHelper.PLAYLIST_RECENTLY_PLAYED.equals(getPlaylistName())) {
                uri = Media.EXTERNAL_CONTENT_URI;
                projection = TrackListAdapter.TRACK_COLUMNS;
                selectionDecorator = new SelectionWithBlacklist(new SelectionDecorator(null) {
                    protected Selection doDecorate(String w, String[] args) {
                        return new Selection("_id IN" + SqlUtils.concatAsSet(HistoryManager.loadLatest(TrackListFragment.this.getActivity())), null);
                    }
                });
            } else if (PlaylistHelper.PLAYLSIT_FREQUENTLY_PLAYED.equals(getPlaylistName())) {
                uri = Media.EXTERNAL_CONTENT_URI;
                projection = TrackListAdapter.TRACK_COLUMNS;
                final long[] frequentlyIds = StatisticsHelper.queryFrequentlyPlayed(getActivity());
                selectionDecorator = new SelectionWithBlacklist(new SelectionDecorator(null) {
                    protected Selection doDecorate(String w, String[] args) {
                        return new Selection("_id IN" + SqlUtils.concatAsSet(frequentlyIds), null);
                    }
                });
                decorator = new TransformDecorder(0, frequentlyIds);
            } else {
                long playlistId = getPlaylistId();
                if (playlistId > 0) {
                    uri = Members.getMembersUri(playlistId);
                    projection = TrackListAdapter.MEMBER_COLUMNS;
                    where = "mi_sync_track_state !=?";
                    selectionArgs = new String[]{String.valueOf(1)};
                    orderBy = Members.DEFAULT_SORT_ORDER;
                }
            }
        }
        if (uri == null) {
            return null;
        }
        QueryArgs args = new QueryArgs(MusicApplication.getApplication().getContentResolver(), uri, projection, where, selectionArgs, orderBy, selectionDecorator);
        if (decorator == null) {
            CursorConverter converter = orderBy == null ? TrackListAdapter.createCursorConverter(projection) : null;
            decorator = converter != null ? new SectionCursorDecorator(converter, 0) : null;
        }
        return new MediaLoaderInfo(decorator, args);
    }

    protected CursorAdapter getCursorAdapter() {
        return getAdapter();
    }

    public void setService(IMediaPlaybackService service) {
        super.setService(service);
        launchLoader(true);
        UIHelper.updateSpecialViewText(this.mPlayAll, ServiceHelper.isShuffle() ? C0329R.string.shuffle_all : C0329R.string.play_all);
    }

    public void launchLoader(boolean reset) {
        if (!isActivityWorking()) {
            return;
        }
        if (!isNowPlaying()) {
            super.launchLoader(reset);
        } else if (this.mService != null) {
            Loader<Cursor> loader = getLoaderManager().getLoader(2);
            if (!reset || loader == null) {
                getLoaderManager().initLoader(2, null, new NowplayingLoaderCallback());
                return;
            }
            loader.onContentChanged();
        }
    }

    protected String[] getObservedServiceActions() {
        return new String[]{Out.STATUS_META_CHANGED, Out.STATUS_QUEUE_CHANGED, Out.STATUS_PLAYSTATE_CHANGED, Out.STATUS_PLAYBACK_COMPLETE, Actions.ACTION_KTV_CONNECT_CHANGED, Actions.ACTION_KTV_SONG_VOD_STATE_CHANGED, Actions.ACTION_SUSPEND_BAR_VISIBILITY_CHANGED};
    }

    protected void handleServiceNotification(Intent intent) {
        String action = intent.getAction();
        if (action.equals(Out.STATUS_META_CHANGED) && intent.getBooleanExtra(ServiceActions.Out.KEY_CHANGED_ID3, false)) {
            launchLoader(true);
        } else if (action.equals(Out.STATUS_QUEUE_CHANGED)) {
            launchLoader(true);
        } else if (action.equals(Actions.ACTION_SUSPEND_BAR_VISIBILITY_CHANGED)) {
            refreshFootView();
        } else {
            update();
            if (Actions.ACTION_KTV_CONNECT_CHANGED.equals(action)) {
                refreshChoiceMode();
                if (this.mIsMainPage) {
                    refreshFootView();
                }
            }
        }
    }

    public void setAlphabetFastIndexerVisible(boolean visible) {
        if (this.mAlphabetIndexer != null) {
            this.mAlphabetIndexer.setVisibility(visible ? 0 : 8);
        }
    }

    public void setAlphabetFastIndexerAlpha(float alpha) {
        if (this.mAlphabetIndexer != null) {
            this.mAlphabetIndexer.setAlpha(alpha);
        }
    }

    public void setOnScrollListener(OnScrollListener l) {
        this.mScrollListener = l;
        if (this.mAdapter != null) {
            AbsListView lv = getListView();
            if (lv != null) {
                lv.setOnScrollListener(this.mAdapter.decorateScrollListener(l));
            }
        }
    }

    public void setOnCursorChangedListener(OnCursorChangedListener l) {
        this.mCursorChangedListener = l;
    }

    protected void refreshChoiceMode() {
        if (!isNowPlaying()) {
            super.refreshChoiceMode();
        }
    }
}
