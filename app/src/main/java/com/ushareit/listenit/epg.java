package com.ushareit.listenit;

import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import java.util.Iterator;

public class epg implements Runnable {
    final /* synthetic */ ImageLoader f11424a;

    public epg(ImageLoader imageLoader) {
        this.f11424a = imageLoader;
    }

    public void run() {
        for (eph com_ushareit_listenit_eph : this.f11424a.f2833e.values()) {
            Iterator it = com_ushareit_listenit_eph.f11429e.iterator();
            while (it.hasNext()) {
                ImageContainer imageContainer = (ImageContainer) it.next();
                if (imageContainer.f2911c != null) {
                    if (com_ushareit_listenit_eph.getError() == null) {
                        imageContainer.f2910b = com_ushareit_listenit_eph.f11427c;
                        imageContainer.f2911c.onResponse(imageContainer, false);
                    } else {
                        imageContainer.f2911c.onErrorResponse(com_ushareit_listenit_eph.getError());
                    }
                }
            }
        }
        this.f11424a.f2833e.clear();
        this.f11424a.f2835g = null;
    }
}
