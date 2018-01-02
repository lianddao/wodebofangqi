package com.miui.player.ui.menu;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import com.miui.player.C0329R;
import com.miui.player.provider.MediaProviderHelper;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.DeleteItems;
import com.miui.player.ui.OperationDialog;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.fragment.AlbumListFragment;
import com.miui.player.ui.menu.common.MenuContextInfo;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Utils;
import java.util.Set;
import miui.util.UiUtils;

public class AlbumBrowserMenu extends BaseMenuManager<Long> {
    private static final int DOWNLOAD_ALL_ALBUM = 33;
    private final AlbumListFragment mFragment;
    private final String mKeyColumn;
    private int mKeyIdx = -1;

    public static class ContextInfo extends MenuContextInfo<Long> {
        public Cursor mCursor;

        public boolean isValid() {
            return this.mCursor != null;
        }
    }

    public AlbumBrowserMenu(AlbumListFragment f, int msgId, String keyColumn) {
        super(f.getActivity(), msgId);
        this.mFragment = f;
        this.mKeyColumn = keyColumn;
    }

    protected ContextInfo getContextInfo() {
        return this.mFragment.getMenuContextInfo();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (Utils.isOnlineVaild()) {
            menu.add(0, 33, 0, C0329R.string.download_all_album);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 33:
                this.mFragment.downloadAllAlbums();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onDialogResult(int requestCode, boolean confirm, Intent intent) {
        ContextInfo ctx = getContextInfo();
        if (ctx.isValid()) {
            Cursor cursor = ctx.mCursor;
            Set<Long> selected = getLastSelected();
            if (!CollectionHelper.isEmpty(selected)) {
                switch (requestCode) {
                    case 4:
                        if (confirm) {
                            Uri uri = intent.getData();
                            if (uri != null) {
                                long playlistId = Long.valueOf(uri.getLastPathSegment()).longValue();
                                if (playlistId > 0) {
                                    long[] list = MediaProviderHelper.queryTrackListForAlbums(MusicApplication.getApplication(), getAlbumIdArr(cursor, selected));
                                    if (list != null) {
                                        PlaylistHelper.addToPlaylistAsync(MusicApplication.getApplication(), list, playlistId, false, null);
                                    }
                                }
                            }
                            this.mFragment.leaveMultiChoiceMode();
                            return;
                        }
                        return;
                    case 10:
                        if (confirm) {
                            this.mFragment.leaveMultiChoiceMode();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void createActionMenu(Menu menu, Set<Long> set) {
        if (getContextInfo().isValid()) {
            Intent intent = new Intent();
            menu.add(0, 5, 0, C0329R.string.play_selection).setIcon(C0329R.drawable.menu_play_selection_selector).setIntent(intent);
            UIHelper.makePlaylistMenuProxy(this.mActivity, menu.add(0, 1, 0, C0329R.string.add_to).setIcon(100795004), intent, this);
            menu.add(0, 10, 0, C0329R.string.delete_item).setIcon(UiUtils.getDrawable(this.mActivity, 100728901)).setIntent(intent);
        }
    }

    public void handleActionItem(MenuItem item, Set<Long> selected) {
        super.handleActionItem(item, selected);
        if (!CollectionHelper.isEmpty(selected)) {
            ContextInfo ctx = getContextInfo();
            if (ctx.isValid()) {
                Intent intent = item.getIntent();
                if (intent != null) {
                    long[] list;
                    switch (item.getItemId()) {
                        case 3:
                            long playlistId = intent.getLongExtra(UIHelper.DST_PLAYLIST_KEY, -1);
                            if (playlistId != -1) {
                                list = MediaProviderHelper.queryTrackListForAlbums(this.mActivity, getAlbumIdArr(ctx.mCursor, selected));
                                if (list != null) {
                                    PlaylistHelper.addToPlaylistAsync(this.mActivity, list, playlistId, true, null);
                                }
                            }
                            this.mFragment.leaveMultiChoiceMode();
                            return;
                        case 4:
                            OperationDialog.makePlaylistCreator(this.mActivity, this, 4, intent).show();
                            return;
                        case 5:
                            ServiceHelper.playAll(this.mActivity, MediaProviderHelper.queryTrackListForAlbums(this.mActivity, getAlbumIdArr(ctx.mCursor, selected)), 0);
                            this.mFragment.leaveMultiChoiceMode();
                            return;
                        case 10:
                            list = MediaProviderHelper.queryTrackListForAlbums(this.mActivity, getAlbumIdArr(ctx.mCursor, selected));
                            DeleteItems.show(this.mActivity, list, null, list != null ? list.length : 0, this, 10);
                            return;
                        case 12:
                            ServiceHelper.addToCurrentPlaylist(this.mActivity, MediaProviderHelper.queryTrackListForAlbums(this.mActivity, getAlbumIdArr(ctx.mCursor, selected)));
                            this.mFragment.leaveMultiChoiceMode();
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    private static long[] getAlbumIdArr(Cursor cursor, Set<Long> s) {
        return SqlUtils.sortElementsByCursor(cursor, s, "_id", "_id");
    }

    protected Long getKeyFromItem(Object obj) {
        if (!(obj instanceof Cursor)) {
            return null;
        }
        Cursor c = (Cursor) obj;
        if (this.mKeyIdx < 0) {
            this.mKeyIdx = c.getColumnIndex(this.mKeyColumn);
        }
        return Long.valueOf(c.getLong(this.mKeyIdx));
    }
}
