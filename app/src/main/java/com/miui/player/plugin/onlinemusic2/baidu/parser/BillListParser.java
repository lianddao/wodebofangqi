package com.miui.player.plugin.onlinemusic2.baidu.parser;

import android.text.TextUtils;
import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.base.Parsers;
import com.miui.player.plugin.onlinemusic2.Bill;
import com.miui.player.plugin.onlinemusic2.Bill.BillDetail;
import com.miui.player.plugin.onlinemusic2.Bill.BillOutline;
import com.miui.player.plugin.onlinemusic2.BillList;
import com.miui.player.util.DateTimeHelper;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class BillListParser implements Parser<BillList, JSONArray> {
    public static final Pattern BILLBOARD_KEY_PATTERN = Pattern.compile("^billboard(\\d+)$");
    private BillParser mBillParser = new BillParser();

    public static class BillParser implements Parser<Bill, JSONObject> {
        private final BillOutlineParser mOutlineParser = new BillOutlineParser();

        public static class BillDetailParser implements Parser<BillDetail, JSONObject> {
            private static final String NO = "billboard_no";
            private static final String TYPE = "billboard_type";
            private static final String UPDATE_DATE = "update_date";

            public BillDetail parse(JSONObject src) {
                String type = null;
                Matcher matcher = BillListParser.BILLBOARD_KEY_PATTERN.matcher(src.optString(Parsers.KEY_JSONOBJECT_ITER, null));
                if (matcher.find()) {
                    type = matcher.group(1);
                }
                if (type == null) {
                    type = src.optString(TYPE, null);
                }
                return new BillDetail(type, src.optString(NO, null), DateTimeHelper.fromString(src.optString(UPDATE_DATE, null), "yyyy-MM-dd"));
            }
        }

        public static class BillOutlineParser implements Parser<BillOutline, JSONObject> {
            private static final String CATALOG = "in_cata";
            private static final String ID = "bill_id";
            private static final String IS_ARTIST = "is_artist";
            private static final String NAME = "name";
            private static final String NUM = "num";
            private static final String[] UNUSED_BILL = new String[]{"10"};

            public BillOutline parse(JSONObject src) {
                String id = src.optString(ID, null);
                String name = src.optString("name", null);
                if ("新歌TOP100".equals(name)) {
                    name = "新歌金曲";
                } else if ("歌曲TOP500".equals(name)) {
                    name = "歌曲总榜";
                }
                int isArtist = src.optInt(IS_ARTIST, 0);
                int num = src.optInt(NUM, 0);
                if (id == null || name == null || isArtist == 1) {
                    return null;
                }
                for (String unused : UNUSED_BILL) {
                    if (TextUtils.equals(unused, id)) {
                        return null;
                    }
                }
                return new BillOutline(id, name, src.optString(CATALOG, null), num);
            }
        }

        public Bill parse(JSONObject src) {
            BillOutline outline = this.mOutlineParser.parse(src);
            return outline != null ? new Bill(outline) : null;
        }
    }

    public BillList parse(JSONArray src) {
        List<Bill> list = Parsers.parserArray(src, this.mBillParser);
        return list != null ? new BillList(list) : null;
    }
}
