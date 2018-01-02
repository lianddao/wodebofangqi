package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.cutter.AudioClipsActivity;

public class foi implements OnClickListener {
    final /* synthetic */ AudioClipsActivity f13098a;

    public foi(AudioClipsActivity audioClipsActivity) {
        this.f13098a = audioClipsActivity;
    }

    public void onClick(View view) {
        this.f13098a.f9030z.m27003b();
        this.f13098a.finish();
    }
}
