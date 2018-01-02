package com.miui.player.network;

import android.content.Context;
import com.miui.player.ui.base.MusicApplication;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.statistics.MusicTrackEvent;
import com.xiaomi.music.statistics.StatEngine;
import org.json.JSONException;
import org.json.JSONObject;

public class StatHelper {
    static final String EVENT_CLICK_SONG_GROUP = "click_song_group";
    static final String EVENT_DOWNLOAD_TRACK = "download_track";
    static final String EVENT_FAVORITE_TRACK = "favorite_track";
    static final String EVENT_PLAY_TRACK = "play_track";

    public static void uploadClickList(String type, String id, String name) {
        Context context = MusicApplication.getApplication();
        StatEngine engine = MusicEngine.get(context).getStatEngine();
        MusicTrackEvent event = engine.createTrackEvent(id);
        event.put("list_type", type).put("list_id", id).put("list_name", name);
        engine.applyTrackEvent(context, event);
    }

    public static void uploadPlayTrack(String track, String artist, String album) {
        Context context = MusicApplication.getApplication();
        StatEngine engine = MusicEngine.get(context).getStatEngine();
        MusicTrackEvent event = engine.createTrackEvent(EVENT_PLAY_TRACK);
        event.put("track_name", track).put("artist_name", artist).put("album_name", album);
        engine.applyTrackEvent(context, event);
    }

    public static void uploadDownloadTrack(String details) {
        try {
            JSONObject json = new JSONObject(details);
            String album = json.getString("album");
            String artist = json.getString("artist");
            String track = json.getString("track");
            Context context = MusicApplication.getApplication();
            StatEngine engine = MusicEngine.get(context).getStatEngine();
            MusicTrackEvent event = engine.createTrackEvent(EVENT_DOWNLOAD_TRACK);
            event.put("track_name", track).put("artist_name", artist).put("album_name", album);
            engine.applyTrackEvent(context, event);
        } catch (JSONException e) {
        }
    }

    public static void uploadFavoriteTrack(String track, String artist, String album) {
        Context context = MusicApplication.getApplication();
        StatEngine engine = MusicEngine.get(context).getStatEngine();
        MusicTrackEvent event = engine.createTrackEvent(EVENT_FAVORITE_TRACK);
        event.put("track_name", track).put("artist_name", artist).put("album_name", album);
        engine.applyTrackEvent(context, event);
    }
}
