package com.ushareit.listenit;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.mopub.mobileads.VastErrorCode;
import com.mopub.mobileads.VastVideoView;
import com.mopub.mobileads.VastVideoViewController;

public class ejz implements OnErrorListener {
    final /* synthetic */ VastVideoView f11164a;
    final /* synthetic */ VastVideoViewController f11165b;

    public ejz(VastVideoViewController vastVideoViewController, VastVideoView vastVideoView) {
        this.f11165b = vastVideoViewController;
        this.f11164a = vastVideoView;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.f11164a.m2950a(mediaPlayer, i, i2, this.f11165b.f2487a.getDiskMediaFileUrl())) {
            return true;
        }
        this.f11165b.m2988s();
        this.f11165b.m3006k();
        this.f11165b.m2840a(false);
        this.f11165b.f2511y = true;
        this.f11165b.f2487a.handleError(this.f11165b.m2848h(), VastErrorCode.GENERAL_LINEAR_AD_ERROR, this.f11165b.m3005j());
        return false;
    }
}
