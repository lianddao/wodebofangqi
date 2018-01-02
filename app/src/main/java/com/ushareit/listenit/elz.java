package com.ushareit.listenit;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.mopub.mraid.MraidVideoViewController;

public class elz implements OnErrorListener {
    final /* synthetic */ MraidVideoViewController f11240a;

    public elz(MraidVideoViewController mraidVideoViewController) {
        this.f11240a = mraidVideoViewController;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f11240a.f2603b.setVisibility(0);
        this.f11240a.m2840a(false);
        return false;
    }
}
