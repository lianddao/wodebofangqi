package com.xiaomi.music.cloud.impl.command;

import android.accounts.Account;
import com.xiaomi.music.cloud.ComposableCommand;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.impl.CloudUrls;
import com.xiaomi.music.cloud.model.DeleteInfo;
import com.xiaomi.music.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

public class DeletePlaylistCommand extends ComposableCommand<DeleteInfo> {
    static final String TAG = "CloudCommand[DeletePlaylistCommand]";
    private final String mPlaylistCloudId;

    public DeletePlaylistCommand(Account account, MusicAuthToken token, String playlistCloudId) {
        super(account, token);
        this.mPlaylistCloudId = playlistCloudId;
    }

    protected JSONObject getParameters() throws JSONException {
        JSONObject params = new JSONObject();
        params.put("micloudId", this.mPlaylistCloudId);
        return params;
    }

    protected Parser<DeleteInfo, JSONObject> getParser() {
        return new DeleteParser();
    }

    protected String getPath() {
        return String.format(CloudUrls.URL_DELETE_PLAYLIST, new Object[]{this.mAccount.name, this.mPlaylistCloudId});
    }
}
