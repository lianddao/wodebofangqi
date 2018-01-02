package com.ushareit.listenit;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.SystemClock;
import com.mopub.volley.DefaultRetryPolicy;

class bgt {
    protected AudioTrack f6239a;
    private boolean f6240b;
    private int f6241c;
    private long f6242d;
    private long f6243e;
    private long f6244f;
    private long f6245g;
    private long f6246h;
    private long f6247i;

    private bgt() {
    }

    public void mo925a(AudioTrack audioTrack, boolean z) {
        this.f6239a = audioTrack;
        this.f6240b = z;
        this.f6245g = -9223372036854775807L;
        this.f6242d = 0;
        this.f6243e = 0;
        this.f6244f = 0;
        if (audioTrack != null) {
            this.f6241c = audioTrack.getSampleRate();
        }
    }

    public void m8283a(long j) {
        this.f6246h = m8286b();
        this.f6245g = SystemClock.elapsedRealtime() * 1000;
        this.f6247i = j;
        this.f6239a.stop();
    }

    public void m8282a() {
        if (this.f6245g == -9223372036854775807L) {
            this.f6239a.pause();
        }
    }

    public long m8286b() {
        if (this.f6245g != -9223372036854775807L) {
            return Math.min(this.f6247i, ((((SystemClock.elapsedRealtime() * 1000) - this.f6245g) * ((long) this.f6241c)) / 1000000) + this.f6246h);
        }
        int playState = this.f6239a.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.f6239a.getPlaybackHeadPosition());
        if (this.f6240b) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f6244f = this.f6242d;
            }
            playbackHeadPosition += this.f6244f;
        }
        if (this.f6242d > playbackHeadPosition) {
            this.f6243e++;
        }
        this.f6242d = playbackHeadPosition;
        return playbackHeadPosition + (this.f6243e << 32);
    }

    public long m8287c() {
        return (m8286b() * 1000000) / ((long) this.f6241c);
    }

    public boolean mo926d() {
        return false;
    }

    public long mo927e() {
        throw new UnsupportedOperationException();
    }

    public long mo928f() {
        throw new UnsupportedOperationException();
    }

    public void mo929a(PlaybackParams playbackParams) {
        throw new UnsupportedOperationException();
    }

    public float mo930g() {
        return DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    }
}
