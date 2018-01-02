package com.miui.player.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Audio.Artists.Albums;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.Out;
import com.miui.player.meta.AlbumManager;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.ImageDownloader;
import com.miui.player.network.ImageDownloader.DownloadTaskToken;
import com.miui.player.network.ImageDownloader.ImageDownloadController;
import com.miui.player.provider.MediaProviderHelper;
import com.miui.player.provider.PlayerStore.OnlineAudioDetail.Columns;
import com.miui.player.reporter.OnlinePlayStatstics;
import com.miui.player.ui.AlbumBrowserActivity;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MediaCursorLoader.MediaLoaderInfo;
import com.miui.player.ui.base.MediaCursorLoader.QueryArgs;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.ui.base.MusicBaseFragment.SectionCursorDecorator;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.ui.menu.AlbumBrowserMenu;
import com.miui.player.ui.menu.AlbumBrowserMenu.ContextInfo;
import com.miui.player.ui.menu.BaseMenuManager;
import com.miui.player.ui.model.AlbumListAdapter;
import com.miui.player.util.Actions;
import com.miui.player.util.SectionCursor.CursorConverter;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.StorageConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AlbumListFragment extends MusicBaseFragment {
    public static final int HEADER_ID_ALL_TRACK = -1;
    static AlbumDownloadAllController sAlbumDownloadController;
    static DownloadTaskToken sDownloadToken;
    AlbumListAdapter mAdapter;
    private long mArtistId;
    private String mArtistName;
    private int mCachedSongNum = -1;
    private Cursor mCursor;
    Handler mDelayedHandler = new Handler();
    final Runnable mDownloadAlbumRunnable = new C04932();
    private BaseMenuManager<Long> mMenuManager;
    private MultiChoiceController<Long> mMultiChoiceController;

    class C04921 implements OnScrollListener {
        C04921() {
        }

        public void onScrollStateChanged(AbsListView listView, int scrollState) {
            if (scrollState != 2) {
                AlbumListAdapter.sDrawableProvider.resume();
            } else {
                AlbumListAdapter.sDrawableProvider.pause();
            }
        }

        public void onScroll(AbsListView listView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }
    }

    class C04932 implements Runnable {
        C04932() {
        }

        public void run() {
            AlbumListFragment.this.mDelayedHandler.removeCallbacks(AlbumListFragment.this.mDownloadAlbumRunnable);
            if (AlbumListFragment.sDownloadToken == null) {
                AlbumListFragment.sDownloadToken = ImageDownloader.downloadAll(AlbumListFragment.sAlbumDownloadController);
            }
        }
    }

    private static class AlbumCursorDecorator extends SectionCursorDecorator {
        public AlbumCursorDecorator(CursorConverter converter, boolean hasHeader) {
            super(converter, hasHeader ? 1 : 0);
        }

        public Cursor decorate(Cursor cursor, QueryArgs args) {
            if (this.mHeaderCount > 0) {
                cursor = new MergeCursor(new Cursor[]{AlbumListFragment.makeSpecialCursor(-1), cursor});
            }
            return super.decorate(cursor, args);
        }
    }

    static class AlbumDownloadAllController implements ImageDownloadController {
        private WeakReference<AlbumListFragment> mFragmentRef;

        public AlbumDownloadAllController(AlbumListFragment f) {
            this.mFragmentRef = new WeakReference(f);
        }

        public List<ImageSearchInfo> getList(Context context) {
            List<ImageSearchInfo> list = new ArrayList();
            String orderBy = "album_id";
            Context context2 = context;
            Cursor cursor = SqlUtils.query(context2, Media.EXTERNAL_CONTENT_URI, new String[]{"album_id", "artist", "album"}, SqlUtils.wrapWithBlacklist(context, "album != ''"), null, "album_id");
            if (cursor != null) {
                try {
                    Set<String> set = MetaManager.getExistImageSet("album");
                    long lastId = -1;
                    while (cursor.moveToNext()) {
                        long aid = cursor.getLong(0);
                        if (aid != lastId) {
                            lastId = aid;
                            String artist = cursor.getString(1);
                            String album = cursor.getString(2);
                            if (!MetaManager.isUnknowName(album) || !MetaManager.isUnknowName(artist)) {
                                String name = StorageConfig.getAlbumFileName(album, artist);
                                if (!(name == null || set.contains(name) || AlbumManager.isAlbumExistInDB(context, aid))) {
                                    list.add(new ImageSearchInfo(aid, null, album, artist));
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
                AlbumListAdapter.removeCacheAlbum(info);
                AlbumListFragment fragment = (AlbumListFragment) this.mFragmentRef.get();
                if (fragment != null) {
                    AlbumBrowserActivity activity = (AlbumBrowserActivity) fragment.getActivity();
                    if (activity != null && !activity.isPaused() && !activity.isFinishing()) {
                        AlbumListAdapter adapter = fragment.mAdapter;
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        }

        public void setFragment(AlbumListFragment f) {
            this.mFragmentRef = new WeakReference(f);
        }
    }

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        if (icicle == null) {
            icicle = getActivity().getIntent().getExtras();
        }
        if (icicle == null) {
            icicle = new Bundle();
            Log.e(getTag(), "icicle is NULL");
        }
        this.mArtistId = icicle.getLong(Columns.ARTIST_ID, -1);
        this.mArtistName = icicle.getString("artist_name", null);
        AbsListView lv = getListView();
        this.mMenuManager = new AlbumBrowserMenu(this, 101711888, "_id");
        this.mMultiChoiceController = new MultiChoiceController(lv, this.mMenuManager);
        if (lv instanceof GridView) {
            this.mMultiChoiceController.setItemViewBinder(UIHelper.createBinderForGrid(C0329R.id.batch_selection_check, C0329R.id.album_mask));
        } else {
            this.mMultiChoiceController.setItemViewBinder(UIHelper.createBinderForList(C0329R.id.batch_selection_check));
        }
        lv.setOnItemClickListener(this);
        lv.setOnScrollListener(new C04921());
        this.mAdapter = new AlbumListAdapter(getActivity(), this, C0329R.layout.album_picker_item, this.mCursor, this.mArtistId, null, this.mMultiChoiceController);
        AlbumListAdapter.startCache(MusicApplication.getApplication());
        setListAdapter(this.mAdapter);
        this.mMenuManager.setAdapter(this.mAdapter);
        if (sAlbumDownloadController == null) {
            sAlbumDownloadController = new AlbumDownloadAllController(this);
        } else {
            sAlbumDownloadController.setFragment(this);
        }
        this.mDelayedHandler.postDelayed(this.mDownloadAlbumRunnable, OnlinePlayStatstics.MIN_LOOP_TIME);
        launchLoader(true);
    }

    public void onSaveInstanceState(Bundle outcicle) {
        outcicle.putLong(Columns.ARTIST_ID, this.mArtistId);
        outcicle.putString("artist_name", this.mArtistName);
        super.onSaveInstanceState(outcicle);
    }

    public void onDestroy() {
        this.mDelayedHandler.removeCallbacks(this.mDownloadAlbumRunnable);
        AlbumListAdapter.quitCache();
        setListAdapter(null);
        if (this.mMenuManager != null) {
            this.mMenuManager.setAdapter(null);
        }
        this.mAdapter = null;
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
        refreshChoiceMode();
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (this.mMenuManager.onContextItemSelected(item)) {
            return true;
        }
        return super.onContextItemSelected(item);
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        Intent intent = new Intent(Actions.ACTION_BROWSER);
        intent.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_TRACK);
        String artist = this.mArtistName;
        if (position >= 0) {
            intent.putExtra("album_id", id);
            if (this.mCursor != null && this.mCursor.moveToPosition(position)) {
                intent.putExtra("album_name", this.mCursor.getString(this.mCursor.getColumnIndex("album")));
                if (artist == null) {
                    artist = this.mCursor.getString(this.mCursor.getColumnIndex("artist"));
                }
            }
        }
        intent.putExtra(Columns.ARTIST_ID, this.mArtistId);
        intent.putExtra("artist_name", artist);
        startActivity(intent);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        this.mMenuManager.onCreateOptionsMenu(menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        this.mMenuManager.onPrepareOptionsMenu(menu);
        super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.mMenuManager.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean swapCursor(Cursor cursor) {
        if (this.mCursor == cursor) {
            return false;
        }
        this.mCursor = cursor;
        return true;
    }

    protected MediaLoaderInfo getMediaLoaderInfo() {
        Uri uri;
        String where;
        boolean z;
        Cursor c = MediaProviderHelper.queryValidAlbumIdCursor(getActivity());
        String set = null;
        if (c != null) {
            try {
                set = SqlUtils.concatIdsAsSet(c, 0);
            } finally {
                c.close();
            }
        }
        String[] cols = AlbumListAdapter.ALBUM_COLUMNS;
        if (this.mArtistId >= 0) {
            uri = Albums.getContentUri("external", this.mArtistId);
            if (set != null) {
                where = " audio.album_id  IN " + set;
            } else {
                where = null;
            }
        } else {
            uri = Audio.Albums.EXTERNAL_CONTENT_URI;
            where = set != null ? " _id  IN " + set : null;
        }
        QueryArgs args = new QueryArgs(MusicApplication.getApplication().getContentResolver(), uri, cols, where, null, null, null);
        CursorConverter converter = AlbumListAdapter.createCursorConverter();
        if (this.mArtistId >= 0) {
            z = true;
        } else {
            z = false;
        }
        return new MediaLoaderInfo(new AlbumCursorDecorator(converter, z), args);
    }

    protected CursorAdapter getCursorAdapter() {
        return this.mAdapter;
    }

    public void handleLoadFinished(int loaderId, Cursor cursor) {
        super.handleLoadFinished(loaderId, cursor);
        if (this.mAdapter != null) {
            this.mCachedSongNum = -1;
            this.mAdapter.changeCursor(cursor);
            if (this.mCursor != null) {
            }
        }
    }

    public ContextInfo getMenuContextInfo() {
        ContextInfo ctx = new ContextInfo();
        ctx.mCursor = this.mCursor;
        ctx.mMultiChoiceController = this.mMultiChoiceController;
        return ctx;
    }

    public boolean isBatchSelectionModeEnabled() {
        return this.mMultiChoiceController.isEnabled();
    }

    public boolean leaveMultiChoiceMode() {
        if (this.mMultiChoiceController.leave()) {
            return true;
        }
        return false;
    }

    public void downloadAllAlbums() {
        this.mDelayedHandler.removeCallbacks(this.mDownloadAlbumRunnable);
        boolean started = true;
        if (sDownloadToken == null || sDownloadToken.isFinished()) {
            sDownloadToken = ImageDownloader.downloadAll(sAlbumDownloadController);
            started = sDownloadToken != null;
        }
        if (started) {
            Toast.makeText(getActivity(), C0329R.string.start_to_download_album, 0).show();
        } else {
            Toast.makeText(getActivity(), C0329R.string.network_error, 0).show();
        }
    }

    protected String[] getObservedServiceActions() {
        return new String[]{Out.STATUS_META_CHANGED, Out.STATUS_PLAYSTATE_CHANGED, Out.STATUS_PLAYBACK_COMPLETE, Actions.ACTION_KTV_CONNECT_CHANGED};
    }

    protected void handleServiceNotification(Intent intent) {
        super.handleServiceNotification(intent);
        if (this.mAdapter != null && !isPaused()) {
            String action = intent.getAction();
            boolean refresh = false;
            if (Out.STATUS_PLAYSTATE_CHANGED.equals(action)) {
                refresh = true;
            } else if (Out.STATUS_META_CHANGED.equals(action)) {
                refresh = Out.META_CHANGED_ALBUM.equals(action) || Out.META_CHANGED_TRACK.equals(action);
            } else if (Actions.ACTION_KTV_CONNECT_CHANGED.equals(action)) {
                refreshChoiceMode();
            }
            if (refresh) {
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    public static Cursor makeSpecialCursor(int headerId) {
        Object[] columnValues = new Object[AlbumListAdapter.ALBUM_COLUMNS.length];
        columnValues[0] = Integer.valueOf(headerId);
        MatrixCursor mc = new MatrixCursor(AlbumListAdapter.ALBUM_COLUMNS, 1);
        mc.addRow(columnValues);
        return mc;
    }

    public int getSongNumForArtist() {
        if (this.mCachedSongNum < 0) {
            this.mCachedSongNum = MediaProviderHelper.getTrackCount(getActivity(), this.mArtistId);
        }
        return this.mCachedSongNum;
    }
}
