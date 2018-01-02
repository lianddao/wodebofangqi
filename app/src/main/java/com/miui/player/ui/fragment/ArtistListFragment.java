package com.miui.player.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Audio.Artists;
import android.provider.MediaStore.Audio.Media;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.ImageDownloader;
import com.miui.player.network.ImageDownloader.DownloadTaskToken;
import com.miui.player.network.ImageDownloader.ImageDownloadController;
import com.miui.player.provider.MediaProviderHelper;
import com.miui.player.provider.PlayerStore.OnlineAudioDetail.Columns;
import com.miui.player.reporter.OnlinePlayStatstics;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.UIHelper.ListViewPositionWrap;
import com.miui.player.ui.base.MediaCursorLoader.MediaLoaderInfo;
import com.miui.player.ui.base.MediaCursorLoader.QueryArgs;
import com.miui.player.ui.base.MediaCursorLoader.Selection;
import com.miui.player.ui.base.MediaCursorLoader.SelectionDecorator;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.ui.base.MusicBaseFragment.SectionCursorDecorator;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.ui.controller.MultiChoiceController.ModeChangedListener;
import com.miui.player.ui.menu.ArtistBrowserMenu;
import com.miui.player.ui.menu.ArtistBrowserMenu.ContextInfo;
import com.miui.player.ui.menu.BaseMenuManager;
import com.miui.player.ui.model.ArtistListAdapter;
import com.miui.player.util.Actions;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.StorageConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import miui.v5.widget.Views;

public class ArtistListFragment extends MusicBaseFragment {
    static AvatarDownloadAllController sAvatarDownloadController;
    static DownloadTaskToken sDownloadToken;
    private static final ListViewPositionWrap sListViewPositionWrap = new ListViewPositionWrap();
    private ArtistListAdapter mAdapter;
    private View mAllAlbumView;
    private Cursor mCursor;
    Handler mDelayedHandler = new Handler();
    final Runnable mDownloadAvatarRunnable = new C04952();
    private int mHeadViewCount;
    private ListView mListView;
    private BaseMenuManager<Long> mMenuManager;
    private MultiChoiceController<Long> mMultiChoiceController;

    class C04952 implements Runnable {
        C04952() {
        }

        public void run() {
            ArtistListFragment.this.mDelayedHandler.removeCallbacks(ArtistListFragment.this.mDownloadAvatarRunnable);
            if (ArtistListFragment.sDownloadToken == null) {
                ArtistListFragment.sDownloadToken = ImageDownloader.downloadAll(ArtistListFragment.sAvatarDownloadController);
            }
        }
    }

    static class AvatarDownloadAllController implements ImageDownloadController {
        private WeakReference<ArtistListFragment> mFragmentRef;

        public AvatarDownloadAllController(ArtistListFragment f) {
            this.mFragmentRef = new WeakReference(f);
        }

        public List<ImageSearchInfo> getList(Context context) {
            List<ImageSearchInfo> list = new ArrayList();
            String orderBy = "artist";
            Context context2 = context;
            Cursor cursor = SqlUtils.query(context2, Media.EXTERNAL_CONTENT_URI, new String[]{"artist"}, SqlUtils.wrapWithBlacklist(context, "artist != ''"), null, "artist");
            if (cursor != null) {
                try {
                    Set<String> set = MetaManager.getExistImageSet(StorageConfig.META_TYPE_AVATAR);
                    String lastAr = MetaManager.UNKNOWN_STRING;
                    while (cursor.moveToNext()) {
                        String artist = cursor.getString(0);
                        if (!(artist == null || artist.equals(lastAr))) {
                            lastAr = artist;
                            if (!MetaManager.isUnknowName(artist)) {
                                String name = StorageConfig.getAvatarFileName(artist);
                                if (!(name == null || set.contains(name))) {
                                    list.add(new ImageSearchInfo(artist));
                                }
                            }
                        }
                    }
                } finally {
                    cursor.close();
                }
            }
            return list;
        }

        public void onUpdate(ImageSearchInfo info) {
            if (info != null) {
                ArtistListAdapter.removeCacheAvatar(info);
                ArtistListFragment fragment = (ArtistListFragment) this.mFragmentRef.get();
                if (fragment != null) {
                    Activity activity = fragment.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        ArtistListAdapter adapter = fragment.mAdapter;
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        }

        public void setFragment(ArtistListFragment a) {
            this.mFragmentRef = new WeakReference(a);
        }
    }

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        this.mMenuManager = new ArtistBrowserMenu(this, C0329R.plurals.Nitems_batch_selection, "_id");
        this.mListView = (ListView) getListView();
        this.mListView.setOnItemClickListener(this);
        this.mAllAlbumView = Views.inflate(getActivity(), C0329R.layout.artist_picker_item, this.mListView, false);
        this.mListView.addHeaderView(this.mAllAlbumView);
        this.mMultiChoiceController = new MultiChoiceController(this.mListView, this.mMenuManager);
        this.mMultiChoiceController.setItemViewBinder(UIHelper.createBinderForList(C0329R.id.batch_selection_check));
        this.mMultiChoiceController.setOnModeChangedListener(this);
        this.mAdapter = new ArtistListAdapter(getActivity(), this, null, C0329R.layout.artist_picker_item, null, this.mMultiChoiceController);
        this.mMenuManager.setAdapter(this.mAdapter);
        if (this.mListView != null) {
            this.mListView.setAdapter(this.mAdapter);
        }
        if (sAvatarDownloadController == null) {
            sAvatarDownloadController = new AvatarDownloadAllController(this);
        } else {
            sAvatarDownloadController.setFragment(this);
        }
        this.mDelayedHandler.postDelayed(this.mDownloadAvatarRunnable, OnlinePlayStatstics.MIN_LOOP_TIME);
        ArtistListAdapter.startCache();
        this.mHeadViewCount = this.mListView.getHeaderViewsCount();
        setHasOptionsMenu(true);
    }

    public void onResume() {
        super.onResume();
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
        refreshChoiceMode();
        refreshFootView();
    }

    public void onDestroy() {
        this.mDelayedHandler.removeCallbacks(this.mDownloadAvatarRunnable);
        sListViewPositionWrap.saveListPosition(this.mListView);
        ArtistListAdapter.quitCache();
        if (this.mListView != null) {
            this.mListView.setAdapter(null);
        }
        this.mAdapter = null;
        super.onDestroy();
    }

    protected MediaLoaderInfo getMediaLoaderInfo() {
        SelectionDecorator selectionDecorator = new SelectionDecorator(null) {
            protected Selection doDecorate(String where, String[] args) {
                Activity a = ArtistListFragment.this.getActivity();
                if (a != null) {
                    Cursor c = MediaProviderHelper.queryValidArtistIdCursor(a);
                    if (c != null) {
                        try {
                            Selection selection = new Selection("_id IN " + SqlUtils.concatIdsAsSet(c, 0), args);
                            return selection;
                        } finally {
                            c.close();
                        }
                    }
                }
                return null;
            }
        };
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return new MediaLoaderInfo(new SectionCursorDecorator(ArtistListAdapter.createCursorConverter(), 0), new QueryArgs(activity.getContentResolver(), Artists.EXTERNAL_CONTENT_URI, ArtistListAdapter.ARTIST_COLUMNS, null, null, null, selectionDecorator));
    }

    public boolean swapCursor(Cursor cursor) {
        if (this.mCursor == cursor) {
            return false;
        }
        this.mCursor = cursor;
        return true;
    }

    protected CursorAdapter getCursorAdapter() {
        return this.mAdapter;
    }

    public void handleLoadFinished(int loaderId, Cursor cursor) {
        super.handleLoadFinished(loaderId, cursor);
        if (this.mAdapter != null) {
            boolean first = this.mCursor == null;
            this.mAdapter.changeCursor(cursor);
            this.mAdapter.notifyDataSetChanged();
            if (this.mCursor != null) {
                if (first) {
                    sListViewPositionWrap.restoreListPosition(this.mListView);
                }
                if (this.mAllAlbumView != null) {
                    updateAllAlbumView();
                }
            }
        }
    }

    public void downloadAllAvatars() {
        this.mDelayedHandler.removeCallbacks(this.mDownloadAvatarRunnable);
        boolean started = true;
        if (sDownloadToken == null || sDownloadToken.isFinished()) {
            sDownloadToken = ImageDownloader.downloadAll(sAvatarDownloadController);
            started = sDownloadToken != null;
        }
        if (started) {
            Toast.makeText(getActivity(), C0329R.string.start_to_download_avatar, 0).show();
        } else {
            Toast.makeText(getActivity(), C0329R.string.network_error, 0).show();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        Intent intent = new Intent(Actions.ACTION_BROWSER);
        intent.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_ALBUM);
        if (position >= this.mHeadViewCount && this.mCursor != null && this.mCursor.moveToPosition(position - this.mHeadViewCount)) {
            String artist = this.mCursor.getString(this.mCursor.getColumnIndex("artist"));
            intent.putExtra(Columns.ARTIST_ID, id);
            intent.putExtra("artist_name", artist);
        }
        startActivity(intent);
    }

    private void updateAllAlbumView() {
        ((TextView) this.mAllAlbumView.findViewById(C0329R.id.primary_text)).setText(C0329R.string.artist_albums);
        ((ImageView) this.mAllAlbumView.findViewById(C0329R.id.avatar)).setImageResource(C0329R.drawable.album_item_default);
        ((ImageView) this.mAllAlbumView.findViewById(C0329R.id.list_text_separator)).setVisibility(0);
        Resources r = getActivity().getResources();
        String albumCount = UIHelper.format(r.getQuantityText(C0329R.plurals.Nalbums_format, 0).toString(), Integer.valueOf(MediaProviderHelper.getAlbumCount(getActivity(), -1)));
        String trackCount = UIHelper.format(r.getQuantityText(C0329R.plurals.Ntracks_format, 0).toString(), Integer.valueOf(MediaProviderHelper.getTrackCount(getActivity(), -1)));
        ((TextView) this.mAllAlbumView.findViewById(C0329R.id.secondary_first_text)).setText(albumCount);
        ((TextView) this.mAllAlbumView.findViewById(C0329R.id.secondary_second_text)).setText(trackCount);
    }

    public ContextInfo getMenuContextInfo() {
        ContextInfo ctx = new ContextInfo();
        ctx.mCursor = this.mCursor;
        ctx.mHeaderCount = this.mListView.getHeaderViewsCount();
        ctx.mMultiChoiceController = this.mMultiChoiceController;
        return ctx;
    }

    public void onModeChanged(boolean enabled, AbsListView lv) {
        Activity a = getActivity();
        if (a instanceof ModeChangedListener) {
            ((ModeChangedListener) a).onModeChanged(enabled, lv);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        this.mMenuManager.onCreateOptionsMenu(menu);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        this.mMenuManager.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return this.mMenuManager.onOptionsItemSelected(item);
    }

    public boolean leaveMultiChoiceMode() {
        if (this.mMultiChoiceController == null || !this.mMultiChoiceController.leave()) {
            return false;
        }
        return true;
    }

    protected String[] getObservedServiceActions() {
        return new String[]{Actions.ACTION_KTV_CONNECT_CHANGED, Actions.ACTION_SUSPEND_BAR_VISIBILITY_CHANGED};
    }

    protected void handleServiceNotification(Intent intent) {
        String action = intent.getAction();
        if (Actions.ACTION_KTV_CONNECT_CHANGED.equals(action)) {
            refreshChoiceMode();
            refreshFootView();
        } else if (Actions.ACTION_SUSPEND_BAR_VISIBILITY_CHANGED.equals(action)) {
            refreshFootView();
        }
    }
}
