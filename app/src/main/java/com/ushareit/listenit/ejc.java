package com.ushareit.listenit;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class ejc {
    private final Node f11112a;

    ejc(Node node) {
        Preconditions.checkNotNull(node);
        this.f11112a = node;
    }

    public eji m17089a() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11112a, "InLine");
        if (firstMatchingChildNode != null) {
            return new eji(firstMatchingChildNode);
        }
        return null;
    }

    public ekg m17090b() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11112a, "Wrapper");
        if (firstMatchingChildNode != null) {
            return new ekg(firstMatchingChildNode);
        }
        return null;
    }

    public String m17091c() {
        return XmlUtils.getAttributeValue(this.f11112a, "sequence");
    }
}
