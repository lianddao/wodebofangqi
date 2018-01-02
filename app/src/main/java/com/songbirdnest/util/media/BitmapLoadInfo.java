package com.songbirdnest.util.media;

public class BitmapLoadInfo {
    public int desired_height;
    public int desired_width;
    public String filePath;
    public String id;
    public ImageReady imageReadyListener;
    public ImagePostProcessor postProcessor;
    public BitmapRemovedListener removeListener;
    public String url;
}
