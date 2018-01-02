package com.miui.player.plugin.onlinelyric.baidu_duomi_lrc123;

import android.text.TextUtils;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.meta.MetaManager;
import com.miui.player.plugin.onlinelyric.LyricContent;
import com.miui.player.plugin.onlinelyric.LyricContentFactory;
import com.miui.player.plugin.onlinelyric.LyricItemInfo;
import com.xiaomi.music.util.NetworkUtil;
import com.xiaomi.music.util.StreamHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.ClientProtocolException;

class Lrc123Provider extends LyricProviderBase {
    private static final String ALBUM_START = "专辑:";
    private static final String ARTIST_START = "歌手:";
    private static final int BUFFER_SIZE = 4096;
    private static final String FIELD_SONG = "song";
    private static final String ITEM_START = "<div class=\"newscont mb15\"";
    private static final String ITEM_URL_PREFIX = "http://www.lrc123.com";
    private static final Pattern LINK_PATTERN = Pattern.compile("\"(/download/lrc/[^\"]+)\"");
    private static final String LINK_START = "<a href=\"/download/lrc";
    private static final String LIST_URL_FORMAT = "http://www.lrc123.com/?field=%s&keyword=%s";
    private static final Pattern NAME_PATTERN = Pattern.compile("<[^>]+>");
    private static final String PAGE_END = "</html>";
    private static final String TRACK_START = "歌曲:";

    private static class LyricItemComparator implements Comparator<LyricItemInfo> {
        private static final int ALBUM_WEIGHT = 1;
        private static final int ARTIST_WEIGHT = 2;
        private static final int CONTAIN_WEIGHT = 2;
        private static final int DEFAULT_WEIGHT = 0;
        private static final int EQUAL_WEIGHT = 3;
        private static final int TRACK_WEIGHT = 3;
        private final String album;
        private final String artist;
        private final String track;

        public LyricItemComparator(String tr, String ar, String al) {
            if (tr == null) {
                tr = MetaManager.UNKNOWN_STRING;
            }
            this.track = tr;
            if (ar == null) {
                ar = MetaManager.UNKNOWN_STRING;
            }
            this.artist = ar;
            if (al == null) {
                al = MetaManager.UNKNOWN_STRING;
            }
            this.album = al;
        }

        public int compare(LyricItemInfo object1, LyricItemInfo object2) {
            return -(getSimilarity(object1) - getSimilarity(object2));
        }

        private int getSimilarity(LyricItemInfo item) {
            return ((getStrSimilarity(this.track, item.getTrack()) * 3) + (getStrSimilarity(this.artist, item.getArtist()) * 2)) + (getStrSimilarity(this.album, item.getAlbum()) * 1);
        }

        private static int getStrSimilarity(String a, String b) {
            if (TextUtils.equals(a, b)) {
                return 3;
            }
            if (a == null || b == null || a.contains(b) || b.contains(a)) {
                return 2;
            }
            return 0;
        }
    }

    public Lrc123Provider(LyricSearchInfo searchInfo) {
        super(searchInfo);
    }

    protected String getItemUrl(LyricItemInfo info) {
        return info != null ? ITEM_URL_PREFIX + info.getLink() : null;
    }

    protected String getListUrl() {
        if (TextUtils.isEmpty(this.mSearchInfo.mTrack)) {
            return null;
        }
        String url = null;
        try {
            return String.format(LIST_URL_FORMAT, new Object[]{"song", URLEncoder.encode(this.mSearchInfo.mTrack, "utf-8")});
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return url;
        }
    }

    protected LyricContent parseItem(InputStream is) {
        try {
            return LyricContentFactory.create(StreamHelper.toByteArray(is));
        } catch (IOException e) {
            return null;
        }
    }

    protected InputStream doRequestItem(String url, Object link) throws ClientProtocolException, URISyntaxException, IOException {
        return NetworkUtil.doHttpGet(url, 0, 0);
    }

    protected List<LyricItemInfo> parseList(InputStream is) {
        ArrayList<LyricItemInfo> itemList = new ArrayList();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        boolean skipLine = false;
        while (true) {
            if (!skipLine || line == null) {
                try {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            skipLine = false;
            if (line.trim().startsWith(ITEM_START)) {
                LyricItemInfo item = new LyricItemInfo();
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        continue;
                        break;
                    }
                    String text = line.trim();
                    if (item.getTrack() == null && text.startsWith(TRACK_START)) {
                        item.setTrack(filterName(text));
                    } else if (item.getArtist() == null && text.startsWith(ARTIST_START)) {
                        item.setArtist(filterName(text));
                    } else if (item.getAlbum() == null && text.startsWith(ALBUM_START)) {
                        item.setAlbum(filterName(text));
                    } else if (item.getLink() == null && text.startsWith(LINK_START)) {
                        item.setLink(filterLink(text));
                    } else {
                        skipLine = text.startsWith(ITEM_START);
                        if (skipLine || text.startsWith(PAGE_END)) {
                        }
                    }
                }
                if (item.isValid()) {
                    itemList.add(item);
                }
            }
        }
        Collections.sort(itemList, new LyricItemComparator(this.mSearchInfo.mTrack, this.mSearchInfo.mArtist, this.mSearchInfo.mAlbum));
        return itemList;
    }

    private String filterName(String src) {
        int start = src.indexOf(60);
        if (start < 0) {
            return null;
        }
        return NAME_PATTERN.matcher(src.substring(start)).replaceAll(MetaManager.UNKNOWN_STRING);
    }

    private String filterLink(String src) {
        Matcher m = LINK_PATTERN.matcher(src);
        return m.find() ? m.group(1) : null;
    }
}
