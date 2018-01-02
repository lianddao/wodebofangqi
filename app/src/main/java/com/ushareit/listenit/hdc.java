package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hdc implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15204a;

    public hdc(NormalPlayerView normalPlayerView) {
        this.f15204a = normalPlayerView;
    }

    public void onClick(View view) {
        this.f15204a.f17338y.setVisibility(8);
        gvj.m22959g(this.f15204a.getContext(), false);
        this.f15204a.m26936j();
    }
}
