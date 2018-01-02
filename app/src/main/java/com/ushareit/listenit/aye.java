package com.ushareit.listenit;

import android.widget.MediaController.MediaPlayerControl;
import com.facebook.ads.internal.view.p003d.p005c.C0047a;

public class aye implements MediaPlayerControl {
    final /* synthetic */ C0047a f5642a;

    public aye(C0047a c0047a) {
        this.f5642a = c0047a;
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public int getAudioSessionId() {
        return this.f5642a.f756g.m8172l();
    }

    public int getBufferPercentage() {
        return this.f5642a.f756g.mo906k();
    }

    public int getCurrentPosition() {
        return this.f5642a.getCurrentPosition();
    }

    public int getDuration() {
        return this.f5642a.getDuration();
    }

    public boolean isPlaying() {
        return this.f5642a.f756g.mo897b();
    }

    public void pause() {
        this.f5642a.pause();
    }

    public void seekTo(int i) {
        this.f5642a.seekTo(i);
    }

    public void start() {
        this.f5642a.start();
    }
}
