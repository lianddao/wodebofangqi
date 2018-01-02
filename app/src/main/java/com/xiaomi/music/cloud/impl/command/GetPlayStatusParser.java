package com.xiaomi.music.cloud.impl.command;

import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.PlayStatus;
import com.xiaomi.music.parser.Parser;
import org.json.JSONObject;

/* compiled from: GetPlayStatusCommand */
class GetPlayStatusParser implements Parser<PlayStatus, JSONObject> {
    GetPlayStatusParser() {
    }

    public PlayStatus parse(JSONObject from) throws Throwable {
        JSONObject status = new JSONObject(from.getString(CloudJsonTag.TAG_INFO));
        return new PlayStatus(status.getString("onlineId"), status.getString("micloudId"), status.getInt(CloudJsonTag.TAG_PLAY_POSITION));
    }
}
