package com.ushareit.listenit;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;

public class goi implements OnScrollListener {
    final /* synthetic */ AddToPlaylistPopupView f14506a;

    public goi(AddToPlaylistPopupView addToPlaylistPopupView) {
        this.f14506a = addToPlaylistPopupView;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f14506a.f16137f.m18919a(i);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
