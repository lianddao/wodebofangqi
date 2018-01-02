package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerBridge;

public class hfq implements Runnable {
    final /* synthetic */ String f15354a;
    final /* synthetic */ YouTubePlayerBridge f15355b;

    public hfq(YouTubePlayerBridge youTubePlayerBridge, String str) {
        this.f15355b = youTubePlayerBridge;
        this.f15354a = str;
    }

    public void run() {
        for (hfh d : this.f15355b.youTubePlayer.getListeners()) {
            d.mo2591d(this.f15354a);
        }
    }
}
