package com.xiaomi.music.cloud.impl;

import java.io.File;

public interface CloudUrls {
    public static final String URL_ADD_TRACK = (URL_MUSIC + "/user/%s/song");
    public static final String URL_BATCH_POST = (URL_MUSIC + "/user/%s/full/batch");
    public static final String URL_CREATE_PLAYLIST = (URL_MUSIC + "/user/%s/playlist");
    public static final String URL_DELETE_PLAYLIST = (URL_MUSIC + "/user/%s/playlist/%s/delete");
    public static final String URL_DELETE_TRACK = (URL_MUSIC + "/user/%s/song/%s/delete");
    public static final String URL_FULL = (URL_MUSIC + "/user/%s/full");
    public static final String URL_GET_PLAYLISTS = (URL_MUSIC + "/user/%s/playlist/full");
    public static final String URL_GET_QUEUE = (URL_MUSIC + "/user/%s/playlist/current");
    public static final String URL_GET_STATUS = (URL_MUSIC + "/user/%s/playstatus");
    public static final String URL_GET_TRACKS = (URL_MUSIC + "/user/%s/playlist/%s/full");
    public static final String URL_HOST_BASE = (USE_PREVIEW ? "http://micloud.preview.n.xiaomi.net" : "http://musicapi.micloud.xiaomi.net");
    public static final String URL_MUSIC = (URL_HOST_BASE + "/mic/music/v3");
    public static final String URL_UPLOAD_QUEUE = (URL_MUSIC + "/user/%s/playlist/current");
    public static final String URL_UPLOAD_STATUS = (URL_MUSIC + "/user/%s/playstatus");
    public static final boolean USE_PREVIEW = new File("/data/system/account_preview").exists();
}
