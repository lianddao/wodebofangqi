package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lyrics.LyricEditorActivity;
import com.ushareit.listenit.popupview.LyricHelperPopupView;

public class ggz implements OnClickListener {
    final /* synthetic */ LyricEditorActivity f14106a;

    public ggz(LyricEditorActivity lyricEditorActivity) {
        this.f14106a = lyricEditorActivity;
    }

    public void onClick(View view) {
        gyn.m23197a(this.f14106a, new fyi(new LyricHelperPopupView(this.f14106a)));
        this.f14106a.f15856n;
        gyw.m23323b(this.f14106a, this.f14106a.f15834E.getEditText());
        fin.m19362h(this.f14106a);
    }
}
