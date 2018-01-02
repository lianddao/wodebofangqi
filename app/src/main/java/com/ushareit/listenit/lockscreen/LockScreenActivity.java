package com.ushareit.listenit.lockscreen;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.umeng.analytics.pro.C0320w;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fim;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.gca;
import com.ushareit.listenit.gcb;
import com.ushareit.listenit.gcc;
import com.ushareit.listenit.gcd;
import com.ushareit.listenit.gzc;
import com.ushareit.listenit.hge;
import com.ushareit.listenit.lockscreen.view.ChargeLockScreenViewGroup;

public class LockScreenActivity extends fjt {
    private FrameLayout f15636n;
    private LayoutParams f15637o;
    private ChargeLockScreenViewGroup f15638p;
    private MusicLockScreenView f15639q;
    private long f15640r;
    private gcc f15641s = new gcb(this);

    public void onAttachedToWindow() {
        getWindow().addFlags(4718720);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(C0320w.f3807b);
        }
    }

    public boolean mo540i() {
        return false;
    }

    protected void onResume() {
        super.onResume();
        this.f15640r = System.currentTimeMillis();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m24487p();
        gzc.m23346b(this, 0);
        setContentView(C0349R.layout.activity_lockscreen);
        this.f15636n = (FrameLayout) findViewById(C0349R.id.root);
        this.f15637o = new LayoutParams(-1, -1);
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra(VastExtensionXmlManager.TYPE, 2);
            if (intExtra == 1) {
                m24485h();
            } else if (intExtra == 2) {
                m24486j();
            }
        }
        if (getIntent() != null && getIntent().hasExtra("kill") && getIntent().getExtras().getInt("kill") == 1) {
            gcd.m21661a().m21679e();
            finish();
        }
    }

    private void m24485h() {
        if (this.f15639q == null) {
            this.f15639q = new MusicLockScreenView(this);
            this.f15639q.setOnDragFinishListener(this.f15641s);
            if (m4860n() != null) {
                this.f15639q.m24533a(m4860n());
            }
            this.f15636n.addView(this.f15639q, this.f15637o);
        }
        this.f15639q.setVisibility(0);
        fim.m19347b(this, "music");
    }

    private void m24486j() {
        if (this.f15638p == null) {
            this.f15638p = new ChargeLockScreenViewGroup(this);
            this.f15638p.setOnDragFinishListener(this.f15641s);
            this.f15636n.addView(this.f15638p, this.f15637o);
        }
        this.f15638p.setVisibility(0);
        fim.m19347b(this, "charging");
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        exw.m18454c("1024", "this:" + this + ".onNewIntent");
        if (getIntent() != null && getIntent().hasExtra("kill") && getIntent().getExtras().getInt("kill") == 1) {
            gcd.m21661a().m21679e();
            finish();
        } else if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra(VastExtensionXmlManager.TYPE, 2);
            if (intExtra == 1) {
                m24485h();
                if (this.f15639q != null) {
                    this.f15639q.m24532a();
                }
                if (this.f15638p != null) {
                    this.f15638p.setVisibility(4);
                }
            } else if (intExtra == 2) {
                m24486j();
                if (this.f15639q != null) {
                    this.f15639q.setVisibility(4);
                }
            }
        }
    }

    protected void onPause() {
        long currentTimeMillis = System.currentTimeMillis() - this.f15640r;
        if (currentTimeMillis > 100) {
            fim.m19348c(this, hge.m23691a(currentTimeMillis));
        }
        super.onPause();
    }

    private void m24487p() {
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            getWindow().addFlags(134217728);
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(C0320w.f3807b);
            decorView.setOnSystemUiVisibilityChangeListener(new gca(this, decorView));
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 3 || keyCode == 4 || super.dispatchKeyEvent(keyEvent);
    }

    public void mo541k() {
        if (this.f15639q != null) {
            this.f15639q.m24533a(m4860n());
        }
    }
}
