package com.ushareit.listenit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class gzn extends hbh {
    private TextView f14975k;
    private TextView f14976l;
    private View f14977m;
    private Context f14978n;
    private TextView f14979p;
    private gjb f14980q;
    private OnClickListener f14981r = new gzo(this);
    private gry f14982s = new gzp(this);

    public static View m23390a(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C0349R.layout.main_card_all_songs, viewGroup, false);
    }

    public gzn(Context context, View view) {
        super(context, view);
        this.f14978n = context;
        this.f14975k = (TextView) view.findViewById(C0349R.id.song_count);
        this.f14976l = (TextView) view.findViewById(C0349R.id.new_song_count);
        this.f14977m = view.findViewById(C0349R.id.play);
        this.f14979p = (TextView) view.findViewById(C0349R.id.remove_duplicate_songs);
    }

    public void mo2564a(gjc com_ushareit_listenit_gjc, int i) {
        this.f14980q = (gjb) com_ushareit_listenit_gjc;
        int a = this.f14980q.m22059a();
        this.f14975k.setText(this.f14978n.getResources().getString(C0349R.string.main_fragment_song_count, new Object[]{Integer.valueOf(a)}));
        if (gyo.m23264a().m23270b(this.f14978n)) {
            this.f14976l.setText(this.f14978n.getString(C0349R.string.main_fragment_new_song_count, new Object[]{Integer.valueOf(gyo.m23264a().m23268b())}));
            this.f14976l.setVisibility(0);
        } else {
            this.f14976l.setVisibility(8);
        }
        if (gvj.m22883V(this.f14978n) > 0) {
            this.f14979p.setVisibility(0);
            this.f14979p.setText(this.f14978n.getString(C0349R.string.main_fragment_remove_duplicate_songs, new Object[]{Integer.valueOf(a)}));
        } else {
            this.f14979p.setVisibility(8);
        }
        this.f14977m.setOnClickListener(this.f14981r);
        grr.m22621a().m22644a(this.f14982s);
    }

    public void mo2563s() {
        grr.m22621a().m22646b(this.f14982s);
    }
}
