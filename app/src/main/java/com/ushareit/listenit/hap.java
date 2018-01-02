package com.ushareit.listenit;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.ushareit.listenit.theme.entry.CustomThemeImageView;
import java.util.List;

public class hap extends hbh {
    private gjf f15068A;
    private OnClickListener f15069B = new haq(this);
    private OnClickListener f15070C = new har(this);
    private fdw f15071D = new hat(this);
    private fyv f15072E = new hau(this);
    private OnScrollListener f15073F = new haw(this);
    private OnClickListener f15074G = new hax(this);
    private OnClickListener f15075H = new hay(this);
    public CustomThemeImageView f15076k;
    public TextView f15077l;
    public TextView f15078m;
    public ImageView f15079n;
    private ListView f15080p;
    private fdu f15081q;
    private View f15082r;
    private View f15083s;
    private boolean f15084t;
    private View f15085u;
    private View f15086v;
    private gar f15087w = new gar();
    private View f15088x;
    private gla f15089y;
    private boolean f15090z = false;

    public static View m23466a(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.main_card_playlist, viewGroup, false);
    }

    public hap(Context context, View view) {
        super(context, view);
        this.f15083s = view.findViewById(C0349R.id.manage);
        this.f15086v = view.findViewById(C0349R.id.playlist_divider);
        this.f15082r = view.findViewById(C0349R.id.new_playlist);
        this.f15080p = (ListView) view.findViewById(C0349R.id.list_view);
        this.f15085u = view.findViewById(C0349R.id.add_playlist_area);
        this.f15088x = view.findViewById(C0349R.id.recommend_playlist);
        this.f15088x.setVisibility(8);
        this.f15081q = new fdu(this.f15087w);
        this.f15080p.setAdapter(this.f15081q);
        this.f15080p.setOnScrollListener(this.f15073F);
        this.f15083s.setOnClickListener(this.f15069B);
        this.f15082r.setOnClickListener(this.f15070C);
        this.f15085u.setOnClickListener(this.f15070C);
        this.f15081q.m18920a(this.f15071D);
    }

    private void m23468a(View view) {
        CharSequence ai = gvj.ai(this.o);
        if (!this.f15090z || TextUtils.isEmpty(ai)) {
            this.f15088x.setVisibility(0);
            this.f15076k = (CustomThemeImageView) view.findViewById(C0349R.id.icon);
            this.f15077l = (TextView) view.findViewById(C0349R.id.title);
            this.f15078m = (TextView) view.findViewById(C0349R.id.sub_title);
            this.f15079n = (ImageView) view.findViewById(C0349R.id.more);
            this.f15089y = fqx.m20491a();
            if (this.f15089y == null) {
                this.f15088x.setVisibility(8);
                return;
            }
            this.f15090z = true;
            fzi.m21401a(this.o, this.f15089y, this.f15076k, tv.NORMAL, (int) this.o.getResources().getDimension(C0349R.dimen.common_dimens_45dp));
            this.f15077l.setText(this.f15089y.mo2562c());
            this.f15078m.setText(view.getContext().getResources().getString(C0349R.string.recommend_item_sub_title));
            this.f15079n.setImageResource(C0349R.drawable.active_playlist_delete_icon_bg);
            int dimensionPixelSize = this.o.getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_14dp);
            this.f15079n.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            this.f15079n.setOnClickListener(this.f15074G);
            this.f15088x.setOnClickListener(this.f15075H);
        }
    }

    public void mo2564a(gjc com_ushareit_listenit_gjc, int i) {
        this.f15068A = (gjf) com_ushareit_listenit_gjc;
        List a = this.f15068A.m22067a();
        if (a.size() > 0) {
            this.f15082r.setVisibility(0);
            this.f15086v.setVisibility(0);
            this.f15085u.setVisibility(8);
            this.f15080p.setVisibility(0);
            this.f15083s.setVisibility(0);
            gyn.m23224c(this.f15080p, ((int) this.o.getResources().getDimension(C0349R.dimen.common_dimens_63dp)) * a.size());
            this.f15081q.m18921a(a);
            m23468a(this.itemView);
            return;
        }
        this.f15082r.setVisibility(8);
        this.f15085u.setVisibility(0);
        this.f15080p.setVisibility(8);
        this.f15086v.setVisibility(8);
        this.f15083s.setVisibility(4);
    }

    public void mo2563s() {
    }

    public void m23497a(String str, int i) {
        frd.m20597a(str, i);
    }

    public void m23498a(boolean z) {
        if (z || !this.f15084t) {
            hhx.m23867a(new hav(this));
        }
    }
}
