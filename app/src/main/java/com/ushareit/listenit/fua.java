package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class fua implements OnClickListener {
    final /* synthetic */ EqualizerActivity f13509a;

    public fua(EqualizerActivity equalizerActivity) {
        this.f13509a = equalizerActivity;
    }

    public void onClick(View view) {
        this.f13509a.m17506a(this.f13509a.f11559I);
        fik.m19341a(this.f13509a, "virtualizer_click", "" + this.f13509a.f11559I.getProgress());
    }
}
