package com.ushareit.listenit.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ah;
import com.ushareit.listenit.ak;
import com.ushareit.listenit.bh;
import com.ushareit.listenit.cloudsync.CloudSyncService;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fir;
import com.ushareit.listenit.fiw;
import com.ushareit.listenit.fjf;
import com.ushareit.listenit.fji;
import com.ushareit.listenit.gdw;
import com.ushareit.listenit.gdx;
import com.ushareit.listenit.gdy;
import com.ushareit.listenit.gdz;
import com.ushareit.listenit.gea;
import com.ushareit.listenit.geb;
import com.ushareit.listenit.gec;
import com.ushareit.listenit.ged;
import com.ushareit.listenit.gef;
import com.ushareit.listenit.get;
import com.ushareit.listenit.gfo;
import com.ushareit.listenit.gfr;
import com.ushareit.listenit.gfx;
import com.ushareit.listenit.ggf;
import com.ushareit.listenit.ggj;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gxj;
import com.ushareit.listenit.gyj;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.hdp;

public class LoginActivity extends fjf {
    private View f15759A;
    private View f15760B;
    private View f15761C;
    private InputMethodManager f15762D;
    private ImageView f15763E;
    private String f15764F = "";
    private long f15765G;
    private OnClickListener f15766H = new gdy(this);
    private OnClickListener f15767I = new gdz(this);
    private OnClickListener f15768J = new gea(this);
    private OnClickListener f15769K = new geb(this);
    private OnClickListener f15770L = new gec(this);
    private get f15771M = new ged(this);
    private hdp f15772n;
    private gfo f15773o;
    private gfx f15774p;
    private gfr f15775q;
    private ggj f15776r;
    private ggf f15777s;
    private int f15778t;
    private View f15779y;
    private View f15780z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15762D = (InputMethodManager) getSystemService("input_method");
        setContentView(C0349R.layout.login_activity);
        this.f15778t = gyj.m23142a(this);
        m24624t();
        m24625u();
        m24626v();
    }

    private void m24624t() {
        this.f15780z = findViewById(C0349R.id.skip_login);
        this.f15779y = findViewById(C0349R.id.cancel_login);
        this.f15759A = findViewById(C0349R.id.login_button_google);
        this.f15760B = findViewById(C0349R.id.login_button_facebook);
        this.f15761C = findViewById(C0349R.id.login_button_email);
        this.f15763E = (ImageView) findViewById(C0349R.id.login_background);
        this.f15763E.post(new gdw(this));
    }

    private void m24625u() {
        switch (this.f15778t) {
            case 0:
                this.f15779y.setVisibility(4);
                this.f15780z.setVisibility(0);
                return;
            case 1:
                this.f15779y.setVisibility(0);
                this.f15780z.setVisibility(4);
                return;
            default:
                return;
        }
    }

    private void m24626v() {
        this.f15780z.setOnClickListener(this.f15766H);
        this.f15779y.setOnClickListener(this.f15767I);
        this.f15759A.setOnClickListener(this.f15768J);
        this.f15760B.setOnClickListener(this.f15769K);
        this.f15761C.setOnClickListener(this.f15770L);
    }

    protected void onResume() {
        super.onResume();
        gvj.m22930d((Context) this, gxj.m23084a());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        gef.m21805a().m21821a(i, i2, intent);
    }

    public void mo541k() {
    }

    public void finish() {
        m24640s();
        setResult(-1);
        if (gef.m21805a().m21835e() && getIntent() != null && getIntent().hasExtra("extra_start_from")) {
            String stringExtra = getIntent().getStringExtra("extra_start_from");
            if (!fbb.m18763c(stringExtra)) {
                if (stringExtra.equals("nearby_login")) {
                    fir.m19382b("login");
                } else if (stringExtra.equals("nearby_user")) {
                    fir.m19382b("user");
                }
            }
        }
        if (gef.m21805a().m21835e()) {
            gvj.m23005m(eys.m18562a(), 0);
            CloudSyncService.m11589a();
        }
        super.finish();
    }

    protected void onDestroy() {
        m24640s();
        super.onDestroy();
    }

    public void onBackPressed() {
        fiw.m19475f(eys.m18562a(), "back" + (fbb.m18763c(this.f15764F) ? "" : "_" + this.f15764F));
        super.onBackPressed();
    }

    public void showSoftKeyboard(View view) {
        view.postDelayed(new gdx(this, view), 100);
    }

    private void m24627w() {
        try {
            getWindow().setSoftInputMode(3);
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
                this.f15762D.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m24628x() {
        this.f15773o = new gfo();
        m24618a(this.f15773o, "email account");
    }

    public void mo539h() {
        m24627w();
        gyn.m23215b((ak) this, this.f15773o);
        this.f15773o = null;
    }

    public void m24629a(String str) {
        this.f15774p = new gfx();
        Bundle bundle = new Bundle();
        bundle.putString("email", str);
        this.f15774p.m1317g(bundle);
        m24618a(this.f15774p, "email register");
    }

    public void mo540i() {
        gyn.m23215b((ak) this, this.f15774p);
        this.f15774p = null;
    }

    public void m24631b(String str) {
        this.f15775q = new gfr();
        Bundle bundle = new Bundle();
        bundle.putString("email", str);
        this.f15775q.m1317g(bundle);
        m24618a(this.f15775q, "email login");
    }

    public void m24635j() {
        gyn.m23215b((ak) this, this.f15775q);
        this.f15775q = null;
    }

    public void m24630a(String str, String str2) {
        this.f15776r = new ggj();
        Bundle bundle = new Bundle();
        bundle.putString(VastExtensionXmlManager.TYPE, str);
        bundle.putString("email", str2);
        this.f15776r.m1317g(bundle);
        m24618a(this.f15776r, "welcome back");
    }

    public void m24637p() {
        gyn.m23215b((ak) this, this.f15776r);
        this.f15776r = null;
    }

    public void m24632c(String str) {
        this.f15777s = new ggf();
        Bundle bundle = new Bundle();
        bundle.putString("email", str);
        this.f15777s.m1317g(bundle);
        m24618a(this.f15777s, "reset password");
    }

    public void m24638q() {
        gyn.m23215b((ak) this, this.f15777s);
        this.f15777s = null;
    }

    public synchronized void m24639r() {
        m24640s();
        this.f15772n = hdp.m23585a(this);
    }

    public synchronized void m24640s() {
        if (this.f15772n != null && this.f15772n.isShowing()) {
            this.f15772n.dismiss();
            this.f15772n = null;
        }
    }

    private void m24618a(fji com_ushareit_listenit_fji, String str) {
        bh a = m709f().mo797a();
        a.mo3090a((int) C0349R.id.fragment_container, (ah) com_ushareit_listenit_fji);
        a.mo3094a(str);
        try {
            a.mo3098c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
