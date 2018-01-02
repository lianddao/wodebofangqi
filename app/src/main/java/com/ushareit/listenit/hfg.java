package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayer;

public class hfg implements Runnable {
    final /* synthetic */ int f15336a;
    final /* synthetic */ YouTubePlayer f15337b;

    public hfg(YouTubePlayer youTubePlayer, int i) {
        this.f15337b = youTubePlayer;
        this.f15336a = i;
    }

    public void run() {
        this.f15337b.loadUrl("javascript:seekTo(" + this.f15336a + ")");
    }
}
