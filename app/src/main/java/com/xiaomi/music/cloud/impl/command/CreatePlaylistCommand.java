package com.xiaomi.music.cloud.impl.command;

import android.accounts.Account;
import android.text.TextUtils;
import com.xiaomi.music.cloud.ComposableCommand;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.impl.CloudUrls;
import com.xiaomi.music.cloud.model.Playlist;
import com.xiaomi.music.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

public class CreatePlaylistCommand extends ComposableCommand<Playlist> {
    static final String TAG = "CloudCommand[CreatePlayList]";
    private final String mName;
    private final String mPlaylistCloudId;
    private final String mPlaylistOnlineId;
    private final int mType;

    public CreatePlaylistCommand(Account account, MusicAuthToken token, String name, int type, String playlistCloudId, String playlistOnlineId) {
        super(account, token);
        this.mName = name;
        this.mType = type;
        this.mPlaylistCloudId = playlistCloudId;
        this.mPlaylistOnlineId = playlistOnlineId;
    }

    protected JSONObject getParameters() throws JSONException {
        JSONObject info = new JSONObject();
        info.put("name", this.mName);
        info.put(CloudJsonTag.TAG_CREATE_TIME, System.currentTimeMillis());
        info.put("type", this.mType);
        if (!TextUtils.isEmpty(this.mPlaylistOnlineId)) {
            info.put("onlineId", this.mPlaylistOnlineId);
        }
        JSONObject params = new JSONObject();
        params.put(CloudJsonTag.TAG_INFO, info);
        return params;
    }

    protected Parser<Playlist, JSONObject> getParser() {
        return new CreatePlaylistResultParser();
    }

    protected String getPath() {
        return String.format(CloudUrls.URL_CREATE_PLAYLIST, new Object[]{this.mAccount.name});
    }
}
