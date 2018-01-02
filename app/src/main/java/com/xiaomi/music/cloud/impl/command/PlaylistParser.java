package com.xiaomi.music.cloud.impl.command;

import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.model.CloudObject;
import com.xiaomi.music.cloud.model.Playlist;
import com.xiaomi.music.cloud.model.PlaylistInfo;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import org.json.JSONObject;

public class PlaylistParser implements Parser<Playlist, JSONObject> {
    private final int mDefaultStatus;

    public PlaylistParser(int dftStatus) {
        this.mDefaultStatus = dftStatus;
    }

    public Playlist parse(JSONObject from) throws Throwable {
        long syncTag = from.optLong(CloudJsonTag.TAG_ITEM_TAG);
        int status = CloudObject.getStatus(from.getString("status"));
        if (status == -1) {
            status = this.mDefaultStatus;
        }
        JSONObject info = from.optJSONObject(CloudJsonTag.TAG_PLAYLIST_INFO);
        if (info == null) {
            info = from;
        }
        return Playlist.create((PlaylistInfo) Parsers.parse(info, new PlaylistInfoParser()), status, syncTag);
    }
}
