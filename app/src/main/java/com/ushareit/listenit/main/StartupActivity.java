package com.ushareit.listenit.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fem;
import com.ushareit.listenit.fet;
import com.ushareit.listenit.fid;
import com.ushareit.listenit.fjf;
import com.ushareit.listenit.fqo;
import com.ushareit.listenit.gik;
import com.ushareit.listenit.giw;
import com.ushareit.listenit.gix;
import com.ushareit.listenit.giy;
import com.ushareit.listenit.gja;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.hhx;

public class StartupActivity extends fjf {
    private boolean f15915n = false;
    private gik f15916o = new gja(this);

    public void mo541k() {
    }

    protected void onCreate(Bundle bundle) {
        this.x = false;
        super.onCreate(bundle);
        if (m24849q()) {
            m24847j();
        } else {
            m24845h();
        }
    }

    private void m24845h() {
        if (!((ListenItApp) getApplicationContext()).m4938d() || u <= 1) {
            m24846i();
            gvj.m23045z(getApplicationContext());
            fem.m18980k();
            setContentView(C0349R.layout.startup_activity);
            m24838a((Context) this);
            if (fem.m18970a()) {
                m24842b(false);
            } else {
                m24848p();
            }
            m24839a(getIntent());
            return;
        }
        finish();
    }

    private void m24846i() {
        hhx.m23867a(new giw(this));
    }

    private void m24847j() {
        setContentView(C0349R.layout.startup_activity);
        findViewById(C0349R.id.flash_screen).setVisibility(8);
        m24842b(true);
    }

    private void m24842b(boolean z) {
        AdFlashView adFlashView = (AdFlashView) findViewById(C0349R.id.ad_flash_view);
        if (z) {
            adFlashView.setVisibility(0);
            adFlashView.setFlashCallback(this.f15916o);
        }
        fet.m19018a((Context) this, new gix(this, (long) fqo.m20424f(), z, adFlashView));
    }

    private void m24848p() {
        View findViewById = findViewById(C0349R.id.app_logo);
        findViewById.setVisibility(0);
        Animation alphaAnimation = new AlphaAnimation(0.1f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new giy(this, findViewById));
        findViewById.startAnimation(alphaAnimation);
    }

    private void m24838a(Context context) {
        Drawable b = gyn.m23207b(C0349R.drawable.main_flash_bottom_bg, fbb.m18762c(context), (int) context.getResources().getDimension(C0349R.dimen.common_dimens_215dp));
        if (b != null) {
            findViewById(C0349R.id.flash_bottom_bg).setBackgroundDrawable(b);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4;
    }

    protected void onDestroy() {
        this.f15915n = true;
        super.onDestroy();
    }

    private boolean m24849q() {
        return getIntent() != null && getIntent().getBooleanExtra("intent_extra_from_background", false);
    }

    private void m24850r() {
        if (m24849q()) {
            finish();
            return;
        }
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        overridePendingTransition(C0349R.anim.enter_fade_in, C0349R.anim.exit_fade_out);
        finish();
        overridePendingTransition(C0349R.anim.enter_fade_in, C0349R.anim.exit_fade_out);
    }

    private void m24839a(Intent intent) {
        fid a;
        String action = intent.getAction();
        if (action != null && action.equalsIgnoreCase("android.intent.action.MAIN")) {
            a = fid.m19229a("fm_launcher");
        } else if (action != null && action.equalsIgnoreCase("android.intent.action.VIEW")) {
            a = fid.m19229a("fm_thirdparty");
        } else if (action != null && action.equalsIgnoreCase("com.ushareit.listenit.action.NOTIFICATION")) {
            a = fid.m19229a("fm_notification");
        } else if (action == null || !action.equalsIgnoreCase("com.ushareit.listenit.action.WIDGET")) {
            a = fid.m19228a(intent);
        } else {
            a = fid.m19229a("fm_widget");
        }
        fid.m19230a(this, a);
    }
}
