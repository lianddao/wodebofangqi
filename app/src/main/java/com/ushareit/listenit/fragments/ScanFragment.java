package com.ushareit.listenit.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.epm;
import com.ushareit.listenit.eqy;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fio;
import com.ushareit.listenit.fji;
import com.ushareit.listenit.fyx;
import com.ushareit.listenit.fyy;
import com.ushareit.listenit.fyz;
import com.ushareit.listenit.fzb;
import com.ushareit.listenit.fzc;
import com.ushareit.listenit.fzd;
import com.ushareit.listenit.gro;
import com.ushareit.listenit.grr;
import com.ushareit.listenit.gry;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.gvk;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.widget.ScanWidget;

public class ScanFragment extends fji {
    private View f13259a;
    private fzd aj;
    private gry ak = new fyz(this);
    private OnClickListener al = new fzb(this);
    private OnClickListener am = new fzc(this);
    private ScanWidget f13260b;
    private TextView f13261c;
    private TextView f13262d;
    private TextView f13263e;
    private TextView f13264f;
    private Button f13265g;
    private boolean f13266h = false;
    private boolean f13267i = false;

    public void m20572a(fzd com_ushareit_listenit_fzd) {
        this.aj = com_ushareit_listenit_fzd;
    }

    public ScanFragment() {
        m19526a(true);
    }

    public ScanFragment(boolean z) {
        this.f13266h = z;
        m19526a(true);
    }

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(C0349R.layout.main_scan_view, viewGroup, false);
        this.f13259a = inflate.findViewById(C0349R.id.fake_statusbar);
        this.f13260b = (ScanWidget) inflate.findViewById(C0349R.id.scan_widget);
        this.f13261c = (TextView) inflate.findViewById(C0349R.id.scan_progress);
        this.f13262d = (TextView) inflate.findViewById(C0349R.id.music_text);
        this.f13263e = (TextView) inflate.findViewById(C0349R.id.scan_result);
        this.f13264f = (TextView) inflate.findViewById(C0349R.id.scan_file);
        this.f13265g = (Button) inflate.findViewById(C0349R.id.scan_button);
        this.f13261c.setText(m1276a((int) C0349R.string.scan_percent, Integer.valueOf(0)));
        this.f13263e.setText(m1276a((int) C0349R.string.scan_result_song_count, Integer.valueOf(0)));
        this.f13265g.setOnClickListener(this.am);
        this.f13260b.setOnClickListener(this.al);
        m20560U();
        return inflate;
    }

    private void m20560U() {
        int c = fbb.m18762c(m1326l());
        if (fbb.m18764d(m1326l()) < c) {
            c = fbb.m18764d(m1326l());
        }
        int c2 = (int) (((float) fbb.m18762c(m1326l())) * 0.72f);
        gyn.m23213b(this.f13260b, c2);
        gyn.m23224c(this.f13260b, c2);
        c = (int) (((float) c) * 0.653f);
        c2 = (int) (((float) c) * 0.153f);
        this.f13265g.setMinWidth(c);
        this.f13265g.setMinHeight(c2);
        if (gyn.m23217b()) {
            gyn.m23224c(this.f13259a, fbb.m18766e(m1326l()));
        }
    }

    public void mo2550c() {
        grr.m22621a().m22644a(this.ak);
        grr.m22621a().m22643a(new gro(gvk.m23052c()));
        grr.m22621a().m22642a(m1326l(), false);
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
    }

    public void mo201x() {
        if (!this.f13267i) {
            this.f13267i = true;
            this.f13260b.m26988b();
            mo2550c();
        }
        super.mo201x();
    }

    public boolean mo2549b() {
        this.am.onClick(null);
        fio.m19368c(m1326l(), "back");
        return false;
    }

    public void mo175h() {
        grr.m22621a().m22646b(this.ak);
        super.mo175h();
    }

    private void m20562a(epm com_ushareit_listenit_epm) {
        eqy b = eqy.m17366b(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f);
        b.mo2252c(600);
        b.m17384a(new fyx(this));
        b.m17274a(new fyy(this, com_ushareit_listenit_epm));
        b.mo2234a();
    }
}
