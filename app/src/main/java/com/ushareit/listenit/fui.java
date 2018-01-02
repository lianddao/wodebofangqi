package com.ushareit.listenit;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class fui implements OnSeekBarChangeListener {
    final /* synthetic */ EqualizerActivity f13518a;

    public fui(EqualizerActivity equalizerActivity) {
        this.f13518a = equalizerActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        fum.m20996a().m21010c(i - 15);
        this.f13518a.f11567Q.m22276d(i - 15);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f13518a.f11580q.m26820a();
        fum.m20996a().m21005a(this.f13518a.f11567Q);
        fik.m19343b(this.f13518a, "eq910Hz", "" + this.f13518a.f11583t.getProgress());
    }
}
