package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.cutter.AudioClipsActivity;
import com.ushareit.listenit.cutter.AudioCutterActivity;

public class fos implements OnClickListener {
    final /* synthetic */ AudioCutterActivity f13117a;

    public fos(AudioCutterActivity audioCutterActivity) {
        this.f13117a = audioCutterActivity;
    }

    public void onClick(View view) {
        this.f13117a.f9031A.m27003b();
        this.f13117a.startActivity(new Intent(this.f13117a, AudioClipsActivity.class));
    }
}
