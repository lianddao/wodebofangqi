package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.widget.ImageView;

public class fzi {
    public static final boolean f13764a = (VERSION.SDK_INT >= 10);

    public static void m21401a(Context context, gla com_ushareit_listenit_gla, ImageView imageView, tv tvVar, int i) {
        if (context != null && com_ushareit_listenit_gla != null && imageView != null) {
            Drawable b = gyn.m23207b(C0349R.drawable.default_albumart_gray, i, i);
            Drawable b2 = ((com_ushareit_listenit_gla instanceof glg) && gyn.m23260p(com_ushareit_listenit_gla.mo2558g())) ? b : gyn.m23207b(gyn.m23169a(com_ushareit_listenit_gla), i, i);
            if (f13764a) {
                m21403a(context, (Object) com_ushareit_listenit_gla, imageView, tvVar, i, i, b, b2, null);
                return;
            }
            imageView.setImageDrawable(b);
            gyb.m23123a().m23131a(new hac(imageView, i, i, com_ushareit_listenit_gla.mo2557a()), com_ushareit_listenit_gla, new fzj(imageView));
        }
    }

    public static void m21405a(ImageView imageView, int i) {
        gyb.m23123a().m23130a(i, imageView);
    }

    public static void m21402a(Context context, gla com_ushareit_listenit_gla, ImageView imageView, tv tvVar, int i, fzv com_ushareit_listenit_fzv) {
        if (com_ushareit_listenit_gla != null && com_ushareit_listenit_fzv != null) {
            int a = ((com_ushareit_listenit_gla instanceof glg) && gyn.m23260p(com_ushareit_listenit_gla.mo2558g())) ? C0349R.drawable.default_albumart_white : gyn.m23169a(com_ushareit_listenit_gla);
            if (f13764a) {
                m21404a(context, (Object) com_ushareit_listenit_gla, com_ushareit_listenit_gla.mo2557a(), imageView, (int) C0349R.drawable.default_albumart_white, a, tvVar, i, com_ushareit_listenit_fzv);
                return;
            }
            imageView.setImageResource(C0349R.drawable.default_albumart_white);
            gyb.m23123a().m23131a(new hac(imageView, i, i, com_ushareit_listenit_gla.mo2557a()), com_ushareit_listenit_gla, new fzk(com_ushareit_listenit_fzv));
        }
    }

    public static void m21399a(Context context, gla com_ushareit_listenit_gla, ImageView imageView, int i, int i2, int i3, int i4) {
        m21400a(context, com_ushareit_listenit_gla, imageView, i, i2, tv.NORMAL, i3, i4, new fzl(imageView));
    }

    public static void m21400a(Context context, gla com_ushareit_listenit_gla, ImageView imageView, int i, int i2, tv tvVar, int i3, int i4, fzv com_ushareit_listenit_fzv) {
        if (com_ushareit_listenit_gla != null && com_ushareit_listenit_fzv != null) {
            if (f13764a) {
                m21404a(context, (Object) com_ushareit_listenit_gla, com_ushareit_listenit_gla.mo2557a(), imageView, i, i2, tvVar, i3, com_ushareit_listenit_fzv);
                return;
            }
            imageView.setImageResource(i);
            gyb.m23123a().m23131a(new hac(imageView, i3, i4, com_ushareit_listenit_gla.mo2557a()), com_ushareit_listenit_gla, new fzm(com_ushareit_listenit_fzv));
        }
    }

    public static void m21397a(Context context, Uri uri, ImageView imageView, tv tvVar, int i, fzv com_ushareit_listenit_fzv) {
        if (uri != null && com_ushareit_listenit_fzv != null && f13764a) {
            m21404a(context, (Object) uri, uri.toString(), imageView, 0, (int) C0349R.drawable.default_download_error_icon, tvVar, i, com_ushareit_listenit_fzv);
        }
    }

    public static void m21395a(Context context, Uri uri, ImageView imageView, int i, int i2, fzv com_ushareit_listenit_fzv) {
        if (uri != null && com_ushareit_listenit_fzv != null) {
            tv tvVar = tv.HIGH;
            if (f13764a) {
                m21403a(context, (Object) uri, imageView, tvVar, i, i2, null, null, new fzn(com_ushareit_listenit_fzv));
            }
        }
    }

    public static void m21396a(Context context, Uri uri, ImageView imageView, tv tvVar, int i, Drawable drawable) {
        if (uri != null && f13764a) {
            m21403a(context, (Object) uri, imageView, tvVar, i, i, drawable, null, null);
        }
    }

    public static void m21398a(Context context, ImageView imageView, Object obj, int i, int i2, int i3) {
        if (f13764a && !m21406a(context)) {
            try {
                tt.m26453b(context).m26480a(obj).m26417a(tv.priority).m26421a(vq.RESULT).m26423a(false).mo3071a().m26415a(i, i2).m26414a(i3).m26439d().mo3070a(imageView);
            } catch (Throwable e) {
                exw.m18450b("ImageLoadHelper", "There is an error when load video thumbnail. ", e);
                fii.m19312c(e.getMessage());
            }
        }
    }

    public static Bitmap m21394a(ImageView imageView) {
        if (imageView == null) {
            return null;
        }
        imageView.setDrawingCacheEnabled(false);
        imageView.setDrawingCacheEnabled(true);
        return imageView.getDrawingCache();
    }

    public static void m21404a(Context context, Object obj, String str, ImageView imageView, int i, int i2, tv tvVar, int i3, fzv com_ushareit_listenit_fzv) {
        if (imageView != null) {
            imageView.setTag(C0349R.id.glide_view_tag_id, str);
            if (i > 0) {
                imageView.setImageResource(i);
            }
        }
        m21403a(context, obj, imageView, tvVar, i3, i3, null, null, new fzo(com_ushareit_listenit_fzv, imageView, str, i2, context));
    }

    private static void m21403a(Context context, Object obj, ImageView imageView, tv tvVar, int i, int i2, Drawable drawable, Drawable drawable2, afe<Bitmap> com_ushareit_listenit_afe_android_graphics_Bitmap) {
        if (!m21406a(context)) {
            if (com_ushareit_listenit_afe_android_graphics_Bitmap != null) {
                try {
                    tn j = tt.m26453b(context).m26480a(obj).m26447j();
                    j.m26382a(tvVar).m26386a(vq.RESULT).m26388a(false);
                    if (i > 0 && i2 > 0) {
                        j.m26380a(i, i2);
                    }
                    j.m26359a((afi) com_ushareit_listenit_afe_android_graphics_Bitmap);
                    return;
                } catch (Exception e) {
                    exw.m18457e("ImageLoadHelper", "load error " + e.getMessage());
                    fii.m19312c(e.getMessage());
                    return;
                }
            }
            tp a = tt.m26453b(context).m26480a(obj);
            a.m26417a(tvVar).m26421a(vq.RESULT).m26423a(false).m26437c();
            if (i > 0 && i2 > 0) {
                a.m26415a(i, i2);
            }
            if (drawable != null) {
                a.m26416a(drawable);
            }
            if (drawable2 != null) {
                a.m26426b(drawable2);
            }
            a.mo3070a(imageView);
        }
    }

    private static boolean m21406a(Context context) {
        if (context == null) {
            return true;
        }
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (((context instanceof ak) || (context instanceof Activity)) && ((Activity) context).isDestroyed()) {
            return true;
        }
        return false;
    }
}
