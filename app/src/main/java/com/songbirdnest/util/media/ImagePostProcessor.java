package com.songbirdnest.util.media;

import android.graphics.Bitmap;

public interface ImagePostProcessor {
    Bitmap postProcess(Bitmap bitmap);
}
