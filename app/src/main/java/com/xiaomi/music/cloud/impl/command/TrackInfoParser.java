package com.xiaomi.music.cloud.impl.command;

import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.TrackInfo;
import com.xiaomi.music.parser.Parser;
import org.json.JSONObject;

public class TrackInfoParser implements Parser<TrackInfo, JSONObject> {
    public TrackInfo parse(JSONObject from) throws Throwable {
        return TrackInfo.create(from.getString("micloudId"), from.optString("onlineId", null), from.getString(CloudJsonTag.TAG_TRACK_PLAYLIST_CLOUD_ID), from.optLong(CloudJsonTag.TAG_CREATE_TIME, 0));
    }
}
