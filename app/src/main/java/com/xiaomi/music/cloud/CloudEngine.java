package com.xiaomi.music.cloud;

import android.accounts.Account;
import com.xiaomi.music.Result;
import com.xiaomi.music.cloud.model.DeleteInfo;
import com.xiaomi.music.cloud.model.OperationList;
import com.xiaomi.music.cloud.model.PlayQueue;
import com.xiaomi.music.cloud.model.PlayStatus;
import com.xiaomi.music.cloud.model.Playlist;
import com.xiaomi.music.cloud.model.PlaylistList;
import com.xiaomi.music.cloud.model.Track;
import com.xiaomi.music.cloud.model.TrackList;
import java.io.IOException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.json.JSONException;

public interface CloudEngine {
    public static final long INITIAL_SYNC_TAG = 0;
    public static final String INITIAL_SYNC_TAG_STR = null;

    CloudCommand<Track> addTrackToPlaylist(Account account, MusicAuthToken musicAuthToken, String str, String str2);

    <T> Result<T> apply(CloudCommand<T> cloudCommand) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException;

    <T> List<Result<T>> applyBatch(List<CloudCommand<T>> list) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException;

    CloudCommand<Playlist> createPlaylist(Account account, MusicAuthToken musicAuthToken, String str, int i, String str2, String str3);

    CloudCommand<DeleteInfo> deletePlaylist(Account account, MusicAuthToken musicAuthToken, String str);

    CloudCommand<DeleteInfo> deleteTrackFromPlaylist(Account account, MusicAuthToken musicAuthToken, String str, String str2);

    CloudCommand<PlayQueue> getNowplayingQueue(Account account, MusicAuthToken musicAuthToken);

    CloudCommand<PlayStatus> getNowplayingStatus(Account account, MusicAuthToken musicAuthToken);

    CloudCommand<OperationList> getOperationListByTag(Account account, MusicAuthToken musicAuthToken, long j, String str, List<Long> list) throws IllegalBlockSizeException, BadPaddingException, JSONException, IOException, MusicCloudServerException;

    CloudCommand<PlaylistList> getPlaylistList(Account account, MusicAuthToken musicAuthToken, String str, int i);

    CloudCommand<TrackList> getTrackList(Account account, MusicAuthToken musicAuthToken, String str, String str2, int i);

    CloudCommand<Void> uploadNowplayingQueue(Account account, MusicAuthToken musicAuthToken, PlayQueue playQueue);

    CloudCommand<Void> uploadNowplayingStatus(Account account, MusicAuthToken musicAuthToken, PlayStatus playStatus);
}
