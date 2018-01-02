package com.ushareit.listenit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.mopub.nativeads.MoPubAdAdapter;

public class emm implements OnItemClickListener {
    final /* synthetic */ OnItemClickListener f11262a;
    final /* synthetic */ MoPubAdAdapter f11263b;

    public emm(MoPubAdAdapter moPubAdAdapter, OnItemClickListener onItemClickListener) {
        this.f11263b = moPubAdAdapter;
        this.f11262a = onItemClickListener;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.f11263b.f2640c.isAd(i)) {
            this.f11262a.onItemClick(adapterView, view, this.f11263b.f2640c.getOriginalPosition(i), j);
        }
    }
}
