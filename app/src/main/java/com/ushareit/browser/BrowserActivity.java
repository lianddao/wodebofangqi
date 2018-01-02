package com.ushareit.browser;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.euk;
import com.ushareit.listenit.eul;
import com.ushareit.listenit.eum;
import com.ushareit.listenit.eun;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fcg;
import com.ushareit.listenit.fjf;
import com.ushareit.listenit.gzc;
import com.ushareit.listenit.heb;
import com.ushareit.listenit.hid;

public class BrowserActivity extends fjf {
    private FrameLayout f3917A;
    private CustomViewCallback f3918B;
    private eum f3919C;
    private eun f3920D;
    private TextView f3921E;
    private ImageView f3922F;
    private View f3923G;
    private View f3924H;
    private View f3925I;
    private View f3926J;
    private View f3927K;
    private View f3928L;
    private ProgressBar f3929M;
    private long f3930N = 0;
    private long f3931O = 0;
    private OnClickListener f3932P = new euk(this);
    private DownloadListener f3933Q = new eul(this);
    public WebView f3934n;
    protected View f3935o;
    protected View f3936p;
    public boolean f3937q;
    protected boolean f3938r;
    protected String f3939s;
    public String f3940t;
    private LinearLayout f3941y;
    private View f3942z;

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(11)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.browser_activity);
        setRequestedOrientation(-1);
        setResult(-1);
        gzc.m23341a((Activity) this, (int) C0349R.color.common_actionbar_color);
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        this.f3941y = (LinearLayout) findViewById(C0349R.id.browser_root);
        this.f3917A = (FrameLayout) findViewById(C0349R.id.customViewContainer);
        this.f3929M = (ProgressBar) findViewById(C0349R.id.pb);
        this.f3929M.setMax(100);
        this.f3935o = findViewById(C0349R.id.common_titlebar);
        this.f3921E = (TextView) findViewById(C0349R.id.title_text);
        this.f3922F = (ImageView) findViewById(C0349R.id.return_view);
        this.f3922F.setOnClickListener(this.f3932P);
        this.f3936p = findViewById(C0349R.id.option_area);
        this.f3924H = findViewById(C0349R.id.btn_back);
        this.f3924H.setOnClickListener(this.f3932P);
        this.f3925I = findViewById(C0349R.id.btn_forward);
        this.f3925I.setOnClickListener(this.f3932P);
        this.f3927K = findViewById(C0349R.id.btn_refresh);
        this.f3927K.setOnClickListener(this.f3932P);
        this.f3926J = findViewById(C0349R.id.btn_share);
        this.f3926J.setOnClickListener(this.f3932P);
        this.f3928L = findViewById(C0349R.id.btn_open);
        this.f3928L.setOnClickListener(this.f3932P);
        this.f3923G = findViewById(C0349R.id.error_view);
        this.f3923G.setOnClickListener(this.f3932P);
        this.f3938r = getIntent().getBooleanExtra("opt", false);
        if (!this.f3938r) {
            this.f3936p.setVisibility(8);
        }
        if (getIntent().hasExtra(VastExtensionXmlManager.TYPE)) {
            this.f3939s = getIntent().getStringExtra(VastExtensionXmlManager.TYPE);
        }
        if (getIntent().hasExtra("web_title")) {
            this.f3940t = getIntent().getStringExtra("web_title");
        }
        m4884v();
        this.f3934n = (WebView) findViewById(C0349R.id.webView);
        this.f3920D = new eun();
        this.f3934n.setWebViewClient(this.f3920D);
        this.f3919C = new eum();
        this.f3934n.setWebChromeClient(this.f3919C);
        this.f3934n.setDownloadListener(this.f3933Q);
        try {
            this.f3934n.getSettings().setJavaScriptEnabled(true);
            this.f3934n.getSettings().setPluginState(PluginState.ON);
            this.f3934n.getSettings().setAppCacheEnabled(true);
            this.f3934n.getSettings().setBuiltInZoomControls(true);
            this.f3934n.getSettings().setSaveFormData(true);
        } catch (Exception e) {
            exw.m18457e("BrowserActivity", "WebSettings error " + e.toString());
        }
        if (!TextUtils.isEmpty(this.f3940t)) {
            this.f3921E.setText(this.f3940t);
        }
        m4878p();
    }

    private void m4878p() {
        String stringExtra = getIntent().getStringExtra("url");
        if (stringExtra == null) {
            this.f3934n.loadUrl("http://www.youku.com");
        } else {
            this.f3934n.loadUrl(stringExtra);
        }
    }

    public boolean mo539h() {
        return this.f3942z != null;
    }

    public void mo540i() {
        this.f3919C.onHideCustomView();
    }

    protected void onPause() {
        super.onPause();
        if (VERSION.SDK_INT >= 11) {
            this.f3934n.onPause();
        }
        m4885w();
    }

    protected void onResume() {
        super.onResume();
        if (VERSION.SDK_INT >= 11) {
            this.f3934n.onResume();
        }
        m4884v();
    }

    protected void onStop() {
        super.onStop();
        if (mo539h()) {
            mo540i();
        }
    }

    protected void onDestroy() {
        if (this.f3934n != null) {
            this.f3941y.removeView(this.f3934n);
            this.f3934n.removeAllViews();
            this.f3934n.setVisibility(8);
            this.f3934n.destroy();
            m4885w();
            super.onDestroy();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (mo539h()) {
                mo540i();
                return true;
            } else if (m4879q()) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @SuppressLint({"InlinedApi"})
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f3939s != null && this.f3939s.equals(fcg.VIDEO.toString())) {
            if (configuration.orientation == 2) {
                this.f3935o.setVisibility(8);
                this.f3936p.setVisibility(8);
                getWindow().setFlags(1024, 1024);
            } else {
                this.f3935o.setVisibility(0);
                if (this.f3938r) {
                    this.f3936p.setVisibility(0);
                }
                getWindow().setFlags(67108864, 67108864);
                getWindow().setFlags(134217728, 134217728);
            }
        }
        super.onConfigurationChanged(configuration);
    }

    public void finish() {
        exw.m18443a("BrowserActivity", getClass().getSimpleName() + ".finish()");
        Intent intent = new Intent();
        intent.putExtra("duration", this.f3930N);
        setResult(-1, intent);
        super.finish();
    }

    private boolean m4879q() {
        if (this.f3942z != null || !this.f3934n.canGoBack()) {
            return false;
        }
        this.f3934n.goBack();
        return true;
    }

    private boolean m4880r() {
        if (this.f3942z != null || !this.f3934n.canGoForward()) {
            return false;
        }
        this.f3934n.goForward();
        return true;
    }

    public void m4888j() {
        Bundle bundle = new Bundle();
        String url = this.f3934n.getUrl();
        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("thumbnail");
        bundle.putString("title", this.f3934n.getTitle());
        bundle.putString("description", m4881s());
        bundle.putString("msg", m4882t());
        bundle.putString("webpage", url);
        bundle.putParcelable("thumbnail", bitmap);
        hid com_ushareit_listenit_hid = new hid();
        com_ushareit_listenit_hid.m1317g(bundle);
        com_ushareit_listenit_hid.mo1295a(m709f(), "share");
    }

    private String m4881s() {
        try {
            Intent intent = getIntent();
            if (intent.hasExtra("des_res")) {
                return getString(intent.getIntExtra("des_res", 0), new Object[]{this.f3934n.getTitle(), this.f3934n.getUrl()});
            }
            if (intent.hasExtra("des")) {
                return intent.getStringExtra("des");
            }
            return getString(C0349R.string.browser_default_msg, new Object[]{this.f3934n.getTitle(), this.f3934n.getUrl()});
        } catch (Exception e) {
        }
    }

    private String m4882t() {
        try {
            Intent intent = getIntent();
            if (intent.hasExtra("msg_res")) {
                return getString(intent.getIntExtra("msg_res", 0), new Object[]{this.f3934n.getTitle(), this.f3934n.getUrl()});
            }
            if (intent.hasExtra("msg")) {
                return intent.getStringExtra("msg");
            }
            return getString(C0349R.string.browser_default_msg, new Object[]{this.f3934n.getTitle(), this.f3934n.getUrl()});
        } catch (Exception e) {
        }
    }

    private void m4883u() {
        Uri parse = Uri.parse(getIntent().getStringExtra("url"));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(parse);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            heb.m23597a(getResources().getString(C0349R.string.browser_openurl_failure), 0).show();
        }
    }

    private void m4865a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    private String m4868b(String str) {
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("attachment;filename=");
        return lastIndexOf >= 0 ? str.substring(lastIndexOf + "attachment;filename=".length()) : str;
    }

    private void m4884v() {
        if (this.f3931O == 0) {
            this.f3931O = System.currentTimeMillis();
        }
    }

    private void m4885w() {
        if (this.f3931O != 0) {
            this.f3930N += System.currentTimeMillis() - this.f3931O;
            this.f3931O = 0;
        }
    }

    public void mo541k() {
    }
}
