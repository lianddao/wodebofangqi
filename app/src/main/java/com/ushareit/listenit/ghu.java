package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.ushareit.listenit.lyrics.LyricView;

public class ghu implements OnItemClickListener {
    final /* synthetic */ OnClickListener f14138a;
    final /* synthetic */ LyricView f14139b;

    public ghu(LyricView lyricView, OnClickListener onClickListener) {
        this.f14139b = lyricView;
        this.f14138a = onClickListener;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f14138a.onClick(view);
    }
}
