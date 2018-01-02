package com.ushareit.listenit;

import com.google.android.exoplayer2.ui.PlaybackControlView;

public class bqs implements Runnable {
    final /* synthetic */ PlaybackControlView f7443a;

    public bqs(PlaybackControlView playbackControlView) {
        this.f7443a = playbackControlView;
    }

    public void run() {
        this.f7443a.m2103h();
    }
}
