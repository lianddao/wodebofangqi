package com.xiaomi.music.cloud.impl.command;

import android.accounts.Account;
import android.text.TextUtils;
import com.google.android.collect.Lists;
import com.xiaomi.music.Result;
import com.xiaomi.music.cloud.CloudCommand;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.MusicCloudServerException;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.impl.CloudParsers;
import com.xiaomi.music.cloud.impl.CloudUrls;
import com.xiaomi.music.cloud.impl.MusicCloudUtils;
import com.xiaomi.music.cloud.model.OperationList;
import com.xiaomi.music.util.MusicLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class GetOperationListCommand extends CloudCommand<OperationList> {
    private static final int MAX_LIMIT = 50;
    static final String TAG = "CloudCommand[GetOperationListCommand]";
    private final List<Long> mFilterTags = Lists.newArrayList();
    private final String mSyncExtraInfo;
    private final long mSyncTag;

    public GetOperationListCommand(Account account, MusicAuthToken token, long syncTag, String extra, List<Long> filterTags) {
        super(account, token);
        this.mSyncTag = syncTag;
        this.mSyncExtraInfo = extra;
        if (filterTags != null) {
            this.mFilterTags.addAll(filterTags);
        }
    }

    public Result<OperationList> execute() throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException {
        String url = String.format(CloudUrls.URL_FULL, new Object[]{this.mAccount.name});
        ArrayList<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair(CloudJsonTag.TAG_SYNC_TAG, String.valueOf(this.mSyncTag)));
        if (!TextUtils.isEmpty(this.mSyncExtraInfo)) {
            params.add(new BasicNameValuePair(CloudJsonTag.TAG_SYNC_EXTRA_TAG, this.mSyncExtraInfo));
        }
        params.add(new BasicNameValuePair(CloudJsonTag.TAG_LIMIT, String.valueOf(50)));
        String filterTags = getFilterTags();
        if (!TextUtils.isEmpty(filterTags)) {
            params.add(new BasicNameValuePair(CloudJsonTag.TAG_FILTER_TAGS, filterTags));
        }
        String str = MusicCloudUtils.postToCloud(url, params, this.mAccount, this.mToken);
        MusicLog.m399i(TAG, "Raw: " + str);
        Result<OperationList> result = CloudParsers.parse(new JSONObject(str), new OperationListParser());
        MusicLog.m399i(TAG, "Result: " + result);
        return result;
    }

    private String getFilterTags() {
        List<Long> tags = this.mFilterTags;
        if (tags == null || tags.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Long longValue : tags) {
            sb.append(longValue.longValue()).append(",");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }
}
