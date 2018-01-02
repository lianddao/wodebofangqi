package com.xiaomi.music.cloud.impl.command;

import android.accounts.Account;
import com.xiaomi.music.cloud.ComposableCommand;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.impl.CloudUrls;
import com.xiaomi.music.cloud.model.Track;
import com.xiaomi.music.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

public class AddTrackCommand extends ComposableCommand<Track> {
    static final String TAG = "CloudCommand[AddTrackCommand]";
    private final String mPlaylistCloudId;
    private final String mTrackOnlineId;

    public AddTrackCommand(Account account, MusicAuthToken token, String playlistCloudId, String trackOnlineId) {
        super(account, token);
        this.mPlaylistCloudId = playlistCloudId;
        this.mTrackOnlineId = trackOnlineId;
    }

    public Parser<Track, JSONObject> getParser() {
        return new AddTrackResultParser();
    }

    public String getPath() {
        return String.format(CloudUrls.URL_ADD_TRACK, new Object[]{this.mAccount.name});
    }

    public JSONObject getParameters() throws JSONException {
        JSONObject info = new JSONObject();
        info.put("onlineId", this.mTrackOnlineId);
        JSONObject params = new JSONObject();
        params.put(CloudJsonTag.TAG_INFO, info);
        params.put("micloudId", this.mPlaylistCloudId);
        return params;
    }
}
