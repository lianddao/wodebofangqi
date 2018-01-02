package com.xiaomi.music.cloud.impl;

import com.xiaomi.music.Result;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudParsers {

    static class ResultParser<T> implements Parser<Result<T>, JSONObject> {
        private final Parser<T, JSONObject> mParser;

        public ResultParser(Parser<T, JSONObject> parser) {
            this.mParser = parser;
        }

        public Result<T> parse(JSONObject from) throws Throwable {
            int err = from.getInt("code");
            boolean retriable = from.getBoolean(CloudJsonTag.TAG_RETRIABLE);
            if (err != 0) {
                return Result.create(err, null, retriable);
            }
            if (this.mParser == null) {
                return Result.create(err, null, retriable);
            }
            return Result.create(err, this.mParser.parse(from.getJSONObject("data")), retriable);
        }
    }

    public static <T> Result<T> parse(JSONObject from, Parser<T, JSONObject> parser) throws JSONException {
        return Parsers.parseJson(from, new ResultParser(parser));
    }
}
