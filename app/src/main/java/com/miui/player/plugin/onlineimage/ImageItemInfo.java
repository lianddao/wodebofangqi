package com.miui.player.plugin.onlineimage;

import java.io.InputStream;
import java.io.Serializable;

public class ImageItemInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public int mHeight;
    public InputStream mInputStream;
    public String mKeyword;
    public final String mURL;
    public int mWidth;

    public ImageItemInfo(String url) {
        this.mURL = url;
    }
}
