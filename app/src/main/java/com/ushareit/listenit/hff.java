package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayer;

public class hff implements Runnable {
    final /* synthetic */ YouTubePlayer f15335a;

    public hff(YouTubePlayer youTubePlayer) {
        this.f15335a = youTubePlayer;
    }

    public void run() {
        this.f15335a.loadUrl("javascript:pauseVideo()");
    }
}
