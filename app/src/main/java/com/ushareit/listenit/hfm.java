package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerBridge;

public class hfm implements Runnable {
    final /* synthetic */ String f15346a;
    final /* synthetic */ YouTubePlayerBridge f15347b;

    public hfm(YouTubePlayerBridge youTubePlayerBridge, String str) {
        this.f15347b = youTubePlayerBridge;
        this.f15346a = str;
    }

    public void run() {
        for (hfh a : this.f15347b.youTubePlayer.getListeners()) {
            a.mo2586a(this.f15346a);
        }
    }
}
