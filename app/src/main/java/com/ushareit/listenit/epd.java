package com.ushareit.listenit;

import android.widget.ImageView;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

public final class epd implements ImageListener {
    final /* synthetic */ int f11417a;
    final /* synthetic */ ImageView f11418b;
    final /* synthetic */ int f11419c;

    public epd(int i, ImageView imageView, int i2) {
        this.f11417a = i;
        this.f11418b = imageView;
        this.f11419c = i2;
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (this.f11417a != 0) {
            this.f11418b.setImageResource(this.f11417a);
        }
    }

    public void onResponse(ImageContainer imageContainer, boolean z) {
        if (imageContainer.getBitmap() != null) {
            this.f11418b.setImageBitmap(imageContainer.getBitmap());
        } else if (this.f11419c != 0) {
            this.f11418b.setImageResource(this.f11419c);
        }
    }
}
