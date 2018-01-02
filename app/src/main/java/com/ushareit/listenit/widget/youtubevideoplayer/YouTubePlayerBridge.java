package com.ushareit.listenit.widget.youtubevideoplayer;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.hfh;
import com.ushareit.listenit.hfi;
import com.ushareit.listenit.hfj;
import com.ushareit.listenit.hfk;
import com.ushareit.listenit.hfl;
import com.ushareit.listenit.hfm;
import com.ushareit.listenit.hfn;
import com.ushareit.listenit.hfo;
import com.ushareit.listenit.hfp;
import com.ushareit.listenit.hfq;
import com.ushareit.listenit.hfr;

public class YouTubePlayerBridge {
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private final YouTubePlayer youTubePlayer;

    public YouTubePlayerBridge(YouTubePlayer youTubePlayer) {
        this.youTubePlayer = youTubePlayer;
    }

    @JavascriptInterface
    public void onReady() {
        for (hfh a : this.youTubePlayer.getListeners()) {
            a.mo2581a();
        }
    }

    @JavascriptInterface
    public void onStateChange(String str) {
        this.mainThreadHandler.post(new hfi(this, str));
    }

    @JavascriptInterface
    public void onPlaybackQualityChange(String str) {
        this.mainThreadHandler.post(new hfk(this, str));
    }

    @JavascriptInterface
    public void onPlaybackRateChange(String str) {
        this.mainThreadHandler.post(new hfl(this, str));
    }

    @JavascriptInterface
    public void onError(String str) {
        this.mainThreadHandler.post(new hfm(this, str));
    }

    @JavascriptInterface
    public void onApiChange() {
        this.mainThreadHandler.post(new hfn(this));
    }

    @JavascriptInterface
    public void currentSeconds(String str, String str2) {
        try {
            this.mainThreadHandler.post(new hfo(this, Float.parseFloat(str), Float.parseFloat(str2)));
        } catch (Exception e) {
            exw.m18451b("YouTubePlayerBridge", "currentSeconds() has an exception.", e);
        }
    }

    @JavascriptInterface
    public void onVideoTitle(String str) {
        this.mainThreadHandler.post(new hfp(this, str));
    }

    @JavascriptInterface
    public void onVideoId(String str) {
        this.mainThreadHandler.post(new hfq(this, str));
    }

    @JavascriptInterface
    public void onVideoDuration(String str) {
        this.mainThreadHandler.post(new hfr(this, str));
    }

    @JavascriptInterface
    public void onLog(String str) {
        this.mainThreadHandler.post(new hfj(this, str));
    }
}
