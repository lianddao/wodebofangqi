package com.xiaomi.music.cloud.impl;

import android.accounts.Account;
import android.content.Context;
import com.google.android.collect.Lists;
import com.xiaomi.music.Result;
import com.xiaomi.music.cloud.CloudCommand;
import com.xiaomi.music.cloud.CloudEngine;
import com.xiaomi.music.cloud.ComposableCommand;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.MusicCloudServerException;
import com.xiaomi.music.cloud.impl.command.AddTrackCommand;
import com.xiaomi.music.cloud.impl.command.CreatePlaylistCommand;
import com.xiaomi.music.cloud.impl.command.DeletePlaylistCommand;
import com.xiaomi.music.cloud.impl.command.DeleteTrackCommand;
import com.xiaomi.music.cloud.impl.command.GetOperationListCommand;
import com.xiaomi.music.cloud.impl.command.GetPlayQueueCommand;
import com.xiaomi.music.cloud.impl.command.GetPlayStatusCommand;
import com.xiaomi.music.cloud.impl.command.GetPlaylistListCommand;
import com.xiaomi.music.cloud.impl.command.GetTrackListCommand;
import com.xiaomi.music.cloud.impl.command.UploadPlayQueueCommand;
import com.xiaomi.music.cloud.impl.command.UploadPlayStatusCommand;
import com.xiaomi.music.cloud.model.DeleteInfo;
import com.xiaomi.music.cloud.model.OperationList;
import com.xiaomi.music.cloud.model.PlayQueue;
import com.xiaomi.music.cloud.model.PlayStatus;
import com.xiaomi.music.cloud.model.Playlist;
import com.xiaomi.music.cloud.model.PlaylistList;
import com.xiaomi.music.cloud.model.Track;
import com.xiaomi.music.cloud.model.TrackList;
import com.xiaomi.music.util.MusicLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudEngineImpl implements CloudEngine {
    static final String TAG = "CloudManagerImpl";

    public CloudEngineImpl(Context context, JSONObject config) {
    }

    public CloudCommand<Playlist> createPlaylist(Account account, MusicAuthToken token, String name, int type, String playlistCloudId, String playlistOnlineId) {
        return new CreatePlaylistCommand(account, token, name, type, playlistCloudId, playlistOnlineId);
    }

    public CloudCommand<DeleteInfo> deletePlaylist(Account account, MusicAuthToken token, String playlistCloudId) {
        return new DeletePlaylistCommand(account, token, playlistCloudId);
    }

    public CloudCommand<PlaylistList> getPlaylistList(Account account, MusicAuthToken token, String tag, int limit) {
        return new GetPlaylistListCommand(account, token, tag, limit);
    }

    public CloudCommand<TrackList> getTrackList(Account account, MusicAuthToken token, String playlistCloudId, String tag, int limit) {
        return new GetTrackListCommand(account, token, playlistCloudId, tag, limit);
    }

    public CloudCommand<Track> addTrackToPlaylist(Account account, MusicAuthToken token, String playlistCloudId, String trackOnlineId) {
        return new AddTrackCommand(account, token, playlistCloudId, trackOnlineId);
    }

    public CloudCommand<DeleteInfo> deleteTrackFromPlaylist(Account account, MusicAuthToken token, String playlistCloudId, String trackCloudId) {
        return new DeleteTrackCommand(account, token, playlistCloudId, trackCloudId);
    }

    public CloudCommand<Void> uploadNowplayingStatus(Account account, MusicAuthToken token, PlayStatus status) {
        return new UploadPlayStatusCommand(account, token, status);
    }

    public CloudCommand<PlayStatus> getNowplayingStatus(Account account, MusicAuthToken token) {
        return new GetPlayStatusCommand(account, token);
    }

    public CloudCommand<PlayQueue> getNowplayingQueue(Account account, MusicAuthToken token) {
        return new GetPlayQueueCommand(account, token);
    }

    public CloudCommand<Void> uploadNowplayingQueue(Account account, MusicAuthToken token, PlayQueue queue) {
        return new UploadPlayQueueCommand(account, token, queue);
    }

    public CloudCommand<OperationList> getOperationListByTag(Account account, MusicAuthToken token, long syncTag, String syncExtraInfo, List<Long> filterTags) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException {
        return new GetOperationListCommand(account, token, syncTag, syncExtraInfo, filterTags);
    }

    public <T> Result<T> apply(CloudCommand<T> cmd) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException {
        return cmd.execute();
    }

    public <T> List<Result<T>> applyBatch(List<CloudCommand<T>> list) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException {
        List<Result<T>> result = Lists.newArrayList();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                result.add(((CloudCommand) list.get(0)).execute());
            } else {
                CloudCommand<T> first = (CloudCommand) list.get(0);
                Account account = first.getAccount();
                MusicAuthToken token = first.getToken();
                List<ComposableCommand<T>> batch = Lists.newArrayList();
                for (CloudCommand<T> cc : list) {
                    boolean isComposable = cc instanceof ComposableCommand;
                    if (!isComposable || batch.size() == 10) {
                        result.addAll(requestCloud(account, token, batch));
                        batch.clear();
                    }
                    if (isComposable) {
                        batch.add((ComposableCommand) cc);
                    } else {
                        result.add(cc.execute());
                    }
                }
                if (!batch.isEmpty()) {
                    result.addAll(requestCloud(account, token, batch));
                    batch.clear();
                }
            }
        }
        return result;
    }

    private <T> List<Result<T>> requestCloud(Account account, MusicAuthToken token, List<ComposableCommand<T>> batch) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException {
        List<Result<T>> result = Lists.newArrayList();
        if (!batch.isEmpty()) {
            if (batch.size() == 1) {
                result.add(((ComposableCommand) batch.get(0)).execute());
            } else {
                JSONArray array = new JSONArray();
                for (ComposableCommand<T> cc : batch) {
                    array.put(cc.toJSONObject());
                }
                String url = String.format(CloudUrls.URL_BATCH_POST, new Object[]{account.name});
                ArrayList<NameValuePair> params = Lists.newArrayList();
                params.add(new BasicNameValuePair(CloudJsonTag.TAG_BATCH_CONTENT, array.toString()));
                String str = MusicCloudUtils.postToCloud(url, params, account, token);
                MusicLog.m395d(TAG, "Raw: " + str);
                Result<List<Result<T>>> batchResult = CloudParsers.parse(new JSONObject(str), new BatchResultParser(batch));
                MusicLog.m395d(TAG, "Result: " + batchResult);
                if (batchResult.mErrorCode == 0 && batchResult.mData != null) {
                    result.addAll((Collection) batchResult.mData);
                } else if (batchResult.mErrorCode != 0) {
                    int err = batchResult.mErrorCode;
                    for (ComposableCommand<T> c : batch) {
                        result.add(c.createError(err));
                    }
                } else if (batchResult.mData == null || ((List) batchResult.mData).size() != batch.size()) {
                    throw new JSONException("Batch request error, batch size=" + batch.size() + ", result size=" + ((List) batchResult.mData).size());
                }
            }
        }
        return result;
    }
}
