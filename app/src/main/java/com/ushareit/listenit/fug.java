package com.ushareit.listenit;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class fug implements OnSeekBarChangeListener {
    final /* synthetic */ EqualizerActivity f13516a;

    public fug(EqualizerActivity equalizerActivity) {
        this.f13516a = equalizerActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        fum.m20996a().m21002a(i - 15);
        this.f13516a.f11567Q.m22272b(i - 15);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f13516a.f11580q.m26820a();
        fum.m20996a().m21005a(this.f13516a.f11567Q);
        fik.m19343b(this.f13516a, "eq60Hz", "" + this.f13516a.f11581r.getProgress());
    }
}
