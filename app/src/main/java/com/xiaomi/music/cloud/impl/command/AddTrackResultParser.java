package com.xiaomi.music.cloud.impl.command;

import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.Track;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import org.json.JSONObject;

/* compiled from: AddTrackCommand */
class AddTrackResultParser implements Parser<Track, JSONObject> {
    AddTrackResultParser() {
    }

    public Track parse(JSONObject from) throws Throwable {
        return (Track) Parsers.parse(from.getJSONObject(CloudJsonTag.TAG_MUSIC_INFO), new TrackParser(0));
    }
}
