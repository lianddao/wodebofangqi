package com.miui.player.plugin.onlinemusic2.baidu.parser;

import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.base.Parsers;
import com.miui.player.plugin.onlinemusic2.Channel;
import com.miui.player.plugin.onlinemusic2.Channel.ChannelDetail;
import com.miui.player.plugin.onlinemusic2.Channel.ChannelOutline;
import com.miui.player.plugin.onlinemusic2.ChannelList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ChannelListParser implements Parser<ChannelList, JSONArray> {

    public static class ChannelParser implements Parser<Channel, JSONObject> {

        public static class ChannelDetailParser implements Parser<ChannelDetail, JSONObject> {
            private static final String ARTIST_ID = "artistid";
            private static final String AVATAR = "avatar";
            private static final String COUNT = "count";

            public ChannelDetail parse(JSONObject src) {
                ChannelDetail detail = new ChannelDetail();
                detail.mArtistId = src.optString("artistid", null);
                detail.mURLAvatar = src.optString("avatar", null);
                detail.mAudioCount = src.optInt("count", 0);
                return detail;
            }
        }

        public static class ChannelOutlineParser implements Parser<ChannelOutline, JSONObject> {
            private static final String ID = "channelid";
            private static final String THUMB = "thumb";
            private static final String TITLE = "name";

            public ChannelOutline parse(JSONObject src) {
                String id = src.optString("channelid", null);
                String title = src.optString("name", null);
                if (id == null || title == null) {
                    return null;
                }
                ChannelOutline outline = new ChannelOutline(id, title);
                outline.mURLThumb = src.optString(THUMB, null);
                return outline;
            }
        }

        public Channel parse(JSONObject src) {
            ChannelOutline outline = new ChannelOutlineParser().parse(src);
            return outline != null ? new Channel(outline) : null;
        }
    }

    public ChannelList parse(JSONArray src) {
        List<Channel> list = Parsers.parserArray(src, new ChannelParser());
        if (list != null) {
            return new ChannelList(list);
        }
        return null;
    }
}
