package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class ftv implements OnClickListener {
    final /* synthetic */ EqualizerActivity f13502a;

    public ftv(EqualizerActivity equalizerActivity) {
        this.f13502a = equalizerActivity;
    }

    public void onClick(View view) {
        this.f13502a.finish();
    }
}
