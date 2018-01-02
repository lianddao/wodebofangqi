package com.songbirdnest.soundboard.data;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class CollectionImage {
    protected STATUS status = STATUS.FAILED;
    protected String url;

    public enum STATUS {
        COMPLETED,
        PENDING,
        FAILED;

        static STATUS getStatus(int status) {
            switch (status) {
                case 0:
                    return COMPLETED;
                case 1:
                    return PENDING;
                default:
                    return FAILED;
            }
        }

        public static STATUS parseStatus(String statusString) {
            if (statusString.equalsIgnoreCase("completed")) {
                return COMPLETED;
            }
            if (statusString.equalsIgnoreCase("pending")) {
                return PENDING;
            }
            return FAILED;
        }
    }

    public STATUS getStatus() {
        return this.status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void parseJSON(JSONObject jsonObject) {
        if (jsonObject.has("image")) {
            try {
                JSONObject image = jsonObject.getJSONObject("image");
                if (!image.isNull("url")) {
                    this.url = image.optString("url", null);
                }
                if (!image.isNull("status")) {
                    String statusString = image.optString("status", null);
                    if (statusString != null) {
                        this.status = STATUS.parseStatus(statusString);
                    }
                }
            } catch (JSONException e) {
                Log.e(getClass().getSimpleName(), "JSON Parse Failed", e);
            }
        }
    }
}
