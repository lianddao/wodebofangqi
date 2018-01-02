package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hcs implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15189a;

    public hcs(NormalPlayerView normalPlayerView) {
        this.f15189a = normalPlayerView;
    }

    public void onClick(View view) {
        this.f15189a.getContext().startActivity(new Intent(this.f15189a.getContext(), EqualizerActivity.class));
        fit.m19433b(this.f15189a.getContext(), "equalizer");
    }
}
