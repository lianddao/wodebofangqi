package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lyrics.LyricEditorActivity;

public class ggx implements OnClickListener {
    final /* synthetic */ LyricEditorActivity f14104a;

    public ggx(LyricEditorActivity lyricEditorActivity) {
        this.f14104a = lyricEditorActivity;
    }

    public void onClick(View view) {
        String i = this.f14104a.m24747t();
        if (!fbb.m18763c(i)) {
            this.f14104a.m24726b(i);
        }
        fin.m19360f(this.f14104a);
    }
}
