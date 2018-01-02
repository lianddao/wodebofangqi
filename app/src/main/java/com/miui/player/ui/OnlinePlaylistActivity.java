package com.miui.player.ui;

import android.os.Bundle;
import com.miui.player.C0329R;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.fragment.OnlineSongListFragment;
import com.miui.player.util.Actions;

public class OnlinePlaylistActivity extends MusicBaseActivity {
    private String mPlaylistId;
    private String mPlaylistName;
    private OnlineSongListFragment mTrackListFragment;

    public void onCreateContent(Bundle icicle) {
        if (icicle == null) {
            icicle = getIntent().getExtras();
        }
        if (icicle != null) {
            this.mPlaylistId = icicle.getString(Actions.KEY_PLAYLIST_ONLINE_ID);
            this.mPlaylistName = icicle.getString("playlist_name");
        }
        if (this.mPlaylistId == null) {
            finish();
        }
        setContentView(C0329R.layout.online_playlist_activity);
        UIHelper.attachGotoNowplayingIcon(this);
        getActionBar().setTitle(this.mPlaylistName);
        this.mTrackListFragment = (OnlineSongListFragment) getFragmentManager().findFragmentById(C0329R.id.track_list_fragment);
        this.mTrackListFragment.setHasOptionsMenu(true);
        this.mTrackListFragment.requestAudioList(6, this.mPlaylistId, true);
        this.mTrackListFragment.setTranslateEnble(true);
    }

    protected boolean saveData(Bundle outcicle) {
        super.saveData(outcicle);
        outcicle.putString(Actions.KEY_PLAYLIST_ONLINE_ID, this.mPlaylistId);
        outcicle.putString("playlist_name", this.mPlaylistName);
        return true;
    }
}
