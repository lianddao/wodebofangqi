package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lyrics.LyricEditorActivity;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class ggv implements OnClickListener {
    final /* synthetic */ LyricEditorActivity f14102a;

    public ggv(LyricEditorActivity lyricEditorActivity) {
        this.f14102a = lyricEditorActivity;
    }

    public void onClick(View view) {
        if (this.f14102a.f15856n.m23325a()) {
            this.f14102a.f15856n;
            gyw.m23323b(this.f14102a, this.f14102a.f15834E.getEditText());
        }
        BasePopupView confirmPopupView = new ConfirmPopupView(this.f14102a);
        confirmPopupView.m25556d().setContent(this.f14102a.getString(C0349R.string.lyric_delete_content));
        confirmPopupView.setConfirmListener(new ggw(this));
        gyn.m23197a(this.f14102a, new fyi(confirmPopupView));
    }
}
