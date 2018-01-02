package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.audiofx.LoudnessEnhancer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.widget.PopupWindow.OnDismissListener;
import com.ushareit.listenit.equalizer.VolumeControlView;

public class fus {
    private VolumeControlView f13536a;
    private hic f13537b;
    private LoudnessEnhancer f13538c;
    private BroadcastReceiver f13539d;
    private Context f13540e;
    private int f13541f;
    private Handler f13542g;
    private OnDismissListener f13543h;
    private fur f13544i;
    private fuq f13545j;

    private fus() {
        this.f13538c = null;
        this.f13541f = 0;
        this.f13542g = new fuv(this, Looper.getMainLooper());
        this.f13543h = new fuw(this);
        this.f13544i = new fux(this);
        this.f13545j = new fuy(this);
    }

    public static fus m21026a() {
        return fuz.f13554a;
    }

    public void m21044b() {
        if (this.f13537b != null && this.f13537b.m23891b()) {
            this.f13537b.m23886a();
        }
    }

    public boolean m21043a(int i, ak akVar, gum com_ushareit_listenit_gum) {
        if (com_ushareit_listenit_gum == null || ((i != 24 && i != 25) || !gvk.m23058f() || m21041a(com_ushareit_listenit_gum) == null)) {
            return false;
        }
        if (this.f13536a == null) {
            m21030a(akVar, m21041a(com_ushareit_listenit_gum));
        }
        m21038d();
        AudioManager audioManager = (AudioManager) akVar.getSystemService("audio");
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        if (streamVolume <= this.f13541f || streamVolume != streamMaxVolume || i != 24 || gvj.m22961g() || gvj.m22969h()) {
            this.f13541f = streamVolume;
            return this.f13536a.m17544a(i, (Context) akVar);
        }
        m21029a(akVar);
        return true;
    }

    public synchronized LoudnessEnhancer m21041a(gum com_ushareit_listenit_gum) {
        LoudnessEnhancer loudnessEnhancer;
        if (this.f13538c != null) {
            loudnessEnhancer = this.f13538c;
        } else {
            if (VERSION.SDK_INT >= 19) {
                try {
                    this.f13538c = new LoudnessEnhancer(com_ushareit_listenit_gum.mo2459p());
                } catch (Throwable th) {
                    if (this.f13538c != null) {
                        this.f13538c.release();
                        this.f13538c = null;
                    }
                }
            }
            loudnessEnhancer = this.f13538c;
        }
        return loudnessEnhancer;
    }

    public static void m21028a(Context context, gum com_ushareit_listenit_gum) {
        boolean z = false;
        String str = "dfs";
        StringBuilder append = new StringBuilder().append("checkAndDisableVolumeBooster, playserc=");
        if (com_ushareit_listenit_gum != null) {
            z = true;
        }
        exw.m18457e(str, append.append(z).toString());
        if (com_ushareit_listenit_gum != null && context != null && VERSION.SDK_INT >= 19) {
            LoudnessEnhancer a = m21026a().m21041a(com_ushareit_listenit_gum);
            if (a != null) {
                try {
                    if (a.getEnabled()) {
                        a.setTargetGain(0);
                        a.setEnabled(false);
                    }
                } catch (Throwable e) {
                    exw.m18450b("VolumeChangedReceiver", "volume changed receiver has an error.", e);
                }
            }
        }
    }

    public static void m21033b(Context context, gum com_ushareit_listenit_gum) {
        if (com_ushareit_listenit_gum != null && context != null && VERSION.SDK_INT >= 19) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager.getStreamVolume(3) < audioManager.getStreamMaxVolume(3)) {
                LoudnessEnhancer a = m21026a().m21041a(com_ushareit_listenit_gum);
                if (a != null) {
                    try {
                        if (a.getEnabled()) {
                            a.setTargetGain(0);
                            a.setEnabled(false);
                        }
                    } catch (Throwable e) {
                        exw.m18450b("VolumeChangedReceiver", "volume changed receiver has an error.", e);
                    }
                }
            }
        }
    }

    public void m21042a(Context context) {
        if (this.f13539d == null) {
            this.f13539d = new fun();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        context.registerReceiver(this.f13539d, intentFilter);
    }

    public void m21045b(Context context) {
        try {
            if (this.f13539d != null) {
                context.unregisterReceiver(this.f13539d);
            }
        } catch (Exception e) {
        }
    }

    private void m21030a(ak akVar, LoudnessEnhancer loudnessEnhancer) {
        this.f13540e = akVar;
        this.f13536a = new VolumeControlView(akVar, loudnessEnhancer);
        this.f13536a.setOnVolumeTouchChangedListener(this.f13544i);
        this.f13536a.setOnAdjustVolumeFailureListener(this.f13545j);
        this.f13536a.setOnBoosterSwitchClickListener(new fut(this, akVar));
        this.f13537b = new hic(akVar, this.f13536a);
        this.f13537b.m23890a(false, 0, akVar.getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_150dp));
        this.f13537b.m23889a(this.f13543h);
    }

    private void m21029a(ak akVar) {
        m21039e();
        fjo com_ushareit_listenit_fjo = new fjo();
        com_ushareit_listenit_fjo.m19549U().m19558b((int) C0349R.string.volume_booster_warning_title);
        com_ushareit_listenit_fjo.m19550V().m19559c(C0349R.string.volume_booster_warning_content);
        com_ushareit_listenit_fjo.m19553Y();
        com_ushareit_listenit_fjo.m19554Z();
        com_ushareit_listenit_fjo.m19551W().m19560d(C0349R.string.volume_booster_warning_remember_operator);
        com_ushareit_listenit_fjo.m19557a(new fuu(this, com_ushareit_listenit_fjo));
        com_ushareit_listenit_fjo.m19518a(akVar, "showVolumeBoosterWarning");
    }

    private void m21036c() {
        this.f13542g.removeMessages(0);
        this.f13542g.sendEmptyMessage(0);
    }

    private void m21038d() {
        this.f13542g.removeMessages(0);
        this.f13542g.sendEmptyMessageDelayed(0, 2000);
    }

    private void m21039e() {
        this.f13542g.removeMessages(0);
    }
}
