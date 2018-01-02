package com.ushareit.listenit.album;

import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fhk;
import com.ushareit.listenit.fho;
import com.ushareit.listenit.fhp;
import com.ushareit.listenit.fhr;
import com.ushareit.listenit.fhs;
import com.ushareit.listenit.fht;
import com.ushareit.listenit.fhu;
import com.ushareit.listenit.fhv;
import com.ushareit.listenit.fjf;
import com.ushareit.listenit.gnj;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.hby;
import com.ushareit.listenit.hdp;
import com.ushareit.listenit.widget.LoadMoreListView;
import java.util.List;

public class SearchAlbumArtActivity extends fjf {
    private OnClickListener f4626A = new fht(this);
    private OnDismissListener f4627B = new fhu(this);
    private TextView f4628n;
    private EditText f4629o;
    private LoadMoreListView f4630p;
    private hdp f4631q;
    private fhv f4632r;
    private fhk f4633s;
    private hby f4634t = new fhp(this);
    private OnEditorActionListener f4635y = new fhr(this);
    private OnClickListener f4636z = new fhs(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.search_album_art_activity);
        String stringExtra = getIntent().getStringExtra("extra_album_name");
        m5968h();
        m5959a(stringExtra);
        m5963b(stringExtra);
        this.f4633s = new fhk();
        m5965c(stringExtra);
    }

    private void m5968h() {
        View findViewById = findViewById(C0349R.id.status_fake_bar);
        if (gyn.m23217b()) {
            gyn.m23224c(findViewById, fbb.m18766e(this));
        } else {
            findViewById.setVisibility(8);
        }
    }

    private void m5959a(String str) {
        ImageView imageView = (ImageView) findViewById(C0349R.id.back);
        this.f4629o = (EditText) findViewById(C0349R.id.edit);
        this.f4628n = (TextView) findViewById(C0349R.id.no_result);
        View findViewById = findViewById(C0349R.id.search_delete);
        this.f4629o.setHint(17039372);
        this.f4629o.setFilters(new InputFilter[]{new LengthFilter(40)});
        this.f4629o.setOnEditorActionListener(this.f4635y);
        this.f4629o.setText(str);
        imageView.setOnClickListener(this.f4636z);
        findViewById.setOnClickListener(this.f4626A);
    }

    private void m5963b(String str) {
        this.f4630p = (LoadMoreListView) findViewById(C0349R.id.list_view);
        this.f4630p.setOnLoadMoreListener(this.f4634t);
        this.f4632r = new fhv();
        this.f4632r.m19210a(str);
        this.f4630p.setAdapter(this.f4632r);
        this.f4630p.setNoMoreText(getString(C0349R.string.search_album_art_no_more));
    }

    private void m5965c(String str) {
        if (!TextUtils.isEmpty(str)) {
            m5970j();
            this.f4631q = hdp.m23585a(this);
            this.f4631q.setOnDismissListener(this.f4627B);
            this.f4628n.setVisibility(4);
            this.f4633s.m19195a(str, new fho(this));
        }
    }

    private void m5960a(List<gnj> list) {
        if (list == null || list.size() <= 0) {
            this.f4628n.setText(C0349R.string.search_album_art_no_result);
            this.f4628n.setVisibility(0);
            this.f4630p.setVisibility(4);
            return;
        }
        this.f4628n.setVisibility(4);
        this.f4630p.setVisibility(0);
        m5961a((List) list, true);
    }

    private void m5961a(List<gnj> list, boolean z) {
        if (z) {
            this.f4632r.m19209a();
        }
        this.f4632r.m19211a((List) list);
        this.f4632r.notifyDataSetChanged();
        this.f4630p.m26855a();
    }

    private void m5969i() {
        this.f4628n.setText(C0349R.string.search_album_art_network_error);
        this.f4628n.setVisibility(0);
        this.f4630p.setVisibility(4);
        this.f4631q.dismiss();
    }

    private void m5970j() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (this.f4629o.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f4629o.getWindowToken(), 0);
        }
    }

    public void mo541k() {
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
