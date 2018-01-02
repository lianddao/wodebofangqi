package com.ushareit.listenit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class gzs extends hbh {
    private OnClickListener f14996A = new gzy(this);
    private gry f14997B = new gzz(this);
    private View f14998k;
    private View f14999l;
    private View f15000m;
    private View f15001n;
    private View f15002p;
    private View f15003q;
    private TextView f15004r;
    private TextView f15005s;
    private TextView f15006t;
    private gjd f15007u;
    private OnClickListener f15008v = new gzt(this);
    private OnClickListener f15009w = new gzu(this);
    private OnClickListener f15010x = new gzv(this);
    private OnClickListener f15011y = new gzw(this);
    private OnClickListener f15012z = new gzx(this);

    public static View m23405a(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.main_card_feature, viewGroup, false);
    }

    public gzs(Context context, View view) {
        super(context, view);
        this.f14998k = view.findViewById(C0349R.id.recent_add);
        this.f14999l = view.findViewById(C0349R.id.recent_play);
        this.f15000m = view.findViewById(C0349R.id.favorite);
        this.f15001n = view.findViewById(C0349R.id.recent_add_play);
        this.f15002p = view.findViewById(C0349R.id.recent_play_play);
        this.f15003q = view.findViewById(C0349R.id.favorite_play);
        this.f15004r = (TextView) view.findViewById(C0349R.id.recent_add_count);
        this.f15005s = (TextView) view.findViewById(C0349R.id.recent_play_count);
        this.f15006t = (TextView) view.findViewById(C0349R.id.favorite_count);
        m23406a(context);
    }

    private void m23406a(Context context) {
        int dimension = (int) context.getResources().getDimension(C0349R.dimen.common_dimens_15dp);
        int dimension2 = (int) context.getResources().getDimension(C0349R.dimen.common_dimens_15dp);
        int c = fbb.m18762c(context);
        int d = fbb.m18764d(context);
        if (c >= d) {
            c = d;
        }
        c = (c - dimension) - dimension2;
        d = (int) (((float) c) * 0.29f);
        dimension = (int) (((float) d) * 1.31f);
        c = (c - (d * 3)) / 2;
        gyn.m23213b(this.f15000m, d);
        gyn.m23224c(this.f15000m, dimension);
        gyn.m23213b(this.f14999l, d);
        gyn.m23224c(this.f14999l, dimension);
        gyn.m23213b(this.f14998k, d);
        gyn.m23224c(this.f14998k, dimension);
        gyn.m23231d(this.f14999l, c);
        gyn.m23239f(this.f14999l, c);
    }

    public void mo2564a(gjc com_ushareit_listenit_gjc, int i) {
        this.f15007u = (gjd) com_ushareit_listenit_gjc;
        this.f15004r.setText(String.valueOf(this.f15007u.m22061a()));
        this.f15005s.setText(String.valueOf(this.f15007u.m22063c()));
        this.f15006t.setText(String.valueOf(this.f15007u.m22065d()));
        this.f15001n.setOnClickListener(this.f15008v);
        this.f15002p.setOnClickListener(this.f15009w);
        this.f15003q.setOnClickListener(this.f15010x);
        this.f14998k.setOnClickListener(this.f15011y);
        this.f14999l.setOnClickListener(this.f15012z);
        this.f15000m.setOnClickListener(this.f14996A);
        grr.m22621a().m22644a(this.f14997B);
    }

    public void mo2563s() {
        grr.m22621a().m22646b(this.f14997B);
    }
}
