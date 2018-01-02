package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayer;

public class hfd implements Runnable {
    final /* synthetic */ String f15331a;
    final /* synthetic */ float f15332b;
    final /* synthetic */ YouTubePlayer f15333c;

    public hfd(YouTubePlayer youTubePlayer, String str, float f) {
        this.f15333c = youTubePlayer;
        this.f15331a = str;
        this.f15332b = f;
    }

    public void run() {
        this.f15333c.loadUrl("javascript:loadVideo('" + this.f15331a + "', " + this.f15332b + ")");
    }
}
