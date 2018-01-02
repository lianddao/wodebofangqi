package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class fud implements OnCheckedChangeListener {
    final /* synthetic */ EqualizerActivity f13512a;

    public fud(EqualizerActivity equalizerActivity) {
        this.f13512a = equalizerActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        fum.m20996a().m21006a(z);
        this.f13512a.m17508b(z);
        fik.m19342a(this.f13512a, z);
    }
}
