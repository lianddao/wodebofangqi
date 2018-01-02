package com.ushareit.listenit.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.umeng.analytics.pro.C0277j;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ak;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.eyw;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fiw;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.fjw;
import com.ushareit.listenit.fkb;
import com.ushareit.listenit.fko;
import com.ushareit.listenit.fkp;
import com.ushareit.listenit.fkq;
import com.ushareit.listenit.fle;
import com.ushareit.listenit.flh;
import com.ushareit.listenit.flw;
import com.ushareit.listenit.fmc;
import com.ushareit.listenit.frf;
import com.ushareit.listenit.fyi;
import com.ushareit.listenit.gee;
import com.ushareit.listenit.gef;
import com.ushareit.listenit.gey;
import com.ushareit.listenit.gez;
import com.ushareit.listenit.gfa;
import com.ushareit.listenit.gfb;
import com.ushareit.listenit.gfc;
import com.ushareit.listenit.gfd;
import com.ushareit.listenit.gfe;
import com.ushareit.listenit.gff;
import com.ushareit.listenit.gfg;
import com.ushareit.listenit.gfh;
import com.ushareit.listenit.gfi;
import com.ushareit.listenit.gfj;
import com.ushareit.listenit.gfk;
import com.ushareit.listenit.gfm;
import com.ushareit.listenit.gfn;
import com.ushareit.listenit.gnh;
import com.ushareit.listenit.gpb;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gyj;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gzh;
import com.ushareit.listenit.heb;
import com.ushareit.listenit.hhx;
import com.ushareit.listenit.popupview.SyncTrafficAlertPopupView;
import com.ushareit.listenit.widget.SwitchButton;
import java.io.File;
import java.io.FileNotFoundException;

public class UserProfileActivity extends fjt {
    private TextView f15782A;
    private SwitchButton f15783B;
    private RelativeLayout f15784C;
    private Uri f15785D;
    private ProgressBar f15786E;
    private File f15787F;
    private File f15788G;
    private Uri f15789H;
    private ImageView f15790I;
    private flh f15791J = new gfg(this);
    private OnCheckedChangeListener f15792K = new gfi(this);
    private fjw f15793L = new gfj(this);
    private gee f15794M = new gfk(this);
    private OnClickListener f15795N = new gfm(this);
    private gpb f15796O = new gfn(this);
    private fkp f15797P = new gez(this);
    private fko f15798Q = new gfa(this);
    private OnClickListener f15799R = new gfb(this);
    private gnh f15800S = new gfc(this);
    private Runnable f15801T = new gfd(this);
    private View f15802n;
    private View f15803o;
    private TextView f15804p;
    private TextView f15805q;
    private TextView f15806r;
    private ImageView f15807s;
    private View f15808t;
    private ImageView f15809y;
    private ImageView f15810z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.user_profile_fragment);
        m24657h();
        m24660j();
        m24665r();
    }

    private void m24657h() {
        this.f15802n = findViewById(C0349R.id.profile_title_bar);
        this.f15803o = findViewById(C0349R.id.home);
        this.f15804p = (TextView) findViewById(C0349R.id.profile_name);
        this.f15805q = (TextView) findViewById(C0349R.id.profile_local_song_count);
        this.f15806r = (TextView) findViewById(C0349R.id.profile_cloud_song_count);
        this.f15807s = (ImageView) findViewById(C0349R.id.profile_portrait);
        this.f15808t = findViewById(C0349R.id.profile_edit_name);
        this.f15809y = (ImageView) findViewById(C0349R.id.profile_sync_button);
        this.f15782A = (TextView) findViewById(C0349R.id.profile_sync_progress_hint);
        this.f15810z = (ImageView) findViewById(C0349R.id.profile_sync_progress_bar);
        this.f15783B = (SwitchButton) findViewById(C0349R.id.profile_wifi_autosync_switch);
        this.f15784C = (RelativeLayout) findViewById(C0349R.id.profile_sync_state_container);
        this.f15786E = (ProgressBar) findViewById(C0349R.id.progress_bar);
        this.f15790I = (ImageView) findViewById(C0349R.id.user_profile_background);
    }

    private void m24660j() {
        if (gyn.m23217b()) {
            gyn.m23237e(this.f15802n, fbb.m18766e(this));
        }
        this.f15790I.post(new gey(this));
        Bitmap i = gyn.m23247i();
        if (i != null) {
            this.f15807s.setImageBitmap(i);
        } else {
            this.f15807s.setImageResource(C0349R.drawable.profile_photo_default);
        }
        this.f15804p.setText(gef.m21805a().m21836f());
        this.f15805q.setText(String.valueOf(frf.m20670d()));
        this.f15806r.setText(String.valueOf(frf.m20674e()));
        this.f15783B.setCheckedImmediately(gvj.m22879R(this));
        m24663p();
        m24648a(fkb.m19610a().m19647e());
    }

    private void m24663p() {
        int i = 98;
        if (m24670w() && fkb.m19610a().m19647e() == fkq.SYNCING_PLAYLIST) {
            int currentTimeMillis = (int) (((System.currentTimeMillis() - fkb.m19610a().m19646d()) / 500) * 5);
            if (currentTimeMillis < 98) {
                i = currentTimeMillis;
            }
            this.f15786E.setProgress(i);
        }
    }

    private void m24648a(fkq com_ushareit_listenit_fkq) {
        if (!m24670w()) {
            com_ushareit_listenit_fkq = fkq.FINISH;
        }
        this.f15784C.setOnClickListener(null);
        exw.m18443a("UserProfileActivity", "initSyncState=" + com_ushareit_listenit_fkq);
        int k;
        switch (gfe.f14022a[com_ushareit_listenit_fkq.ordinal()]) {
            case 1:
                this.f15786E.postDelayed(this.f15801T, 500);
                this.f15782A.setText(getString(C0349R.string.sync_playlist_syncing));
                m24666s();
                return;
            case 2:
                m24664q();
                m24666s();
                if (frf.m20684j() > 0) {
                    this.f15782A.setText(getString(C0349R.string.sync_song_downloading, new Object[]{Integer.valueOf(k)}));
                }
                this.f15805q.setText(String.valueOf(frf.m20670d()));
                this.f15806r.setText(String.valueOf(frf.m20674e()));
                return;
            case 3:
                m24664q();
                m24666s();
                k = frf.m20685k();
                if (k == 0) {
                    k = 1;
                }
                this.f15782A.setText(getString(C0349R.string.sync_song_uploading, new Object[]{Integer.valueOf(k)}));
                this.f15805q.setText(String.valueOf(frf.m20670d()));
                this.f15806r.setText(String.valueOf(frf.m20674e()));
                return;
            case 4:
                m24664q();
                m24667t();
                this.f15805q.setText(String.valueOf(frf.m20670d()));
                this.f15806r.setText(String.valueOf(frf.m20674e()));
                int g = flw.m19819a().m19848g() + fmc.m19867a().m19902g();
                int k2 = frf.m20685k();
                int j = frf.m20684j() + k2;
                boolean a = fle.m19717b().m19727a();
                boolean booleanValue = ((Boolean) eyw.m18568a(eys.m18562a()).second).booleanValue();
                if (g > 0) {
                    this.f15782A.setText(getString(C0349R.string.sync_song_failure_detail, new Object[]{Integer.valueOf(g)}));
                    this.f15784C.setOnClickListener(this.f15799R);
                    return;
                } else if (fkb.m19610a().m19646d() > 0) {
                    if (booleanValue) {
                        if (j > 0) {
                            this.f15782A.setText(getString(C0349R.string.sync_discover_songs_detail, new Object[]{Integer.valueOf(k2 + r3)}));
                            return;
                        } else if (a) {
                            this.f15782A.setText(getString(C0349R.string.sync_discover_playlist));
                            return;
                        } else {
                            this.f15782A.setText(getString(C0349R.string.sync_song_success));
                            return;
                        }
                    } else if (a) {
                        this.f15782A.setText(getString(C0349R.string.sync_all_hint));
                        return;
                    } else {
                        this.f15782A.setText(getString(C0349R.string.sync_playlist_success));
                        return;
                    }
                } else if (booleanValue) {
                    if (j > 0) {
                        this.f15782A.setText(getString(C0349R.string.sync_discover_songs_detail, new Object[]{Integer.valueOf(j)}));
                        return;
                    } else if (a) {
                        this.f15782A.setText(getString(C0349R.string.sync_discover_playlist));
                        return;
                    } else {
                        this.f15782A.setText(getString(C0349R.string.sync_all_hint));
                        return;
                    }
                } else if (a) {
                    this.f15782A.setText(getString(C0349R.string.sync_discover_playlist));
                    return;
                } else {
                    this.f15782A.setText(getString(C0349R.string.sync_all_hint));
                    return;
                }
            default:
                return;
        }
    }

    private void m24664q() {
        this.f15786E.removeCallbacks(this.f15801T);
        if (this.f15786E.getProgress() != 0) {
            this.f15786E.setProgress(this.f15786E.getMax());
            hhx.m23869a(new gff(this), 0, 300);
        }
    }

    private void m24665r() {
        this.f15803o.setOnClickListener(new gfh(this));
        this.f15804p.setOnClickListener(this.f15794M);
        this.f15808t.setOnClickListener(this.f15794M);
        this.f15807s.setOnClickListener(this.f15795N);
        this.f15809y.setOnClickListener(this.f15793L);
        this.f15783B.setOnCheckedChangeListener(this.f15792K);
    }

    private void m24666s() {
        if (!this.f15810z.isShown()) {
            this.f15809y.setBackgroundResource(C0349R.drawable.profile_ic_sync_pause_normal);
            this.f15810z.setVisibility(0);
            Animation rotateAnimation = new RotateAnimation(359.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setDuration(1000);
            this.f15810z.startAnimation(rotateAnimation);
        }
    }

    private void m24667t() {
        if (this.f15810z.isShown()) {
            this.f15809y.setBackgroundResource(C0349R.drawable.profile_ic_sync_normal);
            this.f15810z.setVisibility(8);
            this.f15810z.clearAnimation();
        }
    }

    protected void onResume() {
        super.onResume();
        fkb.m19610a().m19640a(this.f15797P);
        fkb.m19610a().m19639a(this.f15798Q);
        fle.m19717b().m19724a(this.f15791J);
        fmc.m19867a().m19889a(this.f15800S);
        flw.m19819a().m19833a(this.f15800S);
    }

    protected void onPause() {
        fkb.m19610a().m19644b(this.f15797P);
        fkb.m19610a().m19643b(this.f15798Q);
        fle.m19717b().m19729b(this.f15791J);
        fmc.m19867a().m19894b(this.f15800S);
        flw.m19819a().m19838b(this.f15800S);
        super.onPause();
    }

    protected void onDestroy() {
        m24667t();
        this.f15786E.removeCallbacks(this.f15801T);
        super.onDestroy();
    }

    private void m24668u() {
        gyn.m23197a((ak) this, new fyi(new SyncTrafficAlertPopupView(this)));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            heb.m23596a((int) C0349R.string.confirm_view_cancel, 1).show();
        }
        switch (i) {
            case C0277j.f3691b /*160*/:
                if (i2 != -1) {
                    exw.m18454c("UserProfileActivity", "result code:" + i2);
                    m24669v();
                    return;
                } else if (intent != null && intent.getData() != null) {
                    Uri a = gzh.m23374a(this, intent.getData());
                    if (a != null) {
                        this.f15787F = new File(gyn.m23242g());
                        this.f15785D = Uri.fromFile(this.f15787F);
                        gyj.m23145a(this, a, this.f15785D, 100, 100);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 161:
                if (i2 != -1) {
                    exw.m18454c("UserProfileActivity", "result code:" + i2);
                    m24669v();
                    return;
                }
                this.f15787F = new File(gyn.m23242g());
                this.f15785D = Uri.fromFile(this.f15787F);
                gyj.m23145a(this, this.f15789H, this.f15785D, 100, 100);
                return;
            case 162:
                if (i2 != -1) {
                    exw.m18454c("UserProfileActivity", "result code:" + i2);
                    m24669v();
                    return;
                }
                m24647a(intent);
                return;
            default:
                return;
        }
    }

    private void m24669v() {
        if (this.f15787F != null && this.f15787F.exists()) {
            this.f15787F.delete();
        }
        if (this.f15788G != null && this.f15788G.exists()) {
            this.f15788G.delete();
        }
    }

    private void m24647a(Intent intent) {
        Bitmap decodeStream;
        if (intent == null || intent.getExtras() == null || intent.getExtras().getParcelable("data") == null) {
            try {
                decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(this.f15785D));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        decodeStream = (Bitmap) intent.getExtras().getParcelable("data");
        this.f15807s.setImageBitmap(decodeStream);
        gyn.m23189a(decodeStream);
        m24669v();
        fle.m19717b().m19739e(true);
        fiw.m19470d(this);
    }

    public boolean mo540i() {
        return false;
    }

    private boolean m24670w() {
        return gvj.m22880S(this) || fkb.m19610a().m19645c() || (((Boolean) eyw.m18568a(this).second).booleanValue() && gvj.m22879R(eys.m18562a()));
    }
}
