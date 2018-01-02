package com.ushareit.listenit;

import android.app.Activity;
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

public final class bdp extends C0117y<ShareContent, C0146b> implements C0145a {
    private static final int f5953b = C0113u.Message.m1717a();
    private boolean f5954c = false;

    public static boolean m7838a(Class<? extends ShareContent> cls) {
        C0114v c = m7840c(cls);
        return c != null && C0115w.m1727a(c);
    }

    bdp(Activity activity, int i) {
        super(activity, i);
        bcj.m7738a(i);
    }

    bdp(ah ahVar, int i) {
        super(ahVar, i);
        bcj.m7738a(i);
    }

    public boolean mo851e() {
        return this.f5954c;
    }

    protected C0093a mo831d() {
        return new C0093a(m1737a());
    }

    protected List<z> mo830c() {
        List arrayList = new ArrayList();
        arrayList.add(new bdr());
        return arrayList;
    }

    private static C0114v m7840c(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return bbw.MESSAGE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(cls)) {
            return bbw.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(cls)) {
            return bbw.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            return bcb.OG_MESSAGE_DIALOG;
        }
        return null;
    }
}
