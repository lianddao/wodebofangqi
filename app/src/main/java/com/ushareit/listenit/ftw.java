package com.ushareit.listenit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class ftw implements OnItemSelectedListener {
    final /* synthetic */ EqualizerActivity f13503a;

    public ftw(EqualizerActivity equalizerActivity) {
        this.f13503a = equalizerActivity;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        fum.m20996a().m21019h(i);
        this.f13503a.f11567Q.m22286i(i);
        fik.m19341a(this.f13503a, "reverb", String.valueOf(i));
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
