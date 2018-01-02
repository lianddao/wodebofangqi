package com.ushareit.listenit;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.ushareit.listenit.equalizer.VolumeControlView;

public class fup implements OnSeekBarChangeListener {
    final /* synthetic */ VolumeControlView f13534a;
    private boolean f13535b = false;

    public fup(VolumeControlView volumeControlView) {
        this.f13534a = volumeControlView;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.f13535b) {
            this.f13534a.m17531a(i);
            if (this.f13534a.f11592g != null) {
                this.f13534a.f11592g.mo2601a(i);
            }
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f13535b = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f13535b = false;
    }
}
