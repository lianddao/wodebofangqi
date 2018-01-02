package com.ushareit.listenit;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class fuh implements OnSeekBarChangeListener {
    final /* synthetic */ EqualizerActivity f13517a;

    public fuh(EqualizerActivity equalizerActivity) {
        this.f13517a = equalizerActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        fum.m20996a().m21008b(i - 15);
        this.f13517a.f11567Q.m22274c(i - 15);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f13517a.f11580q.m26820a();
        fum.m20996a().m21005a(this.f13517a.f11567Q);
        fik.m19343b(this.f13517a, "eq230Hz", "" + this.f13517a.f11582s.getProgress());
    }
}
