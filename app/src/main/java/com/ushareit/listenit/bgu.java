package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
class bgu extends bgt {
    private final AudioTimestamp f6248b = new AudioTimestamp();
    private long f6249c;
    private long f6250d;
    private long f6251e;

    public bgu() {
        super();
    }

    public void mo925a(AudioTrack audioTrack, boolean z) {
        super.mo925a(audioTrack, z);
        this.f6249c = 0;
        this.f6250d = 0;
        this.f6251e = 0;
    }

    public boolean mo926d() {
        boolean timestamp = this.a.getTimestamp(this.f6248b);
        if (timestamp) {
            long j = this.f6248b.framePosition;
            if (this.f6250d > j) {
                this.f6249c++;
            }
            this.f6250d = j;
            this.f6251e = j + (this.f6249c << 32);
        }
        return timestamp;
    }

    public long mo927e() {
        return this.f6248b.nanoTime;
    }

    public long mo928f() {
        return this.f6251e;
    }
}
