package com.miui.player.asyncplayer;

import android.text.TextUtils;
import com.miui.player.meta.Audio.AudioLink;
import java.util.List;

public class RemoteMediaInfo {
    public final String mAppointName;
    public List<AudioLink> mCandidates;
    public final String mDetails;
    public final String mId;

    public RemoteMediaInfo(String id, String appointName, String details, List<AudioLink> candidateUrls) {
        this.mId = id;
        this.mAppointName = appointName;
        this.mDetails = details;
        this.mCandidates = candidateUrls;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mId) || TextUtils.isEmpty(this.mAppointName)) ? false : true;
    }
}
