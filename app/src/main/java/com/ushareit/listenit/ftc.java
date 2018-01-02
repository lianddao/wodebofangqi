package com.ushareit.listenit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ftc extends hbh {
    private Context f13443k;
    private fsh f13444l;
    private final ftg f13445m;
    private final ftg f13446n;
    private final ftg f13447p;
    private final ftg f13448q;
    private final TextView f13449r;
    private final TextView f13450s;
    private final ImageView f13451t;
    private final ImageView f13452u;
    private final int f13453v;
    private final int f13454w;
    private OnClickListener f13455x = new ftd(this);
    private OnTouchListener f13456y = new fte(this);
    private OnTouchListener f13457z = new ftf(this);

    public static View m20891a(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.stream_video_card, viewGroup, false);
    }

    public ftc(Context context, View view) {
        super(context, view);
        this.f13443k = context;
        this.f13453v = (int) ((((double) gyr.m23306a()) * 315.0d) / 720.0d);
        this.f13454w = (int) ((((double) this.f13453v) * 180.0d) / 322.0d);
        this.f13449r = (TextView) view.findViewById(C0349R.id.card_name);
        this.f13450s = (TextView) view.findViewById(C0349R.id.go_to_list_text);
        this.f13451t = (ImageView) view.findViewById(C0349R.id.go_to_list_arrow);
        this.f13452u = (ImageView) view.findViewById(C0349R.id.arrow_button);
        View findViewById = view.findViewById(C0349R.id.title_bar);
        View findViewById2 = view.findViewById(C0349R.id.first);
        View findViewById3 = view.findViewById(C0349R.id.second);
        View findViewById4 = view.findViewById(C0349R.id.third);
        View findViewById5 = view.findViewById(C0349R.id.fourth);
        View findViewById6 = view.findViewById(C0349R.id.go_to_list);
        this.f13445m = new ftg(this, findViewById2, 0);
        this.f13446n = new ftg(this, findViewById3, 1);
        this.f13447p = new ftg(this, findViewById4, 2);
        this.f13448q = new ftg(this, findViewById5, 3);
        findViewById.setOnClickListener(this.f13455x);
        findViewById6.setOnClickListener(this.f13455x);
        findViewById6.setOnTouchListener(this.f13456y);
        this.f13452u.setOnTouchListener(this.f13457z);
    }

    public void mo2564a(gjc com_ushareit_listenit_gjc, int i) {
        this.f13444l = (fsh) com_ushareit_listenit_gjc;
        this.f13449r.setText(this.f13444l.b);
        List list = this.f13444l.f13361d;
        if (list.size() > 3) {
            this.f13445m.m20901a((fsi) list.get(0));
            this.f13446n.m20901a((fsi) list.get(1));
            this.f13447p.m20901a((fsi) list.get(2));
            this.f13448q.m20901a((fsi) list.get(3));
        }
    }

    public void mo2563s() {
    }
}
