package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.album.SearchAlbumArtActivity;

public class fhs implements OnClickListener {
    final /* synthetic */ SearchAlbumArtActivity f12745a;

    public fhs(SearchAlbumArtActivity searchAlbumArtActivity) {
        this.f12745a = searchAlbumArtActivity;
    }

    public void onClick(View view) {
        this.f12745a.finish();
    }
}
