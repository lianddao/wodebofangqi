package com.ushareit.listenit.nearby.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ah;
import com.ushareit.listenit.ak;
import com.ushareit.listenit.bh;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fir;
import com.ushareit.listenit.fji;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.gef;
import com.ushareit.listenit.gmh;
import com.ushareit.listenit.gmk;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.theme.entry.CustomThemeView;

public class NearbyActivity extends fjt implements OnClickListener {
    private ImageView f15993n;
    private CustomThemeView f15994o;
    private fji f15995p;
    private View f15996q;
    private View f15997r;
    private TextView f15998s;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.nearby_activity);
        m25170p();
        m25171q();
        m25172r();
    }

    private void m25170p() {
        this.f15994o = (CustomThemeView) findViewById(C0349R.id.actionbar_bg);
        this.f15996q = findViewById(C0349R.id.actionbar_view);
        this.f15993n = (ImageView) findViewById(C0349R.id.back);
        this.f15997r = findViewById(C0349R.id.no_login_back);
        this.f15998s = (TextView) findViewById(C0349R.id.title);
        this.f15993n.setOnClickListener(this);
        this.f15997r.setOnClickListener(this);
    }

    private void m25171q() {
        if (gyn.m23217b()) {
            int e = fbb.m18766e(this);
            gyn.m23237e(this.f15996q, e);
            gyn.m23224c(this.f15994o, e + ((int) getResources().getDimension(C0349R.dimen.common_dimens_50dp)));
        }
    }

    private void m25172r() {
        if (gef.m21805a().m21835e()) {
            this.f15995p = m25176j();
        } else {
            this.f15995p = mo539h();
        }
        gyn.m23195a((ak) this, (int) C0349R.id.nearby_content, this.f15995p);
    }

    public fji mo539h() {
        this.f15993n.setVisibility(8);
        this.f15997r.setVisibility(0);
        this.f15998s.setTextColor(getResources().getColor(C0349R.color.navigation_item_text_color));
        erj.m17570a(this.f15994o, 0.0f);
        return new gmh();
    }

    public fji m25176j() {
        this.f15993n.setVisibility(0);
        this.f15997r.setVisibility(8);
        this.f15998s.setTextColor(getResources().getColor(C0349R.color.common_text_color_white));
        erj.m17570a(this.f15994o, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        return new gmk();
    }

    protected void onDestroy() {
        if (this.f15995p instanceof gmk) {
            fir.m19404i();
        }
        super.onDestroy();
    }

    public boolean mo540i() {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (gef.m21805a().m21835e() && (this.f15995p instanceof gmh)) {
            this.f15995p = m25176j();
            m25173a(C0349R.id.nearby_content, this.f15995p);
            erj.m17570a(this.f15994o, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
    }

    public void m25173a(int i, ah ahVar) {
        try {
            bh a = m709f().mo797a();
            a.mo3096b(i, ahVar);
            a.mo3098c();
        } catch (Exception e) {
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0349R.id.back:
                finish();
                return;
            case C0349R.id.no_login_back:
                finish();
                return;
            default:
                return;
        }
    }
}
