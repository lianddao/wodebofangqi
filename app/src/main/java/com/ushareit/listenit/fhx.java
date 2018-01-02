package com.ushareit.listenit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.album.SearchAlbumArtActivity;

class fhx implements OnClickListener {
    final /* synthetic */ Bitmap f12754a;
    final /* synthetic */ fhw f12755b;

    fhx(fhw com_ushareit_listenit_fhw, Bitmap bitmap) {
        this.f12755b = com_ushareit_listenit_fhw;
        this.f12754a = bitmap;
    }

    public void onClick(View view) {
        frf.m20649a(this.f12755b.f12753d.f12749b, gyn.m23183a(this.f12754a, this.f12755b.f12753d.f12749b));
        fig.m19278a(eys.m18562a(), "network");
        if (this.f12755b.f12752c instanceof SearchAlbumArtActivity) {
            Intent intent = new Intent();
            intent.putExtra("extra_album_name", this.f12755b.f12753d.f12749b);
            ((SearchAlbumArtActivity) this.f12755b.f12752c).setResult(-1, intent);
            ((SearchAlbumArtActivity) this.f12755b.f12752c).finish();
        }
    }
}
