package com.miui.player.ui;

import android.os.Bundle;
import android.os.RemoteException;
import com.miui.player.C0329R;
import com.miui.player.service.IMediaPlaybackService;
import com.miui.player.ui.base.MusicBaseActivity;
import com.miui.player.ui.fragment.QueryListFragment;

public class QueryBrowserActivity extends MusicBaseActivity {
    QueryListFragment mFragment;

    public void onCreateContent(Bundle icicle) {
        setContentView(C0329R.layout.query_activity);
        UIHelper.attachGotoNowplayingIcon(this);
        this.mFragment = (QueryListFragment) getFragmentManager().findFragmentById(C0329R.id.query_list_fragment);
    }

    protected void handleServiceConnected(IMediaPlaybackService service) throws RemoteException {
        super.handleServiceConnected(service);
        this.mFragment.setService(service);
    }
}
