package com.miui.player.ui.menu;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import com.miui.player.C0329R;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.DeleteItems;
import com.miui.player.ui.OperationDialog;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.fragment.FolderListFragment;
import com.miui.player.ui.menu.common.MenuContextInfo;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.FolderProvider;
import java.util.Arrays;
import java.util.Set;
import miui.util.UiUtils;

public class FolderBrowserMenu extends BaseMenuManager<String> {
    private final FolderListFragment mFragment;
    private final String mKeyColumn;
    private int mKeyIdx = -1;

    public static class ContextInfo extends MenuContextInfo<String> {
        public Cursor mCursor;
        public int mHeaderCount;

        public boolean isValid() {
            return this.mCursor != null;
        }
    }

    public FolderBrowserMenu(FolderListFragment f, int msgId, String keyColumn) {
        super(f.getActivity(), msgId);
        this.mFragment = f;
        this.mKeyColumn = keyColumn;
    }

    public void onDialogResult(int requestCode, boolean confirm, Intent intent) {
        Set<String> selected = getLastSelected();
        if (!CollectionHelper.isEmpty(selected)) {
            ContextInfo ctx = getContextInfo();
            if (ctx.isValid()) {
                switch (requestCode) {
                    case 4:
                        if (confirm) {
                            Uri uri = intent.getData();
                            if (uri != null) {
                                long playlistId = Long.valueOf(uri.getLastPathSegment()).longValue();
                                if (playlistId > 0 && !selected.isEmpty()) {
                                    long[] list = FolderProvider.queryTrackListForFolder(this.mFragment.getActivity(), getFolderPathArr(ctx.mCursor, selected));
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
                            FolderProvider.markForceUpdate();
                            this.mFragment.update();
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

    protected ContextInfo getContextInfo() {
        return this.mFragment.getMenuContextInfo();
    }

    public void createActionMenu(Menu menu, Set<String> set) {
        if (getContextInfo().isValid()) {
            Intent intent = new Intent();
            menu.add(0, 5, 0, C0329R.string.play_selection).setIcon(C0329R.drawable.menu_play_selection_selector).setIntent(intent);
            UIHelper.makePlaylistMenuProxy(this.mFragment.getActivity(), menu.add(0, 1, 0, C0329R.string.add_to).setIcon(100795004), intent, this);
            menu.add(0, 10, 0, C0329R.string.delete_item).setIcon(UiUtils.getDrawable(this.mFragment.getActivity(), 100728901)).setIntent(intent);
        }
    }

    public void handleActionItem(MenuItem item, Set<String> selected) {
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
                                list = FolderProvider.queryTrackListForFolder(this.mFragment.getActivity(), getFolderPathArr(ctx.mCursor, selected));
                                if (list != null) {
                                    PlaylistHelper.addToPlaylistAsync(this.mFragment.getActivity(), list, playlistId, true, null);
                                }
                            }
                            this.mFragment.leaveMultiChoiceMode();
                            return;
                        case 4:
                            OperationDialog.makePlaylistCreator(this.mFragment.getActivity(), this, 4, intent).show();
                            return;
                        case 5:
                            ServiceHelper.playAll(this.mFragment.getActivity(), FolderProvider.queryTrackListForFolder(this.mFragment.getActivity(), getFolderPathArr(ctx.mCursor, selected)), 0);
                            this.mFragment.leaveMultiChoiceMode();
                            return;
                        case 10:
                            list = FolderProvider.queryTrackListForFolder(this.mFragment.getActivity(), getFolderPathArr(ctx.mCursor, selected));
                            DeleteItems.show(this.mFragment.getActivity(), list, null, list != null ? list.length : 0, this, 10);
                            return;
                        case 12:
                            ServiceHelper.addToCurrentPlaylist(this.mFragment.getActivity(), FolderProvider.queryTrackListForFolder(this.mFragment.getActivity(), getFolderPathArr(ctx.mCursor, selected)));
                            this.mFragment.leaveMultiChoiceMode();
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    private static String[] getFolderPathArr(Cursor cursor, Set<String> selected) {
        if (cursor == null || selected == null || selected.isEmpty()) {
            return null;
        }
        String[] ret = new String[cursor.getCount()];
        int i = 0;
        int oldPos = cursor.getPosition();
        int pathIdx = cursor.getColumnIndex("path");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String path = cursor.getString(pathIdx);
            if (path != null && selected.contains(path)) {
                int i2 = i + 1;
                ret[i] = path;
                i = i2;
            }
            cursor.moveToNext();
        }
        cursor.moveToPosition(oldPos);
        return i != ret.length ? (String[]) Arrays.copyOf(ret, i) : ret;
    }

    protected String getKeyFromItem(Object obj) {
        if (!(obj instanceof Cursor)) {
            return null;
        }
        Cursor c = (Cursor) obj;
        if (this.mKeyIdx < 0) {
            this.mKeyIdx = c.getColumnIndex(this.mKeyColumn);
        }
        return c.getString(this.mKeyIdx);
    }
}
