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
import com.xiaomi.music.cloud.model.Track;
import com.xiaomi.music.cloud.model.TrackList;
import com.xiaomi.music.util.MusicLog;
import java.io.IOException;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class GetTrackListCommand extends CloudCommand<TrackList> {
    private static final int MAX_LIMIT_ONCE = 50;
    static final String TAG = "CloudCommand[GetTrackListCommand]";
    private final int mLimit;
    private final String mPlaylistCloudId;
    private final String mTag;

    class C05401 implements RepeatCommand<Track, TrackList> {
        C05401() {
        }

        public Result<TrackList> requestOnce(String url, String tag, int limit) throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException {
            return GetTrackListCommand.this.requestInternal(url, tag, limit);
        }
    }

    public GetTrackListCommand(Account account, MusicAuthToken token, String playlistCloudId, String tag, int limit) {
        super(account, token);
        this.mPlaylistCloudId = playlistCloudId;
        this.mTag = tag;
        this.mLimit = limit;
    }

    public Result<TrackList> execute() throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException {
        return MusicCloudUtils.repeatRequest(String.format(CloudUrls.URL_GET_TRACKS, new Object[]{this.mAccount.name, this.mPlaylistCloudId}), new C05401(), this.mTag, this.mLimit, 50);
    }

    Result<TrackList> requestInternal(String url, String tag, int limit) throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException {
        ArrayList<NameValuePair> params = Lists.newArrayList();
        if (!TextUtils.isEmpty(tag)) {
            params.add(new BasicNameValuePair(CloudJsonTag.TAG_SYNC_TAG, tag));
        }
        params.add(new BasicNameValuePair("micloudId", this.mPlaylistCloudId));
        params.add(new BasicNameValuePair(CloudJsonTag.TAG_LIMIT, String.valueOf(limit)));
        String str = MusicCloudUtils.getFromCloud(url, params, this.mAccount, this.mToken);
        MusicLog.m399i(TAG, "Raw: " + str);
        Result<TrackList> result = CloudParsers.parse(new JSONObject(str), new TrackListParser());
        MusicLog.m399i(TAG, "Result: " + result);
        return result;
    }
}
