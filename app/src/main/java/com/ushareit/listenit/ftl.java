package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.widget.youtubevideoplayer.YouTubePlayerView;
import java.util.Locale;

public class ftl extends fji {
    private YouTubePlayerView f13479a;
    private Bitmap aj;
    private Drawable ak;
    private Rect al;
    private boolean am;
    private boolean an = false;
    private RelativeLayout ao;
    private View ap;
    private ImageView aq;
    private boolean ar = false;
    private OnClickListener as = new ftm(this);
    private gxs at = new ftn(this);
    private hfb au = new fto(this);
    private hfs av = new ftp(this);
    private OnTouchListener aw = new ftq(this);
    private OnClickListener ax = new ftr(this);
    private RelativeLayout f13480b;
    private TextView f13481c;
    private View f13482d;
    private View f13483e;
    private View f13484f;
    private ImageView f13485g;
    private String f13486h;
    private String f13487i;

    public ftl(String str, String str2, Bitmap bitmap, Drawable drawable) {
        this.f13486h = str;
        this.f13487i = str2;
        this.aj = bitmap;
        this.ak = drawable;
        if (this.aj == null) {
            this.ak = eys.m18562a().getResources().getDrawable(C0349R.drawable.mv_default);
            this.aj = ((BitmapDrawable) this.ak).getBitmap();
        }
    }

    public void m20939a(Rect rect) {
        this.al = rect;
    }

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f13480b = (RelativeLayout) layoutInflater.inflate(C0349R.layout.video_player_fragment, viewGroup, false);
        this.f13485g = (ImageView) this.f13480b.findViewById(C0349R.id.blur_background);
        this.f13482d = this.f13480b.findViewById(C0349R.id.blur_mask);
        this.f13483e = this.f13480b.findViewById(C0349R.id.back);
        this.ap = this.f13480b.findViewById(C0349R.id.traffic_alert_button);
        this.f13484f = this.f13480b.findViewById(C0349R.id.share);
        this.f13481c = (TextView) this.f13480b.findViewById(C0349R.id.title);
        this.f13479a = (YouTubePlayerView) this.f13480b.findViewById(C0349R.id.youtube_player_view);
        this.ao = (RelativeLayout) this.f13480b.findViewById(C0349R.id.use_moble_data_note_view);
        if (gyn.m23217b()) {
            gyn.m23237e(this.f13480b.findViewById(C0349R.id.action_bar), fbb.m18766e(m1328m()));
        }
        m20919b(true);
        this.f13483e.setOnClickListener(this.ax);
        this.f13484f.setOnClickListener(this.as);
        this.f13479a.m27107a(this.av);
        this.ap.setOnTouchListener(this.aw);
        return this.f13480b;
    }

    public void m20940a(String str, String str2, Bitmap bitmap, Drawable drawable) {
        this.f13486h = str;
        this.f13487i = str2;
        this.aj = bitmap;
        this.ak = drawable;
        if (this.aj == null) {
            this.ak = m1329n().getDrawable(C0349R.drawable.mv_default);
            this.aj = ((BitmapDrawable) this.ak).getBitmap();
        }
    }

    public void m20937U() {
        this.f13479a.m27113g();
    }

    private void m20919b(boolean z) {
        this.aq = new ImageView(m1326l());
        this.aq.setScaleType(ScaleType.CENTER_CROP);
        this.aq.setImageDrawable(this.ak);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = this.al.width();
        layoutParams.height = this.al.height();
        if (VERSION.SDK_INT < 17 || TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            layoutParams.leftMargin = this.al.left;
        } else {
            layoutParams.setMarginStart((gyr.m23306a() - this.al.left) - this.al.width());
        }
        layoutParams.topMargin = this.al.top;
        layoutParams.bottomMargin = gyr.m23309b() - this.al.bottom;
        this.aq.setLayoutParams(layoutParams);
        this.f13480b.addView(this.aq);
        float a = ((((float) gyr.m23306a()) * 9.0f) / 16.0f) / ((float) this.al.height());
        float a2 = (((float) gyr.m23306a()) / 2.0f) - ((float) this.al.centerX());
        float b = (((float) gyr.m23309b()) / 2.0f) - ((float) this.al.centerY());
        erl.m17583a(this.aq).mo2272a(300).mo2276c((((float) gyr.m23306a()) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) this.al.width())).mo2277d(a).mo2271a(a2).mo2275b(b).mo2274a(new fts(this, z, this.aq));
    }

    private void m20914V() {
        this.ar = true;
        View imageView = new ImageView(m1326l());
        imageView.setScaleType(ScaleType.CENTER_CROP);
        imageView.setImageDrawable(this.ak);
        int a = gyr.m23306a();
        int i = (int) ((((double) a) * 9.0d) / 16.0d);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(a, i);
        layoutParams.topMargin = (int) (((double) (gyr.m23309b() - i)) / 2.0d);
        imageView.setLayoutParams(layoutParams);
        this.f13480b.addView(imageView);
        float height = (((float) this.al.height()) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) i);
        float centerX = ((float) this.al.centerX()) - (((float) gyr.m23306a()) / 2.0f);
        float centerY = ((float) this.al.centerY()) - (((float) gyr.m23309b()) / 2.0f);
        erl.m17583a(imageView).mo2272a(300).mo2276c((((float) this.al.width()) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) a)).mo2277d(height).mo2271a(centerX).mo2275b(centerY).mo2274a(new ftu(this, imageView));
    }

    private void m20915W() {
        if (this.aq != null && this.aq.isShown()) {
            this.f13480b.removeView(this.aq);
            this.ao.setVisibility(8);
        }
        m20914V();
    }

    public void mo2580c(boolean z) {
        exw.m18454c("Video Player", "onHiddenChanged() hidden:" + z);
        if (z) {
            this.f13479a.m27112f();
            this.f13479a.setVisibility(4);
            this.f13485g.setImageBitmap(null);
            this.f13482d.setVisibility(4);
            this.f13483e.setVisibility(4);
            this.f13481c.setVisibility(4);
            this.f13484f.setVisibility(4);
            return;
        }
        m20919b(false);
    }

    public boolean mo2549b() {
        if (this.am) {
            this.f13479a.m27108b();
            return true;
        } else if (m1336u() || this.ar) {
            return false;
        } else {
            m20915W();
            return true;
        }
    }

    public void mo201x() {
        exw.m18454c("Video Player", "fragment onResume()");
        this.an = false;
        super.mo201x();
    }

    public void mo202y() {
        exw.m18454c("Video Player", "fragment onPause()");
        if (this.f13479a.isShown()) {
            this.f13479a.m27112f();
        }
        this.an = true;
        super.mo202y();
    }

    public void mo203z() {
        this.f13479a.m27110d();
        super.mo203z();
    }
}
