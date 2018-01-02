package com.miui.player.asyncplayer;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import java.util.List;

public interface IPlayerHelper {
    Uri getLocalUriToPlay(String str);

    RemoteMediaInfo getRemoteMediaInfo(Context context, String str);

    boolean isOnlineAudio(String str);

    boolean isValidGlobalId(String str);

    Pair<AudioDetail, List<AudioLink>> requestAudioDetail(Context context, String str);
}
