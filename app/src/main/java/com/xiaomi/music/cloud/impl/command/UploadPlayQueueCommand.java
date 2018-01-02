package com.xiaomi.music.cloud.impl.command;

import android.accounts.Account;
import android.text.TextUtils;
import com.xiaomi.music.cloud.ComposableCommand;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.impl.CloudUrls;
import com.xiaomi.music.cloud.model.PlayQueue;
import com.xiaomi.music.parser.Parser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadPlayQueueCommand extends ComposableCommand<Void> {
    static final String TAG = "CloudCommand[UploadPlayQueueCommand]";
    private final PlayQueue mQueue;

    public UploadPlayQueueCommand(Account account, MusicAuthToken token, PlayQueue queue) {
        super(account, token);
        this.mQueue = queue;
    }

    protected JSONObject getParameters() throws JSONException {
        JSONArray list = new JSONArray();
        for (String i : this.mQueue.getQueue()) {
            if (!TextUtils.isEmpty(i)) {
                list.put(i);
            }
        }
        JSONObject obj = new JSONObject();
        obj.put("list", list);
        JSONObject params = new JSONObject();
        params.put(CloudJsonTag.TAG_INFO, obj);
        return params;
    }

    protected Parser<Void, JSONObject> getParser() {
        return null;
    }

    protected String getPath() {
        return String.format(CloudUrls.URL_UPLOAD_QUEUE, new Object[]{this.mAccount.name});
    }
}
