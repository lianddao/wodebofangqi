package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hct implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15190a;

    public hct(NormalPlayerView normalPlayerView) {
        this.f15190a = normalPlayerView;
    }

    public void onClick(View view) {
        this.f15190a.setPopupMenu(view);
    }
}
