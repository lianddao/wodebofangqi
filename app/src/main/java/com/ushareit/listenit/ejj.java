package com.ushareit.listenit;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.VastAbsoluteProgressTracker;
import com.mopub.mobileads.VastFractionalProgressTracker;
import com.mopub.mobileads.VastIconXmlManager;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;

public class ejj {
    public static final String ICON = "Icon";
    public static final String ICONS = "Icons";
    private final Node f11131a;

    ejj(Node node) {
        Preconditions.checkNotNull(node);
        this.f11131a = node;
    }

    public List<VastFractionalProgressTracker> m17116a() {
        List<VastFractionalProgressTracker> arrayList = new ArrayList();
        m17114a(arrayList, m17115b("firstQuartile"), 0.25f);
        m17114a(arrayList, m17115b("midpoint"), 0.5f);
        m17114a(arrayList, m17115b("thirdQuartile"), 0.75f);
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11131a, "TrackingEvents");
        if (firstMatchingChildNode != null) {
            for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "Tracking", "event", Collections.singletonList("progress"))) {
                String attributeValue = XmlUtils.getAttributeValue(firstMatchingChildNode2, VastIconXmlManager.OFFSET);
                if (attributeValue != null) {
                    attributeValue = attributeValue.trim();
                    if (Strings.isPercentageTracker(attributeValue)) {
                        try {
                            arrayList.add(new VastFractionalProgressTracker(XmlUtils.getNodeValue(firstMatchingChildNode2), Float.parseFloat(attributeValue.replace("%", "")) / 100.0f));
                        } catch (NumberFormatException e) {
                            MoPubLog.m2753d(String.format("Failed to parse VAST progress tracker %s", new Object[]{attributeValue}));
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public List<VastAbsoluteProgressTracker> m17117b() {
        List<VastAbsoluteProgressTracker> arrayList = new ArrayList();
        for (String vastAbsoluteProgressTracker : m17115b("start")) {
            String vastAbsoluteProgressTracker2;
            arrayList.add(new VastAbsoluteProgressTracker(vastAbsoluteProgressTracker2, 2000));
        }
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11131a, "TrackingEvents");
        if (firstMatchingChildNode != null) {
            for (Node node : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("progress"))) {
                String attributeValue = XmlUtils.getAttributeValue(node, VastIconXmlManager.OFFSET);
                if (attributeValue != null) {
                    attributeValue = attributeValue.trim();
                    if (Strings.isAbsoluteTracker(attributeValue)) {
                        vastAbsoluteProgressTracker2 = XmlUtils.getNodeValue(node);
                        try {
                            Integer parseAbsoluteOffset = Strings.parseAbsoluteOffset(attributeValue);
                            if (parseAbsoluteOffset != null) {
                                arrayList.add(new VastAbsoluteProgressTracker(vastAbsoluteProgressTracker2, parseAbsoluteOffset.intValue()));
                            }
                        } catch (NumberFormatException e) {
                            MoPubLog.m2753d(String.format("Failed to parse VAST progress tracker %s", new Object[]{attributeValue}));
                        }
                    }
                }
            }
            for (Node node2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode, "Tracking", "event", Collections.singletonList("creativeView"))) {
                arrayList.add(new VastAbsoluteProgressTracker(XmlUtils.getNodeValue(node2), 0));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public List<VastTracker> m17118c() {
        return m17113a("complete");
    }

    public List<VastTracker> m17119d() {
        List<String> b = m17115b("pause");
        List<VastTracker> arrayList = new ArrayList();
        for (String vastTracker : b) {
            arrayList.add(new VastTracker(vastTracker, true));
        }
        return arrayList;
    }

    public List<VastTracker> m17120e() {
        List<String> b = m17115b("resume");
        List<VastTracker> arrayList = new ArrayList();
        for (String vastTracker : b) {
            arrayList.add(new VastTracker(vastTracker, true));
        }
        return arrayList;
    }

    public List<VastTracker> m17121f() {
        List<VastTracker> a = m17113a("close");
        a.addAll(m17113a("closeLinear"));
        return a;
    }

    public List<VastTracker> m17122g() {
        return m17113a("skip");
    }

    public String m17123h() {
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11131a, "VideoClicks");
        if (firstMatchingChildNode == null) {
            return null;
        }
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(firstMatchingChildNode, "ClickThrough"));
    }

    public List<VastTracker> m17124i() {
        List<VastTracker> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11131a, "VideoClicks");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "ClickTracking")) {
            String nodeValue = XmlUtils.getNodeValue(firstMatchingChildNode2);
            if (nodeValue != null) {
                arrayList.add(new VastTracker(nodeValue));
            }
        }
        return arrayList;
    }

    public String m17125j() {
        String attributeValue = XmlUtils.getAttributeValue(this.f11131a, "skipoffset");
        if (attributeValue == null || attributeValue.trim().isEmpty()) {
            return null;
        }
        return attributeValue.trim();
    }

    public List<ejm> m17126k() {
        List<ejm> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11131a, "MediaFiles");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "MediaFile")) {
            arrayList.add(new ejm(firstMatchingChildNode2));
        }
        return arrayList;
    }

    public List<VastIconXmlManager> m17127l() {
        List<VastIconXmlManager> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11131a, ICONS);
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, ICON)) {
            arrayList.add(new VastIconXmlManager(firstMatchingChildNode2));
        }
        return arrayList;
    }

    private List<VastTracker> m17113a(String str) {
        List<String> b = m17115b(str);
        List<VastTracker> arrayList = new ArrayList(b.size());
        for (String vastTracker : b) {
            arrayList.add(new VastTracker(vastTracker));
        }
        return arrayList;
    }

    private List<String> m17115b(String str) {
        Preconditions.checkNotNull(str);
        List<String> arrayList = new ArrayList();
        Node firstMatchingChildNode = XmlUtils.getFirstMatchingChildNode(this.f11131a, "TrackingEvents");
        if (firstMatchingChildNode == null) {
            return arrayList;
        }
        for (Node firstMatchingChildNode2 : XmlUtils.getMatchingChildNodes(firstMatchingChildNode2, "Tracking", "event", Collections.singletonList(str))) {
            String nodeValue = XmlUtils.getNodeValue(firstMatchingChildNode2);
            if (nodeValue != null) {
                arrayList.add(nodeValue);
            }
        }
        return arrayList;
    }

    private void m17114a(List<VastFractionalProgressTracker> list, List<String> list2, float f) {
        Preconditions.checkNotNull(list, "trackers cannot be null");
        Preconditions.checkNotNull(list2, "urls cannot be null");
        for (String vastFractionalProgressTracker : list2) {
            list.add(new VastFractionalProgressTracker(vastFractionalProgressTracker, f));
        }
    }
}
