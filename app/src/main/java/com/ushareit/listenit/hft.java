package com.ushareit.listenit;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.widget.WheelProgress;
import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerView;

public class hft extends hfb implements hfs {
    private final Runnable f15358A = new hfx(this);
    protected final View f15359a;
    protected OnClickListener f15360b = new hga(this);
    protected OnClickListener f15361c = new hgb(this);
    protected OnClickListener f15362d = new hgc(this);
    protected OnSeekBarChangeListener f15363e = new hgd(this);
    protected OnClickListener f15364f = new hfv(this);
    private Handler f15365g = new Handler();
    private final YouTubePlayerView f15366h;
    private final View f15367i;
    private final ImageView f15368j;
    private final TextView f15369k;
    private final TextView f15370l;
    private final WheelProgress f15371m;
    private final ImageView f15372n;
    private final ImageView f15373o;
    private final ImageView f15374p;
    private final View f15375q;
    private final TextView f15376r;
    private final SeekBar f15377s;
    private boolean f15378t = false;
    private boolean f15379u = false;
    private boolean f15380v = false;
    private boolean f15381w = false;
    private boolean f15382x = false;
    private String f15383y;
    private final Handler f15384z = new Handler(Looper.getMainLooper());

    public hft(YouTubePlayerView youTubePlayerView, View view) {
        this.f15366h = youTubePlayerView;
        this.f15359a = view.findViewById(C0349R.id.event_interrupt_layer);
        this.f15368j = (ImageView) view.findViewById(C0349R.id.thumbnail_image_layer);
        this.f15371m = (WheelProgress) view.findViewById(C0349R.id.loading_progress);
        this.f15367i = view.findViewById(C0349R.id.control_button_layer);
        this.f15375q = view.findViewById(C0349R.id.fullscreen_button_back);
        this.f15376r = (TextView) view.findViewById(C0349R.id.fullscreen_button_title);
        this.f15369k = (TextView) view.findViewById(C0349R.id.video_current_time);
        this.f15370l = (TextView) view.findViewById(C0349R.id.video_duration);
        this.f15372n = (ImageView) view.findViewById(C0349R.id.play_button);
        this.f15373o = (ImageView) view.findViewById(C0349R.id.youtube_button);
        this.f15374p = (ImageView) view.findViewById(C0349R.id.fullscreen_button);
        this.f15377s = (SeekBar) view.findViewById(C0349R.id.seek_bar);
        this.f15377s.setOnSeekBarChangeListener(this.f15363e);
        this.f15375q.setOnClickListener(this.f15364f);
        this.f15372n.setOnClickListener(this.f15362d);
        this.f15374p.setOnClickListener(this.f15360b);
        this.f15359a.setOnClickListener(this.f15361c);
    }

    public void m23678a(Drawable drawable, String str) {
        exw.m18454c("Video Player", "initialize");
        this.f15368j.setImageDrawable(drawable);
        this.f15368j.setVisibility(0);
        this.f15371m.setVisibility(0);
        this.f15376r.setText(str);
        this.f15381w = false;
        fij.m19337h();
    }

    private void m23662a(boolean z) {
        int i;
        this.f15378t = z;
        if (this.f15378t) {
            i = C0349R.drawable.player_video_button_pause_bg;
        } else {
            i = C0349R.drawable.player_video_button_play_bg;
        }
        this.f15372n.setImageResource(i);
    }

    public void m23681d() {
        this.f15367i.setVisibility(8);
        this.f15379u = false;
    }

    public void m23683e() {
        this.f15367i.setVisibility(0);
        this.f15379u = true;
    }

    public void m23685f() {
        if (this.f15381w) {
            if (this.f15378t) {
                m23673i();
            } else {
                this.f15384z.removeCallbacks(this.f15358A);
            }
            erl.m17583a(this.f15367i).mo2278e(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT).mo2272a(300).mo2274a(new hfu(this));
        }
    }

    public void m23686g() {
        exw.m18454c("Video Player", "onActivityStart()");
        this.f15368j.setVisibility(0);
        this.f15382x = true;
        m23662a(false);
        this.f15372n.setVisibility(0);
        this.f15371m.setVisibility(4);
        erj.m17570a(this.f15367i, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        m23683e();
    }

    public void m23687h() {
        this.f15384z.removeCallbacks(this.f15358A);
        erl.m17583a(this.f15367i).mo2278e(0.0f).mo2272a(300).mo2274a(new hfw(this));
    }

    private void m23673i() {
        this.f15384z.postDelayed(this.f15358A, 3000);
    }

    public void g_() {
        this.f15374p.setImageResource(C0349R.drawable.video_button_small_screen_bg);
        this.f15375q.setVisibility(0);
        this.f15376r.setVisibility(0);
    }

    public void mo2592b() {
        this.f15374p.setImageResource(C0349R.drawable.video_button_full_screen_bg);
        this.f15375q.setVisibility(4);
        this.f15376r.setVisibility(4);
    }

    public void mo2585a(int i) {
        switch (i) {
            case -1:
                exw.m18454c("Video Player", "State.UNSTARTED");
                m23662a(false);
                this.f15372n.setVisibility(0);
                return;
            case 0:
                exw.m18454c("Video Player", "State.ENDED");
                m23662a(false);
                m23685f();
                this.f15368j.setVisibility(0);
                this.f15384z.removeCallbacks(this.f15358A);
                return;
            case 1:
                exw.m18454c("Video Player", "State.PLAYING");
                this.f15381w = true;
                this.f15371m.setVisibility(8);
                this.f15368j.setVisibility(8);
                m23662a(true);
                this.f15372n.setVisibility(0);
                return;
            case 2:
                exw.m18454c("Video Player", "State.PAUSED mIsShowThumbnailWhenPause:" + this.f15382x);
                this.f15371m.setVisibility(8);
                ((Activity) this.f15371m.getContext()).getWindow().clearFlags(128);
                if (!this.f15382x) {
                    this.f15368j.setVisibility(8);
                    m23662a(false);
                    m23685f();
                    this.f15372n.setVisibility(0);
                    this.f15384z.removeCallbacks(this.f15358A);
                    return;
                }
                return;
            case 3:
                exw.m18454c("Video Player", "State.BUFFERING");
                if (!this.f15382x) {
                    this.f15372n.setVisibility(4);
                    return;
                }
                return;
            default:
                exw.m18454c("Video Player", "State.VIDEO_CUED");
                return;
        }
    }

    public void mo2584a(float f, float f2) {
        if (!this.f15380v) {
            this.f15377s.setProgress((int) f);
            this.f15377s.setSecondaryProgress((int) (((float) this.f15377s.getMax()) * f2));
        }
    }

    public void mo2583a(float f) {
        this.f15370l.setText(gyn.m23180a(f));
        this.f15377s.setMax((int) f);
    }

    public void mo2586a(String str) {
        if (!TextUtils.isEmpty(this.f15383y)) {
            str = str + "_" + this.f15383y;
        }
        fij.m19333d(str);
    }

    public void mo2591d(String str) {
        this.f15373o.setOnClickListener(new hfy(this, str));
    }

    public void m23684e(String str) {
        this.f15383y = str;
        this.f15365g.post(new hfz(this));
    }
}
