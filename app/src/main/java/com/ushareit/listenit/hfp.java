package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerBridge;

public class hfp implements Runnable {
    final /* synthetic */ String f15352a;
    final /* synthetic */ YouTubePlayerBridge f15353b;

    public hfp(YouTubePlayerBridge youTubePlayerBridge, String str) {
        this.f15353b = youTubePlayerBridge;
        this.f15352a = str;
    }

    public void run() {
        for (hfh c : this.f15353b.youTubePlayer.getListeners()) {
            c.mo2590c(this.f15352a);
        }
    }
}
