package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.mopub.mobileads.resource.DrawableConstants.BlurredLastVideoFrame;

class hhc implements OnErrorListener {
    final /* synthetic */ hgy f15453a;

    hhc(hgy com_ushareit_listenit_hgy) {
        this.f15453a = com_ushareit_listenit_hgy;
    }

    @TargetApi(9)
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        boolean z = false;
        this.f15453a.f15438c = false;
        exw.m18457e("NativePlayer", "onError, what=" + i + ", extra=" + i2);
        boolean b = this.f15453a.f15444i;
        String b2 = !this.f15453a.f15444i ? hhh.m23860b(this.f15453a.f15439d) : "";
        if (this.f15453a.f15444i && hgg.m23704a(this.f15453a.f15439d)) {
            z = true;
        }
        hgf.m23693a(i, i2, b, b2, z);
        switch (i) {
            case BlurredLastVideoFrame.ALPHA /*100*/:
                synchronized (this.f15453a) {
                    if (this.f15453a.f15437b != null) {
                        this.f15453a.f15437b.release();
                    }
                    this.f15453a.f15437b = new MediaPlayer();
                    this.f15453a.f15437b.setWakeMode(this.f15453a.f15436a, this.f15453a.f15442g);
                    if (this.f15453a.m23849o()) {
                        this.f15453a.f15437b.setAudioSessionId(this.f15453a.f15440e);
                    }
                }
                break;
        }
        switch (i2) {
            case -107:
                break;
            default:
                hgy com_ushareit_listenit_hgy = this.f15453a;
                if (i2 != 0) {
                    i = i2;
                }
                com_ushareit_listenit_hgy.m23719c(i);
                break;
        }
        return true;
    }
}
