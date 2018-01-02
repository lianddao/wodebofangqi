package com.ushareit.listenit;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.mopub.mobileads.VastIconXmlManager;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class ejm {
    private final Node f11135a;

    ejm(Node node) {
        Preconditions.checkNotNull(node, "mediaNode cannot be null");
        this.f11135a = node;
    }

    public Integer m17128a() {
        return XmlUtils.getAttributeValueAsInt(this.f11135a, VastIconXmlManager.WIDTH);
    }

    public Integer m17129b() {
        return XmlUtils.getAttributeValueAsInt(this.f11135a, VastIconXmlManager.HEIGHT);
    }

    public String m17130c() {
        return XmlUtils.getAttributeValue(this.f11135a, VastExtensionXmlManager.TYPE);
    }

    public String m17131d() {
        return XmlUtils.getNodeValue(this.f11135a);
    }
}
