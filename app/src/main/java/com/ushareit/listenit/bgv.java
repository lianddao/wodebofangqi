package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import com.mopub.volley.DefaultRetryPolicy;

@TargetApi(23)
class bgv extends bgu {
    private PlaybackParams f6252b;
    private float f6253c = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;

    public void mo925a(AudioTrack audioTrack, boolean z) {
        super.mo925a(audioTrack, z);
        m8296h();
    }

    public void mo929a(PlaybackParams playbackParams) {
        if (playbackParams == null) {
            playbackParams = new PlaybackParams();
        }
        PlaybackParams allowDefaults = playbackParams.allowDefaults();
        this.f6252b = allowDefaults;
        this.f6253c = allowDefaults.getSpeed();
        m8296h();
    }

    public float mo930g() {
        return this.f6253c;
    }

    private void m8296h() {
        if (this.a != null && this.f6252b != null) {
            this.a.setPlaybackParams(this.f6252b);
        }
    }
}
