package com.ushareit.listenit;

import android.media.AudioTrack;

class bgr extends Thread {
    final /* synthetic */ AudioTrack f6235a;
    final /* synthetic */ bgq f6236b;

    bgr(bgq com_ushareit_listenit_bgq, AudioTrack audioTrack) {
        this.f6236b = com_ushareit_listenit_bgq;
        this.f6235a = audioTrack;
    }

    public void run() {
        try {
            this.f6235a.flush();
            this.f6235a.release();
        } finally {
            this.f6236b.f6213e.open();
        }
    }
}
