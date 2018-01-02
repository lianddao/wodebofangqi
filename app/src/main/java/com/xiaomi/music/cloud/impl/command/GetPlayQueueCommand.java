package com.xiaomi.music.cloud.impl.command;

import android.accounts.Account;
import com.xiaomi.music.Result;
import com.xiaomi.music.cloud.CloudCommand;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.MusicCloudServerException;
import com.xiaomi.music.cloud.impl.CloudParsers;
import com.xiaomi.music.cloud.impl.CloudUrls;
import com.xiaomi.music.cloud.impl.MusicCloudUtils;
import com.xiaomi.music.cloud.model.PlayQueue;
import com.xiaomi.music.util.MusicLog;
import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.json.JSONException;
import org.json.JSONObject;

public class GetPlayQueueCommand extends CloudCommand<PlayQueue> {
    static final String TAG = "CloudCommand[GetPlayQueueCommand]";

    public GetPlayQueueCommand(Account account, MusicAuthToken token) {
        super(account, token);
    }

    public Result<PlayQueue> execute() throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException {
        String str = MusicCloudUtils.getFromCloud(String.format(CloudUrls.URL_GET_QUEUE, new Object[]{this.mAccount.name}), null, this.mAccount, this.mToken);
        MusicLog.m399i(TAG, "Raw: " + str);
        Result<PlayQueue> result = CloudParsers.parse(new JSONObject(str), new GetPlayQueueParser());
        MusicLog.m399i(TAG, "Result: " + result);
        return result;
    }
}
