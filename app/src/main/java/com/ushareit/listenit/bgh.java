package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class bgh {
    public static final bgh f6177a = new bgh(new int[]{2}, 2);
    private final int[] f6178b;
    private final int f6179c;

    public static bgh m8236a(Context context) {
        return m8237a(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static bgh m8237a(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return f6177a;
        }
        return new bgh(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    bgh(int[] iArr, int i) {
        if (iArr != null) {
            this.f6178b = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.f6178b);
        } else {
            this.f6178b = new int[0];
        }
        this.f6179c = i;
    }

    public boolean m8238a(int i) {
        return Arrays.binarySearch(this.f6178b, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bgh)) {
            return false;
        }
        bgh com_ushareit_listenit_bgh = (bgh) obj;
        if (Arrays.equals(this.f6178b, com_ushareit_listenit_bgh.f6178b) && this.f6179c == com_ushareit_listenit_bgh.f6179c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f6179c + (Arrays.hashCode(this.f6178b) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f6179c + ", supportedEncodings=" + Arrays.toString(this.f6178b) + "]";
    }
}
