package com.ushareit.listenit;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class fuj implements OnSeekBarChangeListener {
    final /* synthetic */ EqualizerActivity f13519a;

    public fuj(EqualizerActivity equalizerActivity) {
        this.f13519a = equalizerActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        fum.m20996a().m21012d(i - 15);
        this.f13519a.f11567Q.m22278e(i - 15);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f13519a.f11580q.m26820a();
        fum.m20996a().m21005a(this.f13519a.f11567Q);
        fik.m19343b(this.f13519a, "eq3600Hz", "" + this.f13519a.f11584y.getProgress());
    }
}
