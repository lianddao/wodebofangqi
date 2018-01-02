package com.ushareit.listenit;

import android.text.InputFilter;
import android.text.Spanned;
import com.ushareit.listenit.lyrics.TagEditor;
import java.util.List;

public class gif implements InputFilter {
    final /* synthetic */ TagEditor f14160a;

    public gif(TagEditor tagEditor) {
        this.f14160a = tagEditor;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        exw.m18443a("TagEditor", "source=" + charSequence + ", start=" + i + ", end=" + i2 + ", dstStat=" + i3 + ", dend=" + i4);
        if (this.f14160a.f15820f == null || charSequence.length() <= 10) {
            return charSequence;
        }
        List a = this.f14160a.f15820f.mo2678a(charSequence);
        if (a == null || a.size() <= 0) {
            return charSequence;
        }
        return this.f14160a.m24683a(i3, a);
    }
}
