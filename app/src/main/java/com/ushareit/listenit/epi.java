package com.ushareit.listenit;

import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;
import com.mopub.volley.toolbox.NetworkImageView;

public class epi implements ImageListener {
    final /* synthetic */ boolean f11430a;
    final /* synthetic */ NetworkImageView f11431b;

    public epi(NetworkImageView networkImageView, boolean z) {
        this.f11431b = networkImageView;
        this.f11430a = z;
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (this.f11431b.f2921c != 0) {
            this.f11431b.setImageResource(this.f11431b.f2921c);
        }
    }

    public void onResponse(ImageContainer imageContainer, boolean z) {
        if (z && this.f11430a) {
            this.f11431b.post(new epj(this, imageContainer));
        } else if (imageContainer.getBitmap() != null) {
            this.f11431b.setImageBitmap(imageContainer.getBitmap());
        } else if (this.f11431b.f2920b != 0) {
            this.f11431b.setImageResource(this.f11431b.f2920b);
        }
    }
}
