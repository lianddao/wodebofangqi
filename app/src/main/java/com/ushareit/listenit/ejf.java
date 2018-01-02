package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastIconXmlManager;
import com.mopub.mobileads.VastResourceXmlManager;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;

public class ejf {
    private final Node f11118a;
    private final VastResourceXmlManager f11119b;

    ejf(Node node) {
        Preconditions.checkNotNull(node, "companionNode cannot be null");
        this.f11118a = node;
        this.f11119b = new VastResourceXmlManager(node);
    }

    public Integer m17097a() {
        return XmlUtils.getAttributeValueAsInt(this.f11118a, VastIconXmlManager.WIDTH);
    }

    public Integer m17098b() {
        return XmlUtils.getAttributeValueAsInt(this.f11118a, VastIconXmlManager.HEIGHT);
    }

    public String m17099c() {
        return XmlUtils.getAttributeValue(this.f11118a, "adSlotID");
    }

    public VastResourceXmlManager m17100d() {
        return this.f11119b;
    }

    public String m17101e() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.f11118a, "CompanionClickThrough"));
    }

    public List<VastTracker> m17102f() {
        List<VastTracker> arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f11118a, "CompanionClickTracking");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node nodeValue : matchingChildNodes) {
            Object nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (!TextUtils.isEmpty(nodeValue2)) {
                arrayList.add(new VastTracker(nodeValue2));
            }
        }
        return arrayList;
    }

    public List<VastTracker> m17103g() {
        List<VastTracker> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11118a, "TrackingEvents");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "Tracking", "event", Collections.singletonList("creativeView"))) {
            arrayList.add(new VastTracker(XmlUtils.getNodeValue(firstMatchingChildNode2)));
        }
        return arrayList;
    }

    public boolean m17104h() {
        return (TextUtils.isEmpty(this.f11119b.m2926a()) && TextUtils.isEmpty(this.f11119b.m2929d()) && TextUtils.isEmpty(this.f11119b.m2928c())) ? false : true;
    }
}
