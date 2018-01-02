package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerBridge;

public class hfn implements Runnable {
    final /* synthetic */ YouTubePlayerBridge f15348a;

    public hfn(YouTubePlayerBridge youTubePlayerBridge) {
        this.f15348a = youTubePlayerBridge;
    }

    public void run() {
        for (hfh c : this.f15348a.youTubePlayer.getListeners()) {
            c.mo2589c();
        }
    }
}
