package com.ushareit.listenit;

import android.media.AudioManager.OnAudioFocusChangeListener;

class awv implements OnAudioFocusChangeListener {
    final /* synthetic */ awu f5594a;

    awv(awu com_ushareit_listenit_awu) {
        this.f5594a = com_ushareit_listenit_awu;
    }

    public void onAudioFocusChange(int i) {
        if (this.f5594a.f5593a.getVideoView() != null && i <= 0) {
            this.f5594a.f5593a.getVideoView().m1111e();
        }
    }
}
