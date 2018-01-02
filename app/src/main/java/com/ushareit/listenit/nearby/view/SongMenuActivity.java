package com.ushareit.listenit.nearby.view;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.feh;
import com.ushareit.listenit.fei;
import com.ushareit.listenit.fhy;
import com.ushareit.listenit.fir;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.fni;
import com.ushareit.listenit.fnl;
import com.ushareit.listenit.frd;
import com.ushareit.listenit.glp;
import com.ushareit.listenit.gmp;
import com.ushareit.listenit.gmq;
import com.ushareit.listenit.gmr;
import com.ushareit.listenit.gms;
import com.ushareit.listenit.gmt;
import com.ushareit.listenit.gmu;
import com.ushareit.listenit.gmv;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.heb;
import com.ushareit.listenit.nearby.widget.SongsMenuBlurView;
import com.ushareit.listenit.theme.entry.CustomThemeRelativeLayout;
import com.ushareit.listenit.theme.entry.CustomThemeTextView;
import com.ushareit.listenit.theme.entry.CustomThemeView;
import java.util.List;

public class SongMenuActivity extends fjt {
    private ImageView f15999A;
    private TextView f16000B;
    private ImageView f16001C;
    private TextView f16002D;
    private long f16003E = 0;
    private OnScrollListener f16004F = new gmq(this);
    private fei f16005G = new gms(this);
    private OnClickListener f16006H = new gmt(this);
    private OnTouchListener f16007I = new gmu(this);
    private OnClickListener f16008J = new gmv(this);
    OnClickListener f16009n = new gmr(this);
    private ListView f16010o;
    private feh f16011p;
    private fni f16012q;
    private fnl f16013r;
    private View f16014s;
    private SongsMenuBlurView f16015t;
    private CustomThemeView f16016y;
    private CustomThemeRelativeLayout f16017z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.my_home_page_activity);
        this.f16012q = (fni) getIntent().getSerializableExtra("nearby_user");
        this.f16013r = (fnl) getIntent().getSerializableExtra("sharelist");
        boolean z = (this.f16012q == null || this.f16013r == null) ? false : true;
        fir.m19383b(z);
        if (this.f16013r == null) {
            finish();
            return;
        }
        m25186h();
        if (this.f16013r.getSgN() != 0) {
            m25195p();
        }
    }

    private void m25186h() {
        this.f16010o = (ListView) findViewById(C0349R.id.list_view);
        this.f16016y = (CustomThemeView) findViewById(C0349R.id.actionbar_bg);
        this.f16017z = (CustomThemeRelativeLayout) findViewById(C0349R.id.actionbar_view);
        CustomThemeTextView customThemeTextView = (CustomThemeTextView) findViewById(C0349R.id.title);
        this.f16001C = (ImageView) findViewById(C0349R.id.collection_playlist);
        this.f16001C.setVisibility(0);
        this.f16001C.setOnClickListener(this.f16008J);
        this.f16001C.setClickable(false);
        if (frd.m20619c(this.f16013r.getId())) {
            this.f16001C.setImageResource(C0349R.drawable.collection_title_pressed);
        }
        this.f16014s = findViewById(C0349R.id.progress_view);
        if (this.f16013r.getSgN() == 0) {
            this.f16014s.setVisibility(8);
        }
        if (this.f16013r != null) {
            customThemeTextView.setText(this.f16013r.getNa());
        }
        if (gyn.m23217b()) {
            int e = fbb.m18766e(this);
            gyn.m23237e(this.f16017z, e);
            gyn.m23224c(this.f16016y, e + ((int) getResources().getDimension(C0349R.dimen.common_dimens_50dp)));
        }
        m25189j();
        this.f16011p = new feh(this);
        this.f16010o.setAdapter(this.f16011p);
        findViewById(C0349R.id.back).setOnClickListener(this.f16009n);
        this.f16011p.m18950a(this.f16005G);
        this.f16010o.setOnScrollListener(this.f16004F);
    }

    private void m25189j() {
        this.f16015t = new SongsMenuBlurView(this);
        View inflate = LayoutInflater.from(this).inflate(C0349R.layout.my_home_page_songs_count, null);
        this.f15999A = (ImageView) inflate.findViewById(C0349R.id.collection_all);
        this.f16002D = (TextView) inflate.findViewById(C0349R.id.download_all);
        if (fhy.m19213a()) {
            this.f16002D.setVisibility(0);
        } else {
            this.f15999A.setVisibility(0);
        }
        ((TextView) inflate.findViewById(C0349R.id.title)).setText(getResources().getString(C0349R.string.search_fragment_search_by_songs));
        this.f16000B = (TextView) inflate.findViewById(C0349R.id.playlist_count);
        this.f16010o.addHeaderView(this.f16015t);
        this.f16010o.addHeaderView(inflate);
        this.f16015t.m25217a(this.f16013r);
    }

    private void m25195p() {
        glp.m22381a(this.f16012q, this.f16013r, new gmp(this));
    }

    private void m25196q() {
        this.f16002D.setText(getString(C0349R.string.nearby_song_menu_downloaded));
        this.f16002D.setTextColor(getResources().getColor(C0349R.color.common_fffd8442));
        Drawable drawable = getResources().getDrawable(C0349R.drawable.downloaded_all);
        this.f16002D.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        if (VERSION.SDK_INT >= 17) {
            this.f16002D.setCompoundDrawablesRelative(drawable, null, null, null);
        }
        this.f16002D.setBackgroundDrawable(getResources().getDrawable(C0349R.drawable.downloaded_all_background));
        this.f16002D.setOnTouchListener(null);
    }

    private void m25197r() {
        if (fhy.m19213a()) {
            heb.m23597a(getString(C0349R.string.nearby_song_add_to_all_songs_b), 0).show();
        } else {
            heb.m23597a(getString(C0349R.string.nearby_song_add_to_all_songs), 0).show();
        }
    }

    private void m25198s() {
        List b = this.f16011p.m18953b();
        if (frd.m20617b(this.f16013r.getId())) {
            String t;
            if (frd.m20611a(this.f16013r.getNa(), this.f16013r.getId())) {
                t = m25199t();
            } else {
                t = this.f16013r.getNa();
            }
            frd.m20614b(this.f16013r.getId(), t);
            frd.m20623g(this.f16013r.getId());
            frd.m20616b(b, this.f16013r.getId());
            return;
        }
        frd.m20598a(this.f16013r.getId(), m25199t(), 0);
        frd.m20616b(b, this.f16013r.getId());
    }

    private String m25199t() {
        String na = this.f16013r.getNa();
        String str = "";
        int i = 1;
        while (frd.m20610a(na + str)) {
            StringBuilder append = new StringBuilder().append("(");
            int i2 = i + 1;
            str = append.append(i).append(")").toString();
            i = i2;
        }
        return na + str;
    }

    public boolean mo540i() {
        return false;
    }

    protected void onDestroy() {
        if (this.f16003E > 0) {
            fir.m19393e(System.currentTimeMillis() - this.f16003E);
        } else {
            fir.m19410l();
        }
        super.onDestroy();
    }
}
