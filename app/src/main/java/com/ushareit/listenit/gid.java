package com.ushareit.listenit;

import android.text.TextUtils;
import com.ushareit.listenit.lyrics.TagEditor;
import java.util.List;

public class gid implements Runnable {
    final /* synthetic */ List f14154a;
    final /* synthetic */ TagEditor f14155b;

    public gid(TagEditor tagEditor, List list) {
        this.f14155b = tagEditor;
        this.f14154a = list;
    }

    public void run() {
        CharSequence a = this.f14155b.m24683a(0, this.f14154a);
        this.f14155b.setLineTag(0, (String) this.f14155b.f15821g.get(0));
        if (!TextUtils.isEmpty(a)) {
            this.f14155b.f15816b.setText(a);
        }
        this.f14155b.f15816b.requestFocus();
    }
}
