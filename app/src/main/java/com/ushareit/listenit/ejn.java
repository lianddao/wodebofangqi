package com.ushareit.listenit;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastResourceXmlManager;
import com.mopub.mobileads.VastWebView;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ejn implements Serializable {
    private static final List<String> f11136a = Arrays.asList(new String[]{"image/jpeg", "image/png", "image/bmp", "image/gif"});
    private static final List<String> f11137b = Arrays.asList(new String[]{"application/x-javascript"});
    private String f11138c;
    private ejq f11139d;
    private ejp f11140e;
    private int f11141f;
    private int f11142g;

    public static ejn m17132a(VastResourceXmlManager vastResourceXmlManager, ejq com_ushareit_listenit_ejq, int i, int i2) {
        ejp com_ushareit_listenit_ejp;
        Preconditions.checkNotNull(vastResourceXmlManager);
        Preconditions.checkNotNull(com_ushareit_listenit_ejq);
        String c = vastResourceXmlManager.m2928c();
        String d = vastResourceXmlManager.m2929d();
        String a = vastResourceXmlManager.m2926a();
        String b = vastResourceXmlManager.m2927b();
        if (com_ushareit_listenit_ejq != ejq.STATIC_RESOURCE || a == null || b == null || !(f11136a.contains(b) || f11137b.contains(b))) {
            if (com_ushareit_listenit_ejq == ejq.HTML_RESOURCE && d != null) {
                com_ushareit_listenit_ejp = ejp.NONE;
                a = d;
            } else if (com_ushareit_listenit_ejq != ejq.IFRAME_RESOURCE || c == null) {
                return null;
            } else {
                com_ushareit_listenit_ejp = ejp.NONE;
                a = c;
            }
        } else if (f11136a.contains(b)) {
            com_ushareit_listenit_ejp = ejp.IMAGE;
        } else {
            com_ushareit_listenit_ejp = ejp.JAVASCRIPT;
        }
        return new ejn(a, com_ushareit_listenit_ejq, com_ushareit_listenit_ejp, i, i2);
    }

    ejn(String str, ejq com_ushareit_listenit_ejq, ejp com_ushareit_listenit_ejp, int i, int i2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(com_ushareit_listenit_ejq);
        Preconditions.checkNotNull(com_ushareit_listenit_ejp);
        this.f11138c = str;
        this.f11139d = com_ushareit_listenit_ejq;
        this.f11140e = com_ushareit_listenit_ejp;
        this.f11141f = i;
        this.f11142g = i2;
    }

    public String getResource() {
        return this.f11138c;
    }

    public ejq getType() {
        return this.f11139d;
    }

    public ejp getCreativeType() {
        return this.f11140e;
    }

    public void initializeWebView(VastWebView vastWebView) {
        Preconditions.checkNotNull(vastWebView);
        if (this.f11139d == ejq.IFRAME_RESOURCE) {
            vastWebView.m3013a("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.f11141f + "\" height=\"" + this.f11142g + "\" src=\"" + this.f11138c + "\"></iframe>");
        } else if (this.f11139d == ejq.HTML_RESOURCE) {
            vastWebView.m3013a(this.f11138c);
        } else if (this.f11139d != ejq.STATIC_RESOURCE) {
        } else {
            if (this.f11140e == ejp.IMAGE) {
                vastWebView.m3013a("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.f11138c + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" />" + "</body>" + "</html>");
            } else if (this.f11140e == ejp.JAVASCRIPT) {
                vastWebView.m3013a("<script src=\"" + this.f11138c + "\"></script>");
            }
        }
    }

    public String getCorrectClickThroughUrl(String str, String str2) {
        switch (ejo.f11143a[this.f11139d.ordinal()]) {
            case 1:
                if (ejp.IMAGE == this.f11140e) {
                    return str;
                }
                if (ejp.JAVASCRIPT != this.f11140e) {
                    return null;
                }
                return str2;
            case 2:
            case 3:
                return str2;
            default:
                return null;
        }
    }
}
