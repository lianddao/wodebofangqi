package com.xiaomi.music.cloud.impl.command;

import com.google.android.collect.Lists;
import com.xiaomi.music.cloud.CloudEngine;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.Playlist;
import com.xiaomi.music.cloud.model.PlaylistInfo;
import com.xiaomi.music.cloud.model.PlaylistList;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PlaylistListParser implements Parser<PlaylistList, JSONObject> {
    public PlaylistList parse(JSONObject from) throws Throwable {
        String tag = from.optString(CloudJsonTag.TAG_SYNC_TAG, CloudEngine.INITIAL_SYNC_TAG_STR);
        boolean lastPage = from.getBoolean(CloudJsonTag.TAG_LAST_PAGE);
        JSONArray playlists = from.getJSONArray("playlists");
        List<Playlist> list = Lists.newArrayList();
        PlaylistInfoParser pp = new PlaylistInfoParser();
        for (int i = 0; i < playlists.length(); i++) {
            list.add(Playlist.create((PlaylistInfo) Parsers.parse(playlists.getJSONObject(i), pp), 0, 0));
        }
        return PlaylistList.create(list, tag, lastPage);
    }
}
