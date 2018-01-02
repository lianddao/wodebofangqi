package com.miui.player.ui.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ListView;
import com.miui.player.C0329R;
import com.miui.player.provider.PlayerStore.MemberColomns;
import com.miui.player.ui.TrackPickerForPlaylist;
import com.miui.player.ui.UIHelper.ListViewPositionWrap;
import com.miui.player.ui.base.MediaCursorLoader.MediaLoaderInfo;
import com.miui.player.ui.base.MediaCursorLoader.QueryArgs;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.base.MusicBaseFragment;
import com.miui.player.ui.base.MusicBaseFragment.SectionCursorDecorator;
import com.miui.player.ui.model.TrackPickerForPlaylistAdapter;
import com.miui.player.util.SqlUtils;

public class TrackPickerForPlaylistFragment extends MusicBaseFragment {
    private static ListViewPositionWrap sListViewPositionWrap = new ListViewPositionWrap();
    private Cursor mCursor;
    private ListView mListView;
    private long mPlaylistId;
    private TrackPickerForPlaylistAdapter mTrackAdapter;

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mPlaylistId = getActivity().getIntent().getLongExtra(MemberColomns.PLAYLIST_ID, -1);
        ListView lv = (ListView) getListView();
        this.mListView = lv;
        lv.setOnItemClickListener(this);
        this.mTrackAdapter = new TrackPickerForPlaylistAdapter(getActivity(), this, C0329R.layout.track_picker_for_playlist_item, this.mPlaylistId, null, null);
        setListAdapter(this.mTrackAdapter);
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        CheckBox checkBox = (CheckBox) v.findViewById(C0329R.id.track_check_box);
        if (checkBox != null && checkBox.isEnabled()) {
            checkBox.setChecked(this.mTrackAdapter.toggle(id));
            ((TrackPickerForPlaylist) getActivity()).updateTitleBar();
        }
    }

    public void onDestroy() {
        sListViewPositionWrap.saveListPosition(this.mListView);
        setListAdapter(null);
        this.mTrackAdapter = null;
        super.onDestroy();
    }

    public boolean swapCursor(Cursor cursor) {
        if (this.mCursor == cursor) {
            return false;
        }
        this.mCursor = cursor;
        return true;
    }

    public MediaLoaderInfo getMediaLoaderInfo() {
        return new MediaLoaderInfo(new SectionCursorDecorator(TrackPickerForPlaylistAdapter.createCursorConverter(), 0), new QueryArgs(MusicApplication.getApplication().getContentResolver(), Media.EXTERNAL_CONTENT_URI, TrackPickerForPlaylistAdapter.TRACK_PICKER_COLUMNS, SqlUtils.wrapWithBlacklist(getActivity(), "title != ''"), null, null, null));
    }

    public TrackPickerForPlaylistAdapter getTrackAdapter() {
        return this.mTrackAdapter;
    }

    protected CursorAdapter getCursorAdapter() {
        return this.mTrackAdapter;
    }

    public void handleLoadFinished(int loaderId, Cursor cursor) {
        super.handleLoadFinished(loaderId, cursor);
        if (this.mTrackAdapter != null) {
            boolean first = this.mCursor == null;
            this.mTrackAdapter.changeCursor(cursor);
            if (this.mCursor != null) {
                if (first) {
                    sListViewPositionWrap.restoreListPosition(this.mListView);
                }
                ((TrackPickerForPlaylist) getActivity()).updateTitleBar();
            }
        }
    }
}
