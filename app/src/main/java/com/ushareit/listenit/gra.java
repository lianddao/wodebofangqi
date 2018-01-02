package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.album.SearchAlbumArtActivity;
import com.ushareit.listenit.popupview.SelectAlbumPopupView;

public class gra implements OnClickListener {
    final /* synthetic */ SelectAlbumPopupView f14575a;

    public gra(SelectAlbumPopupView selectAlbumPopupView) {
        this.f14575a = selectAlbumPopupView;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f14575a.f16267d, SearchAlbumArtActivity.class);
        intent.putExtra("extra_album_name", this.f14575a.f16265b);
        this.f14575a.f16267d.startActivityForResult(intent, 10001);
        this.f14575a.mo3063e();
    }
}
