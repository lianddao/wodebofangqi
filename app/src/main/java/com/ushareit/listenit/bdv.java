package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.C0075a;
import com.facebook.internal.C0093a;
import com.facebook.internal.C0113u;
import com.facebook.internal.C0114v;
import com.facebook.internal.C0115w;
import com.facebook.internal.C0117y;
import com.facebook.internal.y$com.facebook.internal.z;
import com.facebook.share.C0145a;
import com.facebook.share.C0146b;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;

public final class bdv extends C0117y<ShareContent, C0146b> implements C0145a {
    private static final int f5962b = C0113u.Share.m1717a();
    private boolean f5963c = false;
    private boolean f5964d = true;

    public static boolean m7853a(Class<? extends ShareContent> cls) {
        return m7860f(cls) || m7859e(cls);
    }

    private static boolean m7859e(Class<? extends ShareContent> cls) {
        C0114v g = m7861g(cls);
        return g != null && C0115w.m1727a(g);
    }

    private static boolean m7860f(Class<? extends ShareContent> cls) {
        return ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls);
    }

    public bdv(Activity activity) {
        super(activity, f5962b);
        bcj.m7738a(f5962b);
    }

    bdv(Activity activity, int i) {
        super(activity, i);
        bcj.m7738a(i);
    }

    bdv(ah ahVar, int i) {
        super(ahVar, i);
        bcj.m7738a(i);
    }

    public boolean mo851e() {
        return this.f5963c;
    }

    protected C0093a mo831d() {
        return new C0093a(m1737a());
    }

    protected List<z> mo830c() {
        List arrayList = new ArrayList();
        arrayList.add(new bdz());
        arrayList.add(new bdx());
        arrayList.add(new beb());
        return arrayList;
    }

    private static C0114v m7861g(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return bch.SHARE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(cls)) {
            return bch.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(cls)) {
            return bch.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            return bby.OG_ACTION_DIALOG;
        }
        return null;
    }

    private void m7851a(Context context, ShareContent shareContent, bdy com_ushareit_listenit_bdy) {
        String str;
        String str2;
        if (this.f5964d) {
            com_ushareit_listenit_bdy = bdy.AUTOMATIC;
        }
        switch (bdw.f5965a[com_ushareit_listenit_bdy.ordinal()]) {
            case 1:
                str = "automatic";
                break;
            case 2:
                str = "web";
                break;
            case 3:
                str = "native";
                break;
            default:
                str = "unknown";
                break;
        }
        C0114v g = m7861g(shareContent.getClass());
        if (g == bch.SHARE_DIALOG) {
            str2 = "status";
        } else if (g == bch.PHOTOS) {
            str2 = "photo";
        } else if (g == bch.VIDEO) {
            str2 = "video";
        } else if (g == bby.OG_ACTION_DIALOG) {
            str2 = "open_graph";
        } else {
            str2 = "unknown";
        }
        C0075a a = C0075a.m1174a(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str);
        bundle.putString("fb_share_dialog_content_type", str2);
        a.m1207a("fb_share_dialog_show", null, bundle);
    }
}
