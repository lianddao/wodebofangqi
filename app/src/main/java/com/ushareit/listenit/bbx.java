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

public class bbx {
    public static Bundle m7638a(UUID uuid, ShareContent shareContent, boolean z) {
        cj.m1640a((Object) shareContent, "shareContent");
        cj.m1640a((Object) uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return m7634a((ShareLinkContent) shareContent, z);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return m7636a(sharePhotoContent, bcj.m7733a(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return m7637a(shareVideoContent, bcj.m7732a(shareVideoContent, uuid), z);
        } else if (!(shareContent instanceof ShareOpenGraphContent)) {
            return null;
        } else {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return m7635a(shareOpenGraphContent, bcj.m7737a(bcj.m7736a(uuid, shareOpenGraphContent), false), z);
            } catch (JSONException e) {
                throw new aif("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
            }
        }
    }

    private static Bundle m7634a(ShareLinkContent shareLinkContent, boolean z) {
        Bundle a = m7633a((ShareContent) shareLinkContent, z);
        cb.m1579a(a, "TITLE", shareLinkContent.m1967b());
        cb.m1579a(a, "DESCRIPTION", shareLinkContent.m1966a());
        cb.m1578a(a, "IMAGE", shareLinkContent.m1968c());
        return a;
    }

    private static Bundle m7636a(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle a = m7633a((ShareContent) sharePhotoContent, z);
        a.putStringArrayList("PHOTOS", new ArrayList(list));
        return a;
    }

    private static Bundle m7637a(ShareVideoContent shareVideoContent, String str, boolean z) {
        Bundle a = m7633a((ShareContent) shareVideoContent, z);
        cb.m1579a(a, "TITLE", shareVideoContent.m1984b());
        cb.m1579a(a, "DESCRIPTION", shareVideoContent.m1983a());
        cb.m1579a(a, "VIDEO", str);
        return a;
    }

    private static Bundle m7635a(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        Bundle a = m7633a((ShareContent) shareOpenGraphContent, z);
        cb.m1579a(a, "PREVIEW_PROPERTY_NAME", (String) bcj.m7726a(shareOpenGraphContent.m1976b()).second);
        cb.m1579a(a, "ACTION_TYPE", shareOpenGraphContent.m1975a().m1974a());
        cb.m1579a(a, "ACTION", jSONObject.toString());
        return a;
    }

    private static Bundle m7633a(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        cb.m1578a(bundle, "LINK", shareContent.m1955h());
        cb.m1579a(bundle, "PLACE", shareContent.m1957j());
        cb.m1579a(bundle, "REF", shareContent.m1958k());
        bundle.putBoolean("DATA_FAILURES_FATAL", z);
        Collection i = shareContent.m1956i();
        if (!cb.m1592a(i)) {
            bundle.putStringArrayList("FRIENDS", new ArrayList(i));
        }
        return bundle;
    }
}
