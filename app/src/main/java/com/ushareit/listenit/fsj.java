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

public class fsj extends hbh {
    private Context f13372k;
    private fsd f13373l;
    private final TextView f13374m;
    private final fsn f13375n;
    private final fsn f13376p;
    private final fsn f13377q;
    private final int f13378r;
    private final TextView f13379s;
    private final ImageView f13380t;
    private final ImageView f13381u;
    private OnClickListener f13382v = new fsk(this);
    private OnTouchListener f13383w = new fsl(this);
    private OnTouchListener f13384x = new fsm(this);

    public static View m20801a(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.sound_cloud_card, viewGroup, false);
    }

    public fsj(Context context, View view) {
        super(context, view);
        this.f13372k = context;
        this.f13378r = ((gyr.m23306a() - gyr.m23307a(30.0f)) * 7) / 22;
        this.f13374m = (TextView) view.findViewById(C0349R.id.card_name);
        this.f13379s = (TextView) view.findViewById(C0349R.id.go_to_list_text);
        this.f13380t = (ImageView) view.findViewById(C0349R.id.go_to_list_arrow);
        this.f13381u = (ImageView) view.findViewById(C0349R.id.arrow_button);
        View findViewById = view.findViewById(C0349R.id.title_bar);
        View findViewById2 = view.findViewById(C0349R.id.first);
        View findViewById3 = view.findViewById(C0349R.id.second);
        View findViewById4 = view.findViewById(C0349R.id.third);
        View findViewById5 = view.findViewById(C0349R.id.go_to_list);
        this.f13375n = new fsn(this, findViewById2, 0);
        this.f13376p = new fsn(this, findViewById3, 1);
        this.f13377q = new fsn(this, findViewById4, 2);
        findViewById.setOnClickListener(this.f13382v);
        findViewById5.setOnClickListener(this.f13382v);
        findViewById5.setOnTouchListener(this.f13383w);
        this.f13381u.setOnTouchListener(this.f13384x);
    }

    public void mo2564a(gjc com_ushareit_listenit_gjc, int i) {
        this.f13373l = (fsd) com_ushareit_listenit_gjc;
        this.f13374m.setText(this.f13373l.b);
        List list = this.f13373l.f13341d;
        if (list.size() > 2) {
            this.f13375n.m20810a((fse) list.get(0), i);
            this.f13376p.m20810a((fse) list.get(1), i);
            this.f13377q.m20810a((fse) list.get(2), i);
        }
    }

    public void mo2563s() {
    }
}
