package com.songbirdnest.soundboard.data;

import com.songbirdnest.stream.StreamUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedImage {
    protected int mHeight;
    protected String mSrc;
    protected int mWidth;

    public FeedImage(JSONObject pInput) {
        try {
            parseObject(pInput);
        } catch (JSONException e) {
        }
    }

    protected void parseObject(JSONObject pInput) throws JSONException {
        this.mSrc = StreamUtils.jsonGetString(pInput, "src");
        this.mWidth = StreamUtils.jsonGetInt(pInput, "width").intValue();
        this.mHeight = StreamUtils.jsonGetInt(pInput, "height").intValue();
    }

    public String getSrc() {
        return this.mSrc;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean equals(Object o) {
        if (o.getClass().equals(getClass())) {
            FeedImage aObject = (FeedImage) o;
            if (aObject.mHeight == this.mHeight && aObject.mSrc.equals(this.mSrc) && aObject.mWidth == this.mWidth) {
                return true;
            }
        }
        return false;
    }
}
