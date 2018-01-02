package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayer;

public class hfe implements Runnable {
    final /* synthetic */ YouTubePlayer f15334a;

    public hfe(YouTubePlayer youTubePlayer) {
        this.f15334a = youTubePlayer;
    }

    public void run() {
        this.f15334a.loadUrl("javascript:playVideo()");
    }
}
