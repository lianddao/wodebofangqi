package com.ushareit.listenit;

import org.xmlpull.v1.XmlPullParser;

public final class bte {
    public static boolean m9781a(XmlPullParser xmlPullParser, String str) {
        return m9780a(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean m9780a(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    public static boolean m9783b(XmlPullParser xmlPullParser, String str) {
        return m9782b(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean m9782b(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    public static String m9784c(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (str.equals(xmlPullParser.getAttributeName(i))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
