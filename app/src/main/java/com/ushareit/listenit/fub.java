package com.ushareit.listenit;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class fub implements OnSeekBarChangeListener {
    final /* synthetic */ EqualizerActivity f13510a;

    public fub(EqualizerActivity equalizerActivity) {
        this.f13510a = equalizerActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            try {
                this.f13510a.f11566P.setStreamVolume(3, i, 0);
            } catch (Exception e) {
                exw.m18451b("EqualizerFragment", "There is an Exception when set volume", e);
            }
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        fik.m19341a(this.f13510a, "volume", this.f13510a.f11566P.getStreamVolume(3) + "/" + this.f13510a.f11566P.getStreamMaxVolume(3));
    }
}
