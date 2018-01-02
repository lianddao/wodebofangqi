package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Pair;

@TargetApi(16)
public final class bms {
    public final String f7109a;
    public final boolean f7110b;
    private final String f7111c;
    private final CodecCapabilities f7112d;

    public static bms m9085a(String str) {
        return new bms(str, null, null);
    }

    public static bms m9086a(String str, String str2, CodecCapabilities codecCapabilities) {
        return new bms(str, str2, codecCapabilities);
    }

    private bms(String str, String str2, CodecCapabilities codecCapabilities) {
        this.f7109a = (String) bsg.m9654a((Object) str);
        this.f7111c = str2;
        this.f7112d = codecCapabilities;
        boolean z = codecCapabilities != null && m9087a(codecCapabilities);
        this.f7110b = z;
    }

    public CodecProfileLevel[] m9092a() {
        return (this.f7112d == null || this.f7112d.profileLevels == null) ? new CodecProfileLevel[0] : this.f7112d.profileLevels;
    }

    public boolean m9094b(String str) {
        if (str == null || this.f7111c == null) {
            return true;
        }
        String d = bsn.m9680d(str);
        if (d == null) {
            return true;
        }
        if (!this.f7111c.equals(d)) {
            return false;
        }
        Pair a = bmx.m9102a(str);
        if (a == null) {
            return true;
        }
        for (CodecProfileLevel codecProfileLevel : m9092a()) {
            if (codecProfileLevel.profile == ((Integer) a.first).intValue() && codecProfileLevel.level >= ((Integer) a.second).intValue()) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(21)
    public boolean m9090a(int i, int i2) {
        if (this.f7112d == null) {
            return false;
        }
        VideoCapabilities videoCapabilities = this.f7112d.getVideoCapabilities();
        if (videoCapabilities == null || !videoCapabilities.isSizeSupported(i, i2)) {
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public boolean m9091a(int i, int i2, double d) {
        if (this.f7112d == null) {
            return false;
        }
        VideoCapabilities videoCapabilities = this.f7112d.getVideoCapabilities();
        if (videoCapabilities == null || !videoCapabilities.areSizeAndRateSupported(i, i2, d)) {
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public boolean m9089a(int i) {
        if (this.f7112d == null) {
            return false;
        }
        AudioCapabilities audioCapabilities = this.f7112d.getAudioCapabilities();
        if (audioCapabilities == null || !audioCapabilities.isSampleRateSupported(i)) {
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public boolean m9093b(int i) {
        if (this.f7112d == null) {
            return false;
        }
        AudioCapabilities audioCapabilities = this.f7112d.getAudioCapabilities();
        if (audioCapabilities == null || audioCapabilities.getMaxInputChannelCount() < i) {
            return false;
        }
        return true;
    }

    private static boolean m9087a(CodecCapabilities codecCapabilities) {
        return btc.f7662a >= 19 && m9088b(codecCapabilities);
    }

    @TargetApi(19)
    private static boolean m9088b(CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }
}
