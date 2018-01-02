package com.songbirdnest.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.net.URL;

public abstract class ImageDownloadRunnable implements Runnable {
    int mTargetSize;
    String mUrl;

    public abstract void onPostExecute(Bitmap bitmap);

    public ImageDownloadRunnable(int pTargetSize, String pUrl) {
        this.mTargetSize = pTargetSize;
        this.mUrl = pUrl;
    }

    public void run() {
        try {
            if (this.mUrl != null) {
                Bitmap aFull = BitmapFactory.decodeStream(new URL(this.mUrl).openConnection().getInputStream());
                if (aFull == null) {
                    onPostExecute(aFull);
                    return;
                }
                Bitmap aPassback = Bitmap.createScaledBitmap(aFull, this.mTargetSize, this.mTargetSize, false);
                aFull.recycle();
                if (aPassback != null) {
                    onPostExecute(aPassback);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            onPostExecute(null);
        }
    }
}
