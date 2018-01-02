package com.ushareit.listenit.about;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.TextView;
import com.umeng.analytics.pro.C0277j;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fcy;
import com.ushareit.listenit.fcz;
import com.ushareit.listenit.fda;
import com.ushareit.listenit.fdb;
import com.ushareit.listenit.fdc;
import com.ushareit.listenit.fde;
import com.ushareit.listenit.fdf;
import com.ushareit.listenit.fii;
import com.ushareit.listenit.fjk;
import com.ushareit.listenit.fql;
import com.ushareit.listenit.gyj;
import com.ushareit.listenit.gzc;
import com.ushareit.listenit.hjb;
import com.ushareit.listenit.settings.ProductSettingsActivity;
import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends fjk {
    private static int f4053n = 0;
    private ExpandableListView f4054o;
    private fdc f4055p;
    private List<fdf> f4056q = new ArrayList();
    private int f4057r = -1;
    private Handler f4058s = new fcy(this);
    private OnClickListener f4059t = new fcz(this);
    private OnGroupClickListener f4060y = new fda(this);
    private OnChildClickListener f4061z = new fdb(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gzc.m23341a((Activity) this, (int) C0349R.color.common_actionbar_color);
        setContentView(C0349R.layout.about_main_activity);
        setTitle(C0349R.string.about_name);
        m5103d(8);
        this.f4054o = (ExpandableListView) findViewById(C0349R.id.list_view);
        this.f4055p = new fdc(this);
        this.f4054o.setAdapter(this.f4055p);
        this.f4054o.setDividerHeight(0);
        this.f4054o.setOnGroupClickListener(this.f4060y);
        this.f4054o.setOnChildClickListener(this.f4061z);
        TextView textView = (TextView) findViewById(C0349R.id.version);
        textView.setText("v " + fql.m20392d());
        textView.setOnClickListener(this.f4059t);
        ((TextView) findViewById(C0349R.id.contact_us)).setText("Listenit@ushareit.com");
        m5117j();
    }

    public boolean mo539h() {
        return false;
    }

    public boolean mo540i() {
        return false;
    }

    private void m5116e(int i) {
        switch (((fdf) this.f4056q.get(i)).f12457a) {
            case C0349R.string.about_user_privacy:
                gyj.m23147a((Context) this, "http://w.ushareit.com/w/listenit/agreement/privacy.html");
                fii.m19304b((Context) this, "user_privacy");
                return;
            case C0349R.string.about_user_service:
                gyj.m23147a((Context) this, "http://w.ushareit.com/w/listenit/agreement/service.html");
                fii.m19304b((Context) this, "user_service");
                return;
            case C0349R.string.about_version_check:
                hjb.m23925b(this);
                fii.m19304b((Context) this, "check_update");
                return;
            default:
                return;
        }
    }

    private void m5110a(fde com_ushareit_listenit_fde) {
    }

    private void m5117j() {
        fdf com_ushareit_listenit_fdf = new fdf();
        com_ushareit_listenit_fdf.f12457a = C0349R.string.about_version_check;
        com_ushareit_listenit_fdf.f12458b = false;
        com_ushareit_listenit_fdf.f12459c = null;
        this.f4056q.add(com_ushareit_listenit_fdf);
        com_ushareit_listenit_fdf = new fdf();
        com_ushareit_listenit_fdf.f12457a = C0349R.string.about_user_service;
        com_ushareit_listenit_fdf.f12458b = false;
        com_ushareit_listenit_fdf.f12459c = null;
        this.f4056q.add(com_ushareit_listenit_fdf);
        com_ushareit_listenit_fdf = new fdf();
        com_ushareit_listenit_fdf.f12457a = C0349R.string.about_user_privacy;
        com_ushareit_listenit_fdf.f12458b = false;
        com_ushareit_listenit_fdf.f12459c = null;
        this.f4056q.add(com_ushareit_listenit_fdf);
        this.f4055p.m18878a(this.f4056q);
    }

    private void m5118p() {
        f4053n++;
        if (f4053n >= 3) {
            f4053n = 0;
            m5119q();
            return;
        }
        this.f4058s.sendEmptyMessageDelayed(C0277j.f3694e, 2000);
    }

    private void m5119q() {
        startActivity(new Intent(this, ProductSettingsActivity.class));
    }
}
