package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.nearby.view.SongMenuActivity;

public class gmr implements OnClickListener {
    final /* synthetic */ SongMenuActivity f14427a;

    public gmr(SongMenuActivity songMenuActivity) {
        this.f14427a = songMenuActivity;
    }

    public void onClick(View view) {
        this.f14427a.finish();
    }
}
