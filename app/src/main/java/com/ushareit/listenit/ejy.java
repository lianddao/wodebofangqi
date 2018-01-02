package com.ushareit.listenit;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ImageView.ScaleType;
import com.mopub.common.IntentActions;
import com.mopub.mobileads.VastVideoView;
import com.mopub.mobileads.VastVideoViewController;

public class ejy implements OnCompletionListener {
    final /* synthetic */ VastVideoView f11161a;
    final /* synthetic */ Context f11162b;
    final /* synthetic */ VastVideoViewController f11163c;

    public ejy(VastVideoViewController vastVideoViewController, VastVideoView vastVideoView, Context context) {
        this.f11163c = vastVideoViewController;
        this.f11161a = vastVideoView;
        this.f11162b = context;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f11163c.m2988s();
        this.f11163c.m3006k();
        this.f11163c.m2842b(false);
        this.f11163c.f2510x = true;
        if (this.f11163c.f2487a.isRewardedVideo()) {
            this.f11163c.m2839a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }
        if (!this.f11163c.f2511y && this.f11163c.f2487a.getRemainingProgressTrackerCount() == 0) {
            this.f11163c.f2487a.handleComplete(this.f11163c.m2848h(), this.f11163c.m3005j());
        }
        this.f11161a.setVisibility(4);
        this.f11163c.f2492f.setVisibility(8);
        if (!this.f11163c.f2484B) {
            this.f11163c.f2503q.setVisibility(8);
        } else if (this.f11163c.f2491e.getDrawable() != null) {
            this.f11163c.f2491e.setScaleType(ScaleType.CENTER_CROP);
            this.f11163c.f2491e.setVisibility(0);
        }
        this.f11163c.f2489c.m2944a();
        this.f11163c.f2490d.m2944a();
        this.f11163c.f2494h.m2942b();
        if (this.f11163c.f2496j != null) {
            if (this.f11162b.getResources().getConfiguration().orientation == 1) {
                this.f11163c.f2499m.setVisibility(0);
            } else {
                this.f11163c.f2498l.setVisibility(0);
            }
            this.f11163c.f2496j.m2906a(this.f11162b, this.f11163c.f2485C);
        } else if (this.f11163c.f2491e.getDrawable() != null) {
            this.f11163c.f2491e.setVisibility(0);
        }
    }
}
