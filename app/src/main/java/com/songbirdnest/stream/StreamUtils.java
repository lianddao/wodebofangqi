package com.songbirdnest.stream;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.cmc.music.myid3.id3v2.MyID3v2Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class StreamUtils {
    public static String buildURLString(String server, String path, List<String> params) {
        StringBuilder builder = new StringBuilder();
        builder.append(server);
        if (!server.endsWith("/")) {
            builder.append("/");
        }
        builder.append(path);
        if (!path.endsWith("/")) {
            builder.append("/");
        }
        if (params != null) {
            for (String param : params) {
                builder.append(param);
                builder.append("/");
            }
        }
        if (builder.charAt(builder.length() - 1) == '/') {
            builder.setLength(builder.length() - 1);
        }
        return builder.toString();
    }

    public static String buildURLRequestString(String server, String path, List<RequestParameter> requestParameters) {
        StringBuilder builder = new StringBuilder();
        builder.append(buildURLString(server, path, null));
        builder.append("?");
        for (RequestParameter parameter : requestParameters) {
            try {
                builder.append(URLEncoder.encode(parameter.getParam(), MyID3v2Constants.CHAR_ENCODING_UTF_8));
                builder.append("=");
                builder.append(URLEncoder.encode(parameter.getValue()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }

    public static String jsonGetString(JSONObject pInput, String pTarget) throws JSONException {
        if (pInput.has(pTarget)) {
            return pInput.getString(pTarget);
        }
        return null;
    }

    public static Integer jsonGetInt(JSONObject pInput, String pTarget) throws JSONException {
        if (pInput.has(pTarget)) {
            return Integer.valueOf(pInput.getInt(pTarget));
        }
        return Integer.valueOf(0);
    }

    public static Long jsonGetLong(JSONObject pInput, String pTarget) throws JSONException {
        if (pInput.has(pTarget)) {
            return Long.valueOf(pInput.getLong(pTarget));
        }
        return Long.valueOf(0);
    }
}
