package com.ushareit.listenit;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class hgd implements OnSeekBarChangeListener {
    final /* synthetic */ hft f15395a;

    hgd(hft com_ushareit_listenit_hft) {
        this.f15395a = com_ushareit_listenit_hft;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.f15395a.f15369k.setText(gyn.m23180a((float) i));
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f15395a.f15384z.removeCallbacks(this.f15395a.f15358A);
        this.f15395a.f15380v = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f15395a.m23673i();
        this.f15395a.f15366h.m27103a(seekBar.getProgress());
        this.f15395a.f15380v = false;
    }
}
