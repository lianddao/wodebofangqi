package com.miui.player.plugin.onlinelyric.baidu_duomi_lrc123;

import android.text.TextUtils;
import android.util.Log;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.plugin.onlinelyric.LyricItemInfo;
import com.miui.player.util.SaxXmlParserWrapper;
import com.miui.player.util.SaxXmlParserWrapper.ConfigParserException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class BaiduTingProvider extends LyricProviderBase {
    private static final String LIST_URL_PREFIX = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.search.lrcys&format=xml&query=";
    private static final String QUERY_SEPARATOR = "$$$";
    private static final String TAG = BaiduTingProvider.class.getCanonicalName();

    private static class ListXMLParser extends DefaultHandler {
        static final String TAG_LRC_LINK = "lrclink";
        private final String mArtist;
        private String mCurrentContent;
        private LyricItemInfo mCurrentItem;
        private final List<LyricItemInfo> mList = new ArrayList();
        private final String mTrack;

        public ListXMLParser(String tr, String ar) {
            this.mTrack = tr;
            this.mArtist = ar;
        }

        public List<LyricItemInfo> result() {
            return this.mList;
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if (TAG_LRC_LINK.equalsIgnoreCase(localName)) {
                this.mCurrentItem = new LyricItemInfo();
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            if (this.mCurrentItem != null) {
                this.mCurrentContent = String.valueOf(ch, start, length);
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if (TAG_LRC_LINK.equalsIgnoreCase(localName) && this.mCurrentItem != null) {
                if (!TextUtils.isEmpty(this.mCurrentContent)) {
                    this.mCurrentItem.setArtist(this.mArtist);
                    this.mCurrentItem.setTrack(this.mTrack);
                    this.mCurrentItem.setLink(this.mCurrentContent);
                }
                if (this.mCurrentItem.isValid()) {
                    this.mList.add(this.mCurrentItem);
                }
                this.mCurrentItem = null;
            }
        }
    }

    public BaiduTingProvider(LyricSearchInfo searchInfo) {
        super(searchInfo);
    }

    protected String getItemUrl(LyricItemInfo info) {
        if (info == null || !(info.getLink() instanceof String)) {
            return null;
        }
        return (String) info.getLink();
    }

    protected String getListUrl() {
        if (this.mSearchInfo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            String temp = this.mSearchInfo.mTrack;
            if (!TextUtils.isEmpty(temp)) {
                sb.append(URLEncoder.encode(temp, "utf-8"));
            }
            temp = this.mSearchInfo.mArtist;
            if (!TextUtils.isEmpty(temp)) {
                if (sb.length() > 0) {
                    sb.append("$$$");
                }
                sb.append(URLEncoder.encode(temp, "utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
        }
        if (sb.length() > 0) {
            return LIST_URL_PREFIX + sb.toString();
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.miui.player.plugin.onlinelyric.LyricContent parseItem(InputStream r7) {
        /*
        r6 = this;
        if (r7 != 0) goto L_0x0004;
    L_0x0002:
        r5 = 0;
    L_0x0003:
        return r5;
    L_0x0004:
        r1 = 0;
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r5];
        r4 = new java.io.ByteArrayOutputStream;
        r4.<init>();
        r3 = -1;
    L_0x000f:
        r3 = r7.read(r0);	 Catch:{ IOException -> 0x001a }
        if (r3 < 0) goto L_0x0026;
    L_0x0015:
        r5 = 0;
        r4.write(r0, r5, r3);	 Catch:{ IOException -> 0x001a }
        goto L_0x000f;
    L_0x001a:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x0036 }
        r4.close();	 Catch:{ IOException -> 0x0040 }
    L_0x0021:
        r5 = com.miui.player.plugin.onlinelyric.LyricContentFactory.create(r1);
        goto L_0x0003;
    L_0x0026:
        r4.flush();	 Catch:{ IOException -> 0x001a }
        r1 = r4.toByteArray();	 Catch:{ IOException -> 0x001a }
        r4.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x0021;
    L_0x0031:
        r2 = move-exception;
    L_0x0032:
        r2.printStackTrace();
        goto L_0x0021;
    L_0x0036:
        r5 = move-exception;
        r4.close();	 Catch:{ IOException -> 0x003b }
    L_0x003a:
        throw r5;
    L_0x003b:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x003a;
    L_0x0040:
        r2 = move-exception;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.plugin.onlinelyric.baidu_duomi_lrc123.BaiduTingProvider.parseItem(java.io.InputStream):com.miui.player.plugin.onlinelyric.LyricContent");
    }

    protected List<LyricItemInfo> parseList(InputStream is) {
        List<LyricItemInfo> list = null;
        if (this.mSearchInfo != null) {
            try {
                DefaultHandler handler = new ListXMLParser(this.mSearchInfo.mTrack, this.mSearchInfo.mArtist);
                SaxXmlParserWrapper.parse(is, handler);
                list = handler.result();
            } catch (ConfigParserException e) {
                Log.e(TAG, e.toString());
            }
        }
        return list;
    }
}
