package com.xiaomi.music.parser;

import com.google.android.collect.Lists;
import com.xiaomi.music.Result;
import com.xiaomi.music.util.MusicLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parsers {
    static final String TAG = "Parsers";

    public static <T, F> T parse(F from, Parser<T, F> parser) throws Throwable {
        return parser.parse(from);
    }

    public static <T> Result<T> parseJson(JSONObject from, Parser<Result<T>, JSONObject> parser) throws JSONException {
        Result<T> result;
        try {
            result = (Result) parser.parse(from);
            result.setRawData(from.toString());
            return result;
        } catch (JSONException e) {
            throw e;
        } catch (Throwable e2) {
            MusicLog.m398e(TAG, from.toString(), e2);
            result = Result.create(-3);
            result.setRawData(from.toString());
            return result;
        }
    }

    public static <T> List<T> parserArray(JSONArray jsonArray, Parser<T, JSONObject> parser) throws JSONException {
        List<T> result = Lists.newArrayList();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                T item = parser.parse(jsonArray.getJSONObject(i));
                if (item != null) {
                    result.add(item);
                }
            } catch (JSONException e) {
                throw e;
            } catch (Throwable e2) {
                MusicLog.m398e(TAG, jsonArray.toString(), e2);
            }
        }
        return result;
    }
}
