package com.ushareit.listenit;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.facebook.ads.internal.view.p003d.p004b.C0034b;

public class awt extends avy {
    final /* synthetic */ C0034b f5592a;

    public awt(C0034b c0034b) {
        this.f5592a = c0034b;
    }

    public void m7264a(avx com_ushareit_listenit_avx) {
        ((AudioManager) this.f5592a.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(this.f5592a.f685b == null ? null : (OnAudioFocusChangeListener) this.f5592a.f685b.get());
    }
}
