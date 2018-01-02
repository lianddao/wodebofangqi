package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.internal.cb;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import org.json.JSONObject;

public class bcq {
    public static Bundle m7757a(ShareLinkContent shareLinkContent) {
        Bundle bundle = new Bundle();
        cb.m1578a(bundle, "href", shareLinkContent.m1955h());
        return bundle;
    }

    public static Bundle m7758a(ShareOpenGraphContent shareOpenGraphContent) {
        Bundle bundle = new Bundle();
        cb.m1579a(bundle, "action_type", shareOpenGraphContent.m1975a().m1974a());
        try {
            JSONObject a = bcj.m7737a(bcj.m7735a(shareOpenGraphContent), false);
            if (a != null) {
                cb.m1579a(bundle, "action_properties", a.toString());
            }
            return bundle;
        } catch (Throwable e) {
            throw new aif("Unable to serialize the ShareOpenGraphContent to JSON", e);
        }
    }

    public static Bundle m7759b(ShareLinkContent shareLinkContent) {
        Bundle bundle = new Bundle();
        cb.m1579a(bundle, "name", shareLinkContent.m1967b());
        cb.m1579a(bundle, "description", shareLinkContent.m1966a());
        cb.m1579a(bundle, "link", cb.m1561a(shareLinkContent.m1955h()));
        cb.m1579a(bundle, "picture", cb.m1561a(shareLinkContent.m1968c()));
        return bundle;
    }

    public static Bundle m7756a(ShareFeedContent shareFeedContent) {
        Bundle bundle = new Bundle();
        cb.m1579a(bundle, "to", shareFeedContent.m1959a());
        cb.m1579a(bundle, "link", shareFeedContent.m1960b());
        cb.m1579a(bundle, "picture", shareFeedContent.m1964f());
        cb.m1579a(bundle, "source", shareFeedContent.m1965g());
        cb.m1579a(bundle, "name", shareFeedContent.m1961c());
        cb.m1579a(bundle, "caption", shareFeedContent.m1962d());
        cb.m1579a(bundle, "description", shareFeedContent.m1963e());
        return bundle;
    }
}
