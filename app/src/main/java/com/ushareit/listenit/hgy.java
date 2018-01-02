package com.ushareit.listenit;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.concurrent.atomic.AtomicBoolean;

public class hgy extends hgs {
    private Context f15436a;
    private MediaPlayer f15437b;
    private boolean f15438c;
    private String f15439d;
    private int f15440e;
    private float f15441f;
    private int f15442g;
    private hhd f15443h;
    private boolean f15444i;
    private boolean f15445j;
    private OnCompletionListener f15446k;
    private OnBufferingUpdateListener f15447l;
    private OnErrorListener f15448m;

    public hgy(Context context) {
        this(context, 1);
    }

    public hgy(Context context, int i) {
        this.f15438c = false;
        this.f15440e = 0;
        this.f15441f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f15444i = false;
        this.f15445j = false;
        this.f15446k = new hha(this);
        this.f15447l = new hhb(this);
        this.f15448m = new hhc(this);
        this.f15436a = context;
        this.f15442g = i;
        this.f15441f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f15437b = new MediaPlayer();
        this.f15437b.setVolume(this.f15441f, this.f15441f);
        this.f15437b.setWakeMode(context, this.f15442g);
        this.f15440e = mo2773d();
        this.f15443h = new hhd();
    }

    public synchronized boolean mo2770a() {
        return this.f15438c;
    }

    public synchronized boolean mo2771b() {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            if (!this.f15444i || hgg.m23704a(this.f15439d)) {
                if (!(this.f15437b != null && this.f15438c && this.f15437b.isPlaying())) {
                    z = false;
                }
                z2 = z;
            } else if (this.f15443h.m23854b() || (this.f15438c && this.f15437b.isPlaying())) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean mo2772c() {
        return this.f15445j;
    }

    public void mo2768a(String str) {
        this.f15438c = false;
        this.f15438c = m23818a(this.f15437b, str);
    }

    private boolean m23818a(MediaPlayer mediaPlayer, String str) {
        OnBufferingUpdateListener onBufferingUpdateListener = null;
        if (mediaPlayer == null) {
            return false;
        }
        this.f15439d = str;
        m23833s();
        this.f15444i = hhh.m23859a(str);
        this.f15445j = this.f15444i;
        try {
            mediaPlayer.setWakeMode(this.f15436a, this.f15442g);
            mediaPlayer.reset();
            mediaPlayer.setOnCompletionListener(this.f15446k);
            mediaPlayer.setOnErrorListener(this.f15448m);
            if (this.f15444i) {
                onBufferingUpdateListener = this.f15447l;
            }
            mediaPlayer.setOnBufferingUpdateListener(onBufferingUpdateListener);
            mediaPlayer.setAudioStreamType(3);
            if (str.startsWith("content://")) {
                mediaPlayer.setDataSource(this.f15436a, Uri.parse(str));
                m23823d(0);
            } else if (this.f15444i && mo2782m()) {
                boolean a = hgg.m23704a(str);
                if (!a) {
                    m23830p();
                }
                m23823d(a ? 100 : 0);
                mediaPlayer.setDataSource(hgg.m23706b(str));
            } else {
                mediaPlayer.setDataSource(str);
                m23823d(0);
            }
            if (this.f15444i) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                mediaPlayer.setOnPreparedListener(new hgz(this, atomicBoolean));
                mediaPlayer.prepareAsync();
                synchronized (atomicBoolean) {
                    if (Thread.currentThread().isInterrupted() || !(hhh.m23858a() || hgg.m23704a(this.f15439d))) {
                        throw new InterruptedException();
                    }
                    atomicBoolean.wait();
                }
                m23831q();
            } else {
                mediaPlayer.setOnPreparedListener(null);
                mediaPlayer.prepare();
            }
            this.f15445j = false;
            String str2 = this.f15439d;
            if (fbb.m18763c(str2) || !str2.equals(str) || this.f15437b.getDuration() <= 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            this.f15445j = false;
        }
    }

    public int mo2773d() {
        return (this.f15437b == null || !m23849o()) ? this.f15440e : this.f15437b.getAudioSessionId();
    }

    public synchronized void mo2774e() {
        if (this.f15437b != null && this.f15438c) {
            this.f15437b.start();
            if (this.f15444i && !fbb.m18763c(this.f15439d) && mo2782m() && !hgg.m23704a(this.f15439d)) {
                m23832r();
            }
            boolean z = this.f15444i;
            boolean z2 = this.f15444i && mo2782m() && hgg.m23704a(this.f15439d);
            hgf.m23699b(z, z2);
        }
    }

    public synchronized void mo2775f() {
        if (this.f15437b != null && this.f15438c) {
            this.f15437b.pause();
        }
        if (this.f15437b != null && this.f15444i) {
            m23831q();
        }
    }

    public synchronized void mo2776g() {
        if (this.f15437b != null) {
            this.f15438c = false;
            m23833s();
            this.f15437b.reset();
            this.f15437b.release();
            this.f15437b = null;
            hgg.m23703a();
        }
    }

    public synchronized void mo2763a(float f) {
        this.f15441f = f;
        if (this.f15437b != null && this.f15438c) {
            this.f15437b.setVolume(f, f);
        }
    }

    public float mo2777h() {
        return this.f15441f;
    }

    public synchronized void mo2764a(int i) {
        if (this.f15437b != null && this.f15438c) {
            this.f15437b.seekTo(i);
            this.f15437b.setVolume(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
    }

    public String mo2780k() {
        return this.f15439d;
    }

    public synchronized int mo2778i() {
        int currentPosition;
        currentPosition = (this.f15437b == null || !this.f15438c) ? 0 : this.f15437b.getCurrentPosition();
        return currentPosition;
    }

    public synchronized int mo2779j() {
        int duration;
        duration = (this.f15437b == null || !this.f15438c) ? MoPubClientPositioning.NO_REPEAT : this.f15437b.getDuration();
        return duration;
    }

    public boolean m23849o() {
        return VERSION.SDK_INT >= 9;
    }

    public boolean mo2781l() {
        return this.f15443h.m23854b();
    }

    private void m23823d(int i) {
        Message obtainMessage = this.f15443h.obtainMessage(3);
        obtainMessage.arg1 = i;
        this.f15443h.sendMessage(obtainMessage);
    }

    private void m23830p() {
        this.f15443h.removeCallbacksAndMessages(null);
        this.f15443h.sendMessage(this.f15443h.obtainMessage(0));
    }

    private void m23831q() {
        this.f15443h.removeCallbacksAndMessages(null);
        this.f15443h.sendMessage(this.f15443h.obtainMessage(1));
    }

    private void m23832r() {
        this.f15443h.removeCallbacksAndMessages(null);
        this.f15443h.sendMessageDelayed(this.f15443h.obtainMessage(2), 500);
    }

    private void m23833s() {
        this.f15443h.removeCallbacksAndMessages(null);
        this.f15443h.m23853a();
    }
}
