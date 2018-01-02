package com.ushareit.listenit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.ushareit.listenit.popupview.ActivePlaylistPopupView;

public class gnu implements OnItemClickListener {
    final /* synthetic */ ActivePlaylistPopupView f14483a;

    public gnu(ActivePlaylistPopupView activePlaylistPopupView) {
        this.f14483a = activePlaylistPopupView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        gyp.m23274a(this.f14483a.f16118d.m22553a(i));
    }
}
