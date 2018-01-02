package com.ushareit.listenit;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

class hhb implements OnBufferingUpdateListener {
    final /* synthetic */ hgy f15452a;

    hhb(hgy com_ushareit_listenit_hgy) {
        this.f15452a = com_ushareit_listenit_hgy;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f15452a.m23716b(i);
        if (i == 100) {
            this.f15452a.m23833s();
        }
        if (this.f15452a.mo2770a() && i == 100 && mediaPlayer != null) {
            hgf.m23700c();
        }
    }
}
