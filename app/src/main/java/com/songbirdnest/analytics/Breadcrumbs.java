package com.songbirdnest.analytics;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class Breadcrumbs {
    private static final int SIZE = 64;
    private static Map<String, String> breadMap = new HashMap();
    private static int crumbPtr = 0;
    private static StringBuffer crumbsBuffer = new StringBuffer(64);

    public static void add(String bread) {
        String crumb = (String) breadMap.get(bread);
        if (crumb == null) {
            Log.e("BREADCRUMB", "Undefined bread " + bread);
            return;
        }
        char c = crumb.charAt(0);
        if (crumbsBuffer.length() < 64) {
            crumbsBuffer.append(c);
        } else {
            crumbsBuffer.setCharAt(crumbPtr, c);
        }
        int i = crumbPtr + 1;
        crumbPtr = i;
        if (i >= 64) {
            crumbPtr = 0;
        }
    }

    public static String get() {
        return crumbsBuffer.substring(crumbPtr) + crumbsBuffer.substring(0, crumbPtr);
    }

    private static void put(String key, String value) {
        if (breadMap.containsKey(key)) {
            throw new RuntimeException("Breadcrumbs: key exists " + key);
        }
        value = value.substring(0, 1);
        if (breadMap.containsValue(value)) {
            throw new RuntimeException("Breadcrumbs: value exists " + value);
        }
        breadMap.put(key, value);
    }

    static {
        put(Analytics.EVENT_REPEAT_NONE, "0");
        put(Analytics.EVENT_REPEAT_ONE, "1");
        put(Analytics.EVENT_REPEAT_ALL, "2");
        put(Analytics.EVENT_SPLASH, "3");
        put(Analytics.EVENT_ABOUT, "A");
        put(Analytics.EVENT_BACK_TO_LIST, "B");
        put(Analytics.EVENT_CRASH, "C");
        put(Analytics.EVENT_MUSIC_DRAWER, "D");
        put(Analytics.EVENT_SHUFFLE_ENABLED, "F");
        put(Analytics.EVENT_SHUFFLE_DISABLED, "G");
        put(Analytics.EVENT_HOME, "H");
        put(Analytics.EVENT_FACEBOOK_LIKE, "K");
        put(Analytics.EVENT_LOCK_SCREEN, "L");
        put(Analytics.EVENT_MUSIC_MORE, "M");
        put(Analytics.EVENT_PHOTOSTREAM_ON, "N");
        put(Analytics.EVENT_PHOTOSTREAM_OFF, "O");
        put(Analytics.EVENT_PLAYBACK_INITIATED, "P");
        put(Analytics.EVENT_SEARCH, "S");
        put(Analytics.EVENT_SETTINGS, "T");
        put(Analytics.EVENT_CRUMBS, "U");
        put(Analytics.EVENT_4X1_WIDGET_OFF, "V");
        put(Analytics.EVENT_4X1_WIDGET_ON, "W");
        put(Analytics.EVENT_UNCAUGHTEXCEPTION, "X");
        put(Analytics.EVENT_SD_BUSY, "Z");
        put(Analytics.EVENT_MUSIC_ARTIST, "a");
        put("/music/artists/<artist_name>/albums", "b");
        put(Analytics.EVENT_SEARCH_VIEW_SEARCH, "c");
        put(Analytics.EVENT_MUSIC_PODCASTS, "d");
        put("/music/artists/<artist_name>/songs", "e");
        put("/music/genres/<genre_name>/songs", "f");
        put(Analytics.EVENT_MUSIC_GENRES, "g");
        put("/music/genres/<genre_name>/artists", "h");
        put("/music/genres/<genre_name>/artists<artist_name>/songs", "i");
        put("/music/genres/<genre_name>/albums<album_name>/songs", "j");
        put("/music/genres/<genre_name>/albums", "k");
        put(Analytics.EVENT_MUSIC_ALBUMS, "l");
        put(Analytics.EVENT_NEXT, "m");
        put(Analytics.EVENT_SONG_VIEW_SEARCH, "n");
        put(Analytics.EVENT_PREVIOUS, "o");
        put(Analytics.EVENT_MUSIC_PLAYLISTS, "p");
        put(Analytics.EVENT_LIST_CHANGE, "q");
        put(Analytics.EVENT_ARTIST_VIEW_SEARCH, "r");
        put(Analytics.EVENT_MUSIC_SONGS, "s");
        put(Analytics.EVENT_FLICKR_IMAGE, "t");
        put(Analytics.EVENT_BROADCAST, "u");
        put(Analytics.EVENT_MEDIA_SERVER_DEATH, "v");
        put("/music/albums/<album_name>", "w");
        put("/music/playlists/<playlist_name>", "x");
        put(Analytics.EVENT_NO_HEADSET_MEDIA, "y");
        put(Analytics.EVENT_VIDEO_LISTING, "z");
        put(Analytics.EVENT_FOLLOW_FRIEND_VIEW, "4");
        put(Analytics.EVENT_FOLLOW_ME_VIEW, "5");
        put(Analytics.EVENT_WELCOME_VIEW, "6");
        put(Analytics.EVENT_INVITE, "7");
        put(Analytics.EVENT_COMMENT, "8");
        put(Analytics.EVENT_FRIEND_VIEW, "9");
    }

    private static String getFreeCodes() {
        String free = "";
        for (int i = 33; i <= 126; i++) {
            String value = String.valueOf((char) i);
            if (!breadMap.containsValue(value)) {
                free = free + value;
            }
        }
        return free;
    }

    public static String decrumb(String crumbs) {
        StringBuffer breadBuffer = new StringBuffer();
        Map<String, String> crumbMap = getCrumbMap();
        for (int i = 0; i < crumbs.length(); i++) {
            String crumb = "" + crumbs.charAt(i);
            String bread = (String) crumbMap.get(crumb);
            if (bread == null) {
                bread = "[" + crumb + "]";
            }
            breadBuffer.append(bread);
            breadBuffer.append(", ");
        }
        return breadBuffer.toString();
    }

    private static Map<String, String> getCrumbMap() {
        Map<String, String> crumbMap = new HashMap();
        for (String key : breadMap.keySet()) {
            crumbMap.put((String) breadMap.get(key), key);
        }
        return crumbMap;
    }

    public static void main(String[] args) {
        if (args.length == 2 && args[0].equals("-decrumb")) {
            System.out.println(decrumb(args[1]));
            return;
        }
        System.out.println("Usage: -decrumb crumbsString");
    }
}
