package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.equalizer.VolumeControlView;

public class fuo implements OnClickListener {
    final /* synthetic */ VolumeControlView f13533a;

    public fuo(VolumeControlView volumeControlView) {
        this.f13533a = volumeControlView;
    }

    public void onClick(View view) {
        if (this.f13533a.f11594i != null) {
            this.f13533a.f11594i.onClick(view);
        }
    }
}
