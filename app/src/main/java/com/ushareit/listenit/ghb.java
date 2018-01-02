package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.lyrics.LyricEditorActivity;

public class ghb implements hgq {
    final /* synthetic */ LyricEditorActivity f14114a;

    public ghb(LyricEditorActivity lyricEditorActivity) {
        this.f14114a = lyricEditorActivity;
    }

    public void mo2623a(String str, int i, int i2) {
        if (i >= 0 && i2 > 0) {
            this.f14114a.f15862t.setProgress((int) (((((float) i) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) i2)) * ((float) this.f14114a.f15862t.getMax())));
        }
    }
}
