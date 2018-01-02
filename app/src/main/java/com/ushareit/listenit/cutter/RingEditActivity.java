package com.ushareit.listenit.cutter;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.mopub.common.Constants;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.cutter.view.TouchWaveformView;
import com.ushareit.listenit.cutter.view.WavePlayerView;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.fow;
import com.ushareit.listenit.fox;
import com.ushareit.listenit.foy;
import com.ushareit.listenit.foz;
import com.ushareit.listenit.fpb;
import com.ushareit.listenit.fpc;
import com.ushareit.listenit.fpd;
import com.ushareit.listenit.fpe;
import com.ushareit.listenit.fpm;
import com.ushareit.listenit.fpv;
import com.ushareit.listenit.fqd;
import com.ushareit.listenit.fqm;
import com.ushareit.listenit.fqs;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.guo;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gyp;
import com.ushareit.listenit.hdp;
import com.ushareit.listenit.heb;
import com.ushareit.listenit.hhx;
import java.io.File;

public class RingEditActivity extends fjt {
    private fpm f9045A;
    private String f9046B;
    private String f9047C;
    private boolean f9048D = false;
    private Runnable f9049E = new fow(this);
    private OnClickListener f9050F = new foy(this);
    private OnClickListener f9051G = new foz(this);
    private fpv f9052H = new fpc(this);
    private fqd f9053I = new fpd(this);
    private guo f9054J = new fpe(this);
    private glg f9055n;
    private hdp f9056o;
    private TouchWaveformView f9057p;
    private WavePlayerView f9058q;
    private TextView f9059r;
    private TextView f9060s;
    private View f9061t;
    private View f9062y;
    private View f9063z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (m12821p()) {
            setContentView(C0349R.layout.ring_edit_activity);
            m12826u();
            m12825t();
            this.f9062y.setOnClickListener(this.f9051G);
            this.f9063z.setOnClickListener(this.f9050F);
            this.f9060s.setText(this.f9055n.f14338f);
            this.f9060s.postDelayed(this.f9049E, 300);
            m12822q();
            m12824s();
            return;
        }
        finish();
    }

    private boolean m12821p() {
        long longExtra = getIntent().getLongExtra("songId", -1);
        if (longExtra < 0) {
            return false;
        }
        try {
            this.f9055n = fqs.m20447a(longExtra);
            if (this.f9055n != null) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            exw.m18450b("cutter", "Exception happened when get SongItem from last activity.", e);
            return false;
        }
    }

    public void mo541k() {
        super.mo541k();
        m12822q();
    }

    private void m12822q() {
        gum a = gyp.m23285b() ? gyp.m23272a() : null;
        if (a != null && this.f9058q != null) {
            if (!(this.f9055n == null || a.mo2456m())) {
                a.mo2440c(this.f9055n);
            }
            a.mo2416a(this.f9054J);
            this.f9058q.setPlayService(a);
        }
    }

    private void m12823r() {
        gum a = gyp.m23285b() ? gyp.m23272a() : null;
        if (a != null) {
            a.mo2430b(this.f9054J);
            if (a.mo2456m()) {
                a.mo2458o();
            }
        }
    }

    private void m12824s() {
        this.f9046B = gyn.m23235e(this.f9055n.f14342j);
        this.f9057p.setButtonsEnable(false);
        this.f9058q.setButtonsEnable(false);
        hhx.m23867a(new fox(this));
    }

    private void m12813c(int i) {
        this.f9059r.setText(String.format(getString(C0349R.string.cutter_caption), new Object[]{Integer.valueOf(i), this.f9045A.mo2520g(), Integer.valueOf(this.f9045A.mo2519f()), Integer.valueOf(this.f9045A.mo2518e())}));
    }

    private void m12825t() {
        if (gyn.m23217b()) {
            gyn.m23237e(this.f9061t, fbb.m18766e(this));
        }
    }

    private void m12826u() {
        this.f9060s = (TextView) findViewById(C0349R.id.title);
        this.f9061t = findViewById(C0349R.id.actionbar_view);
        this.f9057p = (TouchWaveformView) findViewById(C0349R.id.touch_waveform);
        this.f9058q = (WavePlayerView) findViewById(C0349R.id.wave_player_view);
        this.f9062y = findViewById(C0349R.id.cutter_save);
        this.f9059r = (TextView) findViewById(C0349R.id.info);
        this.f9063z = findViewById(C0349R.id.back);
    }

    public boolean mo540i() {
        return false;
    }

    private void m12806a(String str) {
        this.f9057p.m12901a();
        hhx.m23867a(new fpb(this, str));
    }

    private String m12803a(CharSequence charSequence, String str) {
        int i = 0;
        String e = fqm.m20393a().m20400f().mo2330e();
        String str2 = "";
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (Character.isLetterOrDigit(charSequence.charAt(i2))) {
                str2 = str2 + charSequence.charAt(i2);
            }
        }
        String str3 = null;
        while (i < Constants.TEN_SECONDS_MILLIS) {
            if (i > 0) {
                str3 = e + File.separator + str2 + i + "." + str;
            } else {
                str3 = e + File.separator + str2 + "." + str;
            }
            if (!new File(str3).exists()) {
                break;
            }
            i++;
        }
        return str3;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f9058q != null) {
            m12823r();
        }
    }

    public void mo539h() {
        m12829j();
        this.f9056o = hdp.m23585a(this);
    }

    public void m12829j() {
        if (this.f9056o != null && this.f9056o.isShowing()) {
            this.f9056o.dismiss();
            this.f9056o = null;
        }
    }

    private void m12815d(int i) {
        heb.m23597a(getResources().getString(i), 0).show();
    }
}
