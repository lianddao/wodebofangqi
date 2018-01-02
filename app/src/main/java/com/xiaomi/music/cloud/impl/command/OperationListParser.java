package com.xiaomi.music.cloud.impl.command;

import com.google.android.collect.Lists;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.CloudObject;
import com.xiaomi.music.cloud.model.OperationList;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GetOperationListCommand */
class OperationListParser implements Parser<OperationList, JSONObject> {
    OperationListParser() {
    }

    public OperationList parse(JSONObject from) throws Throwable {
        String syncTag = from.getString(CloudJsonTag.TAG_SYNC_TAG);
        String syncExtraInfo = from.optString(CloudJsonTag.TAG_SYNC_EXTRA_TAG);
        boolean lastPage = from.getBoolean(CloudJsonTag.TAG_LAST_PAGE);
        JSONArray array = from.getJSONArray(CloudJsonTag.TAG_ITEMS);
        PlaylistParser pp = new PlaylistParser(-1);
        TrackParser tp = new TrackParser(-1);
        List<CloudObject<?>> items = Lists.newArrayList();
        for (int i = 0; i < array.length(); i++) {
            JSONObject item = array.getJSONObject(i);
            String type = item.getString("type");
            if (CloudJsonTag.OPERATION_TYPE_PLAYLIST.equals(type)) {
                items.add(Parsers.parse(item, pp));
            } else if (CloudJsonTag.OPERATION_TYPE_TRACK.equals(type)) {
                items.add(Parsers.parse(item, tp));
            }
        }
        return OperationList.create(items, syncTag, lastPage, syncExtraInfo);
    }
}
