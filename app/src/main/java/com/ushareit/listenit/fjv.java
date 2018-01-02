package com.ushareit.listenit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public abstract class fjv implements OnItemClickListener {
    public abstract void mo2724a(AdapterView<?> adapterView, View view, int i, long j);

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!fjx.m19569a(view)) {
            mo2724a(adapterView, view, i, j);
        }
    }
}
