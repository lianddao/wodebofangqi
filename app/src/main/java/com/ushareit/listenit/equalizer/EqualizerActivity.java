package com.ushareit.listenit.equalizer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.feb;
import com.ushareit.listenit.fik;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.ftv;
import com.ushareit.listenit.ftw;
import com.ushareit.listenit.ftx;
import com.ushareit.listenit.fty;
import com.ushareit.listenit.ftz;
import com.ushareit.listenit.fua;
import com.ushareit.listenit.fub;
import com.ushareit.listenit.fuc;
import com.ushareit.listenit.fud;
import com.ushareit.listenit.fue;
import com.ushareit.listenit.fug;
import com.ushareit.listenit.fuh;
import com.ushareit.listenit.fui;
import com.ushareit.listenit.fuj;
import com.ushareit.listenit.fuk;
import com.ushareit.listenit.ful;
import com.ushareit.listenit.fum;
import com.ushareit.listenit.gky;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gzc;
import com.ushareit.listenit.hbn;
import com.ushareit.listenit.hea;
import com.ushareit.listenit.widget.DefaultEqualizerView;
import com.ushareit.listenit.widget.SeekArc;
import com.ushareit.listenit.widget.SwitchButton;
import com.ushareit.listenit.widget.VerticalSeekBar;

public class EqualizerActivity extends fjt {
    private Spinner f11551A;
    private feb f11552B;
    private TextView f11553C;
    private SeekArc f11554D;
    private View f11555E;
    private View f11556F;
    private View f11557G;
    private TextView f11558H;
    private SeekArc f11559I;
    private View f11560J;
    private View f11561K;
    private View f11562L;
    private TextView f11563M;
    private SeekBar f11564N;
    private TextView f11565O;
    private AudioManager f11566P;
    private gky f11567Q = new gky();
    private int f11568R = -1;
    private OnClickListener f11569S = new ftv(this);
    private OnCheckedChangeListener f11570T = new fud(this);
    private hbn f11571U = new fue(this);
    private OnSeekBarChangeListener f11572V = new fug(this);
    private OnSeekBarChangeListener f11573W = new fuh(this);
    private OnSeekBarChangeListener f11574X = new fui(this);
    private OnSeekBarChangeListener f11575Y = new fuj(this);
    private OnSeekBarChangeListener f11576Z = new fuk(this);
    private OnHierarchyChangeListener aa = new ful(this);
    private OnItemSelectedListener ab = new ftw(this);
    private hea ac = new ftx(this);
    private OnClickListener ad = new fty(this);
    private hea ae = new ftz(this);
    private OnClickListener af = new fua(this);
    private OnSeekBarChangeListener ag = new fub(this);
    private BroadcastReceiver ah = new fuc(this);
    private View f11577n;
    private View f11578o;
    private SwitchButton f11579p;
    private DefaultEqualizerView f11580q;
    private VerticalSeekBar f11581r;
    private VerticalSeekBar f11582s;
    private VerticalSeekBar f11583t;
    private VerticalSeekBar f11584y;
    private VerticalSeekBar f11585z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gzc.m23341a((Activity) this, (int) C0349R.color.equalizer_background_color);
        setContentView(C0349R.layout.equalizer_fragment_view);
        m17518j();
        m17515h();
        m17523p();
        m17524q();
    }

    private void m17515h() {
        this.f11578o.setOnClickListener(this.f11569S);
        this.f11579p.setOnCheckedChangeListener(this.f11570T);
        this.f11580q.setOnEqualizerClickListener(this.f11571U);
        this.f11581r.setOnSeekBarChangeListener(this.f11572V);
        this.f11582s.setOnSeekBarChangeListener(this.f11573W);
        this.f11583t.setOnSeekBarChangeListener(this.f11574X);
        this.f11584y.setOnSeekBarChangeListener(this.f11575Y);
        this.f11585z.setOnSeekBarChangeListener(this.f11576Z);
        this.f11551A.setOnItemSelectedListener(this.ab);
        this.f11551A.setOnHierarchyChangeListener(this.aa);
        this.f11554D.setOnSeekArcChangeListener(this.ac);
        this.f11559I.setOnSeekArcChangeListener(this.ae);
        this.f11564N.setOnSeekBarChangeListener(this.ag);
        this.f11555E.setOnClickListener(this.ad);
        this.f11560J.setOnClickListener(this.af);
    }

    private void m17518j() {
        this.f11577n = findViewById(C0349R.id.root_view);
        this.f11578o = findViewById(C0349R.id.back);
        this.f11579p = (SwitchButton) findViewById(C0349R.id.enable);
        this.f11580q = (DefaultEqualizerView) findViewById(C0349R.id.default_equalizers);
        this.f11551A = (Spinner) findViewById(C0349R.id.reverb);
        this.f11553C = (TextView) findViewById(C0349R.id.reverb_name);
        this.f11581r = (VerticalSeekBar) findViewById(C0349R.id.eq60Hz_seekbar);
        this.f11582s = (VerticalSeekBar) findViewById(C0349R.id.eq230Hz_seekbar);
        this.f11583t = (VerticalSeekBar) findViewById(C0349R.id.eq910Hz_seekbar);
        this.f11584y = (VerticalSeekBar) findViewById(C0349R.id.eq3600Hz_seekbar);
        this.f11585z = (VerticalSeekBar) findViewById(C0349R.id.eq14000Hz_seekbar);
        this.f11554D = (SeekArc) findViewById(C0349R.id.bassboost);
        this.f11555E = findViewById(C0349R.id.bassboost_button);
        this.f11556F = findViewById(C0349R.id.bassboost_arrow);
        this.f11557G = findViewById(C0349R.id.bassboost_icon);
        this.f11558H = (TextView) findViewById(C0349R.id.bassboost_name);
        this.f11559I = (SeekArc) findViewById(C0349R.id.virtualizer);
        this.f11560J = findViewById(C0349R.id.virtualizer_button);
        this.f11561K = findViewById(C0349R.id.virtualizer_arrow);
        this.f11562L = findViewById(C0349R.id.virtualizer_icon);
        this.f11563M = (TextView) findViewById(C0349R.id.virtualizer_name);
        this.f11564N = (SeekBar) findViewById(C0349R.id.volume);
        this.f11565O = (TextView) findViewById(C0349R.id.volume_name);
    }

    private void m17523p() {
        View findViewById = findViewById(C0349R.id.bassboost_view);
        View findViewById2 = findViewById(C0349R.id.virtualizer_view);
        int d = (int) (((float) fbb.m18764d((Context) this)) * 0.187f);
        gyn.m23192a(findViewById, d);
        gyn.m23192a(findViewById2, d);
        int i = (int) (((float) d) * 0.26f);
        this.f11554D.setPadding(i, i, i, i);
        this.f11559I.setPadding(i, i, i, i);
        i = (int) (((float) d) * 0.2f);
        this.f11556F.setPadding(i, i, i, i);
        this.f11561K.setPadding(i, i, i, i);
        i = (int) (((float) d) * 0.42f);
        int i2 = (int) (((float) i) * 0.1f);
        gyn.m23192a(this.f11555E, i);
        gyn.m23192a(this.f11560J, i);
        this.f11555E.setPadding(i2, i2, i2, i2);
        this.f11560J.setPadding(i2, i2, i2, i2);
        i = (int) (((float) d) * 0.117f);
        i2 = (int) (((float) i) * 0.214f);
        d = (int) (((float) d) * 0.125f);
        gyn.m23193a(this.f11557G, i2, i);
        gyn.m23243g(this.f11557G, d);
        gyn.m23193a(this.f11562L, i2, i);
        gyn.m23243g(this.f11562L, d);
        if (gyn.m23217b()) {
            gyn.m23237e(this.f11577n, fbb.m18766e(this));
        }
    }

    private void m17524q() {
        this.f11566P = (AudioManager) getSystemService("audio");
        this.f11579p.setCheckedImmediately(gvj.m22935d());
        this.f11552B = new feb(fum.m20996a().m21015f());
        this.f11551A.setAdapter(this.f11552B);
        gky e = fum.m20996a().m21013e();
        this.f11567Q.m22267a(e);
        this.f11580q.m26821a(e);
        m17505a(e);
        m17525r();
        m17526s();
        m17508b(gvj.m22935d());
    }

    private void m17505a(gky com_ushareit_listenit_gky) {
        this.f11581r.setProgressAndThumb(com_ushareit_listenit_gky.m22275d() + 15);
        this.f11582s.setProgressAndThumb(com_ushareit_listenit_gky.m22277e() + 15);
        this.f11583t.setProgressAndThumb(com_ushareit_listenit_gky.m22279f() + 15);
        this.f11584y.setProgressAndThumb(com_ushareit_listenit_gky.m22281g() + 15);
        this.f11585z.setProgressAndThumb(com_ushareit_listenit_gky.m22283h() + 15);
    }

    private void m17525r() {
        this.f11554D.setProgress(this.f11567Q.m22285i());
        this.f11559I.setProgress(this.f11567Q.m22287j());
        this.f11551A.setSelection(this.f11567Q.m22288k());
        erj.m17571b(this.f11556F, (float) (((int) (((float) this.f11554D.getSweepAngle()) * ((((float) this.f11567Q.m22285i()) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) this.f11554D.getMax())))) + this.f11554D.getStartAngle()));
        erj.m17571b(this.f11561K, (float) (((int) (((float) this.f11559I.getSweepAngle()) * ((((float) this.f11567Q.m22287j()) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) this.f11559I.getMax())))) + this.f11559I.getStartAngle()));
    }

    private void m17526s() {
        int streamMaxVolume = this.f11566P.getStreamMaxVolume(3);
        int streamVolume = this.f11566P.getStreamVolume(3);
        this.f11564N.setMax(streamMaxVolume);
        this.f11564N.setProgress(streamVolume);
    }

    public void onResume() {
        m17527t();
        super.onResume();
    }

    public void onPause() {
        m17528u();
        super.onPause();
    }

    protected void onDestroy() {
        fum.m20996a().m21003a(getApplicationContext());
        if (this.f11579p.isChecked()) {
            fik.m19338a(this);
            fik.m19341a((Context) this, "equalizer_enabled", "" + this.f11568R);
        }
        super.onDestroy();
    }

    public boolean mo540i() {
        return false;
    }

    private void m17527t() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        registerReceiver(this.ah, intentFilter);
    }

    private void m17528u() {
        unregisterReceiver(this.ah);
    }

    private void m17508b(boolean z) {
        this.f11580q.setEnabled(z);
        this.f11581r.setEnabled(z);
        this.f11582s.setEnabled(z);
        this.f11583t.setEnabled(z);
        this.f11584y.setEnabled(z);
        this.f11585z.setEnabled(z);
        this.f11551A.setEnabled(z);
        for (int i = 0; i < this.f11551A.getChildCount(); i++) {
            this.f11551A.getChildAt(i).setEnabled(z);
        }
        this.f11553C.setEnabled(z);
        this.f11554D.setEnabled(z);
        this.f11555E.setEnabled(z);
        this.f11556F.setEnabled(z);
        this.f11558H.setEnabled(z);
        this.f11557G.setEnabled(z);
        this.f11559I.setEnabled(z);
        this.f11560J.setEnabled(z);
        this.f11561K.setEnabled(z);
        this.f11563M.setEnabled(z);
        this.f11562L.setEnabled(z);
        this.f11564N.setEnabled(z);
        this.f11565O.setEnabled(z);
    }

    private void m17506a(SeekArc seekArc) {
        int progress = seekArc.getProgress();
        int max = (int) (((float) seekArc.getMax()) * 0.05f);
        progress = progress + max > seekArc.getMax() ? seekArc.getMax() : progress + max;
        if (progress < 0) {
            progress = 0;
        }
        seekArc.setProgress(progress);
    }
}
