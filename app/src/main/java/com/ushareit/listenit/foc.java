package com.ushareit.listenit;

import android.media.AudioManager.OnAudioFocusChangeListener;

class foc implements OnAudioFocusChangeListener {
    final /* synthetic */ fnr f13080a;

    foc(fnr com_ushareit_listenit_fnr) {
        this.f13080a = com_ushareit_listenit_fnr;
    }

    public void onAudioFocusChange(int i) {
        switch (i) {
            case -3:
                this.f13080a.m20037I();
                return;
            case -2:
            case -1:
                this.f13080a.mo2444e();
                return;
            case 1:
                this.f13080a.mo2438c();
                return;
            default:
                return;
        }
    }
}
