package com.ushareit.listenit.lyrics;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ak;
import com.ushareit.listenit.eqy;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.fqs;
import com.ushareit.listenit.fyi;
import com.ushareit.listenit.fzi;
import com.ushareit.listenit.ggm;
import com.ushareit.listenit.ggq;
import com.ushareit.listenit.ggs;
import com.ushareit.listenit.ggt;
import com.ushareit.listenit.ggu;
import com.ushareit.listenit.ggv;
import com.ushareit.listenit.ggx;
import com.ushareit.listenit.ggy;
import com.ushareit.listenit.ggz;
import com.ushareit.listenit.gha;
import com.ushareit.listenit.ghb;
import com.ushareit.listenit.ghc;
import com.ushareit.listenit.ghd;
import com.ushareit.listenit.ghe;
import com.ushareit.listenit.ghf;
import com.ushareit.listenit.ghg;
import com.ushareit.listenit.ghh;
import com.ushareit.listenit.ghi;
import com.ushareit.listenit.ghj;
import com.ushareit.listenit.ghk;
import com.ushareit.listenit.ghl;
import com.ushareit.listenit.ghm;
import com.ushareit.listenit.ghn;
import com.ushareit.listenit.gho;
import com.ushareit.listenit.ghp;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.guo;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gyp;
import com.ushareit.listenit.gyw;
import com.ushareit.listenit.gyx;
import com.ushareit.listenit.gzc;
import com.ushareit.listenit.heb;
import com.ushareit.listenit.hgq;
import com.ushareit.listenit.hhx;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import com.ushareit.listenit.tv;
import java.net.URLEncoder;
import java.util.Locale;

public class LyricEditorActivity extends fjt {
    private ImageView f15830A;
    private ImageView f15831B;
    private View f15832C;
    private View f15833D;
    private LyricEditor f15834E;
    private TextView f15835F;
    private TextView f15836G;
    private View f15837H;
    private View f15838I;
    private View f15839J;
    private View f15840K;
    private View f15841L;
    private gum f15842M;
    private long f15843N = -1;
    private glg f15844O;
    private boolean f15845P;
    private String f15846Q;
    private boolean f15847R = false;
    private boolean f15848S = true;
    private OnClickListener f15849T = new ghm(this);
    private OnClickListener f15850U = new ghn(this);
    private gyx f15851V = new gho(this);
    private OnClickListener f15852W = new ggs(this);
    private OnClickListener f15853X = new ggt(this);
    private OnClickListener f15854Y = new ggu(this);
    private OnClickListener f15855Z = new ggv(this);
    private OnClickListener aa = new ggx(this);
    private OnClickListener ab = new ggy(this);
    private OnClickListener ac = new ggz(this);
    private hgq ad = new ghb(this);
    private OnSeekBarChangeListener ae = new ghc(this);
    private OnClickListener af = new ghe(this);
    private OnClickListener ag = new ghf(this);
    private OnClickListener ah = new ghg(this);
    private guo ai = new ghh(this);
    private gyw f15856n;
    private View f15857o;
    private ImageView f15858p;
    private View f15859q;
    private View f15860r;
    private View f15861s;
    private SeekBar f15862t;
    private ImageView f15863y;
    private ImageView f15864z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15843N = getIntent().getLongExtra("song_id", -1);
        this.f15845P = getIntent().getBooleanExtra("is_load_lyric", true);
        if (this.f15843N < 0) {
            heb.m23596a((int) C0349R.string.toast_play_failure, 0).show();
            finish();
            return;
        }
        setContentView(C0349R.layout.lyric_edit_activity);
        gzc.m23346b(this, CtaButton.BACKGROUND_COLOR);
        this.f15857o = findViewById(C0349R.id.root_view);
        this.f15858p = (ImageView) findViewById(C0349R.id.albumArt);
        this.f15859q = findViewById(C0349R.id.actionbar);
        this.f15860r = findViewById(C0349R.id.player);
        this.f15861s = findViewById(C0349R.id.back);
        this.f15862t = (SeekBar) findViewById(C0349R.id.seekbar);
        this.f15835F = (TextView) findViewById(C0349R.id.song_name);
        this.f15836G = (TextView) findViewById(C0349R.id.elapse);
        this.f15863y = (ImageView) findViewById(C0349R.id.play);
        this.f15864z = (ImageView) findViewById(C0349R.id.timer);
        this.f15830A = (ImageView) findViewById(C0349R.id.search);
        this.f15831B = (ImageView) findViewById(C0349R.id.paste);
        this.f15832C = findViewById(C0349R.id.loading);
        this.f15837H = findViewById(C0349R.id.search_online);
        this.f15833D = findViewById(C0349R.id.search_guide);
        this.f15834E = (LyricEditor) findViewById(C0349R.id.lyric_editor);
        this.f15838I = findViewById(C0349R.id.help);
        this.f15839J = findViewById(C0349R.id.delete);
        this.f15840K = findViewById(C0349R.id.save);
        this.f15841L = findViewById(C0349R.id.lyric_list_area);
        this.f15856n = new gyw(this.f15857o);
        this.f15856n.m23324a(this.f15851V);
        this.f15841L.setOnClickListener(this.f15852W);
        this.f15862t.setOnSeekBarChangeListener(this.ae);
        this.f15861s.setOnClickListener(this.f15849T);
        this.f15863y.setOnClickListener(this.af);
        this.f15831B.setOnClickListener(this.aa);
        this.f15830A.setOnClickListener(this.f15854Y);
        this.f15837H.setOnClickListener(this.f15853X);
        this.f15864z.setOnClickListener(this.ag);
        this.f15833D.setOnClickListener(this.ah);
        this.f15838I.setOnClickListener(this.ac);
        this.f15839J.setOnClickListener(this.f15855Z);
        this.f15840K.setOnClickListener(this.ab);
        if (gyn.m23217b()) {
            gyn.m23237e(this.f15859q, fbb.m18766e(this));
        }
        if (this.f15845P) {
            m24743p();
        } else {
            m24735h();
        }
        m24744q();
    }

    private void m24735h() {
        this.f15835F.setVisibility(0);
        this.f15833D.setVisibility(0);
        this.f15841L.setVisibility(4);
        this.f15832C.setVisibility(8);
        this.f15830A.setVisibility(8);
        this.f15831B.setVisibility(8);
        this.f15839J.setVisibility(8);
        this.f15839J.setVisibility(8);
        this.f15864z.setEnabled(false);
    }

    private void m24739j() {
        if (!this.f15847R) {
            this.f15841L.setVisibility(0);
            this.f15830A.setVisibility(0);
            this.f15831B.setVisibility(0);
            this.f15839J.setVisibility(0);
            this.f15840K.setVisibility(0);
            this.f15833D.setVisibility(8);
            this.f15835F.setVisibility(4);
            this.f15864z.setEnabled(true);
            gyw com_ushareit_listenit_gyw = this.f15856n;
            gyw.m23321a(this, this.f15834E);
            this.f15847R = true;
        }
    }

    private void m24743p() {
        this.f15832C.setVisibility(0);
        this.f15841L.setVisibility(8);
        this.f15833D.setVisibility(8);
    }

    public void mo541k() {
        super.mo541k();
        if (this.f15842M == null) {
            m24744q();
        }
    }

    private void m24744q() {
        if (gyp.m23285b() && this.f15857o != null) {
            this.f15842M = gyp.m23272a();
            this.f15844O = fqs.m20447a(this.f15843N);
            this.f15842M.mo2457n();
            if (this.f15844O != null) {
                this.f15842M.mo2428b(this.f15844O);
            }
            this.f15842M.mo2418a(this.ad);
            this.f15842M.mo2416a(this.ai);
            m24727b(this.f15842M.mo2425a());
            if (this.f15845P) {
                m24718a(this.f15844O, false);
            }
            m24717a(this.f15844O);
        }
    }

    private void m24717a(glg com_ushareit_listenit_glg) {
        int d = fbb.m18764d((Context) this) / 4;
        gla com_ushareit_listenit_gla = com_ushareit_listenit_glg;
        fzi.m21402a((Context) this, com_ushareit_listenit_gla, this.f15858p, tv.HIGH, fbb.m18762c((Context) this) / 4, new ggq(this));
    }

    private void m24715a(Bitmap bitmap) {
        this.f15858p.setImageBitmap(bitmap);
        eqy b = eqy.m17366b(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        b.mo2252c(600);
        b.m17384a(new ghd(this));
        b.m17274a(new ghi(this));
        b.mo2234a();
    }

    private void m24727b(boolean z) {
        if (this.f15842M != null) {
            if (this.f15844O != null) {
                this.f15835F.setText(this.f15844O.f14338f);
            }
            this.f15863y.setImageResource(z ? C0349R.drawable.lyric_player_pause_bg : C0349R.drawable.lyric_player_play_bg);
            if (this.f15842M.mo2465v() != null) {
                m24714a(this.f15842M.mo2463t(), this.f15842M.mo2465v().f14337e);
            }
        }
    }

    private void m24714a(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            this.f15862t.setProgress((int) (((((float) i) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) i2)) * ((float) this.f15862t.getMax())));
            this.f15836G.setText(gyn.m23208b((long) i));
        }
    }

    private void m24718a(glg com_ushareit_listenit_glg, boolean z) {
        m24743p();
        ghp.m22017a(com_ushareit_listenit_glg, z, new ghj(this));
    }

    private void m24716a(ggm com_ushareit_listenit_ggm) {
        this.f15847R = true;
        this.f15830A.setVisibility(0);
        this.f15831B.setVisibility(0);
        this.f15839J.setVisibility(0);
        this.f15840K.setVisibility(0);
        this.f15835F.setVisibility(4);
        this.f15832C.setVisibility(8);
        this.f15841L.setVisibility(0);
        this.f15834E.setLyric(com_ushareit_listenit_ggm);
    }

    public void onResume() {
        super.onResume();
        String t = m24747t();
        if (m24729c(t)) {
            m24723a(t);
        }
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.f15842M != null) {
            this.f15842M.mo2432b(this.ad);
            this.f15842M.mo2430b(this.ai);
        }
        if (this.f15842M != null && this.f15842M.mo2456m()) {
            this.f15842M.mo2458o();
        }
        super.onDestroy();
    }

    public boolean mo540i() {
        m24745r();
        return true;
    }

    private void m24723a(String str) {
        ConfirmPopupView confirmPopupView = new ConfirmPopupView(this);
        confirmPopupView.m25554a().setTitle(getString(C0349R.string.lyric_paste_hint));
        confirmPopupView.m25556d().setContent(getString(C0349R.string.lyric_paste_hint_content));
        confirmPopupView.setOk(getString(C0349R.string.lyric_paste_ok));
        confirmPopupView.setConfirmListener(new ghk(this, str));
        hhx.m23869a(new ghl(this, confirmPopupView), 0, 300);
    }

    private void m24745r() {
        if (this.f15856n.m23325a()) {
            gyw com_ushareit_listenit_gyw = this.f15856n;
            gyw.m23323b(this, this.f15834E.getEditText());
        }
        if (this.f15847R) {
            m24731d("back");
        } else {
            finish();
        }
    }

    public void finish() {
        if (this.f15842M != null && this.f15842M.mo2456m()) {
            this.f15842M.mo2458o();
        }
        super.finish();
    }

    private void m24746s() {
        if (this.f15844O != null) {
            String str;
            if (getString(C0349R.string.unknown).equals(this.f15844O.f14339g.toLowerCase(Locale.US))) {
                str = this.f15844O.f14338f + "+ lyric";
            } else {
                str = this.f15844O.f14338f + "+ " + this.f15844O.f14339g + "+ lyric";
            }
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com/search?q=" + URLEncoder.encode(str, "UTF-8"))));
            } catch (Exception e) {
            }
        }
    }

    private void m24726b(String str) {
        this.f15834E.mo2886a(str);
    }

    private boolean m24729c(String str) {
        boolean z;
        if (this.f15848S || fbb.m18763c(str) || (!fbb.m18763c(this.f15846Q) && str.equals(this.f15846Q))) {
            z = false;
        } else {
            z = true;
        }
        this.f15846Q = str;
        this.f15848S = false;
        return z;
    }

    private String m24747t() {
        if (gyn.m23233d()) {
            ClipData primaryClip = ((ClipboardManager) getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip == null || primaryClip.getItemAt(0) == null) {
                return null;
            }
            CharSequence text = primaryClip.getItemAt(0).getText();
            return text != null ? text.toString() : null;
        }
        android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) getSystemService("clipboard");
        if (clipboardManager.getText() != null) {
            return clipboardManager.getText().toString();
        }
        return null;
    }

    private void m24731d(String str) {
        if (this.f15856n.m23325a()) {
            gyw com_ushareit_listenit_gyw = this.f15856n;
            gyw.m23323b(this, this.f15834E.getEditText());
        }
        BasePopupView confirmPopupView = new ConfirmPopupView(this);
        confirmPopupView.m25554a().setTitle(getString(C0349R.string.lyric_save_title));
        confirmPopupView.m25556d().setContent(getString(C0349R.string.lyric_save_content));
        confirmPopupView.setConfirmListener(new gha(this, str));
        gyn.m23197a((ak) this, new fyi(confirmPopupView));
    }
}
