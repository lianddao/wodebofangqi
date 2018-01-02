package com.xiaomi.music.cloud.impl.command;

import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.CloudObject;
import com.xiaomi.music.cloud.model.Track;
import com.xiaomi.music.cloud.model.TrackInfo;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import org.json.JSONObject;

public class TrackParser implements Parser<Track, JSONObject> {
    private final int mDefaultStatus;

    public TrackParser(int dftStatus) {
        this.mDefaultStatus = dftStatus;
    }

    public Track parse(JSONObject from) throws Throwable {
        long syncTag = from.optLong(CloudJsonTag.TAG_ITEM_TAG);
        int status = CloudObject.getStatus(from.optString("status", null));
        if (status == -1) {
            status = this.mDefaultStatus;
        }
        JSONObject info = from.optJSONObject(CloudJsonTag.TAG_TRACK_INFO);
        if (info == null) {
            info = from;
        }
        return Track.create((TrackInfo) Parsers.parse(info, new TrackInfoParser()), status, syncTag);
    }
}
