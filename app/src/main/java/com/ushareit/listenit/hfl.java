package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerBridge;

public class hfl implements Runnable {
    final /* synthetic */ String f15344a;
    final /* synthetic */ YouTubePlayerBridge f15345b;

    public hfl(YouTubePlayerBridge youTubePlayerBridge, String str) {
        this.f15345b = youTubePlayerBridge;
        this.f15344a = str;
    }

    public void run() {
        try {
            double parseDouble = Double.parseDouble(this.f15344a);
            for (hfh a : this.f15345b.youTubePlayer.getListeners()) {
                a.mo2582a(parseDouble);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
