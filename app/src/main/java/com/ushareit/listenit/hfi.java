package com.ushareit.listenit;

import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerBridge;

public class hfi implements Runnable {
    final /* synthetic */ String f15338a;
    final /* synthetic */ YouTubePlayerBridge f15339b;

    public hfi(YouTubePlayerBridge youTubePlayerBridge, String str) {
        this.f15339b = youTubePlayerBridge;
        this.f15338a = str;
    }

    public void run() {
        for (hfh com_ushareit_listenit_hfh : this.f15339b.youTubePlayer.getListeners()) {
            if ("UNSTARTED".equalsIgnoreCase(this.f15338a)) {
                com_ushareit_listenit_hfh.mo2585a(-1);
            } else if ("ENDED".equalsIgnoreCase(this.f15338a)) {
                com_ushareit_listenit_hfh.mo2585a(0);
            } else if ("PLAYING".equalsIgnoreCase(this.f15338a)) {
                com_ushareit_listenit_hfh.mo2585a(1);
            } else if ("PAUSED".equalsIgnoreCase(this.f15338a)) {
                com_ushareit_listenit_hfh.mo2585a(2);
            } else if ("BUFFERING".equalsIgnoreCase(this.f15338a)) {
                com_ushareit_listenit_hfh.mo2585a(3);
            } else if ("CUED".equalsIgnoreCase(this.f15338a)) {
                com_ushareit_listenit_hfh.mo2585a(5);
            }
        }
    }
}
