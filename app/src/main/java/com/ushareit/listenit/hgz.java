package com.ushareit.listenit;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.util.concurrent.atomic.AtomicBoolean;

class hgz implements OnPreparedListener {
    final /* synthetic */ AtomicBoolean f15449a;
    final /* synthetic */ hgy f15450b;

    hgz(hgy com_ushareit_listenit_hgy, AtomicBoolean atomicBoolean) {
        this.f15450b = com_ushareit_listenit_hgy;
        this.f15449a = atomicBoolean;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        synchronized (this.f15449a) {
            this.f15449a.notify();
        }
    }
}
