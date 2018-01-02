package com.ushareit.listenit;

import android.text.TextUtils;
import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerBridge;

public class hfr implements Runnable {
    final /* synthetic */ String f15356a;
    final /* synthetic */ YouTubePlayerBridge f15357b;

    public hfr(YouTubePlayerBridge youTubePlayerBridge, String str) {
        this.f15357b = youTubePlayerBridge;
        this.f15356a = str;
    }

    public void run() {
        try {
            float parseFloat = Float.parseFloat(TextUtils.isEmpty(this.f15356a) ? "0" : this.f15356a);
            for (hfh a : this.f15357b.youTubePlayer.getListeners()) {
                a.mo2583a(parseFloat);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
