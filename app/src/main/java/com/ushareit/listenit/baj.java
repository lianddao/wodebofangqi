package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.internal.cb;
import com.facebook.internal.cj;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class baj {
    public static Bundle m7493a(UUID uuid, ShareContent shareContent, boolean z) {
        cj.m1640a((Object) shareContent, "shareContent");
        cj.m1640a((Object) uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return m7489a((ShareLinkContent) shareContent, z);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return m7491a(sharePhotoContent, bcj.m7733a(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            return m7492a((ShareVideoContent) shareContent, z);
        } else {
            if (!(shareContent instanceof ShareOpenGraphContent)) {
                return null;
            }
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return m7490a(shareOpenGraphContent, bcj.m7736a(uuid, shareOpenGraphContent), z);
            } catch (JSONException e) {
                throw new aif("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
            }
        }
    }

    private static Bundle m7489a(ShareLinkContent shareLinkContent, boolean z) {
        Bundle a = m7488a((ShareContent) shareLinkContent, z);
        cb.m1579a(a, "com.facebook.platform.extra.TITLE", shareLinkContent.m1967b());
        cb.m1579a(a, "com.facebook.platform.extra.DESCRIPTION", shareLinkContent.m1966a());
        cb.m1578a(a, "com.facebook.platform.extra.IMAGE", shareLinkContent.m1968c());
        return a;
    }

    private static Bundle m7491a(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle a = m7488a((ShareContent) sharePhotoContent, z);
        a.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(list));
        return a;
    }

    private static Bundle m7492a(ShareVideoContent shareVideoContent, boolean z) {
        return null;
    }

    private static Bundle m7490a(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        Bundle a = m7488a((ShareContent) shareOpenGraphContent, z);
        cb.m1579a(a, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", shareOpenGraphContent.m1976b());
        cb.m1579a(a, "com.facebook.platform.extra.ACTION_TYPE", shareOpenGraphContent.m1975a().m1974a());
        cb.m1579a(a, "com.facebook.platform.extra.ACTION", jSONObject.toString());
        return a;
    }

    private static Bundle m7488a(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        cb.m1578a(bundle, "com.facebook.platform.extra.LINK", shareContent.m1955h());
        cb.m1579a(bundle, "com.facebook.platform.extra.PLACE", shareContent.m1957j());
        cb.m1579a(bundle, "com.facebook.platform.extra.REF", shareContent.m1958k());
        bundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", z);
        Collection i = shareContent.m1956i();
        if (!cb.m1592a(i)) {
            bundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(i));
        }
        return bundle;
    }
}
