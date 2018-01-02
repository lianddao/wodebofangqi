package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.cutter.view.WavePlayerView;

public class fqe implements OnClickListener {
    final /* synthetic */ WavePlayerView f13228a;

    public fqe(WavePlayerView wavePlayerView) {
        this.f13228a = wavePlayerView;
    }

    public void onClick(View view) {
        if (this.f13228a.f9116e != null && this.f13228a.f9113b != null) {
            if (this.f13228a.f9116e.mo2425a()) {
                this.f13228a.m12917b();
                return;
            }
            this.f13228a.f9113b.setIsAfterScrollWaveform(false);
            this.f13228a.m12913a(this.f13228a.f9113b.getStartPos());
        }
    }
}
