package com.ushareit.listenit;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import com.ushareit.listenit.widget.LoadMoreListView;

public class gua extends gsq {
    private hby aj = new guc(this);
    private OnScrollListener ak = new gud(this);
    private gsw al = new gue(this);
    private guo am = new guf(this);
    gum f14729d;
    private gsx f14730e;
    private gaq f14731f;
    private int f14732g;
    private String f14733h;
    private LoadMoreListView f14734i;

    public void mo2740a(ViewGroup viewGroup) {
        m19526a(false);
        Bundle k = m1324k();
        String string = (k == null || fbb.m18763c(k.getString("search_key"))) ? "" : k.getString("search_key");
        this.f14733h = string;
        this.f14731f = new gaq();
        m22802a(View.inflate(m1326l(), C0349R.layout.search_netsong_result, viewGroup));
        if (!fbb.m18763c(this.f14733h)) {
            mo2550c();
        }
    }

    private void m22802a(View view) {
        m22715c(this.f14733h);
        m22713a(this.al);
        this.f14730e = new gsx(m1326l(), this.f14731f);
        this.f14730e.m22725a(new gug(this, this.f14731f));
        this.f14734i = (LoadMoreListView) view.findViewById(C0349R.id.list_view);
        this.f14734i.setOnLoadMoreListener(this.aj);
        this.f14734i.setAdapter(this.f14730e);
        this.f14734i.setOnScrollListener(this.ak);
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
        super.mo2548a(com_ushareit_listenit_gum);
        this.f14729d = com_ushareit_listenit_gum;
        if (com_ushareit_listenit_gum != null) {
            com_ushareit_listenit_gum.mo2416a(this.am);
        }
    }

    public void mo203z() {
        if (this.f14729d != null) {
            this.f14729d.mo2430b(this.am);
        }
        super.mo203z();
    }

    public void mo2550c() {
        m22707U();
        if (this.f14732g == 0) {
            this.f14734i.setVisibility(8);
            m22708V();
            fiv.m19446c(eys.m18562a());
        }
        hhx.m23867a(new gub(this));
    }

    private void m22807d(String str) {
        if (!fbb.m18763c(str)) {
            this.f14732g = 0;
            this.f14733h = str;
            m22707U();
            mo2550c();
        }
    }
}
