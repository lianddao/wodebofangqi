package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hcy implements OnClickListener {
    final /* synthetic */ NormalPlayerView f15197a;

    public hcy(NormalPlayerView normalPlayerView) {
        this.f15197a = normalPlayerView;
    }

    public void onClick(View view) {
        if (!this.f15197a.f17296F) {
            this.f15197a.m26934i();
        }
        this.f15197a.f17296F = false;
    }
}
