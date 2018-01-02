package com.ushareit.listenit;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

final class bnc implements bnb {
    private bnc() {
    }

    public int mo1017a() {
        return MediaCodecList.getCodecCount();
    }

    public MediaCodecInfo mo1018a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    public boolean mo1020b() {
        return false;
    }

    public boolean mo1019a(String str, CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
