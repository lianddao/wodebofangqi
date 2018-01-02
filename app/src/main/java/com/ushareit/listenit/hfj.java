package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerBridge;

public class hfj implements Runnable {
    final /* synthetic */ String f15340a;
    final /* synthetic */ YouTubePlayerBridge f15341b;

    public hfj(YouTubePlayerBridge youTubePlayerBridge, String str) {
        this.f15341b = youTubePlayerBridge;
        this.f15340a = str;
    }

    public void run() {
        for (hfh b : this.f15341b.youTubePlayer.getListeners()) {
            b.mo2588b(this.f15340a.toString());
        }
    }
}
