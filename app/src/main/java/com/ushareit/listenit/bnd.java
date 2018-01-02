package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

@TargetApi(21)
final class bnd implements bnb {
    private final int f7128a;
    private MediaCodecInfo[] f7129b;

    public bnd(boolean z) {
        this.f7128a = z ? 1 : 0;
    }

    public int mo1017a() {
        m9119c();
        return this.f7129b.length;
    }

    public MediaCodecInfo mo1018a(int i) {
        m9119c();
        return this.f7129b[i];
    }

    public boolean mo1020b() {
        return true;
    }

    public boolean mo1019a(String str, CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private void m9119c() {
        if (this.f7129b == null) {
            this.f7129b = new MediaCodecList(this.f7128a).getCodecInfos();
        }
    }
}
