package com.ushareit.listenit;

import com.mopub.mobileads.util.XmlUtils;
import com.mopub.mobileads.util.XmlUtils.NodeProcessor;
import org.w3c.dom.Node;

public final class ekn implements NodeProcessor<String> {
    public String process(Node node) {
        return XmlUtils.getNodeValue(node);
    }
}
