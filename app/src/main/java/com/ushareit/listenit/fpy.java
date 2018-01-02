package com.ushareit.listenit;

import com.ushareit.listenit.cutter.view.MarkerView;
import com.ushareit.listenit.cutter.view.TouchWaveformView;

public class fpy implements Runnable {
    final /* synthetic */ MarkerView f13213a;
    final /* synthetic */ TouchWaveformView f13214b;

    public fpy(TouchWaveformView touchWaveformView, MarkerView markerView) {
        this.f13214b = touchWaveformView;
        this.f13213a = markerView;
    }

    public void run() {
        this.f13213a.setVisibility(0);
    }
}
