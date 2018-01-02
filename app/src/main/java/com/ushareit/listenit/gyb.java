package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

public class gyb {
    private static gyb f14897d;
    private final int f14898a;
    private final int f14899b;
    private final gyf<String, Bitmap> f14900c;

    private gyb() {
        int i;
        long a = fap.m18730a();
        if (a < 750) {
            i = CtaButton.WIDTH_DIPS;
        } else {
            i = 30;
        }
        this.f14899b = i;
        this.f14898a = 30;
        this.f14900c = new gyf(a < 750 ? 8 : 12);
    }

    public static synchronized gyb m23123a() {
        gyb com_ushareit_listenit_gyb;
        synchronized (gyb.class) {
            if (f14897d == null) {
                f14897d = new gyb();
            }
            com_ushareit_listenit_gyb = f14897d;
        }
        return com_ushareit_listenit_gyb;
    }

    public void m23134b() {
        this.f14900c.clear();
    }

    public void m23131a(hac com_ushareit_listenit_hac, gla com_ushareit_listenit_gla, gye com_ushareit_listenit_gye) {
        m23132a(com_ushareit_listenit_hac, com_ushareit_listenit_gla, com_ushareit_listenit_gye, 2);
    }

    public void m23132a(hac com_ushareit_listenit_hac, gla com_ushareit_listenit_gla, gye com_ushareit_listenit_gye, int i) {
        if (com_ushareit_listenit_hac != null && com_ushareit_listenit_gye != null && com_ushareit_listenit_gla != null) {
            String str = com_ushareit_listenit_gla.mo2557a() + "_" + com_ushareit_listenit_hac.m23434b() + "_" + com_ushareit_listenit_hac.m23435c() + "_" + com_ushareit_listenit_gla.mo2561b();
            Bitmap bitmap = (Bitmap) this.f14900c.get(str);
            if (bitmap == null) {
                hhx.m23869a(new gyd(this, com_ushareit_listenit_gla, com_ushareit_listenit_hac, str, com_ushareit_listenit_gye), m23129a(i), m23133b(i));
            } else if (com_ushareit_listenit_hac.f15034d.getTag(C0349R.id.glide_view_tag_id).equals(com_ushareit_listenit_hac.m23433a())) {
                hhx.m23869a(new gyc(this, com_ushareit_listenit_gye, bitmap), 0, m23129a(i) + m23133b(i));
            }
        }
    }

    public int m23129a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return this.f14899b / 4;
        }
        return this.f14899b;
    }

    public int m23133b(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return this.f14898a / 4;
        }
        return this.f14898a;
    }

    public void m23130a(int i, ImageView imageView) {
        Bitmap bitmap = (Bitmap) this.f14900c.get(m23128b(i, imageView));
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            faq.m18735a(new gyh(this, i, imageView));
        }
    }

    private boolean m23126a(ImageView imageView) {
        return (imageView == null || imageView.getWidth() == 0 || imageView.getHeight() == 0) ? false : true;
    }

    private String m23128b(int i, ImageView imageView) {
        if (m23126a(imageView)) {
            return new StringBuffer(String.valueOf(i)).append("_").append(imageView.getWidth()).append("_").append(imageView.getHeight()).toString();
        }
        return null;
    }
}
