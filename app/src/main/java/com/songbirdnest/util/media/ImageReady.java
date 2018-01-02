package com.songbirdnest.util.media;

import android.graphics.Bitmap;

public interface ImageReady {
    void error(String str, Exception exception);

    void ready(String str, Bitmap bitmap);
}
