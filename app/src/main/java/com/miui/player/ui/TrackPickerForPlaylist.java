package com.miui.player.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.provider.PlayerStore.MemberColomns;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.fragment.TrackPickerForPlaylistFragment;
import com.miui.player.ui.model.TrackPickerForPlaylistAdapter;

public class TrackPickerForPlaylist extends MusicBaseActivity implements OnClickListener {
    private TextView mCancelView;
    private Button mCompleteButton;
    private TrackPickerForPlaylistFragment mFragment;
    private long mPlaylistId;
    private TextView mSelectAll;
    private TextView mTitleText;
    private TrackPickerForPlaylistAdapter mTrackAdapter;

    public void onCreateContent(Bundle icicle) {
        setContentView(C0329R.layout.track_picker_for_playlist);
        this.mPlaylistId = getIntent().getLongExtra(MemberColomns.PLAYLIST_ID, -1);
        ActionBar bar = getActionBar();
        bar.setDisplayShowHomeEnabled(false);
        bar.setCustomView(100859949);
        bar.setDisplayShowCustomEnabled(true);
        this.mCancelView = (TextView) findViewById(16908313);
        this.mCancelView.setText(C0329R.string.cancel);
        this.mCancelView.setOnClickListener(this);
        this.mSelectAll = (TextView) findViewById(16908314);
        this.mSelectAll.setBackgroundResource(100794739);
        this.mSelectAll.setOnClickListener(this);
        this.mTitleText = (TextView) findViewById(16908310);
        this.mCompleteButton = (Button) findViewById(C0329R.id.btn_complete);
        this.mCompleteButton.setOnClickListener(this);
        this.mFragment = (TrackPickerForPlaylistFragment) getFragmentManager().findFragmentById(C0329R.id.track_picker_list_fragment);
        this.mTrackAdapter = this.mFragment.getTrackAdapter();
        updateTitleBar();
    }

    public void onClick(View v) {
        if (v == this.mSelectAll) {
            if (this.mTrackAdapter.isSelectAll()) {
                this.mTrackAdapter.clearSelectAudioList();
                this.mSelectAll.setText(C0329R.string.select_all);
            } else if (this.mTrackAdapter.selectAll()) {
                this.mSelectAll.setText(C0329R.string.deselect_all);
            }
            updateTitleBar();
            this.mTrackAdapter.notifyDataSetChanged();
        } else if (v == this.mCancelView) {
            finish();
        } else if (v == this.mCompleteButton) {
            Intent intent = new Intent();
            intent.putExtra(MemberColomns.PLAYLIST_ID, this.mPlaylistId);
            intent.putExtra("track_ids", this.mTrackAdapter.getSelectAudioList());
            setResult(-1, intent);
            finish();
        }
    }

    public void updateTitleBar() {
        boolean z = false;
        int count = this.mTrackAdapter.getSelectedSize();
        int maxSeletable = this.mTrackAdapter.getMaxSelectableCount();
        if (count == 0) {
            this.mTitleText.setText(101450235);
        } else {
            this.mTitleText.setText(getResources().getQuantityString(C0329R.plurals.Nitems_batch_selection, count, new Object[]{Integer.valueOf(count)}));
        }
        if (count == maxSeletable) {
            this.mSelectAll.setText(C0329R.string.deselect_all);
        } else {
            this.mSelectAll.setText(C0329R.string.select_all);
        }
        TextView textView = this.mSelectAll;
        if (!(maxSeletable == 0 && this.mTrackAdapter.isSelectAll())) {
            z = true;
        }
        textView.setEnabled(z);
    }

    public boolean needBindToService() {
        return false;
    }
}
