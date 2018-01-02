package com.ushareit.listenit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class fst extends hbh {
    private Context f13416k;
    private fsf f13417l;
    private final TextView f13418m;
    private final fsv f13419n;
    private final fsv f13420p;
    private final fsv f13421q;
    private final int f13422r;
    private OnClickListener f13423s = new fsu(this);

    public static View m20871a(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.sound_cloud_card, viewGroup, false);
    }

    public fst(Context context, View view) {
        super(context, view);
        this.f13416k = context;
        this.f13422r = ((gyr.m23306a() - gyr.m23307a(30.0f)) * 7) / 22;
        View findViewById = view.findViewById(C0349R.id.title_bar);
        this.f13418m = (TextView) view.findViewById(C0349R.id.card_name);
        View findViewById2 = view.findViewById(C0349R.id.first);
        View findViewById3 = view.findViewById(C0349R.id.second);
        View findViewById4 = view.findViewById(C0349R.id.third);
        this.f13419n = new fsv(this, findViewById2, 0);
        this.f13420p = new fsv(this, findViewById3, 1);
        this.f13421q = new fsv(this, findViewById4, 2);
        findViewById2 = view.findViewById(C0349R.id.go_to_list);
        findViewById.setOnClickListener(this.f13423s);
        findViewById2.setOnClickListener(this.f13423s);
    }

    public void mo2564a(gjc com_ushareit_listenit_gjc, int i) {
        this.f13417l = (fsf) com_ushareit_listenit_gjc;
        this.f13418m.setText(this.f13417l.b);
        List list = this.f13417l.f13354d;
        if (list.size() > 2) {
            this.f13419n.m20877a((fsg) list.get(0), i);
            this.f13420p.m20877a((fsg) list.get(1), i);
            this.f13421q.m20877a((fsg) list.get(2), i);
        }
    }

    public void mo2563s() {
    }
}
