package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.VastExtensionParentXmlManager;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public abstract class ejd {
    protected final Node f11113a;

    ejd(Node node) {
        Preconditions.checkNotNull(node);
        this.f11113a = node;
    }

    public List<VastTracker> m17092a() {
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f11113a, "Impression");
        List<VastTracker> arrayList = new ArrayList();
        for (Node nodeValue : matchingChildNodes) {
            Object nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (!TextUtils.isEmpty(nodeValue2)) {
                arrayList.add(new VastTracker(nodeValue2));
            }
        }
        return arrayList;
    }

    public List<VastTracker> m17093b() {
        List<VastTracker> arrayList = new ArrayList();
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(this.f11113a, "Error");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node nodeValue : matchingChildNodes) {
            Object nodeValue2 = XmlUtils.getNodeValue(nodeValue);
            if (!TextUtils.isEmpty(nodeValue2)) {
                arrayList.add(new VastTracker(nodeValue2, true));
            }
        }
        return arrayList;
    }

    public List<ejj> m17094c() {
        List<ejj> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11113a, "Creatives");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Creative");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : matchingChildNodes) {
            firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode2, "Linear");
            if (firstMatchingChildNode2 != null) {
                arrayList.add(new ejj(firstMatchingChildNode2));
            }
        }
        return arrayList;
    }

    public List<ejf> m17095d() {
        List<ejf> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11113a, "Creatives");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        List<Node> matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Creative");
        if (matchingChildNodes == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : matchingChildNodes) {
            firstMatchingChildNode2 = XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode2, "CompanionAds");
            if (firstMatchingChildNode2 != null) {
                matchingChildNodes = XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "Companion");
                if (matchingChildNodes != null) {
                    for (Node firstMatchingChildNode22 : matchingChildNodes) {
                        arrayList.add(new ejf(firstMatchingChildNode22));
                    }
                }
            }
        }
        return arrayList;
    }

    public VastExtensionParentXmlManager m17096e() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11113a, "Extensions");
        if (firstMatchingChildNode == null) {
            return null;
        }
        return new VastExtensionParentXmlManager(firstMatchingChildNode);
    }
}
