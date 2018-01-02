package com.ushareit.listenit.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fjk;
import com.ushareit.listenit.fus;
import com.ushareit.listenit.gef;
import com.ushareit.listenit.gpi;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gvk;
import com.ushareit.listenit.gvl;
import com.ushareit.listenit.gvm;
import com.ushareit.listenit.gvn;
import com.ushareit.listenit.gvo;
import com.ushareit.listenit.gvp;
import com.ushareit.listenit.gvq;
import com.ushareit.listenit.gvr;
import com.ushareit.listenit.gvs;
import com.ushareit.listenit.gvt;
import com.ushareit.listenit.gvu;
import com.ushareit.listenit.gvv;
import com.ushareit.listenit.gvw;
import com.ushareit.listenit.gvx;
import com.ushareit.listenit.gvy;
import com.ushareit.listenit.gvz;
import com.ushareit.listenit.gwa;
import com.ushareit.listenit.gwd;
import com.ushareit.listenit.gwe;
import com.ushareit.listenit.gwf;
import com.ushareit.listenit.gwg;
import com.ushareit.listenit.gwh;
import com.ushareit.listenit.gwi;
import com.ushareit.listenit.gwj;
import com.ushareit.listenit.gyp;
import com.ushareit.listenit.hdp;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import com.ushareit.listenit.widget.SwitchButton;

public class UserSettingsActivity extends fjk {
    private SwitchButton f16456A;
    private SwitchButton f16457B;
    private SwitchButton f16458C;
    private SwitchButton f16459D;
    private SwitchButton f16460E;
    private ConfirmPopupView f16461F;
    private SwitchButton f16462G;
    private OnCheckedChangeListener f16463H = new gvl(this);
    private OnClickListener f16464I = new gvw(this);
    private OnCheckedChangeListener f16465J = new gwd(this);
    private OnClickListener f16466K = new gwe(this);
    private OnCheckedChangeListener f16467L = new gwf(this);
    private OnCheckedChangeListener f16468M = new gwg(this);
    private OnClickListener f16469N = new gwh(this);
    private OnClickListener f16470O = new gwi(this);
    private OnCheckedChangeListener f16471P = new gwj(this);
    private OnClickListener f16472Q = new gvm(this);
    private OnCheckedChangeListener f16473R = new gvn(this);
    private OnClickListener f16474S = new gvo(this);
    private OnCheckedChangeListener f16475T = new gvp(this);
    private OnClickListener f16476U = new gvq(this);
    private OnCheckedChangeListener f16477V = new gvr(this);
    private OnClickListener f16478W = new gvs(this);
    private OnCheckedChangeListener f16479X = new gvt(this);
    private OnClickListener f16480Y = new gvu(this);
    private OnCheckedChangeListener f16481Z = new gvv(this);
    private OnClickListener aa = new gvx(this);
    private OnClickListener ab = new gvy(this);
    private gpi ac = new gvz(this);
    private OnClickListener ad = new gwa(this);
    private SwitchButton f16482n;
    private SwitchButton f16483o;
    private hdp f16484p;
    private View f16485q;
    private TextView f16486r;
    private View f16487s;
    private View f16488t;
    private SwitchButton f16489y;
    private SwitchButton f16490z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.settings_user_activity);
        setTitle(C0349R.string.setting_name);
        m5103d(8);
        m26091j();
    }

    public boolean mo539h() {
        return false;
    }

    public boolean mo540i() {
        return false;
    }

    public void finish() {
        super.finish();
    }

    private void m26091j() {
        findViewById(C0349R.id.setting_auto_play_music).setOnClickListener(this.f16464I);
        this.f16482n = (SwitchButton) findViewById(C0349R.id.setting_auto_play_music_switch);
        this.f16482n.setCheckedImmediately(gvk.m23050b());
        this.f16482n.setOnCheckedChangeListener(this.f16463H);
        findViewById(C0349R.id.setting_auto_scan_filter).setOnClickListener(this.f16466K);
        this.f16483o = (SwitchButton) findViewById(C0349R.id.setting_auto_scan_filter_switch);
        this.f16483o.setCheckedImmediately(gvk.m23052c());
        this.f16483o.setOnCheckedChangeListener(this.f16465J);
        findViewById(C0349R.id.cross_fade).setOnClickListener(this.f16474S);
        this.f16489y = (SwitchButton) findViewById(C0349R.id.cross_fade_switch);
        this.f16489y.setCheckedImmediately(gvj.ad(this));
        this.f16489y.setOnCheckedChangeListener(this.f16473R);
        findViewById(C0349R.id.fade_startpause).setOnClickListener(this.f16476U);
        this.f16490z = (SwitchButton) findViewById(C0349R.id.fade_startpause_switch);
        this.f16490z.setCheckedImmediately(gvj.ae(this));
        this.f16490z.setOnCheckedChangeListener(this.f16475T);
        findViewById(C0349R.id.setting_auto_match_album_art).setOnClickListener(this.f16469N);
        this.f16459D = (SwitchButton) findViewById(C0349R.id.setting_auto_match_album_art_switch);
        this.f16459D.setCheckedImmediately(gvk.m23054d());
        this.f16459D.setOnCheckedChangeListener(this.f16467L);
        findViewById(C0349R.id.setting_charging_lockscreen).setOnClickListener(this.f16470O);
        this.f16460E = (SwitchButton) findViewById(C0349R.id.setting_charging_lockscreen_switch);
        this.f16460E.setCheckedImmediately(gvk.m23057e());
        this.f16460E.setOnCheckedChangeListener(this.f16468M);
        View findViewById = findViewById(C0349R.id.setting_voice_controller_bar);
        gum a = gyp.m23285b() ? gyp.m23272a() : null;
        if (a == null || fus.m21026a().m21041a(a) != null) {
            boolean z;
            findViewById.setOnClickListener(this.f16472Q);
            this.f16462G = (SwitchButton) findViewById(C0349R.id.setting_voice_controller_bar_switch);
            SwitchButton switchButton = this.f16462G;
            if (gvk.m23058f()) {
                z = false;
            } else {
                z = true;
            }
            switchButton.setCheckedImmediately(z);
            this.f16462G.setOnCheckedChangeListener(this.f16471P);
        } else {
            findViewById.setVisibility(8);
        }
        if (VERSION.SDK_INT < 16) {
            findViewById(C0349R.id.cut_silence).setVisibility(8);
        } else {
            findViewById(C0349R.id.cut_silence).setOnClickListener(this.f16478W);
            this.f16456A = (SwitchButton) findViewById(C0349R.id.cut_silence_switch);
            this.f16456A.setCheckedImmediately(gvj.ah(this));
            this.f16456A.setOnCheckedChangeListener(this.f16477V);
        }
        findViewById(C0349R.id.replay).setOnClickListener(this.f16480Y);
        this.f16457B = (SwitchButton) findViewById(C0349R.id.replay_switch);
        this.f16457B.setCheckedImmediately(gvj.aj(this));
        this.f16457B.setOnCheckedChangeListener(this.f16479X);
        findViewById(C0349R.id.audio_focus).setOnClickListener(this.aa);
        this.f16458C = (SwitchButton) findViewById(C0349R.id.audio_focus_switch);
        this.f16458C.setCheckedImmediately(gvj.ak(this));
        this.f16458C.setOnCheckedChangeListener(this.f16481Z);
        findViewById(C0349R.id.setting_full_scan_sdcard).setOnClickListener(this.ab);
        findViewById(C0349R.id.about).setOnClickListener(this.ab);
        findViewById(C0349R.id.feedback).setOnClickListener(this.ab);
        findViewById(C0349R.id.facebook).setOnClickListener(this.ab);
        this.f16485q = findViewById(C0349R.id.setting_lockscreen);
        this.f16486r = (TextView) findViewById(C0349R.id.setting_lockscreen_desc);
        this.f16486r.setText(gvj.m22953f() ? C0349R.string.setting_lock_system : C0349R.string.setting_lock_custom);
        this.f16485q.setOnClickListener(this.ab);
        this.f16487s = findViewById(C0349R.id.setting_audio_folder);
        this.f16487s.setOnClickListener(this.ab);
        this.f16488t = findViewById(C0349R.id.logout);
        if (gef.m21805a().m21835e()) {
            this.f16488t.setVisibility(0);
            this.f16488t.setOnClickListener(this.ad);
        }
    }

    protected void onResume() {
        super.onResume();
        if (gef.m21805a().m21835e()) {
            this.f16488t.setVisibility(0);
            this.f16488t.setOnClickListener(this.ad);
            return;
        }
        this.f16488t.setVisibility(8);
    }

    private void m26080a(Intent intent) {
        try {
            intent.addFlags(268435456);
            getApplicationContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
        }
    }

    private void m26098p() {
        m26100q();
        this.f16484p = hdp.m23585a(this);
    }

    private void m26100q() {
        if (this.f16484p != null && this.f16484p.isShowing()) {
            this.f16484p.dismiss();
            this.f16484p = null;
        }
    }
}
