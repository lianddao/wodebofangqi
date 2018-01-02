package com.xiaomi.music.cloud.impl.command;

import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.PlaylistInfo;
import com.xiaomi.music.parser.Parser;
import org.json.JSONObject;

public class PlaylistInfoParser implements Parser<PlaylistInfo, JSONObject> {
    public PlaylistInfo parse(JSONObject from) throws Throwable {
        long createTime = from.optLong(CloudJsonTag.TAG_CREATE_TIME, 0);
        String playlistCloudId = from.getString("micloudId");
        String playlistOnlineId = from.optString("onlineId", null);
        return PlaylistInfo.create(playlistCloudId, from.getString("name"), from.getInt("type"), playlistOnlineId, createTime);
    }
}
