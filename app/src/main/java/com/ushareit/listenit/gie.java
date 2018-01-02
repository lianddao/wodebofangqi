package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.ushareit.listenit.lyrics.TagEditor;

public class gie implements TextWatcher {
    final /* synthetic */ TagEditor f14156a;
    private String f14157b;
    private boolean f14158c = true;
    private int f14159d;

    public gie(TagEditor tagEditor) {
        this.f14156a = tagEditor;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (i2 > 0) {
            this.f14159d = i;
            this.f14158c = false;
            this.f14157b = charSequence.subSequence(i, i + i2).toString();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (i3 > 0) {
            this.f14159d = i;
            this.f14158c = true;
            this.f14157b = charSequence.subSequence(i, i + i3).toString();
        }
    }

    public void afterTextChanged(Editable editable) {
        int i = 0;
        if (TextUtils.isEmpty(this.f14156a.f15819e) || !this.f14156a.f15819e.equals(editable.toString())) {
            int length;
            int a;
            if (this.f14158c) {
                length = this.f14157b.length();
                a = this.f14156a.m24692b(this.f14159d, true);
                while (i < length) {
                    if (this.f14157b.charAt(i) == '\n') {
                        a++;
                        this.f14156a.m24696c(a);
                        this.f14156a.m24688a(a, true);
                        this.f14156a.m24688a(a - 1, true);
                    } else {
                        this.f14156a.m24688a(a, true);
                    }
                    i++;
                }
            } else {
                length = this.f14157b.length();
                int a2 = this.f14156a.m24692b(this.f14159d, true);
                for (a = 0; a < length; a++) {
                    if (this.f14157b.charAt(a) == '\n') {
                        this.f14156a.m24701b(a2 + 1);
                        this.f14156a.m24688a(a2, false);
                    } else {
                        this.f14156a.m24688a(a2, false);
                    }
                }
            }
            this.f14156a.f15819e = editable.toString();
        }
    }
}
