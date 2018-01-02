package com.ushareit.listenit;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class ekg extends ejd {
    ekg(Node node) {
        super(node);
        Preconditions.checkNotNull(node);
    }

    public String m17133f() {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, "VASTAdTagURI"));
    }
}
