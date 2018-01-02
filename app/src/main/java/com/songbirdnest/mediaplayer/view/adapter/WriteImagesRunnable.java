package com.songbirdnest.mediaplayer.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import com.songbirdnest.facebook.util.FacebookUtils;
import com.songbirdnest.util.Logger;

public class WriteImagesRunnable implements Runnable {
    private Bitmap bitmap;
    private Context context;
    private String facebookId;
    private boolean timing = false;

    public WriteImagesRunnable(Context context, String facebookId, Bitmap bitmap) {
        this.context = context;
        this.facebookId = facebookId;
        this.bitmap = bitmap;
    }

    public void run() {
        long start = 0;
        if (this.timing) {
            start = System.currentTimeMillis();
        }
        FacebookUtils.saveFacebookFile(this.context, this.facebookId, this.bitmap);
        if (this.timing) {
            Logger.debug(this, "Time to write bitmap file was " + (System.currentTimeMillis() - start) + " ms");
        }
    }
}
