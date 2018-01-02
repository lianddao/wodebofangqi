package com.xiaomi.music.cloud.impl.command;

import android.accounts.Account;
import com.xiaomi.music.cloud.ComposableCommand;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.impl.CloudUrls;
import com.xiaomi.music.cloud.model.DeleteInfo;
import com.xiaomi.music.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

public class DeleteTrackCommand extends ComposableCommand<DeleteInfo> {
    static final String TAG = "CloudCommand[DeleteTrackCommand]";
    private final String mPlaylistCloudId;
    private final String mTrackCloudId;

    public DeleteTrackCommand(Account account, MusicAuthToken token, String playlistCloudId, String trackCloudId) {
        super(account, token);
        this.mPlaylistCloudId = playlistCloudId;
        this.mTrackCloudId = trackCloudId;
    }

    protected JSONObject getParameters() throws JSONException {
        JSONObject params = new JSONObject();
        params.put("micloudId", this.mTrackCloudId);
        return params;
    }

    protected Parser<DeleteInfo, JSONObject> getParser() {
        return new DeleteParser();
    }

    protected String getPath() {
        return String.format(CloudUrls.URL_DELETE_TRACK, new Object[]{this.mAccount.name, this.mTrackCloudId});
    }
}
