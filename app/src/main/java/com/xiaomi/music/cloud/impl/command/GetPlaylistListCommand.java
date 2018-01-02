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
import com.xiaomi.music.cloud.impl.MusicCloudUtils.RepeatCommand;
import com.xiaomi.music.cloud.model.Playlist;
import com.xiaomi.music.cloud.model.PlaylistList;
import com.xiaomi.music.util.MusicLog;
import java.io.IOException;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class GetPlaylistListCommand extends CloudCommand<PlaylistList> {
    private static final int MAX_LIMIT_ONCE = 50;
    static final String TAG = "CloudCommand[GetPlaylistsCommand]";
    private final int mLimit;
    private final String mTag;

    class C05391 implements RepeatCommand<Playlist, PlaylistList> {
        C05391() {
        }

        public Result<PlaylistList> requestOnce(String url, String tag, int limit) throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException {
            return GetPlaylistListCommand.this.requestInternal(url, tag, limit);
        }
    }

    public GetPlaylistListCommand(Account account, MusicAuthToken token, String tag, int limit) {
        super(account, token);
        this.mTag = tag;
        this.mLimit = limit;
    }

    public Result<PlaylistList> execute() throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException {
        return MusicCloudUtils.repeatRequest(String.format(CloudUrls.URL_GET_PLAYLISTS, new Object[]{this.mAccount.name}), new C05391(), this.mTag, this.mLimit, 50);
    }

    Result<PlaylistList> requestInternal(String url, String tag, int limit) throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException {
        ArrayList<NameValuePair> params = Lists.newArrayList();
        if (!TextUtils.isEmpty(tag)) {
            params.add(new BasicNameValuePair(CloudJsonTag.TAG_SYNC_TAG, tag));
        }
        params.add(new BasicNameValuePair(CloudJsonTag.TAG_LIMIT, String.valueOf(limit)));
        String str = MusicCloudUtils.getFromCloud(url, params, this.mAccount, this.mToken);
        MusicLog.m399i(TAG, "Raw: " + str);
        Result<PlaylistList> result = CloudParsers.parse(new JSONObject(str), new PlaylistListParser());
        MusicLog.m399i(TAG, "Result: " + result);
        return result;
    }
}
