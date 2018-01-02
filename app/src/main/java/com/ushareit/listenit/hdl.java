package com.ushareit.listenit;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hdl implements OnSeekBarChangeListener {
    final /* synthetic */ NormalPlayerView f15217a;

    public hdl(NormalPlayerView normalPlayerView) {
        this.f15217a = normalPlayerView;
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        if (this.f15217a.f17294D != null) {
            this.f15217a.f17298H = true;
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.f15217a.f17294D != null && this.f15217a.f17294D.mo2465v() != null) {
            int i = this.f15217a.f17294D.mo2465v().f14337e;
            if (seekBar.getProgress() == 0) {
                i = 0;
            } else if (seekBar.getProgress() != seekBar.getMax()) {
                i = (int) (((float) i) * ((((float) seekBar.getProgress()) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) seekBar.getMax())));
            }
            gyp.m23273a(i);
            if (!this.f15217a.f17297G) {
                this.f15217a.f17337x.m24779a(i, true);
            }
            this.f15217a.f17298H = false;
            fit.m19434c(this.f15217a.getContext());
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.f15217a.f17294D != null && this.f15217a.f17294D.mo2465v() != null) {
            this.f15217a.f17328o.setText(gyn.m23182a((long) ((int) (((((float) i) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) seekBar.getMax())) * ((float) this.f15217a.f17294D.mo2465v().f14337e)))));
        }
    }
}
