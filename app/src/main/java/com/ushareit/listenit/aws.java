package com.ushareit.listenit;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.facebook.ads.internal.view.p003d.p004b.C0034b;

public class aws extends avs {
    final /* synthetic */ C0034b f5591a;

    public aws(C0034b c0034b) {
        this.f5591a = c0034b;
    }

    public void m7262a(avr com_ushareit_listenit_avr) {
        ((AudioManager) this.f5591a.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(this.f5591a.f685b == null ? null : (OnAudioFocusChangeListener) this.f5591a.f685b.get());
    }
}
