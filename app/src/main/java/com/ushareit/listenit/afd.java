package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class afd {
    public <Z> afi<Z> m5451a(ImageView imageView, Class<Z> cls) {
        if (abo.class.isAssignableFrom(cls)) {
            return new afb(imageView);
        }
        if (Bitmap.class.equals(cls)) {
            return new aez(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new afa(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
