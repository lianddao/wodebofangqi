package com.miui.player.ui;

import android.os.Bundle;
import com.miui.player.C0329R;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.fragment.FolderListFragment;

public class FolderBrowserActivity extends MusicBaseActivity {
    FolderListFragment mFragment;

    protected void onCreateContent(Bundle icicle) {
        setContentView(C0329R.layout.folder_picker_activity);
        UIHelper.attachGotoNowplayingIcon(this);
        getActionBar().setTitle(C0329R.string.folders_title);
        this.mFragment = (FolderListFragment) getFragmentManager().findFragmentById(C0329R.id.folder_list_fragment);
    }

    protected boolean needBindToService() {
        return false;
    }
}
