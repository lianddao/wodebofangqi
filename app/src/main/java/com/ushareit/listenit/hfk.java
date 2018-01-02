package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerBridge;

public class hfk implements Runnable {
    final /* synthetic */ String f15342a;
    final /* synthetic */ YouTubePlayerBridge f15343b;

    public hfk(YouTubePlayerBridge youTubePlayerBridge, String str) {
        this.f15343b = youTubePlayerBridge;
        this.f15342a = str;
    }

    public void run() {
        for (hfh com_ushareit_listenit_hfh : this.f15343b.youTubePlayer.getListeners()) {
            if ("small".equalsIgnoreCase(this.f15342a)) {
                com_ushareit_listenit_hfh.mo2587b(0);
            } else if ("medium".equalsIgnoreCase(this.f15342a)) {
                com_ushareit_listenit_hfh.mo2587b(1);
            } else if ("large".equalsIgnoreCase(this.f15342a)) {
                com_ushareit_listenit_hfh.mo2587b(2);
            } else if ("hd720".equalsIgnoreCase(this.f15342a)) {
                com_ushareit_listenit_hfh.mo2587b(3);
            } else if ("hd1080".equalsIgnoreCase(this.f15342a)) {
                com_ushareit_listenit_hfh.mo2587b(4);
            } else if ("highres".equalsIgnoreCase(this.f15342a)) {
                com_ushareit_listenit_hfh.mo2587b(5);
            } else if ("default".equalsIgnoreCase(this.f15342a)) {
                com_ushareit_listenit_hfh.mo2587b(-1);
            }
        }
    }
}
