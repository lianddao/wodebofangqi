package com.ushareit.listenit;

import com.ushareit.listenit.widget.MainActionBar;

public class hbz implements Runnable {
    final /* synthetic */ int f15168a;
    final /* synthetic */ MainActionBar f15169b;

    public hbz(MainActionBar mainActionBar, int i) {
        this.f15169b = mainActionBar;
        this.f15168a = i;
    }

    public void run() {
        if (fqo.m20421c()) {
            this.f15169b.f17266l.setVisibility(8);
            this.f15169b.f17259e.setVisibility(0);
            this.f15169b.f17260f.setVisibility(0);
            this.f15169b.f17259e.setOnClickListener(this.f15169b.f17268n);
            this.f15169b.f17260f.setOnClickListener(this.f15169b.f17269o);
            this.f15169b.f17265k.setVisibility(8);
        } else {
            this.f15169b.f17259e.setVisibility(8);
            this.f15169b.f17260f.setVisibility(8);
            this.f15169b.f17266l.setVisibility(0);
        }
        this.f15169b.m26871b(this.f15168a);
    }
}
