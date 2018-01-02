package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.util.DeviceUtils.ForceOrientation;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.util.XmlUtils;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ekh {
    private Document f11178a;

    public void m17135a(String str) {
        Preconditions.checkNotNull(str, "xmlString cannot be null");
        String str2 = "<MPMoVideoXMLDocRoot>" + str.replaceFirst("<\\?.*\\?>", "") + "</MPMoVideoXMLDocRoot>";
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setCoalescing(true);
        this.f11178a = newInstance.newDocumentBuilder().parse(new InputSource(new StringReader(str2)));
    }

    public List<ejc> m17134a() {
        List<ejc> arrayList = new ArrayList();
        if (this.f11178a == null) {
            return arrayList;
        }
        NodeList elementsByTagName = this.f11178a.getElementsByTagName("Ad");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            arrayList.add(new ejc(elementsByTagName.item(i)));
        }
        return arrayList;
    }

    public VastTracker m17136b() {
        if (this.f11178a == null) {
            return null;
        }
        Object firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.f11178a, "Error");
        if (TextUtils.isEmpty(firstMatchingStringData)) {
            return null;
        }
        return new VastTracker(firstMatchingStringData);
    }

    public List<VastTracker> m17137c() {
        List<String> stringDataAsList = XmlUtils.getStringDataAsList(this.f11178a, "MP_TRACKING_URL");
        List<VastTracker> arrayList = new ArrayList(stringDataAsList.size());
        for (String vastTracker : stringDataAsList) {
            arrayList.add(new VastTracker(vastTracker));
        }
        return arrayList;
    }

    public String m17138d() {
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.f11178a, "MoPubCtaText");
        return (firstMatchingStringData == null || firstMatchingStringData.length() > 15) ? null : firstMatchingStringData;
    }

    public String m17139e() {
        String firstMatchingStringData = XmlUtils.getFirstMatchingStringData(this.f11178a, "MoPubSkipText");
        return (firstMatchingStringData == null || firstMatchingStringData.length() > 8) ? null : firstMatchingStringData;
    }

    public String m17140f() {
        return XmlUtils.getFirstMatchingStringData(this.f11178a, "MoPubCloseIcon");
    }

    public ForceOrientation m17141g() {
        return ForceOrientation.getForceOrientation(XmlUtils.getFirstMatchingStringData(this.f11178a, "MoPubForceOrientation"));
    }
}
