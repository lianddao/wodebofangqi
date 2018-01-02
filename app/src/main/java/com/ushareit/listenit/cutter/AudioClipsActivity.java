package com.ushareit.listenit.cutter;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.fog;
import com.ushareit.listenit.foh;
import com.ushareit.listenit.foi;
import com.ushareit.listenit.foj;
import com.ushareit.listenit.fok;
import com.ushareit.listenit.fol;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.guo;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.hdz;
import com.ushareit.listenit.hhx;
import com.ushareit.listenit.widget.IndexableListView;
import com.ushareit.listenit.widget.SearchWidget;

public class AudioClipsActivity extends fjt {
    private gum f9017A;
    private hdz f9018B = new foh(this);
    private OnClickListener f9019C = new foi(this);
    private OnItemClickListener f9020D = new foj(this);
    private guo f9021E = new fok(this);
    private View f9022n;
    private IndexableListView f9023o;
    private View f9024p;
    private fol f9025q;
    private View f9026r;
    private View f9027s;
    private TextView f9028t;
    private View f9029y;
    private SearchWidget f9030z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.audio_cutter_activity);
        this.f9023o = (IndexableListView) findViewById(C0349R.id.list_view);
        this.f9022n = findViewById(C0349R.id.no_music);
        this.f9024p = findViewById(C0349R.id.progress_view);
        this.f9026r = findViewById(C0349R.id.actionbar_view);
        this.f9027s = findViewById(C0349R.id.actionbar_bg);
        this.f9030z = (SearchWidget) findViewById(C0349R.id.search_widget);
        this.f9028t = (TextView) findViewById(C0349R.id.title);
        this.f9029y = findViewById(C0349R.id.back);
        this.f9029y.setOnClickListener(this.f9019C);
        this.f9025q = new fol(this);
        this.f9023o.setFastScrollEnabled(true);
        this.f9023o.setAdapter(this.f9025q);
        this.f9023o.setOnItemClickListener(this.f9020D);
        this.f9030z.setSearchListener(this.f9018B);
        this.f9028t.setText(getString(C0349R.string.audio_clip_title));
        if (gyn.m23217b()) {
            int e = fbb.m18766e(this);
            gyn.m23237e(this.f9026r, e);
            gyn.m23224c(this.f9027s, e + ((int) getResources().getDimension(C0349R.dimen.common_dimens_50dp)));
        }
        mo539h();
    }

    public void mo541k() {
        super.mo541k();
        this.f9017A = m4860n();
        if (this.f9017A != null) {
            this.f9017A.mo2416a(this.f9021E);
        }
    }

    protected void onDestroy() {
        if (this.f9017A != null) {
            this.f9017A.mo2430b(this.f9021E);
        }
        if (this.f9017A != null && this.f9017A.mo2456m()) {
            this.f9017A.mo2458o();
        }
        super.onDestroy();
    }

    public void mo539h() {
        hhx.m23867a(new fog(this));
    }

    private void m12789j() {
        this.f9023o.setVisibility(8);
        this.f9022n.setVisibility(0);
        ((TextView) this.f9022n.findViewById(C0349R.id.no_music_title)).setText(getResources().getString(C0349R.string.audio_clip_no_music));
    }

    public boolean mo540i() {
        finish();
        return false;
    }

    public void finish() {
        if (this.f9017A != null && this.f9017A.mo2456m()) {
            this.f9017A.mo2458o();
        }
        super.finish();
    }
}
