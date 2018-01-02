package com.songbirdnest.util.media;

import android.graphics.Bitmap;

public interface BitmapRemovedListener<K> {
    void bitmapRemoved(K k, Bitmap bitmap);
}
