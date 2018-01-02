package com.miui.player.ui;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import com.miui.player.C0329R;
import com.miui.player.meta.MetaManager;
import com.miui.player.provider.PlayerStore.OnlineAudioDetail.Columns;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.fragment.AlbumListFragment;

public class AlbumBrowserActivity extends MusicBaseActivity {
    private long mArtistId;
    private String mArtistName;
    private AlbumListFragment mFragment;

    protected void onCreateContent(Bundle icicle) {
        setContentView(C0329R.layout.album_picker_activity);
        UIHelper.attachGotoNowplayingIcon(this);
        if (icicle == null) {
            icicle = getIntent().getExtras();
        }
        if (icicle == null) {
            icicle = new Bundle();
            Log.e(getTag(), "icicle is NULL");
        }
        this.mArtistId = icicle.getLong(Columns.ARTIST_ID, -1);
        this.mArtistName = icicle.getString("artist_name", null);
        ActionBar bar = getActionBar();
        if (this.mArtistId >= 0) {
            bar.setTitle(MetaManager.getLocaleArtistName(this, this.mArtistName));
        } else {
            bar.setTitle(getText(C0329R.string.albums_title));
        }
        this.mFragment = (AlbumListFragment) getFragmentManager().findFragmentById(C0329R.id.album_list_fragment);
        this.mFragment.setHasOptionsMenu(true);
    }

    protected boolean saveData(Bundle outcicle) {
        super.saveData(outcicle);
        outcicle.putLong(Columns.ARTIST_ID, this.mArtistId);
        outcicle.putString("artist_name", this.mArtistName);
        return true;
    }

    public void onSaveInstanceState(Bundle outcicle) {
        saveData(outcicle);
        super.onSaveInstanceState(outcicle);
    }

    protected boolean needBindToService() {
        return false;
    }
}
