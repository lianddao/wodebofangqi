package com.xiaomi.music.cloud.impl.command;

import android.accounts.Account;
import com.xiaomi.music.cloud.ComposableCommand;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.impl.CloudUrls;
import com.xiaomi.music.cloud.model.PlayStatus;
import com.xiaomi.music.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadPlayStatusCommand extends ComposableCommand<Void> {
    static final String TAG = "CloudCommand[UploadPlayStatusCommand]";
    private final PlayStatus mStatus;

    public UploadPlayStatusCommand(Account account, MusicAuthToken token, PlayStatus status) {
        super(account, token);
        this.mStatus = status;
    }

    protected JSONObject getParameters() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("onlineId", this.mStatus.mOnlineId);
        obj.put("micloudId", this.mStatus.mCloudId);
        obj.put(CloudJsonTag.TAG_PLAY_POSITION, this.mStatus.mSeekPos);
        JSONObject params = new JSONObject();
        params.put(CloudJsonTag.TAG_INFO, obj);
        return params;
    }

    protected Parser<Void, JSONObject> getParser() {
        return null;
    }

    protected String getPath() {
        return String.format(CloudUrls.URL_UPLOAD_STATUS, new Object[]{this.mAccount.name});
    }
}
