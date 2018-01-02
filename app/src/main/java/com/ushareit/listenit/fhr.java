package com.ushareit.listenit;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.ushareit.listenit.album.SearchAlbumArtActivity;

public class fhr implements OnEditorActionListener {
    final /* synthetic */ SearchAlbumArtActivity f12744a;

    public fhr(SearchAlbumArtActivity searchAlbumArtActivity) {
        this.f12744a = searchAlbumArtActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.f12744a.m5965c(this.f12744a.f4629o.getText().toString());
        return true;
    }
}
