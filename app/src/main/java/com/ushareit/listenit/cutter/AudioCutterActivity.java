package com.ushareit.listenit.cutter;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.C0356for;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.fop;
import com.ushareit.listenit.foq;
import com.ushareit.listenit.fos;
import com.ushareit.listenit.fot;
import com.ushareit.listenit.fou;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.hdz;
import com.ushareit.listenit.hhx;
import com.ushareit.listenit.widget.IndexableListView;
import com.ushareit.listenit.widget.SearchWidget;

public class AudioCutterActivity extends fjt {
    private SearchWidget f9031A;
    private hdz f9032B = new foq(this);
    private OnClickListener f9033C = new C0356for(this);
    private OnClickListener f9034D = new fos(this);
    private OnItemClickListener f9035E = new fot(this);
    private View f9036n;
    private IndexableListView f9037o;
    private View f9038p;
    private fou f9039q;
    private View f9040r;
    private View f9041s;
    private View f9042t;
    private TextView f9043y;
    private View f9044z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.audio_cutter_activity);
        this.f9037o = (IndexableListView) findViewById(C0349R.id.list_view);
        this.f9036n = findViewById(C0349R.id.no_music);
        this.f9038p = findViewById(C0349R.id.progress_view);
        this.f9040r = findViewById(C0349R.id.actionbar_view);
        this.f9041s = findViewById(C0349R.id.actionbar_bg);
        this.f9042t = findViewById(C0349R.id.history);
        this.f9031A = (SearchWidget) findViewById(C0349R.id.search_widget);
        this.f9043y = (TextView) findViewById(C0349R.id.title);
        this.f9044z = findViewById(C0349R.id.back);
        this.f9044z.setOnClickListener(this.f9033C);
        this.f9042t.setVisibility(0);
        this.f9042t.setOnClickListener(this.f9034D);
        this.f9039q = new fou(this);
        this.f9037o.setFastScrollEnabled(true);
        this.f9037o.setAdapter(this.f9039q);
        this.f9037o.setOnItemClickListener(this.f9035E);
        this.f9031A.setSearchListener(this.f9032B);
        this.f9043y.setText(getString(C0349R.string.audio_cutter_title));
        if (gyn.m23217b()) {
            int e = fbb.m18766e(this);
            gyn.m23237e(this.f9040r, e);
            gyn.m23224c(this.f9041s, e + ((int) (((double) getResources().getDimension(C0349R.dimen.common_dimens_50dp)) + 0.5d)));
        }
        mo539h();
    }

    public void mo539h() {
        hhx.m23867a(new fop(this));
    }

    private void m12798j() {
        this.f9037o.setVisibility(8);
        this.f9036n.setVisibility(0);
        ((TextView) this.f9036n.findViewById(C0349R.id.no_music_title)).setText(getResources().getString(C0349R.string.playlist_no_music_title));
    }

    public boolean mo540i() {
        finish();
        return false;
    }
}
