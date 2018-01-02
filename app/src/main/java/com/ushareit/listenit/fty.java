package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class fty implements OnClickListener {
    final /* synthetic */ EqualizerActivity f13505a;

    public fty(EqualizerActivity equalizerActivity) {
        this.f13505a = equalizerActivity;
    }

    public void onClick(View view) {
        this.f13505a.m17506a(this.f13505a.f11554D);
        fik.m19341a(this.f13505a, "bassboost_click", "" + this.f13505a.f11554D.getProgress());
    }
}
