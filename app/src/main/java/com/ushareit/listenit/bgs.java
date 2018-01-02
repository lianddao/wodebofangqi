package com.ushareit.listenit;

import android.media.AudioTrack;

class bgs extends Thread {
    final /* synthetic */ AudioTrack f6237a;
    final /* synthetic */ bgq f6238b;

    bgs(bgq com_ushareit_listenit_bgq, AudioTrack audioTrack) {
        this.f6238b = com_ushareit_listenit_bgq;
        this.f6237a = audioTrack;
    }

    public void run() {
        this.f6237a.release();
    }
}
