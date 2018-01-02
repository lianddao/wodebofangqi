package com.xiaomi.music.cloud.impl.command;

import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.Playlist;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import org.json.JSONObject;

/* compiled from: CreatePlaylistCommand */
class CreatePlaylistResultParser implements Parser<Playlist, JSONObject> {
    CreatePlaylistResultParser() {
    }

    public Playlist parse(JSONObject from) throws Throwable {
        return (Playlist) Parsers.parse(from.getJSONObject(CloudJsonTag.TAG_MUSIC_INFO), new PlaylistParser(0));
    }
}
