package com.ushareit.listenit;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.facebook.ads.internal.view.p003d.p004b.C0034b;
import java.lang.ref.WeakReference;

public class awu extends awa {
    final /* synthetic */ C0034b f5593a;

    public awu(C0034b c0034b) {
        this.f5593a = c0034b;
    }

    public void m7266a(avz com_ushareit_listenit_avz) {
        if (this.f5593a.f685b == null || this.f5593a.f685b.get() == null) {
            this.f5593a.f685b = new WeakReference(new awv(this));
        }
        ((AudioManager) this.f5593a.getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus((OnAudioFocusChangeListener) this.f5593a.f685b.get(), 3, 1);
    }
}
