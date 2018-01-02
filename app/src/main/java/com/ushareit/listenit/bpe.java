package com.ushareit.listenit;

import android.util.Log;
import android.util.Pair;
import com.mopub.volley.DefaultRetryPolicy;
import com.umeng.analytics.C0154a;
import com.umeng.analytics.pro.C0321x;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class bpe extends bon {
    private static final Pattern f7283a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern f7284b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern f7285c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern f7286d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final bpf f7287e = new bpf(30.0f, 1, 1);
    private final XmlPullParserFactory f7288f;

    protected /* synthetic */ bop mo1077a(byte[] bArr, int i) {
        return m9345b(bArr, i);
    }

    public bpe() {
        super("TtmlDecoder");
        try {
            this.f7288f = XmlPullParserFactory.newInstance();
            this.f7288f.setNamespaceAware(true);
        } catch (Throwable e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    protected bpk m9345b(byte[] bArr, int i) {
        bpk com_ushareit_listenit_bpk = null;
        int i2 = 0;
        try {
            XmlPullParser newPullParser = this.f7288f.newPullParser();
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            hashMap2.put("", new bph());
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            LinkedList linkedList = new LinkedList();
            int eventType = newPullParser.getEventType();
            bpf com_ushareit_listenit_bpf = f7287e;
            for (int i3 = eventType; i3 != 1; i3 = newPullParser.getEventType()) {
                bpg com_ushareit_listenit_bpg = (bpg) linkedList.peekLast();
                if (i2 == 0) {
                    bpk com_ushareit_listenit_bpk2;
                    bpf com_ushareit_listenit_bpf2;
                    int i4;
                    String name = newPullParser.getName();
                    if (i3 == 2) {
                        if ("tt".equals(name)) {
                            com_ushareit_listenit_bpf = m9335a(newPullParser);
                        }
                        int i5;
                        if (!m9343b(name)) {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            eventType = i2 + 1;
                            com_ushareit_listenit_bpk2 = com_ushareit_listenit_bpk;
                            i5 = eventType;
                            com_ushareit_listenit_bpf2 = com_ushareit_listenit_bpf;
                            i4 = i5;
                        } else if ("head".equals(name)) {
                            m9339a(newPullParser, hashMap, hashMap2);
                            com_ushareit_listenit_bpf2 = com_ushareit_listenit_bpf;
                            i4 = i2;
                            com_ushareit_listenit_bpk2 = com_ushareit_listenit_bpk;
                        } else {
                            try {
                                bpg a = m9336a(newPullParser, com_ushareit_listenit_bpg, hashMap2, com_ushareit_listenit_bpf);
                                linkedList.addLast(a);
                                if (com_ushareit_listenit_bpg != null) {
                                    com_ushareit_listenit_bpg.m9357a(a);
                                }
                                com_ushareit_listenit_bpf2 = com_ushareit_listenit_bpf;
                                i4 = i2;
                                com_ushareit_listenit_bpk2 = com_ushareit_listenit_bpk;
                            } catch (Throwable e) {
                                Log.w("TtmlDecoder", "Suppressing parser error", e);
                                eventType = i2 + 1;
                                com_ushareit_listenit_bpk2 = com_ushareit_listenit_bpk;
                                i5 = eventType;
                                com_ushareit_listenit_bpf2 = com_ushareit_listenit_bpf;
                                i4 = i5;
                            }
                        }
                    } else if (i3 == 4) {
                        com_ushareit_listenit_bpg.m9357a(bpg.m9348a(newPullParser.getText()));
                        com_ushareit_listenit_bpf2 = com_ushareit_listenit_bpf;
                        i4 = i2;
                        com_ushareit_listenit_bpk2 = com_ushareit_listenit_bpk;
                    } else if (i3 == 3) {
                        bpk com_ushareit_listenit_bpk3;
                        if (newPullParser.getName().equals("tt")) {
                            com_ushareit_listenit_bpk3 = new bpk((bpg) linkedList.getLast(), hashMap, hashMap2);
                        } else {
                            com_ushareit_listenit_bpk3 = com_ushareit_listenit_bpk;
                        }
                        linkedList.removeLast();
                        bpf com_ushareit_listenit_bpf3 = com_ushareit_listenit_bpf;
                        i4 = i2;
                        com_ushareit_listenit_bpk2 = com_ushareit_listenit_bpk3;
                        com_ushareit_listenit_bpf2 = com_ushareit_listenit_bpf3;
                    } else {
                        com_ushareit_listenit_bpf2 = com_ushareit_listenit_bpf;
                        i4 = i2;
                        com_ushareit_listenit_bpk2 = com_ushareit_listenit_bpk;
                    }
                    com_ushareit_listenit_bpk = com_ushareit_listenit_bpk2;
                    i2 = i4;
                    com_ushareit_listenit_bpf = com_ushareit_listenit_bpf2;
                } else if (i3 == 2) {
                    i2++;
                } else if (i3 == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            return com_ushareit_listenit_bpk;
        } catch (Throwable e2) {
            throw new bor("Unable to decode source", e2);
        } catch (Throwable e22) {
            throw new IllegalStateException("Unexpected error when reading input.", e22);
        }
    }

    private bpf m9335a(XmlPullParser xmlPullParser) {
        int i = 30;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        }
        float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split(" ");
            if (split.length != 2) {
                throw new bor("frameRateMultiplier doesn't have 2 parts");
            }
            f = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
        }
        int i2 = f7287e.f7290b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = f7287e.f7291c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new bpf(((float) i) * f, i2, i3);
    }

    private Map<String, bpj> m9339a(XmlPullParser xmlPullParser, Map<String, bpj> map, Map<String, bph> map2) {
        do {
            xmlPullParser.next();
            if (bte.m9783b(xmlPullParser, C0321x.f3829P)) {
                String c = bte.m9784c(xmlPullParser, C0321x.f3829P);
                bpj a = m9338a(xmlPullParser, new bpj());
                if (c != null) {
                    for (Object obj : m9341a(c)) {
                        a.m9369a((bpj) map.get(obj));
                    }
                }
                if (a.m9385i() != null) {
                    map.put(a.m9385i(), a);
                }
            } else if (bte.m9783b(xmlPullParser, "region")) {
                Pair b = m9342b(xmlPullParser);
                if (b != null) {
                    map2.put(b.first, b.second);
                }
            }
        } while (!bte.m9781a(xmlPullParser, "head"));
        return map;
    }

    private Pair<String, bph> m9342b(XmlPullParser xmlPullParser) {
        String c = bte.m9784c(xmlPullParser, "id");
        Object c2 = bte.m9784c(xmlPullParser, "origin");
        Object c3 = bte.m9784c(xmlPullParser, "extent");
        if (c2 == null || c == null) {
            return null;
        }
        float parseFloat;
        float parseFloat2;
        float parseFloat3;
        Matcher matcher = f7286d.matcher(c2);
        if (matcher.matches()) {
            try {
                parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
            } catch (Throwable e) {
                Log.w("TtmlDecoder", "Ignoring region with malformed origin: '" + c2 + "'", e);
                parseFloat2 = Float.MIN_VALUE;
                parseFloat = Float.MIN_VALUE;
            }
        } else {
            parseFloat2 = Float.MIN_VALUE;
            parseFloat = Float.MIN_VALUE;
        }
        if (c3 != null) {
            matcher = f7286d.matcher(c3);
            if (matcher.matches()) {
                try {
                    parseFloat3 = Float.parseFloat(matcher.group(1)) / 100.0f;
                } catch (Throwable e2) {
                    Log.w("TtmlDecoder", "Ignoring malformed region extent: '" + c3 + "'", e2);
                }
                if (parseFloat == Float.MIN_VALUE) {
                    return new Pair(c, new bph(parseFloat, parseFloat2, 0, parseFloat3));
                }
                return null;
            }
        }
        parseFloat3 = Float.MIN_VALUE;
        if (parseFloat == Float.MIN_VALUE) {
            return null;
        }
        return new Pair(c, new bph(parseFloat, parseFloat2, 0, parseFloat3));
    }

    private String[] m9341a(String str) {
        return str.split("\\s+");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ushareit.listenit.bpj m9338a(org.xmlpull.v1.XmlPullParser r13, com.ushareit.listenit.bpj r14) {
        /*
        r12 = this;
        r6 = 3;
        r5 = 2;
        r3 = -1;
        r4 = 1;
        r2 = 0;
        r8 = r13.getAttributeCount();
        r7 = r2;
        r0 = r14;
    L_0x000b:
        if (r7 >= r8) goto L_0x0223;
    L_0x000d:
        r9 = r13.getAttributeValue(r7);
        r1 = r13.getAttributeName(r7);
        r10 = r1.hashCode();
        switch(r10) {
            case -1550943582: goto L_0x0060;
            case -1224696685: goto L_0x0042;
            case -1065511464: goto L_0x006a;
            case -879295043: goto L_0x0074;
            case -734428249: goto L_0x0056;
            case 3355: goto L_0x0024;
            case 94842723: goto L_0x0038;
            case 365601008: goto L_0x004c;
            case 1287124693: goto L_0x002e;
            default: goto L_0x001c;
        };
    L_0x001c:
        r1 = r3;
    L_0x001d:
        switch(r1) {
            case 0: goto L_0x007f;
            case 1: goto L_0x0094;
            case 2: goto L_0x00c1;
            case 3: goto L_0x00ef;
            case 4: goto L_0x00f9;
            case 5: goto L_0x0123;
            case 6: goto L_0x0133;
            case 7: goto L_0x0143;
            case 8: goto L_0x01c2;
            default: goto L_0x0020;
        };
    L_0x0020:
        r1 = r7 + 1;
        r7 = r1;
        goto L_0x000b;
    L_0x0024:
        r10 = "id";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x002c:
        r1 = r2;
        goto L_0x001d;
    L_0x002e:
        r10 = "backgroundColor";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0036:
        r1 = r4;
        goto L_0x001d;
    L_0x0038:
        r10 = "color";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0040:
        r1 = r5;
        goto L_0x001d;
    L_0x0042:
        r10 = "fontFamily";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x004a:
        r1 = r6;
        goto L_0x001d;
    L_0x004c:
        r10 = "fontSize";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0054:
        r1 = 4;
        goto L_0x001d;
    L_0x0056:
        r10 = "fontWeight";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x005e:
        r1 = 5;
        goto L_0x001d;
    L_0x0060:
        r10 = "fontStyle";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0068:
        r1 = 6;
        goto L_0x001d;
    L_0x006a:
        r10 = "textAlign";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x0072:
        r1 = 7;
        goto L_0x001d;
    L_0x0074:
        r10 = "textDecoration";
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x001c;
    L_0x007c:
        r1 = 8;
        goto L_0x001d;
    L_0x007f:
        r1 = "style";
        r10 = r13.getName();
        r1 = r1.equals(r10);
        if (r1 == 0) goto L_0x0020;
    L_0x008b:
        r0 = r12.m9337a(r0);
        r0 = r0.m9373b(r9);
        goto L_0x0020;
    L_0x0094:
        r0 = r12.m9337a(r0);
        r1 = com.ushareit.listenit.bsi.m9665a(r9);	 Catch:{ IllegalArgumentException -> 0x00a0 }
        r0.m9372b(r1);	 Catch:{ IllegalArgumentException -> 0x00a0 }
        goto L_0x0020;
    L_0x00a0:
        r1 = move-exception;
        r1 = "TtmlDecoder";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "failed parsing background value: '";
        r10 = r10.append(r11);
        r9 = r10.append(r9);
        r10 = "'";
        r9 = r9.append(r10);
        r9 = r9.toString();
        android.util.Log.w(r1, r9);
        goto L_0x0020;
    L_0x00c1:
        r0 = r12.m9337a(r0);
        r1 = com.ushareit.listenit.bsi.m9665a(r9);	 Catch:{ IllegalArgumentException -> 0x00ce }
        r0.m9367a(r1);	 Catch:{ IllegalArgumentException -> 0x00ce }
        goto L_0x0020;
    L_0x00ce:
        r1 = move-exception;
        r1 = "TtmlDecoder";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "failed parsing color value: '";
        r10 = r10.append(r11);
        r9 = r10.append(r9);
        r10 = "'";
        r9 = r9.append(r10);
        r9 = r9.toString();
        android.util.Log.w(r1, r9);
        goto L_0x0020;
    L_0x00ef:
        r0 = r12.m9337a(r0);
        r0 = r0.m9370a(r9);
        goto L_0x0020;
    L_0x00f9:
        r0 = r12.m9337a(r0);	 Catch:{ bor -> 0x0102 }
        m9340a(r9, r0);	 Catch:{ bor -> 0x0102 }
        goto L_0x0020;
    L_0x0102:
        r1 = move-exception;
        r1 = "TtmlDecoder";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "failed parsing fontSize value: '";
        r10 = r10.append(r11);
        r9 = r10.append(r9);
        r10 = "'";
        r9 = r9.append(r10);
        r9 = r9.toString();
        android.util.Log.w(r1, r9);
        goto L_0x0020;
    L_0x0123:
        r0 = r12.m9337a(r0);
        r1 = "bold";
        r1 = r1.equalsIgnoreCase(r9);
        r0 = r0.m9377c(r1);
        goto L_0x0020;
    L_0x0133:
        r0 = r12.m9337a(r0);
        r1 = "italic";
        r1 = r1.equalsIgnoreCase(r9);
        r0 = r0.m9379d(r1);
        goto L_0x0020;
    L_0x0143:
        r1 = com.ushareit.listenit.btc.m9776d(r9);
        r9 = r1.hashCode();
        switch(r9) {
            case -1364013995: goto L_0x0188;
            case 100571: goto L_0x017e;
            case 3317767: goto L_0x0160;
            case 108511772: goto L_0x0174;
            case 109757538: goto L_0x016a;
            default: goto L_0x014e;
        };
    L_0x014e:
        r1 = r3;
    L_0x014f:
        switch(r1) {
            case 0: goto L_0x0154;
            case 1: goto L_0x0192;
            case 2: goto L_0x019e;
            case 3: goto L_0x01aa;
            case 4: goto L_0x01b6;
            default: goto L_0x0152;
        };
    L_0x0152:
        goto L_0x0020;
    L_0x0154:
        r0 = r12.m9337a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r0 = r0.m9368a(r1);
        goto L_0x0020;
    L_0x0160:
        r9 = "left";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0168:
        r1 = r2;
        goto L_0x014f;
    L_0x016a:
        r9 = "start";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0172:
        r1 = r4;
        goto L_0x014f;
    L_0x0174:
        r9 = "right";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x017c:
        r1 = r5;
        goto L_0x014f;
    L_0x017e:
        r9 = "end";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0186:
        r1 = r6;
        goto L_0x014f;
    L_0x0188:
        r9 = "center";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x014e;
    L_0x0190:
        r1 = 4;
        goto L_0x014f;
    L_0x0192:
        r0 = r12.m9337a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r0 = r0.m9368a(r1);
        goto L_0x0020;
    L_0x019e:
        r0 = r12.m9337a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        r0 = r0.m9368a(r1);
        goto L_0x0020;
    L_0x01aa:
        r0 = r12.m9337a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        r0 = r0.m9368a(r1);
        goto L_0x0020;
    L_0x01b6:
        r0 = r12.m9337a(r0);
        r1 = android.text.Layout.Alignment.ALIGN_CENTER;
        r0 = r0.m9368a(r1);
        goto L_0x0020;
    L_0x01c2:
        r1 = com.ushareit.listenit.btc.m9776d(r9);
        r9 = r1.hashCode();
        switch(r9) {
            case -1461280213: goto L_0x01fb;
            case -1026963764: goto L_0x01f1;
            case 913457136: goto L_0x01e7;
            case 1679736913: goto L_0x01dd;
            default: goto L_0x01cd;
        };
    L_0x01cd:
        r1 = r3;
    L_0x01ce:
        switch(r1) {
            case 0: goto L_0x01d3;
            case 1: goto L_0x0205;
            case 2: goto L_0x020f;
            case 3: goto L_0x0219;
            default: goto L_0x01d1;
        };
    L_0x01d1:
        goto L_0x0020;
    L_0x01d3:
        r0 = r12.m9337a(r0);
        r0 = r0.m9371a(r4);
        goto L_0x0020;
    L_0x01dd:
        r9 = "linethrough";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x01e5:
        r1 = r2;
        goto L_0x01ce;
    L_0x01e7:
        r9 = "nolinethrough";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x01ef:
        r1 = r4;
        goto L_0x01ce;
    L_0x01f1:
        r9 = "underline";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x01f9:
        r1 = r5;
        goto L_0x01ce;
    L_0x01fb:
        r9 = "nounderline";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x01cd;
    L_0x0203:
        r1 = r6;
        goto L_0x01ce;
    L_0x0205:
        r0 = r12.m9337a(r0);
        r0 = r0.m9371a(r2);
        goto L_0x0020;
    L_0x020f:
        r0 = r12.m9337a(r0);
        r0 = r0.m9374b(r4);
        goto L_0x0020;
    L_0x0219:
        r0 = r12.m9337a(r0);
        r0 = r0.m9374b(r2);
        goto L_0x0020;
    L_0x0223:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.bpe.a(org.xmlpull.v1.XmlPullParser, com.ushareit.listenit.bpj):com.ushareit.listenit.bpj");
    }

    private bpj m9337a(bpj com_ushareit_listenit_bpj) {
        return com_ushareit_listenit_bpj == null ? new bpj() : com_ushareit_listenit_bpj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ushareit.listenit.bpg m9336a(org.xmlpull.v1.XmlPullParser r20, com.ushareit.listenit.bpg r21, java.util.Map<java.lang.String, com.ushareit.listenit.bph> r22, com.ushareit.listenit.bpf r23) {
        /*
        r19 = this;
        r12 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r6 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r4 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r10 = "";
        r9 = 0;
        r14 = r20.getAttributeCount();
        r2 = 0;
        r0 = r19;
        r1 = r20;
        r8 = r0.m9338a(r1, r2);
        r2 = 0;
        r11 = r2;
    L_0x0021:
        if (r11 >= r14) goto L_0x00b3;
    L_0x0023:
        r0 = r20;
        r15 = r0.getAttributeName(r11);
        r0 = r20;
        r2 = r0.getAttributeValue(r11);
        r3 = -1;
        r16 = r15.hashCode();
        switch(r16) {
            case -934795532: goto L_0x006b;
            case 99841: goto L_0x0057;
            case 100571: goto L_0x004d;
            case 93616297: goto L_0x0043;
            case 109780401: goto L_0x0061;
            default: goto L_0x0037;
        };
    L_0x0037:
        switch(r3) {
            case 0: goto L_0x0075;
            case 1: goto L_0x0082;
            case 2: goto L_0x008b;
            case 3: goto L_0x0098;
            case 4: goto L_0x00a6;
            default: goto L_0x003a;
        };
    L_0x003a:
        r2 = r4;
        r4 = r6;
        r6 = r12;
    L_0x003d:
        r11 = r11 + 1;
        r12 = r6;
        r6 = r4;
        r4 = r2;
        goto L_0x0021;
    L_0x0043:
        r16 = "begin";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x004b:
        r3 = 0;
        goto L_0x0037;
    L_0x004d:
        r16 = "end";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x0055:
        r3 = 1;
        goto L_0x0037;
    L_0x0057:
        r16 = "dur";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x005f:
        r3 = 2;
        goto L_0x0037;
    L_0x0061:
        r16 = "style";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x0069:
        r3 = 3;
        goto L_0x0037;
    L_0x006b:
        r16 = "region";
        r15 = r15.equals(r16);
        if (r15 == 0) goto L_0x0037;
    L_0x0073:
        r3 = 4;
        goto L_0x0037;
    L_0x0075:
        r0 = r23;
        r2 = m9334a(r2, r0);
        r6 = r12;
        r17 = r2;
        r2 = r4;
        r4 = r17;
        goto L_0x003d;
    L_0x0082:
        r0 = r23;
        r2 = m9334a(r2, r0);
        r4 = r6;
        r6 = r12;
        goto L_0x003d;
    L_0x008b:
        r0 = r23;
        r2 = m9334a(r2, r0);
        r17 = r4;
        r4 = r6;
        r6 = r2;
        r2 = r17;
        goto L_0x003d;
    L_0x0098:
        r0 = r19;
        r2 = r0.m9341a(r2);
        r3 = r2.length;
        if (r3 <= 0) goto L_0x003a;
    L_0x00a1:
        r9 = r2;
        r2 = r4;
        r4 = r6;
        r6 = r12;
        goto L_0x003d;
    L_0x00a6:
        r0 = r22;
        r3 = r0.containsKey(r2);
        if (r3 == 0) goto L_0x003a;
    L_0x00ae:
        r10 = r2;
        r2 = r4;
        r4 = r6;
        r6 = r12;
        goto L_0x003d;
    L_0x00b3:
        if (r21 == 0) goto L_0x0114;
    L_0x00b5:
        r0 = r21;
        r2 = r0.f7295d;
        r14 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
        if (r2 == 0) goto L_0x0114;
    L_0x00c2:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x00d0;
    L_0x00cb:
        r0 = r21;
        r2 = r0.f7295d;
        r6 = r6 + r2;
    L_0x00d0:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0114;
    L_0x00d9:
        r0 = r21;
        r2 = r0.f7295d;
        r4 = r4 + r2;
        r17 = r4;
        r4 = r6;
        r6 = r17;
    L_0x00e3:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x00f7;
    L_0x00ec:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0100;
    L_0x00f5:
        r6 = r4 + r12;
    L_0x00f7:
        r3 = r20.getName();
        r2 = com.ushareit.listenit.bpg.m9349a(r3, r4, r6, r8, r9, r10);
        return r2;
    L_0x0100:
        if (r21 == 0) goto L_0x00f7;
    L_0x0102:
        r0 = r21;
        r2 = r0.f7296e;
        r12 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r2 == 0) goto L_0x00f7;
    L_0x010f:
        r0 = r21;
        r6 = r0.f7296e;
        goto L_0x00f7;
    L_0x0114:
        r17 = r4;
        r4 = r6;
        r6 = r17;
        goto L_0x00e3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.bpe.a(org.xmlpull.v1.XmlPullParser, com.ushareit.listenit.bpg, java.util.Map, com.ushareit.listenit.bpf):com.ushareit.listenit.bpg");
    }

    private static boolean m9343b(String str) {
        if (str.equals("tt") || str.equals("head") || str.equals(C0154a.f2970z) || str.equals("div") || str.equals("p") || str.equals("span") || str.equals(fnn.KEY_BITRATE) || str.equals(C0321x.f3829P) || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information")) {
            return true;
        }
        return false;
    }

    private static void m9340a(String str, bpj com_ushareit_listenit_bpj) {
        Matcher matcher;
        String[] split = str.split("\\s+");
        if (split.length == 1) {
            matcher = f7285c.matcher(str);
        } else if (split.length == 2) {
            matcher = f7285c.matcher(split[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new bor("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            int i = -1;
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        i = 2;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        i = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    com_ushareit_listenit_bpj.m9376c(1);
                    break;
                case 1:
                    com_ushareit_listenit_bpj.m9376c(2);
                    break;
                case 2:
                    com_ushareit_listenit_bpj.m9376c(3);
                    break;
                default:
                    throw new bor("Invalid unit for fontSize: '" + group + "'.");
            }
            com_ushareit_listenit_bpj.m9366a(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new bor("Invalid expression for fontSize: '" + str + "'.");
    }

    private static long m9334a(String str, bpf com_ushareit_listenit_bpf) {
        double d = 0.0d;
        Matcher matcher = f7283a.matcher(str);
        double parseLong;
        if (matcher.matches()) {
            double parseLong2 = ((double) Long.parseLong(matcher.group(3))) + (((double) (Long.parseLong(matcher.group(1)) * 3600)) + ((double) (Long.parseLong(matcher.group(2)) * 60)));
            String group = matcher.group(4);
            parseLong2 += group != null ? Double.parseDouble(group) : 0.0d;
            group = matcher.group(5);
            if (group != null) {
                parseLong = (double) (((float) Long.parseLong(group)) / com_ushareit_listenit_bpf.f7289a);
            } else {
                parseLong = 0.0d;
            }
            parseLong += parseLong2;
            String group2 = matcher.group(6);
            if (group2 != null) {
                d = (((double) Long.parseLong(group2)) / ((double) com_ushareit_listenit_bpf.f7290b)) / ((double) com_ushareit_listenit_bpf.f7289a);
            }
            return (long) ((parseLong + d) * 1000000.0d);
        }
        Matcher matcher2 = f7284b.matcher(str);
        if (matcher2.matches()) {
            parseLong = Double.parseDouble(matcher2.group(1));
            String group3 = matcher2.group(2);
            int i = -1;
            switch (group3.hashCode()) {
                case 102:
                    if (group3.equals("f")) {
                        i = 4;
                        break;
                    }
                    break;
                case 104:
                    if (group3.equals("h")) {
                        i = 0;
                        break;
                    }
                    break;
                case 109:
                    if (group3.equals("m")) {
                        i = 1;
                        break;
                    }
                    break;
                case 115:
                    if (group3.equals("s")) {
                        i = 2;
                        break;
                    }
                    break;
                case 116:
                    if (group3.equals("t")) {
                        i = 5;
                        break;
                    }
                    break;
                case 3494:
                    if (group3.equals("ms")) {
                        i = 3;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    parseLong *= 3600.0d;
                    break;
                case 1:
                    parseLong *= 60.0d;
                    break;
                case 3:
                    parseLong /= 1000.0d;
                    break;
                case 4:
                    parseLong /= (double) com_ushareit_listenit_bpf.f7289a;
                    break;
                case 5:
                    parseLong /= (double) com_ushareit_listenit_bpf.f7291c;
                    break;
            }
            return (long) (parseLong * 1000000.0d);
        }
        throw new bor("Malformed time expression: " + str);
    }
}
