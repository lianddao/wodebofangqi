package com.ushareit.listenit.popupview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fdu;
import com.ushareit.listenit.fdw;
import com.ushareit.listenit.fis;
import com.ushareit.listenit.fqs;
import com.ushareit.listenit.frd;
import com.ushareit.listenit.frg;
import com.ushareit.listenit.fxh;
import com.ushareit.listenit.gaw;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.glc;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.goe;
import com.ushareit.listenit.gof;
import com.ushareit.listenit.goh;
import com.ushareit.listenit.goi;
import com.ushareit.listenit.goj;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.heb;
import com.ushareit.listenit.hhx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddToPlaylistPopupView extends BasePopupView {
    public List<glc> f16132a = new ArrayList();
    public List<glg> f16133b = new ArrayList();
    private View f16134c;
    private gla f16135d;
    private ListView f16136e;
    private fdu f16137f;
    private gaw f16138g = new gaw();
    private int f16139h;
    private boolean f16140i;
    private goj f16141j;
    private OnClickListener f16142k = new gof(this);
    private fdw f16143l = new goh(this);
    private OnScrollListener f16144m = new goi(this);

    public AddToPlaylistPopupView(Context context, int i, String str) {
        super(context);
        this.f16139h = i;
        m25539a(context, (ViewGroup) this);
        fis.m19426d(getContext(), str);
    }

    public AddToPlaylistPopupView(Context context, int i) {
        super(context);
        this.f16139h = i;
        m25539a(context, (ViewGroup) this);
        fis.m19426d(getContext(), gyn.m23181a(i));
    }

    public void m25539a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_add_to_playlist, viewGroup);
        this.f16134c = inflate.findViewById(C0349R.id.new_playlist);
        this.f16136e = (ListView) inflate.findViewById(C0349R.id.list_view);
        this.f16137f = new fdu(this.f16138g);
        this.f16136e.setAdapter(this.f16137f);
        this.f16136e.setOnScrollListener(this.f16144m);
        this.f16134c.setOnClickListener(this.f16142k);
        this.f16137f.m18920a(this.f16143l);
        m25542d();
    }

    public boolean m25541a() {
        return this.f16140i;
    }

    public int getGravity() {
        return 17;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
        this.f16135d = com_ushareit_listenit_gla;
    }

    public void setItems(List<glg> list) {
        if (list != null && list.size() != 0) {
            this.f16133b.clear();
            this.f16133b.addAll(list);
        }
    }

    public void setSaveListener(goj com_ushareit_listenit_goj) {
        this.f16141j = com_ushareit_listenit_goj;
    }

    public void setTitle(String str) {
    }

    public void m25542d() {
        hhx.m23867a(new goe(this));
    }

    private void m25534a(String str) {
        if (!fbb.m18763c(str)) {
            if (this.f16133b.size() == 0) {
                if (this.f16135d instanceof glg) {
                    this.f16133b.clear();
                    this.f16133b.add((glg) this.f16135d);
                } else {
                    Collection a = fqs.m20453a(this.f16135d);
                    this.f16133b.clear();
                    this.f16133b.addAll(a);
                }
            }
            if (this.f16133b.size() != 0) {
                frd.m20608a(this.f16133b, str);
                for (glg com_ushareit_listenit_glg : this.f16133b) {
                    if (gyn.m23260p(com_ushareit_listenit_glg.f14342j)) {
                        frg.m20701e(com_ushareit_listenit_glg);
                    }
                }
                heb.m23597a(getResources().getString(C0349R.string.toast_add_to_playlist), 0).show();
                fxh.m21246Z();
                this.f16140i = true;
                if (this.f16141j != null) {
                    this.f16141j.mo2612a();
                }
            }
        }
    }

    public void m25540a(String str, int i) {
        m25534a(frd.m20597a(str, i));
    }

    private void m25535a(List<glg> list) {
        for (glg a : list) {
            a.m20775a(false);
        }
    }
}
