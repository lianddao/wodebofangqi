package com.ushareit.listenit;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.internal.C0093a;
import com.facebook.internal.C0113u;
import com.facebook.internal.C0114v;
import com.facebook.internal.C0115w;
import com.facebook.internal.C0117y;
import com.facebook.internal.y$com.facebook.internal.z;
import com.facebook.share.internal.LikeContent;
import java.util.ArrayList;
import java.util.List;

public class bbp extends C0117y<LikeContent, Object> {
    private static final int f5868b = C0113u.Like.m1717a();

    public static boolean m7612e() {
        return VERSION.SDK_INT >= 14 && C0115w.m1727a(m7615h());
    }

    public static boolean m7613f() {
        return VERSION.SDK_INT >= 14 && C0115w.m1730b(m7615h());
    }

    bbp(Activity activity) {
        super(activity, f5868b);
    }

    bbp(ah ahVar) {
        super(ahVar, f5868b);
    }

    protected C0093a mo831d() {
        return new C0093a(m1737a());
    }

    protected List<z> mo830c() {
        List arrayList = new ArrayList();
        arrayList.add(new bbr());
        arrayList.add(new bbt());
        return arrayList;
    }

    private static C0114v m7615h() {
        return bbu.LIKE_DIALOG;
    }

    private static Bundle m7611b(LikeContent likeContent) {
        Bundle bundle = new Bundle();
        bundle.putString("object_id", likeContent.m1952a());
        bundle.putString("object_type", likeContent.m1953b());
        return bundle;
    }
}
