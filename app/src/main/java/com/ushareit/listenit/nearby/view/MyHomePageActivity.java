package com.ushareit.listenit.nearby.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fdx;
import com.ushareit.listenit.fir;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.fni;
import com.ushareit.listenit.glp;
import com.ushareit.listenit.gmd;
import com.ushareit.listenit.gme;
import com.ushareit.listenit.gmf;
import com.ushareit.listenit.gmg;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.nearby.widget.MyHomePageBlurView;
import com.ushareit.listenit.theme.entry.CustomThemeTextView;
import com.ushareit.listenit.theme.entry.CustomThemeView;

public class MyHomePageActivity extends fjt {
    private OnItemClickListener f15983A = new gmg(this);
    OnClickListener f15984n = new gmf(this);
    private fni f15985o;
    private ListView f15986p;
    private MyHomePageBlurView f15987q;
    private fdx f15988r;
    private CustomThemeView f15989s;
    private View f15990t;
    private long f15991y = 0;
    private OnScrollListener f15992z = new gme(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.my_home_page_activity);
        this.f15985o = (fni) getIntent().getSerializableExtra("nearby_user");
        fir.m19379a(this.f15985o != null);
        if (this.f15985o == null) {
            finish();
            return;
        }
        m25166h();
        m25168p();
    }

    private void m25166h() {
        ((CustomThemeTextView) findViewById(C0349R.id.title)).setText(this.f15985o.getNm());
        this.f15990t = findViewById(C0349R.id.progress_view);
        this.f15989s = (CustomThemeView) findViewById(C0349R.id.actionbar_bg);
        View findViewById = findViewById(C0349R.id.actionbar_view);
        if (gyn.m23217b()) {
            int e = fbb.m18766e(this);
            gyn.m23237e(findViewById, e);
            gyn.m23224c(this.f15989s, ((int) getResources().getDimension(C0349R.dimen.common_dimens_50dp)) + e);
        }
        this.f15986p = (ListView) findViewById(C0349R.id.list_view);
        m25167j();
        this.f15988r = new fdx(this);
        this.f15986p.setAdapter(this.f15988r);
        findViewById(C0349R.id.back).setOnClickListener(this.f15984n);
        this.f15986p.setOnItemClickListener(this.f15983A);
        this.f15986p.setOnScrollListener(this.f15992z);
    }

    private void m25167j() {
        this.f15987q = new MyHomePageBlurView(this);
        View inflate = LayoutInflater.from(this).inflate(C0349R.layout.my_home_page_songs_count, null);
        ((CustomThemeTextView) inflate.findViewById(C0349R.id.playlist_count)).setText("(" + this.f15985o.getPlN() + ")");
        this.f15986p.addHeaderView(this.f15987q);
        this.f15986p.addHeaderView(inflate);
        this.f15987q.m25208a(this.f15985o);
    }

    private void m25168p() {
        glp.m22382a(this.f15985o, new gmd(this));
    }

    public boolean mo540i() {
        return false;
    }

    protected void onDestroy() {
        if (this.f15991y > 0) {
            fir.m19389d(System.currentTimeMillis() - this.f15991y);
        } else {
            fir.m19409k();
        }
        super.onDestroy();
    }
}
