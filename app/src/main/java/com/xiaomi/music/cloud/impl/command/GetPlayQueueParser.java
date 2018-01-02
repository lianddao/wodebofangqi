package com.xiaomi.music.cloud.impl.command;

import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.PlayQueue;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.util.MusicLog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetPlayQueueCommand */
class GetPlayQueueParser implements Parser<PlayQueue, JSONObject> {
    GetPlayQueueParser() {
    }

    public PlayQueue parse(JSONObject from) throws Throwable {
        try {
            JSONArray array = new JSONObject(from.getString(CloudJsonTag.TAG_INFO)).getJSONArray("list");
            String[] queue = new String[array.length()];
            for (int i = 0; i < queue.length; i++) {
                queue[i] = array.getString(i);
            }
            return new PlayQueue(Arrays.asList(queue));
        } catch (JSONException e) {
            MusicLog.m398e("CloudCommand[GetPlayQueueCommand]", "Get Queue", e);
            return PlayQueue.EMPTY;
        }
    }
}
