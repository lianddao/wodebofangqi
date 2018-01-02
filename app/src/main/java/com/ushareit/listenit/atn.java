package com.ushareit.listenit;

import android.content.Context;
import android.media.AudioManager;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.Map;

public class atn {
    public static float m7129a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume > 0) {
                return (((float) streamVolume) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) streamMaxVolume);
            }
        }
        return 0.0f;
    }

    public static void m7130a(Map<String, String> map, boolean z, boolean z2) {
        map.put("autoplay", z ? "1" : "0");
        map.put("inline", z2 ? "1" : "0");
    }
}
