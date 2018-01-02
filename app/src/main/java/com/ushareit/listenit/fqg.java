package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.cutter.view.WavePlayerView;

public class fqg implements OnClickListener {
    final /* synthetic */ WavePlayerView f13230a;

    public fqg(WavePlayerView wavePlayerView) {
        this.f13230a = wavePlayerView;
    }

    public void onClick(View view) {
        if (this.f13230a.f9116e != null) {
            if (this.f13230a.f9116e.mo2425a()) {
                this.f13230a.f9113b.setIsAfterScrollWaveform(false);
                int t = this.f13230a.f9116e.mo2463t() + 5000;
                if (t > this.f13230a.f9115d) {
                    t = this.f13230a.f9115d;
                }
                this.f13230a.f9116e.mo2411a(t);
                return;
            }
            this.f13230a.f9113b.m12908d();
        }
    }
}
