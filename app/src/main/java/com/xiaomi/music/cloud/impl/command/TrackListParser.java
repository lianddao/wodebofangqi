package com.xiaomi.music.cloud.impl.command;

import com.google.android.collect.Lists;
import com.xiaomi.music.cloud.CloudEngine;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.Track;
import com.xiaomi.music.cloud.model.TrackList;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrackListParser implements Parser<TrackList, JSONObject> {
    public TrackList parse(JSONObject from) throws Throwable {
        String tag = from.optString(CloudJsonTag.TAG_SYNC_TAG, CloudEngine.INITIAL_SYNC_TAG_STR);
        boolean lastPage = from.getBoolean(CloudJsonTag.TAG_LAST_PAGE);
        JSONArray tracks = from.getJSONArray(CloudJsonTag.TAG_TRACKS);
        List<Track> list = Lists.newArrayList();
        TrackParser pp = new TrackParser(0);
        for (int i = 0; i < tracks.length(); i++) {
            list.add(Parsers.parse(tracks.getJSONObject(i), pp));
        }
        return TrackList.create(list, tag, lastPage);
    }
}
