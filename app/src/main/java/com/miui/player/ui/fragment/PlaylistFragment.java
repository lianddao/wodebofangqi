package com.miui.player.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.collect.Lists;
import com.miui.player.C0329R;
import com.miui.player.PlayerActions.Out;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.KtvPlaylistCache;
import com.miui.player.provider.PlayerStore.MemberColomns;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Columns;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Members;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.provider.StatisticsHelper;
import com.miui.player.service.HistoryManager;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.DialogCallback;
import com.miui.player.ui.FolderBrowserActivity;
import com.miui.player.ui.OperationDialog;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MediaCursorLoader.MediaLoaderInfo;
import com.miui.player.ui.base.MediaCursorLoader.QueryArgs;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.ui.base.MusicBaseFragment.SectionCursorDecorator;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.ui.model.PlaylistListAdapter;
import com.miui.player.util.Actions;
import com.miui.player.util.SectionCursor.CursorConverter;
import com.miui.player.util.SqlUtils;
import com.miui.player.vod.ThunderStoneKtvNetwork;
import java.util.List;

public class PlaylistFragment extends MusicBaseFragment implements DialogCallback {
    public static final int CREATE_NEW_PLAYLIST = -106;
    private static final int DELETE_PLAYLIST = 34;
    public static final int FAVOURITE_PLAYLIST = -101;
    public static final int FREQUENTLY_PLAYED_PLAYLIST = -104;
    public static final int INVALID_PLAYLIST = -107;
    private static final int ITEM_FOLDER = -108;
    private static final String MENU_KEY_ID = "src_playlist";
    public static final int MY_KTV_PLAYLIST = -105;
    public static final int RECENTLY_ADDED_PLAYLIST = -103;
    public static final int RECENTLY_PLAYED_PLAYLIST = -102;
    private static final int RENAME_PLAYLIST = 35;
    private static final int REQUEST_CODE_ADD_TRACK = 1;
    static final int[] SYS_PLAYLIST_NAMES = new int[]{C0329R.string.playlist_recently_added, C0329R.string.playlist_recently_played, C0329R.string.playlist_frequently_played, C0329R.string.playlist_my_ktv};
    PlaylistListAdapter mAdapter;
    private final Runnable mAdapterUpdateRunnable = new C05061();
    private Cursor mCursor;
    private ListView mListView;
    private boolean mNotifyImmediately = false;
    private PlaylistItem[] mPresetFooters;
    private PlaylistItem[] mPresetHeaders;
    private RefreshReceiver mRefreshReceiver;

    class C05061 implements Runnable {
        C05061() {
        }

        public void run() {
            PlaylistFragment.this.update();
        }
    }

    private static class PlaylistCursorDecorator extends SectionCursorDecorator {
        private final PlaylistItem[] mFooters;
        private final PlaylistItem[] mHeaders;

        public PlaylistCursorDecorator(CursorConverter converter, PlaylistItem[] headers, PlaylistItem[] footers) {
            super(converter, 0);
            this.mHeaders = headers;
            this.mFooters = footers;
        }

        public Cursor decorate(Cursor cursor, QueryArgs args) {
            cursor = super.decorate(cursor, args);
            if (cursor != null) {
                cursor.setNotificationUri(args.mResolver, args.mUri);
            }
            if (this.mHeaders == null || this.mFooters == null) {
                return cursor;
            }
            return mergedCursor(cursor, this.mHeaders, this.mFooters);
        }

        private static Cursor mergedCursor(Cursor c, PlaylistItem[] headers, PlaylistItem[] footers) {
            if (c == null) {
                return null;
            }
            if (c instanceof MergeCursor) {
                Log.d("PlaylistBrowserActivity", "Already wrapped");
                return c;
            }
            MatrixCursor headerCursor = new MatrixCursor(c.getColumnNames());
            for (PlaylistItem item : headers) {
                headerCursor.addRow(item.toRecord());
            }
            MatrixCursor footerCursor = new MatrixCursor(c.getColumnNames());
            for (PlaylistItem item2 : footers) {
                footerCursor.addRow(item2.toRecord());
            }
            return new MergeCursor(new Cursor[]{headerCursor, c, footerCursor});
        }
    }

    public static class PlaylistItem {
        public final int mItemId;
        public final String mName;

        public PlaylistItem(Context context, int itemId, int nameResId) {
            this.mItemId = itemId;
            this.mName = context.getString(nameResId);
        }

        public Object[] toRecord() {
            Object[] rec = new Object[3];
            rec[0] = Integer.valueOf(this.mItemId);
            rec[1] = this.mName;
            return rec;
        }
    }

    private class RefreshReceiver extends BroadcastReceiver {
        private static final String TAG = "RefreshReceiver";
        private Context mContext;
        private boolean mIsRegistered = false;

        public RefreshReceiver(Context context) {
            this.mContext = context;
        }

        public void onReceive(Context context, Intent intent) {
            if (Actions.ACTION_PLAYLIST_SIZE_CHANGED.equals(intent.getAction())) {
                PlaylistFragment.this.refreshSize();
            }
        }

        public void register() {
            if (!this.mIsRegistered) {
                this.mIsRegistered = true;
                IntentFilter filter = new IntentFilter();
                filter.addAction(Actions.ACTION_PLAYLIST_SIZE_CHANGED);
                this.mContext.registerReceiver(this, filter);
            }
        }

        public void unregister() {
            if (this.mIsRegistered) {
                this.mIsRegistered = false;
                this.mContext.unregisterReceiver(this);
            }
        }
    }

    public void onCreate(Bundle icicle) {
        initilizePresetItems();
        this.mRefreshReceiver = new RefreshReceiver(getActivity());
        this.mRefreshReceiver.register();
        super.onCreate(icicle);
    }

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        this.mListView = (ListView) getListView();
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnCreateContextMenuListener(this);
        int leftMargin = getResources().getDimensionPixelOffset(C0329R.dimen.mainpage_list_item_margin_left);
        View v = UIHelper.makeSpecialView(this.mListView, (int) ITEM_FOLDER, (int) C0329R.drawable.enter_indicator, (int) C0329R.string.folders_title, leftMargin);
        v.setLongClickable(false);
        this.mListView.addHeaderView(v);
        this.mListView.addFooterView(UIHelper.makeSpecialView(this.mListView, (int) CREATE_NEW_PLAYLIST, 0, (int) C0329R.string.new_playlist, leftMargin));
        this.mAdapter = new PlaylistListAdapter(getActivity(), this, C0329R.layout.playlist_picker_item, this.mCursor, null);
        setListAdapter(this.mAdapter);
    }

    public void onResume() {
        super.onResume();
        if (this.mNotifyImmediately) {
            update();
        } else {
            this.mListView.postDelayed(this.mAdapterUpdateRunnable, 3000);
        }
        refreshFootView();
    }

    public void onDestroy() {
        setListAdapter(null);
        this.mAdapter = null;
        this.mRefreshReceiver.unregister();
        super.onDestroy();
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfoIn) {
        AdapterContextMenuInfo mi = (AdapterContextMenuInfo) menuInfoIn;
        int headViewsCount = 0;
        if (view instanceof ListView) {
            ListView lv = (ListView) view;
            headViewsCount = lv.getHeaderViewsCount();
            if (mi.position < headViewsCount || mi.position >= lv.getCount() - lv.getFooterViewsCount()) {
                return;
            }
        }
        Intent extras = new Intent().putExtra(MENU_KEY_ID, mi.id);
        int playlistType = PlaylistHelper.getOnlinePlaylistType(view.getContext(), getPlaylistId(mi.id));
        if (!(playlistType == 103 || playlistType == 102)) {
            menu.add(0, 5, 0, C0329R.string.play_selection).setIntent(extras);
        }
        if (mi.id >= 0) {
            menu.add(0, 34, 0, C0329R.string.delete_playlist_menu).setIntent(extras);
            if (!PlaylistHelper.isOnlinePlaylist(playlistType)) {
                menu.add(0, 28, 0, C0329R.string.add_tracks).setIntent(extras);
            }
        } else if (mi.id == -101) {
            menu.add(0, 28, 0, C0329R.string.add_tracks).setIntent(extras);
        }
        if (!PlaylistHelper.isOnlinePlaylist(playlistType)) {
            UIHelper.makePlaylistMenu(getActivity(), menu.addSubMenu(0, 1, 0, C0329R.string.add_to_playlist), extras, getPlaylistId(mi.id));
        }
        if (view != getListView()) {
            menu.setHeaderTitle(SYS_PLAYLIST_NAMES[mi.position - headViewsCount]);
        } else if (this.mCursor.moveToPosition(mi.position - headViewsCount)) {
            menu.setHeaderTitle(this.mCursor.getString(this.mCursor.getColumnIndexOrThrow("name")));
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        long plid = parseMenuIntent(item.getIntent());
        long[] list;
        switch (item.getItemId()) {
            case 3:
                Intent intent = item.getIntent();
                if (intent != null) {
                    long dstId = intent.getLongExtra(UIHelper.DST_PLAYLIST_KEY, -107);
                    if (!(plid == -107 || dstId == -107)) {
                        list = getSeletedTrackIds(plid);
                        if (list != null) {
                            PlaylistHelper.addToPlaylistAsync(getActivity(), list, dstId, true, this.mAdapterUpdateRunnable);
                        }
                    }
                }
                return true;
            case 4:
                OperationDialog.makePlaylistCreator(getActivity(), this, CREATE_NEW_PLAYLIST, item.getIntent()).show();
                return true;
            case 5:
                if (PlaylistHelper.getOnlinePlaylistType(getActivity(), plid) == 101) {
                    Cursor plCursor = SqlUtils.query(getActivity(), MiuiPlaylists.EXTERNAL_URI, new String[]{"name"}, "_id=?", new String[]{Long.toString(plid)}, null, 1);
                    if (plCursor != null) {
                        try {
                            if (plCursor.moveToNext()) {
                                UIHelper.playChannel(getActivity(), Long.toString(plid), plCursor.getString(0));
                            }
                            plCursor.close();
                        } catch (Throwable th) {
                            plCursor.close();
                        }
                    }
                } else if (ServiceHelper.sService != null) {
                    list = getSeletedTrackIds(plid);
                    if (list != null && list.length > 0) {
                        ServiceHelper.playAll(getActivity(), list, 0);
                    }
                }
                return true;
            case 12:
                long itemId = parseMenuIntent(item.getIntent());
                if (itemId != -107) {
                    list = getSeletedTrackIds(itemId);
                    if (list != null && list.length > 0) {
                        ServiceHelper.addToCurrentPlaylist(getActivity(), list);
                    }
                }
                return true;
            case BaseMenuId.ADD_TRACKS /*28*/:
                if (plid == -101) {
                    plid = FavoriteCache.getFavoritePlaylistId(getActivity());
                }
                Intent picker = new Intent(Actions.ACTION_TRACKS_PICKER);
                picker.putExtra(MemberColomns.PLAYLIST_ID, plid);
                startActivityForResult(picker, 1);
                return true;
            case 34:
                PlaylistHelper.deletePlaylist(getActivity(), plid);
                Toast.makeText(getActivity(), C0329R.string.playlist_deleted_message, 0).show();
                return true;
            case 35:
                OperationDialog dialog = OperationDialog.makePlaylistRenamer(getActivity(), this, 35, item.getIntent(), plid);
                if (dialog != null) {
                    dialog.show();
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private long parseMenuIntent(Intent extras) {
        if (extras != null) {
            return extras.getLongExtra(MENU_KEY_ID, -107);
        }
        return -107;
    }

    private long getPlaylistId(long itemId) {
        if (itemId == -101) {
            return FavoriteCache.getFavoritePlaylistId(getActivity());
        }
        return itemId;
    }

    private long[] getSeletedTrackIds(long itemId) {
        if (itemId == -103) {
            return getRecentlyAddedIds();
        }
        if (itemId == -102) {
            return HistoryManager.loadLatest(getActivity());
        }
        if (itemId == -104) {
            return StatisticsHelper.queryFrequentlyPlayed(getActivity());
        }
        long playlistId = itemId;
        if (itemId == -101) {
            playlistId = FavoriteCache.getFavoritePlaylistId(getActivity());
        }
        return PlaylistHelper.getTrackListForPlaylist(getActivity(), playlistId, null);
    }

    private long[] getRecentlyAddedIds() {
        Cursor cursor = SqlUtils.query(getActivity(), Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, SqlUtils.wrapWithBlacklist(getActivity(), PlaylistHelper.recentlyAddedWhere(getActivity())), null, "title_key");
        if (cursor != null) {
            try {
                int len = cursor.getCount();
                long[] jArr = new long[len];
                for (int i = 0; i < len; i++) {
                    cursor.moveToNext();
                    jArr[i] = cursor.getLong(0);
                }
                return jArr;
            } catch (SQLiteException e) {
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    public boolean swapCursor(Cursor cursor) {
        if (this.mCursor == cursor) {
            return false;
        }
        this.mCursor = cursor;
        return true;
    }

    public void onDialogResult(int requestCode, boolean confirm, Intent intent) {
        switch (requestCode) {
            case CREATE_NEW_PLAYLIST /*-106*/:
                if (confirm) {
                    Uri uri = intent.getData();
                    if (uri != null) {
                        long playlistId = Long.valueOf(uri.getLastPathSegment()).longValue();
                        Intent callback = (Intent) intent.getParcelableExtra(OperationDialog.KEY_CALLBACK);
                        if (callback != null) {
                            long srcId = parseMenuIntent(callback);
                            if (srcId != -107) {
                                long[] ids = getSeletedTrackIds(srcId);
                                if (ids != null) {
                                    PlaylistHelper.addToPlaylistAsync(getActivity(), ids, playlistId, false, this.mAdapterUpdateRunnable);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        Intent picker = new Intent(Actions.ACTION_TRACKS_PICKER);
                        picker.putExtra(MemberColomns.PLAYLIST_ID, playlistId);
                        startActivityForResult(picker, 1);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        String name;
        Object tag = v.getTag();
        if (tag != null) {
            if (((Integer) tag).intValue() == ITEM_FOLDER) {
                startActivity(new Intent(getActivity(), FolderBrowserActivity.class));
                return;
            } else if (((Integer) tag).intValue() == CREATE_NEW_PLAYLIST) {
                OperationDialog.makePlaylistCreator(getActivity(), this, CREATE_NEW_PLAYLIST, null).show();
                return;
            }
        }
        boolean editable = true;
        if (id == -103) {
            name = PlaylistHelper.PLAYLIST_RECENTLY_ADDED;
            editable = false;
        } else if (id == -102) {
            name = PlaylistHelper.PLAYLIST_RECENTLY_PLAYED;
            editable = false;
        } else if (id == -104) {
            name = PlaylistHelper.PLAYLSIT_FREQUENTLY_PLAYED;
            editable = false;
        } else if (id == -101) {
            name = String.valueOf(FavoriteCache.getFavoritePlaylistId(getActivity()));
        } else if (id == -105) {
            name = String.valueOf(KtvPlaylistCache.getPlaylistId(getActivity()));
        } else {
            name = String.valueOf(id);
        }
        Cursor plCursor = SqlUtils.query(v.getContext(), MiuiPlaylists.EXTERNAL_URI, new String[]{"name", Columns.MI_ONLINE_LIST_ID, "list_type"}, "_id=?", new String[]{name}, null, 1);
        String playlistName = null;
        String onlinePlaylistId = null;
        int listType = 0;
        if (plCursor != null) {
            if (plCursor.moveToFirst()) {
                playlistName = plCursor.getString(0);
                onlinePlaylistId = plCursor.getString(1);
                listType = plCursor.getInt(2);
            }
            plCursor.close();
        }
        Intent intent;
        if (onlinePlaylistId == null || !PlaylistHelper.isOnlinePlaylist(listType)) {
            intent = new Intent(Actions.ACTION_BROWSER);
            intent.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_TRACK);
            intent.putExtra("playlist_name", name);
            intent.putExtra("editmode", editable);
            startActivity(intent);
        } else if (listType == 101) {
            UIHelper.playChannel(getActivity(), onlinePlaylistId, playlistName);
        } else {
            intent = new Intent(Actions.ACTION_BROWSER);
            intent.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_ONLINE_PREVIEW_ONLINE_PLAYLIST);
            intent.putExtra(Actions.KEY_PLAYLIST_ONLINE_ID, onlinePlaylistId);
            intent.putExtra("playlist_name", playlistName);
            intent.putExtra(Actions.KEY_PLAYLIST_TYPE, listType);
            startActivity(intent);
        }
    }

    protected CursorAdapter getCursorAdapter() {
        return this.mAdapter;
    }

    public void handleLoadFinished(int loaderId, Cursor cursor) {
        if (this.mAdapter != null) {
            this.mAdapter.changeCursor(cursor);
        }
    }

    public MediaLoaderInfo getMediaLoaderInfo() {
        List<Integer> typeList = Lists.newArrayList();
        typeList.add(Integer.valueOf(0));
        typeList.addAll(PlaylistHelper.ONLINE_PLAYLIST_TYPES);
        return new MediaLoaderInfo(new PlaylistCursorDecorator(PlaylistListAdapter.createCursorConverter(), this.mPresetHeaders, this.mPresetFooters), new QueryArgs(getActivity().getContentResolver(), MiuiPlaylists.EXTERNAL_URI, PlaylistListAdapter.PLAYLIST_COLUMNS, "name != '' AND (list_type IN " + SqlUtils.concatNumberAsSet(typeList) + ") AND (" + "mi_sync_playlist_state" + "!=?)", new String[]{String.valueOf(1)}, null, null));
    }

    private void initilizePresetItems() {
        List<PlaylistItem> list = Lists.newArrayList();
        list.add(new PlaylistItem(getActivity(), -101, C0329R.string.playlist_favorite));
        list.add(new PlaylistItem(getActivity(), -102, C0329R.string.playlist_recently_played));
        list.add(new PlaylistItem(getActivity(), -103, C0329R.string.playlist_recently_added));
        list.add(new PlaylistItem(getActivity(), FREQUENTLY_PLAYED_PLAYLIST, C0329R.string.playlist_frequently_played));
        if (ThunderStoneKtvNetwork.isKtvValid()) {
            list.add(new PlaylistItem(getActivity(), MY_KTV_PLAYLIST, C0329R.string.playlist_my_ktv));
        }
        this.mPresetHeaders = new PlaylistItem[list.size()];
        list.toArray(this.mPresetHeaders);
        this.mPresetFooters = new PlaylistItem[0];
    }

    public PlaylistItem findPresetItem(long itemId) {
        for (PlaylistItem item : this.mPresetHeaders) {
            if (((long) item.mItemId) == itemId) {
                return item;
            }
        }
        for (PlaylistItem item2 : this.mPresetFooters) {
            if (((long) item2.mItemId) == itemId) {
                return item2;
            }
        }
        return null;
    }

    public int getPresetRecordCount(int itemId) {
        if (!this.mNotifyImmediately) {
            return 0;
        }
        if (itemId < 0) {
            switch (itemId) {
                case MY_KTV_PLAYLIST /*-105*/:
                    return KtvPlaylistCache.size(getActivity());
                case FREQUENTLY_PLAYED_PLAYLIST /*-104*/:
                    return StatisticsHelper.queryFrequentlyPlayedCount(getActivity());
                case -103:
                    return PlaylistHelper.getRecentlyAddedTrackCount(getActivity());
                case -102:
                    return PlaylistHelper.getRecentlyPlayedTrackCount(getActivity());
                case -101:
                    return FavoriteCache.size(getActivity());
                default:
                    throw new IllegalArgumentException("bad item id=" + itemId);
            }
        }
        String[] args = new String[]{String.valueOf(1)};
        return SqlUtils.getRecordCount(getActivity(), Members.getMembersUri((long) itemId), "mi_sync_track_state!=?", args);
    }

    public void update() {
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
            this.mNotifyImmediately = true;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case 1:
                if (resultCode == -1 && intent != null) {
                    long playlistId = intent.getLongExtra(MemberColomns.PLAYLIST_ID, -1);
                    long[] trackIds = intent.getLongArrayExtra("track_ids");
                    if (playlistId >= 0 && trackIds != null) {
                        if (playlistId != 0) {
                            PlaylistHelper.addToPlaylistAsync(MusicApplication.getApplication(), trackIds, playlistId, false, this.mAdapterUpdateRunnable);
                            break;
                        } else {
                            ServiceHelper.addToCurrentPlaylist(MusicApplication.getApplication(), trackIds);
                            break;
                        }
                    }
                }
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    protected String[] getObservedServiceActions() {
        return new String[]{Out.STATUS_QUEUE_CHANGED, Actions.ACTION_KTV_PLAYLIST_CHANGED, Actions.ACTION_KTV_CONNECT_CHANGED, Actions.ACTION_SUSPEND_BAR_VISIBILITY_CHANGED};
    }

    protected void handleServiceNotification(Intent intent) {
        String action = intent.getAction();
        if (Out.STATUS_QUEUE_CHANGED.equals(action) || Actions.ACTION_KTV_PLAYLIST_CHANGED.equals(action)) {
            update();
        } else if (Actions.ACTION_KTV_CONNECT_CHANGED.equals(action) || Actions.ACTION_SUSPEND_BAR_VISIBILITY_CHANGED.equals(action)) {
            refreshFootView();
        }
    }

    private void refreshSize() {
        FavoriteCache.refreshSize(getActivity());
        KtvPlaylistCache.refreshSize(getActivity());
        update();
    }
}
