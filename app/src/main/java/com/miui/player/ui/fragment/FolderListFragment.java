package com.miui.player.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import com.miui.player.C0329R;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Columns;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.UIHelper.ListViewPositionWrap;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.ui.menu.BaseMenuManager;
import com.miui.player.ui.menu.FolderBrowserMenu;
import com.miui.player.ui.menu.FolderBrowserMenu.ContextInfo;
import com.miui.player.ui.model.FolderListAdapter;
import com.miui.player.util.Actions;
import com.miui.player.util.FolderProvider;

public class FolderListFragment extends MusicBaseFragment {
    private static ListViewPositionWrap sListViewPositionWrap = new ListViewPositionWrap();
    private FolderListAdapter mAdapter;
    private Cursor mCursor;
    private ListView mListView;
    private final BroadcastReceiver mMediaProviderListener = new C04971();
    private BaseMenuManager<String> mMenuManager;
    private MultiChoiceController<String> mMultiChoiceController;
    private int mUpdateVersion = 0;

    class C04971 extends BroadcastReceiver {
        C04971() {
        }

        public void onReceive(Context context, Intent intent) {
            if (Actions.ACTION_MEDIA_PROVIDER_CHANGED.equals(intent.getAction())) {
                FolderListFragment.this.update();
            }
        }
    }

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        this.mListView = (ListView) getListView();
        this.mListView.setOnItemClickListener(this);
        this.mMenuManager = new FolderBrowserMenu(this, C0329R.plurals.Nitems_batch_selection, "path");
        this.mMultiChoiceController = new MultiChoiceController(this.mListView, this.mMenuManager);
        this.mMultiChoiceController.setItemViewBinder(UIHelper.createBinderForList(C0329R.id.batch_selection_check));
        this.mAdapter = new FolderListAdapter(getActivity(), this, C0329R.layout.folder_picker_item, null, null, this.mMultiChoiceController);
        this.mAdapter.changeCursor(FolderProvider.instance(getActivity()).querySelectedFolders(getActivity()));
        setListAdapter(this.mAdapter);
        this.mMenuManager.setAdapter(this.mAdapter);
        sListViewPositionWrap.restoreListPosition(this.mListView);
    }

    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Actions.ACTION_MEDIA_PROVIDER_CHANGED);
        getActivity().registerReceiver(this.mMediaProviderListener, filter);
        update();
    }

    public void onPause() {
        getActivity().unregisterReceiver(this.mMediaProviderListener);
        super.onPause();
    }

    public void onDestroy() {
        sListViewPositionWrap.saveListPosition(this.mListView);
        if (this.mAdapter != null) {
            this.mAdapter.changeCursor(null);
        }
        setListAdapter(null);
        this.mAdapter = null;
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        if (this.mCursor != null && this.mCursor.moveToPosition(position)) {
            String path = this.mCursor.getString(this.mCursor.getColumnIndex("path"));
            Intent intent = new Intent(Actions.ACTION_BROWSER);
            intent.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_TRACK);
            intent.putExtra(Columns.FOLDER_PATH, path);
            startActivity(intent);
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (this.mMenuManager.onContextItemSelected(item)) {
            return true;
        }
        return super.onContextItemSelected(item);
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

    public void update() {
        int version = FolderProvider.updateFolderItemListIfNeeded(getActivity());
        if (this.mUpdateVersion < version) {
            this.mUpdateVersion = version;
            this.mAdapter.changeCursor(FolderProvider.instance(getActivity()).querySelectedFolders(getActivity()));
        }
    }

    protected CursorAdapter getCursorAdapter() {
        return this.mAdapter;
    }

    public ContextInfo getMenuContextInfo() {
        ContextInfo ctx = new ContextInfo();
        ctx.mCursor = this.mCursor;
        ctx.mHeaderCount = this.mListView.getHeaderViewsCount();
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
}
