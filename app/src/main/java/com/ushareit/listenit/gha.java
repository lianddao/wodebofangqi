package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.lyrics.LyricEditorActivity;

public class gha implements gop {
    final /* synthetic */ String f14112a;
    final /* synthetic */ LyricEditorActivity f14113b;

    public gha(LyricEditorActivity lyricEditorActivity, String str) {
        this.f14113b = lyricEditorActivity;
        this.f14112a = str;
    }

    public boolean mo2508a(View view) {
        if (this.f14113b.f15844O != null) {
            this.f14113b.f15834E.m24709a(this.f14113b.f15844O);
            fin.m19359e(this.f14113b, this.f14112a);
        }
        this.f14113b.finish();
        return false;
    }

    public boolean mo2509b(View view) {
        this.f14113b.finish();
        return false;
    }
}
