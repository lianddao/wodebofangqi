package com.ushareit.listenit;

import com.ushareit.listenit.cutter.view.TouchWaveformView;

public class fpx implements Runnable {
    final /* synthetic */ TouchWaveformView f13212a;

    public fpx(TouchWaveformView touchWaveformView) {
        this.f13212a = touchWaveformView;
    }

    public void run() {
        this.f13212a.f9105t = this.f13212a.getMeasuredHeight();
    }
}
