package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerBridge;

public class hfo implements Runnable {
    final /* synthetic */ float f15349a;
    final /* synthetic */ float f15350b;
    final /* synthetic */ YouTubePlayerBridge f15351c;

    public hfo(YouTubePlayerBridge youTubePlayerBridge, float f, float f2) {
        this.f15351c = youTubePlayerBridge;
        this.f15349a = f;
        this.f15350b = f2;
    }

    public void run() {
        for (hfh a : this.f15351c.youTubePlayer.getListeners()) {
            a.mo2584a(this.f15349a, this.f15350b);
        }
    }
}
