package com.ushareit.listenit;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.lyrics.LyricEditorActivity;

public class ghc implements OnSeekBarChangeListener {
    final /* synthetic */ LyricEditorActivity f14115a;

    public ghc(LyricEditorActivity lyricEditorActivity) {
        this.f14115a = lyricEditorActivity;
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.f14115a.f15844O != null) {
            int i = this.f14115a.f15844O.f14337e;
            if (seekBar.getProgress() == 0) {
                i = 0;
            } else if (seekBar.getProgress() != seekBar.getMax()) {
                i = (int) (((float) i) * ((((float) seekBar.getProgress()) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) seekBar.getMax())));
            }
            gyp.m23273a(i);
            fin.m19364j(this.f14115a);
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.f14115a.f15844O != null) {
            this.f14115a.f15836G.setText(gyn.m23208b((long) ((int) (((((float) i) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) seekBar.getMax())) * ((float) this.f14115a.f15844O.f14337e)))));
        }
    }
}
