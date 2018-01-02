package com.ushareit.listenit;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.mopub.mraid.MraidVideoViewController;

public class ely implements OnCompletionListener {
    final /* synthetic */ MraidVideoViewController f11239a;

    public ely(MraidVideoViewController mraidVideoViewController) {
        this.f11239a = mraidVideoViewController;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f11239a.f2603b.setVisibility(0);
        this.f11239a.m2842b(true);
    }
}
