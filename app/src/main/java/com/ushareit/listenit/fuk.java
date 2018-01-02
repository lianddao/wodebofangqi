package com.ushareit.listenit;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class fuk implements OnSeekBarChangeListener {
    final /* synthetic */ EqualizerActivity f13520a;

    public fuk(EqualizerActivity equalizerActivity) {
        this.f13520a = equalizerActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        fum.m20996a().m21014e(i - 15);
        this.f13520a.f11567Q.m22280f(i - 15);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f13520a.f11580q.m26820a();
        fum.m20996a().m21005a(this.f13520a.f11567Q);
        fik.m19343b(this.f13520a, "eq14000Hz", "" + this.f13520a.f11585z.getProgress());
    }
}
