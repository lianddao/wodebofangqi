package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.internal.cb;
import com.facebook.internal.cj;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.List;
import java.util.Locale;

public class bcd {
    private static bcf f5893a;
    private static bcf f5894b;

    public static void m7681a(ShareContent shareContent) {
        m7682a(shareContent, m7680a());
    }

    public static void m7695b(ShareContent shareContent) {
        m7682a(shareContent, m7680a());
    }

    public static void m7705c(ShareContent shareContent) {
        m7682a(shareContent, m7694b());
    }

    private static bcf m7680a() {
        if (f5894b == null) {
            f5894b = new bcf();
        }
        return f5894b;
    }

    private static bcf m7694b() {
        if (f5893a == null) {
            f5893a = new bcg();
        }
        return f5893a;
    }

    private static void m7682a(ShareContent shareContent, bcf com_ushareit_listenit_bcf) {
        if (shareContent == null) {
            throw new aif("Must provide non-null content to share");
        } else if (shareContent instanceof ShareLinkContent) {
            com_ushareit_listenit_bcf.m7709a((ShareLinkContent) shareContent);
        } else if (shareContent instanceof SharePhotoContent) {
            com_ushareit_listenit_bcf.mo845a((SharePhotoContent) shareContent);
        } else if (shareContent instanceof ShareVideoContent) {
            com_ushareit_listenit_bcf.mo846a((ShareVideoContent) shareContent);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            com_ushareit_listenit_bcf.m7711a((ShareOpenGraphContent) shareContent);
        }
    }

    private static void m7696b(ShareLinkContent shareLinkContent, bcf com_ushareit_listenit_bcf) {
        Uri c = shareLinkContent.m1968c();
        if (c != null && !cb.m1602b(c)) {
            throw new aif("Image Url must be an http:// or https:// url");
        }
    }

    private static void m7702b(SharePhotoContent sharePhotoContent, bcf com_ushareit_listenit_bcf) {
        List<SharePhoto> a = sharePhotoContent.m1981a();
        if (a == null || a.isEmpty()) {
            throw new aif("Must specify at least one Photo in SharePhotoContent.");
        } else if (a.size() > 6) {
            throw new aif(String.format(Locale.ROOT, "Cannot add more than %d photos.", new Object[]{Integer.valueOf(6)}));
        } else {
            for (SharePhoto a2 : a) {
                com_ushareit_listenit_bcf.mo844a(a2);
            }
        }
    }

    private static void m7706c(SharePhoto sharePhoto, bcf com_ushareit_listenit_bcf) {
        if (sharePhoto == null) {
            throw new aif("Cannot share a null SharePhoto");
        }
        Bitmap b = sharePhoto.m1977b();
        Uri c = sharePhoto.m1978c();
        if (b != null) {
            return;
        }
        if (c == null) {
            throw new aif("SharePhoto does not have a Bitmap or ImageUrl specified");
        } else if (cb.m1602b(c) && !com_ushareit_listenit_bcf.m7718a()) {
            throw new aif("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }

    private static void m7707d(SharePhoto sharePhoto, bcf com_ushareit_listenit_bcf) {
        m7706c(sharePhoto, com_ushareit_listenit_bcf);
        if (sharePhoto.m1977b() != null || !cb.m1602b(sharePhoto.m1978c())) {
            cj.m1648c(ail.m5715f());
        }
    }

    private static void m7708e(SharePhoto sharePhoto, bcf com_ushareit_listenit_bcf) {
        if (sharePhoto == null) {
            throw new aif("Cannot share a null SharePhoto");
        }
        Uri c = sharePhoto.m1978c();
        if (c == null || !cb.m1602b(c)) {
            throw new aif("SharePhoto must have a non-null imageUrl set to the Uri of an image on the web");
        }
    }

    private static void m7704b(ShareVideoContent shareVideoContent, bcf com_ushareit_listenit_bcf) {
        com_ushareit_listenit_bcf.m7716a(shareVideoContent.m1986d());
        SharePhoto c = shareVideoContent.m1985c();
        if (c != null) {
            com_ushareit_listenit_bcf.mo844a(c);
        }
    }

    private static void m7703b(ShareVideo shareVideo, bcf com_ushareit_listenit_bcf) {
        if (shareVideo == null) {
            throw new aif("Cannot share a null ShareVideo");
        }
        Uri b = shareVideo.m1982b();
        if (b == null) {
            throw new aif("ShareVideo does not have a LocalUrl specified");
        } else if (!cb.m1608c(b) && !cb.m1612d(b)) {
            throw new aif("ShareVideo must reference a video that is on the device");
        }
    }

    private static void m7698b(ShareOpenGraphContent shareOpenGraphContent, bcf com_ushareit_listenit_bcf) {
        com_ushareit_listenit_bcf.m7710a(shareOpenGraphContent.m1975a());
        String b = shareOpenGraphContent.m1976b();
        if (cb.m1591a(b)) {
            throw new aif("Must specify a previewPropertyName.");
        } else if (shareOpenGraphContent.m1975a().m1970a(b) == null) {
            throw new aif("Property \"" + b + "\" was not found on the action. " + "The name of the preview property must match the name of an " + "action property.");
        }
    }

    private static void m7697b(ShareOpenGraphAction shareOpenGraphAction, bcf com_ushareit_listenit_bcf) {
        if (shareOpenGraphAction == null) {
            throw new aif("Must specify a non-null ShareOpenGraphAction");
        } else if (cb.m1591a(shareOpenGraphAction.m1974a())) {
            throw new aif("ShareOpenGraphAction must have a non-empty actionType");
        } else {
            com_ushareit_listenit_bcf.m7713a(shareOpenGraphAction, false);
        }
    }

    private static void m7699b(ShareOpenGraphObject shareOpenGraphObject, bcf com_ushareit_listenit_bcf) {
        if (shareOpenGraphObject == null) {
            throw new aif("Cannot share a null ShareOpenGraphObject");
        }
        com_ushareit_listenit_bcf.m7713a(shareOpenGraphObject, true);
    }

    private static void m7700b(ShareOpenGraphValueContainer shareOpenGraphValueContainer, bcf com_ushareit_listenit_bcf, boolean z) {
        for (String str : shareOpenGraphValueContainer.m1973c()) {
            m7693a(str, z);
            Object a = shareOpenGraphValueContainer.m1970a(str);
            if (a instanceof List) {
                for (Object next : (List) a) {
                    if (next == null) {
                        throw new aif("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                    m7692a(next, com_ushareit_listenit_bcf);
                }
                continue;
            } else {
                m7692a(a, com_ushareit_listenit_bcf);
            }
        }
    }

    private static void m7693a(String str, boolean z) {
        if (z) {
            String[] split = str.split(":");
            if (split.length < 2) {
                throw new aif("Open Graph keys must be namespaced: %s", str);
            }
            for (String isEmpty : split) {
                if (isEmpty.isEmpty()) {
                    throw new aif("Invalid key found in Open Graph dictionary: %s", str);
                }
            }
        }
    }

    private static void m7692a(Object obj, bcf com_ushareit_listenit_bcf) {
        if (obj instanceof ShareOpenGraphObject) {
            com_ushareit_listenit_bcf.m7712a((ShareOpenGraphObject) obj);
        } else if (obj instanceof SharePhoto) {
            com_ushareit_listenit_bcf.mo844a((SharePhoto) obj);
        }
    }
}
