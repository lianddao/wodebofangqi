package com.xiaomi.music.cloud.impl;

import com.google.android.collect.Lists;
import com.xiaomi.music.Result;
import com.xiaomi.music.cloud.ComposableCommand;
import com.xiaomi.music.parser.Parser;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CloudEngineImpl */
class BatchResultParser<T> implements Parser<List<Result<T>>, JSONObject> {
    private final List<ComposableCommand<T>> mCommands;

    public BatchResultParser(List<ComposableCommand<T>> list) {
        this.mCommands = list;
    }

    public List<Result<T>> parse(JSONObject from) throws Throwable {
        List<Result<T>> result = Lists.newArrayList();
        JSONArray array = from.getJSONArray("list");
        for (int i = 0; i < array.length(); i++) {
            result.add(((ComposableCommand) this.mCommands.get(i)).toResult(array.getJSONObject(i)));
        }
        return result;
    }
}
