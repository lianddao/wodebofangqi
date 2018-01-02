package com.xiaomi.music.online.impl.parser;

import com.miui.player.meta.MetaManager;
import com.xiaomi.music.online.model.Song;
import com.xiaomi.music.online.model.SongList;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import com.xiaomi.music.util.MusicLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SongListParser implements Parser<SongList, JSONObject> {
    private static final String TAG = "MusicListParser";
    SongParser mMusicParser = new SongParser();

    public static class SongParser implements Parser<Song, JSONObject> {
        private static final String KEY_ALBUM_NAME = "album_name";
        private static final String KEY_ARTIST_NAME = "artist_name";
        private static final String KEY_COMPOSE_NAME = "compose_name";
        private static final String KEY_COPY_TYPE = "copy_type";
        private static final String KEY_COUNTRY = "country";
        private static final String KEY_CP_ID = "cp_id";
        private static final String KEY_CP_SID = "cp_song_id";
        private static final String KEY_DURATION = "file_duration";
        private static final String KEY_LANGUAGE = "language";
        private static final String KEY_LYRICIST_NAME = "lyricist_name";
        private static final String KEY_NAME = "name";
        private static final String KEY_SID = "sid";

        public Song parse(JSONObject src) {
            Song song;
            String id = src.optString("sid", null);
            String cpId = src.optString(KEY_CP_ID, null);
            String cpSid = src.optString(KEY_CP_SID, null);
            String name = src.optString("name", null);
            if (id == null || cpId == null || cpSid == null || name == null) {
                song = null;
            } else {
                song = new Song(id, cpId, cpSid, name);
            }
            if (song != null) {
                song.mAlbumName = src.optString("album_name", null);
                song.mArtistName = src.optString("artist_name", null);
                song.mLyricistName = src.optString(KEY_LYRICIST_NAME, null);
                song.mComposeName = src.optString(KEY_COMPOSE_NAME, null);
                song.mDuration = src.optLong(KEY_DURATION);
                song.mLanguage = src.optString("language", null);
                song.mCountry = src.optString(KEY_COUNTRY, null);
                song.mCopyType = src.optString(KEY_COPY_TYPE, null);
            }
            return song;
        }
    }

    public SongList parse(JSONObject src) {
        List<Song> list = null;
        try {
            list = Parsers.parserArray(src.getJSONArray("list"), this.mMusicParser);
        } catch (JSONException e) {
            MusicLog.m398e(TAG, MetaManager.UNKNOWN_STRING, e);
        }
        return list != null ? new SongList(list) : null;
    }
}
