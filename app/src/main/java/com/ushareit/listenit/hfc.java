package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.webkit.WebChromeClient;
import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayer;

public class hfc extends WebChromeClient {
    final /* synthetic */ YouTubePlayer f15330a;

    public hfc(YouTubePlayer youTubePlayer) {
        this.f15330a = youTubePlayer;
    }

    public Bitmap getDefaultVideoPoster() {
        Bitmap bitmap = null;
        try {
            bitmap = super.getDefaultVideoPoster();
        } catch (Exception e) {
        }
        int[] iArr = new int[]{Color.parseColor("#000000")};
        if (bitmap == null) {
            return Bitmap.createBitmap(iArr, 1, 1, Config.RGB_565);
        }
        return bitmap;
    }
}
