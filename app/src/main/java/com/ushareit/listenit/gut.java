package com.ushareit.listenit;

import android.content.Intent;
import android.media.AudioManager;
import com.ushareit.listenit.service.PlayService;

public class gut implements guo {
    final /* synthetic */ PlayService f14764a;

    public gut(PlayService playService) {
        this.f14764a = playService;
    }

    public void mo2503a(boolean z) {
        exw.m18443a("PlayService", "onNextPlay isReady=" + z);
        this.f14764a.m26061b(this.f14764a.f16448b.mo2425a());
        fiz.m19503a();
        gyo.m23264a().m23269b(Long.valueOf(this.f14764a.f16448b.mo2464u()));
        if (!(z || this.f14764a.f16450d == null)) {
            hhx.m23869a(new guu(this, "savePlayState"), 1000, 0);
        }
        m22823b(true);
        String str;
        if (this.f14764a.f16448b.mo2465v() != null && !z) {
            str = this.f14764a.f16448b.mo2465v().f14342j;
            if (!(fbb.m18763c(str) || !gyn.m23260p(str) || gyn.m23256m() || (this.f14764a.f16448b.mo2409C() && hgg.m23704a(str)))) {
                heb.m23596a((int) C0349R.string.toast_no_network, 0).show();
            }
            if (!fbb.m18763c(str) && gyn.m23260p(str)) {
                fij.m19332d();
            }
        } else if (this.f14764a.f16448b.mo2465v() != null && z) {
            str = this.f14764a.f16448b.mo2465v().f14342j;
            if (!fbb.m18763c(str) && gyn.m23260p(str)) {
                fij.m19334e();
            }
        }
        if (z) {
            this.f14764a.f16452f.m4940f();
            m22824d();
        }
    }

    private void m22824d() {
        if (((AudioManager) eys.m18562a().getSystemService("audio")).getStreamVolume(3) == 0) {
            heb.m23597a(eys.m18562a().getString(C0349R.string.common_turn_the_volume_up), 1).show();
        }
    }

    public void f_() {
        exw.m18443a("PlayService", "OnPlayerListener onPause");
        if (!gnp.m22535a()) {
            this.f14764a.m26061b(false);
        }
        fiz.m19503a();
        m22823b(false);
        this.f14764a.f16452f.m4939e();
    }

    public void mo2505c() {
        exw.m18443a("PlayService", "OnPlayerListener onError");
        this.f14764a.m26061b(false);
        fiz.m19503a();
        m22823b(false);
        this.f14764a.f16452f.m4939e();
    }

    public void mo2504b() {
        exw.m18443a("PlayService", "OnPlayerListener onCompletion");
        this.f14764a.m26061b(false);
        fiz.m19503a();
        m22823b(false);
        this.f14764a.f16452f.m4939e();
    }

    private void m22823b(boolean z) {
        glg v = this.f14764a.f16448b.mo2465v();
        if (v != null) {
            Intent intent = new Intent("com.android.music.metachanged");
            intent.putExtra("track", v.f14338f);
            intent.putExtra("artist", v.f14339g);
            intent.putExtra("album", v.f14340h);
            intent.putExtra("playing", z);
            this.f14764a.sendBroadcast(intent);
        }
    }
}
