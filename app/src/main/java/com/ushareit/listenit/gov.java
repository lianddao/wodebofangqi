package com.ushareit.listenit;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.ushareit.listenit.popupview.EditID3TagPopupView;

public class gov implements OnEditorActionListener {
    final /* synthetic */ EditID3TagPopupView f14517a;

    public gov(EditID3TagPopupView editID3TagPopupView) {
        this.f14517a = editID3TagPopupView;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        exw.m18454c("ime", i + "");
        if (i != 6) {
            return false;
        }
        this.f14517a.m25569a(this.f14517a.f16163c);
        return true;
    }
}
