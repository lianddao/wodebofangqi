package com.xiaomi.music.cloud.impl.command;

import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.DeleteInfo;
import com.xiaomi.music.parser.Parser;
import org.json.JSONObject;

public class DeleteParser implements Parser<DeleteInfo, JSONObject> {
    public DeleteInfo parse(JSONObject from) throws Throwable {
        return DeleteInfo.create(from.getLong(CloudJsonTag.TAG_SYNC_TAG), from.getBoolean(CloudJsonTag.TAG_EXIST));
    }
}
