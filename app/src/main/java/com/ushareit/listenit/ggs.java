package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lyrics.LyricEditorActivity;

public class ggs implements OnClickListener {
    final /* synthetic */ LyricEditorActivity f14099a;

    public ggs(LyricEditorActivity lyricEditorActivity) {
        this.f14099a = lyricEditorActivity;
    }

    public void onClick(View view) {
        if (this.f14099a.f15856n.m23325a()) {
            this.f14099a.f15856n;
            gyw.m23323b(this.f14099a, this.f14099a.f15834E.getEditText());
            return;
        }
        this.f14099a.f15856n;
        gyw.m23321a(this.f14099a, this.f14099a.f15834E.getEditText());
    }
}
