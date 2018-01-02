package com.ushareit.listenit;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.mopub.mobileads.VastVideoView;
import com.mopub.mobileads.VastVideoViewController;

public class ejx implements OnPreparedListener {
    final /* synthetic */ VastVideoView f11159a;
    final /* synthetic */ VastVideoViewController f11160b;

    public ejx(VastVideoViewController vastVideoViewController, VastVideoView vastVideoView) {
        this.f11160b = vastVideoViewController;
        this.f11159a = vastVideoView;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f11160b.f2485C = this.f11160b.f2488b.getDuration();
        this.f11160b.m2982p();
        if (this.f11160b.f2496j == null || this.f11160b.f2484B) {
            this.f11159a.prepareBlurredLastVideoFrame(this.f11160b.f2491e, this.f11160b.f2487a.getDiskMediaFileUrl());
        }
        this.f11160b.f2492f.calibrateAndMakeVisible(this.f11160b.m3004i(), this.f11160b.f2507u);
        this.f11160b.f2493g.m2947a(this.f11160b.f2507u);
        this.f11160b.f2483A = true;
    }
}
