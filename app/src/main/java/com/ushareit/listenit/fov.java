package com.ushareit.listenit;

import android.view.View;
import android.widget.TextView;

class fov {
    TextView f13122a;
    TextView f13123b;
    TextView f13124c;
    final /* synthetic */ fou f13125d;

    public fov(fou com_ushareit_listenit_fou, View view) {
        this.f13125d = com_ushareit_listenit_fou;
        this.f13122a = (TextView) view.findViewById(C0349R.id.song_name);
        this.f13123b = (TextView) view.findViewById(C0349R.id.artist_name);
        this.f13124c = (TextView) view.findViewById(C0349R.id.count);
    }

    public void m20229a(glg com_ushareit_listenit_glg, int i) {
        this.f13122a.setText(com_ushareit_listenit_glg.f14338f);
        this.f13123b.setText(com_ushareit_listenit_glg.f14339g);
        this.f13124c.setText(String.valueOf(i + 1));
    }
}
